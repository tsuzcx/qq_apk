import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bgec
  implements Observer
{
  bgec(bgdy parambgdy) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bgdy.a(this.a) == null) || (bgdy.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bgmj));
      paramObservable = (bgmj)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bgdy.a(this.a);
      bgdy.a(this.a).a(bgdy.a(this.a).troopUin);
      if (bool)
      {
        bgdy.a(this.a).hasSetNewTroopHead = true;
        if (bgdy.a(this.a).hasSetNewTroopName) {
          bgdy.a(this.a).isNewTroop = false;
        }
        if (bgdy.a(this.a).isUseClassAvatar) {
          bgdy.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bgdy.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bgdy.a(this.a).isResume()) {
        break;
      }
      bgdy.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgec
 * JD-Core Version:    0.7.0.1
 */