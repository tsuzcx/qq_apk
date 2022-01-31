import android.text.TextUtils;

public class bgdi
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
    if (!TextUtils.isEmpty(this.b))
    {
      this.b = this.b.replaceAll("\\+86", "");
      this.b = this.b.replaceAll("\\D", "");
    }
  }
  
  public String toString()
  {
    return "SimInfo mIseDataTrafficSim=" + this.jdField_a_of_type_Boolean + ",mIMSI=" + this.jdField_a_of_type_JavaLangString + ",mPhoneNum=" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgdi
 * JD-Core Version:    0.7.0.1
 */