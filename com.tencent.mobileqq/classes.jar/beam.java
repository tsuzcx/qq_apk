import com.tencent.mobileqq.data.troop.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class beam
  extends amsu
{
  WeakReference<beaj> a;
  
  private beam(beaj parambeaj)
  {
    this.a = new WeakReference(parambeaj);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    beaj localbeaj = (beaj)this.a.get();
    if ((localbeaj != null) && (paramBoolean) && (paramString != null) && (localbeaj.a != null) && (localbeaj.a.size() > 0) && (paramString.equals(((TroopInfo)localbeaj.a.get(0)).troopuin))) {
      localbeaj.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beam
 * JD-Core Version:    0.7.0.1
 */