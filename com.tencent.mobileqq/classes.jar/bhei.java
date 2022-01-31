import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bhei
  implements bgmc<CoverView>
{
  private int jdField_a_of_type_Int = 0;
  private bglv jdField_a_of_type_Bglv;
  private CoverView jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCoverView;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public static bhei a(bglv parambglv)
  {
    bhei localbhei = new bhei();
    localbhei.jdField_a_of_type_Bglv = parambglv;
    return localbhei;
  }
  
  public CoverView a(int paramInt)
  {
    this.jdField_a_of_type_Int = 1;
    this.c = paramInt;
    return (CoverView)this.jdField_a_of_type_Bglv.a(this);
  }
  
  public CoverView a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer))
    {
      QMLog.d("CoverViewAction", "Page is invalid");
      return null;
    }
    parambgls = (AppBrandPageContainer)parambgls;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      QMLog.e("CoverViewAction", "Unknown action");
      for (;;)
      {
        return null;
        return parambgls.a(this.c);
        parambgls.a(this.b, this.c, this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCoverView, this.jdField_a_of_type_Boolean);
      }
      parambgls.a(this.c);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = 3;
    this.c = paramInt;
    this.jdField_a_of_type_Bglv.a(this);
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
    this.jdField_a_of_type_Bglv.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhei
 * JD-Core Version:    0.7.0.1
 */