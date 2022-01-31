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

public final class behs
  extends behr
{
  private Context a;
  
  public behs(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private behj a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      behj localbehj = new behj();
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localbehj;
        if (i >= paramXmlPullParser.getAttributeCount()) {
          break;
        }
        localObject = paramXmlPullParser.getAttributeName(i);
        String str = paramXmlPullParser.getAttributeValue(i);
        if ("name".equals(localObject)) {
          localbehj.jdField_a_of_type_JavaLangString = str;
        }
        i += 1;
      }
      return localObject;
    }
    catch (Exception paramXmlPullParser)
    {
      besl.d("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
      localObject = null;
    }
  }
  
  private behk a(XmlPullParser paramXmlPullParser)
  {
    behk localbehk;
    int i;
    String str1;
    String str2;
    try
    {
      localbehk = new behk();
      i = 0;
      if (i >= paramXmlPullParser.getAttributeCount()) {
        break label235;
      }
      str1 = paramXmlPullParser.getAttributeName(i);
      str2 = paramXmlPullParser.getAttributeValue(i);
      if ("id".equals(str1)) {
        localbehk.jdField_a_of_type_JavaLangString = str2;
      } else if ("name".equals(str1)) {
        localbehk.b = a(str2);
      }
    }
    catch (Exception paramXmlPullParser)
    {
      besl.d("PermissionParser", paramXmlPullParser.getMessage(), paramXmlPullParser);
      return null;
    }
    if ("description".equals(str1)) {
      localbehk.c = a(str2);
    } else if ("description-reject".equals(str1)) {
      localbehk.d = a(str2);
    } else if ("built-in".equals(str1)) {
      localbehk.jdField_a_of_type_Boolean = Boolean.parseBoolean(str2);
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
        Log.i("PermissionParser", "Ignore permission " + localbehk + ". Required min-sdk-version is " + j);
        return null;
        label235:
        if (belh.a(localbehk.d)) {
          localbehk.d = this.a.getString(2131694234);
        }
        return localbehk;
      }
      i += 1;
      break;
    }
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (!belh.a(paramString))
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
  
  private void a(behj parambehj, String paramString)
  {
    if ((parambehj == null) || (paramString == null)) {
      return;
    }
    if (parambehj.jdField_a_of_type_JavaUtilList == null) {
      parambehj.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    parambehj.jdField_a_of_type_JavaUtilList.add(paramString);
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
      besl.d("PermissionParser", localXmlPullParserException.getMessage(), localXmlPullParserException);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        besl.d("PermissionParser", localIOException.getMessage(), localIOException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        besl.d("PermissionParser", localException.getMessage(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behs
 * JD-Core Version:    0.7.0.1
 */