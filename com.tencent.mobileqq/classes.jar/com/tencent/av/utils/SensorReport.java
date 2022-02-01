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
  static String n = "actAVGSensorCaseReport";
  private static BroadcastReceiver w = new SensorReport.1();
  int a = 0;
  int b = 1;
  int c = 2;
  int d = 4;
  int e = 8;
  int f = 16;
  int g = 32;
  SensorReport.ScreenInfo h = null;
  int i = 0;
  ArrayList<SensorReport.ScreenInfo> j = new ArrayList();
  final int k = 0;
  final int l = 1;
  final int m = 2;
  private long o = 0L;
  private long p = 0L;
  private long q = 0L;
  private long r = 0L;
  private String s = "";
  private String t;
  private long u;
  private long v;
  
  private void a(int paramInt, ArrayList<SensorReport.ScreenInfo> paramArrayList)
  {
    if ((this.o == 0L) || (this.u == 0L) || (paramArrayList.size() > 0)) {}
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
          localJSONObject.put("i", ((SensorReport.ScreenInfo)localObject3).a);
          localJSONObject.put("off", ((SensorReport.ScreenInfo)localObject3).b);
          localJSONObject.put("on", ((SensorReport.ScreenInfo)localObject3).c);
          localJSONObject.put("why", ((SensorReport.ScreenInfo)localObject3).d);
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
    ((HashMap)localObject1).put("guid", this.t);
    ((HashMap)localObject1).put("RoomID", String.valueOf(this.u));
    ((HashMap)localObject1).put("EnterRoomTime", String.valueOf(this.v));
    ((HashMap)localObject1).put("screenInfo", paramArrayList);
    ((HashMap)localObject1).put("StartSensorTime", String.valueOf(this.o));
    ((HashMap)localObject1).put("EndSensorTime", String.valueOf(this.p));
    ((HashMap)localObject1).put("SetIgnore", String.valueOf(this.q));
    ((HashMap)localObject1).put("ClearIgnore", String.valueOf(this.r));
    ((HashMap)localObject1).put("reportType", String.valueOf(paramInt));
    ((HashMap)localObject1).put("Log", this.s);
    ((HashMap)localObject1).put("ScreenInfoCount", String.valueOf(this.i));
    if (this.q != 0L)
    {
      ((HashMap)localObject1).put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject1).put("devicesInfo", AppSetting.u);
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = n;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mRoomID[");
      ((StringBuilder)localObject3).append(this.u);
      ((StringBuilder)localObject3).append("], guid[");
      ((StringBuilder)localObject3).append(this.t);
      ((StringBuilder)localObject3).append("], [");
      ((StringBuilder)localObject3).append(paramArrayList);
      QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
    }
    if (!TextUtils.isEmpty(this.s))
    {
      paramArrayList = n;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.t);
      ((StringBuilder)localObject2).append(this.s);
      QLog.d(paramArrayList, 1, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 0)
    {
      paramArrayList = (VideoAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramArrayList != null)
      {
        localObject2 = new Intent(n);
        ((Intent)localObject2).putExtra("params", (Serializable)localObject1);
        ((Intent)localObject2).setPackage(paramArrayList.getApp().getPackageName());
        paramArrayList.getApp().sendBroadcast((Intent)localObject2);
      }
    }
    else
    {
      UserAction.onUserAction(n, true, -1L, -1L, (Map)localObject1, true);
    }
    this.s = "";
    this.h = null;
    if (paramInt != 1)
    {
      this.o = 0L;
      this.p = 0L;
      this.q = 0L;
      this.r = 0L;
    }
    return;
    if (QLog.isDevelopLevel())
    {
      paramArrayList = n;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("report Ignore, mRoomID[");
      ((StringBuilder)localObject1).append(this.u);
      ((StringBuilder)localObject1).append("], guid[");
      ((StringBuilder)localObject1).append(this.t);
      QLog.d(paramArrayList, 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void a(Context paramContext)
  {
    AudioHelper.a(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(n);
    ThreadManager.post(new SensorReport.2(paramContext, localIntentFilter), 5, null, false);
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(w);
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
    long l1 = System.currentTimeMillis();
    String str = UUID.randomUUID().toString();
    if (this.o != 0L)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]begin had came[");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      this.s = ((StringBuilder)localObject).toString();
      if (this.p == 0L) {
        this.p = l1;
      }
      localObject = this.j;
      this.j = new ArrayList();
      a(2, (ArrayList)localObject);
    }
    this.o = l1;
    this.t = str;
  }
  
  void a(VideoController paramVideoController)
  {
    if (paramVideoController != null)
    {
      this.u = paramVideoController.as();
      if (this.u != 0L)
      {
        int i1 = paramVideoController.k().g;
        if ((i1 == 3) || (i1 == 4)) {
          this.v = paramVideoController.aq();
        }
        if (QLog.isDevelopLevel())
        {
          paramVideoController = n;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setRoomID[");
          localStringBuilder.append(this.u);
          localStringBuilder.append("], EnterRoomTime[");
          localStringBuilder.append(this.v);
          QLog.d(paramVideoController, 4, localStringBuilder.toString());
        }
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, VideoController paramVideoController)
  {
    if (this.u == 0L) {
      a(paramVideoController);
    }
    int i2 = this.a;
    int i1 = i2;
    if (!paramBoolean1) {
      i1 = i2 | this.d;
    }
    i2 = i1;
    if (!paramBoolean2) {
      i2 = i1 | this.e;
    }
    i1 = i2;
    if (paramBoolean3) {
      i1 = i2 | this.b;
    }
    i2 = i1;
    if (paramInt == 3) {
      i2 = i1 | this.c;
    }
    i1 = i2;
    if (paramInt == 1) {
      i1 = i2 | this.f;
    }
    paramInt = i1;
    if (paramBoolean4) {
      paramInt = i1 | this.g;
    }
    long l1 = System.currentTimeMillis();
    paramVideoController = this.h;
    this.h = null;
    if (paramVideoController != null)
    {
      paramVideoController.c = l1;
      paramVideoController.d = paramInt;
    }
    else
    {
      paramVideoController = new StringBuilder();
      paramVideoController.append(this.s);
      paramVideoController.append("setScreenOn_LastScreenInfo_null[");
      paramVideoController.append(l1);
      paramVideoController.append("], why[");
      paramVideoController.append(paramInt);
      paramVideoController.append("]。");
      this.s = paramVideoController.toString();
    }
    if ((!paramBoolean4) && (this.j.size() >= 6))
    {
      paramVideoController = this.j;
      this.j = new ArrayList();
      a(1, paramVideoController);
    }
  }
  
  void b()
  {
    if (this.p != 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append("end_came[");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append("]。");
      this.s = ((StringBuilder)localObject).toString();
    }
    this.p = System.currentTimeMillis();
    Object localObject = this.j;
    this.j = new ArrayList();
    a(0, (ArrayList)localObject);
  }
  
  void c()
  {
    this.h = new SensorReport.ScreenInfo(this);
    SensorReport.ScreenInfo localScreenInfo = this.h;
    int i1 = this.i;
    localScreenInfo.a = i1;
    this.i = (i1 + 1);
    localScreenInfo.b = System.currentTimeMillis();
    this.j.add(this.h);
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis();
    if (this.q != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.s);
      localStringBuilder.append("setIgnore[");
      localStringBuilder.append(this.q);
      localStringBuilder.append("->");
      localStringBuilder.append(l1);
      localStringBuilder.append("]。");
      this.s = localStringBuilder.toString();
    }
    this.q = l1;
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis();
    if (this.r != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.s);
      localStringBuilder.append("clearIgnoreFlag[");
      localStringBuilder.append(this.r);
      localStringBuilder.append("->");
      localStringBuilder.append(l1);
      localStringBuilder.append("]。");
      this.s = localStringBuilder.toString();
    }
    this.r = l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorReport
 * JD-Core Version:    0.7.0.1
 */