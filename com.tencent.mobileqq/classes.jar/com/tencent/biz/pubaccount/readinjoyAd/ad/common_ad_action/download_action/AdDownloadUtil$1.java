package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.text.TextUtils;
import bjjq;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import udu;
import ule;

public final class AdDownloadUtil$1
  implements Runnable
{
  public AdDownloadUtil$1(ule paramule, udu paramudu) {}
  
  public void run()
  {
    Object localObject4 = null;
    DownloadInfo localDownloadInfo = bjjq.a().b(this.jdField_a_of_type_Ule.c);
    if (localDownloadInfo == null)
    {
      this.jdField_a_of_type_Udu.a(false);
      return;
    }
    Object localObject1 = "";
    if (!TextUtils.isEmpty(localDownloadInfo.l)) {
      localObject1 = localDownloadInfo.l;
    }
    Object localObject3 = localObject1;
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (localDownloadInfo.c != 0) {
        break label227;
      }
      localObject3 = bjjq.a().a(localDownloadInfo.d);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
        }
      }
      localObject1 = localObject2;
      localObject3 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = bjjq.a().a(localDownloadInfo);
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
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
        localDownloadInfo.l = ((String)localObject2);
        localDownloadInfo.a(4);
        bjjq.a().c(localDownloadInfo);
        localObject3 = localObject2;
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new File((String)localObject3).exists())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Udu.a(bool);
      return;
      label227:
      localObject3 = bjjq.a().a(localDownloadInfo);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
        }
      }
      localObject1 = localObject2;
      localObject3 = localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject3 = bjjq.a().a(localDownloadInfo.d);
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */