import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class bfpl
  implements Animation.AnimationListener
{
  bfpl(bfpj parambfpj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bfpj.a(this.a) != null) {
      bfpj.a(this.a).a.clearAnimation();
    }
    bfpj.a(this.a);
    if ((bfpj.a(this.a) != null) && (!bfpj.a(this.a).isSend())) {
      ((bfpr)this.a.a.getManager(225)).a(this.a.a.getCurrentAccountUin(), bfpj.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(bfpj.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpl
 * JD-Core Version:    0.7.0.1
 */