import com.tencent.mobileqq.utils.FileUtils;

public class aydn
  extends aydo
  implements aydz
{
  public int a;
  public aydl a;
  public ayeb a;
  public boolean a;
  public boolean b = true;
  
  public aydn()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Ayeb = new ayeb();
    this.jdField_a_of_type_Aydl = new aydl();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Ayeb != null) {}
    for (String str = this.jdField_a_of_type_Ayeb.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Aydl);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Ayeb == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Ayeb.b == 1000) || (this.jdField_a_of_type_Ayeb.b == 1020) || (this.jdField_a_of_type_Ayeb.b == 1004)) && (this.jdField_a_of_type_Ayeb.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Ayeb.b + ",secondId:" + this.jdField_a_of_type_Ayeb.d);
      return false;
    }
    if (this.jdField_a_of_type_Ayeb.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Ayeb.jdField_g_of_type_Int);
      return false;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Ayeb.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Aydl == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Aydl.a())
      {
        this.jdField_a_of_type_Aydp = this.jdField_a_of_type_Aydl.jdField_a_of_type_Aydp;
        return false;
      }
    }
    return true;
  }
  
  public aydl getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Aydl;
  }
  
  public ayeb getPicUploadInfo()
  {
    return this.jdField_a_of_type_Ayeb;
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
 * Qualified Name:     aydn
 * JD-Core Version:    0.7.0.1
 */