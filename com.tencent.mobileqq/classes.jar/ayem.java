import android.os.Bundle;

public class ayem
{
  private final Bundle a = ayek.a.a();
  
  public ayem()
  {
    this.a.putString("tid", "personal_live_base");
    this.a.putString("bid", "b_sng_im_personal_live");
    this.a.putString("KEY_START_SRC", "default");
  }
  
  public ayem a(int paramInt)
  {
    return a("obj1", paramInt);
  }
  
  public ayem a(String paramString)
  {
    this.a.putString("module", paramString);
    return this;
  }
  
  public ayem a(String paramString, int paramInt)
  {
    this.a.putString(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ayem a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "null";
    }
    this.a.putString(paramString1, str.replace("&", "_"));
    return this;
  }
  
  public void a()
  {
    ayek.a.a(this.a);
  }
  
  public ayem b(String paramString)
  {
    this.a.putString("action", paramString);
    return this;
  }
  
  public ayem c(String paramString)
  {
    this.a.putString("source", paramString);
    return this;
  }
  
  public ayem d(String paramString)
  {
    return a("obj2", paramString);
  }
  
  public ayem e(String paramString)
  {
    return a("obj3", paramString);
  }
  
  public String toString()
  {
    return "ReportTask{map=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayem
 * JD-Core Version:    0.7.0.1
 */