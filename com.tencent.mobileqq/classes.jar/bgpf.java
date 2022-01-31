import org.json.JSONObject;

public class bgpf
  extends JSONObject
{
  public bgpf() {}
  
  public bgpf(String paramString)
  {
    super(paramString);
  }
  
  public String optString(String paramString1, String paramString2)
  {
    if (isNull(paramString1)) {
      return paramString2;
    }
    return super.optString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpf
 * JD-Core Version:    0.7.0.1
 */