import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bevr
  implements bevq, bevs
{
  private int jdField_a_of_type_Int;
  private final bevs jdField_a_of_type_Bevs;
  private bevt jdField_a_of_type_Bevt;
  private String jdField_a_of_type_JavaLangString;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  bevr(bevs parambevs)
  {
    this.jdField_a_of_type_Bevs = parambevs;
  }
  
  private void a()
  {
    bevs localbevs;
    bevt localbevt;
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      if (!this.c)
      {
        localbevs = this.jdField_a_of_type_Bevs;
        localbevt = this.jdField_a_of_type_Bevt;
        if (this.jdField_a_of_type_JavaLangThrowable == null) {
          break label79;
        }
      }
    }
    label79:
    for (String str = this.jdField_a_of_type_JavaLangThrowable.getMessage();; str = "download plugin fail")
    {
      localbevs.onInitGpkgInfo(2022, localbevt, str);
      this.jdField_a_of_type_Bevs.onInitGpkgInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bevt, this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Bevs.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
  }
  
  public void onInitGpkgInfo(int paramInt, bevt parambevt, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Bevt = parambevt;
      this.jdField_a_of_type_JavaLangString = paramString;
      a();
      return;
    }
    finally
    {
      parambevt = finally;
      throw parambevt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevr
 * JD-Core Version:    0.7.0.1
 */