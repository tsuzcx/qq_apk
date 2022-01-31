import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class baqh
  implements baqz
{
  baqh(baqg parambaqg) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (baqg.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (baqg.a(this.a) == null) {
        break label288;
      }
      paramInt1 = baqg.a(this.a).a(baqg.a(this.a), paramInt2);
      int i = baqg.a(this.a).a(baqg.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      baqg.a(this.a).setSelection(1, paramInt2);
      baqg.a(this.a).a(1);
      baqg.a(this.a).setSelection(2, paramInt1);
      baqg.a(this.a).a(2);
      label212:
      do
      {
        baqg.a(this.a, baqg.a(this.a).a(new int[] { baqg.a(this.a).a(0), baqg.a(this.a).a(1), baqg.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(baqg.a(this.a).a(baqg.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (baqg.a(this.a) != null) {}
      for (paramInt1 = baqg.a(this.a).a(baqg.a(this.a), baqg.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        baqg.a(this.a).setSelection(2, paramInt1);
        baqg.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baqh
 * JD-Core Version:    0.7.0.1
 */