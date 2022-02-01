package com.tencent.mobileqq.apollo.aio.panel;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

class ApolloPanel$3
  extends ApolloExtensionObserver
{
  private volatile String b = null;
  
  ApolloPanel$3(ApolloPanel paramApolloPanel) {}
  
  private boolean a(@NotNull String paramString, ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      if (paramArrayList.contains(paramString))
      {
        paramString = ApolloPanelUtil.a(paramString, ApolloPanel.f(this.a));
        paramArrayList = new StringBuilder();
        paramArrayList.append("check needReGetFrame, current dressInfo:");
        paramArrayList.append(paramString);
        paramArrayList.append(", old dressInfo:");
        paramArrayList.append(this.b);
        QLog.d("[cmshow]ApolloPanel", 1, paramArrayList.toString());
        if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.b)))
        {
          this.b = paramString;
          return true;
        }
      }
    }
    return false;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (!paramBoolean)
    {
      paramObject = new StringBuilder();
      paramObject.append(this);
      paramObject.append(" onApolloDressChange fail");
      QLog.e("[cmshow]ApolloPanel", 1, paramObject.toString());
      return;
    }
    paramBoolean = false;
    try
    {
      paramObject = (ArrayList)paramObject;
      boolean bool = a(ApolloPanel.g(this.a).d.getCurrentUin(), paramObject);
      paramBoolean = bool;
    }
    catch (Exception paramObject)
    {
      QLog.e("[cmshow]ApolloPanel", 1, "onApolloDressChange needReGetFrame exception", paramObject);
    }
    paramObject = new StringBuilder();
    paramObject.append("onApolloDressChange reGetFrame:");
    paramObject.append(paramBoolean);
    QLog.d("[cmshow]ApolloPanel", 1, paramObject.toString());
    if (!paramBoolean) {
      return;
    }
    if (ApolloPanel.h(this.a))
    {
      ThreadManager.getSubThreadHandler().post(new ApolloPanel.3.1(this));
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloPanel.3.2(this), CmShowWnsUtils.z());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.3
 * JD-Core Version:    0.7.0.1
 */