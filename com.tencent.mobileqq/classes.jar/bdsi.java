import java.util.List;

public class bdsi
  extends bdsr
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
  
  public void onUserAudioAvailable(bdrw parambdrw, boolean paramBoolean) {}
  
  public void onUserEnter(bdrw parambdrw) {}
  
  public void onUserExit(bdrw parambdrw) {}
  
  public void onUserSpeaking(bdrw parambdrw, boolean paramBoolean) {}
  
  public void onUserUpdate(List<bdrw> paramList) {}
  
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
      onUserEnter((bdrw)paramVarArgs[0]);
      return;
    case 4: 
      onUserExit((bdrw)paramVarArgs[0]);
      return;
    case 5: 
      onUserAudioAvailable((bdrw)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 6: 
      onUserSpeaking((bdrw)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    }
    onUserUpdate((List)paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsi
 * JD-Core Version:    0.7.0.1
 */