import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class azfd
  implements Observer
{
  azfd(azez paramazez) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((azez.a(this.a) == null) || (azez.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof azli));
      paramObservable = (azli)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = azez.a(this.a);
      azez.a(this.a).a(azez.a(this.a).troopUin);
      if (bool)
      {
        azez.a(this.a).hasSetNewTroopHead = true;
        if (azez.a(this.a).hasSetNewTroopName) {
          azez.a(this.a).isNewTroop = false;
        }
        if (azez.a(this.a).isUseClassAvatar) {
          azez.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = azez.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!azez.a(this.a).isResume()) {
        break;
      }
      azez.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfd
 * JD-Core Version:    0.7.0.1
 */