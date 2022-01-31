package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Map;
import kzw;
import mqq.os.MqqHandler;

public abstract class SuperWebView
  extends WebView
{
  protected Intent a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public SuperWebView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public SuperWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public SuperWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void c()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      ThreadManager.getUIHandler().postDelayed(new kzw(this), 50L);
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    super.loadData(paramString1, paramString2, paramString3);
    d();
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    d();
  }
  
  public void loadUrl(String paramString)
  {
    AIOOpenWebMonitor.a(this.jdField_a_of_type_AndroidContentIntent, paramString);
    if (this.jdField_a_of_type_Boolean) {
      super.loadUrl(paramString);
    }
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      if (paramString.startsWith("javascript:"))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        return;
      }
      super.loadUrl(paramString);
    } while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")));
    d();
  }
  
  public void loadUrl(String paramString, Map paramMap)
  {
    super.loadUrl(paramString, paramMap);
    d();
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SuperWebView
 * JD-Core Version:    0.7.0.1
 */