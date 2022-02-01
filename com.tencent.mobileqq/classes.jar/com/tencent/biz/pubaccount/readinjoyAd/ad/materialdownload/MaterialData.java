package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class MaterialData
  extends BaseResData<oidb_0x885.RspBody>
{
  public String ad_material;
  public String ad_source;
  public int ad_type;
  public String adid;
  public String animFileName;
  public int bid_mask;
  public int delivery_effect;
  public int enable_4g = 0;
  public long end_time;
  public int normal_mask;
  public String res_md5;
  public String res_path;
  public int res_version;
  public long start_time;
  public String sub_adid;
  public int superMaskType;
  
  public MaterialData() {}
  
  public MaterialData(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.start_time = paramJSONObject.optLong("start_time", NetConnInfoCenter.getServerTime());
    this.sub_adid = paramJSONObject.optString("sub_adid");
    this.ad_type = paramJSONObject.optInt("ad_type");
    this.res_version = paramJSONObject.optInt("res_version");
    this.end_time = paramJSONObject.optLong("end_time");
    this.res_md5 = paramJSONObject.optString("res_md5");
    this.adid = paramJSONObject.optString("adid");
    this.ad_source = paramJSONObject.optString("ad_source");
    this.ad_material = paramJSONObject.optString("ad_material");
    this.delivery_effect = paramJSONObject.optInt("delivery_effect");
    this.enable_4g = paramJSONObject.optInt("enable_4g");
    this.animFileName = paramJSONObject.optString("animFileName");
    this.superMaskType = paramJSONObject.optInt("superMaskType");
    this.normal_mask = paramJSONObject.optInt("normal_mask");
    this.bid_mask = paramJSONObject.optInt("bid_mask");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ad_source);
    localStringBuilder.append("_");
    localStringBuilder.append(this.adid);
    this.id = localStringBuilder.toString();
    this.url = paramJSONObject.optString("res_url");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (MaterialData)paramObject;
      return this.id.equals(paramObject.id);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.id });
  }
  
  public oidb_0x885.RspBody toBody()
  {
    return null;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("start_time", this.start_time);
      localJSONObject.put("sub_adid", this.sub_adid);
      localJSONObject.put("ad_type", this.ad_type);
      localJSONObject.put("res_version", this.res_version);
      localJSONObject.put("end_time", this.end_time);
      localJSONObject.put("res_md5", this.res_md5);
      localJSONObject.put("res_path", this.res_path);
      localJSONObject.put("adid", this.adid);
      localJSONObject.put("ad_source", this.ad_source);
      localJSONObject.put("ad_material", this.ad_material);
      localJSONObject.put("delivery_effect", this.delivery_effect);
      localJSONObject.put("enable_4g", this.enable_4g);
      localJSONObject.put("id", this.id);
      localJSONObject.put("url", this.url);
      localJSONObject.put("animFileName", this.animFileName);
      localJSONObject.put("superMaskType", this.superMaskType);
      localJSONObject.put("normal_mask", this.normal_mask);
      localJSONObject.put("bid_mask", this.bid_mask);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MaterialData{start_time=");
    localStringBuilder.append(this.start_time);
    localStringBuilder.append(", sub_adid='");
    localStringBuilder.append(this.sub_adid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ad_type=");
    localStringBuilder.append(this.ad_type);
    localStringBuilder.append(", res_version=");
    localStringBuilder.append(this.res_version);
    localStringBuilder.append(", end_time=");
    localStringBuilder.append(this.end_time);
    localStringBuilder.append(", res_md5='");
    localStringBuilder.append(this.res_md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adid='");
    localStringBuilder.append(this.adid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", res_path='");
    localStringBuilder.append(this.res_path);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ad_source='");
    localStringBuilder.append(this.ad_source);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enable_4g='");
    localStringBuilder.append(this.enable_4g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData
 * JD-Core Version:    0.7.0.1
 */