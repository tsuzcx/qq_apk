public class bfrx
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public bfrx(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramString3;
    this.c = paramString4;
    this.e = paramString5;
  }
  
  public String toString()
  {
    return " appId=" + this.a + ",appName=" + this.b + ",pkgName=" + this.c + ",channel=" + this.d + ",defUrl=" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrx
 * JD-Core Version:    0.7.0.1
 */