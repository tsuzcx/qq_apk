import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParser;

public class bazu
{
  private bazv jdField_a_of_type_Bazv;
  private XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  private void a()
  {
    String str1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(null, "extension");
    String str2 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(null, "mimetype");
    this.jdField_a_of_type_Bazv.a(str1, str2);
  }
  
  public bazv a()
  {
    this.jdField_a_of_type_Bazv = new bazv();
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
    return this.jdField_a_of_type_Bazv;
  }
  
  public bazv a(XmlResourceParser paramXmlResourceParser)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlResourceParser;
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazu
 * JD-Core Version:    0.7.0.1
 */