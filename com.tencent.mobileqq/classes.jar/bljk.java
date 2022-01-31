class bljk
  implements baug
{
  private bljj jdField_a_of_type_Bljj;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  bljk(String paramString1, String paramString2, bljj parambljj)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Bljj = parambljj;
  }
  
  public void onResp(bavf parambavf)
  {
    bljn.b("AEDownloader", "onResp url: " + this.jdField_a_of_type_JavaLangString + " resultcode: " + parambavf.a);
    if (this.jdField_a_of_type_Bljj != null) {
      this.jdField_a_of_type_Bljj.a(parambavf);
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bljj != null) {
      this.jdField_a_of_type_Bljj.a((int)((float)paramLong1 / (float)paramLong2) * 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljk
 * JD-Core Version:    0.7.0.1
 */