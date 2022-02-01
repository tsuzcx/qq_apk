import com.tencent.mobileqq.data.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class berv
  extends anmu
{
  WeakReference<bers> a;
  
  private berv(bers parambers)
  {
    this.a = new WeakReference(parambers);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    bers localbers = (bers)this.a.get();
    if ((localbers != null) && (paramBoolean) && (paramString != null) && (localbers.a != null) && (localbers.a.size() > 0) && (paramString.equals(((TroopInfo)localbers.a.get(0)).troopuin))) {
      localbers.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berv
 * JD-Core Version:    0.7.0.1
 */