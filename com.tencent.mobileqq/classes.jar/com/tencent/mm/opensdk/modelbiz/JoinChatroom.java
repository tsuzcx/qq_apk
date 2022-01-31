package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.d;

public class JoinChatroom
{
  public static class Req
    extends BaseReq
  {
    public String chatroomNickName;
    public String extMsg;
    public String groupId = "";
    
    public boolean checkArgs()
    {
      return !d.h(this.groupId);
    }
    
    public int getType()
    {
      return 15;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
      paramBundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
      paramBundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
      paramBundle.putString("_wxapi_basereq_openid", this.openId);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
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
      this.extMsg = paramBundle.getString("_wxapi_join_chatroom_ext_msg");
    }
    
    public int getType()
    {
      return 15;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JoinChatroom
 * JD-Core Version:    0.7.0.1
 */