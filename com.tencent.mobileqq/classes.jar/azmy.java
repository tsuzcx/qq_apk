import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class azmy
  implements Animation.AnimationListener
{
  azmy(azmw paramazmw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (azmw.a(this.a) != null) {
      azmw.a(this.a).a.clearAnimation();
    }
    azmw.a(this.a);
    if ((azmw.a(this.a) != null) && (!azmw.a(this.a).isSend())) {
      ((azne)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), azmw.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(azmw.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmy
 * JD-Core Version:    0.7.0.1
 */