package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WSVideoPreDownloadManager
  implements WSVideoPluginInstall.OnVideoPluginInstallListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private WSVideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall;
  private WSVideoPreDownloadManager.PreDownloadController jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$PreDownloadController;
  private IWSPlayerFactory jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory;
  private IWSPlayerPreDownloader.Listener jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
  private IWSPlayerPreDownloader jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
  private String jdField_a_of_type_JavaLangString;
  private List<WSVideoPreDownloadManager.VideoPreDownloadParam> jdField_a_of_type_JavaUtilList = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = null;
  
  public WSVideoPreDownloadManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall = new WSVideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a(this);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a();
      return;
    }
    c();
    d();
  }
  
  private AbsWSPlayerInfo a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory == null) {
      return null;
    }
    AbsWSPlayerInfo localAbsWSPlayerInfo = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory.a();
    localAbsWSPlayerInfo.a(WSPlayerUtils.a(paramString), paramString, 101, paramInt);
    return localAbsWSPlayerInfo;
  }
  
  private void a(WSVideoPreDownloadManager.VideoPreDownloadParam paramVideoPreDownloadParam)
  {
    if ((paramVideoPreDownloadParam == null) || (TextUtils.isEmpty(paramVideoPreDownloadParam.b))) {}
    IWSPlayerPreDownloader localIWSPlayerPreDownloader;
    do
    {
      return;
      localIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
      if (localIWSPlayerPreDownloader == null)
      {
        WSLog.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] start preload ERROR preDownloader == null!");
        return;
      }
      WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] START DOWNLOAD!! duration:" + paramVideoPreDownloadParam.a + ", title:" + paramVideoPreDownloadParam.c + ", url:" + paramVideoPreDownloadParam.b);
    } while (TextUtils.isEmpty(paramVideoPreDownloadParam.b));
    localIWSPlayerPreDownloader.a(a(paramVideoPreDownloadParam.b, paramVideoPreDownloadParam.a));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory = WSPlayerWrapHelper.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory.a(BaseApplicationImpl.getContext());
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initCacheMgr] mPreDownloader=" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader == null) {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initSerialPreDownload] setPreloadCallback");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader.a(new WSVideoPreDownloadManager.2(this));
  }
  
  private void e()
  {
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][releaseSerialPreDownload]");
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
    if (localIWSPlayerPreDownloader != null)
    {
      localIWSPlayerPreDownloader.a(null);
      localIWSPlayerPreDownloader.b();
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +172 -> 178
    //   9: aload_2
    //   10: invokeinterface 196 1 0
    //   15: ifle +163 -> 178
    //   18: aload_2
    //   19: iconst_0
    //   20: invokeinterface 200 2 0
    //   25: checkcast 88	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager$VideoPreDownloadParam
    //   28: astore_1
    //   29: aload_2
    //   30: iconst_0
    //   31: invokeinterface 203 2 0
    //   36: pop
    //   37: aload_1
    //   38: ifnull +13 -> 51
    //   41: aload_1
    //   42: getfield 91	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager$VideoPreDownloadParam:b	Ljava/lang/String;
    //   45: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +41 -> 89
    //   51: aload_0
    //   52: invokespecial 147	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:f	()V
    //   55: return
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc 99
    //   61: new 108	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   68: ldc 205
    //   70: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_2
    //   74: invokevirtual 208	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 106	com/tencent/biz/pubaccount/weishi_new/util/WSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -49 -> 37
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 91	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager$VideoPreDownloadParam:b	Ljava/lang/String;
    //   94: putfield 82	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 82	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokevirtual 211	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:a	(Ljava/lang/String;)Z
    //   105: ifeq +40 -> 145
    //   108: ldc 99
    //   110: new 108	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   117: ldc 213
    //   119: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: getfield 125	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager$VideoPreDownloadParam:c	Ljava/lang/String;
    //   126: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 134	com/tencent/biz/pubaccount/weishi_new/util/WSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 82	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload_0
    //   141: invokespecial 147	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:f	()V
    //   144: return
    //   145: ldc 99
    //   147: new 108	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   154: ldc 215
    //   156: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: getfield 125	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager$VideoPreDownloadParam:c	Ljava/lang/String;
    //   163: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 134	com/tencent/biz/pubaccount/weishi_new/util/WSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: aload_1
    //   174: invokespecial 217	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:a	(Lcom/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager$VideoPreDownloadParam;)V
    //   177: return
    //   178: ldc 99
    //   180: ldc 219
    //   182: invokestatic 134	com/tencent/biz/pubaccount/weishi_new/util/WSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: return
    //   186: astore_2
    //   187: goto -128 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	WSVideoPreDownloadManager
    //   28	146	1	localVideoPreDownloadParam	WSVideoPreDownloadManager.VideoPreDownloadParam
    //   4	26	2	localList	List
    //   56	18	2	localException1	java.lang.Exception
    //   186	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	29	56	java/lang/Exception
    //   29	37	186	java/lang/Exception
  }
  
  public void a()
  {
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][destroy]");
    ThreadManager.post(new WSVideoPreDownloadManager.1(this), 5, null, true);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall = null;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$PreDownloadController == null) {}
    List localList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader == null) {
        break;
      }
      localList = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$PreDownloadController.a(paramInt, paramBoolean);
    } while ((localList == null) || (localList.size() <= 0));
    WSLog.f("WS_VIDEO_PRE_DL", ">>>>>>[WSVideoPreDownloadManager.java][requestPreDownload] START!! preDownloadList size:" + localList.size());
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadSerialTask(this, localList), 5, null, true);
    return;
    WSLog.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][requestPreDownload] is off or mPreDownloader is null, return!");
  }
  
  public void a(WSVideoPreDownloadManager.PreDownloadController paramPreDownloadController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$PreDownloadController = paramPreDownloadController;
  }
  
  public void a(IWSPlayerPreDownloader.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener = paramListener;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    d();
  }
  
  public boolean a(String paramString)
  {
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
    if (localIWSPlayerPreDownloader == null) {}
    Set localSet;
    do
    {
      return false;
      localSet = this.jdField_a_of_type_JavaUtilSet;
    } while ((!localIWSPlayerPreDownloader.a(a(paramString, 0))) && ((localSet == null) || (!localSet.contains(paramString))));
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */