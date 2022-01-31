import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class bcou
  implements bcpm
{
  bcou(bcot parambcot) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (bcot.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (bcot.a(this.a) == null) {
        break label288;
      }
      paramInt1 = bcot.a(this.a).a(bcot.a(this.a), paramInt2);
      int i = bcot.a(this.a).a(bcot.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      bcot.a(this.a).setSelection(1, paramInt2);
      bcot.a(this.a).a(1);
      bcot.a(this.a).setSelection(2, paramInt1);
      bcot.a(this.a).a(2);
      label212:
      do
      {
        bcot.a(this.a, bcot.a(this.a).a(new int[] { bcot.a(this.a).a(0), bcot.a(this.a).a(1), bcot.a(this.a).a(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(bcot.a(this.a).a(bcot.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (bcot.a(this.a) != null) {}
      for (paramInt1 = bcot.a(this.a).a(bcot.a(this.a), bcot.a(this.a).a(0), paramInt2);; paramInt1 = 0)
      {
        bcot.a(this.a).setSelection(2, paramInt1);
        bcot.a(this.a).a(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcou
 * JD-Core Version:    0.7.0.1
 */