public class bbsx
  extends bbso
{
  public static final bbsx a;
  private int a;
  
  static
  {
    jdField_a_of_type_Bbsx = new bbsx();
  }
  
  public void a(bbqb parambbqb)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 2) {
      download(null, 0, parambbqb, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsx
 * JD-Core Version:    0.7.0.1
 */