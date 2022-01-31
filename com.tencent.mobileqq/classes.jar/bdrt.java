import java.util.List;

public class bdrt
  extends bdsc
{
  public static final int MSG_ON_ENTER_ROOM = 1;
  public static final int MSG_ON_ERROR = 2;
  public static final int MSG_ON_USER_AUDIO_AVAILABLE = 5;
  public static final int MSG_ON_USER_ENTER = 3;
  public static final int MSG_ON_USER_EXIT = 4;
  public static final int MSG_ON_USER_SPEAKING = 6;
  public static final int MSG_ON_USER_UPDATE = 7;
  
  public void onEnterRoom() {}
  
  public void onError(int paramInt) {}
  
  public void onUserAudioAvailable(bdrh parambdrh, boolean paramBoolean) {}
  
  public void onUserEnter(bdrh parambdrh) {}
  
  public void onUserExit(bdrh parambdrh) {}
  
  public void onUserSpeaking(bdrh parambdrh, boolean paramBoolean) {}
  
  public void onUserUpdate(List<bdrh> paramList) {}
  
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
      onUserEnter((bdrh)paramVarArgs[0]);
      return;
    case 4: 
      onUserExit((bdrh)paramVarArgs[0]);
      return;
    case 5: 
      onUserAudioAvailable((bdrh)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 6: 
      onUserSpeaking((bdrh)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    }
    onUserUpdate((List)paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdrt
 * JD-Core Version:    0.7.0.1
 */