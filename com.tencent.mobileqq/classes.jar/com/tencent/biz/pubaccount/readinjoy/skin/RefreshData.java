package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pzz;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;

public class RefreshData
  extends SkinData
{
  public List<pzz> adClickReports;
  public List<pzz> adExposureReports;
  public Long adId;
  public boolean isAD;
  public boolean isShown = true;
  public boolean showInFeeds;
  public boolean showInFollow;
  
  public RefreshData(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramLong, paramInt1, paramInt2);
    this.isShown = paramBoolean;
  }
  
  public RefreshData(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.isShown = paramJSONObject.optBoolean("isShown", true);
    this.showInFeeds = paramJSONObject.optBoolean("showInFeeds", false);
    this.showInFollow = paramJSONObject.optBoolean("showInFollow", false);
    this.isAD = paramJSONObject.optBoolean("isAd", false);
    this.adId = Long.valueOf(paramJSONObject.optLong("adId", 0L));
    Object localObject1 = paramJSONObject.optJSONArray("adClickReports");
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      this.adClickReports = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 != null)
        {
          pzz localpzz = new pzz();
          localpzz.a = ((JSONObject)localObject2).optString("reportUrl", "");
          this.adClickReports.add(localpzz);
        }
        i += 1;
      }
    }
    paramJSONObject = paramJSONObject.optJSONArray("adExposureReports");
    if (paramJSONObject != null)
    {
      this.adExposureReports = new ArrayList();
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject1 = paramJSONObject.optJSONObject(i);
        if (localObject1 != null)
        {
          localObject2 = new pzz();
          ((pzz)localObject2).a = ((JSONObject)localObject1).optString("reportUrl", "");
          this.adExposureReports.add(localObject2);
        }
        i += 1;
      }
    }
  }
  
  public RefreshData(oidb_0x5bd.RefreshInfo paramRefreshInfo)
  {
    this.id = paramRefreshInfo.bytes_id.get().toStringUtf8();
    this.url = paramRefreshInfo.bytes_url.get().toStringUtf8();
    this.seq = paramRefreshInfo.uint64_seq.get();
    this.beginTime = paramRefreshInfo.uint32_begin_timestamp.get();
    this.endTime = paramRefreshInfo.uint32_end_timestamp.get();
    this.isShown = true;
    if (paramRefreshInfo.uint32_is_ad.get() == 1) {}
    Object localObject;
    for (;;)
    {
      this.isAD = bool;
      this.adId = Long.valueOf(paramRefreshInfo.uint64_ad_id.get());
      localObject = paramRefreshInfo.msg_ad_click_report.get();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      this.adClickReports = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        oidb_0x5bd.AdReport localAdReport = (oidb_0x5bd.AdReport)((Iterator)localObject).next();
        this.adClickReports.add(pzz.a(localAdReport));
      }
      bool = false;
    }
    paramRefreshInfo = paramRefreshInfo.msg_ad_exposure_report.get();
    if ((paramRefreshInfo != null) && (paramRefreshInfo.size() > 0))
    {
      this.adExposureReports = new ArrayList();
      paramRefreshInfo = paramRefreshInfo.iterator();
      while (paramRefreshInfo.hasNext())
      {
        localObject = (oidb_0x5bd.AdReport)paramRefreshInfo.next();
        this.adExposureReports.add(pzz.a((oidb_0x5bd.AdReport)localObject));
      }
    }
  }
  
  public List<String> getUrls(List<pzz> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((pzz)paramList.next()).a);
    }
    return localArrayList;
  }
  
  public boolean isShowInSource(int paramInt)
  {
    if (paramInt == 0) {
      return this.showInFeeds;
    }
    if (paramInt == 1) {
      return this.showInFollow;
    }
    return false;
  }
  
  public void setShowInSource(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0) {
      this.showInFeeds = paramBoolean;
    }
    while (paramInt != 1) {
      return;
    }
    this.showInFollow = paramBoolean;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject1 = super.toJson();
    try
    {
      localJSONObject1.put("isShown", this.isShown);
      localJSONObject1.put("showInFollow", this.showInFollow);
      localJSONObject1.put("showInFeeds", this.showInFeeds);
      localJSONObject1.put("isAd", this.isAD);
      localJSONObject1.put("adId", this.adId);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      JSONObject localJSONObject2;
      while ((this.adClickReports != null) && (i < this.adClickReports.size()))
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("reportUrl", ((pzz)this.adClickReports.get(i)).a);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("adClickReports", localJSONArray);
      localJSONArray = new JSONArray();
      i = 0;
      while ((this.adExposureReports != null) && (i < this.adExposureReports.size()))
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("reportUrl", ((pzz)this.adExposureReports.get(i)).a);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("adExposureReports", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("RefreshData", 2, localJSONException, new Object[0]);
    }
    return localJSONObject1;
    return localJSONObject1;
  }
  
  public oidb_0x5bd.RefreshInfo toRefreshInfoBody()
  {
    oidb_0x5bd.RefreshInfo localRefreshInfo = new oidb_0x5bd.RefreshInfo();
    localRefreshInfo.bytes_id.set(ByteStringMicro.copyFromUtf8(this.id), true);
    localRefreshInfo.bytes_url.set(ByteStringMicro.copyFromUtf8(this.url), true);
    localRefreshInfo.uint64_seq.set(this.seq, true);
    localRefreshInfo.uint32_begin_timestamp.set(this.beginTime, true);
    localRefreshInfo.uint32_end_timestamp.set(this.endTime, true);
    return localRefreshInfo;
  }
  
  public String toString()
  {
    return super.toString() + " isShown = " + this.isShown;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.RefreshData
 * JD-Core Version:    0.7.0.1
 */