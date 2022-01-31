import java.io.File;
import java.util.List;

public class bhuq
  extends bhwk
{
  private bhwf<bhsi> a = new bhwf();
  private bhwf<String> b = new bhwf();
  private bhwf<bial> c = new bhwf();
  
  public bhwf<bhsi> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a(new bhsi("#ccffffff", "#000000"));
    this.b.a("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.a(paramString);
    this.a.a(bhsh.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    bial localbial = new bial();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bhfb.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localbial.a = paramString2;
    localbial.b = paramString1;
    localbial.c = str;
    this.c.a(localbial);
  }
  
  public bhwf<String> b()
  {
    return this.b;
  }
  
  public bhwf<bial> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhuq
 * JD-Core Version:    0.7.0.1
 */