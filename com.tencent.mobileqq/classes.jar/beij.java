import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class beij
  extends beii
{
  private Context a;
  
  public beij(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private beia a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      beia localbeia = new beia();
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localbeia;
        if (i >= paramXmlPullParser.getAttributeCount()) {
          break;
        }
        localObject = paramXmlPullParser.getAttributeName(i);
        String str = paramXmlPullParser.getAttributeValue(i);
        if ("name".equals(localObject)) {
          localbeia.jdField_a_of_type_JavaLangString = str;
        }
        i += 1;
      }
      return localObject;
    }
    catch (Exception paramXmlPullParser)
    {
      betc.d("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
      localObject = null;
    }
  }
  
  private beib a(XmlPullParser paramXmlPullParser)
  {
    beib localbeib;
    int i;
    String str1;
    String str2;
    try
    {
      localbeib = new beib();
      i = 0;
      if (i >= paramXmlPullParser.getAttributeCount()) {
        break label235;
      }
      str1 = paramXmlPullParser.getAttributeName(i);
      str2 = paramXmlPullParser.getAttributeValue(i);
      if ("id".equals(str1)) {
        localbeib.jdField_a_of_type_JavaLangString = str2;
      } else if ("name".equals(str1)) {
        localbeib.b = a(str2);
      }
    }
    catch (Exception paramXmlPullParser)
    {
      betc.d("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
      return null;
    }
    if ("description".equals(str1)) {
      localbeib.c = a(str2);
    } else if ("description-reject".equals(str1)) {
      localbeib.d = a(str2);
    } else if ("built-in".equals(str1)) {
      localbeib.jdField_a_of_type_Boolean = Boolean.parseBoolean(str2);
    } else if ("min-sdk-version".equals(str1)) {
      if (!a(str2)) {
        break label270;
      }
    }
    label270:
    for (int j = Integer.parseInt(str2);; j = 1)
    {
      if (Build.VERSION.SDK_INT < j)
      {
        Log.i("PermissionParser", "Ignore permission " + localbeib + ". Required min-sdk-version is " + j);
        return null;
        label235:
        if (bely.a(localbeib.d)) {
          localbeib.d = this.a.getString(2131694235);
        }
        return localbeib;
      }
      i += 1;
      break;
    }
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (!bely.a(paramString))
    {
      str = paramString;
      if ('@' == paramString.charAt(0))
      {
        paramString = paramString.substring(1);
        str = paramString;
        if (a(paramString)) {
          str = this.a.getString(Integer.parseInt(paramString));
        }
      }
    }
    return str;
  }
  
  private String a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.next() == 4) {
      return paramXmlPullParser.getText();
    }
    return null;
  }
  
  private void a(beia parambeia, String paramString)
  {
    if ((parambeia == null) || (paramString == null)) {
      return;
    }
    if (parambeia.jdField_a_of_type_JavaUtilList == null) {
      parambeia.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    parambeia.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  private static boolean a(String paramString)
  {
    return paramString.matches("\\d+(\\.\\d+)?");
  }
  
  private void b()
  {
    Object localObject3 = null;
    a();
    XmlResourceParser localXmlResourceParser = this.a.getResources().getXml(2131886085);
    Object localObject2 = null;
    Object localObject1 = null;
    if (localXmlResourceParser.getEventType() != 1)
    {
      String str = localXmlResourceParser.getName();
      Object localObject6;
      Object localObject5;
      Object localObject4;
      switch (localXmlResourceParser.getEventType())
      {
      default: 
        localObject6 = localObject1;
        localObject5 = localObject2;
        localObject4 = localObject3;
      }
      for (;;)
      {
        localXmlResourceParser.next();
        localObject3 = localObject4;
        localObject2 = localObject5;
        localObject1 = localObject6;
        break;
        if ("permission".equals(str))
        {
          localObject6 = a(localXmlResourceParser);
          localObject4 = localObject3;
          localObject5 = localObject2;
        }
        else if ("event".equals(str))
        {
          localObject5 = a(localXmlResourceParser);
          localObject4 = localObject3;
          localObject6 = localObject1;
        }
        else
        {
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject6 = localObject1;
          if ("request-permission".equals(str))
          {
            localObject4 = a(localXmlResourceParser);
            localObject5 = localObject2;
            localObject6 = localObject1;
            continue;
            if ("permission".equals(str))
            {
              a(localObject1);
              localObject4 = localObject3;
              localObject5 = localObject2;
              localObject6 = localObject1;
            }
            else if ("event".equals(str))
            {
              a(localObject2);
              localObject4 = localObject3;
              localObject5 = localObject2;
              localObject6 = localObject1;
            }
            else
            {
              localObject4 = localObject3;
              localObject5 = localObject2;
              localObject6 = localObject1;
              if ("request-permission".equals(str))
              {
                a(localObject2, localObject3);
                localObject4 = localObject3;
                localObject5 = localObject2;
                localObject6 = localObject1;
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      b();
      return true;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      betc.d("PermissionParser", localXmlPullParserException.getMessage(), localXmlPullParserException);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        betc.d("PermissionParser", localIOException.getMessage(), localIOException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        betc.d("PermissionParser", localException.getMessage(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beij
 * JD-Core Version:    0.7.0.1
 */