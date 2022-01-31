package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.d;

public class JoinChatroom$Req
  extends BaseReq
{
  public String chatroomNickName;
  public String extMsg;
  public String groupId = "";
  
  public boolean checkArgs()
  {
    return !d.b(this.groupId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JoinChatroom.Req
 * JD-Core Version:    0.7.0.1
 */