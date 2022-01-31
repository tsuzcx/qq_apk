public class aunp
  extends aunq
  implements auoc
{
  public int a;
  public aunn a;
  public auod a;
  public boolean a;
  public boolean b = true;
  
  public aunp()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Auod = new auod();
    this.jdField_a_of_type_Aunn = new aunn();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Auod != null) {}
    for (String str = this.jdField_a_of_type_Auod.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Aunn);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Auod == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Auod.b == 1000) || (this.jdField_a_of_type_Auod.b == 1020) || (this.jdField_a_of_type_Auod.b == 1004)) && (this.jdField_a_of_type_Auod.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Auod.b + ",secondId:" + this.jdField_a_of_type_Auod.d);
      return false;
    }
    if (this.jdField_a_of_type_Auod.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Auod.jdField_g_of_type_Int);
      return false;
    }
    if (!bbdx.b(this.jdField_a_of_type_Auod.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Aunn == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Aunn.a())
      {
        this.jdField_a_of_type_Aunr = this.jdField_a_of_type_Aunn.jdField_a_of_type_Aunr;
        return false;
      }
    }
    return true;
  }
  
  public aunn getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Aunn;
  }
  
  public auod getPicUploadInfo()
  {
    return this.jdField_a_of_type_Auod;
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
 * Qualified Name:     aunp
 * JD-Core Version:    0.7.0.1
 */