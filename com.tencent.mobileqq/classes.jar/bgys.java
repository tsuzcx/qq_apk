import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bgys
  implements bgyr, bgyt
{
  private int jdField_a_of_type_Int;
  private final bgyt jdField_a_of_type_Bgyt;
  private bgyu jdField_a_of_type_Bgyu;
  private String jdField_a_of_type_JavaLangString;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  bgys(bgyt parambgyt)
  {
    this.jdField_a_of_type_Bgyt = parambgyt;
  }
  
  private void a()
  {
    bgyt localbgyt;
    bgyu localbgyu;
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      if (!this.c)
      {
        localbgyt = this.jdField_a_of_type_Bgyt;
        localbgyu = this.jdField_a_of_type_Bgyu;
        if (this.jdField_a_of_type_JavaLangThrowable == null) {
          break label79;
        }
      }
    }
    label79:
    for (String str = this.jdField_a_of_type_JavaLangThrowable.getMessage();; str = "download plugin fail")
    {
      localbgyt.onInitGpkgInfo(2022, localbgyu, str);
      this.jdField_a_of_type_Bgyt.onInitGpkgInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bgyu, this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Bgyt.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
  }
  
  public void onInitGpkgInfo(int paramInt, bgyu parambgyu, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Bgyu = parambgyu;
      this.jdField_a_of_type_JavaLangString = paramString;
      a();
      return;
    }
    finally
    {
      parambgyu = finally;
      throw parambgyu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgys
 * JD-Core Version:    0.7.0.1
 */