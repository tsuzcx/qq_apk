import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

class anxb
{
  private anwz jdField_a_of_type_Anwz;
  private anxa jdField_a_of_type_Anxa;
  private XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  public anxb(anwv paramanwv, anxa paramanxa, anwz paramanwz, XmlPullParser paramXmlPullParser)
  {
    this.jdField_a_of_type_Anxa = paramanxa;
    this.jdField_a_of_type_Anwz = paramanwz;
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
  }
  
  public anwz a()
  {
    return this.jdField_a_of_type_Anwz;
  }
  
  public anxa a()
  {
    return this.jdField_a_of_type_Anxa;
  }
  
  public anxb a()
  {
    Object localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
    if ("activity".equals(localObject1)) {
      if (this.jdField_a_of_type_Anxa == null) {
        this.jdField_a_of_type_Anxa = new anxa();
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
            this.jdField_a_of_type_Anxa.a();
            return this;
            if ("note".equals(localObject1))
            {
              this.jdField_a_of_type_Anwz = new anwz();
              return this;
            }
            if ("activityid".equals(localObject1))
            {
              if (this.jdField_a_of_type_Anxa != null)
              {
                this.jdField_a_of_type_Anxa.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
                return this;
              }
            }
            else if ("stime".equals(localObject1))
            {
              localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
              if (this.jdField_a_of_type_Anwz != null)
              {
                this.jdField_a_of_type_Anwz.jdField_a_of_type_Long = anwz.a((String)localObject1);
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
                if (this.jdField_a_of_type_Anwz != null)
                {
                  this.jdField_a_of_type_Anwz.jdField_a_of_type_JavaLangString = ((String)localObject1);
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
        axql.a("HotchatSCMng", new Object[] { "parseNotice exception", localException1.toString() });
        return this;
        if (!"endtime".equals(localException1)) {
          break;
        }
        localObject2 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
      } while (this.jdField_a_of_type_Anwz == null);
      this.jdField_a_of_type_Anwz.jdField_b_of_type_Long = anwz.a((String)localObject2);
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
        if (this.jdField_a_of_type_Anwz == null) {
          break;
        }
        this.jdField_a_of_type_Anwz.jdField_b_of_type_JavaLangString = ((String)localObject2);
        return this;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      axql.a("HotchatSCMng", new Object[] { "parseNotice exception", localException2.toString() });
      return this;
    }
  }
  
  public anxb b()
  {
    if ("activity".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName())) {
      if ((this.jdField_a_of_type_Anxa != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Anxa.jdField_a_of_type_JavaLangString)))
      {
        localanxa = (anxa)this.jdField_a_of_type_Anwv.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Anxa.jdField_a_of_type_JavaLangString);
        if (anwv.jdField_a_of_type_Boolean)
        {
          if (localanxa != null) {
            break label126;
          }
          str = "null";
          axql.a("HotchatSCMng", "parse", new Object[] { str, this.jdField_a_of_type_Anxa });
        }
        if (localanxa != null) {
          break label132;
        }
        this.jdField_a_of_type_Anwv.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Anxa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anxa);
        this.jdField_a_of_type_Anxa = null;
      }
    }
    label126:
    while ((!"note".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName())) || (this.jdField_a_of_type_Anwz == null) || (this.jdField_a_of_type_Anxa == null))
    {
      anxa localanxa;
      for (;;)
      {
        return this;
        String str = "not null";
      }
      localanxa.jdField_a_of_type_Int = -1;
      localanxa.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Anxa.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Anxa.a();
      return this;
    }
    label132:
    this.jdField_a_of_type_Anxa.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Anwz);
    this.jdField_a_of_type_Anwz = null;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxb
 * JD-Core Version:    0.7.0.1
 */