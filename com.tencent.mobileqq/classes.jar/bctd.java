import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class bctd
  implements bctv
{
  bctd(bctc parambctc) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (bctc.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (bctc.a(this.a) == null) {
        break label288;
      }
      paramInt1 = bctc.a(this.a).a(bctc.a(this.a), paramInt2);
      int i = bctc.a(this.a).a(bctc.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      bctc.a(this.a).setSelection(1, paramInt2);
      bctc.a(this.a).a(1);
      bctc.a(this.a).setSelection(2, paramInt1);
      bctc.a(this.a).a(2);
      label212:
      do
      {
        bctc.a(this.a, bctc.a(this.a).a(new int[] { bctc.a(this.a).a(0), bctc.a(this.a).a(1), bctc.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(bctc.a(this.a).a(bctc.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (bctc.a(this.a) != null) {}
      for (paramInt1 = bctc.a(this.a).a(bctc.a(this.a), bctc.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        bctc.a(this.a).setSelection(2, paramInt1);
        bctc.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctd
 * JD-Core Version:    0.7.0.1
 */