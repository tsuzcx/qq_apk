package com.tencent.mobileqq.armap;

import android.support.v4.util.MQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FrameBmpCache$CancelAbleRunnable
  implements Runnable
{
  public int a;
  volatile boolean a;
  
  public FrameBmpCache$CancelAbleRunnable(FrameBmpCache paramFrameBmpCache, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameBmpCache", 2, "cancel");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      ??? = (String)this.this$0.jdField_a_of_type_JavaUtilList.get(FrameBmpCache.a(this.this$0, this.jdField_a_of_type_Int));
      Object localObject2;
      if (this.this$0.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(???) == null)
      {
        localObject2 = FrameBmpCache.a(this.this$0, (String)???);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeBitmap, index=");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append(", not in cache:");
          localStringBuilder.append((String)???);
          localStringBuilder.append(", after decode=");
          localStringBuilder.append(localObject2);
          QLog.i("FrameBmpCache", 2, localStringBuilder.toString());
        }
        this.this$0.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(???, localObject2);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("decodeBitmap, index=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append(", is in cache:");
        ((StringBuilder)localObject2).append((String)???);
        QLog.i("FrameBmpCache", 2, ((StringBuilder)localObject2).toString());
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label221;
    }
    catch (Throwable localThrowable)
    {
      label195:
      break label195;
    }
    FrameBmpCache.b(this.this$0, 2);
    if (QLog.isColorLevel())
    {
      QLog.d("FrameBmpCache", 2, "decodeBitmap,Throwable e");
      break label270;
      label221:
      FrameBmpCache.b(this.this$0, 1);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("decodeBitmap,OutOfMemory Error index:");
        ((StringBuilder)???).append(this.jdField_a_of_type_Int);
        QLog.d("FrameBmpCache", 2, ((StringBuilder)???).toString());
      }
    }
    label270:
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("decode end......");
      ((StringBuilder)???).append(this.jdField_a_of_type_Int);
      QLog.i("FrameBmpCache", 2, ((StringBuilder)???).toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        FrameBmpCache.a(this.this$0);
        return;
      }
    }
  }
  
  public String toString()
  {
    return Integer.toString(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.FrameBmpCache.CancelAbleRunnable
 * JD-Core Version:    0.7.0.1
 */