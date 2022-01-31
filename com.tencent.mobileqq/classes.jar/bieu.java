class bieu
  implements aysc
{
  bieu(biep parambiep, bifb parambifb, String paramString1, String paramString2) {}
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 3) {
      return;
    }
    if (paramaysz.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramaysz.b;
      this.jdField_a_of_type_Bifb.a(this.jdField_a_of_type_JavaLangString, this.b, bool, paramaysz.jdField_a_of_type_JavaLangString, i);
      return;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bifb.a(this.jdField_a_of_type_JavaLangString, paramLong2, (float)paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bieu
 * JD-Core Version:    0.7.0.1
 */