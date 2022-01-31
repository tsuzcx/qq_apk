import org.json.JSONArray;

public abstract interface bejs
{
  public abstract void onInterrupt(int paramInt, String paramString);
  
  public abstract void onRoomMemberChange(JSONArray paramJSONArray);
  
  public abstract void onRoomMemberSpeaking(JSONArray paramJSONArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejs
 * JD-Core Version:    0.7.0.1
 */