package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SendMessageToWX$Req
  extends BaseReq
{
  private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
  private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
  public static final int WXSceneFavorite = 2;
  public static final int WXSceneSession = 0;
  public static final int WXSceneSpecifiedContact = 3;
  public static final int WXSceneTimeline = 1;
  public WXMediaMessage message;
  public int scene;
  public String userOpenId;
  
  public SendMessageToWX$Req() {}
  
  public SendMessageToWX$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.message;
    if (localObject == null) {
      localObject = "checkArgs fail ,message is null";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.SendMessageToWX.Req", (String)localObject);
      return false;
      if ((((WXMediaMessage)localObject).mediaObject.type() == 6) && (this.scene == 2)) {
        ((WXFileObject)this.message.mediaObject).setContentLengthLimit(26214400);
      }
      if ((this.scene == 3) && (this.userOpenId == null))
      {
        localObject = "Send specifiedContact userOpenId can not be null.";
      }
      else
      {
        if ((this.scene != 3) || (this.openId != null)) {
          break;
        }
        localObject = "Send specifiedContact openid can not be null.";
      }
    }
    return this.message.checkArgs();
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    this.scene = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
    this.userOpenId = paramBundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
    paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
    paramBundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
    paramBundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req
 * JD-Core Version:    0.7.0.1
 */