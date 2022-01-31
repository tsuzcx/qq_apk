import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class bcot
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private bcow jdField_a_of_type_Bcow;
  private bhpy jdField_a_of_type_Bhpy;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public bcot(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, bcox parambcox)
  {
    if (this.jdField_a_of_type_Bhpy == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560486, null);
      this.jdField_a_of_type_Bhpy = bhpy.c(paramActivity);
      this.jdField_a_of_type_Bhpy.d(true);
      this.jdField_a_of_type_Bhpy.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131378247));
      bcpl localbcpl = new bcpl();
      paramActivity = paramActivity.getResources();
      localbcpl.jdField_a_of_type_Int = 33;
      localbcpl.b = 23;
      localbcpl.c = paramActivity.getColor(2131166988);
      localbcpl.d = 17;
      localbcpl.e = 23;
      localbcpl.f = paramActivity.getColor(2131166901);
      this.jdField_a_of_type_Bcow = new bcow(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Bcow, localbcpl);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new bcou(this));
      paramActivity = localView.findViewById(2131363544);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new bcov(this, parambcox));
      }
    }
    if (!this.jdField_a_of_type_Bhpy.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Bcow.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Bcow.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Bhpy.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcot
 * JD-Core Version:    0.7.0.1
 */