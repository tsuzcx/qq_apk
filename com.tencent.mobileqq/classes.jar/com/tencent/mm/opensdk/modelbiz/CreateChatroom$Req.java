package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.b;

public class CreateChatroom$Req
  extends BaseReq
{
  public String chatroomName;
  public String chatroomNickName;
  public String extMsg;
  public String groupId = "";
  
  public boolean checkArgs()
  {
    return !b.b(this.groupId);
  }
  
  public int getType()
  {
    return 14;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
    paramBundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
    paramBundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
    paramBundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
    paramBundle.putString("_wxapi_basereq_openid", this.openId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.CreateChatroom.Req
 * JD-Core Version:    0.7.0.1
 */