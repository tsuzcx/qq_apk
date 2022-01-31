package com.tencent.biz.pubaccount.NativeAd.util;

import android.text.TextUtils;
import bccu;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import nav;
import pxh;

public class ADBaseAppDownloadManager$2
  implements Runnable
{
  public ADBaseAppDownloadManager$2(nav paramnav, pxh parampxh, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Pxh.c;
    int i;
    int j;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 3)))
    {
      localObject = bccu.a().a((String)localObject);
      if (localObject != null)
      {
        i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
        j = ((TMAssistantDownloadTaskInfo)localObject).mState;
        if ((this.jdField_a_of_type_Int != 3) || (j != 3)) {
          break label122;
        }
        this.this$0.c(this.jdField_a_of_type_Pxh);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 4);
      }
    }
    label122:
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 4) && (j == 2))
      {
        this.this$0.a(this.jdField_a_of_type_Pxh);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
        ((DownloadInfo)localObject).f = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
    } while (j != 4);
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).e = this.jdField_a_of_type_Pxh.d;
    ((DownloadInfo)localObject).f = 100;
    this.this$0.a((DownloadInfo)localObject, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */