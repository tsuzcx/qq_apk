package com.tencent.mobileqq.ar.model;

import android.content.Context;
import com.tencent.common.app.AppInterface;

public abstract class AbstractSession
  implements CameraProxy.OnCameraPreviewCallback
{
  protected int a;
  protected Context a;
  protected AppInterface a;
  protected int b = 0;
  protected int c = 0;
  protected int d = 0;
  
  public AbstractSession()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void g()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public void h()
  {
    this.jdField_a_of_type_Int = 3;
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_a_of_type_Int = 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.AbstractSession
 * JD-Core Version:    0.7.0.1
 */