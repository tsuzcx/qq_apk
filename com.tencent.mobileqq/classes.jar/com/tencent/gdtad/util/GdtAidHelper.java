package com.tencent.gdtad.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Xml;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ADGatherSdkInitHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.ams.ga.ITuringDID;
import com.tencent.turingfd.sdk.ams.ga.TuringDIDService;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class GdtAidHelper
{
  public GdtThirdProcessorProxy a = new GdtThirdProcessorProxy();
  private volatile Set<String> b;
  private boolean c;
  
  private GdtAidHelper.TicketEntity a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.a())
    {
      GdtLog.a("GdtAidHelper", "only arm support taid");
      return new GdtAidHelper.TicketEntity("", "", -2147483647, 0L, null);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAidTicket start , businessId -> ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", useCache -> ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", needVerifyBusinessId -> ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append("， TuringVersion : ");
      ((StringBuilder)localObject).append(TuringDIDService.getVersionInfo());
      QLog.d("GdtAidHelper", 2, ((StringBuilder)localObject).toString());
    }
    int k = 0;
    boolean bool;
    if (paramBoolean2) {
      bool = b(paramString);
    } else {
      bool = false;
    }
    paramString = BaseApplication.getContext().getApplicationContext();
    if (!this.c)
    {
      GdtLog.a("GdtAidHelper", "getAidTicket init TuringSDK");
      try
      {
        ADGatherSdkInitHelper.a();
        this.c = true;
      }
      catch (Throwable paramString)
      {
        QLog.e("GdtAidHelper", 1, paramString, new Object[] { "Turing init crash fail" });
        return new GdtAidHelper.TicketEntity("", "", -2147483646, 0L, paramString, null);
      }
    }
    if (paramBoolean1) {}
    try
    {
      paramString = TuringDIDService.getTuringDIDCached(paramString);
      break label227;
      paramString = TuringDIDService.getTuringDID(paramString);
      label227:
      int j = paramString.getErrorCode();
      long l = paramString.getExpiredTimestamp();
      int i = k;
      if (paramBoolean2)
      {
        i = k;
        if (j == 0) {
          i = 1;
        }
      }
      if (i != 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A5B3", "0X800A5B3", 0, 0, "", "", "", "");
        localObject = paramString.getAIDTicket();
        String str = paramString.getTAIDTicket();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAidTicket aid ticket ->");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", taidTicket -> ");
        localStringBuilder.append(str);
        GdtLog.a("GdtAidHelper", localStringBuilder.toString());
        return new GdtAidHelper.TicketEntity(paramString.getAIDTicket(), paramString.getTAIDTicket(), 0, l, null);
      }
      if ((paramBoolean2) && (!bool)) {
        i = -2147483648;
      } else {
        i = j;
      }
      paramString = new StringBuilder();
      paramString.append("getAidTicket business id not verify, error code return only : error code-> ");
      paramString.append(i);
      GdtLog.a("GdtAidHelper", paramString.toString());
      return new GdtAidHelper.TicketEntity("", "", i, l, null);
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Turing get aid crash");
        ((StringBuilder)localObject).append(TuringDIDService.getVersionInfo());
        QLog.e("GdtAidHelper", 2, paramString, new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    return new GdtAidHelper.TicketEntity("", "", -2147483645, 0L, paramString, null);
  }
  
  static GdtAidHelper a()
  {
    return GdtAidHelper.GdtAidHelperHolder.a();
  }
  
  private boolean b(String paramString)
  {
    Object localObject = this.b;
    boolean bool = true;
    if (localObject == null) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.b == null)
        {
          localObject = new HashSet();
          try
          {
            localInputStream = BaseApplication.getContext().getResources().getAssets().open("AidAuthorityFile.xml");
            localXmlPullParser = Xml.newPullParser();
            localXmlPullParser.setInput(localInputStream, "utf-8");
            i = localXmlPullParser.getEventType();
          }
          catch (XmlPullParserException localXmlPullParserException)
          {
            InputStream localInputStream;
            XmlPullParser localXmlPullParser;
            String str;
            StringBuilder localStringBuilder;
            localXmlPullParserException.printStackTrace();
            continue;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
          if (localXmlPullParser.getName().equalsIgnoreCase("business"))
          {
            str = localXmlPullParser.getAttributeValue(null, "id");
            ((Set)localObject).add(str);
            if (QLog.isDevelopLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("init sensitive au, busiId = ");
              localStringBuilder.append(str);
              QLog.d("GdtAidHelper", 4, localStringBuilder.toString());
            }
          }
          i = localXmlPullParser.next();
          break label250;
          localInputStream.close();
          this.b = ((Set)localObject);
        }
      }
      finally {}
      if ((this.b == null) || (!this.b.contains(paramString))) {
        bool = false;
      }
      if (!bool) {
        this.a.a("GdtAidHelper", "business id verify fail, please check the business id");
      }
      return bool;
      label250:
      if (i != 1) {
        if (i != 0) {
          if (i == 2) {}
        }
      }
    }
  }
  
  GdtAidHelper.TicketEntity a(String paramString)
  {
    return a(paramString, true, true);
  }
  
  GdtAidHelper.TicketEntity b()
  {
    return a("", false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtAidHelper
 * JD-Core Version:    0.7.0.1
 */