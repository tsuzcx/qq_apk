import android.graphics.Color;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ascu
{
  private ascp jdField_a_of_type_Ascp;
  private asct jdField_a_of_type_Asct;
  private asdf jdField_a_of_type_Asdf;
  
  private void a(XmlPullParser paramXmlPullParser, ascp paramascp)
  {
    paramascp.jdField_a_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "timeout");
    if (str != null) {
      paramascp.jdField_a_of_type_Int = Integer.parseInt(str);
    }
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "nextActionIfTimeout");
    if (paramXmlPullParser != null) {
      paramascp.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramXmlPullParser);
    }
  }
  
  public int a(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory)localObject).setNamespaceAware(true);
        localObject = ((XmlPullParserFactory)localObject).newPullParser();
        ((XmlPullParser)localObject).setInput(new StringReader(paramString));
        i = ((XmlPullParser)localObject).getEventType();
      }
      catch (Exception paramString)
      {
        Object localObject;
        paramString.printStackTrace();
        return 0;
      }
      int i = ((XmlPullParser)localObject).next();
      if (((XmlPullParser)localObject).getName().equalsIgnoreCase("random"))
      {
        i = Integer.parseInt(((XmlPullParser)localObject).getAttributeValue(null, "value"));
        return i;
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public ascr a(String paramString)
  {
    try
    {
      localObject1 = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject1).setNamespaceAware(true);
      localXmlPullParser = ((XmlPullParserFactory)localObject1).newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      label980:
      for (;;)
      {
        try
        {
          Object localObject1;
          int i = localXmlPullParser.next();
          continue;
          try
          {
            localObject1 = new ascr();
            paramString = (String)localObject1;
          }
          catch (Exception localException1) {}
          localException1.printStackTrace();
          localObject2 = paramString;
          return localObject2;
          localObject2 = localXmlPullParser.getName();
          if (((String)localObject2).equalsIgnoreCase("magicface"))
          {
            localObject2 = localXmlPullParser.getAttributeValue(null, "isAutoPlay");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramString.jdField_c_of_type_Boolean = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "action");
            if (localObject2 != null)
            {
              boolean bool = Boolean.parseBoolean((String)localObject2);
              if (!bool)
              {
                paramString.jdField_a_of_type_Boolean = bool;
                return paramString;
              }
            }
            paramString.jdField_c_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "useSensor");
            localObject2 = localXmlPullParser.getAttributeValue(null, "fullScreen");
            if (localObject2 != null) {
              paramString.jdField_b_of_type_Boolean = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "minQVer");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramString.jdField_b_of_type_JavaLangString = ((String)localObject2);
            }
            paramString.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "type");
            str = localXmlPullParser.getAttributeValue(null, "colorMask");
            if (str != null)
            {
              localObject2 = str;
              if (str.contains("0x")) {
                localObject2 = str.substring(2);
              }
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            XmlPullParser localXmlPullParser;
            paramString.jdField_a_of_type_Int = ((int)Long.parseLong((String)localObject2, 16));
            Object localObject2 = localXmlPullParser.getAttributeValue(null, "windowWidth");
            if (localObject2 != null) {
              paramString.jdField_d_of_type_Int = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "windowHeight");
            if (localObject2 != null) {
              paramString.jdField_e_of_type_Int = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "avatarCenter");
            if (localObject2 != null) {
              paramString.jdField_f_of_type_Int = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "windowCenter");
            if (localObject2 != null) {
              paramString.jdField_g_of_type_Int = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "isShowCount");
            if (localObject2 != null) {
              paramString.jdField_e_of_type_Boolean = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "faceCenter");
            if (localObject2 != null) {
              paramString.i = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "faceLevel");
            if (localObject2 != null) {
              paramString.j = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "isHideFace");
            if (localObject2 != null) {
              paramString.jdField_f_of_type_Boolean = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "bntCenter");
            if (localObject2 != null) {
              paramString.k = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "isHideGetBtn");
            if (localObject2 != null) {
              paramString.jdField_g_of_type_Boolean = Boolean.parseBoolean((String)localObject2);
            }
            String str = localXmlPullParser.getAttributeValue(null, "titleColor");
            if (str != null)
            {
              localObject2 = str;
              if (!str.startsWith("#")) {
                localObject2 = "#" + str;
              }
              paramString.l = Color.parseColor((String)localObject2);
            }
            str = localXmlPullParser.getAttributeValue(null, "resultSuccessColor");
            if (str != null)
            {
              localObject2 = str;
              if (!str.startsWith("#")) {
                localObject2 = "#" + str;
              }
              paramString.m = Color.parseColor((String)localObject2);
            }
            str = localXmlPullParser.getAttributeValue(null, "resultFailedColor");
            if (str != null)
            {
              localObject2 = str;
              if (!str.startsWith("#")) {
                localObject2 = "#" + str;
              }
              paramString.n = Color.parseColor((String)localObject2);
            }
            paramString.h = localXmlPullParser.getAttributeValue(null, "titleStr");
            localObject2 = localXmlPullParser.getAttributeValue(null, "detailStripColor");
            if (localObject2 != null)
            {
              paramString.jdField_g_of_type_JavaLangString = ((String)localObject2);
              break label980;
              if (((String)localObject2).equalsIgnoreCase("title"))
              {
                paramString.jdField_d_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "text");
              }
              else
              {
                if (((String)localObject2).equalsIgnoreCase("feekbacktext"))
                {
                  localObject2 = new ascv();
                  ((ascv)localObject2).jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "type");
                  str = localXmlPullParser.getAttributeValue(null, "timeout");
                  ((ascv)localObject2).jdField_b_of_type_JavaLangString = str;
                  if (str != null) {
                    paramString.jdField_c_of_type_Int = Integer.parseInt(str);
                  }
                  ((ascv)localObject2).jdField_c_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "text");
                  paramString.jdField_a_of_type_Ascv = ((ascv)localObject2);
                  return paramString;
                }
                if ("subtitle".equalsIgnoreCase((String)localObject2))
                {
                  paramString.jdField_f_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "text");
                  continue;
                  localException2 = localException2;
                  paramString = null;
                  continue;
                  localException3 = localException3;
                }
              }
            }
          }
          catch (Exception localException4) {}
        }
      }
    }
    localObject1 = paramString;
    if (i != 1) {
      switch (i)
      {
      }
    }
  }
  
  public List<ascp> a(String paramString)
  {
    localXmlPullParser = Xml.newPullParser();
    try
    {
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        try
        {
          int i = localXmlPullParser.next();
          continue;
          try
          {
            ArrayList localArrayList = new ArrayList();
            paramString = localArrayList;
          }
          catch (Exception localException1) {}
          String str = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("MagicfaceActionDecoder", 2, "e=" + localException1.getMessage());
            str = paramString;
          }
          return str;
          localObject = localXmlPullParser.getName();
          if ((((String)localObject).equalsIgnoreCase("action")) || (((String)localObject).equalsIgnoreCase("ActionDef")))
          {
            this.jdField_a_of_type_Ascp = new ascp();
            paramString.add(this.jdField_a_of_type_Ascp);
            a(localXmlPullParser, this.jdField_a_of_type_Ascp);
            localObject = localXmlPullParser.getAttributeValue(null, "willDo");
            if ((localObject != null) && ("send".equalsIgnoreCase(((String)localObject).trim()))) {
              this.jdField_a_of_type_Ascp.d = true;
            }
          }
          else
          {
            if (((String)localObject).equalsIgnoreCase("process"))
            {
              this.jdField_a_of_type_Asct = new asct();
              this.jdField_a_of_type_Ascp.jdField_a_of_type_Asct = this.jdField_a_of_type_Asct;
              this.jdField_a_of_type_Asct.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "type");
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("gravity"))
            {
              this.jdField_a_of_type_Asct.jdField_b_of_type_JavaLangString = "gravity";
              localObject = localXmlPullParser.getAttributeValue(null, "value");
              if (localObject != null) {
                this.jdField_a_of_type_Asct.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1316;
              }
              this.jdField_a_of_type_Asct.jdField_c_of_type_JavaLangString = ((String)localObject);
              break label1316;
            }
            if ("mic".equalsIgnoreCase((String)localObject))
            {
              this.jdField_a_of_type_Asct.jdField_b_of_type_JavaLangString = "mic";
              localObject = localXmlPullParser.getAttributeValue(null, "value");
              if (localObject != null) {
                this.jdField_a_of_type_Asct.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "replacevalue");
              if (localObject != null) {
                this.jdField_a_of_type_Asct.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1319;
              }
              this.jdField_a_of_type_Asct.jdField_c_of_type_JavaLangString = ((String)localObject);
              break label1319;
            }
            if ("touch".equalsIgnoreCase((String)localObject))
            {
              this.jdField_a_of_type_Asct.jdField_b_of_type_JavaLangString = "touch";
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1322;
              }
              this.jdField_a_of_type_Asct.jdField_c_of_type_JavaLangString = ((String)localObject);
              break label1322;
            }
            if (((String)localObject).equalsIgnoreCase("value"))
            {
              localObject = new ascw();
              str = localXmlPullParser.getAttributeValue(null, "min");
              if (str != null) {
                ((ascw)localObject).jdField_a_of_type_Int = Integer.parseInt(str);
              }
              str = localXmlPullParser.getAttributeValue(null, "max");
              if (str != null)
              {
                ((ascw)localObject).jdField_b_of_type_Int = Integer.parseInt(str);
                if (((ascw)localObject).jdField_b_of_type_Int == -1) {
                  ((ascw)localObject).jdField_b_of_type_Int = 2147483647;
                }
              }
              str = localXmlPullParser.getAttributeValue(null, "sum");
              if (str != null) {
                ((ascw)localObject).jdField_c_of_type_Int = Integer.parseInt(str);
              }
              this.jdField_a_of_type_Asct.jdField_a_of_type_JavaUtilList.add(localObject);
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("text")) {
              continue;
            }
            if ((((String)localObject).equalsIgnoreCase("playRes")) || (((String)localObject).equalsIgnoreCase("playResDef")))
            {
              this.jdField_a_of_type_Asdf = new asdf();
              this.jdField_a_of_type_Ascp.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Asdf);
              localObject = localXmlPullParser.getAttributeValue(null, "min");
              if (localObject != null) {
                this.jdField_a_of_type_Asdf.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "max");
              if (localObject == null) {
                break label1325;
              }
              this.jdField_a_of_type_Asdf.jdField_b_of_type_Int = Integer.parseInt((String)localObject);
              if (this.jdField_a_of_type_Asdf.jdField_b_of_type_Int != -1) {
                break label1325;
              }
              this.jdField_a_of_type_Asdf.jdField_b_of_type_Int = 2147483647;
              break label1325;
            }
            if (((String)localObject).equalsIgnoreCase("video"))
            {
              if (this.jdField_a_of_type_Asdf == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_Asdf.jdField_a_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "srcAlpha");
              this.jdField_a_of_type_Asdf.jdField_b_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_Asdf.jdField_f_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "fps");
              if (localObject != null) {
                this.jdField_a_of_type_Asdf.jdField_g_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1328;
              }
              this.jdField_a_of_type_Asdf.jdField_c_of_type_Int = Integer.parseInt((String)localObject);
              break label1328;
            }
            if ("sound".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_Asdf == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_Asdf.jdField_c_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_Asdf.jdField_d_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1331;
              }
              this.jdField_a_of_type_Asdf.jdField_e_of_type_Int = Integer.parseInt((String)localObject);
              break label1331;
            }
            if ("vibrator".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_Asdf == null) {
                continue;
              }
              this.jdField_a_of_type_Asdf.jdField_a_of_type_Boolean = true;
              localObject = localXmlPullParser.getAttributeValue(null, "time");
              if (localObject == null) {}
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            this.jdField_a_of_type_Asdf.h = Integer.parseInt((String)localObject);
            continue;
            if ("swipeGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_Asct == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "direction");
              if ("up".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_Asct.jdField_b_of_type_Int = 2;
                break label1334;
              }
              if ("down".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_Asct.jdField_b_of_type_Int = 3;
                break label1334;
              }
              if ("left".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_Asct.jdField_b_of_type_Int = 0;
                break label1334;
              }
              if (!"right".equalsIgnoreCase((String)localObject)) {
                break label1334;
              }
              this.jdField_a_of_type_Asct.jdField_b_of_type_Int = 1;
              break label1334;
            }
            if ("dbTapGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_Asct == null) {
                continue;
              }
              this.jdField_a_of_type_Asct.jdField_b_of_type_Int = 5;
              continue;
            }
            if ((!"tapGesture".equalsIgnoreCase((String)localObject)) || (this.jdField_a_of_type_Asct == null)) {
              continue;
            }
            this.jdField_a_of_type_Asct.jdField_b_of_type_Int = 4;
            continue;
            Object localObject = localXmlPullParser.getName();
            if (((String)localObject).equalsIgnoreCase("action"))
            {
              this.jdField_a_of_type_Ascp = null;
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("process"))
            {
              this.jdField_a_of_type_Asct = null;
              continue;
            }
            if (!((String)localObject).equalsIgnoreCase("playRes")) {
              continue;
            }
            this.jdField_a_of_type_Asdf = null;
            continue;
            localException2 = localException2;
            paramString = null;
            continue;
            localException3 = localException3;
          }
          catch (Exception localException4)
          {
            continue;
          }
        }
        continue;
        continue;
        continue;
        continue;
        continue;
        continue;
        continue;
      }
    }
    str = paramString;
    if (i != 1) {
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascu
 * JD-Core Version:    0.7.0.1
 */