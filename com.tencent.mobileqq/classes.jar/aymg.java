import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class aymg
  implements Animation.AnimationListener
{
  aymg(ayme paramayme) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ayme.a(this.a) != null) {
      ayme.a(this.a).a.clearAnimation();
    }
    ayme.a(this.a);
    if ((ayme.a(this.a) != null) && (!ayme.a(this.a).isSend())) {
      ((aymm)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), ayme.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(ayme.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aymg
 * JD-Core Version:    0.7.0.1
 */