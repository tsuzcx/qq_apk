class bkgq
  implements bapx
{
  bkgq(bkgl parambkgl, bkgx parambkgx, String paramString1, String paramString2) {}
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 3) {
      return;
    }
    if (parambaqw.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = parambaqw.b;
      this.jdField_a_of_type_Bkgx.a(this.jdField_a_of_type_JavaLangString, this.b, bool, parambaqw.jdField_a_of_type_JavaLangString, i);
      return;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bkgx.a(this.jdField_a_of_type_JavaLangString, paramLong2, (float)paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgq
 * JD-Core Version:    0.7.0.1
 */