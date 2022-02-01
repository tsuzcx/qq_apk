import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.CaptureAsyncAutomator;
import dov.com.qq.im.capture.control.CaptureAsyncStepFactory;

public class boks
  implements bcha
{
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public CaptureAsyncAutomator a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    c = true;
    jdField_a_of_type_JavaLangString = "{1001,1004,1003,1005,1006,1007,1012}";
  }
  
  public boks()
  {
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator = new CaptureAsyncAutomator(null);
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (!c) {}
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator.onDestroy();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator.a(CaptureAsyncStepFactory.a(this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator, String.valueOf(paramInt)));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    d = true;
    if (!(paramVarArgs[0] instanceof String)) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      if (!e) {
        jdField_b_of_type_JavaLangString = (String)paramVarArgs[0];
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CaptureAsyncControl", 2, new Object[] { "pre open camera, result: ", Boolean.valueOf(e) });
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator.a(CaptureAsyncStepFactory.a(this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator, paramString));
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    paramString = CaptureAsyncStepFactory.a(this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator, paramString);
    paramString.a = paramArrayOfObject;
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncAutomator.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boks
 * JD-Core Version:    0.7.0.1
 */