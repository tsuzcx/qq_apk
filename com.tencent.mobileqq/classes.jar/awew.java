public class awew
  extends awex
  implements awfj
{
  public int a;
  public aweu a;
  public awfl a;
  public boolean a;
  public boolean b = true;
  
  public awew()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Awfl = new awfl();
    this.jdField_a_of_type_Aweu = new aweu();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Awfl != null) {}
    for (String str = this.jdField_a_of_type_Awfl.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Aweu);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Awfl == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Awfl.b == 1000) || (this.jdField_a_of_type_Awfl.b == 1020) || (this.jdField_a_of_type_Awfl.b == 1004)) && (this.jdField_a_of_type_Awfl.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Awfl.b + ",secondId:" + this.jdField_a_of_type_Awfl.d);
      return false;
    }
    if (this.jdField_a_of_type_Awfl.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Awfl.jdField_g_of_type_Int);
      return false;
    }
    if (!bdcs.b(this.jdField_a_of_type_Awfl.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Aweu == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Aweu.a())
      {
        this.jdField_a_of_type_Awey = this.jdField_a_of_type_Aweu.jdField_a_of_type_Awey;
        return false;
      }
    }
    return true;
  }
  
  public aweu getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Aweu;
  }
  
  public awfl getPicUploadInfo()
  {
    return this.jdField_a_of_type_Awfl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awew
 * JD-Core Version:    0.7.0.1
 */