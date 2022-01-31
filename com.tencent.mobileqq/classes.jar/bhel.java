import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bhel
  implements bgmc<Boolean>
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private bglv jdField_a_of_type_Bglv;
  
  public static bhel a(bglv parambglv)
  {
    bhel localbhel = new bhel();
    localbhel.jdField_a_of_type_Bglv = parambglv;
    return localbhel;
  }
  
  public Boolean a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer))
    {
      QMLog.d("NativeViewAction", "Page is invalid");
      return null;
    }
    parambgls = (AppBrandPageContainer)parambgls;
    boolean bool;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      QMLog.e("NativeViewAction", "Unknown action");
      bool = false;
    }
    for (;;)
    {
      return Boolean.valueOf(bool);
      bool = parambgls.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      continue;
      bool = parambgls.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public boolean a(View paramView)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_AndroidViewView = paramView;
    return ((Boolean)this.jdField_a_of_type_Bglv.a(this)).booleanValue();
  }
  
  public boolean a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = paramLayoutParams;
    return ((Boolean)this.jdField_a_of_type_Bglv.a(this)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhel
 * JD-Core Version:    0.7.0.1
 */