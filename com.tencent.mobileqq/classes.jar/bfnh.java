public class bfnh
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  
  public bfnh(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.a = (paramString1 + "");
    this.b = (paramString2 + "");
    this.c = (paramString3 + "");
    this.d = (paramString4 + "");
    this.e = (paramString5 + "");
    this.f = (paramString6 + "");
    this.g = (paramString7 + "");
    this.h = paramString8;
    this.i = paramString9;
    this.j = (paramString10 + "");
    this.k = (paramString11 + "");
    bflp.b("report_debug", "reportItem apn=" + this.a + ",frequency=" + this.b + ",commandid=" + this.c + ",resultcode=" + this.d + "timecost" + this.e + ",reqsize=" + this.f + ",rspsize=" + this.g + ",uin=" + this.h + ",deviceinfo=" + this.i + ",detail=" + this.j + ",appid=" + paramString11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfnh
 * JD-Core Version:    0.7.0.1
 */