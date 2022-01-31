import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;

public class bcax
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aoim jdField_a_of_type_Aoim;
  private bcba jdField_a_of_type_Bcba;
  private bcbb jdField_a_of_type_Bcbb;
  private bcbc jdField_a_of_type_Bcbc;
  private bhuf jdField_a_of_type_Bhuf;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private int jdField_b_of_type_Int;
  private bcbc jdField_b_of_type_Bcbc;
  private int c;
  
  public bcax(Context paramContext, aoim paramaoim)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aoim = paramaoim;
  }
  
  public aoim a()
  {
    return this.jdField_a_of_type_Aoim;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhuf == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561005, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Aoim);
      this.jdField_a_of_type_Bhuf = bhuf.c(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bhuf.d(true);
      this.jdField_a_of_type_Bhuf.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bhuf.findViewById(2131361924);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bhuf.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new bcay(this));
      this.jdField_a_of_type_Bhuf.a(new bcaz(this));
    }
    if (!this.jdField_a_of_type_Bhuf.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    try
    {
      this.jdField_a_of_type_Bhuf.show();
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
  
  public void a(bcba parambcba)
  {
    this.jdField_a_of_type_Bcba = parambcba;
  }
  
  public void a(bcbb parambcbb)
  {
    this.jdField_a_of_type_Bcbb = parambcbb;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
      this.jdField_a_of_type_Bhuf.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcax
 * JD-Core Version:    0.7.0.1
 */