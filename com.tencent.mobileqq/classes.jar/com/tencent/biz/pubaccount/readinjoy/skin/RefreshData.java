package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;

public class RefreshData
  extends SkinData
{
  public boolean isShown = true;
  
  public RefreshData(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramLong, paramInt1, paramInt2);
    this.isShown = paramBoolean;
  }
  
  public RefreshData(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.isShown = paramJSONObject.optBoolean("isShown", true);
  }
  
  public RefreshData(oidb_0x5bd.RefreshInfo paramRefreshInfo)
  {
    this.id = paramRefreshInfo.bytes_id.get().toStringUtf8();
    this.url = paramRefreshInfo.bytes_url.get().toStringUtf8();
    this.seq = paramRefreshInfo.uint64_seq.get();
    this.beginTime = paramRefreshInfo.uint32_begin_timestamp.get();
    this.endTime = paramRefreshInfo.uint32_end_timestamp.get();
    this.isShown = true;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = super.toJson();
    try
    {
      localJSONObject.put("isShown", this.isShown);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("RefreshData", 2, localJSONException, new Object[0]);
    }
    return localJSONObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.RefreshData
 * JD-Core Version:    0.7.0.1
 */