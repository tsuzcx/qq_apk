import org.json.JSONException;
import org.json.JSONObject;

public class bbpe
{
  public long a;
  public long b;
  
  public bbpe()
  {
    a();
  }
  
  public bbpe(bbpe parambbpe)
  {
    a(parambbpe);
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
  
  public void a(bbpe parambbpe)
  {
    if (parambbpe != null)
    {
      this.a = parambbpe.a;
      this.b = parambbpe.b;
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
  
  public boolean a(bbpe parambbpe)
  {
    if (parambbpe == null) {
      return false;
    }
    return a(parambbpe.a, parambbpe.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpe
 * JD-Core Version:    0.7.0.1
 */