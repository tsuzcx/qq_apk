import android.text.TextUtils;

public class aqcl
{
  public int a;
  public long a;
  public aqbt a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "0";
  public String f = "";
  
  public aqcl()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 30;
    this.jdField_b_of_type_Int = 1;
  }
  
  public aqcl a()
  {
    aqcl localaqcl = new aqcl();
    localaqcl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localaqcl.jdField_a_of_type_ArrayOfByte = ((byte[])this.jdField_a_of_type_ArrayOfByte.clone());
    localaqcl.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localaqcl.c = this.c;
    localaqcl.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localaqcl.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localaqcl.e = this.e;
    return localaqcl;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = bdeu.a("");
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.e = "0";
    this.jdField_b_of_type_Int = 0;
    this.f = "";
    this.jdField_a_of_type_Aqbt = null;
  }
  
  public boolean a()
  {
    String str = bdeu.a(this.jdField_a_of_type_ArrayOfByte);
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
      } while (!(paramObject instanceof aqcl));
      paramObject = (aqcl)paramObject;
    } while ((!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    String str = bdeu.a(this.jdField_a_of_type_ArrayOfByte);
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
    if (this.jdField_a_of_type_Aqbt != null) {
      localStringBuilder.append(this.jdField_a_of_type_Aqbt.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcl
 * JD-Core Version:    0.7.0.1
 */