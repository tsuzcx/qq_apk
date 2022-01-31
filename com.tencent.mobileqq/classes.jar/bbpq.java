import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class bbpq
  implements Animation.AnimationListener
{
  bbpq(bbpo parambbpo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bbpo.a(this.a) != null) {
      bbpo.a(this.a).a.clearAnimation();
    }
    bbpo.a(this.a);
    if ((bbpo.a(this.a) != null) && (!bbpo.a(this.a).isSend())) {
      ((bbpw)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), bbpo.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(bbpo.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpq
 * JD-Core Version:    0.7.0.1
 */