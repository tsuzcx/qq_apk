package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import org.json.JSONArray;
import org.json.JSONObject;

class AVPreloadSwitch$1
  implements AVPreloadSwitch.OnCgiResponse
{
  AVPreloadSwitch$1(AVPreloadSwitch paramAVPreloadSwitch) {}
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      AVPreloadSwitch.a(this.a).e("AVPreloadSwitch", "resultJson == null return", new Object[0]);
      return;
    }
    Object localObject = AVPreloadSwitch.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchServiceConfig result = ");
    localStringBuilder.append(paramJSONObject.toString());
    ((LogInterface)localObject).i("AVPreloadSwitch", localStringBuilder.toString(), new Object[0]);
    try
    {
      int i = paramJSONObject.getInt("retcode");
      if (i != 0)
      {
        AVPreloadSwitch.a(this.a).e("AVPreloadSwitch", "result code != 0, return", new Object[0]);
        return;
      }
      paramJSONObject = paramJSONObject.getJSONObject("datas");
      if (paramJSONObject == null)
      {
        AVPreloadSwitch.a(this.a).e("AVPreloadSwitch", "result code != 0, return", new Object[0]);
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("items");
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
      {
        paramJSONObject = paramJSONObject.getJSONObject(0);
        if (paramJSONObject == null)
        {
          AVPreloadSwitch.a(this.a).e("AVPreloadSwitch", "content is empty return", new Object[0]);
          return;
        }
        paramJSONObject = paramJSONObject.getString("value");
        if (paramJSONObject == null) {
          AVPreloadSwitch.a(this.a).e("AVPreloadSwitch", "value is empty return", new Object[0]);
        }
        paramJSONObject = new JSONObject(paramJSONObject).getJSONArray("switch_config");
        boolean bool = AVPreloadSwitch.a(this.a, paramJSONObject);
        paramJSONObject = AVPreloadSwitch.a(this.a);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("switchConfig parse finished result = ");
        ((StringBuilder)localObject).append(bool);
        paramJSONObject.e("AVPreloadSwitch", ((StringBuilder)localObject).toString(), new Object[0]);
        if (AVPreloadSwitch.b(this.a) != null) {
          AVPreloadSwitch.b(this.a).d();
        }
      }
      else
      {
        AVPreloadSwitch.a(this.a).e("AVPreloadSwitch", "json array item is empty return", new Object[0]);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      AVPreloadSwitch.a(this.a).printException(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadSwitch.1
 * JD-Core Version:    0.7.0.1
 */