package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import bjjq;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import udt;
import ule;
import ulg;

class ADVideoAppDownloadManager$4
  implements Runnable
{
  public void run()
  {
    ule localule = ADVideoAppDownloadManager.a(this.this$0);
    if (localule == null) {}
    int k;
    do
    {
      int j;
      int i;
      do
      {
        return;
        j = localule.jdField_a_of_type_Int;
        if (udt.a(localule))
        {
          localule.jdField_a_of_type_Int = 1;
          this.this$0.a(ADVideoAppDownloadManager.a(this.this$0, localule, 100), localule.jdField_a_of_type_Int);
          return;
        }
        localObject = localule.c;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.a(null, 0);
          return;
        }
        localObject = bjjq.a().a((String)localObject);
        if (localObject == null) {
          break;
        }
        i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
        if ((j == 5) || (j == 0))
        {
          j = ((TMAssistantDownloadTaskInfo)localObject).mState;
          if ((j == 2) || (j == 1)) {
            localule.jdField_a_of_type_Int = 3;
          }
          for (;;)
          {
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).e = localule.d;
            ((DownloadInfo)localObject).f = i;
            ((DownloadInfo)localObject).c = localule.jdField_a_of_type_JavaLangString;
            ADVideoAppDownloadManager.a(this.this$0).a = true;
            ADVideoAppDownloadManager.a(this.this$0).a();
            if (ADVideoAppDownloadManager.a(this.this$0) != null) {
              ADVideoAppDownloadManager.a(this.this$0).b = i;
            }
            this.this$0.a((DownloadInfo)localObject, localule.jdField_a_of_type_Int);
            return;
            if (j == 3) {
              localule.jdField_a_of_type_Int = 4;
            } else if (j == 4) {
              localule.jdField_a_of_type_Int = 5;
            } else {
              localule.jdField_a_of_type_Int = 0;
            }
          }
        }
      } while ((j != 4) && (j != 3));
      k = ((TMAssistantDownloadTaskInfo)localObject).mState;
      if ((j == 3) && (k == 3))
      {
        this.this$0.b(localule);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = localule.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = localule.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((j == 4) && (k == 2))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = localule.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = localule.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
      if ((j == 4) && (k == 3))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = localule.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = localule.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((j == 4) && (k == 1))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = localule.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = localule.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
    } while (k != 4);
    Object localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = localule.jdField_a_of_type_JavaLangString;
    ((DownloadInfo)localObject).e = localule.d;
    ((DownloadInfo)localObject).f = 100;
    ADVideoAppDownloadManager.a(this.this$0).a = true;
    ADVideoAppDownloadManager.a(this.this$0).a();
    this.this$0.a((DownloadInfo)localObject, 5);
    return;
    this.this$0.a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */