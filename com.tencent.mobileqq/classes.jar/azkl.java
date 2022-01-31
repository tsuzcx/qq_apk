import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;

public class azkl
  implements Comparable<azkl>
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public azkl(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull azkl paramazkl)
  {
    int i = -1;
    if ((this.f != null) && (paramazkl.f != null)) {
      i = this.f.compareTo(paramazkl.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (paramazkl.f == null);
      return 1;
    } while (paramazkl.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkl
 * JD-Core Version:    0.7.0.1
 */