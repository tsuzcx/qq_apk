package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.BaseActivity;

public abstract class ChatHistoryBaseViewController
{
  protected BaseActivity a;
  protected View b;
  protected String c;
  protected ChatHistoryRightButtonListener d;
  
  public ChatHistoryBaseViewController(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public BaseActivity a()
  {
    return this.a;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract void a(ChatHistoryBaseFragment paramChatHistoryBaseFragment, boolean paramBoolean);
  
  public void a(ChatHistoryRightButtonListener paramChatHistoryRightButtonListener)
  {
    this.d = paramChatHistoryRightButtonListener;
  }
  
  protected View b(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  public FragmentManager b()
  {
    return this.a.getSupportFragmentManager();
  }
  
  public void c()
  {
    this.b = this.a.findViewById(2131445137);
    h();
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.d = null;
  }
  
  public void g() {}
  
  protected void h()
  {
    this.c = this.a.getIntent().getStringExtra("SissionUin");
  }
  
  public abstract int i();
  
  public abstract void j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseViewController
 * JD-Core Version:    0.7.0.1
 */