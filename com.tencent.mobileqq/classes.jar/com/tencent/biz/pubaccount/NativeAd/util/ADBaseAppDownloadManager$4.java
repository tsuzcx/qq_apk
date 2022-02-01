package com.tencent.biz.pubaccount.NativeAd.util;

import android.text.TextUtils;
import bisa;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import nxp;
import orb;

public class ADBaseAppDownloadManager$4
  implements Runnable
{
  public ADBaseAppDownloadManager$4(nxp paramnxp, orb paramorb) {}
  
  public void run()
  {
    Object localObject = this.a.c;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bisa.a().a((String)localObject);
      if (localObject != null)
      {
        int i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
        int j = ((TMAssistantDownloadTaskInfo)localObject).mState;
        if (j == 3)
        {
          this.this$0.b(this.a);
          localObject = new DownloadInfo();
          ((DownloadInfo)localObject).e = this.a.d;
          ((DownloadInfo)localObject).f = i;
          this.this$0.a((DownloadInfo)localObject, 4);
        }
        do
        {
          return;
          if (j == 2)
          {
            this.this$0.a(this.a);
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).e = this.a.d;
            ((DownloadInfo)localObject).f = i;
            this.this$0.a((DownloadInfo)localObject, 3);
            return;
          }
        } while (j != 4);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = this.a.d;
        ((DownloadInfo)localObject).f = 100;
        this.this$0.a((DownloadInfo)localObject, 5);
        return;
      }
      localObject = new DownloadInfo();
      ((DownloadInfo)localObject).e = this.a.d;
      ((DownloadInfo)localObject).f = 0;
      this.this$0.a((DownloadInfo)localObject, 0);
      return;
    }
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).e = this.a.d;
    ((DownloadInfo)localObject).f = 0;
    this.this$0.a((DownloadInfo)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */