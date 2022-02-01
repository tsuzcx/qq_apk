import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bfnd
  implements Observer
{
  bfnd(bfmz parambfmz) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bfmz.a(this.a) == null) || (bfmz.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bfuo));
      paramObservable = (bfuo)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bfmz.a(this.a);
      bfmz.a(this.a).a(bfmz.a(this.a).troopUin);
      if (bool)
      {
        bfmz.a(this.a).hasSetNewTroopHead = true;
        if (bfmz.a(this.a).hasSetNewTroopName) {
          bfmz.a(this.a).isNewTroop = false;
        }
        if (bfmz.a(this.a).isUseClassAvatar) {
          bfmz.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bfmz.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bfmz.a(this.a).isResume()) {
        break;
      }
      bfmz.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnd
 * JD-Core Version:    0.7.0.1
 */