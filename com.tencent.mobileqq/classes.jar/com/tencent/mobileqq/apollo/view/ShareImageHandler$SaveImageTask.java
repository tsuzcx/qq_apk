package com.tencent.mobileqq.apollo.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Message;
import annr;
import bkys;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import nwh;

class ShareImageHandler$SaveImageTask
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final WeakReference<Bitmap> jdField_a_of_type_JavaLangRefWeakReference;
  private int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private WeakReference<bkys> jdField_b_of_type_JavaLangRefWeakReference;
  private final int jdField_c_of_type_Int;
  private WeakReference<annr> jdField_c_of_type_JavaLangRefWeakReference;
  
  public void run()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_c_of_type_JavaLangRefWeakReference == null)) {}
    bkys localbkys;
    Object localObject3;
    do
    {
      do
      {
        return;
        localbkys = (bkys)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      } while (localbkys == null);
      localObject3 = (annr)this.jdField_c_of_type_JavaLangRefWeakReference.get();
    } while (localObject3 == null);
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject2 = (Bitmap)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new int[this.jdField_b_of_type_Int * this.jdField_c_of_type_Int];
          i = 0;
          j = 0;
          if (j < this.jdField_c_of_type_Int)
          {
            int k = 0;
            if (k < this.jdField_b_of_type_Int)
            {
              int m = this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int * j + k)];
              localObject1[((this.jdField_c_of_type_Int - i - 1) * this.jdField_b_of_type_Int + k)] = (m & 0xFF00FF00 | m << 16 & 0xFFFF0000 | m >> 16 & 0xFF);
              k += 1;
              continue;
            }
          }
          else
          {
            localObject1 = Bitmap.createBitmap((int[])localObject1, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
          }
        }
        else if (localObject1 != null)
        {
          localObject3 = ((annr)localObject3).a(this.jdField_a_of_type_ArrayOfInt, (Bitmap)localObject1, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = localObject1;
          }
          localObject1 = nwh.a((Bitmap)localObject2);
          localObject2 = localbkys.obtainMessage(this.jdField_a_of_type_Int);
          ((Message)localObject2).obj = localObject1;
          ((Message)localObject2).sendToTarget();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ShareImageHandler", 2, localException.getMessage());
        return;
        QLog.e("ShareImageHandler", 2, "error! bitmap null");
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ShareImageHandler", 2, localOutOfMemoryError.getMessage());
        return;
      }
      j += 1;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ShareImageHandler.SaveImageTask
 * JD-Core Version:    0.7.0.1
 */