import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class bgxw
  implements bgyo
{
  bgxw(bgxv parambgxv) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (bgxv.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (bgxv.a(this.a) == null) {
        break label288;
      }
      paramInt1 = bgxv.a(this.a).a(bgxv.a(this.a), paramInt2);
      int i = bgxv.a(this.a).a(bgxv.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      bgxv.a(this.a).setSelection(1, paramInt2);
      bgxv.a(this.a).a(1);
      bgxv.a(this.a).setSelection(2, paramInt1);
      bgxv.a(this.a).a(2);
      label212:
      do
      {
        bgxv.a(this.a, bgxv.a(this.a).a(new int[] { bgxv.a(this.a).a(0), bgxv.a(this.a).a(1), bgxv.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(bgxv.a(this.a).a(bgxv.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (bgxv.a(this.a) != null) {}
      for (paramInt1 = bgxv.a(this.a).a(bgxv.a(this.a), bgxv.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        bgxv.a(this.a).setSelection(2, paramInt1);
        bgxv.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxw
 * JD-Core Version:    0.7.0.1
 */