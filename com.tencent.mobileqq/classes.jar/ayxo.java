import android.content.Context;
import android.content.res.Resources;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class ayxo
{
  private static ayxn jdField_a_of_type_Ayxn;
  private static boolean jdField_a_of_type_Boolean;
  
  private static ayxn a(Context paramContext)
  {
    a(paramContext);
    return jdField_a_of_type_Ayxn;
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
    ayxm localayxm;
    if (!jdField_a_of_type_Boolean)
    {
      localayxm = new ayxm();
      paramContext = paramContext.getResources().getXml(2131886084);
    }
    try
    {
      jdField_a_of_type_Ayxn = localayxm.a(paramContext);
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
 * Qualified Name:     ayxo
 * JD-Core Version:    0.7.0.1
 */