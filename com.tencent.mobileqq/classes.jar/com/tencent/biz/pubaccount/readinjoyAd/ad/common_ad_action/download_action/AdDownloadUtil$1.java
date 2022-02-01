package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;

final class AdDownloadUtil$1
  implements Runnable
{
  AdDownloadUtil$1(ADVideoAppDownloadData paramADVideoAppDownloadData, AdDownloadUtil.PkgExistCallback paramPkgExistCallback) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(this.a.c);
    boolean bool2 = false;
    if (localDownloadInfo == null)
    {
      this.b.a(false);
      return;
    }
    Object localObject1;
    if (!TextUtils.isEmpty(localDownloadInfo.q)) {
      localObject1 = localDownloadInfo.q;
    } else {
      localObject1 = "";
    }
    Object localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      int i = localDownloadInfo.o;
      localObject3 = null;
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
      if (i == 0)
      {
        localTMAssistantDownloadTaskInfo = DownloadManagerV2.a().g(localDownloadInfo.d);
        localObject2 = localObject1;
        if (localTMAssistantDownloadTaskInfo != null)
        {
          localObject2 = localObject1;
          if (localTMAssistantDownloadTaskInfo.mState == 4) {
            localObject2 = localTMAssistantDownloadTaskInfo.mSavePath;
          }
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = DownloadManagerV2.a().c(localDownloadInfo);
          localObject1 = localObject2;
        }
      }
      else
      {
        localTMAssistantDownloadTaskInfo = DownloadManagerV2.a().c(localDownloadInfo);
        localObject2 = localObject1;
        if (localTMAssistantDownloadTaskInfo != null)
        {
          localObject2 = localObject1;
          if (localTMAssistantDownloadTaskInfo.mState == 4) {
            localObject2 = localTMAssistantDownloadTaskInfo.mSavePath;
          }
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = DownloadManagerV2.a().g(localDownloadInfo.d);
          localObject1 = localObject2;
        }
      }
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
        }
      }
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localDownloadInfo.q = ((String)localObject2);
        localDownloadInfo.a(4);
        DownloadManagerV2.a().e(localDownloadInfo);
        localObject3 = localObject2;
      }
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      bool1 = bool2;
      if (new File((String)localObject3).exists()) {
        bool1 = true;
      }
    }
    this.b.a(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */