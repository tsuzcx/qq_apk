package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ShortVideoForwardManager
{
  public static Intent a(String paramString1, String paramString2, SendPanelItemInfo paramSendPanelItemInfo, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramSendPanelItemInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("troop_uin", paramSendPanelItemInfo.b);
    localIntent.putExtra("uintype", paramSendPanelItemInfo.jdField_a_of_type_Int);
    localIntent.putExtra("from_uin_type", paramSendPanelItemInfo.jdField_a_of_type_Int);
    localIntent.putExtra("forward_thumb", paramString2);
    localIntent.putExtra("thumbfile_send_path", paramString2);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("forward_need_sendmsg", true);
    localIntent.putExtra("from_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("key_story_video_to_recent", true);
    localIntent.putExtra("widgetinfo", paramString3);
    localIntent.putExtra("key_camera_material_name", paramString4);
    paramString4 = new File(paramString1);
    if ((paramString4.exists()) && (new File(paramString2).exists()))
    {
      String str = HexUtil.bytes2HexStr(FileManagerUtil.d(paramString1));
      if (str == null)
      {
        QLog.e("ShortVideoForwardManager", 1, "video file md5 compute fail");
        return null;
      }
      paramString3 = HexUtil.bytes2HexStr(FileManagerUtil.d(paramString2));
      if (paramString3 == null)
      {
        QLog.e("ShortVideoForwardManager", 1, "thumb file md5 compute fail");
        return null;
      }
      paramSendPanelItemInfo.g = str;
      paramSendPanelItemInfo = new MediaMetadataUtils.MetaData();
      int i = MediaMetadataUtils.a(paramString1, paramSendPanelItemInfo);
      if (i != 0)
      {
        QLog.e("ShortVideoForwardManager", 1, new Object[] { "video file getRotationDegree fail, code:", Integer.valueOf(i) });
        return null;
      }
      i = paramSendPanelItemInfo.a[0];
      int j = paramSendPanelItemInfo.a[1];
      int k = paramSendPanelItemInfo.a[3];
      localIntent.putExtra("file_send_size", (int)paramString4.length());
      double d = k;
      Double.isNaN(d);
      localIntent.putExtra("file_send_duration", (int)Math.round(d / 1000.0D));
      localIntent.putExtra("file_shortvideo_md5", str);
      localIntent.putExtra("file_name", paramString1);
      localIntent.putExtra("file_width", i);
      localIntent.putExtra("file_height", j);
      paramString1 = new BitmapFactory.Options();
      paramString1.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString2, paramString1);
      localIntent.putExtra("thumbfile_send_width", paramString1.outWidth);
      localIntent.putExtra("thumbfile_send_height", paramString1.outHeight);
      localIntent.putExtra("thumbfile_md5", paramString3);
      return localIntent;
    }
    QLog.e("ShortVideoForwardManager", 1, "video file do not exist");
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      String str = paramString1.optString("_show_mission");
      paramString1 = new JSONObject(new JSONObject(paramString1.optString("msg")).optString(str)).optString("link");
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("ShortVideoForwardManager", 1, "parseLinkFromRedTouchBuffer fail, ", paramString1);
    }
    return paramString2;
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 27);
    localIntent.putExtra("is_ark_display_share", true);
    localIntent.putExtra("forward_ark_app_name", "com.tencent.subscription");
    localIntent.putExtra("forward_ark_app_view", paramString1);
    localIntent.putExtra("forward_ark_app_ver", "1.0.0.29");
    localIntent.putExtra("forward_ark_app_prompt", "promptTest");
    localIntent.putExtra("forward_ark_app_meta", paramString2);
    localIntent.putExtra("forward_ark_app_config", "");
    localIntent.putExtra("selection_mode", 2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    a(paramActivity, paramString1, paramString2, paramBoolean, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 21);
    localIntent.putExtra("forward_thumb", paramString2);
    localIntent.putExtra("thumbfile_send_path", paramString2);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("forward_need_sendmsg", true);
    localIntent.putExtra("from_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("k_qzone", true);
    localIntent.putExtra("key_direct_jump_qzone_shuoshuo", paramBoolean);
    localIntent.putExtra("forward_source_business_type", 100200);
    localIntent.putExtra("k_qzone", true);
    localIntent.putExtra("forward_ability_entrence_show_in_share", false);
    localIntent.putExtra("key_forward_business_id", "msg_tab_camera");
    localIntent.putExtra("filePath", paramString1);
    localIntent.putExtra("reqType", 4);
    localIntent.putExtra("source", "msgTabCamera");
    if (paramString1 == null)
    {
      QLog.e("ShortVideoForwardManager", 1, "videoPath is null");
      return;
    }
    File localFile = new File(paramString1);
    if ((localFile.exists()) && (new File(paramString2).exists()))
    {
      String str = HexUtil.bytes2HexStr(FileManagerUtil.d(paramString1));
      if (str == null)
      {
        QLog.e("ShortVideoForwardManager", 1, "video file md5 compute fail");
        return;
      }
      Object localObject = HexUtil.bytes2HexStr(FileManagerUtil.d(paramString2));
      if (localObject == null)
      {
        QLog.e("ShortVideoForwardManager", 1, "thumb file md5 compute fail");
        return;
      }
      MediaMetadataUtils.MetaData localMetaData = new MediaMetadataUtils.MetaData();
      int i = MediaMetadataUtils.a(paramString1, localMetaData);
      if (i != 0)
      {
        QLog.e("ShortVideoForwardManager", 1, new Object[] { "video file getRotationDegree fail, code:", Integer.valueOf(i) });
        return;
      }
      i = localMetaData.a[0];
      int j = localMetaData.a[1];
      int k = localMetaData.a[3];
      localIntent.putExtra("file_send_size", (int)localFile.length());
      double d = k;
      Double.isNaN(d);
      localIntent.putExtra("file_send_duration", (int)Math.round(d / 1000.0D));
      localIntent.putExtra("file_shortvideo_md5", str);
      localIntent.putExtra("file_name", localFile.getName());
      localIntent.putExtra("file_width", i);
      localIntent.putExtra("file_height", j);
      paramString1 = new BitmapFactory.Options();
      paramString1.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString2, paramString1);
      localIntent.putExtra("thumbfile_send_width", paramString1.outWidth);
      localIntent.putExtra("thumbfile_send_height", paramString1.outHeight);
      localIntent.putExtra("thumbfile_md5", (String)localObject);
      localIntent.setClass(paramActivity, ForwardRecentActivity.class);
      if (TextUtils.isEmpty(paramString3)) {
        localIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
      } else {
        localIntent.putExtra("caller_name", paramString3);
      }
      if ((paramActivity instanceof QQStoryBaseActivity))
      {
        paramString1 = paramActivity.getIntent().getStringExtra("widgetinfo");
        if (!TextUtils.isEmpty(paramString1))
        {
          localIntent.putExtra("qq_camera_scheme", JumpUtil.a(paramString1));
          localIntent.putExtra("widgetinfo", paramString1);
          paramString1 = paramActivity.getIntent().getStringExtra("key_camera_material_name");
          paramString2 = new StringBuilder();
          paramString2.append("gotoForwardShortVideoUI---activity=");
          paramString2.append(paramActivity);
          paramString2.append(", takeSameName=");
          paramString2.append(paramString1);
          AEQLog.b("ShortVideoForwardManager", paramString2.toString());
          if (!TextUtils.isEmpty(paramString1))
          {
            localIntent.putExtra("key_camera_material_name", paramString1);
            localIntent.putExtra("qq_camera_top_title", paramString1);
          }
          else
          {
            localIntent.putExtra("qq_camera_top_title", "魔法视频");
          }
        }
        ((QQStoryBaseActivity)paramActivity).startActivityForResultDirectly(localIntent, paramInt);
        return;
      }
      if ((!(paramActivity instanceof PublicFragmentActivityForPeak)) && (!(paramActivity instanceof QQBrowserActivity)))
      {
        paramActivity.startActivityForResult(localIntent, paramInt);
        return;
      }
      paramString1 = paramActivity.getIntent();
      paramString3 = "";
      if (paramString1 == null) {
        paramString1 = "";
      } else {
        paramString1 = paramActivity.getIntent().getStringExtra("loc_play_show_tab_name");
      }
      if (paramActivity.getIntent() == null) {
        paramString2 = "";
      } else {
        paramString2 = paramActivity.getIntent().getStringExtra("loc_play_show_material_id");
      }
      if (paramActivity.getIntent() != null) {
        paramString3 = paramActivity.getIntent().getStringExtra("key_camera_material_name");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoForwardShortVideoUI---activity=");
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append(", takeSameName=");
      ((StringBuilder)localObject).append(paramString3);
      AEQLog.b("ShortVideoForwardManager", ((StringBuilder)localObject).toString());
      try
      {
        if (paramString2.startsWith("http"))
        {
          localIntent.putExtra("widgetinfo", URLEncoder.encode(paramString2, "UTF-8"));
          localIntent.putExtra("qq_camera_scheme", JumpUtil.a(paramString2));
          if (!TextUtils.isEmpty(paramString3))
          {
            localIntent.putExtra("key_camera_material_name", paramString3);
            localIntent.putExtra("qq_camera_top_title", paramString3);
          }
          else
          {
            localIntent.putExtra("qq_camera_top_title", "魔法视频");
          }
        }
        else if ((!StringUtil.a(paramString2)) && (!StringUtil.a(paramString1)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("play^");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append("^");
          ((StringBuilder)localObject).append(paramString1);
          paramString1 = ((StringBuilder)localObject).toString();
          localIntent.putExtra("widgetinfo", paramString1);
          localIntent.putExtra("qq_camera_scheme", JumpUtil.a(paramString1));
          if (!TextUtils.isEmpty(paramString3))
          {
            localIntent.putExtra("key_camera_material_name", paramString3);
            localIntent.putExtra("qq_camera_top_title", paramString3);
          }
          else
          {
            localIntent.putExtra("qq_camera_top_title", "魔法视频");
          }
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
      }
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    QLog.e("ShortVideoForwardManager", 1, "video file do not exist");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramBoolean, 21, paramString3);
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    a(paramActivity, paramString, paramBoolean, false, null, null, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = new File(paramString1);
    if (!((File)localObject).exists())
    {
      QLog.e("ShortVideoForwardManager", 1, "pic file do not exist");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_filepath", paramString1);
    localIntent.putExtra("forward_thumb", paramString1);
    localIntent.putExtra("forward_urldrawable", true);
    localIntent.putExtra("forward_urldrawable_big_url", ((File)localObject).toURI().toString());
    localIntent.putExtra("forward_urldrawable_thumb_url", ((File)localObject).toURI().toString());
    localIntent.putExtra("forward_send_selfie_face", true);
    localIntent.putExtra("key_help_forward_pic", true);
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("key_direct_jump_qzone_shuoshuo", paramBoolean1);
    localIntent.putExtra("forward_is_selfie_face", paramBoolean2);
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      localIntent.putExtra("forward_summary_extra", ((StringBuilder)localObject).toString());
    }
    else if (paramBoolean2)
    {
      localIntent.putExtra("forward_summary_extra", HardCodeUtil.a(2131713919));
    }
    if ((paramActivity != null) && (paramActivity.getIntent() != null))
    {
      paramString2 = paramActivity.getIntent().getStringExtra("widgetinfo");
      if (paramString2 != null)
      {
        localIntent.putExtra("qq_camera_scheme", JumpUtil.a(paramString2));
        localIntent.putExtra("widgetinfo", paramString2);
        paramString2 = paramActivity.getIntent().getStringExtra("key_camera_material_name");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gotoForwardPicUI---activity=");
        ((StringBuilder)localObject).append(paramActivity);
        ((StringBuilder)localObject).append(", takeSameName=");
        ((StringBuilder)localObject).append(paramString2);
        AEQLog.b("ShortVideoForwardManager", ((StringBuilder)localObject).toString());
        if (!TextUtils.isEmpty(paramString2))
        {
          localIntent.putExtra("key_camera_material_name", paramString2);
          localIntent.putExtra("qq_camera_top_title", paramString2);
        }
        else
        {
          localIntent.putExtra("qq_camera_top_title", "魔法视频");
        }
      }
    }
    if (paramBoolean2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gif^");
      paramString2 = paramString3;
      if (paramString3 == null) {
        paramString2 = "";
      }
      ((StringBuilder)localObject).append(paramString2);
      localIntent.putExtra("widgetinfo", ((StringBuilder)localObject).toString());
    }
    localIntent.putExtra("k_qzone", true);
    localIntent.putExtra("forward_ability_entrence_show_in_share", false);
    localIntent.putExtra("key_forward_business_id", "msg_tab_camera");
    localIntent.putExtra("filePath", paramString1);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("source", "msgTabCamera");
    if ((paramInt != 2) && (paramInt != 1))
    {
      ForwardBaseOption.a(paramActivity, localIntent, 21, 100200);
      return;
    }
    ForwardBaseOption.a(paramActivity, "caller_aecamera", localIntent, 21, 100200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.ShortVideoForwardManager
 * JD-Core Version:    0.7.0.1
 */