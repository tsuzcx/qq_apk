import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class beqe
  implements Animation.AnimationListener
{
  beqe(beqc parambeqc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (beqc.a(this.a) != null) {
      beqc.a(this.a).a.clearAnimation();
    }
    beqc.a(this.a);
    if ((beqc.a(this.a) != null) && (!beqc.a(this.a).isSend())) {
      ((beqk)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), beqc.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(beqc.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqe
 * JD-Core Version:    0.7.0.1
 */