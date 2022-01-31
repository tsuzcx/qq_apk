import org.json.JSONObject;

public class berl
  implements Cloneable
{
  public besa a;
  
  public static berl a()
  {
    berl localberl = new berl();
    localberl.a = besa.a();
    return localberl;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    besa localbesa;
    if (this.a != null)
    {
      localbesa = this.a;
      if (paramJSONObject != null) {
        break label24;
      }
    }
    label24:
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optJSONObject("window"))
    {
      localbesa.a(paramJSONObject);
      return;
    }
  }
  
  public berl b()
  {
    try
    {
      localberl = (berl)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localberl.a = this.a.b();
        return localberl;
      }
      catch (Throwable localThrowable2)
      {
        berl localberl;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localberl = null;
    }
    label24:
    return localberl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berl
 * JD-Core Version:    0.7.0.1
 */