import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bgul
  implements bguk, bgum
{
  private int jdField_a_of_type_Int;
  private final bgum jdField_a_of_type_Bgum;
  private bgun jdField_a_of_type_Bgun;
  private String jdField_a_of_type_JavaLangString;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  bgul(bgum parambgum)
  {
    this.jdField_a_of_type_Bgum = parambgum;
  }
  
  private void a()
  {
    bgum localbgum;
    bgun localbgun;
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      if (!this.c)
      {
        localbgum = this.jdField_a_of_type_Bgum;
        localbgun = this.jdField_a_of_type_Bgun;
        if (this.jdField_a_of_type_JavaLangThrowable == null) {
          break label79;
        }
      }
    }
    label79:
    for (String str = this.jdField_a_of_type_JavaLangThrowable.getMessage();; str = "download plugin fail")
    {
      localbgum.onInitGpkgInfo(2022, localbgun, str);
      this.jdField_a_of_type_Bgum.onInitGpkgInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bgun, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Throwable paramThrowable)
  {
    try
    {
      this.b = true;
      this.c = paramBoolean;
      this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
      a();
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    this.jdField_a_of_type_Bgum.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
  }
  
  public void onInitGpkgInfo(int paramInt, bgun parambgun, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Bgun = parambgun;
      this.jdField_a_of_type_JavaLangString = paramString;
      a();
      return;
    }
    finally
    {
      parambgun = finally;
      throw parambgun;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgul
 * JD-Core Version:    0.7.0.1
 */