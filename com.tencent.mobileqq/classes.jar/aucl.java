import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aucl
  extends aucg
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public aucl(bfjs parambfjs)
  {
    this.jdField_a_of_type_JavaLangString = parambfjs.e;
    this.jdField_a_of_type_Int = 1;
    this.b = String.valueOf(parambfjs.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucl
 * JD-Core Version:    0.7.0.1
 */