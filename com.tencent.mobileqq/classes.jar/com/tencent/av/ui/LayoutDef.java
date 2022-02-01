package com.tencent.av.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class LayoutDef
{
  public static String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = HardCodeUtil.a(2131706021) + paramInt + "]，Name[" + AudioHelper.a(BaseApplicationImpl.getContext().getResources(), paramInt);
      QLog.d("LayoutDef", 1, str);
      if (AudioHelper.d()) {
        throw new IllegalArgumentException(str);
      }
      break;
    case 0: 
      str = "NONE";
    }
    for (;;)
    {
      return "[" + paramInt + "][" + str + "]";
      str = "CAMERA";
      continue;
      str = "ADD_MEMBER";
      continue;
      str = "Effect";
      continue;
      str = "VideoMode";
      continue;
      str = "Voice";
      continue;
      str = "Sharpness";
      continue;
      str = "Theme";
      continue;
      str = "Member_Speaking_Control";
      continue;
      str = "Record";
      continue;
      str = "HAND_FREE";
      continue;
      str = "MUTE";
      continue;
      str = "HIDE";
      continue;
      str = "HANG_UP";
      continue;
      str = "HANG_UP_BTN";
      continue;
      str = "CALL_PHONE";
      continue;
      str = "LEAVE_MSG";
      continue;
      str = "ACCEPT";
      continue;
      str = "ACCEPT_BY_AUDIO";
      continue;
      str = "REFUSE";
      continue;
      str = "REFUSE1";
      continue;
      str = "MSG_REPLY_VIDEO";
      continue;
      str = "SLIDER_AREA";
      continue;
      str = "SLIDER_ACCEPT";
      continue;
      str = "OPEN_LOCK_SHELL";
      continue;
      str = "OPEN_LOCK";
      continue;
      str = "MORE";
      continue;
      str = "double_sharpness";
      continue;
      str = "SwitchCamera";
      continue;
      str = "quit_double_screen";
      continue;
      str = "audio_net_container.text";
      continue;
      str = "video_net_container.text";
      continue;
      str = "qav_sharp_info";
      continue;
      str = "qav_child_guide_i_got_it";
      continue;
      str = "chatTime";
      continue;
      str = "memberInfo";
      continue;
      str = "memberArrow";
      continue;
      str = "audio_memberInfo";
      continue;
      str = "audio_memberArrow";
      continue;
      str = "BeautySeakBar";
      continue;
      str = "ScreenShot";
      continue;
      str = "ScreenShare";
      continue;
      str = "ChatRoom";
      continue;
      str = "VirtualBackground";
      continue;
      str = "WatchTogether";
      continue;
      str = "unKnown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.LayoutDef
 * JD-Core Version:    0.7.0.1
 */