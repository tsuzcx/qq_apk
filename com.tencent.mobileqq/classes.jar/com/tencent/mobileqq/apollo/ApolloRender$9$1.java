package com.tencent.mobileqq.apollo;

import aith;
import com.tencent.qphone.base.util.QLog;

public class ApolloRender$9$1
  extends IApolloRunnableTask
{
  public ApolloRender$9$1(aith paramaith, byte[] paramArrayOfByte, int paramInt) {}
  
  public String a()
  {
    return "httpRequest_httpCallBack";
  }
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ArrayOfByte != null)) {
      QLog.d("sava_ApolloRender", 2, "httpLog httpCallBack data.len=" + this.jdField_a_of_type_ArrayOfByte.length);
    }
    ((ApolloSurfaceView)this.this$0.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.9.1
 * JD-Core Version:    0.7.0.1
 */