import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class bjzs
{
  public static Intent a(String paramString1, String paramString2, bkmo parambkmo, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", parambkmo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("troop_uin", parambkmo.b);
    localIntent.putExtra("uintype", parambkmo.jdField_a_of_type_Int);
    localIntent.putExtra("from_uin_type", parambkmo.jdField_a_of_type_Int);
    localIntent.putExtra("forward_thumb", paramString2);
    localIntent.putExtra("thumbfile_send_path", paramString2);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("forward_need_sendmsg", true);
    localIntent.putExtra("from_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("key_story_video_to_recent", true);
    localIntent.putExtra("widgetinfo", paramString3);
    File localFile = new File(paramString1);
    if ((!localFile.exists()) || (!new File(paramString2).exists()))
    {
      QLog.e("ShortVideoForwardManager", 1, "video file do not exist");
      return null;
    }
    String str = bbea.a(apug.d(paramString1));
    if (str == null)
    {
      QLog.e("ShortVideoForwardManager", 1, "video file md5 compute fail");
      return null;
    }
    paramString3 = bbea.a(apug.d(paramString2));
    if (paramString3 == null)
    {
      QLog.e("ShortVideoForwardManager", 1, "thumb file md5 compute fail");
      return null;
    }
    parambkmo.g = str;
    parambkmo = new blck();
    int i = blcj.a(paramString1, parambkmo);
    if (i != 0)
    {
      QLog.e("ShortVideoForwardManager", 1, new Object[] { "video file getRotationDegree fail, code:", Integer.valueOf(i) });
      return null;
    }
    i = parambkmo.a[0];
    int j = parambkmo.a[1];
    int k = parambkmo.a[3];
    localIntent.putExtra("file_send_size", (int)localFile.length());
    localIntent.putExtra("file_send_duration", (int)Math.round(k / 1000.0D));
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
    File localFile = new File(paramString1);
    if ((!localFile.exists()) || (!new File(paramString2).exists()))
    {
      QLog.e("ShortVideoForwardManager", 1, "video file do not exist");
      return;
    }
    String str2 = bbea.a(apug.d(paramString1));
    if (str2 == null)
    {
      QLog.e("ShortVideoForwardManager", 1, "video file md5 compute fail");
      return;
    }
    String str1 = bbea.a(apug.d(paramString2));
    if (str1 == null)
    {
      QLog.e("ShortVideoForwardManager", 1, "thumb file md5 compute fail");
      return;
    }
    blck localblck = new blck();
    int i = blcj.a(paramString1, localblck);
    if (i != 0)
    {
      QLog.e("ShortVideoForwardManager", 1, new Object[] { "video file getRotationDegree fail, code:", Integer.valueOf(i) });
      return;
    }
    i = localblck.a[0];
    int j = localblck.a[1];
    int k = localblck.a[3];
    localIntent.putExtra("file_send_size", (int)localFile.length());
    localIntent.putExtra("file_send_duration", (int)Math.round(k / 1000.0D));
    localIntent.putExtra("file_shortvideo_md5", str2);
    localIntent.putExtra("file_name", localFile.getName());
    localIntent.putExtra("file_width", i);
    localIntent.putExtra("file_height", j);
    paramString1 = new BitmapFactory.Options();
    paramString1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString2, paramString1);
    localIntent.putExtra("thumbfile_send_width", paramString1.outWidth);
    localIntent.putExtra("thumbfile_send_height", paramString1.outHeight);
    localIntent.putExtra("thumbfile_md5", str1);
    localIntent.setClass(paramActivity, ForwardRecentActivity.class);
    if (TextUtils.isEmpty(paramString3)) {
      localIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    }
    while ((paramActivity instanceof QQStoryBaseActivity))
    {
      paramString1 = paramActivity.getIntent().getStringExtra("widgetinfo");
      if (!TextUtils.isEmpty(paramString1))
      {
        localIntent.putExtra("qq_camera_scheme", bkvh.a(paramString1));
        localIntent.putExtra("qq_camera_top_title", "魔法视频");
        localIntent.putExtra("widgetinfo", paramString1);
      }
      ((QQStoryBaseActivity)paramActivity).a(localIntent, paramInt);
      return;
      localIntent.putExtra("caller_name", paramString3);
    }
    if (((paramActivity instanceof PublicFragmentActivityForPeak)) || ((paramActivity instanceof QQBrowserActivity)))
    {
      if (paramActivity.getIntent() == null) {
        paramString1 = "";
      }
      for (;;)
      {
        if (paramActivity.getIntent() == null) {
          paramString2 = "";
        }
        try
        {
          label605:
          if (paramString2.startsWith("http"))
          {
            localIntent.putExtra("widgetinfo", URLEncoder.encode(paramString2, "UTF-8"));
            localIntent.putExtra("qq_camera_scheme", bkvh.a(paramString2));
            localIntent.putExtra("qq_camera_top_title", "魔法视频");
          }
          for (;;)
          {
            paramActivity.startActivityForResult(localIntent, paramInt);
            return;
            paramString1 = paramActivity.getIntent().getStringExtra("loc_play_show_tab_name");
            break;
            paramString2 = paramActivity.getIntent().getStringExtra("loc_play_show_material_id");
            break label605;
            if ((!bbkk.a(paramString2)) && (!bbkk.a(paramString1)))
            {
              paramString1 = "play^" + paramString2 + "^" + paramString1;
              localIntent.putExtra("widgetinfo", paramString1);
              localIntent.putExtra("qq_camera_scheme", bkvh.a(paramString1));
              localIntent.putExtra("qq_camera_top_title", "魔法视频");
            }
          }
        }
        catch (UnsupportedEncodingException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramBoolean, 21, paramString3);
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    a(paramActivity, paramString, paramBoolean, false, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      QLog.e("ShortVideoForwardManager", 1, "pic file do not exist");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_filepath", paramString1);
    localIntent.putExtra("forward_thumb", paramString1);
    localIntent.putExtra("forward_urldrawable", true);
    localIntent.putExtra("forward_urldrawable_big_url", localFile.toURI().toString());
    localIntent.putExtra("forward_urldrawable_thumb_url", localFile.toURI().toString());
    localIntent.putExtra("forward_send_selfie_face", true);
    localIntent.putExtra("key_help_forward_pic", true);
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra("key_direct_jump_qzone_shuoshuo", paramBoolean1);
    localIntent.putExtra("forward_is_selfie_face", paramBoolean2);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("forward_summary_extra", "[" + paramString2 + "]");
    }
    for (;;)
    {
      if ((paramActivity != null) && (paramActivity.getIntent() != null))
      {
        paramString2 = paramActivity.getIntent().getStringExtra("widgetinfo");
        if (paramString2 != null)
        {
          localIntent.putExtra("qq_camera_scheme", bkvh.a(paramString2));
          localIntent.putExtra("qq_camera_top_title", "魔法视频");
          localIntent.putExtra("widgetinfo", paramString2);
        }
      }
      localIntent.putExtra("k_qzone", true);
      localIntent.putExtra("forward_ability_entrence_show_in_share", false);
      localIntent.putExtra("key_forward_business_id", "msg_tab_camera");
      localIntent.putExtra("filePath", paramString1);
      localIntent.putExtra("reqType", 1);
      localIntent.putExtra("source", "msgTabCamera");
      if ((!(paramActivity instanceof EditVideoActivity)) && (!(paramActivity instanceof AEStoryGIFPreviewActivity))) {
        break;
      }
      aqbe.a(paramActivity, "caller_aecamera", localIntent, 21, 100200);
      return;
      if (paramBoolean2) {
        localIntent.putExtra("forward_summary_extra", ajya.a(2131714050));
      }
    }
    aqbe.a(paramActivity, localIntent, 21, 100200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjzs
 * JD-Core Version:    0.7.0.1
 */