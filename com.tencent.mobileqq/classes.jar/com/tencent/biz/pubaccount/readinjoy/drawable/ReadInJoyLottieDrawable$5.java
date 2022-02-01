package com.tencent.biz.pubaccount.readinjoy.drawable;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

final class ReadInJoyLottieDrawable$5
  extends DownloadListener
{
  ReadInJoyLottieDrawable$5(long paramLong, String paramString, File paramFile1, File paramFile2, WeakReference paramWeakReference) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyLottieDrawable", 1, this.jdField_a_of_type_Long + " download lottie resource fail!");
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask != null) && (paramDownloadTask.a().getLong("bgLottieResId") == this.jdField_a_of_type_Long) && (paramDownloadTask.a == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyLottieDrawable", 1, "download success " + this.jdField_a_of_type_JavaLangString);
      }
      ThreadManager.excute(new ReadInJoyLottieDrawable.5.1(this), 64, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.5
 * JD-Core Version:    0.7.0.1
 */