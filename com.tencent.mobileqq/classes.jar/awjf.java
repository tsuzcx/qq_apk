public class awjf
  extends awjg
  implements awjs
{
  public int a;
  public awjd a;
  public awju a;
  public boolean a;
  public boolean b = true;
  
  public awjf()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Awju = new awju();
    this.jdField_a_of_type_Awjd = new awjd();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Awju != null) {}
    for (String str = this.jdField_a_of_type_Awju.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Awjd);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Awju == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Awju.b == 1000) || (this.jdField_a_of_type_Awju.b == 1020) || (this.jdField_a_of_type_Awju.b == 1004)) && (this.jdField_a_of_type_Awju.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Awju.b + ",secondId:" + this.jdField_a_of_type_Awju.d);
      return false;
    }
    if (this.jdField_a_of_type_Awju.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Awju.jdField_g_of_type_Int);
      return false;
    }
    if (!bdhb.b(this.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Awjd == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Awjd.a())
      {
        this.jdField_a_of_type_Awjh = this.jdField_a_of_type_Awjd.jdField_a_of_type_Awjh;
        return false;
      }
    }
    return true;
  }
  
  public awjd getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Awjd;
  }
  
  public awju getPicUploadInfo()
  {
    return this.jdField_a_of_type_Awju;
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
 * Qualified Name:     awjf
 * JD-Core Version:    0.7.0.1
 */