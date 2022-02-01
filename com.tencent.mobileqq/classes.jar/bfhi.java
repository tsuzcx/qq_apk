import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class bfhi
  implements bfia
{
  bfhi(bfhh parambfhh) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (bfhh.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (bfhh.a(this.a) == null) {
        break label288;
      }
      paramInt1 = bfhh.a(this.a).a(bfhh.a(this.a), paramInt2);
      int i = bfhh.a(this.a).a(bfhh.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      bfhh.a(this.a).setSelection(1, paramInt2);
      bfhh.a(this.a).a(1);
      bfhh.a(this.a).setSelection(2, paramInt1);
      bfhh.a(this.a).a(2);
      label212:
      do
      {
        bfhh.a(this.a, bfhh.a(this.a).a(new int[] { bfhh.a(this.a).a(0), bfhh.a(this.a).a(1), bfhh.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(bfhh.a(this.a).a(bfhh.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (bfhh.a(this.a) != null) {}
      for (paramInt1 = bfhh.a(this.a).a(bfhh.a(this.a), bfhh.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        bfhh.a(this.a).setSelection(2, paramInt1);
        bfhh.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhi
 * JD-Core Version:    0.7.0.1
 */