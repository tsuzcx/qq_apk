import com.tencent.qav.QavDef.MultiUserInfo;
import java.util.List;

public class biiz
  extends biji
{
  public static final int MSG_ON_ENTER_ROOM = 1;
  public static final int MSG_ON_ERROR = 2;
  public static final int MSG_ON_GO_OFF_STAGE_RET = 12;
  public static final int MSG_ON_GO_ON_STAGE_RET = 11;
  public static final int MSG_ON_SELF_VOLUME_UPDATE = 8;
  public static final int MSG_ON_START_REMOTE_VIDEO_RESULT = 15;
  public static final int MSG_ON_SYSTEM_CALL_CHANGED = 16;
  public static final int MSG_ON_USER_AUDIO_AVAILABLE = 5;
  public static final int MSG_ON_USER_ENTER = 3;
  public static final int MSG_ON_USER_EXIT = 4;
  public static final int MSG_ON_USER_SPEAKING = 6;
  public static final int MSG_ON_USER_UPDATE = 7;
  public static final int MSG_ON_USER_VIDEO_FRAME_COME = 13;
  public static final int MSG_ON_USER_VIDEO_IN = 9;
  public static final int MSG_ON_USER_VIDEO_OUT = 10;
  public static final int MSG_ON_USER_VIDEO_SRC_CHANGE = 14;
  
  public void onEnterRoom() {}
  
  public void onError(int paramInt) {}
  
  public void onGoOffStageRet(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void onGoOnStageRet(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void onMemberVideoInOrOut(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2) {}
  
  public void onSelfVolumeUpdate(int paramInt) {}
  
  public void onStartRemoteVideoRequestResult(int paramInt) {}
  
  public void onSystemCallStateChanged(boolean paramBoolean) {}
  
  public void onUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void onUserEnter(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void onUserExit(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void onUserFirstVideoFrameIn(long paramLong, int paramInt) {}
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt) {}
  
  public void onUserUpdate(List<QavDef.MultiUserInfo> paramList) {}
  
  public void onUserVideoSrcChange(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  public void update(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      onEnterRoom();
      return;
    case 2: 
      onError(((Integer)paramVarArgs[0]).intValue());
      return;
    case 3: 
      onUserEnter((QavDef.MultiUserInfo)paramVarArgs[0]);
      return;
    case 4: 
      onUserExit((QavDef.MultiUserInfo)paramVarArgs[0]);
      return;
    case 5: 
      onUserAudioAvailable((QavDef.MultiUserInfo)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 6: 
      QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)paramVarArgs[0];
      boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
      onUserSpeaking(localMultiUserInfo, bool, ((Integer)paramVarArgs[2]).intValue());
      onUserSpeaking(localMultiUserInfo, bool);
      return;
    case 7: 
      onUserUpdate((List)paramVarArgs[0]);
      return;
    case 8: 
      onSelfVolumeUpdate(((Integer)paramVarArgs[0]).intValue());
      return;
    case 9: 
      onMemberVideoInOrOut(true, ((Long)paramVarArgs[0]).longValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue(), ((Long)paramVarArgs[3]).longValue(), ((Integer)paramVarArgs[4]).intValue());
      return;
    case 10: 
      onMemberVideoInOrOut(false, ((Long)paramVarArgs[0]).longValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue(), ((Long)paramVarArgs[3]).longValue(), ((Integer)paramVarArgs[4]).intValue());
      return;
    case 11: 
      onGoOnStageRet(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue());
      return;
    case 12: 
      onGoOffStageRet(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue());
      return;
    case 13: 
      onUserFirstVideoFrameIn(((Long)paramVarArgs[0]).longValue(), ((Integer)paramVarArgs[1]).intValue());
      return;
    case 14: 
      onUserVideoSrcChange(((Long)paramVarArgs[0]).longValue(), ((Integer)paramVarArgs[1]).intValue(), ((Long)paramVarArgs[2]).longValue(), ((Integer)paramVarArgs[3]).intValue());
      return;
    case 15: 
      onStartRemoteVideoRequestResult(((Integer)paramVarArgs[0]).intValue());
      return;
    }
    onSystemCallStateChanged(((Boolean)paramVarArgs[0]).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biiz
 * JD-Core Version:    0.7.0.1
 */