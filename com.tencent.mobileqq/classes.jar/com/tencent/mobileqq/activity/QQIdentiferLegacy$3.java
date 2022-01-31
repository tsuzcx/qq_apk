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
    localIntent.putExtra("title", this.a.getString(2131628118));
    localIntent.putExtra("selfSet_leftViewText", this.a.getString(2131625011));
    StringBuilder localStringBuilder = new StringBuilder().append(getURL());
    if ((QQIdentiferLegacy.a(this.a) == null) || (TextUtils.isEmpty(QQIdentiferLegacy.a(this.a).appName))) {}
    for (paramView = "";; paramView = "?appname=" + QQIdentiferLegacy.a(this.a).appName)
    {
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.3
 * JD-Core Version:    0.7.0.1
 */