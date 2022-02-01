import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class bfxu
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private bfxx jdField_a_of_type_Bfxx;
  private bkho jdField_a_of_type_Bkho;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public bfxu(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, bfxy parambfxy)
  {
    if (this.jdField_a_of_type_Bkho == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560639, null);
      this.jdField_a_of_type_Bkho = bkho.c(paramActivity);
      this.jdField_a_of_type_Bkho.e(true);
      this.jdField_a_of_type_Bkho.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131379156));
      bfym localbfym = new bfym();
      paramActivity = paramActivity.getResources();
      localbfym.jdField_a_of_type_Int = 33;
      localbfym.b = 23;
      localbfym.c = paramActivity.getColor(2131167073);
      localbfym.d = 17;
      localbfym.e = 23;
      localbfym.f = paramActivity.getColor(2131166986);
      this.jdField_a_of_type_Bfxx = new bfxx(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Bfxx, localbfym);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new bfxv(this));
      paramActivity = localView.findViewById(2131363744);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new bfxw(this, parambfxy));
      }
    }
    if (!this.jdField_a_of_type_Bkho.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Bfxx.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Bfxx.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Bkho.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxu
 * JD-Core Version:    0.7.0.1
 */