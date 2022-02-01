import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class aruz
  extends DefaultHandler
{
  MessageForStarLeague a;
  public String a;
  
  public aruz()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague = ((MessageForStarLeague)bcsa.a(-2069));
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public MessageForStarLeague a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (paramArrayOfChar.equals("\n")) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.equals("title"))
      {
        localMessageForStarLeague = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.starName == null) {}
        for (;;)
        {
          localMessageForStarLeague.starName = paramArrayOfChar;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.starName.trim();
          return;
          paramArrayOfChar = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.starName.concat(paramArrayOfChar);
        }
      }
    } while (!this.jdField_a_of_type_JavaLangString.equals("summary"));
    MessageForStarLeague localMessageForStarLeague = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.subTitle == null) {}
    for (;;)
    {
      localMessageForStarLeague.subTitle = paramArrayOfChar;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.subTitle.trim();
      return;
      paramArrayOfChar = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.subTitle.concat(paramArrayOfChar);
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("msg")) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.actionUrl = paramAttributes.getValue("url");
    }
    do
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.levelStatus = Integer.parseInt(paramAttributes.getValue("levelStatus"));
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.brief = paramAttributes.getValue("brief");
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.e("StructMsg", 1, "levelStatus parse failed!", paramString1);
        }
      }
      if (paramString3.equals("picture"))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.starAvatar = paramAttributes.getValue("cover");
        return;
      }
      if (paramString3.equals("title"))
      {
        this.jdField_a_of_type_JavaLangString = "title";
        return;
      }
    } while (!paramString3.equals("summary"));
    this.jdField_a_of_type_JavaLangString = "summary";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruz
 * JD-Core Version:    0.7.0.1
 */