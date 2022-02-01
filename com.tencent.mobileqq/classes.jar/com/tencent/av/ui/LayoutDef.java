package com.tencent.av.ui;

import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class LayoutDef
{
  public static int a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return 2131625779;
    }
    return 2131625780;
  }
  
  public static String a(int paramInt)
  {
    Object localObject;
    if (paramInt != 0) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          localObject = new StringBuilder();
                          ((StringBuilder)localObject).append(HardCodeUtil.a(2131903947));
                          ((StringBuilder)localObject).append(paramInt);
                          ((StringBuilder)localObject).append("]，Name[");
                          ((StringBuilder)localObject).append(AudioHelper.a(BaseApplicationImpl.getContext().getResources(), paramInt));
                          localObject = ((StringBuilder)localObject).toString();
                          QLog.d("LayoutDef", 1, (String)localObject);
                          if (!AudioHelper.a())
                          {
                            localObject = "unKnown";
                            break;
                          }
                          throw new IllegalArgumentException((String)localObject);
                        case 2131893088: 
                          localObject = "WatchTogether";
                          break;
                        case 2131893087: 
                          localObject = "Voice";
                          break;
                        case 2131893086: 
                          localObject = "VirtualBackground";
                          break;
                        case 2131893085: 
                          localObject = "VideoMode";
                          break;
                        case 2131893084: 
                          localObject = "Theme";
                          break;
                        case 2131893083: 
                          localObject = "Sharpness";
                          break;
                        case 2131893082: 
                          localObject = "ScreenShot";
                        }
                        break;
                      case 2131893080: 
                        localObject = "ScreenShare";
                        break;
                      case 2131893079: 
                        localObject = "Record";
                        break;
                      case 2131893078: 
                        localObject = "ADD_MEMBER";
                        break;
                      case 2131893077: 
                        localObject = "Effect";
                        break;
                      case 2131893076: 
                        localObject = "Doodle";
                        break;
                      case 2131893075: 
                        localObject = "Member_Speaking_Control";
                        break;
                      case 2131893074: 
                        localObject = "ChatRoom";
                        break;
                      case 2131893073: 
                        localObject = "CAMERA";
                        break;
                      case 2131893072: 
                        localObject = "AIDenoise";
                      }
                      break;
                    case 2131441306: 
                      localObject = "TOP_RECORD_SCREEN";
                      break;
                    case 2131441305: 
                      localObject = "quit_double_screen";
                      break;
                    case 2131441304: 
                      localObject = "MORE";
                      break;
                    case 2131441303: 
                      localObject = "audio_net_container.text";
                      break;
                    case 2131441302: 
                      localObject = "memberManager";
                      break;
                    case 2131441301: 
                      localObject = "AVATAR2D";
                      break;
                    case 2131441300: 
                      localObject = "CAMERA_EXP";
                    }
                    break;
                  case 2131441183: 
                    localObject = "REFUSE1";
                    break;
                  case 2131441182: 
                    localObject = "REFUSE";
                  }
                  break;
                case 2131441179: 
                  localObject = "SLIDER_ACCEPT";
                  break;
                case 2131441178: 
                  localObject = "SLIDER_AREA";
                }
                break;
              case 2131441026: 
                localObject = "OPEN_LOCK_SHELL";
                break;
              case 2131441025: 
                localObject = "OPEN_LOCK";
              }
              break;
            case 2131441023: 
              localObject = "MUTE";
              break;
            case 2131441022: 
              localObject = "LEAVE_MSG";
            }
            break;
          case 2131441018: 
            localObject = "DAV_HANG_UP_NO_ANSWER_BTN";
            break;
          case 2131441017: 
            localObject = "HANG_UP_BTN";
            break;
          case 2131441016: 
            localObject = "HANG_UP";
          }
          break;
        case 2131428983: 
          localObject = "ACCEPT_BY_AUDIO";
          break;
        case 2131428982: 
          localObject = "MSG_REPLY_VIDEO";
        }
        break;
      case 2131449444: 
        localObject = "videochatTime";
        break;
      case 2131441323: 
        localObject = "videoEffect";
        break;
      case 2131441310: 
        localObject = "SwitchCamera";
        break;
      case 2131441308: 
        localObject = "TOP_SCREENSHOT";
        break;
      case 2131441260: 
        localObject = "qav_sharp_info";
        break;
      case 2131441199: 
        localObject = "BeautySeakBar";
        break;
      case 2131441038: 
        localObject = "qav_child_guide_i_got_it";
        break;
      case 2131441020: 
        localObject = "HIDE";
        break;
      case 2131441014: 
        localObject = "HAND_FREE";
        break;
      case 2131441008: 
        localObject = "CALL_PHONE";
        break;
      case 2131440994: 
        localObject = "AudioEffect";
        break;
      case 2131438060: 
        localObject = "memberInfo";
        break;
      case 2131431769: 
        localObject = "video_net_container.text";
        break;
      case 2131428972: 
        localObject = "ACCEPT";
        break;
      case 2131428860: 
        localObject = "audio_memberInfo";
        break;
      case 2131428836: 
        localObject = "audiochatTime";
        break;
      }
    } else {
      localObject = "NONE";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static int b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return 2131625785;
    }
    return 2131625786;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.LayoutDef
 * JD-Core Version:    0.7.0.1
 */