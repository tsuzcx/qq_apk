import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;

public class bbwo
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aoed jdField_a_of_type_Aoed;
  private bbwr jdField_a_of_type_Bbwr;
  private bbws jdField_a_of_type_Bbws;
  private bbwt jdField_a_of_type_Bbwt;
  private bhpy jdField_a_of_type_Bhpy;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private int jdField_b_of_type_Int;
  private bbwt jdField_b_of_type_Bbwt;
  private int c;
  
  public bbwo(Context paramContext, aoed paramaoed)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aoed = paramaoed;
  }
  
  public aoed a()
  {
    return this.jdField_a_of_type_Aoed;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhpy == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560987, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Aoed);
      this.jdField_a_of_type_Bhpy = bhpy.c(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bhpy.d(true);
      this.jdField_a_of_type_Bhpy.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bhpy.findViewById(2131361924);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bhpy.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new bbwp(this));
      this.jdField_a_of_type_Bhpy.a(new bbwq(this));
    }
    if (!this.jdField_a_of_type_Bhpy.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    try
    {
      this.jdField_a_of_type_Bhpy.show();
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
  
  public void a(bbwr parambbwr)
  {
    this.jdField_a_of_type_Bbwr = parambbwr;
  }
  
  public void a(bbws parambbws)
  {
    this.jdField_a_of_type_Bbws = parambbws;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
      this.jdField_a_of_type_Bhpy.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwo
 * JD-Core Version:    0.7.0.1
 */