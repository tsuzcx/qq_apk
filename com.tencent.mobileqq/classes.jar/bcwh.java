import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class bcwh
  extends DefaultHandler
{
  protected bcwd a;
  protected String a;
  protected ArrayList<bcwd> a;
  protected boolean a;
  protected bcwd b;
  
  public bcwh(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bcwd a()
  {
    return this.jdField_a_of_type_Bcwd;
  }
  
  public ArrayList<bcwd> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void endDocument() {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (this.b != null) {
      this.b = this.b.jdField_a_of_type_Bcwd;
    }
  }
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    paramString3 = null;
    int j = paramAttributes.getLength();
    int i = 0;
    paramString1 = null;
    String str2;
    String str1;
    if (i < j)
    {
      str2 = paramAttributes.getLocalName(i);
      str1 = paramAttributes.getValue(str2);
      if ("id".equals(str2)) {
        paramString1 = str1;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ("value".equals(str2))
      {
        paramString3 = str1;
        continue;
        if (("0".equals(paramString1)) || (paramString1 == null)) {}
        for (;;)
        {
          return;
          paramAttributes = this.b;
          if (paramString2.startsWith("L"))
          {
            paramString2 = paramString2.substring(1);
            try
            {
              i = Integer.parseInt(paramString2);
              if (i != 0)
              {
                paramString2 = new bcwd(i, paramString1, paramString3);
                this.b = paramString2;
                if (paramString2.a(paramAttributes))
                {
                  paramAttributes.a(this.b);
                  if ((this.jdField_a_of_type_Boolean) || (!String.valueOf(this.jdField_a_of_type_JavaLangString).equals(paramString1))) {
                    continue;
                  }
                  this.jdField_a_of_type_Boolean = true;
                  this.jdField_a_of_type_Bcwd = paramString2;
                }
              }
            }
            catch (NumberFormatException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
                i = 0;
                continue;
                this.jdField_a_of_type_JavaUtilArrayList.add(this.b);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwh
 * JD-Core Version:    0.7.0.1
 */