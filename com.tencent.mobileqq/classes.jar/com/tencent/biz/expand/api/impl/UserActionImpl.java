package com.tencent.biz.expand.api.impl;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.expand.api.IUserAction;
import java.util.Map;

public class UserActionImpl
  implements IUserAction
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("0AND0Y11VZ3PFHQD"));
  }
  
  public boolean onUserActionToTunnel(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return UserAction.onUserActionToTunnel(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.impl.UserActionImpl
 * JD-Core Version:    0.7.0.1
 */