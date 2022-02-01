import android.os.Bundle;

public class axkn
{
  private final Bundle a = axkl.a.a();
  
  public axkn()
  {
    this.a.putString("tid", "personal_live_base");
    this.a.putString("bid", "b_sng_im_personal_live");
    this.a.putString("KEY_START_SRC", "default");
  }
  
  public axkn a(int paramInt)
  {
    return a("obj1", paramInt);
  }
  
  public axkn a(String paramString)
  {
    this.a.putString("module", paramString);
    return this;
  }
  
  public axkn a(String paramString, int paramInt)
  {
    this.a.putString(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public axkn a(String paramString1, String paramString2)
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
    axkl.a.a(this.a);
  }
  
  public axkn b(int paramInt)
  {
    return a("obj3", paramInt);
  }
  
  public axkn b(String paramString)
  {
    this.a.putString("action", paramString);
    return this;
  }
  
  public axkn c(String paramString)
  {
    this.a.putString("source", paramString);
    return this;
  }
  
  public axkn d(String paramString)
  {
    return a("obj2", paramString);
  }
  
  public axkn e(String paramString)
  {
    return a("obj3", paramString);
  }
  
  public String toString()
  {
    return "ReportTask{map=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkn
 * JD-Core Version:    0.7.0.1
 */