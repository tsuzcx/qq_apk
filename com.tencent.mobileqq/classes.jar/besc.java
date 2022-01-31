import org.json.JSONObject;

public class besc
  implements Cloneable
{
  public besr a;
  
  public static besc a()
  {
    besc localbesc = new besc();
    localbesc.a = besr.a();
    return localbesc;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    besr localbesr;
    if (this.a != null)
    {
      localbesr = this.a;
      if (paramJSONObject != null) {
        break label24;
      }
    }
    label24:
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optJSONObject("window"))
    {
      localbesr.a(paramJSONObject);
      return;
    }
  }
  
  public besc b()
  {
    try
    {
      localbesc = (besc)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localbesc.a = this.a.b();
        return localbesc;
      }
      catch (Throwable localThrowable2)
      {
        besc localbesc;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localbesc = null;
    }
    label24:
    return localbesc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besc
 * JD-Core Version:    0.7.0.1
 */