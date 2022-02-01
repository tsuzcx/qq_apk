package com.tencent.mobileqq.activity.richmedia;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import com.qq.im.poi.LbsPackPoiListServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class LBSDetetor
{
  private static LBSDetetor e;
  private AppInterface a;
  private LBSDetetor.LBSTemplateListener b;
  private LBSDetetor.LBSDetectorObserver c = new LBSDetetor.LBSDetectorObserver(this, null);
  private Handler d = new Handler(new LBSDetetor.1(this));
  
  private LBSDetetor(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    paramAppInterface = this.a;
    if (paramAppInterface != null) {
      paramAppInterface.registObserver(this.c);
    }
  }
  
  public static LBSDetetor a(AppInterface paramAppInterface)
  {
    if (e == null) {
      e = new LBSDetetor(paramAppInterface);
    }
    return e;
  }
  
  private void a(double paramDouble1, double paramDouble2, int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = new NewIntent(((AppInterface)localObject).getApp(), LbsPackPoiListServlet.class);
    ((NewIntent)localObject).putExtra("key_latitude", paramDouble1);
    ((NewIntent)localObject).putExtra("key_longitude", paramDouble2);
    int i = 4;
    ((NewIntent)localObject).putExtra("k_cmd", 4);
    ((NewIntent)localObject).putExtra("key_lbs_template_cookie", paramInt);
    int j = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getBaseContext());
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            if (j != 4) {
              i = 0;
            } else {
              i = 3;
            }
          }
        }
        else {
          i = 5;
        }
      }
      else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    ((NewIntent)localObject).putExtra("key_lbs_template_network_type", i);
    this.a.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLBSTemplateIds. req:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" netType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" latitude:");
      ((StringBuilder)localObject).append(paramDouble1);
      ((StringBuilder)localObject).append(" longitude:");
      ((StringBuilder)localObject).append(paramDouble2);
      QLog.d("LBSDetetor", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callback. isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" cookie: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("LBSDetetor", 2, ((StringBuilder)localObject).toString());
    }
    this.d.removeMessages(paramInt);
    if (this.b != null)
    {
      localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList(1);
      }
      this.b.a(paramInt, paramBoolean, (ArrayList)localObject);
    }
  }
  
  @TargetApi(19)
  public void a(int paramInt)
  {
    boolean bool4 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool4;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          bool2 = bool4;
          localObject3 = BaseApplicationImpl.getApplication().getBaseContext();
          bool2 = bool4;
          Object localObject1 = (AppOpsManager)((Context)localObject3).getSystemService("appops");
          bool2 = bool4;
          localObject3 = ((Context)localObject3).getApplicationInfo();
          bool2 = bool4;
          int i = ((AppOpsManager)localObject1).checkOpNoThrow("android:fine_location", ((ApplicationInfo)localObject3).uid, ((ApplicationInfo)localObject3).packageName);
          bool2 = bool4;
          int j = ((AppOpsManager)localObject1).checkOpNoThrow("android:coarse_location", ((ApplicationInfo)localObject3).uid, ((ApplicationInfo)localObject3).packageName);
          if ((i != 0) || (j != 0)) {
            break label364;
          }
          bool2 = bool1;
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            localObject1 = new StringBuilder();
            bool2 = bool1;
            ((StringBuilder)localObject1).append("check permission by AppOpsManager:");
            bool2 = bool1;
            ((StringBuilder)localObject1).append(bool1);
            bool2 = bool1;
            QLog.d("LBSDetetor", 2, ((StringBuilder)localObject1).toString());
            bool3 = bool1;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        bool3 = bool2;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("something wrong:");
          ((StringBuilder)localObject3).append(localException.toString());
          QLog.d("LBSDetetor", 2, ((StringBuilder)localObject3).toString());
          bool3 = bool2;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startCheckPermissionAndDetetLocation. hasPermission:");
        ((StringBuilder)localObject2).append(bool3);
        QLog.d("LBSDetetor", 2, ((StringBuilder)localObject2).toString());
      }
      this.d.removeMessages(paramInt);
      if (bool3)
      {
        this.d.sendEmptyMessageDelayed(paramInt, 30000L);
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new LBSDetetor.LBSLocationListener(this, 0, true, true, 30000L, false, false, "NewFlowCameraActivity", paramInt));
      }
      Object localObject2 = this.b;
      if (localObject2 != null) {
        ((LBSDetetor.LBSTemplateListener)localObject2).a(paramInt, bool3);
      }
      return;
      label364:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.LBSDetetor
 * JD-Core Version:    0.7.0.1
 */