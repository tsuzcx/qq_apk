public class bdwr
  extends bdwi
{
  public static final bdwr a;
  private int a;
  
  static
  {
    jdField_a_of_type_Bdwr = new bdwr();
  }
  
  public void a(bdts parambdts)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 2) {
      download(null, 0, parambdts, false);
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
 * Qualified Name:     bdwr
 * JD-Core Version:    0.7.0.1
 */