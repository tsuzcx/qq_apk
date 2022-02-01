import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParser;

public class beaq
{
  private bear jdField_a_of_type_Bear;
  private XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  private void a()
  {
    String str1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(null, "extension");
    String str2 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(null, "mimetype");
    this.jdField_a_of_type_Bear.a(str1, str2);
  }
  
  public bear a()
  {
    this.jdField_a_of_type_Bear = new bear();
    int i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
    if (i != 1)
    {
      String str = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
      if (i == 2) {
        if (!str.equals("MimeTypes")) {}
      }
      for (;;)
      {
        i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.next();
        break;
        if (str.equals("type"))
        {
          a();
          continue;
          if ((i != 3) || (!str.equals("MimeTypes"))) {}
        }
      }
    }
    return this.jdField_a_of_type_Bear;
  }
  
  public bear a(XmlResourceParser paramXmlResourceParser)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlResourceParser;
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaq
 * JD-Core Version:    0.7.0.1
 */