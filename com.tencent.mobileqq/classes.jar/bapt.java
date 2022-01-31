import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class bapt
  implements baql
{
  bapt(baps parambaps) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (baps.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (baps.a(this.a) == null) {
        break label288;
      }
      paramInt1 = baps.a(this.a).a(baps.a(this.a), paramInt2);
      int i = baps.a(this.a).a(baps.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      baps.a(this.a).setSelection(1, paramInt2);
      baps.a(this.a).a(1);
      baps.a(this.a).setSelection(2, paramInt1);
      baps.a(this.a).a(2);
      label212:
      do
      {
        baps.a(this.a, baps.a(this.a).a(new int[] { baps.a(this.a).a(0), baps.a(this.a).a(1), baps.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(baps.a(this.a).a(baps.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (baps.a(this.a) != null) {}
      for (paramInt1 = baps.a(this.a).a(baps.a(this.a), baps.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        baps.a(this.a).setSelection(2, paramInt1);
        baps.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bapt
 * JD-Core Version:    0.7.0.1
 */