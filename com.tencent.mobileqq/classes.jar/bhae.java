import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bhae
  implements bghv<Boolean>
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private bgho jdField_a_of_type_Bgho;
  
  public static bhae a(bgho parambgho)
  {
    bhae localbhae = new bhae();
    localbhae.jdField_a_of_type_Bgho = parambgho;
    return localbhae;
  }
  
  public Boolean a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer))
    {
      QMLog.d("NativeViewAction", "Page is invalid");
      return null;
    }
    parambghl = (AppBrandPageContainer)parambghl;
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
      bool = parambghl.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      continue;
      bool = parambghl.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public boolean a(View paramView)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_AndroidViewView = paramView;
    return ((Boolean)this.jdField_a_of_type_Bgho.a(this)).booleanValue();
  }
  
  public boolean a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = paramLayoutParams;
    return ((Boolean)this.jdField_a_of_type_Bgho.a(this)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhae
 * JD-Core Version:    0.7.0.1
 */