import com.tencent.mobileqq.data.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class bbrk
  extends altm
{
  WeakReference<bbrh> a;
  
  private bbrk(bbrh parambbrh)
  {
    this.a = new WeakReference(parambbrh);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    bbrh localbbrh = (bbrh)this.a.get();
    if ((localbbrh != null) && (paramBoolean) && (paramString != null) && (localbbrh.a != null) && (localbbrh.a.size() > 0) && (paramString.equals(((TroopInfo)localbbrh.a.get(0)).troopuin))) {
      localbbrh.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrk
 * JD-Core Version:    0.7.0.1
 */