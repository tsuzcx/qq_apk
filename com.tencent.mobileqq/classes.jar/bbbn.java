import java.util.ArrayList;

public class bbbn
  extends bbbz
{
  public int a;
  public long a;
  public String a;
  public ArrayList<bawy> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d = "";
  public String e = "";
  public String f = "";
  
  public bbbn()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" fileID:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" blockSize:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" netChg:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" downDomain:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" thumbDownUrl");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" bigDownUrl:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" orgiDownUrl:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbn
 * JD-Core Version:    0.7.0.1
 */