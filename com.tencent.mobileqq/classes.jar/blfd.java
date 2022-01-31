class blfd
  implements bapx
{
  private blfc jdField_a_of_type_Blfc;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  blfd(String paramString1, String paramString2, blfc paramblfc)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Blfc = paramblfc;
  }
  
  public void onResp(baqw parambaqw)
  {
    blfg.b("AEDownloader", "onResp url: " + this.jdField_a_of_type_JavaLangString + " resultcode: " + parambaqw.a);
    if (this.jdField_a_of_type_Blfc != null) {
      this.jdField_a_of_type_Blfc.a(parambaqw);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Blfc != null) {
      this.jdField_a_of_type_Blfc.a((int)((float)paramLong1 / (float)paramLong2) * 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfd
 * JD-Core Version:    0.7.0.1
 */