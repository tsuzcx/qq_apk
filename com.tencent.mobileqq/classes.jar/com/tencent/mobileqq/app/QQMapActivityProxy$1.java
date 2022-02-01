package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QQMapActivityProxy$1
  extends BroadcastReceiver
{
  QQMapActivityProxy$1(QQMapActivityProxy paramQQMapActivityProxy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQMapActivityProxy-onReceive:");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(", action=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.d("QQMapActivityProxy", 2, ((StringBuilder)localObject).toString());
    }
    if (paramContext.equals("com.tencent.mobileqq.addLbsObserver"))
    {
      if (QQMapActivityProxy.a(this.a) != null) {
        QQMapActivityProxy.a(this.a).addObserver(QQMapActivityProxy.a(this.a));
      }
    }
    else if (paramContext.equals("com.tencent.mobileqq.removeLbsObserver"))
    {
      if (QQMapActivityProxy.a(this.a) != null) {
        QQMapActivityProxy.a(this.a).removeObserver(QQMapActivityProxy.a(this.a));
      }
    }
    else if (paramContext.equals("com.tencent.mobileqq.getStreetViewUrl"))
    {
      if (QQMapActivityProxy.a(this.a) != null) {
        ((LBSHandler)QQMapActivityProxy.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b((int)(paramIntent.getDoubleExtra("latitude", 0.0D) * 1000000.0D), (int)(paramIntent.getDoubleExtra("longitude", 0.0D) * 1000000.0D));
      }
    }
    else if (paramContext.equals("com.tencent.mobileqq.unregisterReceiver"))
    {
      try
      {
        QQMapActivityProxy.a(this.a).unregisterReceiver(QQMapActivityProxy.a(this.a));
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramIntent = new StringBuilder();
      paramIntent.append("mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : ");
      paramIntent.append(paramContext.toString());
      QLog.w("QQMapActivityProxy", 2, paramIntent.toString());
    }
    else
    {
      int i;
      int j;
      int k;
      int m;
      int n;
      if (paramContext.equals("com.tencent.mobileqq.getLbsShareSearch"))
      {
        i = paramIntent.getIntExtra("latitude", 0);
        j = paramIntent.getIntExtra("longitude", 0);
        k = paramIntent.getIntExtra("coordinate", 0);
        paramContext = paramIntent.getStringExtra("keyword");
        localObject = paramIntent.getStringExtra("category");
        m = paramIntent.getIntExtra("page", 0);
        n = paramIntent.getIntExtra("count", 0);
        int i1 = paramIntent.getIntExtra("requireMyLbs", 0);
        if (QQMapActivityProxy.a(this.a) != null) {
          ((LBSHandler)QQMapActivityProxy.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(i, j, k, paramContext, (String)localObject, m, n, i1);
        }
      }
      else if (paramContext.equals("com.tencent.mobileqq.getLbsShareShop"))
      {
        i = paramIntent.getIntExtra("latitude", 0);
        j = paramIntent.getIntExtra("longitude", 0);
        k = paramIntent.getIntExtra("coordinate", 0);
        m = paramIntent.getIntExtra("begin", 0);
        n = paramIntent.getIntExtra("count", 0);
        if (QQMapActivityProxy.a(this.a) != null) {
          ((LBSHandler)QQMapActivityProxy.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(i, j, k, m, n);
        }
      }
      else if (paramContext.equals("com.tencent.mobileqq.getShareShopDetail"))
      {
        paramContext = paramIntent.getStringExtra("shop_id");
        if ((!TextUtils.isEmpty(paramContext)) && (QQMapActivityProxy.a(this.a) != null))
        {
          paramIntent = new ArrayList();
          paramIntent.add(paramContext);
          ((LBSHandler)QQMapActivityProxy.a(this.a).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQMapActivityProxy.1
 * JD-Core Version:    0.7.0.1
 */