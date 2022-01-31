import org.json.JSONObject;

public class bdna
  implements Cloneable
{
  public bdnl a;
  
  public static bdna a()
  {
    bdna localbdna = new bdna();
    localbdna.a = bdnl.a();
    return localbdna;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bdnl localbdnl;
    if (this.a != null)
    {
      localbdnl = this.a;
      if (paramJSONObject != null) {
        break label24;
      }
    }
    label24:
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optJSONObject("window"))
    {
      localbdnl.a(paramJSONObject);
      return;
    }
  }
  
  public bdna b()
  {
    try
    {
      localbdna = (bdna)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localbdna.a = this.a.b();
        return localbdna;
      }
      catch (Throwable localThrowable2)
      {
        bdna localbdna;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localbdna = null;
    }
    label24:
    return localbdna;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdna
 * JD-Core Version:    0.7.0.1
 */