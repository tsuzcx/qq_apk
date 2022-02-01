package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;

class PublicAccountUtilImpl$8
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountUtilImpl$8(PublicAccountUtilImpl paramPublicAccountUtilImpl, IPublicAccountObserver paramIPublicAccountObserver, String paramString, AppInterface paramAppInterface, Context paramContext) {}
  
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
    this.e.sendDetailInfoRequest(this.c, this.d, this.b);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.onUpdate(101, false, this.b);
    }
    PublicAccountUtilImpl.access$300(this.d, 2131892951);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.8
 * JD-Core Version:    0.7.0.1
 */