import com.tencent.qphone.base.util.QLog;

public class axuj
{
  public bbeg a;
  @aumc
  public String a;
  public short a;
  public String b = "";
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l;
  public String m;
  public String n;
  
  public axuj(long paramLong, String paramString, short paramShort)
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
    this.c = paramString;
    if (paramShort == 0)
    {
      this.jdField_a_of_type_Short = 10;
      return;
    }
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("&");
      if (arrayOfString.length == 7)
      {
        this.e = arrayOfString[0].substring("RESPCONDITION=".length());
        this.f = arrayOfString[1].substring("SUBJECT=".length());
        this.g = arrayOfString[2].substring("DESC=".length());
        this.h = arrayOfString[3].substring("RESPDESC=".length());
        this.i = arrayOfString[4].substring("RESPCONTENTTYPES=".length());
        this.j = bbmx.a(arrayOfString[5].substring("RESPDEST=".length()));
        int i1;
        String str;
        if ((this.j != null) && (this.j.length() > 0))
        {
          i1 = this.j.lastIndexOf("channel_id");
          if (i1 != -1)
          {
            paramString = this.j.substring(i1);
            i1 = paramString.charAt("channel_id".length());
            if (i1 != 37) {
              break label244;
            }
            str = paramString.substring(paramString.indexOf('%') + 3);
            paramString = str;
            if (str.indexOf('%') > 0) {
              paramString = str.substring(0, str.indexOf('%'));
            }
            this.b = paramString;
          }
        }
        for (;;)
        {
          this.k = arrayOfString[6].substring("RESPCONTENTS=".length());
          if (!"PLUGIN".equalsIgnoreCase(this.i)) {
            break;
          }
          return true;
          label244:
          if (i1 == 61)
          {
            str = paramString.substring(paramString.indexOf('=') + 1);
            paramString = str;
            if (str.indexOf('&') > 0) {
              paramString = str.substring(0, str.indexOf('&'));
            }
            this.b = paramString;
          }
        }
        return false;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PushBanner", 2, "loadParams Exception:", paramString);
      }
    }
    throw new IllegalArgumentException("PushBanner Params Count must be:7");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axuj
 * JD-Core Version:    0.7.0.1
 */