import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class bfhh
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private bfhk jdField_a_of_type_Bfhk;
  private bjnw jdField_a_of_type_Bjnw;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public bfhh(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, bfhl parambfhl)
  {
    if (this.jdField_a_of_type_Bjnw == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560664, null);
      this.jdField_a_of_type_Bjnw = bjnw.c(paramActivity);
      this.jdField_a_of_type_Bjnw.e(true);
      this.jdField_a_of_type_Bjnw.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131379090));
      bfhz localbfhz = new bfhz();
      paramActivity = paramActivity.getResources();
      localbfhz.jdField_a_of_type_Int = 33;
      localbfhz.b = 23;
      localbfhz.c = paramActivity.getColor(2131167105);
      localbfhz.d = 17;
      localbfhz.e = 23;
      localbfhz.f = paramActivity.getColor(2131167012);
      this.jdField_a_of_type_Bfhk = new bfhk(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Bfhk, localbfhz);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new bfhi(this));
      paramActivity = localView.findViewById(2131363797);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new bfhj(this, parambfhl));
      }
    }
    if (!this.jdField_a_of_type_Bjnw.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Bfhk.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Bfhk.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Bjnw.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhh
 * JD-Core Version:    0.7.0.1
 */