import com.tencent.mobileqq.data.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class bbnb
  extends alox
{
  WeakReference<bbmy> a;
  
  private bbnb(bbmy parambbmy)
  {
    this.a = new WeakReference(parambbmy);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    bbmy localbbmy = (bbmy)this.a.get();
    if ((localbbmy != null) && (paramBoolean) && (paramString != null) && (localbbmy.a != null) && (localbbmy.a.size() > 0) && (paramString.equals(((TroopInfo)localbbmy.a.get(0)).troopuin))) {
      localbbmy.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnb
 * JD-Core Version:    0.7.0.1
 */