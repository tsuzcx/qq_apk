public class aunn
  extends auno
  implements auoa
{
  public int a;
  public aunl a;
  public auob a;
  public boolean a;
  public boolean b = true;
  
  public aunn()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Auob = new auob();
    this.jdField_a_of_type_Aunl = new aunl();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Auob != null) {}
    for (String str = this.jdField_a_of_type_Auob.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Aunl);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Auob == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Auob.b == 1000) || (this.jdField_a_of_type_Auob.b == 1020) || (this.jdField_a_of_type_Auob.b == 1004)) && (this.jdField_a_of_type_Auob.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Auob.b + ",secondId:" + this.jdField_a_of_type_Auob.d);
      return false;
    }
    if (this.jdField_a_of_type_Auob.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Auob.jdField_g_of_type_Int);
      return false;
    }
    if (!bbdj.b(this.jdField_a_of_type_Auob.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Aunl == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Aunl.a())
      {
        this.jdField_a_of_type_Aunp = this.jdField_a_of_type_Aunl.jdField_a_of_type_Aunp;
        return false;
      }
    }
    return true;
  }
  
  public aunl getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Aunl;
  }
  
  public auob getPicUploadInfo()
  {
    return this.jdField_a_of_type_Auob;
  }
  
  public boolean isSendFromLocal()
  {
    return this.b;
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunn
 * JD-Core Version:    0.7.0.1
 */