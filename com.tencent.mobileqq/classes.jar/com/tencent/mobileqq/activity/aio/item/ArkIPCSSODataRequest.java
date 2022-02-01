package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateSSO;
import java.lang.ref.WeakReference;

class ArkIPCSSODataRequest
  extends ArkSSODataRequest
{
  public ArkIPCSSODataRequest(String paramString)
  {
    super(null, paramString);
  }
  
  protected boolean a(ArkSSODataRequest.Request paramRequest, int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this);
    IArkDelegateSSO localIArkDelegateSSO = ArkDelegateManager.getInstance().getSSODelegate();
    if (localIArkDelegateSSO == null) {
      return false;
    }
    localIArkDelegateSSO.send(paramRequest.a, paramRequest.b, paramInt, new ArkIPCSSODataRequest.1(this, localWeakReference, paramRequest));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkIPCSSODataRequest
 * JD-Core Version:    0.7.0.1
 */