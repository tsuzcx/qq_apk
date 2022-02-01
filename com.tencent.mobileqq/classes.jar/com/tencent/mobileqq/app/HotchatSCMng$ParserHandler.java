package com.tencent.mobileqq.app;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

class HotchatSCMng$ParserHandler
{
  private HotchatSCMng.HotchatNote jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote;
  private HotchatSCMng.HotchatNotice jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice;
  private XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  public HotchatSCMng$ParserHandler(HotchatSCMng paramHotchatSCMng, HotchatSCMng.HotchatNotice paramHotchatNotice, HotchatSCMng.HotchatNote paramHotchatNote, XmlPullParser paramXmlPullParser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice = paramHotchatNotice;
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote = paramHotchatNote;
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
  }
  
  public HotchatSCMng.HotchatNote a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote;
  }
  
  public HotchatSCMng.HotchatNotice a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice;
  }
  
  public ParserHandler a()
  {
    Object localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
    if ("activity".equals(localObject1)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice = new HotchatSCMng.HotchatNotice();
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
            this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.a();
            return this;
            if ("note".equals(localObject1))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote = new HotchatSCMng.HotchatNote();
              return this;
            }
            if ("activityid".equals(localObject1))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
                return this;
              }
            }
            else if ("stime".equals(localObject1))
            {
              localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
              if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote.jdField_a_of_type_Long = HotchatSCMng.HotchatNote.a((String)localObject1);
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
                if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote.jdField_a_of_type_JavaLangString = ((String)localObject1);
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
        NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", localException1.toString() });
        return this;
        if (!"endtime".equals(localException1)) {
          break;
        }
        localObject2 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
      } while (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote == null);
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote.jdField_b_of_type_Long = HotchatSCMng.HotchatNote.a((String)localObject2);
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
        if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote.jdField_b_of_type_JavaLangString = ((String)localObject2);
        return this;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", localException2.toString() });
      return this;
    }
  }
  
  public ParserHandler b()
  {
    if ("activity".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName())) {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.jdField_a_of_type_JavaLangString)))
      {
        localHotchatNotice = (HotchatSCMng.HotchatNotice)this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.jdField_a_of_type_JavaLangString);
        if (HotchatSCMng.jdField_a_of_type_Boolean)
        {
          if (localHotchatNotice != null) {
            break label126;
          }
          str = "null";
          NearbyUtils.a("HotchatSCMng", "parse", new Object[] { str, this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice });
        }
        if (localHotchatNotice != null) {
          break label132;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice);
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice = null;
      }
    }
    label126:
    while ((!"note".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName())) || (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote == null) || (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice == null))
    {
      HotchatSCMng.HotchatNotice localHotchatNotice;
      for (;;)
      {
        return this;
        String str = "not null";
      }
      localHotchatNotice.jdField_a_of_type_Int = -1;
      localHotchatNotice.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.a();
      return this;
    }
    label132:
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNotice.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote);
    this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng$HotchatNote = null;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotchatSCMng.ParserHandler
 * JD-Core Version:    0.7.0.1
 */