package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class PokeItemAnimationManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("inFileDir:");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" | outFileDir:");
        localStringBuilder.append(this.b);
        QLog.d("LzmaUtils", 2, localStringBuilder.toString());
      }
      FileUtils.uncompressZip(this.jdField_a_of_type_JavaLangString, this.b, false);
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LzmaUtils", 2, localIOException, new Object[0]);
      }
    }
    PokeItemAnimationManager.a(this.this$0, this.b, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */