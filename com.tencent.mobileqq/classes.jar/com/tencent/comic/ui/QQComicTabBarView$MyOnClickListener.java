package com.tencent.comic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.comic.jsp.QQComicJsPlugin;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class QQComicTabBarView$MyOnClickListener
  implements View.OnClickListener
{
  final WeakReference<QQComicTabBarView> a;
  final int b;
  final boolean c;
  final List<WebViewTabBarData> d;
  
  QQComicTabBarView$MyOnClickListener(QQComicTabBarView paramQQComicTabBarView, int paramInt, boolean paramBoolean, List<WebViewTabBarData> paramList)
  {
    this.a = new WeakReference(paramQQComicTabBarView);
    this.b = paramInt;
    this.c = paramBoolean;
    this.d = paramList;
  }
  
  void a(QQComicTabBarView paramQQComicTabBarView)
  {
    if ((paramQQComicTabBarView.getContext() instanceof QQBrowserActivity))
    {
      localObject = ((QQBrowserActivity)paramQQComicTabBarView.getContext()).getWebViewProvider();
      if ((localObject instanceof QQComicFragment))
      {
        localObject = ((QQComicFragment)localObject).c();
        if (localObject != null)
        {
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("source", "comic");
          }
          catch (JSONException localJSONException)
          {
            QLog.e("WebViewTabBarView", 1, localJSONException, new Object[0]);
          }
          ((QQComicJsPlugin)localObject).dispatchJsEvent("qbrowserTabClick", null, localJSONObject);
        }
      }
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      int i = ((List)localObject).size();
      int j = this.b;
      if (i > j)
      {
        localObject = ((WebViewTabBarData)this.d.get(j)).tag;
        QQComicTabBarView.a(paramQQComicTabBarView.h, (String)localObject, true);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQComicTabBarView)this.a.get();
    if (paramView == null) {
      return;
    }
    if (this.b == paramView.x)
    {
      a(paramView);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - paramView.t < 500L) {
      return;
    }
    paramView.t = l;
    paramView.setSelectedTab(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.MyOnClickListener
 * JD-Core Version:    0.7.0.1
 */