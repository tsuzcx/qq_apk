package com.tencent.mobileqq.apollo.aio.panel;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class CmshowPanelDialog
{
  public int a;
  public DialogInterface.OnClickListener b = new CmshowPanelDialog.5(this);
  private QQCustomDialog c = null;
  private QQAppInterface d;
  private Activity e;
  
  public CmshowPanelDialog(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    this.d = paramQQAppInterface;
    this.e = paramActivity;
    this.a = paramInt;
  }
  
  protected void a()
  {
    QQCustomDialog localQQCustomDialog = this.c;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.c = null;
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (TextUtils.isEmpty(paramString5)) {
        return;
      }
      if (this.c != null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showAidDialog title=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" content=");
        localStringBuilder.append(paramString3);
        localStringBuilder.append("rightString=");
        localStringBuilder.append(paramString4);
        localStringBuilder.append(" url=");
        localStringBuilder.append(paramString5);
        QLog.d("[cmshow]CmshowPanelDialog", 2, localStringBuilder.toString());
      }
      a();
      boolean bool = "onlyRightType".equals(paramString5);
      int i = 0;
      if (bool)
      {
        paramString1 = new CmshowPanelDialog.1(this);
        i = 1;
      }
      else
      {
        if ("moreInfo".equals(paramString5)) {
          paramString1 = new CmshowPanelDialog.2(this, paramString7);
        }
        for (;;)
        {
          break;
          if ("requestSSO".equals(paramString5))
          {
            paramString1 = new CmshowPanelDialog.3(this, paramString1, paramString7, paramString8);
          }
          else
          {
            if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(String.valueOf(9))))
            {
              ApolloUtilImpl.jumpToH5PreviewAction(this.e, paramString7, paramString9);
              paramString1 = this.d;
              i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.a);
              paramString2 = new StringBuilder();
              paramString2.append("");
              paramString2.append(paramString7);
              VipUtils.a(paramString1, "cmshow", "Apollo", "vip_alert_view", i, 0, new String[] { paramString2.toString(), "0" });
              return;
            }
            paramString1 = new CmshowPanelDialog.4(this, paramString5, paramString6, paramString7, paramString1, paramString9);
          }
        }
      }
      paramString6 = this.e.getResources().getString(2131892733);
      if (i != 0) {
        paramString5 = null;
      } else {
        paramString5 = this.b;
      }
      this.c = DialogUtil.a(this.e, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      paramString1 = this.e;
      if ((paramString1 != null) && (!paramString1.isFinishing())) {
        this.c.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.CmshowPanelDialog
 * JD-Core Version:    0.7.0.1
 */