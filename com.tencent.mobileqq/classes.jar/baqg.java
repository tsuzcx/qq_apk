import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class baqg
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private baqj jdField_a_of_type_Baqj;
  private bfpc jdField_a_of_type_Bfpc;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public baqg(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, baqk parambaqk)
  {
    if (this.jdField_a_of_type_Bfpc == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560378, null);
      this.jdField_a_of_type_Bfpc = bfpc.c(paramActivity);
      this.jdField_a_of_type_Bfpc.d(true);
      this.jdField_a_of_type_Bfpc.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131377706));
      baqy localbaqy = new baqy();
      paramActivity = paramActivity.getResources();
      localbaqy.jdField_a_of_type_Int = 33;
      localbaqy.b = 23;
      localbaqy.c = paramActivity.getColor(2131166940);
      localbaqy.d = 17;
      localbaqy.e = 23;
      localbaqy.f = paramActivity.getColor(2131166854);
      this.jdField_a_of_type_Baqj = new baqj(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Baqj, localbaqy);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new baqh(this));
      paramActivity = localView.findViewById(2131363503);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new baqi(this, parambaqk));
      }
    }
    if (!this.jdField_a_of_type_Bfpc.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Baqj.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Baqj.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Bfpc.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baqg
 * JD-Core Version:    0.7.0.1
 */