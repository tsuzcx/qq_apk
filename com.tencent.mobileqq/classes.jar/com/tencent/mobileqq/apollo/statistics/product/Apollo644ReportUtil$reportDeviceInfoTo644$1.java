package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class Apollo644ReportUtil$reportDeviceInfoTo644$1
  implements Runnable
{
  Apollo644ReportUtil$reportDeviceInfoTo644$1(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public final void run()
  {
    try
    {
      localObject2 = DeviceInfoUtil.u();
      Object localObject3 = DeviceInfoUtil.g();
      int i = DeviceInfoUtil.h();
      long l1 = DeviceInfoUtil.k();
      long l2 = DeviceInfoUtil.a();
      double d1 = l2;
      double d2 = 1073741824;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      l2 = Math.ceil(d1);
      long l3 = DeviceInfoUtil.F();
      long l4 = DeviceInfoUtil.G();
      float f = DeviceInfoUtil.A();
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("mo", localObject2);
      ((JSONObject)localObject1).put("os", localObject3);
      ((JSONObject)localObject1).put("cc", String.valueOf(i));
      ((JSONObject)localObject1).put("cf", String.valueOf(l1));
      ((JSONObject)localObject1).put("mm", String.valueOf(l2));
      ((JSONObject)localObject1).put("w", String.valueOf(l3));
      ((JSONObject)localObject1).put("h", String.valueOf(l4));
      ((JSONObject)localObject1).put("d", String.valueOf(f));
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("vd", this.a);
      ((JSONObject)localObject2).put("vs", this.b);
      ((JSONObject)localObject2).put("rd", this.c);
      localObject1 = ((JSONObject)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "cpuJSON.toString()");
      localObject2 = ((JSONObject)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "gpuJSON.toString()");
      VipUtils.a(null, "cmshow", "Apollo", "device_info", 0, 0, new String[] { String.valueOf(this.d), localObject1, localObject2 });
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" onSurfaceCreated report 644 data: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(';');
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.i("Apollo644ReportUtil", 1, ((StringBuilder)localObject3).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" onSurfaceCreated report 644 data fail: ");
      ((StringBuilder)localObject2).append(localJSONException);
      QLog.d("Apollo644ReportUtil", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil.reportDeviceInfoTo644.1
 * JD-Core Version:    0.7.0.1
 */