import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class aqut
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private int b;
  
  public aqut(TimeSelectView paramTimeSelectView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt2, paramTimeSelectView.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView).a(this.b);
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
      paramView = new WheelTextView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.getContext());
      paramView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimeSelectView", 2, "getView column:" + this.b + ", position: " + paramInt);
      }
      String str = TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView).a(this.b, paramInt);
      Object localObject = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.getContext(), TimeSelectView.a());
      if (QLog.isColorLevel()) {
        QLog.d("TimeSelectView", 2, "view height 33dp -> " + ((ViewGroup.LayoutParams)localObject).height + "px");
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (WheelTextView)paramView;
      ((WheelTextView)localObject).setTextSize(20.0F);
      ((WheelTextView)localObject).setTextColor(TimeSelectView.jdField_a_of_type_Int);
      if (TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView)[0].getId() == paramViewGroup.getId()) {
        ((WheelTextView)localObject).setGravity(8388613);
      }
      for (;;)
      {
        ((WheelTextView)localObject).setText(str);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        ((WheelTextView)localObject).setGravity(8388611);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqut
 * JD-Core Version:    0.7.0.1
 */