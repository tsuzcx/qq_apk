package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import bjsz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import tkk;
import tqt;
import tqw;

class ADVideoAppDownloadManager$7
  implements Runnable
{
  ADVideoAppDownloadManager$7(ADVideoAppDownloadManager paramADVideoAppDownloadManager) {}
  
  public void run()
  {
    tqt localtqt = ADVideoAppDownloadManager.a(this.this$0);
    if (localtqt == null) {}
    int k;
    do
    {
      int j;
      int i;
      do
      {
        return;
        j = localtqt.jdField_a_of_type_Int;
        if (tkk.a(localtqt))
        {
          localtqt.jdField_a_of_type_Int = 1;
          this.this$0.a(ADVideoAppDownloadManager.a(this.this$0, localtqt, 100), localtqt.jdField_a_of_type_Int);
          return;
        }
        localObject = localtqt.c;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.a(null, 0);
          return;
        }
        localObject = bjsz.a().a((String)localObject);
        if (localObject == null) {
          break;
        }
        i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
        if ((j == 5) || (j == 0))
        {
          j = ((TMAssistantDownloadTaskInfo)localObject).mState;
          if ((j == 2) || (j == 1)) {
            localtqt.jdField_a_of_type_Int = 3;
          }
          for (;;)
          {
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).e = localtqt.d;
            ((DownloadInfo)localObject).f = i;
            ((DownloadInfo)localObject).c = localtqt.jdField_a_of_type_JavaLangString;
            ADVideoAppDownloadManager.a(this.this$0).a = true;
            ADVideoAppDownloadManager.a(this.this$0).a();
            if (ADVideoAppDownloadManager.a(this.this$0) != null) {
              ADVideoAppDownloadManager.a(this.this$0).b = i;
            }
            this.this$0.a((DownloadInfo)localObject, localtqt.jdField_a_of_type_Int);
            return;
            if (j == 3) {
              localtqt.jdField_a_of_type_Int = 4;
            } else if (j == 4) {
              localtqt.jdField_a_of_type_Int = 5;
            } else {
              localtqt.jdField_a_of_type_Int = 0;
            }
          }
        }
      } while ((j != 4) && (j != 3));
      k = ((TMAssistantDownloadTaskInfo)localObject).mState;
      if ((j == 3) && (k == 3))
      {
        this.this$0.c(localtqt);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = localtqt.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = localtqt.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((j == 4) && (k == 2))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = localtqt.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = localtqt.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
      if ((j == 4) && (k == 3))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = localtqt.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = localtqt.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((j == 4) && (k == 1))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = localtqt.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = localtqt.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
    } while (k != 4);
    Object localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = localtqt.jdField_a_of_type_JavaLangString;
    ((DownloadInfo)localObject).e = localtqt.d;
    ((DownloadInfo)localObject).f = 100;
    ADVideoAppDownloadManager.a(this.this$0).a = true;
    ADVideoAppDownloadManager.a(this.this$0).a();
    this.this$0.a((DownloadInfo)localObject, 5);
    return;
    this.this$0.a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.7
 * JD-Core Version:    0.7.0.1
 */