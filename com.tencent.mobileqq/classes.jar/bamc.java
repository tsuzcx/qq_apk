import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;

public class bamc
  implements Comparable<bamc>
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bamc(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull bamc parambamc)
  {
    int i = -1;
    if ((this.f != null) && (parambamc.f != null)) {
      i = this.f.compareTo(parambamc.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (parambamc.f == null);
      return 1;
    } while (parambamc.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bamc
 * JD-Core Version:    0.7.0.1
 */