import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;
import java.util.Calendar;

public class auia
  implements aoim
{
  private auia(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return MsgBackupDateFragment.c(this.a) - MsgBackupDateFragment.d(this.a) + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    if (MsgBackupDateFragment.b(this.a) == 1)
    {
      localCalendar.set(1, MsgBackupDateFragment.e(this.a) + MsgBackupDateFragment.d(this.a));
      localCalendar.set(2, MsgBackupDateFragment.f(this.a));
      localCalendar.set(5, 1);
    }
    for (;;)
    {
      return localCalendar.getActualMaximum(5);
      localCalendar.set(1, MsgBackupDateFragment.g(this.a) + MsgBackupDateFragment.d(this.a));
      localCalendar.set(2, MsgBackupDateFragment.h(this.a));
      localCalendar.set(5, 1);
    }
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return MsgBackupDateFragment.d(this.a) + paramInt2 + alud.a(2131707316);
    case 1: 
      return paramInt2 + 1 + alud.a(2131707299);
    }
    return paramInt2 + 1 + alud.a(2131707315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auia
 * JD-Core Version:    0.7.0.1
 */