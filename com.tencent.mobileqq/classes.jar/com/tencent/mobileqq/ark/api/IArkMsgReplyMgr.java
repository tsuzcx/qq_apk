package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Map;
import org.json.JSONObject;

@QAPI(process={"all"})
@QRouteFactory
public abstract interface IArkMsgReplyMgr
  extends QRouteApi
{
  public static final String ArkMsgReplyAction_ShowLargeText = "showLargeText";
  public static final String kArkMsgReplyAction = "kArkMsgReplyAction";
  public static final String kArkMsgReplyApp = "kArkMsgReplyApp";
  public static final String kArkMsgReplyIcon = "kArkMsgReplyIcon";
  public static final String kArkMsgReplyJumpUrl = "kArkMsgReplyJumpUrl";
  public static final String kArkMsgReplyTag = "kArkMsgReplyTag";
  public static final String kArkMsgReplyTitle = "kArkMsgReplyTitle";
  public static final String kArkMsgReplyView = "kArkMsgReplyView";
  
  public abstract boolean canReply(String paramString1, String paramString2);
  
  public abstract Map<String, String> getReplyConfigFromMsg(JSONObject paramJSONObject);
  
  public abstract int msgReplyFromType(String paramString1, String paramString2);
  
  public abstract void updateConfig(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
 * JD-Core Version:    0.7.0.1
 */