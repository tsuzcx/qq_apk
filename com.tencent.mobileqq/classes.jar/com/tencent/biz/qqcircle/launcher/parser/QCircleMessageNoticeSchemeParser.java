package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

public class QCircleMessageNoticeSchemeParser
  extends QCircleBaseSchemeParser
{
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    b(paramContext, paramQCircleSchemeBean);
  }
  
  public void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    if (paramQCircleSchemeBean == null) {
      return;
    }
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    Object localObject = paramQCircleSchemeBean.getAttrs();
    a(paramQCircleSchemeBean, localQCircleInitBean);
    if (localObject != null)
    {
      a(localQCircleInitBean, (HashMap)localObject);
      b(localQCircleInitBean, (HashMap)localObject);
      if (((HashMap)localObject).containsKey("to"))
      {
        paramQCircleSchemeBean = (String)((HashMap)localObject).get("to");
        try
        {
          if (!TextUtils.isEmpty(paramQCircleSchemeBean)) {
            localQCircleInitBean.setLaunchTo(Integer.parseInt(paramQCircleSchemeBean));
          }
        }
        catch (NumberFormatException paramQCircleSchemeBean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("launchMessageNoticePage parseNumError:");
          ((StringBuilder)localObject).append(paramQCircleSchemeBean.getMessage());
          QLog.e("QCircleBaseSchemeParser", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
    QCircleLauncher.f(paramContext, localQCircleInitBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleMessageNoticeSchemeParser
 * JD-Core Version:    0.7.0.1
 */