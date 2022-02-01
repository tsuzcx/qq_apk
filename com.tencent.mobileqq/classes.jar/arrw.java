import android.text.TextUtils;

public class arrw
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public arrw(String paramString)
  {
    this.a = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("_");
      if (paramString.length >= 7)
      {
        this.g = paramString[0];
        this.h = paramString[1];
        this.b = paramString[2];
        this.c = paramString[3];
        this.d = paramString[4];
        this.e = paramString[5];
        this.f = paramString[6];
      }
    }
  }
  
  public boolean a()
  {
    return this.a.split("_").length >= 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrw
 * JD-Core Version:    0.7.0.1
 */