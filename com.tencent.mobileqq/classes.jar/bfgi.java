import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;

public class bfgi
  extends bffq
  implements Animation.AnimationListener
{
  protected static int d = 1;
  protected static int e = 2;
  protected static int f;
  protected static int g = 1;
  protected static int h = 2;
  protected static int i = 3;
  protected static int j;
  protected static final int m = (int)BaseApplicationImpl.getApplication().getResources().getDimension(2131297519);
  protected float a;
  protected Handler a;
  protected Animation a;
  public LinearLayout a;
  protected TextView a;
  protected Animation b;
  public LinearLayout b;
  protected RelativeLayout b;
  protected TextView b;
  public boolean b;
  protected Animation c;
  protected int k;
  protected int l = f;
  protected int n;
  
  public bfgi()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new bfgj(this);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Object localObject;
    if (paramInt == e)
    {
      paramTextView.setText(2131697351);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842415, 0);
      paramTextView.setCompoundDrawablePadding(4);
      paramTextView.setGravity(17);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != d);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setGravity(19);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    } while (localObject == null);
    MsgSummary localMsgSummary = new MsgSummary();
    bhfj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QQMessageFacade.Message)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMsgSummary, ((QQMessageFacade.Message)localObject).nickName, false, false);
    paramTextView.setText(localMsgSummary.parseMsg(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.l == g)
    {
      f();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.l = i;
    }
    while (this.l != h) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.l = i;
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
  }
  
  public int a()
  {
    return this.n;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(paramInt);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout != null;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, m, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, m);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.c = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - m);
    this.c.setDuration(300L);
    this.c.setAnimationListener(this);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      f();
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Float = 0.0F;
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.l = f;
    }
    do
    {
      do
      {
        return;
        if (!paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {
          break;
        }
        this.l = h;
      } while (this.k != e);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, j), 3000L);
      return;
    } while (!paramAnimation.equals(this.c));
    a(this.jdField_a_of_type_AndroidWidgetTextView, this.k);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgi
 * JD-Core Version:    0.7.0.1
 */