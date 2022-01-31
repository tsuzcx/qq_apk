import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bagu
  implements Observer
{
  bagu(bagq parambagq) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bagq.a(this.a) == null) || (bagq.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bana));
      paramObservable = (bana)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bagq.a(this.a);
      bagq.a(this.a).a(bagq.a(this.a).troopUin);
      if (bool)
      {
        bagq.a(this.a).hasSetNewTroopHead = true;
        if (bagq.a(this.a).hasSetNewTroopName) {
          bagq.a(this.a).isNewTroop = false;
        }
        if (bagq.a(this.a).isUseClassAvatar) {
          bagq.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bagq.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bagq.a(this.a).isResume()) {
        break;
      }
      bagq.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bagu
 * JD-Core Version:    0.7.0.1
 */