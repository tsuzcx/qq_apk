import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class azoo
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private azor jdField_a_of_type_Azor;
  private begr jdField_a_of_type_Begr;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public azoo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, azos paramazos)
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131494806, null);
      this.jdField_a_of_type_Begr = begr.c(paramActivity);
      this.jdField_a_of_type_Begr.d(true);
      this.jdField_a_of_type_Begr.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131311885));
      azpg localazpg = new azpg();
      paramActivity = paramActivity.getResources();
      localazpg.jdField_a_of_type_Int = 33;
      localazpg.b = 23;
      localazpg.c = paramActivity.getColor(2131101345);
      localazpg.d = 17;
      localazpg.e = 23;
      localazpg.f = paramActivity.getColor(2131101260);
      this.jdField_a_of_type_Azor = new azor(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Azor, localazpg);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new azop(this));
      paramActivity = localView.findViewById(2131297956);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new azoq(this, paramazos));
      }
    }
    if (!this.jdField_a_of_type_Begr.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Azor.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Azor.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Begr.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azoo
 * JD-Core Version:    0.7.0.1
 */