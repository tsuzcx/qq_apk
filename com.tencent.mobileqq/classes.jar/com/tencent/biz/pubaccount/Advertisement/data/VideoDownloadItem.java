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
  public int A;
  public int B;
  public int C;
  public int D;
  public boolean E;
  public int F;
  public String G;
  public int H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String a;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 5;
  public boolean g = false;
  public int h;
  public boolean i;
  public int j;
  public String k = "";
  public String l = "";
  public String m = "";
  public int n;
  public String o = "";
  public String p;
  public String q = "";
  public String r = "";
  public String s = "";
  public boolean t;
  public int u;
  public String v = "";
  public String w;
  public String x;
  public int y;
  public String z;
  
  private VideoDownloadItem() {}
  
  public VideoDownloadItem(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.a = paramString.optString("paUin", "");
        this.b = paramString.optString("paName", "");
        this.c = paramString.optString("adId", "");
        this.d = paramString.optString("adPosId", "");
        this.i = paramString.optBoolean("bannerShow", false);
        this.j = paramString.optInt("bannertype", 0);
        this.n = paramString.optInt("jumpType", 0);
        this.v = paramString.optString("jumpUrl", "");
        this.q = paramString.optString("appId", "");
        this.r = paramString.optString("packagename", "");
        this.o = paramString.optString("androidDownloadUrl", "");
        this.k = paramString.optString("bannerImgUrl", "");
        this.l = paramString.optString("bannerText", "");
        this.m = paramString.optString("bannerButtonText", "");
        this.t = paramString.optBoolean("silentDownload", false);
        this.s = paramString.optString("appName", "");
        this.e = paramString.optString("reportLink", "");
        this.g = paramString.optBoolean("horizontalVideo", false);
        this.f = paramString.optInt("audioFadeinDuration", 5);
        this.h = paramString.optInt("audioSwitchType", 0);
        this.u = paramString.optInt("preDownloadType", 0);
        this.u = PAAdPreloadTask.checkNetworkType(this.u);
        if ((!TextUtils.isEmpty(this.e)) && (!this.e.contains("https"))) {
          this.e = this.e.replace("http", "https");
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportLink :");
          localStringBuilder.append(this.e);
          QLog.w("VideoDownloadItem", 2, localStringBuilder.toString());
        }
        this.w = paramString.optString("str_openJumpUrlGuide", "");
        this.p = paramString.optString("str_myappDownloadUrl", "");
        this.x = paramString.optString("jumpTypeParams");
        this.B = paramString.optInt("canScorll");
        int i1 = this.B;
        bool = true;
        if (i1 == 1)
        {
          this.E = bool;
          this.C = paramString.optInt("controlVariable");
          this.D = paramString.optInt("uint32_control_plugin_time");
          this.F = paramString.optInt("uint32_autoJump");
          this.A = paramString.optInt("dDCategoryId", -1);
          this.z = paramString.optString("dDCategoryName", "");
          this.y = paramString.optInt("dDItemID", -1);
          this.G = paramString.optString("str_clickLink", "");
          this.H = paramString.optInt("uint32_monitorType", 0);
          this.I = paramString.getString("str_share_nick");
          this.J = paramString.getString("str_share_ad_head_url");
          this.K = paramString.getString("str_share_ad_brief");
          this.L = paramString.getString("str_share_ad_txt");
          this.M = paramString.getString("str_share_ad_icon_url");
          this.N = paramString.getString("str_share_jump_url");
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public static VideoDownloadItem a(String paramString1, String paramString2, String paramString3)
  {
    VideoDownloadItem localVideoDownloadItem = new VideoDownloadItem();
    localVideoDownloadItem.a = paramString2;
    localVideoDownloadItem.b = paramString3;
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        localVideoDownloadItem.c = paramString1.optString("str_adId", "");
        localVideoDownloadItem.d = paramString1.optString("str_adPosId", "");
        localVideoDownloadItem.i = paramString1.optBoolean("bool_bannerShow", false);
        localVideoDownloadItem.j = paramString1.optInt("uint32_bannertype", 0);
        localVideoDownloadItem.n = paramString1.optInt("uint32_jumpType", 0);
        localVideoDownloadItem.v = paramString1.optString("str_jumpUrl", "");
        localVideoDownloadItem.q = paramString1.optString("str_appId", "");
        localVideoDownloadItem.r = paramString1.optString("str_packagename", "");
        localVideoDownloadItem.o = paramString1.optString("str_androidDownloadUrl", "");
        localVideoDownloadItem.k = paramString1.optString("str_bannerImgUrl", "");
        localVideoDownloadItem.l = paramString1.optString("str_bannerText", "");
        localVideoDownloadItem.m = paramString1.optString("str_bannerButtonText", "");
        localVideoDownloadItem.t = paramString1.optBoolean("bool_silentDownload", false);
        localVideoDownloadItem.s = paramString1.optString("str_appName", "");
        localVideoDownloadItem.e = paramString1.optString("str_reportLink", "");
        if ((!TextUtils.isEmpty(localVideoDownloadItem.e)) && (!localVideoDownloadItem.e.contains("https"))) {
          localVideoDownloadItem.e = localVideoDownloadItem.e.replace("http", "https");
        }
        localVideoDownloadItem.g = paramString1.optBoolean("bool_horizontalVideo", false);
        localVideoDownloadItem.f = paramString1.optInt("uint32_audioFadeinDuration", 5);
        localVideoDownloadItem.h = paramString1.optInt("uint32_audioSwitchType", 0);
        localVideoDownloadItem.u = paramString1.optInt("uint32_preDownloadType", 0);
        localVideoDownloadItem.u = PAAdPreloadTask.checkNetworkType(localVideoDownloadItem.u);
        localVideoDownloadItem.w = paramString1.optString("str_openJumpUrlGuide", "");
        localVideoDownloadItem.p = paramString1.optString("str_myappDownloadUrl", "");
        localVideoDownloadItem.x = paramString1.optString("str_jumpTypeParams", "");
        localVideoDownloadItem.B = paramString1.optInt("uint32_scrollUpToJump", 0);
        int i1 = localVideoDownloadItem.B;
        bool = true;
        if (i1 == 1)
        {
          localVideoDownloadItem.E = bool;
          localVideoDownloadItem.C = paramString1.optInt("uint32_controlVariable", 0);
          localVideoDownloadItem.D = paramString1.optInt("uint32_control_plugin_time", 0);
          localVideoDownloadItem.F = paramString1.optInt("uint32_autoJump", 0);
          if (localVideoDownloadItem.n >= 3)
          {
            bool = TextUtils.isEmpty(localVideoDownloadItem.x);
            if (!bool) {
              try
              {
                paramString2 = new JSONObject(localVideoDownloadItem.x);
                localVideoDownloadItem.A = paramString2.optInt("class_id", -1);
                localVideoDownloadItem.z = paramString2.optString("class_name", "");
                localVideoDownloadItem.y = paramString2.optInt("pendant_id", -1);
              }
              catch (JSONException paramString2)
              {
                if (QLog.isColorLevel())
                {
                  paramString3 = new StringBuilder();
                  paramString3.append("parse jumpTypeParams fail");
                  paramString3.append(paramString2.getMessage());
                  QLog.w("VideoDownloadItem", 2, paramString3.toString());
                }
              }
            }
          }
          localVideoDownloadItem.G = paramString1.optString("str_clickLink", "");
          localVideoDownloadItem.H = paramString1.optInt("uint32_monitorType", 0);
          localVideoDownloadItem.I = paramString1.optString("str_share_nick", "");
          localVideoDownloadItem.J = paramString1.optString("str_share_ad_head_url", "");
          localVideoDownloadItem.K = paramString1.optString("str_share_ad_brief", "");
          localVideoDownloadItem.L = paramString1.optString("str_share_ad_txt", "");
          localVideoDownloadItem.M = paramString1.optString("str_share_ad_icon_url", "");
          localVideoDownloadItem.N = paramString1.optString("str_share_jump_url", "");
          return localVideoDownloadItem;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static VideoDownloadItem a(submsgtype0xf9.MsgCommonData paramMsgCommonData, String paramString1, String paramString2)
  {
    VideoDownloadItem localVideoDownloadItem = new VideoDownloadItem();
    localVideoDownloadItem.a = paramString1;
    localVideoDownloadItem.b = paramString2;
    if (paramMsgCommonData.str_adId.has()) {
      localVideoDownloadItem.c = paramMsgCommonData.str_adId.get();
    }
    if (paramMsgCommonData.str_adPosId.has()) {
      localVideoDownloadItem.d = paramMsgCommonData.str_adPosId.get();
    }
    if (paramMsgCommonData.bool_bannerShow.has()) {
      localVideoDownloadItem.i = paramMsgCommonData.bool_bannerShow.get();
    }
    if (paramMsgCommonData.uint32_bannertype.has()) {
      localVideoDownloadItem.j = paramMsgCommonData.uint32_bannertype.get();
    }
    if (paramMsgCommonData.uint32_jumpType.has()) {
      localVideoDownloadItem.n = paramMsgCommonData.uint32_jumpType.get();
    }
    if (paramMsgCommonData.str_jumpUrl.has()) {
      localVideoDownloadItem.v = paramMsgCommonData.str_jumpUrl.get();
    }
    if (paramMsgCommonData.str_appId.has()) {
      localVideoDownloadItem.q = paramMsgCommonData.str_appId.get();
    }
    if (paramMsgCommonData.str_packagename.has()) {
      localVideoDownloadItem.r = paramMsgCommonData.str_packagename.get();
    }
    if (paramMsgCommonData.str_androidDownloadUrl.has()) {
      localVideoDownloadItem.o = paramMsgCommonData.str_androidDownloadUrl.get();
    }
    if (paramMsgCommonData.str_bannerImgUrl.has()) {
      localVideoDownloadItem.k = paramMsgCommonData.str_bannerImgUrl.get();
    }
    if (paramMsgCommonData.str_bannerText.has()) {
      localVideoDownloadItem.l = paramMsgCommonData.str_bannerText.get();
    }
    if (paramMsgCommonData.str_bannerButtonText.has()) {
      localVideoDownloadItem.m = paramMsgCommonData.str_bannerButtonText.get();
    }
    if (paramMsgCommonData.bool_silentDownload.has()) {
      localVideoDownloadItem.t = paramMsgCommonData.bool_silentDownload.get();
    }
    if (paramMsgCommonData.str_appName.has()) {
      localVideoDownloadItem.s = paramMsgCommonData.str_appName.get();
    }
    if (paramMsgCommonData.str_reportLink.has())
    {
      localVideoDownloadItem.e = paramMsgCommonData.str_reportLink.get();
      if ((!TextUtils.isEmpty(localVideoDownloadItem.e)) && (!localVideoDownloadItem.e.contains("https"))) {
        localVideoDownloadItem.e = localVideoDownloadItem.e.replace("http", "https");
      }
    }
    if (paramMsgCommonData.bool_horizontalVideo.has()) {
      localVideoDownloadItem.g = paramMsgCommonData.bool_horizontalVideo.get();
    }
    if (paramMsgCommonData.uint32_audioFadeinDuration.has()) {
      localVideoDownloadItem.f = paramMsgCommonData.uint32_audioFadeinDuration.get();
    }
    if (paramMsgCommonData.uint32_audioSwitchType.has()) {
      localVideoDownloadItem.h = paramMsgCommonData.uint32_audioSwitchType.get();
    }
    if (paramMsgCommonData.uint32_preDownloadType.has())
    {
      localVideoDownloadItem.u = paramMsgCommonData.uint32_preDownloadType.get();
      localVideoDownloadItem.u = PAAdPreloadTask.checkNetworkType(localVideoDownloadItem.u);
    }
    if (paramMsgCommonData.str_openJumpUrlGuide.has()) {
      localVideoDownloadItem.w = paramMsgCommonData.str_openJumpUrlGuide.get();
    }
    if (paramMsgCommonData.str_myappDownloadUrl.has()) {
      localVideoDownloadItem.p = paramMsgCommonData.str_myappDownloadUrl.get();
    }
    if (paramMsgCommonData.str_jumpTypeParams.has()) {
      localVideoDownloadItem.x = paramMsgCommonData.str_jumpTypeParams.get();
    }
    if (paramMsgCommonData.uint32_scrollUpToJump.has())
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("uint32_scrollUpToJump :");
        paramString1.append(paramMsgCommonData.uint32_scrollUpToJump.get());
        QLog.w("VideoDownloadItem", 2, paramString1.toString());
      }
      localVideoDownloadItem.B = paramMsgCommonData.uint32_scrollUpToJump.get();
      int i1 = localVideoDownloadItem.B;
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      localVideoDownloadItem.E = bool;
    }
    if (paramMsgCommonData.uint32_controlVariable.has())
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("uint32_controlVariable :");
        paramString1.append(paramMsgCommonData.uint32_controlVariable.get());
        QLog.d("VideoDownloadItem", 2, paramString1.toString());
      }
      localVideoDownloadItem.C = paramMsgCommonData.uint32_controlVariable.get();
    }
    if (paramMsgCommonData.uint32_control_plugin_time.has())
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("uint32_control_plugin_time :");
        paramString1.append(paramMsgCommonData.uint32_control_plugin_time.get());
        QLog.d("VideoDownloadItem", 2, paramString1.toString());
      }
      localVideoDownloadItem.D = paramMsgCommonData.uint32_control_plugin_time.get();
    }
    if (paramMsgCommonData.uint32_autoJump.has())
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("uint32_autoJump :");
        paramString1.append(paramMsgCommonData.uint32_autoJump.get());
        QLog.d("VideoDownloadItem", 2, paramString1.toString());
      }
      localVideoDownloadItem.F = paramMsgCommonData.uint32_autoJump.get();
    }
    if ((localVideoDownloadItem.n >= 3) && (!TextUtils.isEmpty(localVideoDownloadItem.x))) {
      try
      {
        paramString1 = new JSONObject(localVideoDownloadItem.x);
        localVideoDownloadItem.A = paramString1.optInt("class_id", -1);
        localVideoDownloadItem.z = paramString1.optString("class_name", "");
        localVideoDownloadItem.y = paramString1.optInt("pendant_id", -1);
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("parse jumpTypeParams fail");
          paramString2.append(paramString1.getMessage());
          QLog.w("VideoDownloadItem", 2, paramString2.toString());
        }
      }
    }
    if (paramMsgCommonData.str_clickLink.has())
    {
      localVideoDownloadItem.G = paramMsgCommonData.str_clickLink.get();
      if ((!TextUtils.isEmpty(localVideoDownloadItem.G)) && (!localVideoDownloadItem.G.startsWith("https://"))) {
        localVideoDownloadItem.G = localVideoDownloadItem.G.replace("http://", "https://");
      }
    }
    if (paramMsgCommonData.uint32_monitorType.has()) {
      localVideoDownloadItem.H = paramMsgCommonData.uint32_monitorType.get();
    }
    if (paramMsgCommonData.str_share_nick.has()) {
      localVideoDownloadItem.I = paramMsgCommonData.str_share_nick.get();
    }
    if (paramMsgCommonData.str_share_ad_head_url.has()) {
      localVideoDownloadItem.J = paramMsgCommonData.str_share_ad_head_url.get();
    }
    if (paramMsgCommonData.str_share_ad_brief.has()) {
      localVideoDownloadItem.K = paramMsgCommonData.str_share_ad_brief.get();
    }
    if (paramMsgCommonData.str_share_ad_txt.has()) {
      localVideoDownloadItem.L = paramMsgCommonData.str_share_ad_txt.get();
    }
    if (paramMsgCommonData.str_share_ad_icon_url.has()) {
      localVideoDownloadItem.M = paramMsgCommonData.str_share_ad_icon_url.get();
    }
    if (paramMsgCommonData.str_share_jump_url.has()) {
      localVideoDownloadItem.N = paramMsgCommonData.str_share_jump_url.get();
    }
    return localVideoDownloadItem;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("paUin", this.a);
      localJSONObject.put("paName", this.b);
      localJSONObject.put("bannerShow", this.i);
      localJSONObject.put("bannertype", this.j);
      localJSONObject.put("jumpType", this.n);
      localJSONObject.put("jumpUrl", this.v);
      localJSONObject.put("appId", this.q);
      localJSONObject.put("packagename", this.r);
      localJSONObject.put("androidDownloadUrl", this.o);
      localJSONObject.put("bannerImgUrl", this.k);
      localJSONObject.put("bannerText", this.l);
      localJSONObject.put("bannerButtonText", this.m);
      localJSONObject.put("silentDownload", this.t);
      localJSONObject.put("adId", this.c);
      localJSONObject.put("adPosId", this.d);
      localJSONObject.put("appName", this.s);
      localJSONObject.put("reportLink", this.e);
      localJSONObject.put("horizontalVideo", this.g);
      localJSONObject.put("audioFadeinDuration", this.f);
      localJSONObject.put("audioSwitchType", this.h);
      localJSONObject.put("preDownloadType", this.u);
      localJSONObject.put("str_openJumpUrlGuide", this.w);
      localJSONObject.put("str_myappDownloadUrl", this.p);
      localJSONObject.put("jumpTypeParams", this.x);
      localJSONObject.put("canScorll", this.B);
      localJSONObject.put("controlVariable", this.C);
      localJSONObject.put("uint32_control_plugin_time", this.D);
      localJSONObject.put("uint32_autoJump", this.F);
      localJSONObject.put("dDCategoryId", this.A);
      localJSONObject.put("dDCategoryName", this.z);
      localJSONObject.put("dDItemID", this.y);
      localJSONObject.put("str_clickLink", this.G);
      localJSONObject.put("uint32_monitorType", this.H);
      localJSONObject.put("str_share_nick", this.I);
      localJSONObject.put("str_share_ad_head_url", this.J);
      localJSONObject.put("str_share_ad_brief", this.K);
      localJSONObject.put("str_share_ad_txt", this.L);
      localJSONObject.put("str_share_ad_icon_url", this.M);
      localJSONObject.put("str_share_jump_url", this.N);
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
    localStringBuilder.append("VideoDownloadItem{mTrueUin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNickName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adPosId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportLink='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", audioFadeinDuration=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", horizontalVideo=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", audioMode=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", bannerShow=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", bannertype=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", bannerImgUrl='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerText='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerButtonText='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpType=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", downloadUrl='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", myappDownloadUrl='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", packagename='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", silentDownload=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", downloadType=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.v);
    localStringBuilder.append('\'');
    localStringBuilder.append(", openJumpUrlGuide='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpTypeParams='");
    localStringBuilder.append(this.x);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dDItemID=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", dDCategoryName='");
    localStringBuilder.append(this.z);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dDCategoryId=");
    localStringBuilder.append(this.A);
    localStringBuilder.append(", canScorll=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", controlVariable=");
    localStringBuilder.append(this.C);
    localStringBuilder.append(", plugin_time=");
    localStringBuilder.append(this.D);
    localStringBuilder.append(", scrollUpToJump=");
    localStringBuilder.append(this.E);
    localStringBuilder.append(", uint32_autoJump=");
    localStringBuilder.append(this.F);
    localStringBuilder.append(", mClickReportLink='");
    localStringBuilder.append(this.G);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mReportPlatType=");
    localStringBuilder.append(this.H);
    localStringBuilder.append(", mShareNickname='");
    localStringBuilder.append(this.I);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShareHeaderUrl='");
    localStringBuilder.append(this.J);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShareBrief='");
    localStringBuilder.append(this.K);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShareTxt='");
    localStringBuilder.append(this.L);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShareIconUrl='");
    localStringBuilder.append(this.M);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShareJumpUrl='");
    localStringBuilder.append(this.N);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem
 * JD-Core Version:    0.7.0.1
 */