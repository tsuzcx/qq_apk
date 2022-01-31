import java.io.File;
import java.util.List;

public class bivj
  extends bjow
{
  private bjor<bitd> a = new bjor();
  private bjor<String> b = new bjor();
  private bjor<bivs> c = new bjor();
  
  public bjor<bitd> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a(new bitd("#ccffffff", "#000000"));
    this.b.a("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.a(paramString);
    this.a.a(bitc.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    bivs localbivs = new bivs();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      biii.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localbivs.a = paramString2;
    localbivs.b = paramString1;
    localbivs.c = str;
    this.c.a(localbivs);
  }
  
  public bjor<String> b()
  {
    return this.b;
  }
  
  public bjor<bivs> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivj
 * JD-Core Version:    0.7.0.1
 */