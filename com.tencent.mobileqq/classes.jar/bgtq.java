import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;

public class bgtq
  implements Comparable<bgtq>
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bgtq(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull bgtq parambgtq)
  {
    int i = -1;
    if ((this.f != null) && (parambgtq.f != null)) {
      i = this.f.compareTo(parambgtq.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (parambgtq.f == null);
      return 1;
    } while (parambgtq.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtq
 * JD-Core Version:    0.7.0.1
 */