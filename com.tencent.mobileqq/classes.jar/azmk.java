import org.json.JSONException;
import org.json.JSONObject;

public class azmk
{
  public long a;
  public long b;
  
  public azmk()
  {
    a();
  }
  
  public azmk(azmk paramazmk)
  {
    a(paramazmk);
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shmsgseq", this.a);
      localJSONObject.put("uniseq", this.b);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.a = -1L;
    this.b = -1L;
  }
  
  public void a(azmk paramazmk)
  {
    if (paramazmk != null)
    {
      this.a = paramazmk.a;
      this.b = paramazmk.b;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.getLong("shmsgseq");
      this.b = paramString.getLong("uniseq");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return this.a != -1L;
  }
  
  public boolean a(long paramLong)
  {
    return (paramLong != -1L) && ((this.a == -1L) || (this.a > paramLong));
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if (a(paramLong1))
    {
      this.a = paramLong1;
      this.b = paramLong2;
      return true;
    }
    return false;
  }
  
  public boolean a(azmk paramazmk)
  {
    if (paramazmk == null) {
      return false;
    }
    return a(paramazmk.a, paramazmk.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmk
 * JD-Core Version:    0.7.0.1
 */