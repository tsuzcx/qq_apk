import org.json.JSONObject;

public abstract interface annj
{
  public abstract boolean needProcess(JSONObject paramJSONObject);
  
  public abstract void process(JSONObject paramJSONObject, annk paramannk, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annj
 * JD-Core Version:    0.7.0.1
 */