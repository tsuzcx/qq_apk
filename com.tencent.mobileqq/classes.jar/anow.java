import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doutu.combo.ComboEggView;
import com.tencent.mobileqq.doutu.combo.ComboMasterView;
import com.tencent.mobileqq.doutu.combo.ComboNavigateBar;
import com.tencent.mobileqq.doutu.combo.ComboUIManager.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

@TargetApi(11)
public class anow
  implements Handler.Callback, View.OnTouchListener, Observer
{
  private int jdField_a_of_type_Int = 8;
  aeyv jdField_a_of_type_Aeyv;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new bfob(Looper.getMainLooper(), this);
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private anot jdField_a_of_type_Anot;
  azno jdField_a_of_type_Azno;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ComboEggView jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView;
  ComboMasterView jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView;
  ComboNavigateBar jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar;
  RelativeLayout b;
  
  public anow(QQAppInterface paramQQAppInterface, Activity paramActivity, BaseChatPie paramBaseChatPie, RelativeLayout paramRelativeLayout, azno paramazno, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidContentContext = paramRelativeLayout.getContext();
    this.jdField_a_of_type_Azno = paramazno;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_Azno != null) {
      this.jdField_a_of_type_Azno.a(this);
    }
    if (paramBaseChatPie != null)
    {
      this.jdField_a_of_type_Aeyv = paramBaseChatPie.a();
      this.jdField_a_of_type_Aeyv.a(this);
    }
  }
  
  private ComboEggView a(anot paramanot)
  {
    e();
    ComboEggView localComboEggView = (ComboEggView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558532, null);
    localComboEggView.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localComboEggView.a(paramanot))
    {
      paramanot = new RelativeLayout.LayoutParams(-1, -1);
      paramanot.addRule(13);
      this.b.addView(localComboEggView, paramanot);
      localComboEggView.b();
      return localComboEggView;
    }
    b(paramanot);
    return null;
  }
  
  private ComboMasterView a(anot paramanot)
  {
    e();
    ComboMasterView localComboMasterView = (ComboMasterView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558533, null);
    localComboMasterView.a(this);
    if (localComboMasterView.a(paramanot))
    {
      paramanot = new RelativeLayout.LayoutParams(-1, -1);
      paramanot.addRule(13);
      this.b.addView(localComboMasterView, paramanot);
      localComboMasterView.a();
      return localComboMasterView;
    }
    b(paramanot);
    return null;
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    Object localObject = Runtime.getRuntime();
    long l1 = (((Runtime)localObject).totalMemory() - ((Runtime)localObject).freeMemory()) / 1048576L;
    long l2 = ((Runtime)localObject).maxMemory() / 1048576L;
    long l3 = l2 - l1;
    boolean bool1;
    if (l3 < 10L)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, " hasOOMDanger: " + bool1 + " availHeapSizeInMB:" + l3 + " maxHeapSizeInMB:" + l2 + " usedMemInMB:" + l1);
      }
      localObject = axrn.a(BaseApplication.getContext());
      if (bool1) {
        break label145;
      }
    }
    for (;;)
    {
      ((axrn)localObject).a(null, "ComboEggOOM", bool2, l3, l1, null, "");
      return bool1;
      bool1 = false;
      break;
      label145:
      bool2 = false;
    }
  }
  
  private void b(anot paramanot)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = ((ComboNavigateBar)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558534, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar) == -1)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, actj.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.topMargin = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298865) + actj.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar, localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.setInfo(paramanot);
  }
  
  private void e()
  {
    if (this.b == null)
    {
      this.b = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.b.setOnTouchListener(this);
    }
    FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    if (localFrameLayout.indexOfChild(this.b) == -1)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout.addView(this.b, localLayoutParams);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a();
  }
  
  public anot a()
  {
    anot localanot;
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.a(this.b);
      localanot = new anot(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_Anot.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_Anot.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
      return localanot;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.a(this.b);
      localanot = new anot(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_Anot.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_Anot.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
      return localanot;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    c();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, paramLong);
  }
  
  public void a(Animator paramAnimator, ComboMasterView paramComboMasterView)
  {
    if (this.b != null)
    {
      paramAnimator = paramComboMasterView.jdField_a_of_type_Anot;
      if ((paramAnimator != null) && (this.jdField_a_of_type_Anot.jdField_a_of_type_Int == paramAnimator.jdField_a_of_type_Int)) {
        b(paramAnimator);
      }
      this.b.removeView(paramComboMasterView);
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
  }
  
  public void a(anot paramanot)
  {
    for (;;)
    {
      Message localMessage;
      try
      {
        if (this.jdField_a_of_type_Anot != null)
        {
          int i = this.jdField_a_of_type_Anot.jdField_a_of_type_Int;
          int j = paramanot.jdField_a_of_type_Int;
          if (i >= j) {
            return;
          }
        }
        this.jdField_a_of_type_Anot = paramanot;
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localMessage.obj = paramanot;
        if (QLog.isColorLevel()) {
          QLog.d("ComboUIManager", 2, "update  msg what:" + localMessage.what + " " + paramanot);
        }
        if (!paramanot.jdField_a_of_type_Boolean)
        {
          localMessage.what = 1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
            break label242;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w()) {
            break label204;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ComboUIManager", 2, "isMsgBoxShown");
          continue;
        }
        if (!ComboEggView.a(paramanot.jdField_a_of_type_Int)) {
          break label169;
        }
      }
      finally {}
      localMessage.what = 3;
      continue;
      label169:
      if (paramanot.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
      {
        localMessage.what = 2;
      }
      else
      {
        localMessage.what = 1;
        continue;
        label204:
        paramanot = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
        if ((paramanot != null) && (paramanot.a() != -1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "isTipsShown");
          }
        }
        else {
          label242:
          if ((this.jdField_a_of_type_Azno != null) && (this.jdField_a_of_type_Azno.h()) && (localMessage.what < 11))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ComboUIManager", 2, "isTroopAioTipsShown");
            }
          }
          else {
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 0L);
          }
        }
      }
    }
  }
  
  public void a(ComboEggView paramComboEggView)
  {
    if (this.b != null)
    {
      anot localanot = paramComboEggView.jdField_a_of_type_Anot;
      if ((localanot != null) && (this.jdField_a_of_type_Anot.jdField_a_of_type_Int == localanot.jdField_a_of_type_Int)) {
        b(localanot);
      }
      this.b.removeView(paramComboEggView);
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
  }
  
  public void c()
  {
    if (this.b != null)
    {
      FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      a();
      localFrameLayout.removeView(this.b);
      this.b = null;
    }
    anou.a();
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar);
      }
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = null;
    }
  }
  
  public void d()
  {
    anot localanot = a();
    if (localanot != null) {
      b(localanot);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    anot localanot1 = (anot)paramMessage.obj;
    anot localanot2 = a();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (localanot1.jdField_a_of_type_Int > 999) {
        localanot1.jdField_a_of_type_Int = 999;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a()))
      {
        b(localanot1);
      }
      else if (ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "combo"))
      {
        b(localanot1);
      }
      else
      {
        if (localanot2 != null) {
          b(localanot2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(false);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
          if (paramMessage.what == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localanot1);
          }
          else
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008096", "0X8008096", 0, 0, "", "", "", "");
            if (a())
            {
              if (localanot1.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localanot1);
              } else {
                b(localanot1);
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = a(localanot1);
              if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView == null)
              {
                b(localanot1);
                continue;
                if (localanot1.jdField_a_of_type_Int > 999) {
                  localanot1.jdField_a_of_type_Int = 999;
                }
                b(localanot1);
                continue;
                c();
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("ComboUIManager", 2, "[Doutu] + handleMessage : 12");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.a();
                }
                this.jdField_a_of_type_Anot = null;
                c();
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView != null) || (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView != null))
    {
      d();
      f();
      return true;
    }
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    new Handler(Looper.getMainLooper()).post(new ComboUIManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anow
 * JD-Core Version:    0.7.0.1
 */