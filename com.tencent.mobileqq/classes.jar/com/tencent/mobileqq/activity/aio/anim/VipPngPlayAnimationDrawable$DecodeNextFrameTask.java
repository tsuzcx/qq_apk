package com.tencent.mobileqq.activity.aio.anim;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class VipPngPlayAnimationDrawable$DecodeNextFrameTask
  extends AsyncTask
{
  private Object jdField_a_of_type_JavaLangObject;
  
  public VipPngPlayAnimationDrawable$DecodeNextFrameTask(VipPngPlayAnimationDrawable paramVipPngPlayAnimationDrawable, Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    try
    {
      long l1 = paramVarArgs[0].longValue();
      long l2 = paramVarArgs[1].longValue();
      long l3 = paramVarArgs[2].longValue();
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a((int)l3, this.jdField_a_of_type_JavaLangObject, (int)l2);
      if ((paramVarArgs != null) && (!isCancelled()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_AndroidGraphicsBitmap = paramVarArgs;
        l2 = SystemClock.uptimeMillis();
        if (l2 < l1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable, l1 - l2);
          return null;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
        return null;
      }
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VipPngPlayAnimationDrawable", 4, "", paramVarArgs);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_Boolean = true;
      return null;
    }
    catch (Throwable paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VipPngPlayAnimationDrawable", 4, "", paramVarArgs);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_Boolean = true;
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable$DecodeNextFrameTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable.DecodeNextFrameTask
 * JD-Core Version:    0.7.0.1
 */