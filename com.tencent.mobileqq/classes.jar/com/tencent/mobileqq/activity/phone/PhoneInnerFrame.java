package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

public class PhoneInnerFrame
  extends InnerFrame
{
  boolean a;
  private ContactListView b;
  private BaseActivityView c;
  private PhoneLaunchView d;
  private PhoneMatchView e;
  private ContactBindObserver f;
  private int g = 0;
  private BaseActivityView.IPhoneContext h;
  
  public PhoneInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Intent paramIntent)
  {
    if (this.e == null) {
      this.e = new PhoneMatchView(getActivity(), this.g);
    }
    a(paramIntent, this.e);
  }
  
  private void a(Intent paramIntent, BaseActivityView paramBaseActivityView)
  {
    BaseActivityView localBaseActivityView = this.c;
    if (localBaseActivityView != paramBaseActivityView)
    {
      if (localBaseActivityView != null)
      {
        if (this.a) {
          localBaseActivityView.c();
        }
        this.c.d();
      }
      this.c = paramBaseActivityView;
      this.c.a(paramIntent, this);
      this.c.a();
      if (this.a) {
        this.c.b();
      }
      setContentView(this.c);
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (this.d == null) {
      this.d = new PhoneLaunchView(getActivity(), this.g);
    }
    a(paramIntent, this.d);
  }
  
  private void i()
  {
    if (this.b == null) {
      this.b = new ContactListView(getContext(), this.g);
    }
    a(null, this.b);
  }
  
  public void a()
  {
    BaseActivityView localBaseActivityView = this.c;
    if (localBaseActivityView != null) {
      localBaseActivityView.b();
    }
    this.a = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    getActivity().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    BaseActivityView localBaseActivityView = this.c;
    if (localBaseActivityView != null) {
      localBaseActivityView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getComponent().getClassName();
    if (str.equals(ContactListView.class.getName()))
    {
      i();
      return;
    }
    if (str.equals(PhoneLaunchActivity.class.getName()))
    {
      b(paramIntent);
      return;
    }
    if (str.equals(PhoneMatchView.class.getName()))
    {
      a(null);
      return;
    }
    getActivity().startActivityForResult(paramIntent, paramInt);
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((BaseActivityView)localObject).c();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ContactListView)localObject).c();
    }
    this.a = false;
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (paramBundle != null) {
      this.g = paramBundle.getInt("key_req_type");
    }
    h();
    if (this.f == null)
    {
      this.f = new PhoneInnerFrame.1(this);
      getPhoneContext().a().registObserver(this.f);
    }
  }
  
  public void c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((BaseActivityView)localObject).d();
      this.c = null;
      removeAllViews();
    }
    if (this.f != null)
    {
      getPhoneContext().a().unRegistObserver(this.f);
      this.f = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((ContactListView)localObject).e();
      this.b = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((PhoneLaunchView)localObject).e();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((PhoneMatchView)localObject).e();
      this.e = null;
    }
    super.c();
  }
  
  public void d()
  {
    this.b = null;
    this.e = null;
    this.d = null;
    this.c = null;
    super.d();
  }
  
  protected BaseActivityView.IPhoneContext f()
  {
    return null;
  }
  
  public void g()
  {
    getInnerFrameManager().a(0);
  }
  
  public ForwardBaseOption getForwardOption()
  {
    ContactListView localContactListView = this.b;
    if (localContactListView != null) {
      return localContactListView.t;
    }
    return null;
  }
  
  public final BaseActivityView.IPhoneContext getPhoneContext()
  {
    if (this.h == null) {
      this.h = f();
    }
    return this.h;
  }
  
  void h()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)getPhoneContext().a().getRuntimeService(IPhoneContactService.class, "");
    switch (localIPhoneContactService.getSelfBindState())
    {
    default: 
      i();
      return;
    case 6: 
      if ((!localIPhoneContactService.isAutoUploadContacts()) && (this.g != 2))
      {
        a(null);
        return;
      }
      i();
      return;
    case 4: 
    case 5: 
      b(null);
      return;
    case 1: 
    case 2: 
    case 3: 
      if (this.g == 2)
      {
        i();
        return;
      }
      b(null);
      return;
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame
 * JD-Core Version:    0.7.0.1
 */