import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;

public class bckp
  implements Comparable<bckp>
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bckp(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull bckp parambckp)
  {
    int i = -1;
    if ((this.f != null) && (parambckp.f != null)) {
      i = this.f.compareTo(parambckp.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (parambckp.f == null);
      return 1;
    } while (parambckp.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckp
 * JD-Core Version:    0.7.0.1
 */