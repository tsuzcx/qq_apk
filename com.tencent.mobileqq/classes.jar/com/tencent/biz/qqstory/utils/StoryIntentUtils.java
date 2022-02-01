package com.tencent.biz.qqstory.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class StoryIntentUtils
{
  public static Intent a(Intent paramIntent, Bundle paramBundle, Activity paramActivity)
  {
    if (paramBundle == null) {
      return paramIntent;
    }
    paramIntent.putExtra("troop_uin", paramBundle.getInt("troop_uin", 0));
    paramIntent.putExtra("entrance_type", paramBundle.getInt("entrance_type"));
    if (paramBundle.getString("widgetinfo") != null)
    {
      paramIntent.putExtra("qq_camera_scheme", ((IJumpUtil)QRoute.api(IJumpUtil.class)).getSchemeForTail(paramBundle.getString("widgetinfo")));
      paramIntent.putExtra("widgetinfo", paramBundle.getString("widgetinfo"));
      paramActivity = paramBundle.getString("key_camera_material_name");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("passStoryRecordExtrasToIntent---takeSameName=");
      localStringBuilder.append(paramActivity);
      AEQLog.b("StoryIntentUtils", localStringBuilder.toString());
      if (!TextUtils.isEmpty(paramActivity))
      {
        paramIntent.putExtra("key_camera_material_name", paramActivity);
        paramIntent.putExtra("qq_camera_top_title", paramActivity);
      }
      else
      {
        paramIntent.putExtra("qq_camera_top_title", "魔法视频");
      }
    }
    paramIntent.putExtra("KEY_SEND_ARK_MSG_ID", paramBundle.getString("KEY_SEND_ARK_MSG_ID"));
    paramIntent.putExtra("key_scheme_request_from_business_type", paramBundle.getString("key_scheme_request_from_business_type"));
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.StoryIntentUtils
 * JD-Core Version:    0.7.0.1
 */