import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bagg
  implements Observer
{
  bagg(bagc parambagc) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bagc.a(this.a) == null) || (bagc.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bamm));
      paramObservable = (bamm)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bagc.a(this.a);
      bagc.a(this.a).a(bagc.a(this.a).troopUin);
      if (bool)
      {
        bagc.a(this.a).hasSetNewTroopHead = true;
        if (bagc.a(this.a).hasSetNewTroopName) {
          bagc.a(this.a).isNewTroop = false;
        }
        if (bagc.a(this.a).isUseClassAvatar) {
          bagc.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bagc.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bagc.a(this.a).isResume()) {
        break;
      }
      bagc.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bagg
 * JD-Core Version:    0.7.0.1
 */