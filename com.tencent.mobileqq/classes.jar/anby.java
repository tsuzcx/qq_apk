import org.json.JSONObject;

public class anby
  implements ancm
{
  private int a;
  
  public anby()
  {
    int i = ancl.a;
    ancl.a = i + 1;
    this.a = i;
  }
  
  public String a()
  {
    return null;
  }
  
  public JSONObject a(ancl paramancl, JSONObject paramJSONObject)
  {
    if ("cs.audio_create.local".equals(paramJSONObject.optString("N_R_CMD")))
    {
      paramJSONObject = new anbl(paramJSONObject.optInt("N_R_OBJ"), paramJSONObject.optInt("id"), paramJSONObject.optString("type"));
      if (paramancl != null) {
        paramancl.a(paramJSONObject);
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
 * Qualified Name:     anby
 * JD-Core Version:    0.7.0.1
 */