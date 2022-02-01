public class ayxr
  extends ayxs
  implements ayye
{
  public int a;
  public ayxp a;
  public ayyg a;
  public boolean a;
  public boolean b = true;
  
  public ayxr()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ayyg = new ayyg();
    this.jdField_a_of_type_Ayxp = new ayxp();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Ayyg != null) {}
    for (String str = this.jdField_a_of_type_Ayyg.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Ayxp);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Ayyg == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Ayyg.b == 1000) || (this.jdField_a_of_type_Ayyg.b == 1020) || (this.jdField_a_of_type_Ayyg.b == 1004)) && (this.jdField_a_of_type_Ayyg.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Ayyg.b + ",secondId:" + this.jdField_a_of_type_Ayyg.d);
      return false;
    }
    if (this.jdField_a_of_type_Ayyg.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Ayyg.jdField_g_of_type_Int);
      return false;
    }
    if (!bgmg.b(this.jdField_a_of_type_Ayyg.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Ayxp == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Ayxp.a())
      {
        this.jdField_a_of_type_Ayxt = this.jdField_a_of_type_Ayxp.jdField_a_of_type_Ayxt;
        return false;
      }
    }
    return true;
  }
  
  public ayxp getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Ayxp;
  }
  
  public ayyg getPicUploadInfo()
  {
    return this.jdField_a_of_type_Ayyg;
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
 * Qualified Name:     ayxr
 * JD-Core Version:    0.7.0.1
 */