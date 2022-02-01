package com.tencent.component.network.downloader.impl.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class QzoneResumeTransfer
  implements ResumeTransfer
{
  private FileCacheService mCache;
  private Map<String, QzoneResumeTransfer.CacheFileAttribute> mCacheAttributes = new ConcurrentHashMap();
  private boolean mCheckContentType = false;
  private Context mContext;
  private List<String> mDomainCacheList = Collections.synchronizedList(new ArrayList());
  public Map<String, Pattern> mDominPatterns = new HashMap();
  public boolean mForceEnable = false;
  private final Object mLock = new Object();
  private String mName;
  private SharedPreferences mSharePre;
  private String[] mSupportDomains = { "a[0-9].qpic.cn", "m.qpic.cn", ".*qzonestyle.gtimg.cn", ".*qzs.qq.com", ".*i.gtimg.cn", "a\\d+.photo.store.qq.com", "b\\d+.photo.store.qq.com", "vqzone.tc.qq.com", "vwecam.tc.qq.com" };
  private UrlKeyGenerator mUrlKeyGenerator;
  
  public QzoneResumeTransfer(Context paramContext, String paramString, FileCacheService paramFileCacheService, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mName = paramString;
    this.mCache = paramFileCacheService;
    this.mCheckContentType = paramBoolean;
    initUrlPatterns();
    if (this.mCheckContentType)
    {
      paramString = new StringBuilder();
      paramString.append("qzone_download_resume_");
      paramString.append(getProcessName(this.mContext));
      this.mSharePre = paramContext.getSharedPreferences(paramString.toString(), 0);
      loadConfig();
    }
  }
  
  private boolean checkContentRange(String paramString, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if ((paramHttpResponse == null) || (paramHttpResponse.getStatusLine() == null) || (paramHttpResponse.getStatusLine().getStatusCode() != 206))
    {
      if (paramResponse == null) {
        break label257;
      }
      if (paramResponse.code() != 206) {
        return true;
      }
    }
    long l4 = 0L;
    Object localObject1;
    if (paramHttpResponse != null)
    {
      localObject1 = paramHttpResponse.getEntity();
      if (localObject1 != null)
      {
        l1 = ((HttpEntity)localObject1).getContentLength();
        break label113;
      }
    }
    else if (paramResponse != null)
    {
      localObject1 = paramResponse.body();
      if (localObject1 != null) {
        try
        {
          l1 = ((ResponseBody)localObject1).contentLength();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    long l1 = 0L;
    label113:
    Object localObject2 = null;
    if (paramHttpResponse != null)
    {
      paramResponse = paramHttpResponse.getFirstHeader("Content-Range");
      paramHttpResponse = localObject2;
      if (paramResponse != null) {
        paramHttpResponse = paramResponse.getValue();
      }
    }
    else
    {
      paramHttpResponse = localObject2;
      if (paramResponse != null) {
        paramHttpResponse = paramResponse.header("Content-Range");
      }
    }
    int i;
    if (!TextUtils.isEmpty(paramHttpResponse)) {
      i = paramHttpResponse.indexOf("/");
    }
    try
    {
      i = Integer.valueOf(paramHttpResponse.substring(i + 1)).intValue();
      l2 = i;
    }
    catch (Exception paramHttpResponse)
    {
      long l2;
      label199:
      long l3;
      break label199;
    }
    l2 = 0L;
    paramString = getTmpCacheFileName(paramString);
    paramString = this.mCache.getFile(paramString);
    l3 = l4;
    if (paramString != null)
    {
      l3 = l4;
      if (paramString.exists()) {
        l3 = paramString.length();
      }
    }
    return l3 + l1 == l2;
    label257:
    return true;
  }
  
  private String getProcessName(Context paramContext)
  {
    try
    {
      String str = Utils.getCurrentProcessName(paramContext);
      paramContext = str;
      if (str != null)
      {
        paramContext = str;
        if (str.contains(":"))
        {
          int i = str.lastIndexOf(":");
          paramContext = str;
          if (i > 0) {
            paramContext = str.substring(i + 1);
          }
        }
      }
      boolean bool = TextUtils.isEmpty(paramContext);
      if (!bool) {
        return paramContext;
      }
      return "";
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  private String getTmpCacheFileName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.mUrlKeyGenerator;
    if (localObject == null) {
      localObject = paramString;
    } else {
      localObject = ((UrlKeyGenerator)localObject).doGenerate(paramString);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = (String)localObject;
    }
    return String.valueOf(paramString.hashCode());
  }
  
  private QzoneResumeTransfer.CacheFileAttribute getTmpFileAttr(String paramString)
  {
    paramString = getTmpCacheFileName(paramString);
    if (paramString == null) {
      return null;
    }
    return (QzoneResumeTransfer.CacheFileAttribute)this.mCacheAttributes.get(paramString);
  }
  
  private String getTmpFileContentType(String paramString)
  {
    paramString = getTmpCacheFileName(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = (QzoneResumeTransfer.CacheFileAttribute)this.mCacheAttributes.get(paramString);
    if (paramString != null) {
      return paramString.ContentType;
    }
    return null;
  }
  
  private void initUrlPatterns()
  {
    this.mDominPatterns.clear();
    int i = 0;
    for (;;)
    {
      Object localObject = this.mSupportDomains;
      if (i >= localObject.length) {
        break;
      }
      localObject = Pattern.compile(localObject[i], 2);
      this.mDominPatterns.put(this.mSupportDomains[i], localObject);
      i += 1;
    }
  }
  
  private boolean isCacheFileVaild(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      long l = paramFile.lastModified();
      l = System.currentTimeMillis() - l;
      if ((l >= 0L) && (l <= 86400000L)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private void loadConfig()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mSharePre	Landroid/content/SharedPreferences;
    //   4: astore_3
    //   5: new 96	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   12: astore_1
    //   13: aload_1
    //   14: ldc_w 294
    //   17: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 89	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mName	Ljava/lang/String;
    //   26: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 4
    //   36: aconst_null
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_3
    //   41: aload 4
    //   43: aconst_null
    //   44: invokeinterface 300 3 0
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +91 -> 142
    //   54: aload_3
    //   55: iconst_0
    //   56: invokestatic 306	com/tencent/component/network/utils/Base64:decode	(Ljava/lang/String;I)[B
    //   59: invokestatic 310	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   62: astore_3
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 45	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mCacheAttributes	Ljava/util/Map;
    //   71: invokeinterface 270 1 0
    //   76: aload_3
    //   77: astore_2
    //   78: aload_3
    //   79: astore_1
    //   80: aload_3
    //   81: aload_0
    //   82: getfield 45	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mCacheAttributes	Ljava/util/Map;
    //   85: aload_0
    //   86: getfield 87	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mContext	Landroid/content/Context;
    //   89: invokevirtual 314	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   92: invokevirtual 320	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   95: aload_3
    //   96: ifnull +46 -> 142
    //   99: aload_3
    //   100: astore_1
    //   101: goto +24 -> 125
    //   104: astore_1
    //   105: goto +27 -> 132
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: ldc_w 322
    //   114: ldc_w 322
    //   117: aload_3
    //   118: invokestatic 328	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_1
    //   122: ifnull +20 -> 142
    //   125: aload_1
    //   126: invokevirtual 331	android/os/Parcel:recycle	()V
    //   129: goto +13 -> 142
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 331	android/os/Parcel:recycle	()V
    //   140: aload_1
    //   141: athrow
    //   142: aload_0
    //   143: getfield 45	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mCacheAttributes	Ljava/util/Map;
    //   146: ifnonnull +14 -> 160
    //   149: aload_0
    //   150: new 49	java/util/HashMap
    //   153: dup
    //   154: invokespecial 50	java/util/HashMap:<init>	()V
    //   157: putfield 45	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mCacheAttributes	Ljava/util/Map;
    //   160: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	QzoneResumeTransfer
    //   12	89	1	localObject1	Object
    //   104	37	1	localObject2	Object
    //   39	98	2	localObject3	Object
    //   4	96	3	localObject4	Object
    //   108	10	3	localThrowable	Throwable
    //   34	8	4	str	String
    // Exception table:
    //   from	to	target	type
    //   54	63	104	finally
    //   67	76	104	finally
    //   80	95	104	finally
    //   111	121	104	finally
    //   54	63	108	java/lang/Throwable
    //   67	76	108	java/lang/Throwable
    //   80	95	108	java/lang/Throwable
  }
  
  private QzoneResumeTransfer.CacheFileAttribute parseAttrs(HttpResponse paramHttpResponse, Response paramResponse)
  {
    Object localObject1 = null;
    Header localHeader = null;
    Object localObject2 = null;
    if ((paramHttpResponse == null) && (paramResponse == null)) {
      return null;
    }
    if (paramHttpResponse != null)
    {
      paramResponse = paramHttpResponse.getEntity();
      if (paramResponse != null)
      {
        paramResponse = paramResponse.getContentType();
        if (paramResponse != null)
        {
          paramResponse = paramResponse.getValue();
          break label56;
        }
      }
      paramResponse = null;
      label56:
      localObject1 = paramHttpResponse.getFirstHeader("Last-Modified");
      if (localObject1 != null) {
        localObject1 = ((Header)localObject1).getValue();
      } else {
        localObject1 = null;
      }
      localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
      paramHttpResponse = (HttpResponse)localObject2;
      if (localHeader != null) {
        paramHttpResponse = localHeader.getValue();
      }
      localObject2 = paramHttpResponse;
      paramHttpResponse = paramResponse;
      paramResponse = (Response)localObject1;
      localObject1 = localObject2;
    }
    else if (paramResponse != null)
    {
      localObject2 = paramResponse.body();
      paramHttpResponse = (HttpResponse)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((ResponseBody)localObject2).contentType();
        paramHttpResponse = (HttpResponse)localObject1;
        if (localObject2 != null) {
          paramHttpResponse = ((MediaType)localObject2).toString();
        }
      }
      localObject1 = paramResponse.header("Last-Modified");
      localObject2 = paramResponse.header("Content-Encoding");
      paramResponse = (Response)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      paramResponse = null;
      localObject1 = paramResponse;
      paramHttpResponse = localHeader;
    }
    return new QzoneResumeTransfer.CacheFileAttribute(paramHttpResponse, paramResponse, (String)localObject1);
  }
  
  /* Error */
  private void saveConfig()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 356	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: astore_1
    //   12: aload_3
    //   13: aload_0
    //   14: getfield 45	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mCacheAttributes	Ljava/util/Map;
    //   17: invokevirtual 360	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: astore_1
    //   24: new 65	java/lang/String
    //   27: dup
    //   28: aload_3
    //   29: invokevirtual 364	android/os/Parcel:marshall	()[B
    //   32: iconst_0
    //   33: invokestatic 368	com/tencent/component/network/utils/Base64:encode	([BI)[B
    //   36: invokespecial 371	java/lang/String:<init>	([B)V
    //   39: astore 4
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 119	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mSharePre	Landroid/content/SharedPreferences;
    //   49: invokeinterface 375 1 0
    //   54: astore 5
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: astore_1
    //   60: new 96	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   67: astore 6
    //   69: aload_3
    //   70: astore_2
    //   71: aload_3
    //   72: astore_1
    //   73: aload 6
    //   75: ldc_w 294
    //   78: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: astore_2
    //   84: aload_3
    //   85: astore_1
    //   86: aload 6
    //   88: aload_0
    //   89: getfield 89	com/tencent/component/network/downloader/impl/strategy/QzoneResumeTransfer:mName	Ljava/lang/String;
    //   92: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: astore_2
    //   98: aload_3
    //   99: astore_1
    //   100: aload 5
    //   102: aload 6
    //   104: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload 4
    //   109: invokeinterface 381 3 0
    //   114: invokeinterface 384 1 0
    //   119: pop
    //   120: aload_3
    //   121: ifnull +33 -> 154
    //   124: aload_3
    //   125: astore_1
    //   126: goto +24 -> 150
    //   129: astore_1
    //   130: goto +25 -> 155
    //   133: astore_3
    //   134: aload_1
    //   135: astore_2
    //   136: ldc_w 386
    //   139: ldc_w 387
    //   142: aload_3
    //   143: invokestatic 390	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 331	android/os/Parcel:recycle	()V
    //   154: return
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 331	android/os/Parcel:recycle	()V
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	QzoneResumeTransfer
    //   1	125	1	localObject1	Object
    //   129	35	1	localObject2	Object
    //   3	157	2	localObject3	Object
    //   7	118	3	localParcel	android.os.Parcel
    //   133	10	3	localException	Exception
    //   39	69	4	str	String
    //   54	47	5	localEditor	android.content.SharedPreferences.Editor
    //   67	36	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	8	129	finally
    //   12	20	129	finally
    //   24	41	129	finally
    //   45	56	129	finally
    //   60	69	129	finally
    //   73	82	129	finally
    //   86	96	129	finally
    //   100	120	129	finally
    //   136	146	129	finally
    //   4	8	133	java/lang/Exception
    //   12	20	133	java/lang/Exception
    //   24	41	133	java/lang/Exception
    //   45	56	133	java/lang/Exception
    //   60	69	133	java/lang/Exception
    //   73	82	133	java/lang/Exception
    //   86	96	133	java/lang/Exception
    //   100	120	133	java/lang/Exception
  }
  
  private boolean supportResumeDownload(String paramString1, String paramString2)
  {
    if (this.mForceEnable) {
      return true;
    }
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (this.mDomainCacheList.contains(paramString2)) {
        return true;
      }
      paramString1 = this.mDominPatterns.entrySet().iterator();
      do
      {
        bool1 = bool2;
        if (!paramString1.hasNext()) {
          break;
        }
      } while (!Utils.match((Pattern)((Map.Entry)paramString1.next()).getValue(), paramString2));
      this.mDomainCacheList.add(paramString2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void addCacheTmpFile(String paramString1, String arg2, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(???)) {
        return;
      }
      ??? = new File(???);
      if (???.exists())
      {
        if (???.length() <= 0L) {
          return;
        }
        if ((this.mCache.putFile(getTmpCacheFileName(paramString1))) && (this.mCheckContentType) && ((paramHttpResponse != null) || (paramResponse != null)))
        {
          paramHttpResponse = parseAttrs(paramHttpResponse, paramResponse);
          paramResponse = new StringBuilder();
          paramResponse.append("Downloader Resume Response url:");
          paramResponse.append(paramString1);
          paramResponse.append(" curr:");
          if (paramHttpResponse != null) {
            ??? = paramHttpResponse.toString();
          } else {
            ??? = "N/A";
          }
          paramResponse.append(???);
          QDLog.d("downloader", paramResponse.toString());
          if (paramHttpResponse != null) {
            synchronized (this.mLock)
            {
              if (!paramHttpResponse.equals((QzoneResumeTransfer.CacheFileAttribute)this.mCacheAttributes.get(getTmpCacheFileName(paramString1))))
              {
                this.mCacheAttributes.put(getTmpCacheFileName(paramString1), paramHttpResponse);
                saveConfig();
              }
              return;
            }
          }
        }
      }
    }
  }
  
  public void cleanCache()
  {
    this.mCache.clear();
    synchronized (this.mLock)
    {
      this.mCacheAttributes.clear();
      saveConfig();
      return;
    }
  }
  
  public void cleanCache(String arg1)
  {
    String str = getTmpCacheFileName(???);
    this.mCache.deleteFile(str);
    synchronized (this.mLock)
    {
      this.mCacheAttributes.remove(str);
      saveConfig();
      return;
    }
  }
  
  public String getResumeTmpFile(String paramString)
  {
    paramString = this.mCache.getFile(getTmpCacheFileName(paramString));
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public boolean handleResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if (this.mCheckContentType)
    {
      if (!supportResumeDownload(paramString1, paramString2)) {
        return true;
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        if ((paramHttpResponse == null) && (paramResponse == null)) {
          return false;
        }
        if (!checkContentRange(paramString1, paramHttpResponse, paramResponse)) {
          return false;
        }
        QzoneResumeTransfer.CacheFileAttribute localCacheFileAttribute = getTmpFileAttr(paramString1);
        if (localCacheFileAttribute == null) {
          return true;
        }
        paramHttpResponse = parseAttrs(paramHttpResponse, paramResponse);
        if (QDLog.isInfoEnable())
        {
          paramResponse = new StringBuilder();
          paramResponse.append("download content-type check url:");
          paramResponse.append(paramString1);
          paramResponse.append(" old:");
          paramString2 = "N/A";
          if (localCacheFileAttribute != null) {
            paramString1 = localCacheFileAttribute.toString();
          } else {
            paramString1 = "N/A";
          }
          paramResponse.append(paramString1);
          paramResponse.append(" curr:");
          paramString1 = paramString2;
          if (paramHttpResponse != null) {
            paramString1 = paramHttpResponse.toString();
          }
          paramResponse.append(paramString1);
          QDLog.i("downloader", paramResponse.toString());
        }
        if (localCacheFileAttribute.equals(paramHttpResponse)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public void onDownloadResult(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.mCache)
      {
        this.mCache.deleteFile(getTmpCacheFileName(paramString));
        if (this.mCheckContentType) {
          synchronized (this.mLock)
          {
            if (this.mCacheAttributes.containsKey(getTmpCacheFileName(paramString)))
            {
              this.mCacheAttributes.remove(getTmpCacheFileName(paramString));
              saveConfig();
            }
            return;
          }
        }
      }
    }
  }
  
  public void prepareRequest(HttpGet paramHttpGet, Request.Builder paramBuilder, String paramString1, String paramString2)
  {
    if (!supportResumeDownload(paramString1, paramString2)) {
      return;
    }
    paramString2 = getTmpCacheFileName(paramString1);
    File localFile = this.mCache.getFile(paramString2);
    long l;
    if ((localFile != null) && (localFile.exists()))
    {
      if (isCacheFileVaild(localFile)) {
        l = localFile.length();
      } else {
        this.mCache.deleteFile(paramString2);
      }
    }
    else {
      l = 0L;
    }
    paramString2 = getTmpFileContentType(paramString1);
    if (l > 0L) {
      if (!this.mCheckContentType)
      {
        if (paramHttpGet != null)
        {
          paramBuilder = new StringBuilder();
          paramBuilder.append("bytes=");
          paramBuilder.append(l);
          paramBuilder.append("-");
          paramHttpGet.addHeader("Range", paramBuilder.toString());
        }
        else if (paramBuilder != null)
        {
          paramHttpGet = new StringBuilder();
          paramHttpGet.append("bytes=");
          paramHttpGet.append(l);
          paramHttpGet.append("-");
          paramBuilder.addHeader("Range", paramHttpGet.toString());
        }
      }
      else if (!TextUtils.isEmpty(paramString2)) {
        if (paramHttpGet != null)
        {
          paramBuilder = new StringBuilder();
          paramBuilder.append("bytes=");
          paramBuilder.append(l);
          paramBuilder.append("-");
          paramHttpGet.addHeader("Range", paramBuilder.toString());
          paramHttpGet.addHeader("Accept", paramString2);
          paramHttpGet.addHeader("Q-Accept", paramString2);
        }
        else if (paramBuilder != null)
        {
          paramHttpGet = new StringBuilder();
          paramHttpGet.append("bytes=");
          paramHttpGet.append(l);
          paramHttpGet.append("-");
          paramBuilder.addHeader("Range", paramHttpGet.toString());
          paramBuilder.addHeader("Accept", paramString2);
          paramBuilder.addHeader("Q-Accept", paramString2);
        }
      }
    }
    paramHttpGet = new StringBuilder();
    paramHttpGet.append("Downloader Resume --- begin range:");
    paramHttpGet.append(l);
    paramHttpGet.append(" Accept:");
    paramHttpGet.append(paramString2);
    paramHttpGet.append(" url:");
    paramHttpGet.append(paramString1);
    QDLog.i("downloader", paramHttpGet.toString());
  }
  
  public void setSupportDomains(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length <= 0) {
        return;
      }
      if (!paramBoolean)
      {
        this.mSupportDomains = paramArrayOfString;
      }
      else
      {
        int j = this.mSupportDomains.length + paramArrayOfString.length;
        String[] arrayOfString1 = new String[j];
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = this.mSupportDomains;
          if (i < arrayOfString2.length) {
            arrayOfString1[i] = arrayOfString2[i];
          } else {
            arrayOfString1[i] = paramArrayOfString[(i - arrayOfString2.length)];
          }
          i += 1;
        }
        this.mSupportDomains = arrayOfString1;
      }
      initUrlPatterns();
    }
  }
  
  public void setUrlKeyGenerator(UrlKeyGenerator paramUrlKeyGenerator)
  {
    this.mUrlKeyGenerator = paramUrlKeyGenerator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer
 * JD-Core Version:    0.7.0.1
 */