package com.tencent.mobileqq.armap.test;

import abau;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class MapTestHelper$TestConfig
{
  public double a;
  public int a;
  protected long a;
  protected StringBuilder a;
  public boolean a;
  public double b;
  protected int b;
  public boolean b;
  public double c;
  public boolean c;
  public double d = 22.546195000000001D;
  public boolean d;
  public boolean e;
  
  public MapTestHelper$TestConfig()
  {
    this.jdField_c_of_type_Boolean = ARGLSurfaceView.FPS_LIMIT_SWITCH;
    this.jdField_a_of_type_Double = 113.941063D;
    this.jdField_b_of_type_Double = 22.545978000000002D;
    this.jdField_c_of_type_Double = 113.951331D;
    this.jdField_a_of_type_Int = 10;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangStringBuilder == null) {}
    String str;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("MapTestHelper", 4, String.format(Locale.getDefault(), "endFPSTrace", new Object[0]));
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("end trace fps [").append(System.currentTimeMillis()).append("]").append("\r\n");
      str = this.jdField_a_of_type_JavaLangStringBuilder.toString();
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangStringBuilder = null;
    } while (str.length() <= 0);
    ThreadManager.post(new abau(this, str), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.test.MapTestHelper.TestConfig
 * JD-Core Version:    0.7.0.1
 */