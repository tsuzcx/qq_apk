package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;
import tpy;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class MaterialData
  extends BaseResData<oidb_0x885.RspBody>
{
  public String ad_material;
  public String ad_source;
  public int ad_type;
  public String adid;
  public int delivery_effect;
  public long end_time;
  public String res_md5;
  public String res_path;
  public int res_version;
  public long start_time;
  public String sub_adid;
  
  public MaterialData() {}
  
  public MaterialData(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.start_time = paramJSONObject.optLong("start_time");
    this.sub_adid = paramJSONObject.optString("sub_adid");
    this.ad_type = paramJSONObject.optInt("ad_type");
    this.res_version = paramJSONObject.optInt("res_version");
    this.end_time = paramJSONObject.optLong("end_time");
    this.res_md5 = paramJSONObject.optString("res_md5");
    this.adid = paramJSONObject.optString("adid");
    this.ad_source = paramJSONObject.optString("ad_source");
    this.ad_material = paramJSONObject.optString("ad_material");
    this.delivery_effect = paramJSONObject.optInt("delivery_effect");
    this.id = (this.ad_source + "_" + this.adid);
    this.url = paramJSONObject.optString("res_url");
    tpy.a("super_mask_ad_preference", BaseApplicationImpl.getContext(), this.id, paramJSONObject.optInt("enable_4g", 0) + "");
  }
  
  public oidb_0x885.RspBody toBody()
  {
    return null;
  }
  
  @NotNull
  public String toString()
  {
    return "MaterialData{start_time=" + this.start_time + ", sub_adid='" + this.sub_adid + '\'' + ", ad_type=" + this.ad_type + ", res_version=" + this.res_version + ", end_time=" + this.end_time + ", res_md5='" + this.res_md5 + '\'' + ", adid='" + this.adid + '\'' + ", res_path='" + this.res_path + '\'' + ", ad_source='" + this.ad_source + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData
 * JD-Core Version:    0.7.0.1
 */