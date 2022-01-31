package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarInfo
{
  public ArrayList a;
  
  public static DynamicAvatarInfo a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    DynamicAvatarInfo localDynamicAvatarInfo;
    do
    {
      return localObject;
      localDynamicAvatarInfo = new DynamicAvatarInfo();
      localObject = localDynamicAvatarInfo;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localDynamicAvatarInfo.a = DynamicAvatarInfo.OneUinHeadInfo.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localDynamicAvatarInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo
 * JD-Core Version:    0.7.0.1
 */