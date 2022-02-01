import org.json.JSONObject;

public class amxi
  implements amxw
{
  private int a;
  
  public amxi()
  {
    int i = amxv.a;
    amxv.a = i + 1;
    this.a = i;
  }
  
  public String a()
  {
    return null;
  }
  
  public JSONObject a(amxv paramamxv, JSONObject paramJSONObject)
  {
    if ("cs.audio_create.local".equals(paramJSONObject.optString("N_R_CMD")))
    {
      paramJSONObject = new amwv(paramJSONObject.optInt("N_R_OBJ"), paramJSONObject.optInt("id"), paramJSONObject.optString("type"));
      if (paramamxv != null) {
        paramamxv.a(paramJSONObject);
      }
    }
    return null;
  }
  
  public int c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxi
 * JD-Core Version:    0.7.0.1
 */