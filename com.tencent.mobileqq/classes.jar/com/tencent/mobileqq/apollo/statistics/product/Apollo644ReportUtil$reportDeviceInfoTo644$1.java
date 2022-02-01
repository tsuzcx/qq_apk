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
      Object localObject2 = DeviceInfoUtil.i();
      String str = DeviceInfoUtil.e();
      int i = DeviceInfoUtil.b();
      long l1 = DeviceInfoUtil.b();
      long l2 = Math.ceil(DeviceInfoUtil.a() / 1073741824);
      long l3 = DeviceInfoUtil.k();
      long l4 = DeviceInfoUtil.l();
      float f = DeviceInfoUtil.a();
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("mo", localObject2);
      ((JSONObject)localObject1).put("os", str);
      ((JSONObject)localObject1).put("cc", String.valueOf(i));
      ((JSONObject)localObject1).put("cf", String.valueOf(l1));
      ((JSONObject)localObject1).put("mm", String.valueOf(l2));
      ((JSONObject)localObject1).put("w", String.valueOf(l3));
      ((JSONObject)localObject1).put("h", String.valueOf(l4));
      ((JSONObject)localObject1).put("d", String.valueOf(f));
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("vd", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("vs", this.b);
      ((JSONObject)localObject2).put("rd", this.c);
      localObject1 = ((JSONObject)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "cpuJSON.toString()");
      localObject2 = ((JSONObject)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "gpuJSON.toString()");
      VipUtils.a(null, "cmshow", "Apollo", "device_info", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Int), localObject1, localObject2 });
      QLog.i("sava_ApolloRender", 1, " onSurfaceCreated report 644 data: " + (String)localObject1 + ';' + (String)localObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("sava_ApolloRender", 2, " onSurfaceCreated report 644 data fail: " + localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil.reportDeviceInfoTo644.1
 * JD-Core Version:    0.7.0.1
 */