package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarInfo
{
  public ArrayList<DynamicAvatarInfo.OneUinHeadInfo> a;
  
  public static DynamicAvatarInfo a(oidb_0x74b.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      return null;
    }
    DynamicAvatarInfo localDynamicAvatarInfo = new DynamicAvatarInfo();
    if (paramRspBody.rpt_msg_uin_head_list.has()) {
      localDynamicAvatarInfo.a = DynamicAvatarInfo.OneUinHeadInfo.a(paramRspBody.rpt_msg_uin_head_list.get());
    }
    return localDynamicAvatarInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo
 * JD-Core Version:    0.7.0.1
 */