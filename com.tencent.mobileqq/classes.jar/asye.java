import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class asye
  extends asxz
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public asye(becp parambecp)
  {
    this.jdField_a_of_type_JavaLangString = parambecp.e;
    this.jdField_a_of_type_Int = 1;
    this.b = String.valueOf(parambecp.b);
  }
  
  public String a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)))
    {
      QLog.e("TroopFileControlReq<QFile>", 1, "key params is null");
      return "";
    }
    return a(this.jdField_a_of_type_Int + "", this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asye
 * JD-Core Version:    0.7.0.1
 */