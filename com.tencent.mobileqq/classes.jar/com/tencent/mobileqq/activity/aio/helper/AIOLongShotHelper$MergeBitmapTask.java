package com.tencent.mobileqq.activity.aio.helper;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AIOLongShotHelper$MergeBitmapTask
  implements Runnable
{
  private AIOLongShotHelper jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  
  public AIOLongShotHelper$MergeBitmapTask(AIOLongShotHelper paramAIOLongShotHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper = paramAIOLongShotHelper;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void run()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "run() isCanceled before mergeBitmaps");
      }
      AIOLongShotHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper);
      AIOLongShotHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper, true, false, null);
      return;
    }
    Bitmap localBitmap = AIOLongShotHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper);
    AIOLongShotHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper);
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "run() isCanceled before encodeAndWritePNG");
      }
      AIOLongShotHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper, true, false, null);
      return;
    }
    AIOLongShotHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper, localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.MergeBitmapTask
 * JD-Core Version:    0.7.0.1
 */