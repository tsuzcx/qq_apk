import android.os.Bundle;

public class ayqs
{
  private final Bundle a = ayqq.a.a();
  
  public ayqs()
  {
    this.a.putString("tid", "personal_live_base");
    this.a.putString("bid", "b_sng_im_personal_live");
    this.a.putString("KEY_START_SRC", "default");
  }
  
  public ayqs a(int paramInt)
  {
    return a("obj1", paramInt);
  }
  
  public ayqs a(String paramString)
  {
    this.a.putString("module", paramString);
    return this;
  }
  
  public ayqs a(String paramString, int paramInt)
  {
    this.a.putString(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ayqs a(String paramString1, String paramString2)
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
    ayqq.a.a(this.a);
  }
  
  public ayqs b(int paramInt)
  {
    return a("obj3", paramInt);
  }
  
  public ayqs b(String paramString)
  {
    this.a.putString("action", paramString);
    return this;
  }
  
  public ayqs c(String paramString)
  {
    this.a.putString("source", paramString);
    return this;
  }
  
  public ayqs d(String paramString)
  {
    return a("obj2", paramString);
  }
  
  public ayqs e(String paramString)
  {
    return a("obj3", paramString);
  }
  
  public String toString()
  {
    return "ReportTask{map=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqs
 * JD-Core Version:    0.7.0.1
 */