package com.tencent.biz.pubaccount;

import afuh;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public abstract class SuperWebView
  extends WebView
{
  static final String JAVASCRIPT_SCHEME = "javascript:";
  protected Intent mIntent;
  private boolean mIsForceLoadUrl;
  private ArrayList<String> mJsUrlsWaitingForLoad = new ArrayList();
  private boolean mReadyForLoadJs;
  
  public SuperWebView(Context paramContext)
  {
    super(paramContext);
    removeBuiltInJSInterface();
  }
  
  public SuperWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    removeBuiltInJSInterface();
  }
  
  public SuperWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    removeBuiltInJSInterface();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    super.loadData(paramString1, paramString2, paramString3);
    readyForLoadJs();
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    readyForLoadJs();
  }
  
  public void loadUrl(String paramString)
  {
    afuh.a(this.mIntent, paramString);
    if (this.mReadyForLoadJs) {
      if ((Build.VERSION.SDK_INT >= 19) && (paramString != null) && (paramString.startsWith("javascript:"))) {
        super.evaluateJavascript(paramString.substring("javascript:".length()), null);
      }
    }
    do
    {
      do
      {
        return;
        String str = getUrl();
        if ((str != null) && (str.equals(paramString)) && (!this.mIsForceLoadUrl))
        {
          super.reload();
          return;
        }
        super.loadUrl(paramString);
        return;
      } while (TextUtils.isEmpty(paramString));
      if (paramString.startsWith("javascript:"))
      {
        this.mJsUrlsWaitingForLoad.add(paramString);
        return;
      }
      super.loadUrl(paramString);
    } while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")));
    readyForLoadJs();
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    super.loadUrl(paramString, paramMap);
    readyForLoadJs();
  }
  
  public void readyForLoadJs()
  {
    this.mReadyForLoadJs = true;
    if (!this.mJsUrlsWaitingForLoad.isEmpty()) {
      ThreadManager.getUIHandler().postDelayed(new SuperWebView.1(this), 50L);
    }
  }
  
  public void removeBuiltInJSInterface()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public void resetForReuse()
  {
    this.mReadyForLoadJs = false;
    this.mJsUrlsWaitingForLoad.clear();
  }
  
  public void setForceLoadUrl(boolean paramBoolean)
  {
    this.mIsForceLoadUrl = paramBoolean;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SuperWebView
 * JD-Core Version:    0.7.0.1
 */