package com.tencent.mobileqq.activity.specialcare;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class VipSpecialCareHandler
  extends QvipSpecialCareObserver
  implements IPCConstants
{
  private Bundle b = null;
  private Bundle c = null;
  private volatile int d = 0;
  private HandlerThread e = null;
  private Handler f = null;
  private final int g = 1;
  private final int h = 90000;
  
  public VipSpecialCareHandler()
  {
    ThreadManager.post(new VipSpecialCareHandler.1(this), 8, null, true);
  }
  
  private final void a(int paramInt)
  {
    int i = this.d - 1;
    this.d = i;
    Object localObject;
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->warning:special care set,uncorrect state,seq=");
      ((StringBuilder)localObject).append(this.d);
      a(((StringBuilder)localObject).toString());
      this.d = 0;
    }
    try
    {
      localObject = this.c;
      i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      ((Bundle)localObject).putInt("error", i);
      this.b.putBundle("response", this.c);
      a(this.b);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareHandler", 2, paramString);
    }
  }
  
  public void a()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(1);
    }
    localObject = this.e;
    if (localObject != null) {
      ((HandlerThread)localObject).quit();
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public final void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.b = paramBundle1;
    this.c = paramBundle2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (this.d != 0)
    {
      a("-->current request is ongoing,can't do request yet");
      paramBundle2.putInt("error", -1);
      paramBundle1.putBundle("response", paramBundle2);
      a(paramBundle1);
      return;
    }
    this.d += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->do request,seq=");
    ((StringBuilder)localObject).append(this.d);
    a(((StringBuilder)localObject).toString());
    try
    {
      a(paramBundle1, paramBundle2);
      boolean bool = "sepcial_care_delete_ring".equals(paramString);
      if ((bool) || ("special_care_set_ring".equals(paramString)))
      {
        paramBundle1 = paramBundle1.getBundle("request");
        int i = paramBundle1.getInt("id", 1);
        paramBundle2 = paramBundle1.getString("uin");
        paramBundle1 = paramBundle2;
        if (paramBundle2 == null) {
          paramBundle1 = "";
        }
        paramBundle2 = new ArrayList();
        paramBundle2.add(paramBundle1);
        localObject = new ArrayList();
        ((List)localObject).add(String.valueOf(i));
        if (this.f != null) {
          this.f.sendEmptyMessageDelayed(1, 90000L);
        }
        if ("special_care_set_ring".equals(paramString))
        {
          if (i == 1) {
            QvipSpecialCareUtil.a(paramBundle2, 2, (List)localObject, paramQQAppInterface);
          } else {
            QvipSpecialCareUtil.a(paramBundle2, 3, (List)localObject, paramQQAppInterface);
          }
          paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          paramString = new StringBuilder();
          paramString.append("specialcare_already_set");
          paramString.append(paramBundle1);
          paramString = paramString.toString();
          paramQQAppInterface.edit().putBoolean(paramString, true).commit();
          return;
        }
        QvipSpecialCareUtil.a(paramBundle2, 4, (List)localObject, paramQQAppInterface);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      this.d = 0;
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      int i = ((Integer)paramObject).intValue();
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            a("-->method_type_delete_sound");
          }
        }
        else {
          a("-->method_type_set_sound");
        }
      }
      else {
        a("-->method_type_open_switch");
      }
    }
    paramObject = this.f;
    if (paramObject != null) {
      paramObject.removeMessages(1);
    }
    a(0);
  }
  
  public void b(Object paramObject)
  {
    int i;
    if (paramObject != null)
    {
      i = ((Integer)paramObject).intValue();
      if (i == 10010)
      {
        a("-->error:set quota limit");
      }
      else
      {
        paramObject = new StringBuilder();
        paramObject.append("-->error:");
        paramObject.append(i);
        a(paramObject.toString());
      }
    }
    else
    {
      i = -1;
    }
    paramObject = this.f;
    if (paramObject != null) {
      paramObject.removeMessages(1);
    }
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler
 * JD-Core Version:    0.7.0.1
 */