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
public class amyj
  implements Handler.Callback, View.OnTouchListener, Observer
{
  private int jdField_a_of_type_Int = 8;
  aeob jdField_a_of_type_Aeob;
  private amyg jdField_a_of_type_Amyg;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new befq(Looper.getMainLooper(), this);
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  aymw jdField_a_of_type_Aymw;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ComboEggView jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView;
  ComboMasterView jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView;
  ComboNavigateBar jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar;
  RelativeLayout b;
  
  public amyj(QQAppInterface paramQQAppInterface, Activity paramActivity, BaseChatPie paramBaseChatPie, RelativeLayout paramRelativeLayout, aymw paramaymw, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidContentContext = paramRelativeLayout.getContext();
    this.jdField_a_of_type_Aymw = paramaymw;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a(this);
    }
    if (paramBaseChatPie != null)
    {
      this.jdField_a_of_type_Aeob = paramBaseChatPie.a();
      this.jdField_a_of_type_Aeob.a(this);
    }
  }
  
  private ComboEggView a(amyg paramamyg)
  {
    e();
    ComboEggView localComboEggView = (ComboEggView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131492980, null);
    localComboEggView.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localComboEggView.a(paramamyg))
    {
      paramamyg = new RelativeLayout.LayoutParams(-1, -1);
      paramamyg.addRule(13);
      this.b.addView(localComboEggView, paramamyg);
      localComboEggView.b();
      return localComboEggView;
    }
    b(paramamyg);
    return null;
  }
  
  private ComboMasterView a(amyg paramamyg)
  {
    e();
    ComboMasterView localComboMasterView = (ComboMasterView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131492981, null);
    localComboMasterView.a(this);
    if (localComboMasterView.a(paramamyg))
    {
      paramamyg = new RelativeLayout.LayoutParams(-1, -1);
      paramamyg.addRule(13);
      this.b.addView(localComboMasterView, paramamyg);
      localComboMasterView.a();
      return localComboMasterView;
    }
    b(paramamyg);
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
      localObject = awrn.a(BaseApplication.getContext());
      if (bool1) {
        break label145;
      }
    }
    for (;;)
    {
      ((awrn)localObject).a(null, "ComboEggOOM", bool2, l3, l1, null, "");
      return bool1;
      bool1 = false;
      break;
      label145:
      bool2 = false;
    }
  }
  
  private void b(amyg paramamyg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = ((ComboNavigateBar)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131492982, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar) == -1)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, aciy.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.topMargin = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131167766) + aciy.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar, localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.setInfo(paramamyg);
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
  
  public amyg a()
  {
    amyg localamyg;
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.a(this.b);
      localamyg = new amyg(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_Amyg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_Amyg.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
      return localamyg;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.a(this.b);
      localamyg = new amyg(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_Amyg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_Amyg.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
      return localamyg;
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
  
  public void a(amyg paramamyg)
  {
    for (;;)
    {
      Message localMessage;
      try
      {
        if (this.jdField_a_of_type_Amyg != null)
        {
          int i = this.jdField_a_of_type_Amyg.jdField_a_of_type_Int;
          int j = paramamyg.jdField_a_of_type_Int;
          if (i >= j) {
            return;
          }
        }
        this.jdField_a_of_type_Amyg = paramamyg;
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localMessage.obj = paramamyg;
        if (QLog.isColorLevel()) {
          QLog.d("ComboUIManager", 2, "update  msg what:" + localMessage.what + " " + paramamyg);
        }
        if (!paramamyg.jdField_a_of_type_Boolean)
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
        if (!ComboEggView.a(paramamyg.jdField_a_of_type_Int)) {
          break label169;
        }
      }
      finally {}
      localMessage.what = 3;
      continue;
      label169:
      if (paramamyg.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
      {
        localMessage.what = 2;
      }
      else
      {
        localMessage.what = 1;
        continue;
        label204:
        paramamyg = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
        if ((paramamyg != null) && (paramamyg.a() != -1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "isTipsShown");
          }
        }
        else {
          label242:
          if ((this.jdField_a_of_type_Aymw != null) && (this.jdField_a_of_type_Aymw.h()) && (localMessage.what < 11))
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
  
  public void a(Animator paramAnimator, ComboMasterView paramComboMasterView)
  {
    if (this.b != null)
    {
      paramAnimator = paramComboMasterView.jdField_a_of_type_Amyg;
      if ((paramAnimator != null) && (this.jdField_a_of_type_Amyg.jdField_a_of_type_Int == paramAnimator.jdField_a_of_type_Int)) {
        b(paramAnimator);
      }
      this.b.removeView(paramComboMasterView);
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
  }
  
  public void a(ComboEggView paramComboEggView)
  {
    if (this.b != null)
    {
      amyg localamyg = paramComboEggView.jdField_a_of_type_Amyg;
      if ((localamyg != null) && (this.jdField_a_of_type_Amyg.jdField_a_of_type_Int == localamyg.jdField_a_of_type_Int)) {
        b(localamyg);
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
    amyh.a();
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
    amyg localamyg = a();
    if (localamyg != null) {
      b(localamyg);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    amyg localamyg1 = (amyg)paramMessage.obj;
    amyg localamyg2 = a();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (localamyg1.jdField_a_of_type_Int > 999) {
        localamyg1.jdField_a_of_type_Int = 999;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a()))
      {
        b(localamyg1);
      }
      else if (aisc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "combo"))
      {
        b(localamyg1);
      }
      else
      {
        if (localamyg2 != null) {
          b(localamyg2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(false);
          }
          if (paramMessage.what == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localamyg1);
          }
          else
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008096", "0X8008096", 0, 0, "", "", "", "");
            if (a())
            {
              if (localamyg1.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localamyg1);
              } else {
                b(localamyg1);
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = a(localamyg1);
              if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView == null)
              {
                b(localamyg1);
                continue;
                if (localamyg1.jdField_a_of_type_Int > 999) {
                  localamyg1.jdField_a_of_type_Int = 999;
                }
                b(localamyg1);
                continue;
                c();
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("ComboUIManager", 2, "[Doutu] + handleMessage : 12");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.a();
                }
                this.jdField_a_of_type_Amyg = null;
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
 * Qualified Name:     amyj
 * JD-Core Version:    0.7.0.1
 */