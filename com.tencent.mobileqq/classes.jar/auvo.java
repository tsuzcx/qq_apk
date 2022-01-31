import android.text.TextUtils;

public class auvo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  private String b()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return "";
    case 4: 
      return ajyc.a(2131713561);
    case 5: 
      return ajyc.a(2131713559);
    case 6: 
      return ajyc.a(2131713557);
    case 7: 
      return ajyc.a(2131713558);
    case 8: 
      return ajyc.a(2131713562);
    }
    return ajyc.a(2131713560);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_b_of_type_Int == 3)
    {
      if (this.jdField_a_of_type_Long > 0L) {
        localStringBuilder.append(this.jdField_a_of_type_Long + "级");
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("，");
        }
        localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_Int > 0)
      {
        String str = b();
        if (!TextUtils.isEmpty(str))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("，");
          }
          localStringBuilder.append(str);
        }
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.jdField_a_of_type_Long > 0L) {
        localStringBuilder.append(this.jdField_a_of_type_Long + "级");
      }
    }
  }
  
  public String toString()
  {
    return "uint32_idx:" + this.jdField_a_of_type_Int + " uint32_category:" + this.jdField_b_of_type_Int + " str_school_id:" + this.jdField_a_of_type_JavaLangString + " str_school_name:" + this.jdField_b_of_type_JavaLangString + " str_department_id:" + this.jdField_c_of_type_JavaLangString + " str_department_name:" + this.jdField_d_of_type_JavaLangString + " uint32_degree:" + this.jdField_c_of_type_Int + " uint32_enrollment_year:" + this.jdField_a_of_type_Long + " uint32_graduation_year:" + this.jdField_b_of_type_Long + " uint32_allow_recommend:" + this.jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvo
 * JD-Core Version:    0.7.0.1
 */