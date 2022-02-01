import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class bfxv
  implements bfyn
{
  bfxv(bfxu parambfxu) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (bfxu.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (bfxu.a(this.a) == null) {
        break label288;
      }
      paramInt1 = bfxu.a(this.a).a(bfxu.a(this.a), paramInt2);
      int i = bfxu.a(this.a).a(bfxu.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      bfxu.a(this.a).setSelection(1, paramInt2);
      bfxu.a(this.a).a(1);
      bfxu.a(this.a).setSelection(2, paramInt1);
      bfxu.a(this.a).a(2);
      label212:
      do
      {
        bfxu.a(this.a, bfxu.a(this.a).a(new int[] { bfxu.a(this.a).a(0), bfxu.a(this.a).a(1), bfxu.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(bfxu.a(this.a).a(bfxu.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (bfxu.a(this.a) != null) {}
      for (paramInt1 = bfxu.a(this.a).a(bfxu.a(this.a), bfxu.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        bfxu.a(this.a).setSelection(2, paramInt1);
        bfxu.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxv
 * JD-Core Version:    0.7.0.1
 */