class bgvb
  implements axrt
{
  bgvb(bguw parambguw, bgvi parambgvi, String paramString1, String paramString2) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.jdField_a_of_type_Int == 3) {
      return;
    }
    if (paramaxsq.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramaxsq.b;
      this.jdField_a_of_type_Bgvi.a(this.jdField_a_of_type_JavaLangString, this.b, bool, paramaxsq.jdField_a_of_type_JavaLangString, i);
      return;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bgvi.a(this.jdField_a_of_type_JavaLangString, paramLong2, (float)paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvb
 * JD-Core Version:    0.7.0.1
 */