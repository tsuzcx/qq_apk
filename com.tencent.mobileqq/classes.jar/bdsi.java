public class bdsi
  extends bdrz
{
  public static final bdsi a;
  private int a;
  
  static
  {
    jdField_a_of_type_Bdsi = new bdsi();
  }
  
  public void a(bdpj parambdpj)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 2) {
      download(null, 0, parambdpj, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsi
 * JD-Core Version:    0.7.0.1
 */