package com.tencent.av.so;

import android.content.SharedPreferences;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import ksi;
import ksj;
import org.json.JSONObject;

public class DownloadInfo
  extends ConfigInfo
{
  static final String spKey_model_zip_md5 = "model_zip_md5";
  static final String spKey_so_zip_md5 = "so_zip_md5";
  public static final String spName = "config_qq.android.qavso";
  public String MD5_model_wxvoiceembed;
  public String MD5_so_wxvoiceembedqqegg;
  public String MD5_zip_model;
  public String MD5_zip_so;
  public boolean enable;
  public String filename_model_wxvoiceembed;
  public String filename_so_wxvoiceembedqqegg;
  public boolean is_auto_download = true;
  public int thre;
  public String url_zip_model;
  public String url_zip_so;
  
  public static DownloadInfo get()
  {
    String str = ksj.b(367).a;
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.tryParse("QavSo", str);
    return localDownloadInfo;
  }
  
  public static SharedPreferences getSP()
  {
    return EffectConfigBase.a(367, EffectConfigBase.d);
  }
  
  public boolean parse(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("enable")) {
        this.enable = paramJSONObject.getBoolean("enable");
      }
      if (paramJSONObject.has("url_zip_so")) {
        this.url_zip_so = paramJSONObject.getString("url_zip_so");
      }
      if (paramJSONObject.has("MD5_zip_so")) {
        this.MD5_zip_so = paramJSONObject.getString("MD5_zip_so");
      }
      if (paramJSONObject.has("url_zip_model")) {
        this.url_zip_model = paramJSONObject.getString("url_zip_model");
      }
      if (paramJSONObject.has("MD5_zip_model")) {
        this.MD5_zip_model = paramJSONObject.getString("MD5_zip_model");
      }
      if (paramJSONObject.has("MD5_so_wxvoiceembedqqegg")) {
        this.MD5_so_wxvoiceembedqqegg = paramJSONObject.getString("MD5_so_wxvoiceembedqqegg");
      }
      if (paramJSONObject.has("MD5_model_wxvoiceembed")) {
        this.MD5_model_wxvoiceembed = paramJSONObject.getString("MD5_model_wxvoiceembed");
      }
      if (paramJSONObject.has("filename_so_wxvoiceembedqqegg")) {
        this.filename_so_wxvoiceembedqqegg = paramJSONObject.getString("filename_so_wxvoiceembedqqegg");
      }
      if (paramJSONObject.has("filename_model_wxvoiceembed")) {
        this.filename_model_wxvoiceembed = paramJSONObject.getString("filename_model_wxvoiceembed");
      }
      if (paramJSONObject.has("is_auto_download")) {
        this.is_auto_download = paramJSONObject.getBoolean("is_auto_download");
      }
      if (paramJSONObject.has("thre")) {
        this.thre = paramJSONObject.getInt("thre");
      }
      return true;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("QavSo", 1, String.format("parseJson, Exception\n%s", new Object[] { paramJSONObject }));
    }
    return false;
  }
  
  public String toString()
  {
    return String.format("task_id[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], url_zip_model[%s], MD5_zip_model[%s], MD5_so_wxvoiceembedqqegg[%s], MD5_model_wxvoiceembed[%s], filename_so_wxvoiceembedqqegg[%s], filename_model_wxvoiceembed[%s], is_auto_download[%s], thre[%s]", new Object[] { Integer.valueOf(this.task_id), Boolean.valueOf(this.enable), this.url_zip_so, this.MD5_zip_so, this.url_zip_model, this.MD5_zip_model, this.MD5_so_wxvoiceembedqqegg, this.MD5_model_wxvoiceembed, this.filename_so_wxvoiceembedqqegg, this.filename_model_wxvoiceembed, Boolean.valueOf(this.is_auto_download), Integer.valueOf(this.thre) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.so.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */