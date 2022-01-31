import org.json.JSONObject;

public class berj
{
  public int a = 60000;
  public int b = 60000;
  public int c = 60000;
  public int d = 60000;
  
  public static berj a(JSONObject paramJSONObject)
  {
    int j = 60000;
    berj localberj = new berj();
    if (paramJSONObject == null)
    {
      i = 60000;
      localberj.a = i;
      if (paramJSONObject != null) {
        break label72;
      }
      i = 60000;
      label30:
      localberj.b = i;
      if (paramJSONObject != null) {
        break label84;
      }
      i = 60000;
      label42:
      localberj.c = i;
      if (paramJSONObject != null) {
        break label96;
      }
    }
    label72:
    label84:
    label96:
    for (int i = j;; i = paramJSONObject.optInt("downloadFile", 60000))
    {
      localberj.d = i;
      return localberj;
      i = paramJSONObject.optInt("request", 60000);
      break;
      i = paramJSONObject.optInt("connectSocket", 60000);
      break label30;
      i = paramJSONObject.optInt("uploadFile", 60000);
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berj
 * JD-Core Version:    0.7.0.1
 */