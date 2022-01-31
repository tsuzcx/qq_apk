import android.text.TextUtils;

public class apyc
{
  public int a;
  public long a;
  public apxk a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "0";
  public String f = "";
  
  public apyc()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 30;
    this.jdField_b_of_type_Int = 1;
  }
  
  public apyc a()
  {
    apyc localapyc = new apyc();
    localapyc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localapyc.jdField_a_of_type_ArrayOfByte = ((byte[])this.jdField_a_of_type_ArrayOfByte.clone());
    localapyc.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localapyc.c = this.c;
    localapyc.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localapyc.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localapyc.e = this.e;
    return localapyc;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = bdal.a("");
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.e = "0";
    this.jdField_b_of_type_Int = 0;
    this.f = "";
    this.jdField_a_of_type_Apxk = null;
  }
  
  public boolean a()
  {
    String str = bdal.a(this.jdField_a_of_type_ArrayOfByte);
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
      } while (!(paramObject instanceof apyc));
      paramObject = (apyc)paramObject;
    } while ((!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    String str = bdal.a(this.jdField_a_of_type_ArrayOfByte);
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
    if (this.jdField_a_of_type_Apxk != null) {
      localStringBuilder.append(this.jdField_a_of_type_Apxk.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyc
 * JD-Core Version:    0.7.0.1
 */