import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class aoik
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private int b;
  
  public aoik(IphonePickerView paramIphonePickerView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt2, paramIphonePickerView.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).a(this.b);
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new WheelTextView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.getContext());
      paramView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
    }
    for (;;)
    {
      paramViewGroup = IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).a(this.b, paramInt);
      WheelTextView localWheelTextView = (WheelTextView)paramView;
      localWheelTextView.setTextSize(20.0F);
      localWheelTextView.setTextColor(IphonePickerView.jdField_a_of_type_Int);
      localWheelTextView.setGravity(17);
      localWheelTextView.setText(paramViewGroup);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoik
 * JD-Core Version:    0.7.0.1
 */