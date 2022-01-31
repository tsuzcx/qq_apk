import org.json.JSONObject;

public abstract interface anrs
{
  public abstract boolean needProcess(JSONObject paramJSONObject);
  
  public abstract void process(JSONObject paramJSONObject, anrt paramanrt, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrs
 * JD-Core Version:    0.7.0.1
 */