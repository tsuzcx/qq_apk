class bpai
  implements beuq
{
  private bpah jdField_a_of_type_Bpah;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  bpai(String paramString1, String paramString2, bpah parambpah)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Bpah = parambpah;
  }
  
  public void onResp(bevm parambevm)
  {
    bpam.b("AEDownloader", "onResp url: " + this.jdField_a_of_type_JavaLangString + " resultcode: " + parambevm.a);
    if (this.jdField_a_of_type_Bpah != null) {
      this.jdField_a_of_type_Bpah.a(parambevm);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bpah != null) {
      this.jdField_a_of_type_Bpah.a((int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpai
 * JD-Core Version:    0.7.0.1
 */