class beqh
  implements beqo
{
  beqh(beqf parambeqf, beqo parambeqo) {}
  
  public void a(int paramInt, String paramString, beqm parambeqm)
  {
    try
    {
      if (this.jdField_a_of_type_Beqo != null) {
        this.jdField_a_of_type_Beqo.a(paramInt, paramString, parambeqm);
      }
      if (paramInt != 0) {
        this.jdField_a_of_type_Beqf.a(parambeqm);
      }
      return;
    }
    catch (Throwable paramString)
    {
      betc.d("minisdk-start_AppRuntimeLoaderManager", "runtime load result exception!", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqh
 * JD-Core Version:    0.7.0.1
 */