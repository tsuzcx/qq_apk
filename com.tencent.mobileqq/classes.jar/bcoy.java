import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;

public class bcoy
  implements Comparable<bcoy>
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bcoy(TroopNameHelper.GenTroopNameTask paramGenTroopNameTask) {}
  
  public int a(@NonNull bcoy parambcoy)
  {
    int i = -1;
    if ((this.f != null) && (parambcoy.f != null)) {
      i = this.f.compareTo(parambcoy.f);
    }
    do
    {
      do
      {
        return i;
        if (this.f != null) {
          break;
        }
      } while (parambcoy.f == null);
      return 1;
    } while (parambcoy.f == null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoy
 * JD-Core Version:    0.7.0.1
 */