package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ulb;
import ule;
import ulg;
import ulj;
import ulk;
import ull;
import uqf;

public class WSVideoPreDownloadManager
  implements ulg
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TVK_ICacheMgr.IPreloadCallback jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString;
  private List<ull> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private ule jdField_a_of_type_Ule;
  private ulk jdField_a_of_type_Ulk;
  
  public WSVideoPreDownloadManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ule = new ule();
    this.jdField_a_of_type_Ule.a(this);
    if (!this.jdField_a_of_type_Ule.a())
    {
      this.jdField_a_of_type_Ule.a();
      return;
    }
    c();
    e();
  }
  
  private void a(ull paramull)
  {
    if ((paramull == null) || (TextUtils.isEmpty(paramull.b))) {}
    TVK_ICacheMgr localTVK_ICacheMgr;
    TVK_UserInfo localTVK_UserInfo;
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    do
    {
      return;
      localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
      if (localTVK_ICacheMgr == null)
      {
        uqf.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] start preload ERROR cacheMgr == null!");
        return;
      }
      String str = ulb.a(paramull.b);
      localTVK_UserInfo = new TVK_UserInfo("", "");
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str, "");
      localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", ulb.jdField_a_of_type_JavaLangString);
      if (paramull.jdField_a_of_type_Int > 0) {
        localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramull.jdField_a_of_type_Int));
      }
      uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] START DOWNLOAD!! duration:" + paramull.jdField_a_of_type_Int + ", vid:" + str + ", title:" + paramull.c + ", url:" + paramull.b);
    } while (TextUtils.isEmpty(paramull.b));
    int i = localTVK_ICacheMgr.preLoadVideoByUrlWithResult(this.jdField_a_of_type_AndroidContentContext, paramull.b, localTVK_UserInfo, localTVK_PlayerVideoInfo);
    uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] result:" + i);
  }
  
  private void c()
  {
    d();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
    }
    uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initCacheMgr] mFactory=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory + ", mCacheMgr=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr);
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)) {}
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initSerialPreDownload] setPreloadCallback");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new ulj(this));
  }
  
  private void f()
  {
    uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][releaseSerialPreDownload]");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(ulb.jdField_a_of_type_Int);
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +172 -> 178
    //   9: aload_2
    //   10: invokeinterface 224 1 0
    //   15: ifle +163 -> 178
    //   18: aload_2
    //   19: iconst_0
    //   20: invokeinterface 228 2 0
    //   25: checkcast 74	ull
    //   28: astore_1
    //   29: aload_2
    //   30: iconst_0
    //   31: invokeinterface 231 2 0
    //   36: pop
    //   37: aload_1
    //   38: ifnull +13 -> 51
    //   41: aload_1
    //   42: getfield 77	ull:b	Ljava/lang/String;
    //   45: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +41 -> 89
    //   51: aload_0
    //   52: invokespecial 167	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:g	()V
    //   55: return
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc 85
    //   61: new 132	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   68: ldc 233
    //   70: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_2
    //   74: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 93	uqf:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -49 -> 37
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 77	ull:b	Ljava/lang/String;
    //   94: putfield 56	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 56	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokevirtual 239	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:a	(Ljava/lang/String;)Z
    //   105: ifeq +40 -> 145
    //   108: ldc 85
    //   110: new 132	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   117: ldc 241
    //   119: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: getfield 148	ull:c	Ljava/lang/String;
    //   126: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 156	uqf:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 56	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload_0
    //   141: invokespecial 167	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:g	()V
    //   144: return
    //   145: ldc 85
    //   147: new 132	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   154: ldc 243
    //   156: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: getfield 148	ull:c	Ljava/lang/String;
    //   163: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 156	uqf:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: aload_1
    //   174: invokespecial 245	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:a	(Lull;)V
    //   177: return
    //   178: ldc 85
    //   180: ldc 247
    //   182: invokestatic 156	uqf:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: return
    //   186: astore_2
    //   187: goto -128 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	WSVideoPreDownloadManager
    //   28	146	1	localull	ull
    //   4	26	2	localList	List
    //   56	18	2	localException1	Exception
    //   186	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   18	29	56	java/lang/Exception
    //   29	37	186	java/lang/Exception
  }
  
  public void a()
  {
    uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][destroy]");
    ThreadManager.post(new WSVideoPreDownloadManager.1(this), 5, null, true);
    if (this.jdField_a_of_type_Ule != null)
    {
      this.jdField_a_of_type_Ule.b();
      this.jdField_a_of_type_Ule = null;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ulk == null) {}
    List localList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
        break;
      }
      localList = this.jdField_a_of_type_Ulk.a(paramInt, paramBoolean);
    } while ((localList == null) || (localList.size() <= 0));
    uqf.f("WS_VIDEO_PRE_DL", ">>>>>>[WSVideoPreDownloadManager.java][requestPreDownload] START!! preDownloadList size:" + localList.size());
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadSerialTask(this, localList), 5, null, true);
    return;
    uqf.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][requestPreDownload] is off or mCacheMgr is null, return!");
  }
  
  public void a(TVK_ICacheMgr.IPreloadCallback paramIPreloadCallback)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr$IPreloadCallback = paramIPreloadCallback;
  }
  
  public void a(ulk paramulk)
  {
    this.jdField_a_of_type_Ulk = paramulk;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    e();
  }
  
  public boolean a(String paramString)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    Object localObject = ulb.a(paramString);
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
    localObject = new TVK_PlayerVideoInfo(2, (String)localObject, "");
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_duration", "2");
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_servers_type", ulb.jdField_a_of_type_JavaLangString);
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int i = 0;
    int m = arrayOfString.length;
    int j = 0;
    while (j < m)
    {
      String str = arrayOfString[j];
      try
      {
        int k = localTVK_ICacheMgr.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString, localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject, str);
        i = k;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          uqf.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][checkIsCached] Exception url:" + paramString + ", cacheMgr.isVideoCached Exception:" + localException.getMessage());
        }
        j += 1;
      }
      if ((i == 2) || (i == 1))
      {
        uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][checkIsCached] return TRUE! cacheStatus:" + i + ", definition:" + str + ", url:" + paramString);
        return true;
      }
    }
    uqf.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][checkIsCached] return FALSE! url:" + paramString);
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(ulb.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */