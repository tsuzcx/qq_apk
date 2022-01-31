import com.tencent.qphone.base.util.QLog;

public class anbe
  extends ancs
{
  public float a;
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public anbe()
  {
    this.jdField_b_of_type_Long = 64L;
  }
  
  public static boolean a(anbe paramanbe)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramanbe != null)
    {
      bool1 = bool2;
      if (paramanbe.a())
      {
        bool1 = bool2;
        if (paramanbe.b()) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARCloudPreOcrResult", 2, "isRecogSuccess result = " + bool1);
    }
    return bool1;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "ARCloudPreOcrResult{recogType = " + this.jdField_b_of_type_Long + ", recogSvrRetCode = " + this.jdField_a_of_type_Int + ", recogSvrRetMsg = " + this.jdField_a_of_type_JavaLangString + ", sessionId = " + this.jdField_b_of_type_JavaLangString + ", arWordDetectRetCode = " + this.jdField_b_of_type_Int + ", arWordDetectRetMsg = " + this.jdField_c_of_type_JavaLangString + ", wordType = " + this.jdField_c_of_type_Int + ", confidence = " + this.jdField_a_of_type_Float + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbe
 * JD-Core Version:    0.7.0.1
 */