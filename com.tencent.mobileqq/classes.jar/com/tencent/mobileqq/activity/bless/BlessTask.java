package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class BlessTask
  extends Entity
{
  public int cameraMode = 0;
  public String defaultShareTitle;
  public String defaultVoice;
  public int defaultVoiceLength;
  public String entranceBegin;
  public int entranceEnabled;
  public String entranceEnd;
  public String entranceHint;
  public String ex1 = "";
  public String ex2 = "";
  public int ex3 = 0;
  public int ex4 = 0;
  public int festival_id;
  public String filterCategory = "";
  public String filterId = "";
  @unique
  public int id = 1000;
  public boolean isDeleted = false;
  public boolean isNew = true;
  public String mainBanner;
  public String mainCenter;
  public String pendantCategory = HardCodeUtil.a(2131899409);
  public String pendantId = "";
  public int ptvAnimationCost;
  public int ptvAnimationCount;
  public boolean ptvAnimationSwtich;
  public String ptvAnimationUrl;
  public int ptvEnabled;
  public String recentHeadImgUrl;
  public String recentHeadImgUrlSimple;
  public String sendBackBegin;
  public String sendBackEnd;
  public int sendTotalLimit;
  public String shareQzoneTitle;
  public String shareUrl;
  public String shareWeixinTitle;
  public String starAvator;
  public String starAvatorSimple;
  public String starBegin;
  public String starBless;
  public String starEnd;
  public String starVideo;
  public String starVideoCoverFileName = "cover";
  public String starVideoCoverFolderName = "cover";
  public String starWord;
  public String succeededBanner;
  public int supportFilter = 1;
  public int supportPendant = 1;
  public int supportPhoto = 0;
  public int supportVideo = 1;
  public int task_id;
  public String typeBanner;
  public int uinTotalLimit;
  public int unfoldFilter = 0;
  public int unfoldPendant = 1;
  public int unread;
  public boolean videoPlayed = false;
  public String webBlessUrl;
  
  public static boolean parse(String paramString, BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      paramBlessTask.festival_id = paramString.optInt("festival_id", -1);
      paramBlessTask.task_id = paramString.optInt("task_id", -1);
      paramBlessTask.entranceEnabled = paramString.getInt("mb_open");
      paramBlessTask.ptvEnabled = paramString.getInt("mb_ptv_open");
      paramBlessTask.starVideo = paramString.getString("mb_star_video");
      paramBlessTask.starAvator = paramString.getString("mb_star_avator");
      if (paramString.has("mb_star_avator_simple")) {
        paramBlessTask.starAvatorSimple = paramString.getString("mb_star_avator_simple");
      }
      paramBlessTask.starWord = paramString.getString("mb_star_word");
      paramBlessTask.starBless = paramString.getString("mb_star_bless");
      paramBlessTask.ex2 = paramString.getString("mb_star_bless_orange");
      paramBlessTask.ex3 = paramString.optInt("use_hint", 0);
      paramBlessTask.entranceHint = paramString.getString("mb_hint");
      paramBlessTask.entranceBegin = paramString.getString("mb_begin");
      paramBlessTask.entranceEnd = paramString.getString("mb_end");
      paramBlessTask.sendBackBegin = paramString.getString("mb_return_begin");
      paramBlessTask.sendBackEnd = paramString.getString("mb_return_end");
      paramBlessTask.starBegin = paramString.getString("mb_star_begin");
      paramBlessTask.starEnd = paramString.getString("mb_star_end");
      paramBlessTask.unread = paramString.getInt("mb_redpoint");
      paramBlessTask.mainBanner = paramString.getString("mb_main_banner");
      paramBlessTask.mainCenter = paramString.getString("mb_center_banner");
      paramBlessTask.typeBanner = paramString.getString("mb_type_banner");
      paramBlessTask.succeededBanner = paramString.getString("mb_succed_banner");
      paramBlessTask.uinTotalLimit = paramString.getInt("mb_uin_limit");
      paramBlessTask.sendTotalLimit = paramString.getInt("mb_send_limit");
      paramBlessTask.defaultVoiceLength = paramString.getInt("mb_default_voice_length");
      paramBlessTask.defaultShareTitle = paramString.getString("mb_default_share_title");
    }
    catch (Exception paramString)
    {
      label312:
      Object localObject;
      label429:
      int i;
      QLog.e("BlessTask", 1, "parse error, ", paramString);
      return false;
    }
    try
    {
      paramBlessTask.shareUrl = paramString.getString("mb_share_url");
    }
    catch (Exception localException)
    {
      break label312;
      bool = false;
      break label429;
    }
    paramBlessTask.shareUrl = "";
    if (paramString.has("mb_recent_head")) {
      paramBlessTask.recentHeadImgUrl = paramString.getString("mb_recent_head");
    }
    if (paramString.has("mb_recent_head_simple")) {
      paramBlessTask.recentHeadImgUrlSimple = paramString.getString("mb_recent_head_simple");
    }
    if (paramString.has("mb_shareQzone_title")) {
      paramBlessTask.shareQzoneTitle = paramString.getString("mb_shareQzone_title");
    }
    if (paramString.has("mb_shareWeixin_title")) {
      paramBlessTask.shareWeixinTitle = paramString.getString("mb_shareWeixin_title");
    }
    if (paramString.has("mb_ptvAnimation_open"))
    {
      if (paramString.getInt("mb_ptvAnimation_open") != 1) {
        break label888;
      }
      bool = true;
      paramBlessTask.ptvAnimationSwtich = bool;
      if ((paramBlessTask.ptvAnimationSwtich) && (paramString.has("mb_ptvAnimation_Url")) && (paramString.has("mb_ptvAnimation_repeat_count")) && (paramString.has("mb_ptvAnimation_cost")))
      {
        paramBlessTask.ptvAnimationUrl = paramString.getString("mb_ptvAnimation_Url");
        paramBlessTask.ptvAnimationCount = paramString.getInt("mb_ptvAnimation_repeat_count");
        paramBlessTask.ptvAnimationCost = paramString.getInt("mb_ptvAnimation_cost");
      }
    }
    if (paramString.has("mb_bless_url")) {
      paramBlessTask.webBlessUrl = paramString.getString("mb_bless_url");
    }
    localObject = paramString.getJSONArray("mb_words");
    i = 0;
    while (i < ((JSONArray)localObject).length())
    {
      paramArrayList1.add(new BlessWording(((JSONArray)localObject).getString(i)));
      i += 1;
    }
    paramBlessTask.defaultVoice = paramString.getString("mb_default_voice");
    paramArrayList1 = paramString.getJSONArray("mb_ptvs");
    i = 0;
    while (i < paramArrayList1.length())
    {
      localObject = paramArrayList1.getJSONObject(i);
      paramArrayList.add(new BlessPtvModule(((JSONObject)localObject).getString("mb_name"), ((JSONObject)localObject).getString("mb_data"), ((JSONObject)localObject).getString("mb_id"), ((JSONObject)localObject).getString("mb_viplevel"), ((JSONObject)localObject).getInt("mb_music_length"), ((JSONObject)localObject).getString("mb_share_title")));
      i += 1;
    }
    bool = paramString.has("camera_param");
    if (bool) {
      try
      {
        paramString = paramString.getJSONObject("camera_param");
        paramBlessTask.supportVideo = paramString.getInt("support_video");
        paramBlessTask.supportPhoto = paramString.getInt("support_photo");
        paramBlessTask.cameraMode = paramString.getInt("camera_mode");
        paramBlessTask.supportPendant = paramString.getInt("support_pendant");
        paramBlessTask.unfoldPendant = paramString.getInt("unfold_pendant");
        paramBlessTask.pendantCategory = paramString.getString("pendant_category");
        paramBlessTask.pendantId = paramString.getString("pendant_id");
        paramBlessTask.supportFilter = paramString.getInt("support_filter");
        paramBlessTask.unfoldFilter = paramString.getInt("unfold_filter");
        paramBlessTask.filterCategory = paramString.getString("filter_category");
        paramBlessTask.filterId = paramString.getString("filter_id");
        if ((paramBlessTask.supportVideo == 0) && (paramBlessTask.supportPhoto == 0)) {
          paramBlessTask.supportVideo = 1;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          QLog.e("BlessTask", 1, "parse error, ", paramString);
          return true;
        }
        catch (Exception paramString) {}
      }
    } else {
      return true;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----BlessTask KeyDump-----:");
    localStringBuilder.append(",festival_id:");
    localStringBuilder.append(this.festival_id);
    localStringBuilder.append(",task_id:");
    localStringBuilder.append(this.task_id);
    localStringBuilder.append(",entranceEnabled:");
    localStringBuilder.append(this.entranceEnabled);
    localStringBuilder.append(",entranceBegin:");
    localStringBuilder.append(this.entranceBegin);
    localStringBuilder.append(",entranceEnd:");
    localStringBuilder.append(this.entranceEnd);
    localStringBuilder.append(",ptvEnabled:");
    localStringBuilder.append(this.ptvEnabled);
    localStringBuilder.append(",videoPlayed:");
    localStringBuilder.append(this.videoPlayed);
    localStringBuilder.append(",uinTotalLimit:");
    localStringBuilder.append(this.uinTotalLimit);
    localStringBuilder.append(",sendTotalLimit:");
    localStringBuilder.append(this.sendTotalLimit);
    localStringBuilder.append(",unfoldPendant:");
    localStringBuilder.append(this.unfoldPendant);
    localStringBuilder.append(",unfoldFilter:");
    localStringBuilder.append(this.unfoldFilter);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessTask
 * JD-Core Version:    0.7.0.1
 */