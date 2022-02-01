import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;

public class bgbc
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aqxz jdField_a_of_type_Aqxz;
  private bgbf jdField_a_of_type_Bgbf;
  private bgbg jdField_a_of_type_Bgbg;
  private bgbh jdField_a_of_type_Bgbh;
  private blir jdField_a_of_type_Blir;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private int jdField_b_of_type_Int;
  private bgbh jdField_b_of_type_Bgbh;
  private int c;
  
  public bgbc(Context paramContext, aqxz paramaqxz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqxz = paramaqxz;
  }
  
  public aqxz a()
  {
    return this.jdField_a_of_type_Aqxz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561252, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Aqxz);
      this.jdField_a_of_type_Blir = blir.c(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Blir.e(true);
      this.jdField_a_of_type_Blir.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Blir.findViewById(2131361980);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Blir.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new bgbd(this));
      this.jdField_a_of_type_Blir.a(new bgbe(this));
    }
    if (!this.jdField_a_of_type_Blir.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    try
    {
      this.jdField_a_of_type_Blir.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null) {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(paramInt1, paramInt2);
      }
      return;
      this.jdField_a_of_type_Int = paramInt2;
      continue;
      this.jdField_b_of_type_Int = paramInt2;
      continue;
      this.c = paramInt2;
    }
  }
  
  public void a(bgbf parambgbf)
  {
    this.jdField_a_of_type_Bgbf = parambgbf;
  }
  
  public void a(bgbg parambgbg)
  {
    this.jdField_a_of_type_Bgbg = parambgbg;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
      this.jdField_a_of_type_Blir.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbc
 * JD-Core Version:    0.7.0.1
 */