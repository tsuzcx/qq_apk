package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.FaceConf;

class QQIdentiferLegacy$4
  extends URLSpan
{
  QQIdentiferLegacy$4(QQIdentiferLegacy paramQQIdentiferLegacy, String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("title", this.a.getString(2131693597));
    localIntent.putExtra("selfSet_leftViewText", this.a.getString(2131690706));
    paramView = getURL();
    AppConf localAppConf = QQIdentiferLegacy.a(this.a).getAppConf();
    if ((!"identify".equals(QQIdentiferLegacy.a(this.a))) || (TextUtils.isEmpty(paramView)) || (!paramView.contains("?appname=")))
    {
      StringBuilder localStringBuilder;
      if ("setFaceData".equals(QQIdentiferLegacy.a(this.a)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramView);
        localStringBuilder.append("?appname=qq_safety");
        paramView = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramView);
        if ((localAppConf != null) && (!TextUtils.isEmpty(localAppConf.appName)))
        {
          paramView = new StringBuilder();
          paramView.append("?appname=");
          paramView.append(localAppConf.appName);
          paramView = paramView.toString();
        }
        else
        {
          paramView = "";
        }
        localStringBuilder.append(paramView);
        paramView = localStringBuilder.toString();
      }
    }
    localIntent.putExtra("url", paramView);
    this.a.startActivity(localIntent);
    RouteUtils.a(this.a.getActivity(), localIntent, "/base/browser");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.4
 * JD-Core Version:    0.7.0.1
 */