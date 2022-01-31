package com.tencent.biz.pubaccount.NativeAd.util;

import bdin;
import bfkr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import nop;
import noy;
import qyj;

public class ADBaseAppDownloadManager$1
  implements Runnable
{
  public ADBaseAppDownloadManager$1(nop paramnop, qyj paramqyj) {}
  
  public void run()
  {
    if ((this.this$0.b(this.a)) && (noy.a(this.this$0.a, this.a.d)))
    {
      QLog.d("ADBaseAppDownloadManager", 1, "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
    }
    do
    {
      return;
      if ((this.this$0.c(this.a)) && (nop.a(this.this$0.a, this.a)))
      {
        QLog.d("ADBaseAppDownloadManager", 1, "already finishDownload." + this.a.d);
        this.this$0.a(this.a, 5, 100);
        DownloadInfo localDownloadInfo = bfkr.a().c(this.a.jdField_a_of_type_JavaLangString);
        bfkr.a().a(localDownloadInfo);
        return;
      }
      if (this.a.jdField_a_of_type_Boolean)
      {
        nop.a(this.this$0, this.a);
        return;
      }
      if (bdin.g(BaseApplicationImpl.getContext()))
      {
        this.this$0.a(this.a, 0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADBaseAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */