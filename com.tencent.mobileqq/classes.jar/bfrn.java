import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;

public class bfrn
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aqul jdField_a_of_type_Aqul;
  private bfrq jdField_a_of_type_Bfrq;
  private bfrr jdField_a_of_type_Bfrr;
  private bfrs jdField_a_of_type_Bfrs;
  private bkzi jdField_a_of_type_Bkzi;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private int jdField_b_of_type_Int;
  private bfrs jdField_b_of_type_Bfrs;
  private int c;
  
  public bfrn(Context paramContext, aqul paramaqul)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqul = paramaqul;
  }
  
  public aqul a()
  {
    return this.jdField_a_of_type_Aqul;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561188, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Aqul);
      this.jdField_a_of_type_Bkzi = bkzi.c(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bkzi.e(true);
      this.jdField_a_of_type_Bkzi.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bkzi.findViewById(2131361981);
      ((DispatchActionMoveScrollView)localObject).dispatchActionMove = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bkzi.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new bfro(this));
      this.jdField_a_of_type_Bkzi.a(new bfrp(this));
    }
    if (!this.jdField_a_of_type_Bkzi.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    try
    {
      this.jdField_a_of_type_Bkzi.show();
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
  
  public void a(bfrq parambfrq)
  {
    this.jdField_a_of_type_Bfrq = parambfrq;
  }
  
  public void a(bfrr parambfrr)
  {
    this.jdField_a_of_type_Bfrr = parambfrr;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      this.jdField_a_of_type_Bkzi.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrn
 * JD-Core Version:    0.7.0.1
 */