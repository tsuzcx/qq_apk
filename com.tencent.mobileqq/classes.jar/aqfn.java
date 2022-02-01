import org.json.JSONObject;

public abstract interface aqfn
{
  public abstract boolean needProcess(JSONObject paramJSONObject);
  
  public abstract void process(JSONObject paramJSONObject, aqfo paramaqfo, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfn
 * JD-Core Version:    0.7.0.1
 */