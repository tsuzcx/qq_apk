package com.tencent.biz.qqcircle.localphoto.scan;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class QCirclePhotoLocalClusterHelper$1
  implements Runnable
{
  QCirclePhotoLocalClusterHelper$1(QCirclePhotoLocalClusterHelper paramQCirclePhotoLocalClusterHelper) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      List localList = QCirclePhotoLocalClusterHelper.a(this.this$0);
      QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[clustering] total cost=%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      if (localList == null) {
        return;
      }
      l = System.currentTimeMillis();
      QCirclePhotoLocalClusterHelper.a(this.this$0, localList);
      QLog.i("QCirclePhotoLocalClusterHelper", 1, String.format(Locale.CHINESE, "[sendBroadcast] total cost=%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCirclePhotoLocalClusterHelper", 1, "[execute]", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoLocalClusterHelper.1
 * JD-Core Version:    0.7.0.1
 */