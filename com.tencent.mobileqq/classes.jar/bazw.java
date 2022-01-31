import android.content.Context;
import android.content.res.Resources;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class bazw
{
  private static bazv jdField_a_of_type_Bazv;
  private static boolean jdField_a_of_type_Boolean;
  
  private static bazv a(Context paramContext)
  {
    a(paramContext);
    return jdField_a_of_type_Bazv;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.toLowerCase();
    }
    return a(paramContext).a(str);
  }
  
  private static void a(Context paramContext)
  {
    bazu localbazu;
    if (!jdField_a_of_type_Boolean)
    {
      localbazu = new bazu();
      paramContext = paramContext.getResources().getXml(2131886084);
    }
    try
    {
      jdField_a_of_type_Bazv = localbazu.a(paramContext);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: XmlPullParserException");
    }
    catch (IOException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: IOException");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazw
 * JD-Core Version:    0.7.0.1
 */