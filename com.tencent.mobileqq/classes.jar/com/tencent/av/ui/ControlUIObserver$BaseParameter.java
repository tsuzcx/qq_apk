package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;

public class ControlUIObserver$BaseParameter
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = null;
  
  ControlUIObserver$BaseParameter(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Long == 0L) && (AudioHelper.a()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq未初始化:");
      localStringBuilder.append(getClass().getSimpleName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return this.jdField_a_of_type_Long;
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    paramVideoAppInterface.a(new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.BaseParameter
 * JD-Core Version:    0.7.0.1
 */