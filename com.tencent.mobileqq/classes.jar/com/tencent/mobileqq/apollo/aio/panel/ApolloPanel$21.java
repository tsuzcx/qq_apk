package com.tencent.mobileqq.apollo.aio.panel;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class ApolloPanel$21
  extends ApolloExtensionObserver
{
  ApolloPanel$21(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, result=", Boolean.valueOf(paramBoolean), ", data=", paramObject });
    }
    if (!(paramObject instanceof HashMap))
    {
      QLog.e("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] data is empty! ");
      return;
    }
    paramObject = (HashMap)paramObject;
    Object localObject = (String)paramObject.get("optFrom");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!"newActionFloatView".equals(localObject)) {
        return;
      }
      ApolloPanel.g(this.c).d.removeObserver(this);
      if (paramBoolean)
      {
        ApolloPanel.a(this.c, this.a, 0, 21, this.b, null);
        return;
      }
      localObject = new Bundle();
      paramObject = (String)paramObject.get("url");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, activityUrl=", paramObject });
      }
      ((Bundle)localObject).putString("activityUrl", paramObject);
      ApolloPanel.a(this.c, this.a, 1, 22, this.b, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.21
 * JD-Core Version:    0.7.0.1
 */