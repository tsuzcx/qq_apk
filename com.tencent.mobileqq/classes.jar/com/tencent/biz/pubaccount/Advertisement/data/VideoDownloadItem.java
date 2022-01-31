package com.tencent.biz.pubaccount.Advertisement.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.MsgCommonData;

public class VideoDownloadItem
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n;
  
  private VideoDownloadItem()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 5;
  }
  
  public VideoDownloadItem(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 5;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.optString("paUin", "");
      this.jdField_b_of_type_JavaLangString = paramString.optString("paName", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("adId", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("adPosId", "");
      this.jdField_a_of_type_Boolean = paramString.optBoolean("bannerShow", false);
      this.jdField_a_of_type_Int = paramString.optInt("bannertype", 0);
      this.jdField_b_of_type_Int = paramString.optInt("jumpType", 0);
      this.jdField_e_of_type_JavaLangString = paramString.optString("jumpUrl", "");
      this.f = paramString.optString("appId", "");
      this.g = paramString.optString("packagename", "");
      this.h = paramString.optString("androidDownloadUrl", "");
      this.i = paramString.optString("bannerImgUrl", "");
      this.j = paramString.optString("bannerText", "");
      this.k = paramString.optString("bannerButtonText", "");
      this.jdField_b_of_type_Boolean = paramString.optBoolean("silentDownload", false);
      this.l = paramString.optString("appName", "");
      this.m = paramString.optString("reportLink", "");
      this.jdField_c_of_type_Boolean = paramString.optBoolean("horizontalVideo", false);
      this.jdField_c_of_type_Int = paramString.optInt("audioFadeinDuration", 5);
      this.jdField_d_of_type_Int = paramString.optInt("audioSwitchType", 0);
      this.jdField_e_of_type_Int = paramString.optInt("preDownloadType", 0);
      this.jdField_e_of_type_Int = PAAdPreloadTask.checkNetworkType(this.jdField_e_of_type_Int);
      if ((!TextUtils.isEmpty(this.m)) && (!this.m.contains("https"))) {
        this.m = this.m.replace("http", "https");
      }
      if (QLog.isColorLevel()) {
        QLog.w("AdvertisementRecentUserManager", 2, "reportLink :" + this.m);
      }
      this.n = paramString.optString("str_openJumpUrlGuide", "");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static VideoDownloadItem a(submsgtype0xf9.MsgCommonData paramMsgCommonData, String paramString1, String paramString2)
  {
    VideoDownloadItem localVideoDownloadItem = new VideoDownloadItem();
    localVideoDownloadItem.jdField_a_of_type_JavaLangString = paramString1;
    localVideoDownloadItem.jdField_b_of_type_JavaLangString = paramString2;
    if (paramMsgCommonData.str_adId.has()) {
      localVideoDownloadItem.jdField_c_of_type_JavaLangString = paramMsgCommonData.str_adId.get();
    }
    if (paramMsgCommonData.str_adPosId.has()) {
      localVideoDownloadItem.jdField_d_of_type_JavaLangString = paramMsgCommonData.str_adPosId.get();
    }
    if (paramMsgCommonData.bool_bannerShow.has()) {
      localVideoDownloadItem.jdField_a_of_type_Boolean = paramMsgCommonData.bool_bannerShow.get();
    }
    if (paramMsgCommonData.uint32_bannertype.has()) {
      localVideoDownloadItem.jdField_a_of_type_Int = paramMsgCommonData.uint32_bannertype.get();
    }
    if (paramMsgCommonData.uint32_jumpType.has()) {
      localVideoDownloadItem.jdField_b_of_type_Int = paramMsgCommonData.uint32_jumpType.get();
    }
    if (paramMsgCommonData.str_jumpUrl.has()) {
      localVideoDownloadItem.jdField_e_of_type_JavaLangString = paramMsgCommonData.str_jumpUrl.get();
    }
    if (paramMsgCommonData.str_appId.has()) {
      localVideoDownloadItem.f = paramMsgCommonData.str_appId.get();
    }
    if (paramMsgCommonData.str_packagename.has()) {
      localVideoDownloadItem.g = paramMsgCommonData.str_packagename.get();
    }
    if (paramMsgCommonData.str_androidDownloadUrl.has()) {
      localVideoDownloadItem.h = paramMsgCommonData.str_androidDownloadUrl.get();
    }
    if (paramMsgCommonData.str_bannerImgUrl.has()) {
      localVideoDownloadItem.i = paramMsgCommonData.str_bannerImgUrl.get();
    }
    if (paramMsgCommonData.str_bannerText.has()) {
      localVideoDownloadItem.j = paramMsgCommonData.str_bannerText.get();
    }
    if (paramMsgCommonData.str_bannerButtonText.has()) {
      localVideoDownloadItem.k = paramMsgCommonData.str_bannerButtonText.get();
    }
    if (paramMsgCommonData.bool_silentDownload.has()) {
      localVideoDownloadItem.jdField_b_of_type_Boolean = paramMsgCommonData.bool_silentDownload.get();
    }
    if (paramMsgCommonData.str_appName.has()) {
      localVideoDownloadItem.l = paramMsgCommonData.str_appName.get();
    }
    if (paramMsgCommonData.str_reportLink.has())
    {
      localVideoDownloadItem.m = paramMsgCommonData.str_reportLink.get();
      if ((!TextUtils.isEmpty(localVideoDownloadItem.m)) && (!localVideoDownloadItem.m.contains("https"))) {
        localVideoDownloadItem.m = localVideoDownloadItem.m.replace("http", "https");
      }
    }
    if (paramMsgCommonData.bool_horizontalVideo.has()) {
      localVideoDownloadItem.jdField_c_of_type_Boolean = paramMsgCommonData.bool_horizontalVideo.get();
    }
    if (paramMsgCommonData.uint32_audioFadeinDuration.has()) {
      localVideoDownloadItem.jdField_c_of_type_Int = paramMsgCommonData.uint32_audioFadeinDuration.get();
    }
    if (paramMsgCommonData.uint32_audioSwitchType.has()) {
      localVideoDownloadItem.jdField_d_of_type_Int = paramMsgCommonData.uint32_audioSwitchType.get();
    }
    if (paramMsgCommonData.uint32_preDownloadType.has())
    {
      localVideoDownloadItem.jdField_e_of_type_Int = paramMsgCommonData.uint32_preDownloadType.get();
      localVideoDownloadItem.jdField_e_of_type_Int = PAAdPreloadTask.checkNetworkType(localVideoDownloadItem.jdField_e_of_type_Int);
    }
    if (paramMsgCommonData.str_openJumpUrlGuide.has()) {
      localVideoDownloadItem.n = paramMsgCommonData.str_openJumpUrlGuide.get();
    }
    return localVideoDownloadItem;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("paUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("paName", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("bannerShow", this.jdField_a_of_type_Boolean);
      localJSONObject.put("bannertype", this.jdField_a_of_type_Int);
      localJSONObject.put("jumpType", this.jdField_b_of_type_Int);
      localJSONObject.put("jumpUrl", this.jdField_e_of_type_JavaLangString);
      localJSONObject.put("appId", this.f);
      localJSONObject.put("packagename", this.g);
      localJSONObject.put("androidDownloadUrl", this.h);
      localJSONObject.put("bannerImgUrl", this.i);
      localJSONObject.put("bannerText", this.j);
      localJSONObject.put("bannerButtonText", this.k);
      localJSONObject.put("silentDownload", this.jdField_b_of_type_Boolean);
      localJSONObject.put("adId", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("adPosId", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("appName", this.l);
      localJSONObject.put("reportLink", this.m);
      localJSONObject.put("horizontalVideo", this.jdField_c_of_type_Boolean);
      localJSONObject.put("audioFadeinDuration", this.jdField_c_of_type_Int);
      localJSONObject.put("audioSwitchType", this.jdField_d_of_type_Int);
      localJSONObject.put("preDownloadType", this.jdField_e_of_type_Int);
      localJSONObject.put("str_openJumpUrlGuide", this.n);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("====mTrueUin " + this.jdField_a_of_type_JavaLangString + "\n").append("====mNickName " + this.jdField_b_of_type_JavaLangString + "\n").append("====adId " + this.jdField_c_of_type_JavaLangString + "\n").append("====adPosId " + this.jdField_d_of_type_JavaLangString + "\n").append("====bannerShow " + this.jdField_a_of_type_Boolean + "\n").append("====bannertype " + this.jdField_a_of_type_Int + "\n").append("====jumpType " + this.jdField_b_of_type_Int + "\n").append("====jumpUrl " + this.jdField_e_of_type_JavaLangString + "\n").append("====appId " + this.f + "\n").append("====packagename " + this.g + "\n").append("====downloadUrl " + this.h + "\n").append("====bannerImgUrl " + this.i + "\n").append("====bannerText " + this.j + "\n").append("====bannerButtonText " + this.k + "\n").append("====silentDownload " + this.jdField_b_of_type_Boolean + "\n").append("====appName " + this.l + "\n").append("====reportLink " + this.m + "\n").append("====audioFadeinDuration " + this.jdField_c_of_type_Int).append("====horizontalVideo " + this.jdField_c_of_type_Boolean).append("====audioMode " + this.jdField_d_of_type_Int).append("====openJumpUrlGuide " + this.n).append("====downloadType " + this.jdField_e_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem
 * JD-Core Version:    0.7.0.1
 */