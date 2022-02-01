package com.tencent.mobileqq.apollo.model;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

public class Apollo3DMessage
  implements Serializable
{
  public static final String RESERVE_JSON_KEY_ACTIONID_3D = "actionID_3D";
  public static final String RESERVE_JSON_KEY_ACTION_NAME_3D = "actionName_3D";
  public static final String RESERVE_JSON_KEY_ACTION_TYPE_3D = "actionType_3D";
  public static final String RESERVE_JSON_KEY_PEER_STATUS_3D = "peerStatus_3D";
  public static final String RESERVE_JSON_KEY_SENDER_STATUS_3D = "senderStatus_3D";
  private static final long serialVersionUID = 201812110422150001L;
  public int actionID3D;
  public String actionName3D;
  public int actionType3D;
  public int peerStatus3D;
  public int senderStatus3D;
  
  public JSONObject getMessageJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("actionID_3D", this.actionID3D);
      localJSONObject.put("actionType_3D", this.actionType3D);
      localJSONObject.put("actionName_3D", this.actionName3D);
      localJSONObject.put("senderStatus_3D", this.senderStatus3D);
      localJSONObject.put("peerStatus_3D", this.peerStatus3D);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Apollo3DMessage", 1, "get apollo 3d message jsonObject error", localThrowable);
    }
    return null;
  }
  
  public void setMessageWithJSONObject(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("Apollo3DMessage", 1, "jsonObject is null");
      return;
    }
    try
    {
      this.actionID3D = paramJSONObject.optInt("actionID_3D");
      this.actionType3D = paramJSONObject.optInt("actionType_3D");
      this.actionName3D = paramJSONObject.optString("actionName_3D");
      this.senderStatus3D = paramJSONObject.optInt("senderStatus_3D");
      this.peerStatus3D = paramJSONObject.optInt("peerStatus_3D");
      return;
    }
    catch (Throwable paramJSONObject)
    {
      label64:
      break label64;
    }
    QLog.e("Apollo3DMessage", 1, "set apollo 3d message jsonObject error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.Apollo3DMessage
 * JD-Core Version:    0.7.0.1
 */