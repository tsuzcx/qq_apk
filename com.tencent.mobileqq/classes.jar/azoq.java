import com.tencent.mobileqq.data.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class azoq
  extends ajxl
{
  WeakReference<azon> a;
  
  private azoq(azon paramazon)
  {
    this.a = new WeakReference(paramazon);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    azon localazon = (azon)this.a.get();
    if ((localazon != null) && (paramBoolean) && (paramString != null) && (localazon.a != null) && (localazon.a.size() > 0) && (paramString.equals(((TroopInfo)localazon.a.get(0)).troopuin))) {
      localazon.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azoq
 * JD-Core Version:    0.7.0.1
 */