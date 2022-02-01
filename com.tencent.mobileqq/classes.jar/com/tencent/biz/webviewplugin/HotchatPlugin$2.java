package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;

class HotchatPlugin$2
  implements Runnable
{
  HotchatPlugin$2(HotchatPlugin paramHotchatPlugin, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject2 = HotChatHelper.a();
    Object localObject1 = HotChatHelper.a(false);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      Object localObject3 = new JSONObject();
      if (localObject2 != null)
      {
        ((JSONObject)localObject3).put("mac", String.valueOf(((LBS.Wifi)((LBS.Wifi)localObject2).get()).mac.get()));
        ((JSONObject)localObject3).put("essid", ((LBS.Wifi)((LBS.Wifi)localObject2).get()).essid.get().toStringUtf8());
        ((JSONObject)localObject3).put("rssi", String.valueOf(((LBS.Wifi)((LBS.Wifi)localObject2).get()).rssi.get()));
      }
      localJSONObject1.put("joined_wifi", localObject3);
      if (localObject1 != null)
      {
        localObject2 = new JSONArray();
        localObject3 = ((LBS.LBSInfo)localObject1).rpt_wifi.get();
        Object localObject4;
        JSONObject localJSONObject2;
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LBS.Wifi)((Iterator)localObject3).next();
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("mac", String.valueOf(((LBS.Wifi)localObject4).mac.get()));
            localJSONObject2.put("rssi", String.valueOf(((LBS.Wifi)localObject4).rssi.get()));
            localJSONObject2.put("essid", String.valueOf(((LBS.Wifi)localObject4).essid.get().toStringUtf8()));
            ((JSONArray)localObject2).put(localJSONObject2);
          }
        }
        localJSONObject1.put("rpt_wifis", localObject2);
        localObject2 = new JSONArray();
        localObject3 = ((LBS.LBSInfo)localObject1).rpt_cell.get();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LBS.Cell)((Iterator)localObject3).next();
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("mcc", String.valueOf(((LBS.Cell)localObject4).mcc.get()));
            localJSONObject2.put("mnc", String.valueOf(((LBS.Cell)localObject4).mnc.get()));
            localJSONObject2.put("lac", String.valueOf(((LBS.Cell)localObject4).lac.get()));
            localJSONObject2.put("cellid", String.valueOf(((LBS.Cell)localObject4).cellid.get()));
            localJSONObject2.put("rssi", String.valueOf(((LBS.Cell)localObject4).rssi.get()));
            ((JSONArray)localObject2).put(localJSONObject2);
          }
        }
        localJSONObject1.put("rpt_cells", localObject2);
        localObject2 = new JSONObject();
        if (((LBS.LBSInfo)localObject1).attribute != null)
        {
          localObject1 = (LBS.Attribute)((LBS.LBSInfo)localObject1).attribute.get();
          if (localObject1 != null)
          {
            ((JSONObject)localObject2).put("imei", ((LBS.Attribute)localObject1).imei.get().toStringUtf8());
            ((JSONObject)localObject2).put("imsi", ((LBS.Attribute)localObject1).imsi.get().toStringUtf8());
          }
        }
        localJSONObject1.put("attribute", localObject2);
      }
      else
      {
        localJSONObject1.put("rpt_wifis", new JSONArray());
        localJSONObject1.put("rpt_cells", new JSONArray());
        localJSONObject1.put("attribute", new JSONObject());
      }
      if ((this.a != null) && (this.a.length > 0))
      {
        localObject1 = new JSONObject(this.a[0]).getString("callback");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("callbackName: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("HotchatPlugin", 2, ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get 8a3Info: ");
          ((StringBuilder)localObject2).append(localJSONObject1.toString());
          QLog.d("HotchatPlugin", 2, ((StringBuilder)localObject2).toString());
        }
        this.this$0.callJs((String)localObject1, new String[] { localJSONObject1.toString() });
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin.2
 * JD-Core Version:    0.7.0.1
 */