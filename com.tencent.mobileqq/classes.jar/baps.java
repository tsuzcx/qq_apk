import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class baps
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private bapv jdField_a_of_type_Bapv;
  private bfol jdField_a_of_type_Bfol;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public baps(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, bapw parambapw)
  {
    if (this.jdField_a_of_type_Bfol == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560378, null);
      this.jdField_a_of_type_Bfol = bfol.c(paramActivity);
      this.jdField_a_of_type_Bfol.d(true);
      this.jdField_a_of_type_Bfol.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131377706));
      baqk localbaqk = new baqk();
      paramActivity = paramActivity.getResources();
      localbaqk.jdField_a_of_type_Int = 33;
      localbaqk.b = 23;
      localbaqk.c = paramActivity.getColor(2131166940);
      localbaqk.d = 17;
      localbaqk.e = 23;
      localbaqk.f = paramActivity.getColor(2131166854);
      this.jdField_a_of_type_Bapv = new bapv(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Bapv, localbaqk);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new bapt(this));
      paramActivity = localView.findViewById(2131363504);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new bapu(this, parambapw));
      }
    }
    if (!this.jdField_a_of_type_Bfol.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Bapv.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Bapv.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Bfol.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baps
 * JD-Core Version:    0.7.0.1
 */