package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class SendMessageToWX
{
  public static class Req
    extends BaseReq
  {
    private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
    private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
    public static final int WXSceneFavorite = 2;
    public static final int WXSceneSession = 0;
    public static final int WXSceneTimeline = 1;
    public WXMediaMessage message;
    public int scene;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      if (this.message == null)
      {
        Log.e("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
        return false;
      }
      if ((this.message.mediaObject.type() == 6) && (this.scene == 2)) {
        ((WXFileObject)this.message.mediaObject).setContentLengthLimit(26214400);
      }
      return this.message.checkArgs();
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
      this.scene = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
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
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
    }
    
    public int getType()
    {
      return 2;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendMessageToWX
 * JD-Core Version:    0.7.0.1
 */