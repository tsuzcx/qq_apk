public class bhcf
  extends bhbw
{
  public static bhcf a;
  private int a;
  
  static
  {
    jdField_a_of_type_Bhcf = new bhcf();
  }
  
  public void a(bgyv parambgyv)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 2) {
      download(null, 0, parambgyv, false);
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
 * Qualified Name:     bhcf
 * JD-Core Version:    0.7.0.1
 */