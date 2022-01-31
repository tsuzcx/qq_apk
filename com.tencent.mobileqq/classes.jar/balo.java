import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;

public class balo
  implements Comparable<balo>
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public balo(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull balo parambalo)
  {
    int i = -1;
    if ((this.f != null) && (parambalo.f != null)) {
      i = this.f.compareTo(parambalo.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (parambalo.f == null);
      return 1;
    } while (parambalo.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     balo
 * JD-Core Version:    0.7.0.1
 */