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
  final int jdField_a_of_type_Int;
  final List<WebViewTabBarData> jdField_a_of_type_JavaUtilList;
  final WeakReference<QQComicTabBarView> jdField_a_of_type_MqqUtilWeakReference;
  final boolean jdField_a_of_type_Boolean;
  
  QQComicTabBarView$MyOnClickListener(QQComicTabBarView paramQQComicTabBarView, int paramInt, boolean paramBoolean, List<WebViewTabBarData> paramList)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQComicTabBarView);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  void a(QQComicTabBarView paramQQComicTabBarView)
  {
    if ((paramQQComicTabBarView.getContext() instanceof QQBrowserActivity))
    {
      localObject = ((QQBrowserActivity)paramQQComicTabBarView.getContext()).getWebViewProvider();
      if ((localObject instanceof QQComicFragment))
      {
        localObject = ((QQComicFragment)localObject).a();
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i = ((List)localObject).size();
      int j = this.jdField_a_of_type_Int;
      if (i > j)
      {
        localObject = ((WebViewTabBarData)this.jdField_a_of_type_JavaUtilList.get(j)).tag;
        QQComicTabBarView.a(paramQQComicTabBarView.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, true);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQComicTabBarView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == paramView.i)
    {
      a(paramView);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - paramView.jdField_a_of_type_Long < 500L) {
      return;
    }
    paramView.jdField_a_of_type_Long = l;
    paramView.setSelectedTab(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.MyOnClickListener
 * JD-Core Version:    0.7.0.1
 */