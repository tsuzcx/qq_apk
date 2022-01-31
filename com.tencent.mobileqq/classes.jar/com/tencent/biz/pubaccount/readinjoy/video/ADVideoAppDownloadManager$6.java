package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import bccu;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import pxh;
import pxj;

class ADVideoAppDownloadManager$6
  implements Runnable
{
  ADVideoAppDownloadManager$6(ADVideoAppDownloadManager paramADVideoAppDownloadManager, pxh parampxh, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Pxh.c;
    int i;
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bccu.a().a((String)localObject);
      if (localObject == null) {
        break label543;
      }
      i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
      if ((this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 0)) {
        break label207;
      }
      j = ((TMAssistantDownloadTaskInfo)localObject).mState;
      if ((j != 2) && (j != 1)) {
        break label164;
      }
      this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 3;
      localObject = new DownloadInfo();
      ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
      ((DownloadInfo)localObject).f = i;
      ((DownloadInfo)localObject).c = this.jdField_a_of_type_Pxh.jdField_a_of_type_JavaLangString;
      ADVideoAppDownloadManager.a(this.this$0).a = true;
      ADVideoAppDownloadManager.a(this.this$0).a();
      ADVideoAppDownloadManager.a(this.this$0).b = i;
      this.this$0.a((DownloadInfo)localObject, this.jdField_a_of_type_Pxh.jdField_a_of_type_Int);
    }
    label164:
    label207:
    do
    {
      do
      {
        return;
        if (j == 3)
        {
          this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 4;
          break;
        }
        if (j == 4)
        {
          this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 5;
          break;
        }
        this.jdField_a_of_type_Pxh.jdField_a_of_type_Int = 0;
        break;
      } while ((this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 3));
      j = ((TMAssistantDownloadTaskInfo)localObject).mState;
      if ((this.jdField_a_of_type_Int == 3) && (j == 3))
      {
        this.this$0.c(this.jdField_a_of_type_Pxh);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = this.jdField_a_of_type_Pxh.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((this.jdField_a_of_type_Int == 4) && (j == 2))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = this.jdField_a_of_type_Pxh.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
      if ((this.jdField_a_of_type_Int == 4) && (j == 3))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
        ((DownloadInfo)localObject).f = i;
        ((DownloadInfo)localObject).c = this.jdField_a_of_type_Pxh.jdField_a_of_type_JavaLangString;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((this.jdField_a_of_type_Int == 4) && (j == 1))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).c = this.jdField_a_of_type_Pxh.jdField_a_of_type_JavaLangString;
        ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
    } while (j != 4);
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = this.jdField_a_of_type_Pxh.jdField_a_of_type_JavaLangString;
    ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
    ((DownloadInfo)localObject).f = 100;
    ADVideoAppDownloadManager.a(this.this$0).a = true;
    ADVideoAppDownloadManager.a(this.this$0).a();
    this.this$0.a((DownloadInfo)localObject, 5);
    return;
    label543:
    this.this$0.a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */