public class atlx
{
  public static final String a;
  public static final String[] a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public int a;
  public long a;
  public boolean a;
  public int b;
  public int c;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131640848);
    jdField_b_of_type_JavaLangString = ajjy.a(2131640847);
    jdField_c_of_type_JavaLangString = ajjy.a(2131640846);
    d = ajjy.a(2131640850);
    e = ajjy.a(2131640849);
    f = ajjy.a(2131640851);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "uin", "uin_type", "senderUin", "msg_type", "msgid", "msgTime", "is_send", "msgContent", "media_path", "mediaStatus" };
  }
  
  private atlx() {}
  
  public atlx(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4, String paramString5, int paramInt3)
  {
    this.g = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.h = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.i = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.j = paramString4;
    this.k = paramString5;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public Object[] a()
  {
    return new Object[] { this.g, Integer.valueOf(this.jdField_a_of_type_Int), this.h, Integer.valueOf(this.jdField_b_of_type_Int), this.i, Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.j, this.k, Integer.valueOf(this.jdField_c_of_type_Int) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append(this.g).append("; ");
    localStringBuilder.append(this.jdField_b_of_type_Int).append("; ");
    localStringBuilder.append(this.h).append("; ");
    localStringBuilder.append(this.i).append("; ");
    localStringBuilder.append(this.jdField_a_of_type_Long).append(";");
    localStringBuilder.append(this.jdField_a_of_type_Boolean).append("; ");
    localStringBuilder.append(this.j).append("; ");
    localStringBuilder.append(this.k).append("; ");
    localStringBuilder.append(this.jdField_c_of_type_Int).append(". ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atlx
 * JD-Core Version:    0.7.0.1
 */