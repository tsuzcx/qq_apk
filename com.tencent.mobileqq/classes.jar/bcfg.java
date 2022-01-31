import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class bcfg
  implements Observer
{
  bcfg(bcfc parambcfc) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((bcfc.a(this.a) == null) || (bcfc.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof bcln));
      paramObservable = (bcln)paramObject;
    } while (paramObservable.a != 1);
    if (paramObservable.d == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramObservable = bcfc.a(this.a);
      bcfc.a(this.a).a(bcfc.a(this.a).troopUin);
      if (bool)
      {
        bcfc.a(this.a).hasSetNewTroopHead = true;
        if (bcfc.a(this.a).hasSetNewTroopName) {
          bcfc.a(this.a).isNewTroop = false;
        }
        if (bcfc.a(this.a).isUseClassAvatar) {
          bcfc.a(this.a).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.a != null))
        {
          paramObservable.a.hasSetNewTroopHead = true;
          paramObservable.a.isNewTroop = bcfc.a(this.a).isNewTroop;
          if (paramObservable.a.isUseClassAvatar()) {
            paramObservable.a.setUseClassAvatar(false);
          }
          this.a.c();
        }
      }
      if (!bcfc.a(this.a).isResume()) {
        break;
      }
      bcfc.a(this.a).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfg
 * JD-Core Version:    0.7.0.1
 */