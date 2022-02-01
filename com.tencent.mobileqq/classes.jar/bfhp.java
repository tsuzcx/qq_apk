import com.tencent.mobileqq.data.troop.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class bfhp
  extends anvi
{
  WeakReference<bfhm> a;
  
  private bfhp(bfhm parambfhm)
  {
    this.a = new WeakReference(parambfhm);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    bfhm localbfhm = (bfhm)this.a.get();
    if ((localbfhm != null) && (paramBoolean) && (paramString != null) && (localbfhm.a != null) && (localbfhm.a.size() > 0) && (paramString.equals(((TroopInfo)localbfhm.a.get(0)).troopuin))) {
      localbfhm.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhp
 * JD-Core Version:    0.7.0.1
 */