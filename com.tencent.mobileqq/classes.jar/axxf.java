import android.content.Context;
import android.content.res.Resources;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class axxf
{
  private static axxe jdField_a_of_type_Axxe;
  private static boolean jdField_a_of_type_Boolean;
  
  private static axxe a(Context paramContext)
  {
    a(paramContext);
    return jdField_a_of_type_Axxe;
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
    axxd localaxxd;
    if (!jdField_a_of_type_Boolean)
    {
      localaxxd = new axxd();
      paramContext = paramContext.getResources().getXml(2131820548);
    }
    try
    {
      jdField_a_of_type_Axxe = localaxxd.a(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxf
 * JD-Core Version:    0.7.0.1
 */