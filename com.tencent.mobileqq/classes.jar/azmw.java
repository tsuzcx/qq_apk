import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class azmw
  implements Animation.AnimationListener
{
  azmw(azmu paramazmu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (azmu.a(this.a) != null) {
      azmu.a(this.a).a.clearAnimation();
    }
    azmu.a(this.a);
    if ((azmu.a(this.a) != null) && (!azmu.a(this.a).isSend())) {
      ((aznc)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), azmu.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(azmu.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmw
 * JD-Core Version:    0.7.0.1
 */