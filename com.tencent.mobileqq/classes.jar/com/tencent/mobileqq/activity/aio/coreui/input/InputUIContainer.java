package com.tencent.mobileqq.activity.aio.coreui.input;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;

public class InputUIContainer
{
  private AIOContext a;
  private final InputBarUI b;
  private final EditTextUI c;
  private final FunBtnUI d;
  private final InputRightIconUI e;
  private final FakeInputUI f;
  private final AIOInputState g;
  
  public InputUIContainer(AIOContext paramAIOContext, InputBarUI paramInputBarUI, EditTextUI paramEditTextUI, FunBtnUI paramFunBtnUI, InputRightIconUI paramInputRightIconUI)
  {
    this.a = paramAIOContext;
    this.b = paramInputBarUI;
    this.c = paramEditTextUI;
    this.d = paramFunBtnUI;
    this.e = paramInputRightIconUI;
    this.f = new FakeInputUI(paramAIOContext);
    this.g = new AIOInputState(paramAIOContext);
  }
  
  public AIOInputState a()
  {
    return this.g;
  }
  
  public void a(boolean paramBoolean)
  {
    ((FullScreenInputHelper)this.a.a(24)).b(paramBoolean);
  }
  
  public FakeInputUI b()
  {
    return this.f;
  }
  
  public InputRightIconUI c()
  {
    return this.e;
  }
  
  public FunBtnUI d()
  {
    return this.d;
  }
  
  public InputBarUI e()
  {
    return this.b;
  }
  
  public EditTextUI f()
  {
    return this.c;
  }
  
  public void g()
  {
    this.d.a(HardCodeUtil.a(2131899204));
    if (AppSetting.e) {
      this.d.b(HardCodeUtil.a(2131899195));
    }
    this.d.a();
    this.d.b();
  }
  
  public void h()
  {
    this.c.w();
    this.c.a("");
    try
    {
      this.c.a(QQTextBuilder.EMOTION_INPUT_FACTORY);
    }
    catch (Exception localException)
    {
      QLog.e("InputContainer", 1, "input set error", localException);
    }
    this.c.v();
    this.c.r();
    this.c.a(true).putInt("SOGOU_EXPRESSION", 1);
    this.c.t();
  }
  
  public void i()
  {
    this.f.d();
    this.f.e();
  }
  
  public void j()
  {
    this.e.c();
  }
  
  public void k()
  {
    this.b.b();
  }
  
  public void l()
  {
    Object localObject;
    if (this.a.b() != null)
    {
      localObject = this.a.b().getCurrentFocus();
      if (localObject != null)
      {
        QLog.i("InputContainer", 1, localObject.toString());
        ((View)localObject).clearFocus();
      }
    }
    if (this.a.b() != null) {
      localObject = (InputMethodManager)this.a.b().getSystemService("input_method");
    } else {
      localObject = null;
    }
    a(true);
    if (localObject != null) {
      try
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(f().b().getWindowToken(), 0);
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("InputContainer", 1, localRuntimeException, new Object[0]);
      }
    }
    if (f() != null)
    {
      f().w();
      if (f().a(false) != null) {
        f().a(false).clear();
      }
      f().a(null, null, null, null);
      f().a(2131441550, null);
      try
      {
        f().d(0);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("InputContainer", 1, "doOnDestroy: ", localThrowable);
      }
      f().u();
      f().b().setOnEditorActionListener(null);
      f().b().setOnKeyListener(null);
      f().b().setOnTouchListener(null);
      f().b().setOnFocusChangeListener(null);
      f().s();
      if (this.a.O().z) {
        f().a("");
      }
      try
      {
        if (AIOUtils.c())
        {
          ViewTreeObserver localViewTreeObserver = f().b().getViewTreeObserver();
          Field localField = ViewTreeObserver.class.getDeclaredField("mOnTouchModeChangeListeners");
          localField.setAccessible(true);
          localField.set(localViewTreeObserver, new CopyOnWriteArrayList());
          QLog.d("InputContainer", 1, "force clear mOnTouchModeChangeListeners success.");
        }
      }
      catch (Exception localException)
      {
        QLog.d("InputContainer", 1, "force clear mOnTouchModeChangeListeners", localException);
      }
      f().x();
    }
    if (f().a != null) {
      f().a.a();
    }
    if (e() != null) {
      e().g();
    }
    if (b() != null) {
      b().f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer
 * JD-Core Version:    0.7.0.1
 */