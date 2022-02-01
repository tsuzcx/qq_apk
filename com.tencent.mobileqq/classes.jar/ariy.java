import android.text.TextUtils;

public class ariy
{
  public int a;
  public long a;
  public arie a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "0";
  public String f = "";
  
  public ariy()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 30;
    this.jdField_b_of_type_Int = 1;
  }
  
  public ariy a()
  {
    ariy localariy = new ariy();
    localariy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localariy.jdField_a_of_type_ArrayOfByte = ((byte[])this.jdField_a_of_type_ArrayOfByte.clone());
    localariy.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localariy.c = this.c;
    localariy.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localariy.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localariy.e = this.e;
    return localariy;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = bftf.a("");
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.e = "0";
    this.jdField_b_of_type_Int = 0;
    this.f = "";
    this.jdField_a_of_type_Arie = null;
  }
  
  public boolean a()
  {
    String str = bftf.a(this.jdField_a_of_type_ArrayOfByte);
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(str));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof ariy));
      paramObject = (ariy)paramObject;
    } while ((!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    String str = bftf.a(this.jdField_a_of_type_ArrayOfByte);
    int i = 0;
    if (str != null) {
      i = str.length();
    }
    localStringBuilder.append("{sig: ").append(i).append("}");
    localStringBuilder.append("{matchUin: ").append(this.jdField_b_of_type_JavaLangString).append("}");
    localStringBuilder.append("{tipsWording: ").append(this.c).append("}");
    localStringBuilder.append("{timeStamp: ").append(this.jdField_a_of_type_Long).append("}");
    localStringBuilder.append("{nickName: ").append(this.d).append("}");
    localStringBuilder.append("{algorithmID: ").append(this.e).append("}");
    localStringBuilder.append("{tagId: ").append(this.jdField_b_of_type_Int).append("}");
    localStringBuilder.append("{tagName: ").append(this.f).append("}");
    if (this.jdField_a_of_type_Arie != null) {
      localStringBuilder.append(this.jdField_a_of_type_Arie.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ariy
 * JD-Core Version:    0.7.0.1
 */