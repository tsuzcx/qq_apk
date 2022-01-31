import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import java.util.Calendar;

public class bctc
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private bctf jdField_a_of_type_Bctf;
  private bhuf jdField_a_of_type_Bhuf;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public bctc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, bctg parambctg)
  {
    if (this.jdField_a_of_type_Bhuf == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560485, null);
      this.jdField_a_of_type_Bhuf = bhuf.c(paramActivity);
      this.jdField_a_of_type_Bhuf.d(true);
      this.jdField_a_of_type_Bhuf.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131378301));
      bctu localbctu = new bctu();
      paramActivity = paramActivity.getResources();
      localbctu.jdField_a_of_type_Int = 33;
      localbctu.b = 23;
      localbctu.c = paramActivity.getColor(2131166990);
      localbctu.d = 17;
      localbctu.e = 23;
      localbctu.f = paramActivity.getColor(2131166903);
      this.jdField_a_of_type_Bctf = new bctf(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Bctf, localbctu);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new bctd(this));
      paramActivity = localView.findViewById(2131363546);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new bcte(this, parambctg));
      }
    }
    if (!this.jdField_a_of_type_Bhuf.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Bctf.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Bctf.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_Bhuf.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctc
 * JD-Core Version:    0.7.0.1
 */