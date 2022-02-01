package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;

class QQIdentiferLegacy$3
  extends URLSpan
{
  QQIdentiferLegacy$3(QQIdentiferLegacy paramQQIdentiferLegacy, String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("title", this.a.getString(2131693219));
    localIntent.putExtra("selfSet_leftViewText", this.a.getString(2131690559));
    paramView = getURL();
    if (("identify".equals(QQIdentiferLegacy.a(this.a))) && (!TextUtils.isEmpty(paramView)) && (paramView.contains("?appname="))) {}
    for (;;)
    {
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      return;
      if (!"setFaceData".equals(QQIdentiferLegacy.a(this.a))) {
        break;
      }
      paramView = paramView + "?appname=qq_safety";
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramView);
    if ((QQIdentiferLegacy.a(this.a) == null) || (TextUtils.isEmpty(QQIdentiferLegacy.a(this.a).appName))) {}
    for (paramView = "";; paramView = "?appname=" + QQIdentiferLegacy.a(this.a).appName)
    {
      paramView = paramView;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.3
 * JD-Core Version:    0.7.0.1
 */