package com.tencent.mobileqq.activity.springfestival.entry.model;

import java.io.Serializable;
import org.json.JSONObject;

public class HtmlOfflineCheckConfig
  implements Serializable
{
  public static final String TAG = "shua2021_HtmlOfflineCheckConfig";
  public String bids;
  public String checkDomain;
  public String net_type;
  public int time_interval;
  public int total_cnt;
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.bids = paramJSONObject.optString("bids", "");
    this.time_interval = paramJSONObject.optInt("time_interval", 24);
    this.total_cnt = paramJSONObject.optInt("total_cnt", 3);
    this.net_type = paramJSONObject.optString("net_type", "0");
    this.checkDomain = paramJSONObject.optString("check_domain", "");
  }
  
  public String toString()
  {
    return "HtmlOfflineCheckConfig{bids='" + this.bids + '\'' + ", time_interval=" + this.time_interval + ", total_cnt=" + this.total_cnt + ", net_type='" + this.net_type + '\'' + ", checkDomain='" + this.checkDomain + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.HtmlOfflineCheckConfig
 * JD-Core Version:    0.7.0.1
 */