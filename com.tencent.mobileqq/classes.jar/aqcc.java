import org.json.JSONObject;

public abstract interface aqcc
{
  public abstract boolean needProcess(JSONObject paramJSONObject);
  
  public abstract void process(JSONObject paramJSONObject, aqcd paramaqcd, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcc
 * JD-Core Version:    0.7.0.1
 */