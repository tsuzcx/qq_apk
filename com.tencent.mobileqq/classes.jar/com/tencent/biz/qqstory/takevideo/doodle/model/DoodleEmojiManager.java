package com.tencent.biz.qqstory.takevideo.doodle.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.biz.qqstory.network.request.GetEmojiPackInfoListRequest;
import com.tencent.biz.qqstory.network.request.GetPoiFacesRequest;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse.EmojiPack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import onc;
import ond;
import one;
import onf;
import ong;
import onh;
import oni;
import onj;

@TargetApi(9)
public class DoodleEmojiManager
  implements IManager
{
  public static final String a;
  public final int a;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private LocationListener jdField_a_of_type_AndroidLocationLocationListener = new onf(this);
  public DoodleEmojiItem a;
  public final Object a;
  public final List a;
  public final Queue a;
  public final ConcurrentHashMap a;
  public AtomicBoolean a;
  public volatile AtomicInteger a;
  public final Object b;
  public String b;
  public List b;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQStoryConstant.e + "emoji";
    a(jdField_a_of_type_JavaLangString);
  }
  
  public DoodleEmojiManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangObject = new Object[0];
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 50;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().a();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 0);
  }
  
  private static GetEmojiPackInfoListResponse a()
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte = FileUtils.b(new File(jdField_a_of_type_JavaLangString + "/" + "list.pb"));
      if (arrayOfByte != null) {
        i = arrayOfByte.length;
      }
      SLog.a("DoodleEmojiManager", "restoreFilterItemListLocked file length = %d", Integer.valueOf(i));
      if (arrayOfByte == null) {
        return null;
      }
      Object localObject = new ObjectInputStream(new ByteArrayInputStream(arrayOfByte));
      i = ((ObjectInputStream)localObject).readInt();
      if (i == 18)
      {
        long l = ((ObjectInputStream)localObject).readLong();
        arrayOfByte = new byte[((ObjectInputStream)localObject).readInt()];
        ((ObjectInputStream)localObject).readFully(arrayOfByte);
        localObject = new qqstory_service.RspGetEmoticonPackList();
        try
        {
          ((qqstory_service.RspGetEmoticonPackList)localObject).mergeFrom(arrayOfByte);
          return new GetEmojiPackInfoListResponse((qqstory_service.RspGetEmoticonPackList)localObject, arrayOfByte, l);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          SLog.e("DoodleEmojiManager", "restoreResponseFromFile error : " + localInvalidProtocolBufferMicroException);
          return null;
        }
      }
      return null;
    }
    catch (IOException localIOException)
    {
      SLog.d("DoodleEmojiManager", "restoreResponseFromFile failed FileNotFoundException");
      return null;
      SLog.d("DoodleEmojiManager", "restoreResponseFromFile find illegal file with magic code %d", new Object[] { Integer.valueOf(i) });
      return null;
    }
    catch (Exception localException)
    {
      SLog.c("DoodleEmojiManager", "restoreResponseFromFile failed", localException);
    }
  }
  
  public static String a(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_url_" + paramString, "");
  }
  
  private static String a(@NonNull File paramFile)
  {
    return paramFile.getName().substring("emoji_folder_".length());
  }
  
  public static String a(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_zip_" + paramString;
  }
  
  /* Error */
  public static void a(GetEmojiPackInfoListResponse paramGetEmojiPackInfoListResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 27	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   12: getstatic 47	com/tencent/biz/qqstory/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 135
    //   20: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 137
    //   25: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 248	com/tencent/biz/qqstory/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   34: pop
    //   35: getstatic 47	com/tencent/biz/qqstory/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokestatic 50	com/tencent/biz/qqstory/takevideo/doodle/model/DoodleEmojiManager:a	(Ljava/lang/String;)V
    //   41: new 250	java/io/ByteArrayOutputStream
    //   44: dup
    //   45: sipush 8192
    //   48: invokespecial 251	java/io/ByteArrayOutputStream:<init>	(I)V
    //   51: astore_1
    //   52: new 253	java/io/ObjectOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 256	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_2
    //   61: aload_2
    //   62: bipush 18
    //   64: invokevirtual 259	java/io/ObjectOutputStream:writeInt	(I)V
    //   67: aload_2
    //   68: aload_0
    //   69: getfield 261	com/tencent/biz/qqstory/network/response/GetEmojiPackInfoListResponse:jdField_a_of_type_Long	J
    //   72: invokevirtual 265	java/io/ObjectOutputStream:writeLong	(J)V
    //   75: aload_2
    //   76: aload_0
    //   77: getfield 268	com/tencent/biz/qqstory/network/response/GetEmojiPackInfoListResponse:jdField_a_of_type_ArrayOfByte	[B
    //   80: arraylength
    //   81: invokevirtual 259	java/io/ObjectOutputStream:writeInt	(I)V
    //   84: aload_2
    //   85: aload_0
    //   86: getfield 268	com/tencent/biz/qqstory/network/response/GetEmojiPackInfoListResponse:jdField_a_of_type_ArrayOfByte	[B
    //   89: invokevirtual 271	java/io/ObjectOutputStream:write	([B)V
    //   92: aload_2
    //   93: invokevirtual 274	java/io/ObjectOutputStream:flush	()V
    //   96: aload_2
    //   97: invokevirtual 277	java/io/ObjectOutputStream:close	()V
    //   100: new 279	java/io/FileOutputStream
    //   103: dup
    //   104: new 27	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   111: getstatic 47	com/tencent/biz/qqstory/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 135
    //   119: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 137
    //   124: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   133: astore_2
    //   134: aload_1
    //   135: aload_2
    //   136: invokevirtual 283	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   139: aload_1
    //   140: invokevirtual 284	java/io/ByteArrayOutputStream:flush	()V
    //   143: aload_1
    //   144: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   147: aload_2
    //   148: invokevirtual 286	java/io/FileOutputStream:close	()V
    //   151: ldc 145
    //   153: ldc_w 288
    //   156: aload_0
    //   157: getfield 268	com/tencent/biz/qqstory/network/response/GetEmojiPackInfoListResponse:jdField_a_of_type_ArrayOfByte	[B
    //   160: arraylength
    //   161: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: invokestatic 158	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 286	java/io/FileOutputStream:close	()V
    //   183: return
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   189: goto -14 -> 175
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   197: return
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_3
    //   202: astore_1
    //   203: ldc 145
    //   205: ldc_w 293
    //   208: aload_2
    //   209: invokestatic 215	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   220: aload_1
    //   221: ifnull -38 -> 183
    //   224: aload_1
    //   225: invokevirtual 286	java/io/FileOutputStream:close	()V
    //   228: return
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   234: return
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   240: goto -20 -> 220
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_1
    //   246: aload 4
    //   248: astore_2
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 286	java/io/FileOutputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   272: goto -15 -> 257
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   280: goto -15 -> 265
    //   283: astore_0
    //   284: aload 4
    //   286: astore_2
    //   287: goto -38 -> 249
    //   290: astore_0
    //   291: goto -42 -> 249
    //   294: astore_2
    //   295: aload_0
    //   296: astore_3
    //   297: aload_2
    //   298: astore_0
    //   299: aload_1
    //   300: astore_2
    //   301: aload_3
    //   302: astore_1
    //   303: goto -54 -> 249
    //   306: astore_2
    //   307: aload_1
    //   308: astore_0
    //   309: aload_3
    //   310: astore_1
    //   311: goto -108 -> 203
    //   314: astore 4
    //   316: aload_2
    //   317: astore_0
    //   318: aload_1
    //   319: astore_3
    //   320: aload 4
    //   322: astore_2
    //   323: aload_0
    //   324: astore_1
    //   325: aload_3
    //   326: astore_0
    //   327: goto -124 -> 203
    //   330: astore_1
    //   331: goto -296 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramGetEmojiPackInfoListResponse	GetEmojiPackInfoListResponse
    //   51	203	1	localObject1	Object
    //   267	2	1	localIOException1	IOException
    //   275	25	1	localIOException2	IOException
    //   302	23	1	localObject2	Object
    //   330	1	1	localException	Exception
    //   60	120	2	localObject3	Object
    //   198	11	2	localIOException3	IOException
    //   248	39	2	localObject4	Object
    //   294	4	2	localObject5	Object
    //   300	1	2	localIOException4	IOException
    //   306	11	2	localIOException5	IOException
    //   322	1	2	localIOException6	IOException
    //   4	322	3	localObject6	Object
    //   1	284	4	localObject7	Object
    //   314	7	4	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   171	175	184	java/io/IOException
    //   179	183	192	java/io/IOException
    //   5	35	198	java/io/IOException
    //   35	52	198	java/io/IOException
    //   224	228	229	java/io/IOException
    //   216	220	235	java/io/IOException
    //   5	35	243	finally
    //   35	52	243	finally
    //   253	257	267	java/io/IOException
    //   261	265	275	java/io/IOException
    //   52	134	283	finally
    //   134	167	290	finally
    //   203	212	294	finally
    //   52	134	306	java/io/IOException
    //   134	167	314	java/io/IOException
    //   5	35	330	java/lang/Exception
  }
  
  public static void a(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_md5_" + paramString1, paramString2);
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      SLog.d("DoodleEmojiManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      SLog.d("DoodleEmojiManager", "create folder : " + bool);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  private static boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return false;
      paramFile = paramFile.listFiles(new onj());
    } while ((paramFile == null) || (paramFile.length <= 0));
    return true;
  }
  
  public static String b(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_name_" + paramString, "");
  }
  
  public static String b(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_folder_" + paramString;
  }
  
  private static void b(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_url_" + paramString1, paramString2);
  }
  
  public static String c(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_config_" + paramString, "");
  }
  
  private static void c(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_name_" + paramString1, paramString2);
  }
  
  public static String d(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_md5_" + paramString, "");
  }
  
  private static void d(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_config_" + paramString1, paramString2);
  }
  
  private void e()
  {
    long l = 0L;
    SLog.b("DoodleEmojiManager", "fireRequestEmojiPackList, cookie = " + this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      if (this.jdField_a_of_type_Long != 0L) {
        l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      }
      if (l > 5000L) {
        SLog.d("DoodleEmojiManager", "fireRequestEmojiPackList previous requesting is time out, fire another request, past time = %d", new Object[] { Long.valueOf(l) });
      }
    }
    else
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      CmdTaskManger.a().a(new GetEmojiPackInfoListRequest(this.jdField_b_of_type_JavaLangString, 50), new oni(this));
      return;
    }
    SLog.d("DoodleEmojiManager", "fireRequestEmojiPackList now is already requesting, just waiting is ok, requesting past time = %d", new Object[] { Long.valueOf(l) });
  }
  
  public String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
    SLog.b("DoodleEmojiManager", "getStringValue, key : %s, value : %s", paramString1, paramString2);
    return paramString2;
  }
  
  public List a()
  {
    if (!a()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        SLog.d("DoodleEmojiManager", "current emoji packages is null.");
        List localList2 = Collections.EMPTY_LIST;
        return localList2;
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    SLog.c("DoodleEmojiManager", "current emoji packages's size=" + localArrayList.size());
    return localArrayList;
  }
  
  @NonNull
  public List a(boolean paramBoolean)
  {
    if (!a()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        if (!paramBoolean) {
          break label53;
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaLangString = "";
      e();
      label53:
      ??? = new ArrayList();
      ((List)???).addAll(this.jdField_a_of_type_JavaUtilList);
      return ???;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    paramPOIPostersRequestCallback = new WeakReference(paramPOIPostersRequestCallback);
    CmdTaskManger.a().a(new GetPoiFacesRequest(paramInt1, paramInt2), new onh(this, paramPOIPostersRequestCallback));
  }
  
  public void a(Context paramContext)
  {
    SLog.b("DoodleEmojiManager", "initLocalPackages, doodle emoji path : " + jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      paramContext = (DoodleEmojiManager)SuperManager.a(8);
      Object localObject1 = new File(jdField_a_of_type_JavaLangString);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles(new onc(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            File localFile = localObject1[i];
            Object localObject2 = localFile.listFiles(new ond(this));
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              localObject2 = a(localFile);
              Object localObject3 = b(paramContext, (String)localObject2);
              localObject3 = new DoodleEmojiItem((String)localObject2, a(paramContext, (String)localObject2), (String)localObject3, null, c(paramContext, (String)localObject2), d(paramContext, (String)localObject2));
              ((DoodleEmojiItem)localObject3).a(localFile.getPath());
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localObject3);
              SLog.b("DoodleEmojiManager", "load local emoji pack : " + localObject3);
            }
            for (;;)
            {
              i += 1;
              break;
              try
              {
                FileUtils.d(localFile.getPath());
                SLog.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete it");
              }
              catch (Exception localException)
              {
                SLog.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete failed : " + localException);
              }
            }
          }
        }
      }
      else
      {
        SLog.d("DoodleEmojiManager", "local emoji folder is empty");
      }
      paramContext = a();
      if ((paramContext != null) && (paramContext.jdField_a_of_type_Long + 43200000L > System.currentTimeMillis()))
      {
        SLog.c("DoodleEmojiManager", "has valid emoji packages cache. startTime=" + paramContext.jdField_a_of_type_Long + " currentTime=" + System.currentTimeMillis());
        a(true, paramContext, true);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
  }
  
  public void a(BasicLocation paramBasicLocation, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    SLog.b("DoodleEmojiManager", "requestPoiFaces " + paramPOIPostersRequestCallback);
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = paramBasicLocation;
    if (paramBasicLocation == null) {
      localBasicLocation = localLbsManager.b();
    }
    if (localBasicLocation != null)
    {
      a(localBasicLocation.b, localBasicLocation.jdField_a_of_type_Int, paramPOIPostersRequestCallback);
      return;
    }
    localLbsManager.a(new ong(this, paramPOIPostersRequestCallback));
    localLbsManager.c();
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    SLog.b("DoodleEmojiManager", "saveStringValue, key : %s, value : %s", paramString1, paramString2);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public void a(boolean paramBoolean1, @NonNull GetEmojiPackInfoListResponse paramGetEmojiPackInfoListResponse, boolean paramBoolean2)
  {
    DoodleEmojiManager localDoodleEmojiManager = (DoodleEmojiManager)SuperManager.a(8);
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    if (paramBoolean1)
    {
      localArrayList.clear();
      if (!paramBoolean2) {
        a(paramGetEmojiPackInfoListResponse);
      }
    }
    Iterator localIterator = paramGetEmojiPackInfoListResponse.jdField_a_of_type_JavaUtilList.iterator();
    GetEmojiPackInfoListResponse.EmojiPack localEmojiPack;
    DoodleEmojiItem localDoodleEmojiItem;
    if (localIterator.hasNext())
    {
      localEmojiPack = (GetEmojiPackInfoListResponse.EmojiPack)localIterator.next();
      if (localEmojiPack.b != 1) {
        break label476;
      }
      localDoodleEmojiItem = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localEmojiPack.jdField_a_of_type_JavaLangString);
      if (localDoodleEmojiItem == null) {
        break label476;
      }
      ??? = localDoodleEmojiItem.a();
      if (TextUtils.equals(localDoodleEmojiItem.g, localEmojiPack.f)) {
        break label473;
      }
      SLog.a("DoodleEmojiManager", "EmojiPack md5 has changed. old : %s, new : %s", localDoodleEmojiItem.g, localEmojiPack.f);
    }
    for (;;)
    {
      try
      {
        FileUtils.d((String)???);
        ??? = null;
        localDoodleEmojiItem = new DoodleEmojiItem(localEmojiPack);
        localDoodleEmojiItem.a((String)???);
        b(localDoodleEmojiManager, localDoodleEmojiItem.jdField_a_of_type_JavaLangString, localDoodleEmojiItem.jdField_b_of_type_JavaLangString);
        c(localDoodleEmojiManager, localDoodleEmojiItem.jdField_a_of_type_JavaLangString, localDoodleEmojiItem.d);
        d(localDoodleEmojiManager, localDoodleEmojiItem.jdField_a_of_type_JavaLangString, localDoodleEmojiItem.f);
        a(localDoodleEmojiManager, localDoodleEmojiItem.jdField_a_of_type_JavaLangString, localDoodleEmojiItem.g);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEmojiPack.jdField_a_of_type_JavaLangString, localDoodleEmojiItem);
        if (paramBoolean2)
        {
          SLog.a("DoodleEmojiManager", "from local get doodle item : %s", localDoodleEmojiItem);
          localArrayList.remove(localDoodleEmojiItem);
          localArrayList.add(localDoodleEmojiItem);
        }
      }
      catch (Exception localException)
      {
        SLog.d("DoodleEmojiManager", "remove folder : %s failed. error: %s .", new Object[] { ???, localException });
        continue;
        SLog.a("DoodleEmojiManager", "from network get doodle item : %s", localException);
        continue;
      }
      do
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
          Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiUpdateEvent());
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          if ((!paramBoolean2) && (!paramGetEmojiPackInfoListResponse.jdField_a_of_type_Boolean))
          {
            e();
            return;
          }
        }
      } while (localArrayList.size() <= 0);
      SLog.b("DoodleEmojiManager", "start download the first emoji pack if needed : " + ((DoodleEmojiItem)localArrayList.get(0)).jdField_a_of_type_JavaLangString);
      a(((DoodleEmojiItem)localArrayList.get(0)).jdField_a_of_type_JavaLangString, false);
      return;
      label473:
      continue;
      label476:
      ??? = null;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      SLog.d("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) });
    }
    if (paramString == null) {
      throw new IllegalArgumentException("pack id should not be null");
    }
    DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localDoodleEmojiItem == null)
    {
      SLog.d("DoodleEmojiManager", "can not find pack item by id " + paramString);
      return false;
    }
    ??? = new File(b(localDoodleEmojiItem.jdField_a_of_type_JavaLangString));
    if ((a((File)???)) && (!paramBoolean))
    {
      SLog.d("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
      localDoodleEmojiItem.a(((File)???).getPath());
      Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem, 0, true, 0L, 0L));
      return true;
    }
    if (!TextUtils.isEmpty(localDoodleEmojiItem.a()))
    {
      SLog.d("DoodleEmojiManager", "local emoji folder is missing");
      localDoodleEmojiItem.a(null);
    }
    if (TextUtils.isEmpty(localDoodleEmojiItem.e))
    {
      SLog.d("DoodleEmojiManager", "can not start download because of empty download-url is found");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(localDoodleEmojiItem))
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localDoodleEmojiItem);
        SLog.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " enqueue");
        c();
        return true;
      }
      SLog.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " is already in pending list");
    }
  }
  
  public void b() {}
  
  public void c()
  {
    SLog.b("DoodleEmojiManager", "startDownload");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = ((DoodleEmojiItem)this.jdField_a_of_type_JavaUtilQueue.poll());
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem != null)
        {
          SLog.b("DoodleEmojiManager", "downloader startDownload : " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
          Bosses.get().postJob(new one(this, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem));
        }
        return;
      }
      SLog.b("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
    }
  }
  
  public void d()
  {
    SLog.b("DoodleEmojiManager", "stopRequestSpeed.");
    ((LocationManager)QQStoryContext.a().a().getSystemService("location")).removeUpdates(this.jdField_a_of_type_AndroidLocationLocationListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager
 * JD-Core Version:    0.7.0.1
 */