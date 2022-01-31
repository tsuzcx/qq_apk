import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bhab
  implements bghv<CoverView>
{
  private int jdField_a_of_type_Int = 0;
  private bgho jdField_a_of_type_Bgho;
  private CoverView jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCoverView;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public static bhab a(bgho parambgho)
  {
    bhab localbhab = new bhab();
    localbhab.jdField_a_of_type_Bgho = parambgho;
    return localbhab;
  }
  
  public CoverView a(int paramInt)
  {
    this.jdField_a_of_type_Int = 1;
    this.c = paramInt;
    return (CoverView)this.jdField_a_of_type_Bgho.a(this);
  }
  
  public CoverView a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer))
    {
      QMLog.d("CoverViewAction", "Page is invalid");
      return null;
    }
    parambghl = (AppBrandPageContainer)parambghl;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      QMLog.e("CoverViewAction", "Unknown action");
      for (;;)
      {
        return null;
        return parambghl.a(this.c);
        parambghl.a(this.b, this.c, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCoverView, this.jdField_a_of_type_Boolean);
      }
      parambghl.a(this.c);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = 3;
    this.c = paramInt;
    this.jdField_a_of_type_Bgho.a(this);
  }
  
  public void a(int paramInt1, int paramInt2, CoverView paramCoverView)
  {
    a(paramInt1, paramInt2, paramCoverView, false);
  }
  
  public void a(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 2;
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCoverView = paramCoverView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bgho.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhab
 * JD-Core Version:    0.7.0.1
 */