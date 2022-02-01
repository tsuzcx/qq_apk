package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;

class PublicAccountUtilImpl$4
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountUtilImpl$4(PublicAccountUtilImpl paramPublicAccountUtilImpl, IPublicAccountObserver paramIPublicAccountObserver, String paramString, AppInterface paramAppInterface, Context paramContext, int paramInt, boolean paramBoolean) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.onUpdate(101, true, this.b);
    }
    PublicAccountUtilImpl.access$200(this.c, this.d, this.b, this.e);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.onUpdate(101, false, this.b);
    }
    if (this.f) {
      PublicAccountUtilImpl.access$300(this.d, 2131892951);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */