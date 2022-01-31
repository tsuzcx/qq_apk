import java.io.File;
import java.util.List;

public class blek
  extends bmes
{
  private bmen<blcd> a = new bmen();
  private bmen<String> b = new bmen();
  private bmen<blet> c = new bmen();
  
  public bmen<blcd> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a(new blcd("#ccffffff", "#000000"));
    this.b.a("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.a(paramString);
    this.a.a(blcc.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    blet localblet = new blet();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bkok.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localblet.a = paramString2;
    localblet.b = paramString1;
    localblet.c = str;
    this.c.a(localblet);
  }
  
  public bmen<String> b()
  {
    return this.b;
  }
  
  public bmen<blet> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blek
 * JD-Core Version:    0.7.0.1
 */