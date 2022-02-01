import com.tencent.mobileqq.utils.StringUtil;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class bfic
  extends DefaultHandler
{
  public String a;
  public String b;
  public String c;
  public String d;
  protected String e;
  
  public bfic(bfhz parambfhz) {}
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.e != null)
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      if (!this.e.equals("title")) {
        break label46;
      }
      if (StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = paramArrayOfChar;
      }
    }
    label46:
    while (!this.e.equals("summary")) {
      return;
    }
    this.c = paramArrayOfChar;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.e = null;
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString2.equals("picture")) {
      this.b = paramAttributes.getValue("cover");
    }
    for (;;)
    {
      this.e = paramString2;
      return;
      if (paramString2.equals("msg")) {
        this.d = paramAttributes.getValue("url");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfic
 * JD-Core Version:    0.7.0.1
 */