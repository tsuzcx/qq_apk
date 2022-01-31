import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bcjp
  implements Observer
{
  bcjp(bcjl parambcjl) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bcjl.a(this.a) == null) || (bcjl.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bcpw));
      paramObservable = (bcpw)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bcjl.a(this.a);
      bcjl.a(this.a).a(bcjl.a(this.a).troopUin);
      if (bool)
      {
        bcjl.a(this.a).hasSetNewTroopHead = true;
        if (bcjl.a(this.a).hasSetNewTroopName) {
          bcjl.a(this.a).isNewTroop = false;
        }
        if (bcjl.a(this.a).isUseClassAvatar) {
          bcjl.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bcjl.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bcjl.a(this.a).isResume()) {
        break;
      }
      bcjl.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjp
 * JD-Core Version:    0.7.0.1
 */