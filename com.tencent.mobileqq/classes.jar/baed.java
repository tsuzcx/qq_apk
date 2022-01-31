import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class baed
  implements Animation.AnimationListener
{
  baed(baec parambaec) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.i = false;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    if (this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.a.jdField_a_of_type_Azno != null) {}
        baec.a(this.a);
        this.a.notifyObservers(Integer.valueOf(123322));
        this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (this.a.jdField_a_of_type_Azno != null) {
        this.a.jdField_a_of_type_Azno.d = false;
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.d(true);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if (this.a.e)
      {
        if (bbfj.d(BaseApplication.getContext())) {
          break label247;
        }
        bcql.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 1, ((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131697859), 1).b(((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 5.0F));
      }
    }
    for (;;)
    {
      return;
      label247:
      baix localbaix = (baix)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(133);
      String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (!TextUtils.isEmpty(str))
      {
        TroopAioTopADInfo localTroopAioTopADInfo = localbaix.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        Object localObject;
        if (localTroopAioTopADInfo != null)
        {
          if (!TextUtils.isEmpty(localTroopAioTopADInfo.jumpUrl)) {
            break label430;
          }
          paramAnimation = localTroopAioTopADInfo.backgroundUrl;
          localObject = bbex.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), paramAnimation);
          if (localObject == null) {
            break label439;
          }
          ((bbeg)localObject).c();
        }
        for (;;)
        {
          axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_Promote", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localTroopAioTopADInfo.adId + "", "", "");
          localbaix.a(str);
          this.a.d = false;
          return;
          label430:
          paramAnimation = localTroopAioTopADInfo.jumpUrl;
          break;
          label439:
          if (paramAnimation.startsWith("http"))
          {
            localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramAnimation));
            ((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
          }
        }
        if (this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
        {
          if ((this.a.jdField_a_of_type_AndroidViewView != null) && (this.a.jdField_a_of_type_Azno != null))
          {
            this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
            baec.b(this.a);
            this.a.notifyObservers(Integer.valueOf(123322));
            if ((this.a.c) && (this.a.jdField_a_of_type_AndroidViewView != null) && ((this.a.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView)))
            {
              if (!this.a.d) {
                break label651;
              }
              this.a.jdField_a_of_type_Azpc.b();
            }
          }
          while (this.a.jdField_a_of_type_AndroidViewView != null)
          {
            this.a.jdField_a_of_type_AndroidViewView.requestFocus();
            return;
            label651:
            if (this.a.f)
            {
              ((TroopAioFeedsCenterView)this.a.jdField_a_of_type_AndroidViewView).a();
              this.a.f = false;
            }
            else
            {
              this.a.c = false;
              ((TroopAioFeedsCenterView)this.a.jdField_a_of_type_AndroidViewView).a(true);
            }
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baed
 * JD-Core Version:    0.7.0.1
 */