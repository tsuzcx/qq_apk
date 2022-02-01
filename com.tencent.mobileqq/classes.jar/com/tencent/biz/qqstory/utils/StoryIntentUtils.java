package com.tencent.biz.qqstory.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;

public class StoryIntentUtils
{
  public static Intent a(Intent paramIntent, Bundle paramBundle, Activity paramActivity)
  {
    if (paramBundle == null) {
      return paramIntent;
    }
    if (paramBundle.containsKey("ignorePersonalPublish")) {
      paramIntent.putExtra("ignorePersonalPublish", paramBundle.getBoolean("ignorePersonalPublish"));
    }
    paramIntent.putExtra("troop_uin", paramBundle.getInt("troop_uin", 0));
    paramIntent.putExtra("entrance_type", paramBundle.getInt("entrance_type"));
    paramIntent.putExtra("shareGroupType", paramBundle.getString("shareGroupType"));
    paramIntent.putExtra("shareGroupId", paramBundle.getString("shareGroupId"));
    paramIntent.putExtra("shareGroupName", paramBundle.getString("shareGroupName"));
    if (paramBundle.getString("widgetinfo") != null)
    {
      paramIntent.putExtra("qq_camera_scheme", JumpUtil.a(paramBundle.getString("widgetinfo")));
      paramIntent.putExtra("widgetinfo", paramBundle.getString("widgetinfo"));
      String str = paramBundle.getString("key_camera_material_name");
      AEQLog.b("StoryIntentUtils", "passStoryRecordExtrasToIntent---takeSameName=" + str);
      if (TextUtils.isEmpty(str)) {
        break label319;
      }
      paramIntent.putExtra("key_camera_material_name", str);
      paramIntent.putExtra("qq_camera_top_title", str);
    }
    for (;;)
    {
      paramIntent.putExtra("KEY_SEND_ARK_MSG_ID", paramBundle.getString("KEY_SEND_ARK_MSG_ID"));
      paramIntent.putExtra("key_scheme_request_from_business_type", paramBundle.getString("key_scheme_request_from_business_type"));
      if (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))
      {
        paramIntent.putExtra("share_url_target_url", paramBundle.getString("share_url_target_url"));
        paramIntent.putExtra("share_url_name", paramBundle.getString("share_url_name"));
        paramIntent.putExtra("share_url_text", paramBundle.getString("share_url_text"));
        paramIntent.putExtra("share_url_thumb_url", paramBundle.getString("share_url_thumb_url"));
        paramIntent.putExtra("struct_share_key_source_name", paramBundle.getString("struct_share_key_source_name"));
        paramIntent.putExtra("struct_share_key_source_icon", paramBundle.getString("struct_share_key_source_icon"));
      }
      paramIntent.putExtra("video_tag_info", paramBundle.getString("video_tag_info"));
      return paramIntent;
      label319:
      paramIntent.putExtra("qq_camera_top_title", "魔法视频");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.StoryIntentUtils
 * JD-Core Version:    0.7.0.1
 */