import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;

public class bglk
  implements Comparable<bglk>
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bglk(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull bglk parambglk)
  {
    int i = -1;
    if ((this.f != null) && (parambglk.f != null)) {
      i = this.f.compareTo(parambglk.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (parambglk.f == null);
      return 1;
    } while (parambglk.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglk
 * JD-Core Version:    0.7.0.1
 */