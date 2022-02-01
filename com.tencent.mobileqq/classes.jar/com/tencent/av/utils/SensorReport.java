package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorReport
{
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new SensorReport.1();
  static String jdField_a_of_type_JavaLangString = "actAVGSensorCaseReport";
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  SensorReport.ScreenInfo jdField_a_of_type_ComTencentAvUtilsSensorReport$ScreenInfo = null;
  ArrayList<SensorReport.ScreenInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int = 4;
  private long jdField_d_of_type_Long = 0L;
  int jdField_e_of_type_Int = 8;
  private long jdField_e_of_type_Long;
  int jdField_f_of_type_Int = 16;
  private long jdField_f_of_type_Long;
  int g = 32;
  int h = 0;
  final int i = 0;
  final int j = 1;
  final int k = 2;
  
  private void a(int paramInt, ArrayList<SensorReport.ScreenInfo> paramArrayList)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_e_of_type_Long == 0L) || (paramArrayList.size() > 0)) {}
    try
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("size", paramArrayList.size());
        localObject2 = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject3 = (SensorReport.ScreenInfo)paramArrayList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("i", ((SensorReport.ScreenInfo)localObject3).jdField_a_of_type_Int);
          localJSONObject.put("off", ((SensorReport.ScreenInfo)localObject3).jdField_a_of_type_Long);
          localJSONObject.put("on", ((SensorReport.ScreenInfo)localObject3).jdField_b_of_type_Long);
          localJSONObject.put("why", ((SensorReport.ScreenInfo)localObject3).jdField_c_of_type_Long);
          ((JSONArray)localObject2).put(localJSONObject);
        }
        ((JSONObject)localObject1).put("infos", localObject2);
        paramArrayList = ((JSONObject)localObject1).toString();
      }
      catch (Exception paramArrayList)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("json_");
        ((StringBuilder)localObject1).append(paramArrayList.getClass().getName());
        ((StringBuilder)localObject1).append(". ");
        paramArrayList = ((StringBuilder)localObject1).toString();
      }
    }
    catch (JSONException paramArrayList)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      label213:
      break label213;
    }
    paramArrayList = "JSONException. ";
    break label222;
    paramArrayList = "";
    label222:
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("guid", this.jdField_c_of_type_JavaLangString);
    ((HashMap)localObject1).put("RoomID", String.valueOf(this.jdField_e_of_type_Long));
    ((HashMap)localObject1).put("EnterRoomTime", String.valueOf(this.jdField_f_of_type_Long));
    ((HashMap)localObject1).put("screenInfo", paramArrayList);
    ((HashMap)localObject1).put("StartSensorTime", String.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject1).put("EndSensorTime", String.valueOf(this.jdField_b_of_type_Long));
    ((HashMap)localObject1).put("SetIgnore", String.valueOf(this.jdField_c_of_type_Long));
    ((HashMap)localObject1).put("ClearIgnore", String.valueOf(this.jdField_d_of_type_Long));
    ((HashMap)localObject1).put("reportType", String.valueOf(paramInt));
    ((HashMap)localObject1).put("Log", this.jdField_b_of_type_JavaLangString);
    ((HashMap)localObject1).put("ScreenInfoCount", String.valueOf(this.h));
    if (this.jdField_c_of_type_Long != 0L)
    {
      ((HashMap)localObject1).put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject1).put("devicesInfo", AppSetting.jdField_c_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mRoomID[");
      ((StringBuilder)localObject3).append(this.jdField_e_of_type_Long);
      ((StringBuilder)localObject3).append("], guid[");
      ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("], [");
      ((StringBuilder)localObject3).append(paramArrayList);
      QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      paramArrayList = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      QLog.d(paramArrayList, 1, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 0)
    {
      paramArrayList = (VideoAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramArrayList != null)
      {
        localObject2 = new Intent(jdField_a_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("params", (Serializable)localObject1);
        ((Intent)localObject2).setPackage(paramArrayList.getApp().getPackageName());
        paramArrayList.getApp().sendBroadcast((Intent)localObject2);
      }
    }
    else
    {
      UserAction.onUserAction(jdField_a_of_type_JavaLangString, true, -1L, -1L, (Map)localObject1, true);
    }
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentAvUtilsSensorReport$ScreenInfo = null;
    if (paramInt != 1)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
    }
    return;
    if (QLog.isDevelopLevel())
    {
      paramArrayList = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("report Ignore, mRoomID[");
      ((StringBuilder)localObject1).append(this.jdField_e_of_type_Long);
      ((StringBuilder)localObject1).append("], guid[");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      QLog.d(paramArrayList, 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void a(Context paramContext)
  {
    AudioHelper.a(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(jdField_a_of_type_JavaLangString);
    ThreadManager.post(new SensorReport.2(paramContext, localIntentFilter), 5, null, false);
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unregistonUserActionReceiver e = ");
        localStringBuilder.append(paramContext);
        QLog.d("SensorReport", 2, localStringBuilder.toString());
      }
    }
  }
  
  void a()
  {
    long l = System.currentTimeMillis();
    String str = UUID.randomUUID().toString();
    if (this.jdField_a_of_type_Long != 0L)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]begin had came[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      a(2, (ArrayList)localObject);
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_c_of_type_JavaLangString = str;
  }
  
  void a(VideoController paramVideoController)
  {
    if (paramVideoController != null)
    {
      this.jdField_e_of_type_Long = paramVideoController.f();
      if (this.jdField_e_of_type_Long != 0L)
      {
        int m = paramVideoController.a().jdField_d_of_type_Int;
        if ((m == 3) || (m == 4)) {
          this.jdField_f_of_type_Long = paramVideoController.e();
        }
        if (QLog.isDevelopLevel())
        {
          paramVideoController = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setRoomID[");
          localStringBuilder.append(this.jdField_e_of_type_Long);
          localStringBuilder.append("], EnterRoomTime[");
          localStringBuilder.append(this.jdField_f_of_type_Long);
          QLog.d(paramVideoController, 4, localStringBuilder.toString());
        }
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, VideoController paramVideoController)
  {
    if (this.jdField_e_of_type_Long == 0L) {
      a(paramVideoController);
    }
    int n = this.jdField_a_of_type_Int;
    int m = n;
    if (!paramBoolean1) {
      m = n | this.jdField_d_of_type_Int;
    }
    n = m;
    if (!paramBoolean2) {
      n = m | this.jdField_e_of_type_Int;
    }
    m = n;
    if (paramBoolean3) {
      m = n | this.jdField_b_of_type_Int;
    }
    n = m;
    if (paramInt == 3) {
      n = m | this.jdField_c_of_type_Int;
    }
    m = n;
    if (paramInt == 1) {
      m = n | this.jdField_f_of_type_Int;
    }
    paramInt = m;
    if (paramBoolean4) {
      paramInt = m | this.g;
    }
    long l = System.currentTimeMillis();
    paramVideoController = this.jdField_a_of_type_ComTencentAvUtilsSensorReport$ScreenInfo;
    this.jdField_a_of_type_ComTencentAvUtilsSensorReport$ScreenInfo = null;
    if (paramVideoController != null)
    {
      paramVideoController.jdField_b_of_type_Long = l;
      paramVideoController.jdField_c_of_type_Long = paramInt;
    }
    else
    {
      paramVideoController = new StringBuilder();
      paramVideoController.append(this.jdField_b_of_type_JavaLangString);
      paramVideoController.append("setScreenOn_LastScreenInfo_null[");
      paramVideoController.append(l);
      paramVideoController.append("], why[");
      paramVideoController.append(paramInt);
      paramVideoController.append("]。");
      this.jdField_b_of_type_JavaLangString = paramVideoController.toString();
    }
    if ((!paramBoolean4) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= 6))
    {
      paramVideoController = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      a(1, paramVideoController);
    }
  }
  
  void b()
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("end_came[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append("]。");
      this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(0, (ArrayList)localObject);
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentAvUtilsSensorReport$ScreenInfo = new SensorReport.ScreenInfo(this);
    SensorReport.ScreenInfo localScreenInfo = this.jdField_a_of_type_ComTencentAvUtilsSensorReport$ScreenInfo;
    int m = this.h;
    localScreenInfo.jdField_a_of_type_Int = m;
    this.h = (m + 1);
    localScreenInfo.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvUtilsSensorReport$ScreenInfo);
  }
  
  void d()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_c_of_type_Long != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("setIgnore[");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("->");
      localStringBuilder.append(l);
      localStringBuilder.append("]。");
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_c_of_type_Long = l;
  }
  
  void e()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_d_of_type_Long != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("clearIgnoreFlag[");
      localStringBuilder.append(this.jdField_d_of_type_Long);
      localStringBuilder.append("->");
      localStringBuilder.append(l);
      localStringBuilder.append("]。");
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_d_of_type_Long = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorReport
 * JD-Core Version:    0.7.0.1
 */