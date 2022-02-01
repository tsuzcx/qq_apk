import com.tencent.mobileqq.utils.FileUtils;

public class azjz
  extends azka
  implements azkl
{
  public int a;
  public azjx a;
  public azkn a;
  public boolean a;
  public boolean b = true;
  
  public azjz()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Azkn = new azkn();
    this.jdField_a_of_type_Azjx = new azjx();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_a_of_type_Azkn != null) {}
    for (String str = this.jdField_a_of_type_Azkn.a();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Azjx);
      return localStringBuilder.toString();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Azkn == null)
    {
      a("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_a_of_type_Azkn.b == 1000) || (this.jdField_a_of_type_Azkn.b == 1020) || (this.jdField_a_of_type_Azkn.b == 1004)) && (this.jdField_a_of_type_Azkn.d == null))
    {
      a("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_a_of_type_Azkn.b + ",secondId:" + this.jdField_a_of_type_Azkn.d);
      return false;
    }
    if (this.jdField_a_of_type_Azkn.jdField_g_of_type_Int == -1)
    {
      a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_a_of_type_Azkn.jdField_g_of_type_Int);
      return false;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Azjx == null)
      {
        a("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.jdField_a_of_type_Azjx.a())
      {
        this.jdField_a_of_type_Azkb = this.jdField_a_of_type_Azjx.jdField_a_of_type_Azkb;
        return false;
      }
    }
    return true;
  }
  
  public azjx getPicDownloadInfo()
  {
    return this.jdField_a_of_type_Azjx;
  }
  
  public azkn getPicUploadInfo()
  {
    return this.jdField_a_of_type_Azkn;
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
 * Qualified Name:     azjz
 * JD-Core Version:    0.7.0.1
 */