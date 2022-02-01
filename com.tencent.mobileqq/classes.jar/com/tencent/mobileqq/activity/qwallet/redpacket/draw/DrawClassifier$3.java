package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DrawClassifier$3
  implements IPreloadService.OnGetPathListener
{
  DrawClassifier$3(DrawClassifier paramDrawClassifier, DrawClassifier.OnClassifierInitListener paramOnClassifierInitListener) {}
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnClassifierInitListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnClassifierInitListener.a(false);
    }
  }
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      try
      {
        String str = new File(paramPathResult.folderPath, "quickDraw.tflite").toString();
        paramPathResult = new File(paramPathResult.folderPath, "classes.txt").toString();
        if ((!new File(str).exists()) || (!new File(paramPathResult).exists()))
        {
          QLog.e("DrawClassifier", 1, "init fail file not exist");
          a();
          return;
        }
        DrawClassifier.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier, new DefaultClassifier(str, paramPathResult));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnClassifierInitListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnClassifierInitListener.a(true);
        }
        DrawClassifier.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier, true);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("DrawClassifier", 2, "init success");
        return;
      }
      catch (Throwable paramPathResult)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "init recog fail:" + paramPathResult);
        }
        paramPathResult.printStackTrace();
        a();
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier", 2, "init download fail");
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3
 * JD-Core Version:    0.7.0.1
 */