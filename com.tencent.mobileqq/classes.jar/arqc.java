import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class arqc
  extends arpx
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public arqc(bbtn parambbtn)
  {
    this.jdField_a_of_type_JavaLangString = parambbtn.e;
    this.jdField_a_of_type_Int = 1;
    this.b = String.valueOf(parambbtn.b);
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
 * Qualified Name:     arqc
 * JD-Core Version:    0.7.0.1
 */