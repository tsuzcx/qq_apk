import java.io.File;
import java.util.List;

public class bius
  extends bjof
{
  private bjoa<bism> a = new bjoa();
  private bjoa<String> b = new bjoa();
  private bjoa<bivb> c = new bjoa();
  
  public bjoa<bism> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a(new bism("#ccffffff", "#000000"));
    this.b.a("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.a(paramString);
    this.a.a(bisl.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    bivb localbivb = new bivb();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bihr.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localbivb.a = paramString2;
    localbivb.b = paramString1;
    localbivb.c = str;
    this.c.a(localbivb);
  }
  
  public bjoa<String> b()
  {
    return this.b;
  }
  
  public bjoa<bivb> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bius
 * JD-Core Version:    0.7.0.1
 */