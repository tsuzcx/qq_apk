import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class bgpy
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private bgqb jdField_a_of_type_Bgqb;
  private bkzi jdField_a_of_type_Bkzi;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public bgpy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, bgqc parambgqc)
  {
    if (this.jdField_a_of_type_Bkzi == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560717, null);
      this.jdField_a_of_type_Bkzi = bkzi.c(paramActivity);
      this.jdField_a_of_type_Bkzi.e(true);
      this.jdField_a_of_type_Bkzi.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131379386));
      bgqq localbgqq = new bgqq();
      paramActivity = paramActivity.getResources();
      localbgqq.jdField_a_of_type_Int = 33;
      localbgqq.b = 23;
      localbgqq.c = paramActivity.getColor(2131167119);
      localbgqq.d = 17;
      localbgqq.e = 23;
      localbgqq.f = paramActivity.getColor(2131167026);
      this.jdField_a_of_type_Bgqb = new bgqb(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Bgqb, localbgqq);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new bgpz(this));
      paramActivity = localView.findViewById(2131363869);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new bgqa(this, parambgqc));
      }
    }
    if (!this.jdField_a_of_type_Bkzi.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Bgqb.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Bgqb.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Bkzi.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpy
 * JD-Core Version:    0.7.0.1
 */