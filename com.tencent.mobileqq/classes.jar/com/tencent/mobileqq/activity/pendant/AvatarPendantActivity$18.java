package com.tencent.mobileqq.activity.pendant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class AvatarPendantActivity$18
  implements IApolloExtensionObserver
{
  AvatarPendantActivity$18(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("pendantId");
    paramObject.getInt("seriesId");
    Object localObject = paramObject.getString("uin");
    int i = paramObject.getInt("result");
    if (l != -1L)
    {
      if (localObject == null) {
        return;
      }
      if (paramBoolean)
      {
        if (l == 0L)
        {
          this.a.F.setVisibility(4);
          this.a.X.setVisibility(8);
          AvatarPendantActivity.e(this.a);
          if (this.a.T != null) {
            this.a.T.j = -1;
          }
          ReportController.b(this.a.app, "CliOper", "", "", "0X8005FD4", "0X8005FD4", 0, 0, "", "", "", "");
        }
        else
        {
          this.a.Y.setText(2131916326);
          this.a.F.setVisibility(0);
          this.a.X.setVisibility(0);
          localObject = this.a.app;
          if (this.a.ad) {
            paramObject = "1";
          } else {
            paramObject = "0";
          }
          ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8005FD6", "0X8005FD6", 0, 0, paramObject, "", "", "");
          if (this.a.ad) {
            this.a.ad = false;
          }
        }
        if ((this.a.B != null) && (this.a.aj != null))
        {
          paramObject = ((AvatarPendantManager)this.a.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).f();
          this.a.B.a(paramObject, this.a.aj, AvatarPendantActivity.c(this.a));
        }
        if ((this.a.S != null) && (this.a.S.d))
        {
          localObject = IndividuationUrlHelper.a("linkPendantSet");
          paramObject = localObject;
          if (localObject != null) {
            paramObject = ((String)localObject).replace("[id]", String.valueOf(this.a.S.a));
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handlePendantAuth, mPendantInfo.isLink == true, jump to url =");
            ((StringBuilder)localObject).append(paramObject);
            QLog.i("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
          }
          localObject = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramObject);
          ((Intent)localObject).putExtra("hide_more_button", true);
          ((Intent)localObject).putExtra("webStyle", "noBottomBar");
          this.a.startActivity((Intent)localObject);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006517", "0X8006517", 0, 0, "", "", "", "");
        }
      }
      else
      {
        paramObject = (PendantTipsInfo)paramObject.getSerializable("tipsInfo");
        if (paramObject != null)
        {
          this.a.a(paramObject, l, i);
          return;
        }
        paramObject = new StringBuilder();
        paramObject.append("handlePendantAuth, tipsInfo == null, pendantId = ");
        paramObject.append(l);
        QLog.e("AvatarPendantActivity", 1, paramObject.toString());
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.18
 * JD-Core Version:    0.7.0.1
 */