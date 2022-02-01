import com.tencent.mobileqq.data.MessageForTroopFee;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class arvb
  extends DefaultHandler
{
  MessageForTroopFee a;
  public String a;
  
  public arvb()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFee = new MessageForTroopFee();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public MessageForTroopFee a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFee;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (this.jdField_a_of_type_JavaLangString.equals("title")) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFee.title = paramArrayOfChar;
    }
    while (!this.jdField_a_of_type_JavaLangString.equals("summary")) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFee.summary = paramArrayOfChar;
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("msg"))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFee.actionUrl = paramAttributes.getValue("url");
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFee.brief = paramAttributes.getValue("brief");
    }
    do
    {
      return;
      if (paramString3.equals("title"))
      {
        this.jdField_a_of_type_JavaLangString = "title";
        return;
      }
      if (paramString3.equals("summary"))
      {
        this.jdField_a_of_type_JavaLangString = "summary";
        return;
      }
    } while (!paramString3.equals("source"));
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFee.source = paramAttributes.getValue("name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvb
 * JD-Core Version:    0.7.0.1
 */