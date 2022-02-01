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
public class ascw
  implements Handler.Callback, View.OnTouchListener, Observer
{
  private int jdField_a_of_type_Int = 8;
  aiwh jdField_a_of_type_Aiwh;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new blhq(Looper.getMainLooper(), this);
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private asct jdField_a_of_type_Asct;
  bfpy jdField_a_of_type_Bfpy;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ComboEggView jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView;
  ComboMasterView jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView;
  ComboNavigateBar jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar;
  RelativeLayout b;
  
  public ascw(QQAppInterface paramQQAppInterface, Activity paramActivity, BaseChatPie paramBaseChatPie, RelativeLayout paramRelativeLayout, bfpy parambfpy, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidContentContext = paramRelativeLayout.getContext();
    this.jdField_a_of_type_Bfpy = parambfpy;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_Bfpy != null) {
      this.jdField_a_of_type_Bfpy.a(this);
    }
    if (paramBaseChatPie != null)
    {
      this.jdField_a_of_type_Aiwh = paramBaseChatPie.a();
      this.jdField_a_of_type_Aiwh.a(this);
    }
  }
  
  private ComboEggView a(asct paramasct)
  {
    e();
    ComboEggView localComboEggView = (ComboEggView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558589, null);
    localComboEggView.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localComboEggView.a(paramasct))
    {
      paramasct = new RelativeLayout.LayoutParams(-1, -1);
      paramasct.addRule(13);
      this.b.addView(localComboEggView, paramasct);
      localComboEggView.b();
      return localComboEggView;
    }
    b(paramasct);
    return null;
  }
  
  private ComboMasterView a(asct paramasct)
  {
    e();
    ComboMasterView localComboMasterView = (ComboMasterView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558590, null);
    localComboMasterView.a(this);
    if (localComboMasterView.a(paramasct))
    {
      paramasct = new RelativeLayout.LayoutParams(-1, -1);
      paramasct.addRule(13);
      this.b.addView(localComboMasterView, paramasct);
      localComboMasterView.a();
      return localComboMasterView;
    }
    b(paramasct);
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
      localObject = bdmc.a(BaseApplication.getContext());
      if (bool1) {
        break label145;
      }
    }
    for (;;)
    {
      ((bdmc)localObject).a(null, "ComboEggOOM", bool2, l3, l1, null, "");
      return bool1;
      bool1 = false;
      break;
      label145:
      bool2 = false;
    }
  }
  
  private void b(asct paramasct)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = ((ComboNavigateBar)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558591, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar) == -1)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, agej.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.topMargin = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131299011) + agej.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar, localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.setInfo(paramasct);
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
  
  public asct a()
  {
    asct localasct;
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.a(this.b);
      localasct = new asct(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_Asct.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_Asct.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
      return localasct;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.a(this.b);
      localasct = new asct(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_Asct.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_Asct.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
      return localasct;
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
      paramAnimator = paramComboMasterView.jdField_a_of_type_Asct;
      if ((paramAnimator != null) && (this.jdField_a_of_type_Asct.jdField_a_of_type_Int == paramAnimator.jdField_a_of_type_Int)) {
        b(paramAnimator);
      }
      this.b.removeView(paramComboMasterView);
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
  }
  
  public void a(asct paramasct)
  {
    for (;;)
    {
      Message localMessage;
      try
      {
        if (this.jdField_a_of_type_Asct != null)
        {
          int i = this.jdField_a_of_type_Asct.jdField_a_of_type_Int;
          int j = paramasct.jdField_a_of_type_Int;
          if (i >= j) {
            return;
          }
        }
        this.jdField_a_of_type_Asct = paramasct;
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localMessage.obj = paramasct;
        if (QLog.isColorLevel()) {
          QLog.d("ComboUIManager", 2, "update  msg what:" + localMessage.what + " " + paramasct);
        }
        if (!paramasct.jdField_a_of_type_Boolean)
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
        if (!ComboEggView.a(paramasct.jdField_a_of_type_Int)) {
          break label169;
        }
      }
      finally {}
      localMessage.what = 3;
      continue;
      label169:
      if (paramasct.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
      {
        localMessage.what = 2;
      }
      else
      {
        localMessage.what = 1;
        continue;
        label204:
        paramasct = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
        if ((paramasct != null) && (paramasct.a() != -1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "isTipsShown");
          }
        }
        else {
          label242:
          if ((this.jdField_a_of_type_Bfpy != null) && (this.jdField_a_of_type_Bfpy.h()) && (localMessage.what < 11))
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
      asct localasct = paramComboEggView.jdField_a_of_type_Asct;
      if ((localasct != null) && (this.jdField_a_of_type_Asct.jdField_a_of_type_Int == localasct.jdField_a_of_type_Int)) {
        b(localasct);
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
    ascu.a();
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
    asct localasct = a();
    if (localasct != null) {
      b(localasct);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    asct localasct1 = (asct)paramMessage.obj;
    asct localasct2 = a();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (localasct1.jdField_a_of_type_Int > 999) {
        localasct1.jdField_a_of_type_Int = 999;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a()))
      {
        b(localasct1);
      }
      else if (anfz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "combo"))
      {
        b(localasct1);
      }
      else
      {
        if (localasct2 != null) {
          b(localasct2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(false);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aw();
          if (paramMessage.what == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localasct1);
          }
          else
          {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008096", "0X8008096", 0, 0, "", "", "", "");
            if (a())
            {
              if (localasct1.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localasct1);
              } else {
                b(localasct1);
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = a(localasct1);
              if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView == null)
              {
                b(localasct1);
                continue;
                if (localasct1.jdField_a_of_type_Int > 999) {
                  localasct1.jdField_a_of_type_Int = 999;
                }
                b(localasct1);
                continue;
                c();
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("ComboUIManager", 2, "[Doutu] + handleMessage : 12");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.a();
                }
                this.jdField_a_of_type_Asct = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascw
 * JD-Core Version:    0.7.0.1
 */