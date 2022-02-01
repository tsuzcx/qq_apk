class bnyx
  implements bdvw
{
  private bnyw jdField_a_of_type_Bnyw;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  bnyx(String paramString1, String paramString2, bnyw parambnyw)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Bnyw = parambnyw;
  }
  
  public void onResp(bdwt parambdwt)
  {
    bnzb.b("AEDownloader", "onResp url: " + this.jdField_a_of_type_JavaLangString + " resultcode: " + parambdwt.a);
    if (this.jdField_a_of_type_Bnyw != null) {
      this.jdField_a_of_type_Bnyw.a(parambdwt);
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bnyw != null) {
      this.jdField_a_of_type_Bnyw.a((int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyx
 * JD-Core Version:    0.7.0.1
 */