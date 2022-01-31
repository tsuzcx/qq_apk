import org.json.JSONObject;

public class besa
{
  public int a = 60000;
  public int b = 60000;
  public int c = 60000;
  public int d = 60000;
  
  public static besa a(JSONObject paramJSONObject)
  {
    int j = 60000;
    besa localbesa = new besa();
    if (paramJSONObject == null)
    {
      i = 60000;
      localbesa.a = i;
      if (paramJSONObject != null) {
        break label72;
      }
      i = 60000;
      label30:
      localbesa.b = i;
      if (paramJSONObject != null) {
        break label84;
      }
      i = 60000;
      label42:
      localbesa.c = i;
      if (paramJSONObject != null) {
        break label96;
      }
    }
    label72:
    label84:
    label96:
    for (int i = j;; i = paramJSONObject.optInt("downloadFile", 60000))
    {
      localbesa.d = i;
      return localbesa;
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
 * Qualified Name:     besa
 * JD-Core Version:    0.7.0.1
 */