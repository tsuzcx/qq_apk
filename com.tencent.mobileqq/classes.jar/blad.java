import java.io.File;
import java.util.List;

public class blad
  extends bmag
{
  private bmab<bkxw> a = new bmab();
  private bmab<String> b = new bmab();
  private bmab<blam> c = new bmab();
  
  public bmab<bkxw> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a(new bkxw("#ccffffff", "#000000"));
    this.b.a("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.a(paramString);
    this.a.a(bkxv.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    blam localblam = new blam();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bkkd.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localblam.a = paramString2;
    localblam.b = paramString1;
    localblam.c = str;
    this.c.a(localblam);
  }
  
  public bmab<String> b()
  {
    return this.b;
  }
  
  public bmab<blam> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blad
 * JD-Core Version:    0.7.0.1
 */