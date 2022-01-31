import com.tencent.mobileqq.data.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class ayoa
  extends ajjh
{
  WeakReference<aynx> a;
  
  private ayoa(aynx paramaynx)
  {
    this.a = new WeakReference(paramaynx);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    aynx localaynx = (aynx)this.a.get();
    if ((localaynx != null) && (paramBoolean) && (paramString != null) && (localaynx.a != null) && (localaynx.a.size() > 0) && (paramString.equals(((TroopInfo)localaynx.a.get(0)).troopuin))) {
      localaynx.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayoa
 * JD-Core Version:    0.7.0.1
 */