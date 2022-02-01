package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class PublicAccountDetailReportUtilImpl
  implements IPublicAccountDetailReportUtil
{
  public static final String TAG = "PADetailReportUtil";
  public static final String Version = "1.0";
  static ByteBuffer buffer = ByteBuffer.allocate(8);
  int curPage = 1;
  long curTime;
  int entranceID;
  int isDirectClick;
  String itemID;
  String itemList;
  int itemPos;
  int pageNum;
  String search;
  String searchID;
  int startPos;
  int superViewID;
  int thisViewID;
  int version;
  
  public void backPage()
  {
    this.curPage = 0;
  }
  
  public String buildSearchID(String paramString1, String paramString2)
  {
    try
    {
      if ((!this.search.equals(paramString2)) || (this.searchID == null))
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(String.valueOf(System.currentTimeMillis()));
        paramString2.append(Math.random());
        paramString1 = MD5.toMD5Byte(paramString2.toString());
        buffer.put(paramString1, 0, 8);
        buffer.flip();
        this.curPage = 0;
        long l = buffer.getLong();
        return String.valueOf(l);
      }
    }
    catch (Exception paramString1)
    {
      label94:
      break label94;
    }
    return null;
  }
  
  public void doReport(String paramString, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, paramString, true, 0L, 0L, paramHashMap, null);
  }
  
  public void resetAttribute()
  {
    this.searchID = null;
    this.search = null;
    this.superViewID = 0;
    this.thisViewID = 0;
    this.pageNum = 0;
    this.startPos = 0;
  }
  
  public void setAttrEntrance(int paramInt)
  {
    resetAttribute();
    long l = System.currentTimeMillis();
    Object localObject = new HashMap();
    ((HashMap)localObject).put("sVer", "1.0");
    ((HashMap)localObject).put("sScene", String.valueOf(paramInt));
    ((HashMap)localObject).put("sCurTime", String.valueOf(l));
    doReport("actSearchExposure", (HashMap)localObject);
    this.thisViewID = paramInt;
    this.entranceID = paramInt;
    this.curPage = 0;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start report entrance event cur view:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", time:");
      ((StringBuilder)localObject).append(l);
      QLog.d("PADetailReportUtil", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setAttrSearchAttention(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.searchID);
    localHashMap.put("sKey", this.search);
    localHashMap.put("sCurTime", String.valueOf(l));
    localHashMap.put("sPScene", String.valueOf(this.thisViewID));
    localHashMap.put("sScene", String.valueOf(this.entranceID + paramInt1));
    localHashMap.put("sDirect", String.valueOf(paramInt2));
    localHashMap.put("sItem", paramString);
    if (paramInt3 == 12) {
      localHashMap.put("sFolder", "1");
    } else {
      localHashMap.put("sFolder", "0");
    }
    if (paramBoolean) {
      localHashMap.put("sFrom", "1");
    } else {
      localHashMap.put("sFrom", "0");
    }
    doReport("actSearchSubscribe", localHashMap);
    this.superViewID = this.thisViewID;
    this.thisViewID = (paramInt1 + this.entranceID);
    this.itemID = paramString;
    this.isDirectClick = paramInt2;
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("start report attention event searchID:");
      paramString.append(this.searchID);
      paramString.append(", superview:");
      paramString.append(this.superViewID);
      paramString.append(", thisview:");
      paramString.append(this.thisViewID);
      paramString.append(", itemID:");
      paramString.append(this.itemID);
      paramString.append(", isDirectClick:");
      paramString.append(this.isDirectClick);
      paramString.append(", time");
      paramString.append(l);
      paramString.append(", from:");
      paramString.append(paramInt3);
      paramString.append(", isoffline:");
      paramString.append(paramBoolean);
      QLog.d("PADetailReportUtil", 4, paramString.toString());
    }
  }
  
  public void setAttrSearchClick(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.searchID);
    localHashMap.put("sKey", this.search);
    localHashMap.put("sCurTime", String.valueOf(l));
    localHashMap.put("sItem", paramString);
    localHashMap.put("sPScene", String.valueOf(this.thisViewID));
    localHashMap.put("sScene", String.valueOf(this.entranceID + paramInt1));
    localHashMap.put("sItemPos", String.valueOf(paramInt2));
    if (paramInt3 == 12) {
      localHashMap.put("sFolder", "1");
    } else {
      localHashMap.put("sFolder", "0");
    }
    doReport("actSearchNetClick", localHashMap);
    this.superViewID = this.thisViewID;
    this.thisViewID = (paramInt1 + this.entranceID);
    this.itemPos = paramInt2;
    this.itemID = paramString;
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("start report click event searchID:");
      paramString.append(this.searchID);
      paramString.append(", superview:");
      paramString.append(this.superViewID);
      paramString.append(", thisview:");
      paramString.append(this.thisViewID);
      paramString.append(", itemPos:");
      paramString.append(this.itemPos);
      paramString.append(", time:");
      paramString.append(l);
      paramString.append(", itemID:");
      paramString.append(this.itemID);
      paramString.append(", from:");
      paramString.append(paramInt3);
      QLog.d("PADetailReportUtil", 4, paramString.toString());
    }
  }
  
  public void setAttrSearchPage(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    if (paramInt1 == 3)
    {
      this.curPage += 1;
      this.startPos = ((this.curPage - 1) * paramInt2);
    }
    else
    {
      this.curPage = 0;
    }
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    if (paramString1 != null) {
      localHashMap.put("sSearch", paramString1);
    } else {
      localHashMap.put("sSearch", this.searchID);
    }
    localHashMap.put("sCurTime", String.valueOf(l));
    localHashMap.put("sKey", paramString2);
    localHashMap.put("sPScene", String.valueOf(this.thisViewID));
    localHashMap.put("sScene", String.valueOf(this.entranceID + paramInt1));
    int i = this.curPage;
    if (i != 0)
    {
      localHashMap.put("sItemListPage", String.valueOf(i));
      localHashMap.put("sItemListStart", String.valueOf(paramInt2 * (this.curPage - 1)));
    }
    else
    {
      localHashMap.put("sItemListPage", "1");
      localHashMap.put("sItemListStart", "0");
    }
    localHashMap.put("sItemlist", paramString3);
    doReport("actSearchNet", localHashMap);
    this.superViewID = this.thisViewID;
    this.thisViewID = (paramInt1 + this.entranceID);
    if (paramString1 != null) {
      this.searchID = paramString1;
    }
    this.search = paramString2;
    this.pageNum = this.curPage;
    this.itemList = paramString3;
    if (QLog.isDevelopLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("start report searchpage searchID:");
      paramString1.append(this.searchID);
      paramString1.append(" superview:");
      paramString1.append(this.superViewID);
      paramString1.append(", thisview:");
      paramString1.append(this.thisViewID);
      paramString1.append(", search:");
      paramString1.append(this.search);
      QLog.d("PADetailReportUtil", 4, paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append("pagenum:");
      paramString1.append(this.pageNum);
      paramString1.append(", startPos:");
      paramString1.append(this.startPos);
      paramString1.append(", itemList:");
      paramString1.append(this.itemList);
      paramString1.append(", time:");
      paramString1.append(l);
      QLog.d("PADetailReportUtil", 4, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountDetailReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */