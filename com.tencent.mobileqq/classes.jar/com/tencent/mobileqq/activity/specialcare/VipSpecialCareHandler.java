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
  private volatile int jdField_a_of_type_Int = 0;
  private Bundle jdField_a_of_type_AndroidOsBundle = null;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  private final int jdField_b_of_type_Int = 1;
  private Bundle jdField_b_of_type_AndroidOsBundle = null;
  private final int c = 90000;
  
  public VipSpecialCareHandler()
  {
    ThreadManager.post(new VipSpecialCareHandler.1(this), 8, null, true);
  }
  
  private final void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int - 1;
    this.jdField_a_of_type_Int = i;
    Object localObject;
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->warning:special care set,uncorrect state,seq=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      a(((StringBuilder)localObject).toString());
      this.jdField_a_of_type_Int = 0;
    }
    try
    {
      localObject = this.jdField_b_of_type_AndroidOsBundle;
      i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      ((Bundle)localObject).putInt("error", i);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", this.jdField_b_of_type_AndroidOsBundle);
      a(this.jdField_a_of_type_AndroidOsBundle);
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
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(1);
    }
    localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null) {
      ((HandlerThread)localObject).quit();
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public final void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      a("-->current request is ongoing,can't do request yet");
      paramBundle2.putInt("error", -1);
      paramBundle1.putBundle("response", paramBundle2);
      a(paramBundle1);
      return;
    }
    this.jdField_a_of_type_Int += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->do request,seq=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
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
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 90000L);
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
      this.jdField_a_of_type_Int = 0;
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
    paramObject = this.jdField_a_of_type_AndroidOsHandler;
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
    paramObject = this.jdField_a_of_type_AndroidOsHandler;
    if (paramObject != null) {
      paramObject.removeMessages(1);
    }
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler
 * JD-Core Version:    0.7.0.1
 */