import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class bfhx
  extends BaseAdapter
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  public bfhx(WheelPickerLayout paramWheelPickerLayout, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt2, paramWheelPickerLayout.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).a(this.b);
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
      paramView = new WheelTextView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.getContext());
      paramView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
    }
    for (;;)
    {
      String str = WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).a(this.b, paramInt);
      WheelTextView localWheelTextView = (WheelTextView)paramView;
      localWheelTextView.setTextSize(1, WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).b);
      localWheelTextView.setTextColor(WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).c);
      localWheelTextView.setGravity(WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).d);
      localWheelTextView.setText(str);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhx
 * JD-Core Version:    0.7.0.1
 */