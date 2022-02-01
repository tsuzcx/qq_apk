package com.tencent.mobileqq.activity.contacts.phone;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class PhoneContactFragment
  extends ContactsBaseFragment
  implements INewFriendListener, IPhoneContactListener
{
  protected View a;
  protected XListView b;
  protected PhoneContactAdapter c;
  protected FrameLayout d;
  protected PhoneContactFragment.MyContactObserver e = new PhoneContactFragment.MyContactObserver(this, null);
  protected PhoneContactStatusCheckView f;
  protected boolean g = false;
  protected Handler h = new WeakReferenceHandler(Looper.getMainLooper(), null);
  private Runnable i = new PhoneContactFragment.2(this);
  private Runnable j = new PhoneContactFragment.3(this);
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    paramBundle = this.a;
    if (paramBundle == null)
    {
      this.a = paramLayoutInflater.inflate(2131624558, null, false);
      this.b = ((XListView)this.a.findViewById(2131440037));
      this.d = new FrameLayout(this.a.getContext());
      paramLayoutInflater = new AbsListView.LayoutParams(-1, -2);
      this.d.setLayoutParams(paramLayoutInflater);
      this.b.addHeaderView(this.d);
      this.f = new PhoneContactStatusCheckView(this.a.getContext());
      this.f.setOrientation(1);
      this.f.setGravity(17);
      int k = getResources().getDimensionPixelSize(2131298180);
      paramLayoutInflater = new FrameLayout.LayoutParams(-1, k);
      paramLayoutInflater.gravity = 17;
      if (p != null) {
        paramLayoutInflater.height = Math.max(k, p.bottom - p.top);
      }
      this.f.setLayoutParams(paramLayoutInflater);
      this.d.addView(this.f, paramLayoutInflater);
      this.b.setSelector(new ColorDrawable(0));
      this.b.setNeedCheckSpringback(true);
      this.b.setCacheColorHint(0);
      this.b.setDivider(null);
      this.b.setOverScrollMode(0);
      this.b.mForContacts = true;
      this.f.setVisibility(8);
      this.f.setPhoneContactFragment(this);
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.a);
      }
    }
    return this.a;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "doOnDestroy");
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged ");
      localStringBuilder.append(paramInt);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUIBitsChanged ");
      localStringBuilder.append(paramLong);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnResume:");
      localStringBuilder.append(paramBoolean);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    if (this.b == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.c == null)
    {
      this.c = new PhoneContactAdapter(this.w, this.s, this.b, 1, true, this);
      this.b.setAdapter(this.c);
    }
    this.f.a();
    ThreadManager.excute(new PhoneContactFragment.1(this), 16, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecommendCountChanged ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onContactCountChanged");
    }
    c();
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause:");
      localStringBuilder.append(paramBoolean);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    PhoneContactStatusCheckView localPhoneContactStatusCheckView = this.f;
    if (localPhoneContactStatusCheckView != null) {
      localPhoneContactStatusCheckView.a(paramBoolean);
    }
  }
  
  public void bR_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onMayKnowStatesChanged");
    }
    c();
  }
  
  public void bU_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "refresh");
    }
    c();
    ((IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "")).checkUpdateBindStateAndListIgnoreBindState(true, false, 16);
    this.g = true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reset data  mIsTabSelected:");
      ((StringBuilder)localObject).append(this.v);
      QLog.d("PhoneContactFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.v)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.j);
      ThreadManager.getSubThreadHandler().postDelayed(this.j, 500L);
      return;
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((PhoneContactAdapter)localObject).a(this.s);
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateContactList ");
      localStringBuilder.append(paramInt);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  protected void d()
  {
    if ((this.s != null) && (this.v))
    {
      ((IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
      this.s.registObserver(this.e);
      ((INewFriendService)this.s.getRuntimeService(INewFriendService.class, "")).addListener(this);
    }
  }
  
  protected void e()
  {
    if (this.s != null)
    {
      ((IPhoneContactService)this.s.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
      this.s.unRegistObserver(this.e);
      ((INewFriendService)this.s.getRuntimeService(INewFriendService.class, "")).removeListener(this);
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((PhoneContactAdapter)localObject).a();
      this.c.c();
      this.c = null;
    }
  }
  
  public View getScrollableView()
  {
    return this.b;
  }
  
  public void i_(int paramInt) {}
  
  public boolean j()
  {
    PhoneContactStatusCheckView localPhoneContactStatusCheckView = this.f;
    return (localPhoneContactStatusCheckView != null) && (localPhoneContactStatusCheckView.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment
 * JD-Core Version:    0.7.0.1
 */