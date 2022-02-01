import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class bffy
  implements Animation.AnimationListener
{
  bffy(bffw parambffw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bffw.a(this.a) != null) {
      bffw.a(this.a).a.clearAnimation();
    }
    bffw.a(this.a);
    if ((bffw.a(this.a) != null) && (!bffw.a(this.a).isSend())) {
      ((bfge)this.a.a.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(this.a.a.getCurrentAccountUin(), bffw.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(bffw.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffy
 * JD-Core Version:    0.7.0.1
 */