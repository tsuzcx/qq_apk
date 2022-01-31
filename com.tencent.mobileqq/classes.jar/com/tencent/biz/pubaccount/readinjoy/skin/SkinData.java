package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class SkinData
  extends BaseResData<oidb_0x5bd.SkinInfo>
{
  public SkinData() {}
  
  public SkinData(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    this.id = paramString1;
    this.url = paramString2;
    this.seq = paramLong;
    this.beginTime = paramInt1;
    this.endTime = paramInt2;
  }
  
  public SkinData(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optString("id");
    this.url = paramJSONObject.optString("url");
    this.seq = paramJSONObject.optLong("seq");
    this.beginTime = paramJSONObject.optInt("beginTime");
    this.endTime = paramJSONObject.optInt("endTime");
  }
  
  public SkinData(oidb_0x5bd.SkinInfo paramSkinInfo)
  {
    super(paramSkinInfo);
    this.id = paramSkinInfo.bytes_id.get().toStringUtf8();
    this.url = paramSkinInfo.bytes_url.get().toStringUtf8();
    this.seq = paramSkinInfo.uint64_seq.get();
    this.beginTime = paramSkinInfo.uint32_begin_timestamp.get();
    this.endTime = paramSkinInfo.uint32_end_timestamp.get();
  }
  
  public oidb_0x5bd.SkinInfo toBody()
  {
    oidb_0x5bd.SkinInfo localSkinInfo = new oidb_0x5bd.SkinInfo();
    localSkinInfo.bytes_id.set(ByteStringMicro.copyFromUtf8(this.id), true);
    localSkinInfo.bytes_url.set(ByteStringMicro.copyFromUtf8(this.url), true);
    localSkinInfo.uint64_seq.set(this.seq, true);
    localSkinInfo.uint32_begin_timestamp.set(this.beginTime, true);
    localSkinInfo.uint32_end_timestamp.set(this.endTime, true);
    return localSkinInfo;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.id);
      localJSONObject.put("url", this.url);
      localJSONObject.put("seq", this.seq);
      localJSONObject.put("beginTime", this.beginTime);
      localJSONObject.put("endTime", this.endTime);
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
    return String.format("{id = %s, url = %s, seq = %d, beginTime = %d, endTime = %d}", new Object[] { this.id, this.url, Long.valueOf(this.seq), Integer.valueOf(this.beginTime), Integer.valueOf(this.endTime) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.SkinData
 * JD-Core Version:    0.7.0.1
 */