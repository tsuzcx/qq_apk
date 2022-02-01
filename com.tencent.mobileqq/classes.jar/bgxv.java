import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class bgxv
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private bgxy jdField_a_of_type_Bgxy;
  private blir jdField_a_of_type_Blir;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public bgxv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, bgxz parambgxz)
  {
    if (this.jdField_a_of_type_Blir == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560654, null);
      this.jdField_a_of_type_Blir = blir.c(paramActivity);
      this.jdField_a_of_type_Blir.e(true);
      this.jdField_a_of_type_Blir.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131379320));
      bgyn localbgyn = new bgyn();
      paramActivity = paramActivity.getResources();
      localbgyn.jdField_a_of_type_Int = 33;
      localbgyn.b = 23;
      localbgyn.c = paramActivity.getColor(2131167083);
      localbgyn.d = 17;
      localbgyn.e = 23;
      localbgyn.f = paramActivity.getColor(2131166990);
      this.jdField_a_of_type_Bgxy = new bgxy(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Bgxy, localbgyn);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new bgxw(this));
      paramActivity = localView.findViewById(2131363768);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new bgxx(this, parambgxz));
      }
    }
    if (!this.jdField_a_of_type_Blir.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Bgxy.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Bgxy.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Blir.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxv
 * JD-Core Version:    0.7.0.1
 */