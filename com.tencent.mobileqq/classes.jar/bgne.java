import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bgne
  implements Observer
{
  bgne(bgna parambgna) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bgna.a(this.a) == null) || (bgna.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bgup));
      paramObservable = (bgup)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bgna.a(this.a);
      bgna.a(this.a).a(bgna.a(this.a).troopUin);
      if (bool)
      {
        bgna.a(this.a).hasSetNewTroopHead = true;
        if (bgna.a(this.a).hasSetNewTroopName) {
          bgna.a(this.a).isNewTroop = false;
        }
        if (bgna.a(this.a).isUseClassAvatar) {
          bgna.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bgna.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bgna.a(this.a).isResume()) {
        break;
      }
      bgna.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgne
 * JD-Core Version:    0.7.0.1
 */