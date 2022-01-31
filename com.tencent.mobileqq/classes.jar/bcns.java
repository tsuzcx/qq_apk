import java.util.List;

public class bcns
  extends bcob
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
  
  public void onUserAudioAvailable(bcng parambcng, boolean paramBoolean) {}
  
  public void onUserEnter(bcng parambcng) {}
  
  public void onUserExit(bcng parambcng) {}
  
  public void onUserSpeaking(bcng parambcng, boolean paramBoolean) {}
  
  public void onUserUpdate(List<bcng> paramList) {}
  
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
      onUserEnter((bcng)paramVarArgs[0]);
      return;
    case 4: 
      onUserExit((bcng)paramVarArgs[0]);
      return;
    case 5: 
      onUserAudioAvailable((bcng)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 6: 
      onUserSpeaking((bcng)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    }
    onUserUpdate((List)paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcns
 * JD-Core Version:    0.7.0.1
 */