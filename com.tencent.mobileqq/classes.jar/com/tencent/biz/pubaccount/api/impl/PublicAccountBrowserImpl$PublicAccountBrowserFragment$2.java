package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory;
import java.lang.ref.SoftReference;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$2
  implements SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$2(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public Object a(int paramInt)
  {
    if (paramInt != 4) {
      return null;
    }
    if (PublicAccountBrowserImpl.PublicAccountBrowserFragment.f(this.a) != null)
    {
      localObject = (PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler)PublicAccountBrowserImpl.PublicAccountBrowserFragment.f(this.a).get();
      if (localObject != null)
      {
        ((PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler)localObject).b();
        PublicAccountBrowserImpl.PublicAccountBrowserFragment.f(this.a).clear();
      }
    }
    Object localObject = this.a;
    PublicAccountBrowserImpl.PublicAccountBrowserFragment.a((PublicAccountBrowserImpl.PublicAccountBrowserFragment)localObject, new SoftReference(new PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler((PublicAccountBrowserImpl.PublicAccountBrowserFragment)localObject, null)));
    return PublicAccountBrowserImpl.PublicAccountBrowserFragment.f(this.a).get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.2
 * JD-Core Version:    0.7.0.1
 */