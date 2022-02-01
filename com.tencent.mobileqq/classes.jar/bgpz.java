import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class bgpz
  implements bgqr
{
  bgpz(bgpy parambgpy) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (bgpy.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (bgpy.a(this.a) == null) {
        break label288;
      }
      paramInt1 = bgpy.a(this.a).a(bgpy.a(this.a), paramInt2);
      int i = bgpy.a(this.a).a(bgpy.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      bgpy.a(this.a).setSelection(1, paramInt2);
      bgpy.a(this.a).a(1);
      bgpy.a(this.a).setSelection(2, paramInt1);
      bgpy.a(this.a).a(2);
      label212:
      do
      {
        bgpy.a(this.a, bgpy.a(this.a).a(new int[] { bgpy.a(this.a).a(0), bgpy.a(this.a).a(1), bgpy.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(bgpy.a(this.a).a(bgpy.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (bgpy.a(this.a) != null) {}
      for (paramInt1 = bgpy.a(this.a).a(bgpy.a(this.a), bgpy.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        bgpy.a(this.a).setSelection(2, paramInt1);
        bgpy.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpz
 * JD-Core Version:    0.7.0.1
 */