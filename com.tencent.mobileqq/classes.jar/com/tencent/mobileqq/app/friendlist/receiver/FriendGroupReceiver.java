package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import friendlist.MovGroupMemResp;

public class FriendGroupReceiver
  extends BaseHandlerReceiver
{
  public FriendGroupReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, MovGroupMemResp paramMovGroupMemResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    String str = paramToServiceMsg.getString("uin");
    byte b1 = paramToServiceMsg.getByte("group_id");
    byte b2 = paramToServiceMsg.getByte("away_group_id");
    if (paramMovGroupMemResp.result == 0)
    {
      ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(str, b1);
      a(9, true, new Object[] { str, Byte.valueOf(b1), Byte.valueOf(b2) });
      return;
    }
    a(9, false, null);
  }
  
  public boolean a(String paramString)
  {
    return ("friendlist.MovGroupMemReq".equals(paramString)) || ("friendlist.SetGroupReq".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("friendlist.MovGroupMemReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      int i = paramToServiceMsg.extraData.getByte("move_fri_type");
      if (i == 0)
      {
        if (paramObject != null)
        {
          a(paramToServiceMsg, (MovGroupMemResp)paramObject);
          return;
        }
        a(9, false, null);
        return;
      }
      if ((i == 1) && (paramObject != null)) {
        paramToServiceMsg = (MovGroupMemResp)paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.FriendGroupReceiver
 * JD-Core Version:    0.7.0.1
 */