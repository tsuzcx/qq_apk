package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory;
import java.lang.ref.SoftReference;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$2
  implements SwiftBrowserComponentsProvider.SwiftBrowserComponentFactory
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$2(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public Object a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    if (PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a) != null)
    {
      PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler localPublicAccountBrowserShareMenuHandler = (PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler)PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a).get();
      if (localPublicAccountBrowserShareMenuHandler != null)
      {
        localPublicAccountBrowserShareMenuHandler.a();
        PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a).clear();
      }
    }
    PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a, new SoftReference(new PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler(this.a, null)));
    return PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a).get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.2
 * JD-Core Version:    0.7.0.1
 */