import com.tencent.mobileqq.data.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class azos
  extends ajxj
{
  WeakReference<azop> a;
  
  private azos(azop paramazop)
  {
    this.a = new WeakReference(paramazop);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    azop localazop = (azop)this.a.get();
    if ((localazop != null) && (paramBoolean) && (paramString != null) && (localazop.a != null) && (localazop.a.size() > 0) && (paramString.equals(((TroopInfo)localazop.a.get(0)).troopuin))) {
      localazop.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azos
 * JD-Core Version:    0.7.0.1
 */