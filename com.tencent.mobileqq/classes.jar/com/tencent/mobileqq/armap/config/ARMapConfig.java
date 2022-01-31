package com.tencent.mobileqq.armap.config;

import ablu;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class ARMapConfig
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new ablu();
  public static final int DEFAULT_503_TIMEOUT = 120;
  public static final int DEFAULT_FAIL_TIMEOUT = 20;
  public static final int DEFAULT_MAPUPDATEFLAG = 0;
  private static final String[] a = { "", "http://hbd.url.cn/myapp/qq_desk/lbsredbag/712f1a446d7ab4a7b6576334b9f4720albs_redbag.zip?md5=712f1a446d7ab4a7b6576334b9f4720a", "http://hbd.url.cn/myapp/qq_desk/lbsredbag/5a4b272703cb035a3b38263ba9e979e5lbs_multiredbag.zip?md5=5a4b272703cb035a3b38263ba9e979e5", "http://hbd.url.cn/myapp/qq_desk/lbsredbag/5a4b272703cb035a3b38263ba9e979e5lbs_multiredbag.zip?md5=5a4b272703cb035a3b38263ba9e979e5", "http://hbd.url.cn/myapp/qq_desk/lbsredbag/712f1a446d7ab4a7b6576334b9f4720albs_redbag.zip?md5=712f1a446d7ab4a7b6576334b9f4720a", "http://hbd.url.cn/myapp/qq_desk/lbsredbag/3990a29daca96ecbd063b4088540b104lbs_top.zip?md5=3990a29daca96ecbd063b4088540b104" };
  public ARMapConfig.ResInfo bgMusic;
  public List cheatApps;
  public ARMapConfig.ResInfo commonRes;
  public long curfewBeginTime = 82800000L;
  public long curfewEndTime = 23400000L;
  public ARMapConfig.ResInfo mapConfig;
  public ARMapConfig.ResInfo mapDaySkin;
  public int mapDownloadTimeout = 20;
  public int mapDownloadTimeoutFor503 = 120;
  public String mapEngineSoMd5;
  public int mapForceUpdate = 0;
  public int mapLocateFreq;
  public ARMapConfig.ResInfo mapNightSkin;
  public long mapPreLoadEndTime;
  public int mapPreLoadNetType;
  public long mapPreloadBeginTime;
  public long mapTopRightBeginTime;
  public long mapTopRightEndTime;
  public List mapTopRightRedPointDisplayTimes;
  public String mapTopRightUrl;
  public ARMapConfig.ResInfo openBoxRes;
  public String pccBid;
  public List poiModels;
  public long preLoadGridMapBeginTime;
  public long preLoadGridMapEndTime;
  public String shopScanTips;
  public ARMapConfig.ResInfo skySkin;
  public long starEntranceEndTime;
  public long starEntranceStartTime;
  public List starInfos;
  public int starRightButtonShow;
  public String starWebUrl;
  public ARMapConfig.ResInfo treeSkin;
  public int version;
  public ARMapConfig.WealthGodConfig wealthGodConfig;
  public List wordingList;
  
  public ARMapConfig()
  {
    this.poiModels = new ArrayList();
    this.wordingList = new ArrayList();
    this.starInfos = new ArrayList();
  }
  
  public ARMapConfig(Parcel paramParcel)
  {
    this.version = paramParcel.readInt();
    this.pccBid = paramParcel.readString();
    this.mapLocateFreq = paramParcel.readInt();
    this.curfewBeginTime = paramParcel.readLong();
    this.curfewEndTime = paramParcel.readLong();
    this.mapTopRightBeginTime = paramParcel.readLong();
    this.mapTopRightEndTime = paramParcel.readLong();
    this.mapTopRightUrl = paramParcel.readString();
    this.mapTopRightRedPointDisplayTimes = paramParcel.readArrayList(Long.class.getClassLoader());
    this.mapConfig = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
    this.mapDaySkin = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
    this.mapNightSkin = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
    this.skySkin = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
    this.treeSkin = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
    this.commonRes = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
    this.bgMusic = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
    this.poiModels = paramParcel.readArrayList(ARMapConfig.ResInfo.class.getClassLoader());
    this.cheatApps = paramParcel.readArrayList(String.class.getClassLoader());
    this.wealthGodConfig = ((ARMapConfig.WealthGodConfig)paramParcel.readParcelable(ARMapConfig.WealthGodConfig.class.getClassLoader()));
    this.wordingList = paramParcel.readArrayList(ARMapConfig.ResInfo.class.getClassLoader());
    this.mapDownloadTimeoutFor503 = paramParcel.readInt();
    this.mapDownloadTimeout = paramParcel.readInt();
    this.mapForceUpdate = paramParcel.readInt();
    this.mapPreloadBeginTime = paramParcel.readLong();
    this.mapPreLoadEndTime = paramParcel.readLong();
    this.mapPreLoadNetType = paramParcel.readInt();
    this.preLoadGridMapBeginTime = paramParcel.readLong();
    this.preLoadGridMapEndTime = paramParcel.readLong();
    this.starWebUrl = paramParcel.readString();
    this.starRightButtonShow = paramParcel.readInt();
    this.starInfos = paramParcel.readArrayList(ARMapConfig.StarInfo.class.getClassLoader());
    this.shopScanTips = paramParcel.readString();
  }
  
  private static ARMapConfig.ResInfo a(XmlPullParser paramXmlPullParser, int paramInt)
  {
    ARMapConfig.ResInfo localResInfo = new ARMapConfig.ResInfo();
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        k = paramXmlPullParser.getEventType();
      }
      catch (Exception paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
        return localResInfo;
      }
      int k = paramXmlPullParser.next();
      j = i;
      break label707;
      String str = paramXmlPullParser.getName();
      if (paramInt == 2)
      {
        if ("skinId".equalsIgnoreCase(str))
        {
          localResInfo.extra = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
          i = j;
        }
        else if ("url".equalsIgnoreCase(str))
        {
          localResInfo.url = paramXmlPullParser.nextText();
          i = j;
        }
        else
        {
          i = j;
          if ("md5".equalsIgnoreCase(str))
          {
            localResInfo.md5 = paramXmlPullParser.nextText();
            i = j;
          }
        }
      }
      else if (paramInt == 1)
      {
        if ("type".equalsIgnoreCase(str))
        {
          localResInfo.extra = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
          i = j;
        }
        else if ("url".equalsIgnoreCase(str))
        {
          localResInfo.url = paramXmlPullParser.nextText();
          i = j;
        }
        else
        {
          i = j;
          if ("md5".equalsIgnoreCase(str))
          {
            localResInfo.md5 = paramXmlPullParser.nextText();
            i = j;
          }
        }
      }
      else if (paramInt == 3)
      {
        if ("url".equalsIgnoreCase(str))
        {
          localResInfo.url = paramXmlPullParser.nextText();
          i = j;
        }
        else if ("md5".equalsIgnoreCase(str))
        {
          localResInfo.md5 = paramXmlPullParser.nextText();
          i = j;
        }
        else if ("isPreload".equalsIgnoreCase(str))
        {
          localResInfo.isPreload = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
          i = j;
        }
        else
        {
          i = j;
          if ("resType".equalsIgnoreCase(str))
          {
            str = paramXmlPullParser.nextText();
            if ("single".equalsIgnoreCase(str))
            {
              localResInfo.extra = 1;
              i = j;
            }
            else if ("two".equalsIgnoreCase(str))
            {
              localResInfo.extra = 2;
              i = j;
            }
            else if ("multi".equalsIgnoreCase(str))
            {
              localResInfo.extra = 3;
              i = j;
            }
            else if ("lbstop".equalsIgnoreCase(str))
            {
              localResInfo.extra = 5;
              i = j;
            }
            else
            {
              i = j;
              if ("disable".equalsIgnoreCase(str))
              {
                localResInfo.extra = 4;
                i = j;
              }
            }
          }
        }
      }
      else if (paramInt == 4)
      {
        if ("taskStatus".equalsIgnoreCase(str))
        {
          localResInfo.extra = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
          i = j;
        }
        else
        {
          i = j;
          if ("text".equalsIgnoreCase(str))
          {
            localResInfo.url = paramXmlPullParser.nextText();
            i = j;
          }
        }
      }
      else
      {
        i = j;
        if (paramInt == 5) {
          if ("url".equalsIgnoreCase(str))
          {
            localResInfo.url = paramXmlPullParser.nextText();
            i = j;
          }
          else
          {
            i = j;
            if ("md5".equalsIgnoreCase(str))
            {
              localResInfo.md5 = paramXmlPullParser.nextText();
              i = j;
              continue;
              str = paramXmlPullParser.getName();
              if (paramInt == 2)
              {
                i = j;
                if ("skinFile".equalsIgnoreCase(str)) {
                  i = 1;
                }
              }
              else if (paramInt == 1)
              {
                i = j;
                if ("res".equalsIgnoreCase(str)) {
                  i = 1;
                }
              }
              else if (paramInt == 3)
              {
                i = j;
                if ("model".equalsIgnoreCase(str)) {
                  i = 1;
                }
              }
              else if (paramInt == 4)
              {
                i = j;
                if ("wording".equalsIgnoreCase(str)) {
                  i = 1;
                }
              }
              else
              {
                i = j;
                if (paramInt == 5)
                {
                  boolean bool = "res".equalsIgnoreCase(str);
                  i = j;
                  if (bool)
                  {
                    i = 1;
                    continue;
                    label707:
                    if (j == 0)
                    {
                      i = j;
                      switch (k)
                      {
                      }
                      i = j;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static ARMapConfig.StarInfo a(XmlPullParser paramXmlPullParser)
  {
    ARMapConfig.StarInfo localStarInfo = new ARMapConfig.StarInfo();
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        k = paramXmlPullParser.getEventType();
      }
      catch (Exception paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
        return localStarInfo;
      }
      int k = paramXmlPullParser.next();
      i = j;
      break label241;
      String str = paramXmlPullParser.getName();
      if ("StarName".equalsIgnoreCase(str))
      {
        localStarInfo.StarName = paramXmlPullParser.nextText();
        j = i;
      }
      else if ("starID".equalsIgnoreCase(str))
      {
        localStarInfo.starId = Integer.parseInt(paramXmlPullParser.nextText());
        j = i;
      }
      else if ("ShareTitle".equalsIgnoreCase(str))
      {
        localStarInfo.ShareTitle = paramXmlPullParser.nextText();
        j = i;
      }
      else if ("ShareSummary".equalsIgnoreCase(str))
      {
        localStarInfo.ShareSummary = paramXmlPullParser.nextText();
        j = i;
      }
      else if ("ShareStructText".equalsIgnoreCase(str))
      {
        localStarInfo.ShareContent = paramXmlPullParser.nextText();
        j = i;
      }
      else
      {
        j = i;
        if ("res".equalsIgnoreCase(str))
        {
          localStarInfo.starResInfo = a(paramXmlPullParser, 5);
          j = i;
          continue;
          boolean bool = "Star".equalsIgnoreCase(paramXmlPullParser.getName());
          j = i;
          if (bool)
          {
            j = 1;
            continue;
            label241:
            if (i == 0)
            {
              j = i;
              switch (k)
              {
              }
              j = i;
            }
          }
        }
      }
    }
  }
  
  private static ARMapConfig.WealthGodActTime a(XmlPullParser paramXmlPullParser)
  {
    for (;;)
    {
      try
      {
        j = paramXmlPullParser.getEventType();
        i = 0;
        localObject1 = null;
        localObject2 = null;
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (i == 0) {
          switch (j)
          {
          }
        }
      }
      catch (Exception paramXmlPullParser)
      {
        int j;
        int i;
        Object localObject2 = null;
        Object localObject1 = null;
        Object localObject3 = localObject1;
        Object localObject4 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("APMapConfig", 2, "parseActTime exception:" + paramXmlPullParser.getMessage());
          localObject4 = localObject2;
          localObject3 = localObject1;
        }
        if ((TextUtils.isEmpty(localObject4)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
          break label273;
        }
        paramXmlPullParser = new ARMapConfig.WealthGodActTime();
        paramXmlPullParser.beginTime = ArMapUtil.b(localObject4);
        paramXmlPullParser.endTime = ArMapUtil.b((String)localObject3);
        return paramXmlPullParser;
      }
      try
      {
        j = paramXmlPullParser.next();
      }
      catch (Exception paramXmlPullParser)
      {
        continue;
      }
      continue;
      continue;
      try
      {
        localObject3 = paramXmlPullParser.getName();
        if ("startTime".equalsIgnoreCase((String)localObject3))
        {
          localObject3 = paramXmlPullParser.nextText();
          localObject2 = localObject3;
          continue;
        }
        if (!"endTime".equalsIgnoreCase((String)localObject3)) {
          continue;
        }
        localObject3 = paramXmlPullParser.nextText();
        localObject1 = localObject3;
      }
      catch (Exception paramXmlPullParser)
      {
        boolean bool;
        continue;
      }
      bool = "act".equalsIgnoreCase(paramXmlPullParser.getName());
      if (bool) {
        i = 1;
      }
    }
    label273:
    return null;
  }
  
  private static ARMapConfig.WealthGodConfig a(XmlPullParser paramXmlPullParser)
  {
    ARMapConfig.WealthGodConfig localWealthGodConfig = new ARMapConfig.WealthGodConfig();
    localWealthGodConfig.actSchedule = new ArrayList();
    label939:
    label993:
    for (;;)
    {
      int i;
      try
      {
        k = paramXmlPullParser.getEventType();
        i = 0;
        str = "";
      }
      catch (Exception paramXmlPullParser)
      {
        String str;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("APMapConfig", 2, "parseWealthGodConfig exception:" + paramXmlPullParser.getMessage());
        return localWealthGodConfig;
      }
      int k = paramXmlPullParser.next();
      break label939;
      localObject = paramXmlPullParser.getName();
      if ("enterStartTime".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.enterOpenTime = ArMapUtil.b(paramXmlPullParser.nextText());
      }
      else if ("enterEndTime".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.enterCloseTime = ArMapUtil.b(paramXmlPullParser.nextText());
      }
      else if ("permanentLedBeginTime".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.permanentLedBeginTime = ArMapUtil.a(paramXmlPullParser.nextText());
      }
      else if ("permanentLedEndTime".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.permanentLedEndTime = ArMapUtil.a(paramXmlPullParser.nextText());
      }
      else if ("splashLight".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.splashLight = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      }
      else if ("pendantSwitcher".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.pendantSwitcher = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      }
      else if ("showSpecialLoadingPage".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.showSpecialLoadingPage = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      }
      else if ("loadingPageInfoExpireDuration".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.loadingPageInfoExpireDuration = (Integer.valueOf(paramXmlPullParser.nextText()).intValue() * 1000);
      }
      else if ("showDailyPendantPercent".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.showDailyPendantPercent = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      }
      else if ("pendantDisplayDuration".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.pendantDisplayDuration = (Integer.valueOf(paramXmlPullParser.nextText()).intValue() * 1000);
      }
      else if ("pendantShowTime".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.pendantPreShowGap = (Integer.valueOf(paramXmlPullParser.nextText()).intValue() * 1000);
      }
      else if ("locateCheckTime".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.locatePreCheckGap = (Integer.valueOf(paramXmlPullParser.nextText()).intValue() * 1000);
      }
      else if ("locateFrequency".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.locateFrequency = (Integer.valueOf(paramXmlPullParser.nextText()).intValue() * 1000);
      }
      else if ("pbReqInterval".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.pbReqInterval = (Integer.valueOf(paramXmlPullParser.nextText()).intValue() * 1000);
      }
      else if ("resUrl".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.resUrl = paramXmlPullParser.nextText();
      }
      else if ("resMd5".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.resMd5 = paramXmlPullParser.nextText();
      }
      else if ("processTips".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.processTips = paramXmlPullParser.nextText();
      }
      else if ("countdownTips".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.countdownTips = paramXmlPullParser.nextText();
      }
      else if ("noBeginTips".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.noBeginTips = paramXmlPullParser.nextText();
      }
      else if ("endTips".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.endTips = paramXmlPullParser.nextText();
      }
      else if ("errorTips".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.errorTips = paramXmlPullParser.nextText();
      }
      else if ("curfewWarning".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.curfewWarning = paramXmlPullParser.nextText();
      }
      else if ("specialLoadingPageWording".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.specialLoadingPageWording = paramXmlPullParser.nextText();
      }
      else if ("topBarCloudUrl".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.topBarCloudUrl = paramXmlPullParser.nextText();
      }
      else if ("dragRefreshAfterBegin".equalsIgnoreCase((String)localObject))
      {
        localWealthGodConfig.dragRefreshAfterBegin = (Long.valueOf(paramXmlPullParser.nextText()).longValue() * 1000L);
      }
      else if ("actSchedule".equalsIgnoreCase((String)localObject))
      {
        str = "actSchedule";
      }
      else
      {
        int j = i;
        if ("actSchedule".equalsIgnoreCase(str))
        {
          j = i;
          if ("act".equalsIgnoreCase((String)localObject))
          {
            localObject = a(paramXmlPullParser);
            if (localObject == null) {
              break label993;
            }
            localWealthGodConfig.actSchedule.add(localObject);
            break label993;
            localObject = paramXmlPullParser.getName();
            if ("qqWealthGod".equalsIgnoreCase((String)localObject)) {
              i = 1;
            }
            j = i;
            if ("actSchedule".equalsIgnoreCase((String)localObject))
            {
              str = "";
              continue;
              if (i != 0) {
                continue;
              }
              j = i;
            }
          }
        }
        switch (k)
        {
        case 2: 
        case 3: 
        default: 
          j = i;
        case 1: 
          i = j;
          break;
        case 0: 
          break;
        }
      }
    }
  }
  
  private static List a(XmlPullParser paramXmlPullParser)
  {
    ArrayList localArrayList = new ArrayList();
    paramXmlPullParser = a(paramXmlPullParser, "redPointDisplayTimes", "beginTime").iterator();
    while (paramXmlPullParser.hasNext()) {
      localArrayList.add(Long.valueOf(ArMapUtil.b((String)paramXmlPullParser.next())));
    }
    return localArrayList;
  }
  
  private static List a(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
  {
    localArrayList = new ArrayList();
    int i = 0;
    try
    {
      int k = paramXmlPullParser.getEventType();
      for (;;)
      {
        k = paramXmlPullParser.next();
        i = j;
        break label98;
        int j = i;
        if (paramXmlPullParser.getName().equalsIgnoreCase(paramString2))
        {
          localArrayList.add(paramXmlPullParser.nextText());
          j = i;
          continue;
          boolean bool = paramString1.equalsIgnoreCase(paramXmlPullParser.getName());
          j = i;
          if (bool)
          {
            j = 1;
            continue;
            label98:
            if (i != 0) {
              break;
            }
            j = i;
            switch (k)
            {
            }
            j = i;
          }
        }
      }
      return localArrayList;
    }
    catch (Exception paramXmlPullParser) {}
  }
  
  public static void deleteLocalConfig(String paramString)
  {
    paramString = BaseApplicationImpl.getContext().getFileStreamPath("armap_config_" + paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    if (QLog.isColorLevel()) {
      QLog.d("APMapConfig", 2, "deleteLocalConfig path:" + paramString.getAbsolutePath());
    }
  }
  
  public static String getLbsPoi(ARMapConfig paramARMapConfig, int paramInt)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((paramARMapConfig != null) && (paramARMapConfig.poiModels != null))
    {
      i = paramARMapConfig.poiModels.size();
      if (j >= i) {
        break label144;
      }
      localObject = (ARMapConfig.ResInfo)paramARMapConfig.poiModels.get(j);
      if ((localObject == null) || (((ARMapConfig.ResInfo)localObject).extra != paramInt) || (TextUtils.isEmpty(((ARMapConfig.ResInfo)localObject).url)) || (TextUtils.isEmpty(((ARMapConfig.ResInfo)localObject).md5))) {
        break label137;
      }
    }
    label137:
    label144:
    for (paramARMapConfig = ((ARMapConfig.ResInfo)localObject).url + "?md5=" + ((ARMapConfig.ResInfo)localObject).md5;; paramARMapConfig = null)
    {
      localObject = paramARMapConfig;
      if (TextUtils.isEmpty(paramARMapConfig)) {
        localObject = a[paramInt];
      }
      return localObject;
      i = 0;
      break;
      j += 1;
      break;
    }
  }
  
  public static ARMapConfig parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ARMapConfig localARMapConfig = new ARMapConfig();
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = "";
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      int k;
      int i;
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        n = localXmlPullParser.getEventType();
        paramString = "";
        j = -1;
        k = -1;
        m = -1;
        i = -1;
      }
      catch (Exception paramString) {}
      int i1 = localXmlPullParser.next();
      int n = m;
      int m = j;
      int j = n;
      n = i1;
      break label2225;
      str2 = localXmlPullParser.getName();
      if (localXmlPullParser.getDepth() == 2)
      {
        localObject2 = str2;
        n = j;
        j = m;
        m = n;
      }
      else
      {
        if ("map".equalsIgnoreCase(localObject2))
        {
          if ("pccBid".equalsIgnoreCase(str2))
          {
            localARMapConfig.pccBid = localXmlPullParser.nextText();
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapLocateFreq".equalsIgnoreCase(str2))
          {
            localARMapConfig.mapLocateFreq = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("curfewBegin".equalsIgnoreCase(str2))
          {
            localARMapConfig.curfewBeginTime = ArMapUtil.d(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("curfewEnd".equalsIgnoreCase(str2))
          {
            localARMapConfig.curfewEndTime = ArMapUtil.d(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapDownloadTimeoutFor503".equalsIgnoreCase(str2))
          {
            localARMapConfig.mapDownloadTimeoutFor503 = Integer.parseInt(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapDownloadTimeout".equalsIgnoreCase(str2))
          {
            localARMapConfig.mapDownloadTimeout = Integer.parseInt(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapForceUpdate".equalsIgnoreCase(str2))
          {
            localARMapConfig.mapForceUpdate = Integer.parseInt(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapEngineSoMd5".equalsIgnoreCase(str2))
          {
            localARMapConfig.mapEngineSoMd5 = localXmlPullParser.nextText();
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapPreDownloadBeginTime".equals(str2))
          {
            localARMapConfig.mapPreloadBeginTime = ArMapUtil.c(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapPreDownloadEndTime".equals(str2))
          {
            localARMapConfig.mapPreLoadEndTime = ArMapUtil.c(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapPreDownloadNetType".equals(str2))
          {
            localARMapConfig.mapPreLoadNetType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("preDownGridMapBeginTime".equals(str2))
          {
            localARMapConfig.preLoadGridMapBeginTime = ArMapUtil.b(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("preDownGridMapEndTime".equals(str2))
          {
            localARMapConfig.preLoadGridMapEndTime = ArMapUtil.b(localXmlPullParser.nextText());
            n = j;
            j = m;
            m = n;
          }
        }
        else if ("skin".equalsIgnoreCase(localObject2))
        {
          if ("skinDayId".equalsIgnoreCase(str2))
          {
            n = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            j = m;
            m = n;
            continue;
          }
          if ("skinNightId".equalsIgnoreCase(str2))
          {
            k = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("skinSkyId".equalsIgnoreCase(str2))
          {
            n = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            m = j;
            j = n;
            continue;
          }
          if ("skinTreeId".equalsIgnoreCase(str2))
          {
            i = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapConfig".equalsIgnoreCase(str2))
          {
            localObject1 = "mapConfig";
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("skinFiles".equalsIgnoreCase(str2))
          {
            localObject1 = "skinFiles";
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("skinSkyConfig".equalsIgnoreCase(str2))
          {
            localObject1 = "skinSkyConfig";
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("skinTreeConfig".equalsIgnoreCase(str2))
          {
            localObject1 = "skinTreeConfig";
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapConfig".equalsIgnoreCase((String)localObject1))
          {
            if ("url".equalsIgnoreCase(str2))
            {
              str1 = localXmlPullParser.nextText();
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("md5".equalsIgnoreCase(str2))
            {
              paramString = localXmlPullParser.nextText();
              n = j;
              j = m;
              m = n;
            }
          }
          else if ("skinFiles".equalsIgnoreCase((String)localObject1))
          {
            if ("skinFile".equalsIgnoreCase(str2))
            {
              localArrayList4.add(a(localXmlPullParser, 2));
              n = j;
              j = m;
              m = n;
            }
          }
          else if ("skinSkyConfig".equalsIgnoreCase((String)localObject1))
          {
            if ("skinFile".equals(str2))
            {
              localArrayList2.add(a(localXmlPullParser, 2));
              n = j;
              j = m;
              m = n;
            }
          }
          else if (("skinTreeConfig".equalsIgnoreCase((String)localObject1)) && ("skinFile".equals(str2)))
          {
            localArrayList3.add(a(localXmlPullParser, 2));
            n = j;
            j = m;
            m = n;
          }
        }
        else if ("poi".equalsIgnoreCase(localObject2))
        {
          if ("model".equalsIgnoreCase(str2))
          {
            localARMapConfig.poiModels.add(a(localXmlPullParser, 3));
            n = j;
            j = m;
            m = n;
          }
        }
        else if ("cheatApp".equalsIgnoreCase(localObject2))
        {
          if ("android".equalsIgnoreCase(str2))
          {
            localARMapConfig.cheatApps = a(localXmlPullParser, "android", "app");
            n = j;
            j = m;
            m = n;
          }
        }
        else if ("commonRes".equalsIgnoreCase(localObject2))
        {
          if ("res".equals(str2))
          {
            localArrayList1.add(a(localXmlPullParser, 1));
            n = j;
            j = m;
            m = n;
          }
        }
        else
        {
          if ("qqWealthGod".equalsIgnoreCase(localObject2))
          {
            localARMapConfig.wealthGodConfig = a(localXmlPullParser);
            n = j;
            j = m;
            m = n;
            continue;
          }
          if ("mapTopRightEnter".equalsIgnoreCase(localObject2))
          {
            if ("redirectUrl".equalsIgnoreCase(str2))
            {
              localARMapConfig.mapTopRightUrl = localXmlPullParser.nextText();
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("beginTime".equalsIgnoreCase(str2))
            {
              localARMapConfig.mapTopRightBeginTime = ArMapUtil.b(localXmlPullParser.nextText());
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("endTime".equalsIgnoreCase(str2))
            {
              localARMapConfig.mapTopRightEndTime = ArMapUtil.b(localXmlPullParser.nextText());
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("redPointDisplayTimes".equalsIgnoreCase(str2))
            {
              localARMapConfig.mapTopRightRedPointDisplayTimes = a(localXmlPullParser);
              n = j;
              j = m;
              m = n;
            }
          }
          else if ("wordings".equalsIgnoreCase(localObject2))
          {
            if ("wording".equalsIgnoreCase(str2))
            {
              localObject1 = "wording";
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("wording".equalsIgnoreCase((String)localObject1))
            {
              localARMapConfig.wordingList.add(a(localXmlPullParser, 4));
              n = j;
              j = m;
              m = n;
            }
          }
          else if ("mapStarConfig".equalsIgnoreCase(localObject2))
          {
            if ("starWebUrl".equalsIgnoreCase(str2))
            {
              localARMapConfig.starWebUrl = localXmlPullParser.nextText();
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("isShow".equalsIgnoreCase(str2))
            {
              localARMapConfig.starRightButtonShow = Integer.parseInt(localXmlPullParser.nextText());
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("beginTime".equalsIgnoreCase(str2))
            {
              localARMapConfig.starEntranceStartTime = ArMapUtil.b(localXmlPullParser.nextText());
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("endTime".equalsIgnoreCase(str2))
            {
              localARMapConfig.starEntranceEndTime = ArMapUtil.b(localXmlPullParser.nextText());
              n = j;
              j = m;
              m = n;
              continue;
            }
            if ("Star".equalsIgnoreCase(str2))
            {
              localARMapConfig.starInfos.add(a(localXmlPullParser));
              n = j;
              j = m;
              m = n;
            }
          }
          else if (("ShopScan".equalsIgnoreCase(localObject2)) && ("tips".equalsIgnoreCase(str2)))
          {
            localARMapConfig.shopScanTips = localXmlPullParser.nextText();
            n = j;
            j = m;
            m = n;
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("APMapConfig", 2, "parse exception:" + paramString.toString());
            label2225:
            while (n == 1)
            {
              String str2;
              if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1))) {
                localARMapConfig.mapConfig = new ARMapConfig.ResInfo(str1, paramString, -1);
              }
              if (localArrayList4 != null)
              {
                paramString = localArrayList4.iterator();
                while (paramString.hasNext())
                {
                  localObject1 = (ARMapConfig.ResInfo)paramString.next();
                  if (j == ((ARMapConfig.ResInfo)localObject1).extra) {
                    localARMapConfig.mapDaySkin = ((ARMapConfig.ResInfo)localObject1);
                  }
                  if (k == ((ARMapConfig.ResInfo)localObject1).extra) {
                    localARMapConfig.mapNightSkin = ((ARMapConfig.ResInfo)localObject1);
                  }
                }
              }
              if (localArrayList3 != null)
              {
                paramString = localArrayList3.iterator();
                while (paramString.hasNext())
                {
                  localObject1 = (ARMapConfig.ResInfo)paramString.next();
                  if (i == ((ARMapConfig.ResInfo)localObject1).extra) {
                    localARMapConfig.treeSkin = ((ARMapConfig.ResInfo)localObject1);
                  }
                }
              }
              if (localArrayList2 != null)
              {
                paramString = localArrayList2.iterator();
                while (paramString.hasNext())
                {
                  localObject1 = (ARMapConfig.ResInfo)paramString.next();
                  if (m == ((ARMapConfig.ResInfo)localObject1).extra) {
                    localARMapConfig.skySkin = ((ARMapConfig.ResInfo)localObject1);
                  }
                }
              }
              if (localArrayList1 != null)
              {
                paramString = localArrayList1.iterator();
                while (paramString.hasNext())
                {
                  localObject1 = (ARMapConfig.ResInfo)paramString.next();
                  if (((ARMapConfig.ResInfo)localObject1).extra == 2) {
                    localARMapConfig.bgMusic = ((ARMapConfig.ResInfo)localObject1);
                  }
                  if (((ARMapConfig.ResInfo)localObject1).extra == 1) {
                    localARMapConfig.commonRes = ((ARMapConfig.ResInfo)localObject1);
                  }
                  if (((ARMapConfig.ResInfo)localObject1).extra == 3) {
                    localARMapConfig.openBoxRes = ((ARMapConfig.ResInfo)localObject1);
                  }
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("APMapConfig", 2, "parse:" + localARMapConfig);
              }
              return localARMapConfig;
            }
          }
        }
        switch (n)
        {
        case 2: 
        case 1: 
        case 3: 
        default: 
          n = j;
          j = m;
          m = n;
          break;
        case 0: 
          n = j;
          j = m;
          m = n;
          break;
        case 4: 
          n = j;
          j = m;
          m = n;
        }
      }
    }
  }
  
  /* Error */
  public static ARMapConfig readFromFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 318
    //   9: iconst_2
    //   10: ldc_w 679
    //   13: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_0
    //   17: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +21 -> 41
    //   23: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +13 -> 39
    //   29: ldc_w 318
    //   32: iconst_2
    //   33: ldc_w 681
    //   36: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: areturn
    //   41: invokestatic 519	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: new 320	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 521
    //   54: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 527	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 532	java/io/File:exists	()Z
    //   72: ifne +21 -> 93
    //   75: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq -39 -> 39
    //   81: ldc_w 318
    //   84: iconst_2
    //   85: ldc_w 683
    //   88: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aconst_null
    //   92: areturn
    //   93: ldc_w 684
    //   96: newarray byte
    //   98: astore_0
    //   99: new 686	java/io/FileInputStream
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 689	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   107: astore_1
    //   108: aload_1
    //   109: aload_0
    //   110: invokevirtual 693	java/io/FileInputStream:read	([B)I
    //   113: pop
    //   114: new 695	java/io/ObjectInputStream
    //   117: dup
    //   118: new 562	java/io/ByteArrayInputStream
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 569	java/io/ByteArrayInputStream:<init>	([B)V
    //   126: invokespecial 698	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   129: astore 5
    //   131: aload 5
    //   133: astore_3
    //   134: aload_1
    //   135: astore_2
    //   136: aload 5
    //   138: invokevirtual 701	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   141: checkcast 2	com/tencent/mobileqq/armap/config/ARMapConfig
    //   144: astore 4
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 704	java/io/FileInputStream:close	()V
    //   154: aload 4
    //   156: astore_0
    //   157: aload 5
    //   159: ifnull +11 -> 170
    //   162: aload 5
    //   164: invokevirtual 705	java/io/ObjectInputStream:close	()V
    //   167: aload 4
    //   169: astore_0
    //   170: aload_0
    //   171: areturn
    //   172: astore_0
    //   173: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq -22 -> 154
    //   179: aload_0
    //   180: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   183: goto -29 -> 154
    //   186: astore_1
    //   187: aload 4
    //   189: astore_0
    //   190: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq -23 -> 170
    //   196: aload_1
    //   197: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   200: aload 4
    //   202: astore_0
    //   203: goto -33 -> 170
    //   206: astore 4
    //   208: aconst_null
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: aload_0
    //   213: astore_3
    //   214: aload_1
    //   215: astore_2
    //   216: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +38 -> 257
    //   222: aload_0
    //   223: astore_3
    //   224: aload_1
    //   225: astore_2
    //   226: ldc_w 318
    //   229: iconst_2
    //   230: new 320	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 708
    //   240: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 4
    //   245: invokevirtual 664	java/lang/Exception:toString	()Ljava/lang/String;
    //   248: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 704	java/io/FileInputStream:close	()V
    //   265: aload_0
    //   266: ifnull +120 -> 386
    //   269: aload_0
    //   270: invokevirtual 705	java/io/ObjectInputStream:close	()V
    //   273: aconst_null
    //   274: astore_0
    //   275: goto -105 -> 170
    //   278: astore_1
    //   279: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -17 -> 265
    //   285: aload_1
    //   286: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   289: goto -24 -> 265
    //   292: astore_0
    //   293: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +7 -> 303
    //   299: aload_0
    //   300: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   303: aconst_null
    //   304: astore_0
    //   305: goto -135 -> 170
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_3
    //   311: aconst_null
    //   312: astore_1
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 704	java/io/FileInputStream:close	()V
    //   321: aload_3
    //   322: ifnull +7 -> 329
    //   325: aload_3
    //   326: invokevirtual 705	java/io/ObjectInputStream:close	()V
    //   329: aload_0
    //   330: athrow
    //   331: astore_1
    //   332: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -14 -> 321
    //   338: aload_1
    //   339: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   342: goto -21 -> 321
    //   345: astore_1
    //   346: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq -20 -> 329
    //   352: aload_1
    //   353: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   356: goto -27 -> 329
    //   359: astore_0
    //   360: aconst_null
    //   361: astore_3
    //   362: goto -49 -> 313
    //   365: astore_0
    //   366: aload_2
    //   367: astore_1
    //   368: goto -55 -> 313
    //   371: astore 4
    //   373: aconst_null
    //   374: astore_0
    //   375: goto -163 -> 212
    //   378: astore 4
    //   380: aload 5
    //   382: astore_0
    //   383: goto -171 -> 212
    //   386: aconst_null
    //   387: astore_0
    //   388: goto -218 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString	String
    //   67	84	1	localObject1	Object
    //   186	11	1	localIOException1	java.io.IOException
    //   211	51	1	localObject2	Object
    //   278	8	1	localIOException2	java.io.IOException
    //   312	6	1	localObject3	Object
    //   331	8	1	localIOException3	java.io.IOException
    //   345	8	1	localIOException4	java.io.IOException
    //   367	1	1	localObject4	Object
    //   135	232	2	localObject5	Object
    //   133	229	3	localObject6	Object
    //   144	57	4	localARMapConfig	ARMapConfig
    //   206	38	4	localException1	Exception
    //   371	1	4	localException2	Exception
    //   378	1	4	localException3	Exception
    //   129	252	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   150	154	172	java/io/IOException
    //   162	167	186	java/io/IOException
    //   93	108	206	java/lang/Exception
    //   261	265	278	java/io/IOException
    //   269	273	292	java/io/IOException
    //   93	108	308	finally
    //   317	321	331	java/io/IOException
    //   325	329	345	java/io/IOException
    //   108	131	359	finally
    //   136	146	365	finally
    //   216	222	365	finally
    //   226	257	365	finally
    //   108	131	371	java/lang/Exception
    //   136	146	378	java/lang/Exception
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ARMapConfig.WealthGodActTime getRecentActTime()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if ((this.wealthGodConfig == null) || (this.wealthGodConfig.actSchedule == null))
    {
      QLog.d("APMapConfig", 1, "getRecentActTime wealthGodConfig is null or actScheduled is null");
      localObject2 = localObject1;
    }
    do
    {
      return localObject2;
      localObject1 = localObject2;
      if (this.wealthGodConfig.actSchedule != null)
      {
        localObject1 = localObject2;
        if (this.wealthGodConfig.actSchedule.size() > 0)
        {
          Collections.sort(this.wealthGodConfig.actSchedule);
          localObject1 = (ARMapConfig.WealthGodActTime)this.wealthGodConfig.actSchedule.get(this.wealthGodConfig.actSchedule.size() - 1);
        }
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("APMapConfig", 2, "getRecentActTime recentActTime:" + localObject1 + ",wealthGodConfig.actSchedule:" + this.wealthGodConfig.actSchedule);
    return localObject1;
  }
  
  public String getWording(int paramInt)
  {
    int i = 0;
    while (i < this.wordingList.size())
    {
      if (((ARMapConfig.ResInfo)this.wordingList.get(i)).extra == paramInt) {
        return ((ARMapConfig.ResInfo)this.wordingList.get(i)).url;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean isWealthGodEnterOpen()
  {
    boolean bool1 = true;
    boolean bool2;
    if ((this.wealthGodConfig == null) || (this.wealthGodConfig.actSchedule == null))
    {
      QLog.d("APMapConfig", 1, "isWealthGodEnterOpen wealthGodConfig is null or actScheduled is null");
      bool2 = false;
      return bool2;
    }
    long l = MessageCache.a() * 1000L;
    if ((l > this.wealthGodConfig.enterOpenTime) && (l < this.wealthGodConfig.enterCloseTime)) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("APMapConfig", 2, "isWealthGodEnterOpen, isEnterOpen:" + bool1);
      return bool1;
      bool1 = false;
    }
  }
  
  /* Error */
  public void saveToFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +13 -> 25
    //   15: ldc_w 318
    //   18: iconst_2
    //   19: ldc_w 742
    //   22: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: return
    //   26: invokestatic 519	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   29: new 320	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 521
    //   39: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 527	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore 4
    //   54: invokestatic 519	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   57: new 320	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 521
    //   67: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 744
    //   77: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 527	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   86: astore 9
    //   88: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +34 -> 125
    //   94: ldc_w 318
    //   97: iconst_2
    //   98: new 320	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 746
    //   108: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 4
    //   113: invokevirtual 540	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload 9
    //   127: invokevirtual 532	java/io/File:exists	()Z
    //   130: ifeq +9 -> 139
    //   133: aload 9
    //   135: invokevirtual 535	java/io/File:delete	()Z
    //   138: pop
    //   139: aload 9
    //   141: invokevirtual 749	java/io/File:createNewFile	()Z
    //   144: pop
    //   145: new 751	java/io/FileOutputStream
    //   148: dup
    //   149: aload 9
    //   151: invokespecial 752	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: astore_3
    //   155: new 754	java/io/ByteArrayOutputStream
    //   158: dup
    //   159: sipush 8192
    //   162: invokespecial 757	java/io/ByteArrayOutputStream:<init>	(I)V
    //   165: astore_1
    //   166: new 759	java/io/ObjectOutputStream
    //   169: dup
    //   170: aload_1
    //   171: invokespecial 762	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   174: astore 6
    //   176: aload_3
    //   177: astore 8
    //   179: aload_1
    //   180: astore 7
    //   182: aload 6
    //   184: astore 5
    //   186: aload 6
    //   188: aload_0
    //   189: invokevirtual 766	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   192: aload_3
    //   193: astore 8
    //   195: aload_1
    //   196: astore 7
    //   198: aload 6
    //   200: astore 5
    //   202: aload 6
    //   204: invokevirtual 769	java/io/ObjectOutputStream:flush	()V
    //   207: aload_3
    //   208: astore 8
    //   210: aload_1
    //   211: astore 7
    //   213: aload 6
    //   215: astore 5
    //   217: aload_1
    //   218: aload_3
    //   219: invokevirtual 772	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   222: aload_3
    //   223: astore 8
    //   225: aload_1
    //   226: astore 7
    //   228: aload 6
    //   230: astore 5
    //   232: aload_1
    //   233: invokevirtual 773	java/io/ByteArrayOutputStream:flush	()V
    //   236: aload_3
    //   237: astore 8
    //   239: aload_1
    //   240: astore 7
    //   242: aload 6
    //   244: astore 5
    //   246: aload_3
    //   247: invokevirtual 774	java/io/FileOutputStream:flush	()V
    //   250: aload_3
    //   251: astore 8
    //   253: aload_1
    //   254: astore 7
    //   256: aload 6
    //   258: astore 5
    //   260: aload 4
    //   262: invokevirtual 532	java/io/File:exists	()Z
    //   265: ifeq +19 -> 284
    //   268: aload_3
    //   269: astore 8
    //   271: aload_1
    //   272: astore 7
    //   274: aload 6
    //   276: astore 5
    //   278: aload 4
    //   280: invokevirtual 535	java/io/File:delete	()Z
    //   283: pop
    //   284: aload_3
    //   285: astore 8
    //   287: aload_1
    //   288: astore 7
    //   290: aload 6
    //   292: astore 5
    //   294: aload 9
    //   296: aload 4
    //   298: invokevirtual 778	java/io/File:renameTo	(Ljava/io/File;)Z
    //   301: pop
    //   302: aload_3
    //   303: astore 8
    //   305: aload_1
    //   306: astore 7
    //   308: aload 6
    //   310: astore 5
    //   312: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +23 -> 338
    //   318: aload_3
    //   319: astore 8
    //   321: aload_1
    //   322: astore 7
    //   324: aload 6
    //   326: astore 5
    //   328: ldc_w 318
    //   331: iconst_2
    //   332: ldc_w 780
    //   335: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_3
    //   339: ifnull +7 -> 346
    //   342: aload_3
    //   343: invokevirtual 781	java/io/FileOutputStream:close	()V
    //   346: aload 6
    //   348: ifnull +8 -> 356
    //   351: aload 6
    //   353: invokevirtual 782	java/io/ObjectOutputStream:close	()V
    //   356: aload_1
    //   357: ifnull -332 -> 25
    //   360: aload_1
    //   361: invokevirtual 783	java/io/ByteArrayOutputStream:close	()V
    //   364: return
    //   365: astore_1
    //   366: aload_1
    //   367: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   370: return
    //   371: astore_2
    //   372: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq -29 -> 346
    //   378: aload_2
    //   379: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   382: goto -36 -> 346
    //   385: astore_2
    //   386: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq -33 -> 356
    //   392: aload_2
    //   393: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   396: goto -40 -> 356
    //   399: astore 4
    //   401: aconst_null
    //   402: astore_3
    //   403: aconst_null
    //   404: astore_1
    //   405: aload 4
    //   407: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   410: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +34 -> 447
    //   416: ldc_w 318
    //   419: iconst_2
    //   420: new 320	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 785
    //   430: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 4
    //   435: invokevirtual 786	java/io/IOException:toString	()Ljava/lang/String;
    //   438: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_3
    //   448: ifnull +7 -> 455
    //   451: aload_3
    //   452: invokevirtual 781	java/io/FileOutputStream:close	()V
    //   455: aload_1
    //   456: ifnull +7 -> 463
    //   459: aload_1
    //   460: invokevirtual 782	java/io/ObjectOutputStream:close	()V
    //   463: aload_2
    //   464: ifnull -439 -> 25
    //   467: aload_2
    //   468: invokevirtual 783	java/io/ByteArrayOutputStream:close	()V
    //   471: return
    //   472: astore_1
    //   473: aload_1
    //   474: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   477: return
    //   478: astore_3
    //   479: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq -27 -> 455
    //   485: aload_3
    //   486: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   489: goto -34 -> 455
    //   492: astore_1
    //   493: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq -33 -> 463
    //   499: aload_1
    //   500: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   503: goto -40 -> 463
    //   506: astore 4
    //   508: aconst_null
    //   509: astore_3
    //   510: aconst_null
    //   511: astore_2
    //   512: aconst_null
    //   513: astore_1
    //   514: aload_3
    //   515: astore 8
    //   517: aload_2
    //   518: astore 7
    //   520: aload_1
    //   521: astore 5
    //   523: ldc_w 318
    //   526: iconst_2
    //   527: new 320	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 788
    //   537: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload 4
    //   542: invokevirtual 789	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   545: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: aload_3
    //   555: ifnull +7 -> 562
    //   558: aload_3
    //   559: invokevirtual 781	java/io/FileOutputStream:close	()V
    //   562: aload_1
    //   563: ifnull +7 -> 570
    //   566: aload_1
    //   567: invokevirtual 782	java/io/ObjectOutputStream:close	()V
    //   570: aload_2
    //   571: ifnull -546 -> 25
    //   574: aload_2
    //   575: invokevirtual 783	java/io/ByteArrayOutputStream:close	()V
    //   578: return
    //   579: astore_1
    //   580: aload_1
    //   581: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   584: return
    //   585: astore_3
    //   586: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq -27 -> 562
    //   592: aload_3
    //   593: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   596: goto -34 -> 562
    //   599: astore_1
    //   600: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   603: ifeq -33 -> 570
    //   606: aload_1
    //   607: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   610: goto -40 -> 570
    //   613: astore_2
    //   614: aconst_null
    //   615: astore 4
    //   617: aconst_null
    //   618: astore_1
    //   619: aconst_null
    //   620: astore_3
    //   621: aload 4
    //   623: ifnull +8 -> 631
    //   626: aload 4
    //   628: invokevirtual 781	java/io/FileOutputStream:close	()V
    //   631: aload_3
    //   632: ifnull +7 -> 639
    //   635: aload_3
    //   636: invokevirtual 782	java/io/ObjectOutputStream:close	()V
    //   639: aload_1
    //   640: ifnull +7 -> 647
    //   643: aload_1
    //   644: invokevirtual 783	java/io/ByteArrayOutputStream:close	()V
    //   647: aload_2
    //   648: athrow
    //   649: astore 4
    //   651: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -23 -> 631
    //   657: aload 4
    //   659: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   662: goto -31 -> 631
    //   665: astore_3
    //   666: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq -30 -> 639
    //   672: aload_3
    //   673: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   676: goto -37 -> 639
    //   679: astore_1
    //   680: aload_1
    //   681: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   684: goto -37 -> 647
    //   687: astore_2
    //   688: aconst_null
    //   689: astore_1
    //   690: aconst_null
    //   691: astore 5
    //   693: aload_3
    //   694: astore 4
    //   696: aload 5
    //   698: astore_3
    //   699: goto -78 -> 621
    //   702: astore_2
    //   703: aconst_null
    //   704: astore 5
    //   706: aload_3
    //   707: astore 4
    //   709: aload 5
    //   711: astore_3
    //   712: goto -91 -> 621
    //   715: astore_2
    //   716: aload 8
    //   718: astore 4
    //   720: aload 7
    //   722: astore_1
    //   723: aload 5
    //   725: astore_3
    //   726: goto -105 -> 621
    //   729: astore 4
    //   731: aload_1
    //   732: astore 5
    //   734: aload_2
    //   735: astore_1
    //   736: aload 4
    //   738: astore_2
    //   739: aload_3
    //   740: astore 4
    //   742: aload 5
    //   744: astore_3
    //   745: goto -124 -> 621
    //   748: astore 4
    //   750: aconst_null
    //   751: astore_2
    //   752: aconst_null
    //   753: astore_1
    //   754: goto -240 -> 514
    //   757: astore 4
    //   759: aconst_null
    //   760: astore 5
    //   762: aload_1
    //   763: astore_2
    //   764: aload 5
    //   766: astore_1
    //   767: goto -253 -> 514
    //   770: astore 4
    //   772: aload_1
    //   773: astore_2
    //   774: aload 6
    //   776: astore_1
    //   777: goto -263 -> 514
    //   780: astore 4
    //   782: aconst_null
    //   783: astore_1
    //   784: goto -379 -> 405
    //   787: astore 4
    //   789: aconst_null
    //   790: astore 5
    //   792: aload_1
    //   793: astore_2
    //   794: aload 5
    //   796: astore_1
    //   797: goto -392 -> 405
    //   800: astore 4
    //   802: aload_1
    //   803: astore_2
    //   804: aload 6
    //   806: astore_1
    //   807: goto -402 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	810	0	this	ARMapConfig
    //   0	810	1	paramString	String
    //   1	1	2	localObject1	Object
    //   371	8	2	localIOException1	java.io.IOException
    //   385	83	2	localIOException2	java.io.IOException
    //   511	64	2	localObject2	Object
    //   613	35	2	localObject3	Object
    //   687	1	2	localObject4	Object
    //   702	1	2	localObject5	Object
    //   715	20	2	localObject6	Object
    //   738	66	2	localObject7	Object
    //   154	298	3	localFileOutputStream	java.io.FileOutputStream
    //   478	8	3	localIOException3	java.io.IOException
    //   509	50	3	localObject8	Object
    //   585	8	3	localIOException4	java.io.IOException
    //   620	16	3	localObject9	Object
    //   665	29	3	localIOException5	java.io.IOException
    //   698	47	3	localObject10	Object
    //   52	245	4	localFile1	File
    //   399	35	4	localIOException6	java.io.IOException
    //   506	35	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   615	12	4	localObject11	Object
    //   649	9	4	localIOException7	java.io.IOException
    //   694	25	4	localObject12	Object
    //   729	8	4	localObject13	Object
    //   740	1	4	localObject14	Object
    //   748	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   757	1	4	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   770	1	4	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   780	1	4	localIOException8	java.io.IOException
    //   787	1	4	localIOException9	java.io.IOException
    //   800	1	4	localIOException10	java.io.IOException
    //   184	611	5	localObject15	Object
    //   174	631	6	localObjectOutputStream	java.io.ObjectOutputStream
    //   180	541	7	localObject16	Object
    //   177	540	8	localObject17	Object
    //   86	209	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   360	364	365	java/io/IOException
    //   342	346	371	java/io/IOException
    //   351	356	385	java/io/IOException
    //   139	155	399	java/io/IOException
    //   467	471	472	java/io/IOException
    //   451	455	478	java/io/IOException
    //   459	463	492	java/io/IOException
    //   139	155	506	java/lang/OutOfMemoryError
    //   574	578	579	java/io/IOException
    //   558	562	585	java/io/IOException
    //   566	570	599	java/io/IOException
    //   139	155	613	finally
    //   626	631	649	java/io/IOException
    //   635	639	665	java/io/IOException
    //   643	647	679	java/io/IOException
    //   155	166	687	finally
    //   166	176	702	finally
    //   186	192	715	finally
    //   202	207	715	finally
    //   217	222	715	finally
    //   232	236	715	finally
    //   246	250	715	finally
    //   260	268	715	finally
    //   278	284	715	finally
    //   294	302	715	finally
    //   312	318	715	finally
    //   328	338	715	finally
    //   523	554	715	finally
    //   405	447	729	finally
    //   155	166	748	java/lang/OutOfMemoryError
    //   166	176	757	java/lang/OutOfMemoryError
    //   186	192	770	java/lang/OutOfMemoryError
    //   202	207	770	java/lang/OutOfMemoryError
    //   217	222	770	java/lang/OutOfMemoryError
    //   232	236	770	java/lang/OutOfMemoryError
    //   246	250	770	java/lang/OutOfMemoryError
    //   260	268	770	java/lang/OutOfMemoryError
    //   278	284	770	java/lang/OutOfMemoryError
    //   294	302	770	java/lang/OutOfMemoryError
    //   312	318	770	java/lang/OutOfMemoryError
    //   328	338	770	java/lang/OutOfMemoryError
    //   155	166	780	java/io/IOException
    //   166	176	787	java/io/IOException
    //   186	192	800	java/io/IOException
    //   202	207	800	java/io/IOException
    //   217	222	800	java/io/IOException
    //   232	236	800	java/io/IOException
    //   246	250	800	java/io/IOException
    //   260	268	800	java/io/IOException
    //   278	284	800	java/io/IOException
    //   294	302	800	java/io/IOException
    //   312	318	800	java/io/IOException
    //   328	338	800	java/io/IOException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("version:").append(this.version).append("\npccBid:").append(this.pccBid).append("\nmapEngineSoMd5:").append(this.mapEngineSoMd5).append("\nmapLocateFreq:").append(this.mapLocateFreq).append("\nmapTopRightBeginTime:").append(this.mapTopRightBeginTime).append("\nmapTopRightEndTime:").append(this.mapTopRightEndTime).append("\nmapTopRightUrl:").append(this.mapTopRightUrl).append("\nmapConfig:").append(this.mapConfig).append("\nmapDaySkin:").append(this.mapDaySkin).append("\nmapNightSkin:").append(this.mapNightSkin).append("\nskySkin:").append(this.skySkin).append("\ntreeSkin:").append(this.treeSkin).append("\ncommonRes:").append(this.commonRes).append("\nbgMusic:").append(this.bgMusic).append("\npoiModels:").append(this.poiModels).append("\ncheatApps:").append(this.cheatApps).append("\nwealthGodConfig:").append(this.wealthGodConfig).append("\nWordingConfig:").append(this.wordingList).append("\nmapPreloadBeginTime:").append(this.mapPreloadBeginTime).append("\nmapPreLoadEndTime:").append(this.mapPreLoadEndTime).append("\nmapPreLoadNetType:").append(this.mapPreLoadNetType).append("\npreLoadGridMapBeginTime:").append(this.preLoadGridMapBeginTime).append("\npreLoadGridMapEndTime:").append(this.preLoadGridMapEndTime);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.pccBid);
    paramParcel.writeInt(this.mapLocateFreq);
    paramParcel.writeLong(this.curfewBeginTime);
    paramParcel.writeLong(this.curfewEndTime);
    paramParcel.writeLong(this.mapTopRightBeginTime);
    paramParcel.writeLong(this.mapTopRightEndTime);
    paramParcel.writeString(this.mapTopRightUrl);
    paramParcel.writeList(this.mapTopRightRedPointDisplayTimes);
    paramParcel.writeParcelable(this.mapConfig, paramInt);
    paramParcel.writeParcelable(this.mapDaySkin, paramInt);
    paramParcel.writeParcelable(this.mapNightSkin, paramInt);
    paramParcel.writeParcelable(this.skySkin, paramInt);
    paramParcel.writeParcelable(this.treeSkin, paramInt);
    paramParcel.writeParcelable(this.commonRes, paramInt);
    paramParcel.writeParcelable(this.bgMusic, paramInt);
    paramParcel.writeList(this.poiModels);
    paramParcel.writeList(this.cheatApps);
    paramParcel.writeParcelable(this.commonRes, paramInt);
    paramParcel.writeParcelable(this.wealthGodConfig, paramInt);
    paramParcel.writeList(this.wordingList);
    paramParcel.writeInt(this.mapDownloadTimeoutFor503);
    paramParcel.writeInt(this.mapDownloadTimeout);
    paramParcel.writeInt(this.mapForceUpdate);
    paramParcel.writeLong(this.mapPreloadBeginTime);
    paramParcel.writeLong(this.mapTopRightEndTime);
    paramParcel.writeInt(this.mapPreLoadNetType);
    paramParcel.writeLong(this.preLoadGridMapBeginTime);
    paramParcel.writeLong(this.preLoadGridMapEndTime);
    paramParcel.writeString(this.starWebUrl);
    paramParcel.writeInt(this.starRightButtonShow);
    paramParcel.writeList(this.starInfos);
    paramParcel.writeString(this.shopScanTips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ARMapConfig
 * JD-Core Version:    0.7.0.1
 */