import android.text.TextUtils;

public class azfw
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  
  private String b()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return "";
    case 4: 
      return anni.a(2131712335);
    case 5: 
      return anni.a(2131712333);
    case 6: 
      return anni.a(2131712331);
    case 7: 
      return anni.a(2131712332);
    case 8: 
      return anni.a(2131712336);
    }
    return anni.a(2131712334);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_b_of_type_Int == 3)
    {
      if (this.jdField_d_of_type_Int > 0) {
        localStringBuilder.append(this.jdField_d_of_type_Int + "级");
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("   ");
        }
        localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_Int > 0)
      {
        String str = b();
        if (!TextUtils.isEmpty(str))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("   ");
          }
          localStringBuilder.append(str);
        }
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.jdField_d_of_type_Int > 0) {
        localStringBuilder.append(this.jdField_d_of_type_Int + "级");
      }
    }
  }
  
  public String toString()
  {
    return "uint32_idx:" + this.jdField_a_of_type_Int + " uint32_category:" + this.jdField_b_of_type_Int + " str_school_id:" + this.jdField_a_of_type_JavaLangString + " str_school_name:" + this.jdField_b_of_type_JavaLangString + " str_department_id:" + this.jdField_c_of_type_JavaLangString + " str_department_name:" + this.jdField_d_of_type_JavaLangString + " uint32_degree:" + this.jdField_c_of_type_Int + " uint32_enrollment_year:" + this.jdField_d_of_type_Int + " uint32_graduation_year:" + this.e + " uint32_allow_recommend:" + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfw
 * JD-Core Version:    0.7.0.1
 */