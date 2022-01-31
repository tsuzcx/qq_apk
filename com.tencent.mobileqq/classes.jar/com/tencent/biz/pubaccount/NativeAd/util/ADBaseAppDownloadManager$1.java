package com.tencent.biz.pubaccount.NativeAd.util;

import bbfj;
import bdhk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import nlt;
import nmc;
import qjc;

public class ADBaseAppDownloadManager$1
  implements Runnable
{
  public ADBaseAppDownloadManager$1(nlt paramnlt, qjc paramqjc) {}
  
  public void run()
  {
    if ((this.this$0.b(this.a)) && (nmc.a(this.this$0.a, this.a.d)))
    {
      QLog.d("ADBaseAppDownloadManager", 1, "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
    }
    do
    {
      return;
      if ((this.this$0.c(this.a)) && (nlt.a(this.this$0.a, this.a)))
      {
        QLog.d("ADBaseAppDownloadManager", 1, "already finishDownload." + this.a.d);
        this.this$0.a(this.a, 5, 100);
        DownloadInfo localDownloadInfo = bdhk.a().c(this.a.jdField_a_of_type_JavaLangString);
        bdhk.a().a(localDownloadInfo);
        return;
      }
      if (this.a.jdField_a_of_type_Boolean)
      {
        nlt.a(this.this$0, this.a);
        return;
      }
      if (bbfj.g(BaseApplicationImpl.getContext()))
      {
        this.this$0.a(this.a, 0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADBaseAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */