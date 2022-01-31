import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bdpw
  implements bdpv, bdpx
{
  private int jdField_a_of_type_Int;
  private final bdpx jdField_a_of_type_Bdpx;
  private bdpy jdField_a_of_type_Bdpy;
  private String jdField_a_of_type_JavaLangString;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  bdpw(bdpx parambdpx)
  {
    this.jdField_a_of_type_Bdpx = parambdpx;
  }
  
  private void a()
  {
    bdpx localbdpx;
    bdpy localbdpy;
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      if (!this.c)
      {
        localbdpx = this.jdField_a_of_type_Bdpx;
        localbdpy = this.jdField_a_of_type_Bdpy;
        if (this.jdField_a_of_type_JavaLangThrowable == null) {
          break label79;
        }
      }
    }
    label79:
    for (String str = this.jdField_a_of_type_JavaLangThrowable.getMessage();; str = "download plugin fail")
    {
      localbdpx.a(2022, localbdpy, str);
      this.jdField_a_of_type_Bdpx.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bdpy, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  public void a(int paramInt, bdpy parambdpy, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Bdpy = parambdpy;
      this.jdField_a_of_type_JavaLangString = paramString;
      a();
      return;
    }
    finally
    {
      parambdpy = finally;
      throw parambdpy;
    }
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    this.jdField_a_of_type_Bdpx.a(paramMiniAppInfo, paramFloat, paramLong);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpw
 * JD-Core Version:    0.7.0.1
 */