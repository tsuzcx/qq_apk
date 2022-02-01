public class azqf
  extends azqg
  implements azqr
{
  public int a;
  public azqd a;
  public azqt a;
  public boolean a;
  public boolean b = true;
  
  public azqf()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Azqt = new azqt();
    this.jdField_a_of_type_Azqd = new azqd();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Azqt != null) {}
    for (String str = this.jdField_a_of_type_Azqt.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Azqd);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Azqt == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Azqt.b == 1000) || (this.jdField_a_of_type_Azqt.b == 1020) || (this.jdField_a_of_type_Azqt.b == 1004)) && (this.jdField_a_of_type_Azqt.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Azqt.b + ",secondId:" + this.jdField_a_of_type_Azqt.d);
      return false;
    }
    if (this.jdField_a_of_type_Azqt.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Azqt.jdField_g_of_type_Int);
      return false;
    }
    if (!bhmi.b(this.jdField_a_of_type_Azqt.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Azqd == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Azqd.a())
      {
        this.jdField_a_of_type_Azqh = this.jdField_a_of_type_Azqd.jdField_a_of_type_Azqh;
        return false;
      }
    }
    return true;
  }
  
  public azqd getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Azqd;
  }
  
  public azqt getPicUploadInfo()
  {
    return this.jdField_a_of_type_Azqt;
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
 * Qualified Name:     azqf
 * JD-Core Version:    0.7.0.1
 */