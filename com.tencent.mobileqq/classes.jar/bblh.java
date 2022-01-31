import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class bblh
  implements Animation.AnimationListener
{
  bblh(bblf parambblf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bblf.a(this.a) != null) {
      bblf.a(this.a).a.clearAnimation();
    }
    bblf.a(this.a);
    if ((bblf.a(this.a) != null) && (!bblf.a(this.a).isSend())) {
      ((bbln)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), bblf.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(bblf.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblh
 * JD-Core Version:    0.7.0.1
 */