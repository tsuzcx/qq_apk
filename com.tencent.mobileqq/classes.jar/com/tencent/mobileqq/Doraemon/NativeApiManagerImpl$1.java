package com.tencent.mobileqq.Doraemon;

import android.util.LruCache;
import com.tencent.mobileqq.Doraemon.impl.webview.WebViewDoraemonAPIManager;

class NativeApiManagerImpl$1
  extends LruCache<String, WebViewDoraemonAPIManager>
{
  NativeApiManagerImpl$1(NativeApiManagerImpl paramNativeApiManagerImpl, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, WebViewDoraemonAPIManager paramWebViewDoraemonAPIManager1, WebViewDoraemonAPIManager paramWebViewDoraemonAPIManager2)
  {
    super.entryRemoved(paramBoolean, paramString, paramWebViewDoraemonAPIManager1, paramWebViewDoraemonAPIManager2);
    paramWebViewDoraemonAPIManager1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.NativeApiManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */