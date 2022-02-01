package com.tencent.mobileqq.activity.aio.item;

import ahnp;
import bhmi;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class PokeItemAnimationManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LzmaUtils", 2, "inFileDir:" + this.jdField_a_of_type_JavaLangString + " | outFileDir:" + this.b);
      }
      bhmi.a(this.jdField_a_of_type_JavaLangString, this.b, false);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LzmaUtils", 2, localIOException, new Object[0]);
        }
      }
    }
    ahnp.a(this.this$0, this.b, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */