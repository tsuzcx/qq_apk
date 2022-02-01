import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;

public class bekk
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private apri jdField_a_of_type_Apri;
  private bekn jdField_a_of_type_Bekn;
  private beko jdField_a_of_type_Beko;
  private bekp jdField_a_of_type_Bekp;
  private bjnw jdField_a_of_type_Bjnw;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private int jdField_b_of_type_Int;
  private bekp jdField_b_of_type_Bekp;
  private int c;
  
  public bekk(Context paramContext, apri paramapri)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Apri = paramapri;
  }
  
  public apri a()
  {
    return this.jdField_a_of_type_Apri;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjnw == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561127, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Apri);
      this.jdField_a_of_type_Bjnw = bjnw.c(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bjnw.e(true);
      this.jdField_a_of_type_Bjnw.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bjnw.findViewById(2131361979);
      ((DispatchActionMoveScrollView)localObject).dispatchActionMove = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bjnw.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new bekl(this));
      this.jdField_a_of_type_Bjnw.a(new bekm(this));
    }
    if (!this.jdField_a_of_type_Bjnw.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    try
    {
      this.jdField_a_of_type_Bjnw.show();
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
  
  public void a(bekn parambekn)
  {
    this.jdField_a_of_type_Bekn = parambekn;
  }
  
  public void a(beko parambeko)
  {
    this.jdField_a_of_type_Beko = parambeko;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bjnw != null) && (this.jdField_a_of_type_Bjnw.isShowing())) {
      this.jdField_a_of_type_Bjnw.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekk
 * JD-Core Version:    0.7.0.1
 */