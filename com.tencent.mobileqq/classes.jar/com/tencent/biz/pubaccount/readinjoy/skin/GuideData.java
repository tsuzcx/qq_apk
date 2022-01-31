package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id,uin,business")
public class GuideData
  extends BaseResData<oidb_0x5bd.GuideInfo>
{
  public int guideType;
  public SkinData skinData;
  public int source;
  
  public GuideData()
  {
    this.uin = (BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() + "");
  }
  
  public GuideData(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, int paramInt3, SkinData paramSkinData)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.url = paramString3;
    this.seq = paramLong;
    this.beginTime = paramInt1;
    this.endTime = paramInt2;
    this.guideType = paramInt3;
    this.skinData = paramSkinData;
  }
  
  public GuideData(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.id = paramJSONObject.optString("id");
    this.name = paramJSONObject.optString("name");
    this.url = paramJSONObject.optString("url");
    this.seq = paramJSONObject.optLong("seq");
    this.beginTime = paramJSONObject.optInt("beginTime");
    this.endTime = paramJSONObject.optInt("endTime");
    this.guideType = paramJSONObject.optInt("guideType");
    this.source = paramJSONObject.optInt("source");
    this.skinData = new SkinData(paramJSONObject.optJSONObject("skinInfo"));
  }
  
  public GuideData(oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt)
  {
    super(paramGuideInfo);
    this.id = paramGuideInfo.bytes_id.get().toStringUtf8();
    this.name = paramGuideInfo.bytes_name.get().toStringUtf8();
    this.url = paramGuideInfo.bytes_url.get().toStringUtf8();
    this.seq = paramGuideInfo.uint64_seq.get();
    this.beginTime = paramGuideInfo.uint32_begin_timestamp.get();
    this.endTime = paramGuideInfo.uint32_end_timestamp.get();
    this.guideType = paramGuideInfo.uint32_guide_type.get();
    this.skinData = new SkinData((oidb_0x5bd.SkinInfo)paramGuideInfo.msg_skin_info.get());
    this.source = paramInt;
  }
  
  public void postRead()
  {
    super.postRead();
    if (this.resData != null) {}
    try
    {
      JSONObject localJSONObject1 = new JSONObject(new String(this.resData));
      this.guideType = localJSONObject1.optInt("guideType");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("skinInfo");
      this.source = localJSONObject1.optInt("source");
      this.skinData = new SkinData(localJSONObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    try
    {
      if (this.resData == null) {}
      for (JSONObject localJSONObject = new JSONObject();; localJSONObject = new JSONObject(new String(this.resData)))
      {
        localJSONObject.put("guideType", this.guideType);
        localJSONObject.put("skinInfo", this.skinData.toJson());
        localJSONObject.put("source", this.source);
        this.resData = localJSONObject.toString().getBytes();
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public oidb_0x5bd.GuideInfo toBody()
  {
    oidb_0x5bd.GuideInfo localGuideInfo = new oidb_0x5bd.GuideInfo();
    localGuideInfo.bytes_id.set(ByteStringMicro.copyFromUtf8(this.id), true);
    localGuideInfo.bytes_name.set(ByteStringMicro.copyFromUtf8(this.name), true);
    localGuideInfo.bytes_url.set(ByteStringMicro.copyFromUtf8(this.url), true);
    localGuideInfo.uint64_seq.set(this.seq, true);
    localGuideInfo.uint32_begin_timestamp.set(this.beginTime, true);
    localGuideInfo.uint32_end_timestamp.set(this.endTime, true);
    localGuideInfo.uint32_guide_type.set(this.guideType, true);
    localGuideInfo.msg_skin_info.set(this.skinData.toBody());
    return localGuideInfo;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.id);
      localJSONObject.put("name", this.name);
      localJSONObject.put("url", this.url);
      localJSONObject.put("seq", this.seq);
      localJSONObject.put("beginTime", this.beginTime);
      localJSONObject.put("endTime", this.endTime);
      localJSONObject.put("guideType", this.guideType);
      localJSONObject.put("skinInfo", this.skinData.toJson());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return super.toString() + "GuideData{beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", guideType=" + this.guideType + ", source=" + this.source + ", skinData=" + this.skinData + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.GuideData
 * JD-Core Version:    0.7.0.1
 */