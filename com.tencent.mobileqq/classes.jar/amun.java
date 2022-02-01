import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

class amun
{
  private amul jdField_a_of_type_Amul;
  private amum jdField_a_of_type_Amum;
  private XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  public amun(amuh paramamuh, amum paramamum, amul paramamul, XmlPullParser paramXmlPullParser)
  {
    this.jdField_a_of_type_Amum = paramamum;
    this.jdField_a_of_type_Amul = paramamul;
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
  }
  
  public amul a()
  {
    return this.jdField_a_of_type_Amul;
  }
  
  public amum a()
  {
    return this.jdField_a_of_type_Amum;
  }
  
  public amun a()
  {
    Object localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
    if ("activity".equals(localObject1)) {
      if (this.jdField_a_of_type_Amum == null) {
        this.jdField_a_of_type_Amum = new amum();
      }
    }
    String str;
    label224:
    Object localObject2;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return this;
            this.jdField_a_of_type_Amum.a();
            return this;
            if ("note".equals(localObject1))
            {
              this.jdField_a_of_type_Amul = new amul();
              return this;
            }
            if ("activityid".equals(localObject1))
            {
              if (this.jdField_a_of_type_Amum != null)
              {
                this.jdField_a_of_type_Amum.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
                return this;
              }
            }
            else if ("stime".equals(localObject1))
            {
              localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
              if (this.jdField_a_of_type_Amul != null)
              {
                this.jdField_a_of_type_Amul.jdField_a_of_type_Long = amul.a((String)localObject1);
                return this;
              }
            }
            else
            {
              if (!"content".equals(localObject1)) {
                break label224;
              }
              try
              {
                str = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
                localObject1 = str;
                if (str != null) {
                  localObject1 = str.trim();
                }
                if (this.jdField_a_of_type_Amul != null)
                {
                  this.jdField_a_of_type_Amul.jdField_a_of_type_JavaLangString = ((String)localObject1);
                  return this;
                }
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
          }
        } while (!QLog.isColorLevel());
        awkj.a("HotchatSCMng", new Object[] { "parseNotice exception", localException1.toString() });
        return this;
        if (!"endtime".equals(localException1)) {
          break;
        }
        localObject2 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
      } while (this.jdField_a_of_type_Amul == null);
      this.jdField_a_of_type_Amul.jdField_b_of_type_Long = amul.a((String)localObject2);
      return this;
    } while (!"url".equals(localObject2));
    label382:
    for (;;)
    {
      try
      {
        str = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
        localObject2 = str;
        if (str != null) {
          localObject2 = str.trim();
        }
        if ((localObject2 == null) || (((String)localObject2).startsWith("http://")) || (((String)localObject2).contains("&"))) {
          break label382;
        }
        localObject2 = new String(Base64.decode(((String)localObject2).getBytes(), 0));
        if (this.jdField_a_of_type_Amul == null) {
          break;
        }
        this.jdField_a_of_type_Amul.jdField_b_of_type_JavaLangString = ((String)localObject2);
        return this;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      awkj.a("HotchatSCMng", new Object[] { "parseNotice exception", localException2.toString() });
      return this;
    }
  }
  
  public amun b()
  {
    if ("activity".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName())) {
      if ((this.jdField_a_of_type_Amum != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Amum.jdField_a_of_type_JavaLangString)))
      {
        localamum = (amum)this.jdField_a_of_type_Amuh.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Amum.jdField_a_of_type_JavaLangString);
        if (amuh.jdField_a_of_type_Boolean)
        {
          if (localamum != null) {
            break label126;
          }
          str = "null";
          awkj.a("HotchatSCMng", "parse", new Object[] { str, this.jdField_a_of_type_Amum });
        }
        if (localamum != null) {
          break label132;
        }
        this.jdField_a_of_type_Amuh.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Amum.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Amum);
        this.jdField_a_of_type_Amum = null;
      }
    }
    label126:
    while ((!"note".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName())) || (this.jdField_a_of_type_Amul == null) || (this.jdField_a_of_type_Amum == null))
    {
      amum localamum;
      for (;;)
      {
        return this;
        String str = "not null";
      }
      localamum.jdField_a_of_type_Int = -1;
      localamum.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Amum.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Amum.a();
      return this;
    }
    label132:
    this.jdField_a_of_type_Amum.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Amul);
    this.jdField_a_of_type_Amul = null;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amun
 * JD-Core Version:    0.7.0.1
 */