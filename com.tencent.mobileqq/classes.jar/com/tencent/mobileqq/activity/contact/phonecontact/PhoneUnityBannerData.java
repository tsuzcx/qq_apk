package com.tencent.mobileqq.activity.contact.phonecontact;

import android.text.TextUtils;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import org.xmlpull.v1.XmlPullParser;

public class PhoneUnityBannerData
{
  public String a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public boolean h;
  public boolean i = true;
  
  public static PhoneUnityBannerData a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      PhoneUnityBannerData localPhoneUnityBannerData = new PhoneUnityBannerData();
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int j = 0;; j = localXmlPullParser.next())
      {
        paramString = localPhoneUnityBannerData;
        if (j == 1) {
          break;
        }
        if ((j == 2) && (localXmlPullParser.getName().equalsIgnoreCase("banner")))
        {
          int k = localXmlPullParser.getAttributeCount();
          j = 0;
          while (j < k)
          {
            paramString = localXmlPullParser.getAttributeName(j);
            if ("text".equals(paramString)) {
              localPhoneUnityBannerData.b = localXmlPullParser.getAttributeValue(j);
            } else if ("url".equals(paramString)) {
              localPhoneUnityBannerData.a = localXmlPullParser.getAttributeValue(j);
            } else if ("dayNum".equals(paramString)) {
              localPhoneUnityBannerData.c = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
            } else if ("dayIntervalNum".equals(paramString)) {
              localPhoneUnityBannerData.d = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
            } else if ("totalNum".equals(paramString)) {
              localPhoneUnityBannerData.e = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
            } else if ("loginNum".equals(paramString)) {
              localPhoneUnityBannerData.g = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
            } else if ("banner".equals(paramString)) {
              localPhoneUnityBannerData.h = "1".equals(localXmlPullParser.getAttributeValue(j));
            } else if ("setEntry".equals(paramString)) {
              localPhoneUnityBannerData.i = "1".equals(localXmlPullParser.getAttributeValue(j));
            }
            j += 1;
          }
        }
      }
    }
    paramString = null;
    return paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MobileUnityBannerData [url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", text=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", dayNum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", dayIntervalNum=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", totalNum=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", loginNum = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityBannerData
 * JD-Core Version:    0.7.0.1
 */