package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import java.util.Map;
import org.json.JSONObject;

public class ArkMsgReplyMgrImpl
  implements IArkMsgReplyMgr
{
  public boolean canReply(String paramString1, String paramString2)
  {
    return ArkMsgReplyConfigMgr.getInstance().canReply(paramString1, paramString2);
  }
  
  public Map<String, String> getReplyConfigFromMsg(JSONObject paramJSONObject)
  {
    return ArkMsgReplyConfigMgr.getInstance().getReplyConfigFromMsg(paramJSONObject);
  }
  
  public int msgReplyFromType(String paramString1, String paramString2)
  {
    return ArkMsgReplyConfigMgr.getInstance().msgReplyFromType(paramString1, paramString2);
  }
  
  public void updateConfig(JSONObject paramJSONObject)
  {
    ArkMsgReplyConfigMgr.getInstance().updateConfig(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkMsgReplyMgrImpl
 * JD-Core Version:    0.7.0.1
 */