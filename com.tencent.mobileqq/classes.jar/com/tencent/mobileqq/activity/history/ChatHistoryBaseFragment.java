package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar.OnActionListener;
import com.tencent.mobileqq.activity.selectable.CommonSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

public abstract class ChatHistoryBaseFragment
  extends BaseFragment
{
  public QQAppInterface a;
  public boolean b;
  public boolean c;
  protected BaseActivity d;
  protected String e;
  protected View f;
  protected ChatHistoryBaseViewController g;
  protected ChatHistorySelectBottomBar h;
  protected boolean i;
  protected ChatHistoryItemSelectHelper j;
  QQCustomDialog k;
  Dialog l;
  protected CommonSelectableHelper m;
  ChatHistorySelectBottomBar.OnActionListener n = new ChatHistoryBaseFragment.2(this);
  ChatHistoryRightButtonListener o = new ChatHistoryBaseFragment.3(this);
  protected Handler p = new Handler(Looper.getMainLooper());
  protected Dialog q;
  protected ChatHistoryBaseFragment.ProgressView r;
  private int s;
  private int t;
  
  public void a(int paramInt)
  {
    this.t = paramInt;
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ChatHistoryBaseViewController paramChatHistoryBaseViewController)
  {
    this.g = paramChatHistoryBaseViewController;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.d = paramBaseActivity;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    c();
  }
  
  public void a(CharSequence paramCharSequence, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.p.removeCallbacksAndMessages(null);
    this.p.post(new ChatHistoryBaseFragment.4(this, paramOnCancelListener, paramCharSequence));
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f != null)
    {
      if ((paramBoolean) && (!this.b)) {
        i();
      } else if (((paramBoolean ^ true) & this.b)) {
        j();
      }
      this.b = paramBoolean;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTabChange ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(" ");
        localStringBuilder.append(e());
        QLog.d("Q.history.BaseFragment", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void b(String paramString)
  {
    if (this.k == null)
    {
      this.k = DialogUtil.a(getBaseActivity(), 230);
      this.k.setNegativeButton(2131916601, new ChatHistoryBaseFragment.1(this));
    }
    if (!this.k.isShowing()) {
      this.k.setMessage(paramString);
    } else {
      this.k.dismiss();
    }
    try
    {
      this.k.show();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  void b(boolean paramBoolean) {}
  
  protected abstract void c();
  
  protected abstract void d();
  
  public int e()
  {
    return this.t;
  }
  
  public int f()
  {
    return this.s;
  }
  
  public String g()
  {
    return this.e;
  }
  
  protected void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    this.h.a(localArrayList);
  }
  
  public void i()
  {
    this.g.a(this.o);
    this.g.a(l());
    this.g.a(this, true);
    this.m.onMoveToState(7);
  }
  
  public void j()
  {
    ChatHistorySelectBottomBar localChatHistorySelectBottomBar = this.h;
    if (localChatHistorySelectBottomBar != null) {
      localChatHistorySelectBottomBar.b();
    }
    this.m.onMoveToState(11);
  }
  
  public void k()
  {
    ChatHistorySelectBottomBar localChatHistorySelectBottomBar = this.h;
    if (localChatHistorySelectBottomBar != null) {
      localChatHistorySelectBottomBar.b();
    }
    d();
  }
  
  protected int l()
  {
    return 1600;
  }
  
  public void m()
  {
    this.j.a();
    this.g.g();
    this.i = false;
  }
  
  public void n()
  {
    if (this.l == null)
    {
      this.l = new ReportDialog(getBaseActivity(), 2131953338);
      this.l.setCanceledOnTouchOutside(false);
      this.l.setContentView(2131625585);
    }
    TextView localTextView = (TextView)this.l.findViewById(2131440191);
    localTextView.setText(localTextView.getResources().getString(2131886524));
    if (!this.l.isShowing()) {}
    try
    {
      this.l.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  void o() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = new ChatHistoryItemSelectHelper();
    this.m = new CommonSelectableHelper(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f = paramView;
    if ((this.f != null) && (this.c))
    {
      i();
      this.b = true;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onViewCreated ");
      paramView.append(e());
      QLog.d("Q.history.BaseFragment", 2, paramView.toString());
    }
    paramView = this.d;
    if (paramView == null) {
      return;
    }
    this.h = new ChatHistorySelectBottomBar(paramView, (ViewGroup)getView());
    this.h.a(this.n);
    h();
  }
  
  protected void p() {}
  
  protected void q() {}
  
  protected void r() {}
  
  protected void s() {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.c = paramBoolean;
  }
  
  protected void t() {}
  
  public void u()
  {
    this.p.removeCallbacksAndMessages(null);
    this.p.post(new ChatHistoryBaseFragment.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */