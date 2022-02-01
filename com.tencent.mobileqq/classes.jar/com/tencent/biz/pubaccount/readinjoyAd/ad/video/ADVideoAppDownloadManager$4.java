package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class ADVideoAppDownloadManager$4
  implements Runnable
{
  public void run()
  {
    ADVideoAppDownloadData localADVideoAppDownloadData = ADVideoAppDownloadManager.a(this.this$0);
    if (localADVideoAppDownloadData == null) {}
    int k;
    do
    {
      int j;
      int i;
      do
      {
        return;
        j = localADVideoAppDownloadData.jdField_a_of_type_Int;
        if (AdDownloadUtil.a(localADVideoAppDownloadData))
        {
          localADVideoAppDownloadData.jdField_a_of_type_Int = 1;
          this.this$0.a(ADVideoAppDownloadManager.a(this.this$0, localADVideoAppDownloadData, 100), localADVideoAppDownloadData.jdField_a_of_type_Int);
          return;
        }
        localObject = localADVideoAppDownloadData.c;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.a(null, 0);
          return;
        }
        localObject = DownloadManagerV2.a().a((String)localObject);
        if (localObject == null) {
          break;
        }
        i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
        if ((j == 5) || (j == 0))
        {
          j = ((TMAssistantDownloadTaskInfo)localObject).mState;
          if ((j == 2) || (j == 1)) {
            localADVideoAppDownloadData.jdField_a_of_type_Int = 3;
          }
          for (;;)
          {
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
            ((DownloadInfo)localObject).f = i;
            ((DownloadInfo)localObject).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
            ADVideoAppDownloadManager.a(this.this$0).a = true;
            ADVideoAppDownloadManager.a(this.this$0).a();
            if (ADVideoAppDownloadManager.a(this.this$0) != null) {
              ADVideoAppDownloadManager.a(this.this$0).b = i;
            }
            this.this$0.a((DownloadInfo)localObject, localADVideoAppDownloadData.jdField_a_of_type_Int);
            return;
            if (j == 3) {
              localADVideoAppDownloadData.jdField_a_of_type_Int = 4;
            } else if (j == 4) {
              localADVideoAppDownloadData.jdField_a_of_type_Int = 5;
            } else {
              localADVideoAppDownloadData.jdField_a_of_type_Int = 0;
            }
          }
        }
      } while ((j != 4) && (j != 3));
      k = ((TMAssistantDownloadTaskInfo)localObject).mState;
      if ((j == 3) && (k == 3))
      {
        this.this$0.b(localADVideoAppDownloadData);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((j == 4) && (k == 2))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
      if ((j == 4) && (k == 3))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((j == 4) && (k == 1))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
    } while (k != 4);
    Object localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
    ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
    ((DownloadInfo)localObject).f = 100;
    ADVideoAppDownloadManager.a(this.this$0).a = true;
    ADVideoAppDownloadManager.a(this.this$0).a();
    this.this$0.a((DownloadInfo)localObject, 5);
    return;
    this.this$0.a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */