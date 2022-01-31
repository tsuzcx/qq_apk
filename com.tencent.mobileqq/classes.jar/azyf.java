import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;

public class azyf
{
  private int jdField_a_of_type_Int;
  private amnf jdField_a_of_type_Amnf;
  private Context jdField_a_of_type_AndroidContentContext;
  private azyi jdField_a_of_type_Azyi;
  private azyj jdField_a_of_type_Azyj;
  private azyk jdField_a_of_type_Azyk;
  private bfpc jdField_a_of_type_Bfpc;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private int jdField_b_of_type_Int;
  private azyk jdField_b_of_type_Azyk;
  private int c;
  
  public azyf(Context paramContext, amnf paramamnf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amnf = paramamnf;
  }
  
  public amnf a()
  {
    return this.jdField_a_of_type_Amnf;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfpc == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560804, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Amnf);
      this.jdField_a_of_type_Bfpc = bfpc.c(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bfpc.d(true);
      this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bfpc.findViewById(2131361922);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bfpc.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new azyg(this));
      this.jdField_a_of_type_Bfpc.a(new azyh(this));
    }
    if (!this.jdField_a_of_type_Bfpc.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    try
    {
      this.jdField_a_of_type_Bfpc.show();
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
  
  public void a(azyi paramazyi)
  {
    this.jdField_a_of_type_Azyi = paramazyi;
  }
  
  public void a(azyj paramazyj)
  {
    this.jdField_a_of_type_Azyj = paramazyj;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
      this.jdField_a_of_type_Bfpc.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azyf
 * JD-Core Version:    0.7.0.1
 */