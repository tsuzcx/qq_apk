public class atpp
  extends atpq
  implements atqc
{
  public int a;
  public atpn a;
  public atqd a;
  public boolean a;
  public boolean b = true;
  
  public atpp()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Atqd = new atqd();
    this.jdField_a_of_type_Atpn = new atpn();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Atqd != null) {}
    for (String str = this.jdField_a_of_type_Atqd.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Atpn);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Atqd == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Atqd.b == 1000) || (this.jdField_a_of_type_Atqd.b == 1020) || (this.jdField_a_of_type_Atqd.b == 1004)) && (this.jdField_a_of_type_Atqd.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Atqd.b + ",secondId:" + this.jdField_a_of_type_Atqd.d);
      return false;
    }
    if (this.jdField_a_of_type_Atqd.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Atqd.jdField_g_of_type_Int);
      return false;
    }
    if (!bace.b(this.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Atpn == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Atpn.a())
      {
        this.jdField_a_of_type_Atpr = this.jdField_a_of_type_Atpn.jdField_a_of_type_Atpr;
        return false;
      }
    }
    return true;
  }
  
  public atpn getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Atpn;
  }
  
  public atqd getPicUploadInfo()
  {
    return this.jdField_a_of_type_Atqd;
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
 * Qualified Name:     atpp
 * JD-Core Version:    0.7.0.1
 */