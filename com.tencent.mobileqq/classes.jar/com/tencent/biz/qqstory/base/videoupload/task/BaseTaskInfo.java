package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
public class BaseTaskInfo
{
  public volatile int a;
  public long a;
  public ErrorMessage a;
  public List a;
  public int b;
  public int c;
  
  public BaseTaskInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 3);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 5;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BaseTaskInfo{");
    localStringBuffer.append("status=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", retryTimes=").append(this.b);
    localStringBuffer.append(", result=").append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BaseTaskInfo
 * JD-Core Version:    0.7.0.1
 */