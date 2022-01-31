class bepq
  implements bepx
{
  bepq(bepo parambepo, bepx parambepx) {}
  
  public void a(int paramInt, String paramString, bepv parambepv)
  {
    try
    {
      if (this.jdField_a_of_type_Bepx != null) {
        this.jdField_a_of_type_Bepx.a(paramInt, paramString, parambepv);
      }
      if (paramInt != 0) {
        this.jdField_a_of_type_Bepo.a(parambepv);
      }
      return;
    }
    catch (Throwable paramString)
    {
      besl.d("minisdk-start_AppRuntimeLoaderManager", "runtime load result exception!", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepq
 * JD-Core Version:    0.7.0.1
 */