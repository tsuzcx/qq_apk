public class bgjc
  extends bgit
{
  public static bgjc a;
  private int a;
  
  static
  {
    jdField_a_of_type_Bgjc = new bgjc();
  }
  
  public void a(bgfl parambgfl)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 2) {
      download(null, 0, parambgfl, false);
    }
  }
  
  public long getBID()
  {
    return 3L;
  }
  
  protected String getRootDir()
  {
    return "tintconfig";
  }
  
  public String getScid(int paramInt)
  {
    return getScidPrefix();
  }
  
  protected String getScidPrefix()
  {
    return "theme_mapping_config_android";
  }
  
  protected boolean isZip_KeepZip()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjc
 * JD-Core Version:    0.7.0.1
 */