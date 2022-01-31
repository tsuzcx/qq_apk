package com.tencent.mobileqq.activity.richmedia;

import ajjs;
import android.content.Context;
import android.view.WindowManager.BadTokenException;
import bdcd;
import bdfq;
import com.tencent.qphone.base.util.QLog;

public class CameraPreviewNew$1
  implements Runnable
{
  CameraPreviewNew$1(CameraPreviewNew paramCameraPreviewNew, String paramString, int paramInt, Context paramContext) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131699714);
    }
    localObject = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131694205), new ajjs(this));
    try
    {
      ((bdfq)localObject).setCancelable(false);
      ((bdfq)localObject).show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CameraPreviewNew", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.CameraPreviewNew.1
 * JD-Core Version:    0.7.0.1
 */