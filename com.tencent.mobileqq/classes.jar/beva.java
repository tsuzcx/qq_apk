import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class beva
  implements beuz, bevb
{
  private int jdField_a_of_type_Int;
  private final bevb jdField_a_of_type_Bevb;
  private bevc jdField_a_of_type_Bevc;
  private String jdField_a_of_type_JavaLangString;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  beva(bevb parambevb)
  {
    this.jdField_a_of_type_Bevb = parambevb;
  }
  
  private void a()
  {
    bevb localbevb;
    bevc localbevc;
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      if (!this.c)
      {
        localbevb = this.jdField_a_of_type_Bevb;
        localbevc = this.jdField_a_of_type_Bevc;
        if (this.jdField_a_of_type_JavaLangThrowable == null) {
          break label79;
        }
      }
    }
    label79:
    for (String str = this.jdField_a_of_type_JavaLangThrowable.getMessage();; str = "download plugin fail")
    {
      localbevb.onInitGpkgInfo(2022, localbevc, str);
      this.jdField_a_of_type_Bevb.onInitGpkgInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bevc, this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Bevb.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
  }
  
  public void onInitGpkgInfo(int paramInt, bevc parambevc, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Bevc = parambevc;
      this.jdField_a_of_type_JavaLangString = paramString;
      a();
      return;
    }
    finally
    {
      parambevc = finally;
      throw parambevc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beva
 * JD-Core Version:    0.7.0.1
 */