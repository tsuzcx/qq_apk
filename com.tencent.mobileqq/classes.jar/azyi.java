import android.text.TextUtils;

public class azyi
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
      return anzj.a(2131712444);
    case 5: 
      return anzj.a(2131712442);
    case 6: 
      return anzj.a(2131712440);
    case 7: 
      return anzj.a(2131712441);
    case 8: 
      return anzj.a(2131712445);
    }
    return anzj.a(2131712443);
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
 * Qualified Name:     azyi
 * JD-Core Version:    0.7.0.1
 */