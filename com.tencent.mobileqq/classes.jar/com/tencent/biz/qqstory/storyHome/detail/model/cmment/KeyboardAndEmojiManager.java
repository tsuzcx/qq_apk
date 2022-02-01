package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

public class KeyboardAndEmojiManager
  implements View.OnClickListener
{
  EmoticonCallback a = new KeyboardAndEmojiManager.3(this);
  private Context b;
  private KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener c;
  private View d;
  private XEditTextEx e;
  private ImageButton f;
  private FrameLayout g;
  private SystemEmoticonPanel h;
  private View i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private long n = 0L;
  private ViewTreeObserver.OnGlobalLayoutListener o;
  
  public KeyboardAndEmojiManager(Context paramContext, View paramView, KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener paramKeyboardAndEmojiStateChangeListener)
  {
    this.b = paramContext;
    this.d = paramView;
    this.c = paramKeyboardAndEmojiStateChangeListener;
    e();
    f();
  }
  
  public static QQAppInterface d()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void e()
  {
    this.e = ((XEditTextEx)this.d.findViewById(2131432617));
    this.g = ((FrameLayout)this.d.findViewById(2131432475));
    this.i = this.d.findViewById(2131431315);
    this.f = ((ImageButton)this.d.findViewById(2131432438));
    this.h = TroopBarPublishUtils.a(this.b, this.g, this.e, this.a);
  }
  
  private void f()
  {
    ((PatchedButton)this.d.findViewById(2131433920)).setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.o = new KeyboardAndEmojiManager.1(this);
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.o);
  }
  
  private void g()
  {
    SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard up. mIsForceChange = %s.", Boolean.valueOf(this.m));
    if (this.k)
    {
      this.l = true;
      i();
    }
    if (!this.e.isFocused()) {
      this.e.requestFocus();
    }
    this.j = true;
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.c;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.b(this.m);
    }
    this.m = false;
  }
  
  private void h()
  {
    SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard down. mIsForceChange = %s.", Boolean.valueOf(this.m));
    this.j = false;
    boolean bool;
    if (!this.l)
    {
      if (this.e.getText().length() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.e.clearFocus();
    }
    else
    {
      bool = false;
    }
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.c;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.c(bool);
    }
    this.l = false;
    this.m = false;
  }
  
  private void i()
  {
    boolean bool;
    if (!this.l)
    {
      if (this.e.getText().length() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.e.clearFocus();
    }
    else
    {
      bool = false;
    }
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.c;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.c(bool);
    }
    this.l = false;
    this.k = false;
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.f.setSelected(false);
  }
  
  public void a()
  {
    if (this.j)
    {
      this.l = true;
      a(false);
    }
    if (!this.e.isFocused()) {
      this.e.requestFocus();
    }
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener = this.c;
    if (localKeyboardAndEmojiStateChangeListener != null) {
      localKeyboardAndEmojiStateChangeListener.b(this.m);
    }
    this.k = true;
    this.h.setVisibility(0);
    this.i.setVisibility(0);
    this.f.setSelected(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = true;
    Object localObject = (InputMethodManager)this.b.getSystemService("input_method");
    if (localObject != null) {
      if (paramBoolean)
      {
        if (!this.e.isFocused()) {
          this.e.requestFocus();
        }
        ((InputMethodManager)localObject).showSoftInput(this.e, 1);
      }
      else
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setKeyBoardState: %s.");
    ((StringBuilder)localObject).append(paramBoolean);
    SLog.b("Q.qqstory.detail.KeyboardAndEmojiManager", ((StringBuilder)localObject).toString());
  }
  
  public void b()
  {
    if (this.j) {
      a(false);
    }
    if (this.k) {
      i();
    }
  }
  
  public boolean c()
  {
    return (this.j) || (this.k);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    KeyboardAndEmojiManager.KeyboardAndEmojiStateChangeListener localKeyboardAndEmojiStateChangeListener;
    if (i1 != 2131432438)
    {
      if (i1 == 2131433920)
      {
        localKeyboardAndEmojiStateChangeListener = this.c;
        if (localKeyboardAndEmojiStateChangeListener != null) {
          localKeyboardAndEmojiStateChangeListener.f();
        }
      }
    }
    else if (System.currentTimeMillis() - this.n >= 500L)
    {
      this.n = System.currentTimeMillis();
      localKeyboardAndEmojiStateChangeListener = this.c;
      if ((localKeyboardAndEmojiStateChangeListener == null) || (!localKeyboardAndEmojiStateChangeListener.e()))
      {
        this.l = true;
        if (this.h.getVisibility() == 0)
        {
          i();
          a(true);
        }
        else
        {
          a(false);
          new Handler().postDelayed(new KeyboardAndEmojiManager.2(this), 200L);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager
 * JD-Core Version:    0.7.0.1
 */