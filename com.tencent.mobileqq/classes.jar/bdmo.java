import com.tencent.common.config.AppSetting;

class bdmo
{
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k = "8.4.5.4745";
  public String l = "AND";
  
  public bdmo()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = AppSetting.a();
    this.jdField_a_of_type_JavaLangString = bhlo.a();
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.f);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.g);
    localStringBuilder.append('|');
    localStringBuilder.append(this.h);
    localStringBuilder.append('|');
    localStringBuilder.append(this.i);
    localStringBuilder.append('|');
    localStringBuilder.append(this.j);
    localStringBuilder.append('|');
    localStringBuilder.append(this.k);
    localStringBuilder.append('|');
    localStringBuilder.append(this.l);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmo
 * JD-Core Version:    0.7.0.1
 */