package com.tencent.biz.expand.flutter;

import android.os.Bundle;
import com.tencent.biz.expand.api.GenericSerializable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.HashMap;
import java.util.Map;

public class ReportHelper
{
  public static void a()
  {
    Bundle localBundle = new Bundle();
    GenericSerializable localGenericSerializable = new GenericSerializable();
    localGenericSerializable.set(new HashMap());
    localBundle.putSerializable("params", localGenericSerializable);
    localBundle.putString("event", "expose#launch_loading_noplugin#view");
    QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyDoReport", localBundle);
  }
  
  public static void a(long paramLong)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(l - paramLong));
    localHashMap.put("ext_int", "3");
    Bundle localBundle = new Bundle();
    GenericSerializable localGenericSerializable = new GenericSerializable();
    localGenericSerializable.set(localHashMap);
    localBundle.putSerializable("params", localGenericSerializable);
    localBundle.putString("event", "exit#all_page#view");
    QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyDoReport", localBundle);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    QLog.d("ReportHelper", 1, "starttime " + paramLong + " isHotLoad " + paramBoolean);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(l - paramLong));
    localHashMap.put("ext_int1", String.valueOf(paramInt));
    if (paramBoolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      localHashMap.put("launch_type", localObject);
      localObject = new Bundle();
      GenericSerializable localGenericSerializable = new GenericSerializable();
      localGenericSerializable.set(localHashMap);
      ((Bundle)localObject).putSerializable("params", localGenericSerializable);
      ((Bundle)localObject).putString("event", "loading#launch_loading_noplugin#view");
      QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyDoReport", (Bundle)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ReportHelper
 * JD-Core Version:    0.7.0.1
 */