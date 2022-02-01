package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

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
    if ((this.jdField_a_of_type_Long == 0L) && (AudioHelper.d())) {
      throw new IllegalArgumentException("seq未初始化:" + getClass().getSimpleName());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.BaseParameter
 * JD-Core Version:    0.7.0.1
 */