package com.tencent.av.ui;

import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class LayoutDef
{
  public static String a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131706073));
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]，Name[");
      ((StringBuilder)localObject).append(AudioHelper.a(BaseApplicationImpl.getContext().getResources(), paramInt));
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("LayoutDef", 1, (String)localObject);
      if (AudioHelper.a()) {
        break label755;
      }
      localObject = "unKnown";
      break;
    case 2131695347: 
      localObject = "WatchTogether";
      break;
    case 2131695346: 
      localObject = "Voice";
      break;
    case 2131695345: 
      localObject = "VirtualBackground";
      break;
    case 2131695344: 
      localObject = "VideoMode";
      break;
    case 2131695343: 
      localObject = "Theme";
      break;
    case 2131695342: 
      localObject = "Sharpness";
      break;
    case 2131695341: 
      localObject = "ScreenShot";
      break;
    case 2131695339: 
      localObject = "ScreenShare";
      break;
    case 2131695338: 
      localObject = "Record";
      break;
    case 2131695337: 
      localObject = "ADD_MEMBER";
      break;
    case 2131695336: 
      localObject = "Effect";
      break;
    case 2131695335: 
      localObject = "Member_Speaking_Control";
      break;
    case 2131695334: 
      localObject = "ChatRoom";
      break;
    case 2131695333: 
      localObject = "CAMERA";
      break;
    case 2131376548: 
      localObject = "memberArrow";
      break;
    case 2131373640: 
      localObject = "SwitchCamera";
      break;
    case 2131373637: 
      localObject = "quit_double_screen";
      break;
    case 2131373636: 
      localObject = "MORE";
      break;
    case 2131373635: 
      localObject = "audio_net_container.text";
      break;
    case 2131373634: 
      localObject = "double_sharpness";
      break;
    case 2131373595: 
      localObject = "qav_sharp_info";
      break;
    case 2131373526: 
      localObject = "BeautySeakBar";
      break;
    case 2131373511: 
      localObject = "REFUSE1";
      break;
    case 2131373510: 
      localObject = "REFUSE";
      break;
    case 2131373507: 
      localObject = "SLIDER_ACCEPT";
      break;
    case 2131373506: 
      localObject = "SLIDER_AREA";
      break;
    case 2131373365: 
      localObject = "qav_child_guide_i_got_it";
      break;
    case 2131373354: 
      localObject = "OPEN_LOCK_SHELL";
      break;
    case 2131373353: 
      localObject = "OPEN_LOCK";
      break;
    case 2131373351: 
      localObject = "MUTE";
      break;
    case 2131373350: 
      localObject = "LEAVE_MSG";
      break;
    case 2131373348: 
      localObject = "HIDE";
      break;
    case 2131373346: 
      localObject = "HANG_UP_BTN";
      break;
    case 2131373345: 
      localObject = "HANG_UP";
      break;
    case 2131373343: 
      localObject = "HAND_FREE";
      break;
    case 2131373337: 
      localObject = "CALL_PHONE";
      break;
    case 2131370754: 
      localObject = "memberInfo";
      break;
    case 2131365542: 
      localObject = "video_net_container.text";
      break;
    case 2131364477: 
      localObject = "chatTime";
      break;
    case 2131363130: 
      localObject = "ACCEPT_BY_AUDIO";
      break;
    case 2131363129: 
      localObject = "MSG_REPLY_VIDEO";
      break;
    case 2131363119: 
      localObject = "ACCEPT";
      break;
    case 2131363044: 
      localObject = "audio_memberArrow";
      break;
    case 2131363038: 
      localObject = "audio_memberInfo";
      break;
    case 0: 
      localObject = "NONE";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
    label755:
    throw new IllegalArgumentException((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.LayoutDef
 * JD-Core Version:    0.7.0.1
 */