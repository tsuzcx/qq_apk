import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bewq
  implements Observer
{
  bewq(bewm parambewm) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bewm.a(this.a) == null) || (bewm.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bfed));
      paramObservable = (bfed)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bewm.a(this.a);
      bewm.a(this.a).a(bewm.a(this.a).troopUin);
      if (bool)
      {
        bewm.a(this.a).hasSetNewTroopHead = true;
        if (bewm.a(this.a).hasSetNewTroopName) {
          bewm.a(this.a).isNewTroop = false;
        }
        if (bewm.a(this.a).isUseClassAvatar) {
          bewm.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bewm.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bewm.a(this.a).isResume()) {
        break;
      }
      bewm.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bewq
 * JD-Core Version:    0.7.0.1
 */