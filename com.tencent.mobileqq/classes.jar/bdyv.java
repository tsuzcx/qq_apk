import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class bdyv
  implements Animation.AnimationListener
{
  bdyv(bdyt parambdyt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bdyt.a(this.a) != null) {
      bdyt.a(this.a).a.clearAnimation();
    }
    bdyt.a(this.a);
    if ((bdyt.a(this.a) != null) && (!bdyt.a(this.a).isSend())) {
      ((bdzb)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), bdyt.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(bdyt.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyv
 * JD-Core Version:    0.7.0.1
 */