import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.camera.BaseVideoCaptureResult;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;

public class bpnk
{
  public static Bundle a(Bundle paramBundle, String paramString)
  {
    Object localObject1 = paramBundle.getString("KEY_CURRENT_SELECT_ID");
    String str = "";
    Object localObject2 = str;
    Object localObject3 = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\^");
      paramString = str;
      if (arrayOfString.length > 0) {
        paramString = arrayOfString[0];
      }
      if (arrayOfString.length == 1)
      {
        localObject1 = arrayOfString[0];
        paramString = AECaptureMode.NORMAL.name;
      }
      if (arrayOfString.length > 1) {
        localObject1 = arrayOfString[1];
      }
      localObject2 = paramString;
      localObject3 = localObject1;
      if (arrayOfString.length > 2)
      {
        localObject3 = arrayOfString[2];
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label147;
        }
        paramBundle.putString("KEY_CURRENT_TYPE", (String)localObject1);
      }
      for (;;)
      {
        paramBundle.putString("KEY_CURRENT_TAB", bnlb.a(paramString));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramBundle.putString("KEY_CURRENT_SELECT_ID", (String)localObject2);
        }
        return paramBundle;
        label147:
        paramBundle.putString("KEY_CURRENT_TYPE", " ");
      }
      localObject1 = "";
      paramString = (String)localObject2;
      localObject2 = localObject3;
    }
  }
  
  public static String a(@Nullable String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.startsWith("mqqapi://"));
    return "mqqapi://videostory/takevideo?from=qzoneTail&widgetinfo=" + paramString + "&cmode=all";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString2 = "mqqapi://qcircle/opencamera?activity_id=circle_takesame";
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2 = "mqqapi://qcircle/opencamera?activity_id=circle_takesame" + "&tab=camera&widgetinfo=" + paramString1;
    }
    return paramString2;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    paramBundle.putInt("qq_sub_business_id", 3);
    paramBundle.putInt("entrance_type", 10001);
    paramBundle.putLong("qzone_slide_enable_mask", 99195L);
    paramBundle.putBoolean("from_qzone_slideshow", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    QLog.e("QzoneSlideShowPreparingFragment", 2, "jumpToSlideShowEditVideoActivityForQzone start!");
    PublicFragmentActivityForPeak.b(paramActivity.getApplicationContext(), localIntent, QzoneSlideShowPreparingFragment.class);
    paramActivity.overridePendingTransition(2130771997, 2130772001);
  }
  
  public static void a(Activity paramActivity, bnay parambnay, boqz paramboqz, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramboqz == null)) {}
    bora localbora;
    do
    {
      return;
      localbora = paramboqz.a();
      if (localbora != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
    return;
    boolean bool = localbora.a();
    int i = paramboqz.c;
    int j = localbora.c();
    int k = paramboqz.b();
    int m = localbora.a();
    paramboqz = localbora.b();
    Object localObject = EditPicActivity.a(paramActivity, parambnay.jdField_a_of_type_JavaLangString, true, localbora.jdField_a_of_type_Boolean, true, bool, true, false, false, false, i, k, j, false, null);
    ((Intent)localObject).putExtra("edit_video_call_back", paramboqz);
    ((Intent)localObject).putExtra("qcamera_photo_filepath", parambnay.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("qcamera_rotate", parambnay.c);
    ((Intent)localObject).putExtra("shareto_web_mode", localbora.d());
    ((Intent)localObject).putExtra("camera_type", 103);
    ((Intent)localObject).putExtra("camera_front_back", m);
    ((Intent)localObject).putExtra("camera_capture_method", parambnay.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("camera_mode", localbora.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("state", paramBundle);
    paramBundle = localbora.a();
    paramboqz = (boqz)localObject;
    if (paramBundle != null)
    {
      ((Intent)localObject).putExtra("uin", paramBundle.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", paramBundle.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("troop_uin", paramBundle.c);
      ((Intent)localObject).putExtra("uinname", paramBundle.b);
      paramboqz = AIOUtils.setOpenAIOIntent((Intent)localObject, null);
    }
    paramboqz.putExtra("edit_video_way", paramInt);
    paramboqz.putExtra("sub_business_id", localbora.e());
    paramBundle = SplashActivity.class.getName();
    localObject = localbora.a();
    if ((localObject != null) && (((String)localObject).equals(ChatActivity.class.getName()))) {
      paramBundle = (Bundle)localObject;
    }
    for (;;)
    {
      bpii.a("finish");
      bpii.a(paramboqz);
      paramboqz.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle);
      if (parambnay.jdField_a_of_type_Int == 1) {
        paramboqz.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(paramboqz, 1012);
        bpia.a("", "0X80075C1", "", "", "", "");
        return;
        if (parambnay.jdField_a_of_type_Int == 0) {
          paramboqz.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, BaseVideoCaptureResult paramBaseVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, boqz paramboqz, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramboqz == null)) {}
    bord localbord;
    do
    {
      return;
      localbord = paramboqz.a();
      if (localbord != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
    int j;
    if ((paramActivity.getIntent() != null) && (l != -1L))
    {
      i = (int)l;
      if ((!localbord.jdField_a_of_type_Boolean) || (!bddt.m())) {
        break label887;
      }
      j = i | 0x10;
      label99:
      i = j;
      if (localbord.b()) {
        i = j | 0x4000;
      }
      j = i;
      if (localbord.a()) {
        j = i | 0x200;
      }
      i = j;
      if (localbord.c()) {
        i = j | 0x100;
      }
      j = i;
      if (paramboqz.jdField_a_of_type_Int != 10013)
      {
        j = i;
        if (paramboqz.jdField_a_of_type_Int != 10012)
        {
          j = i;
          if (paramboqz.jdField_a_of_type_Int != 10007) {
            j = i | 0x1000;
          }
        }
      }
      if (localbord.c) {
        break label1129;
      }
    }
    label339:
    label1119:
    label1129:
    for (int i = j & 0xFFFFFFFE;; i = j)
    {
      if (paramBundle2 == null) {}
      for (Object localObject1 = new Bundle();; localObject1 = paramBundle2)
      {
        boolean bool1;
        boolean bool2;
        if (paramboqz.jdField_a_of_type_Int == 10012)
        {
          if ((paramLocalMediaInfo.mDuration > 20000L) || (paramLocalMediaInfo.mTotalDuration > 20000L))
          {
            ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
            ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
          }
          bool1 = ((Bundle)localObject1).getBoolean("needVideoDoodle", false);
          bool2 = ((Bundle)localObject1).getBoolean("needVideoWording", false);
          if (bool1) {
            break label1119;
          }
          i &= 0xFFFFFBFF;
        }
        for (;;)
        {
          j = i;
          if (!bool2) {
            j = i & 0xFFFFFFFE;
          }
          if (paramLocalMediaInfo.mDuration > 80000L) {
            ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
          }
          Object localObject2 = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putString("uin", ((SessionWrap)localObject2).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject1).putInt("uintype", ((SessionWrap)localObject2).jdField_a_of_type_Int);
            ((Bundle)localObject1).putString("troop_uin", ((SessionWrap)localObject2).c);
            ((Bundle)localObject1).putString("uinname", ((SessionWrap)localObject2).b);
          }
          localObject2 = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
          if (localObject2 != null) {
            ((Bundle)localObject1).putParcelable("edit_send_session_info", (Parcelable)localObject2);
          }
          ((Bundle)localObject1).putInt("qq_sub_business_id", localbord.a());
          ((Bundle)localObject1).putInt("entrance_type", paramboqz.b);
          bool1 = localbord.d();
          paramBaseVideoCaptureResult = new EditTakeVideoSource(paramBaseVideoCaptureResult.videoMp4FilePath, paramBaseVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
          i = paramboqz.c;
          int k = localbord.b();
          ykw.b(k);
          ((Bundle)localObject1).putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
          localObject1 = new EditVideoParams(i, j, paramBaseVideoCaptureResult, (Bundle)localObject1);
          ((EditVideoParams)localObject1).b = localbord.jdField_a_of_type_Int;
          ((EditVideoParams)localObject1).f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnlb.a.a());
          ((EditVideoParams)localObject1).a.putBoolean("enable_hw_encode", true);
          if (QLog.isColorLevel()) {
            QLog.d("JumpUtil", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString());
          }
          if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
            ((EditVideoParams)localObject1).a.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
          }
          ((EditVideoParams)localObject1).a.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
          if (bool1)
          {
            paramBaseVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
            l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
            if (l != 0L) {
              ((EditVideoParams)localObject1).a.putLong("troop_uin", l);
            }
            zfd.a(paramBaseVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
            paramBaseVideoCaptureResult.putExtra("edit_video_call_back", localbord.jdField_a_of_type_JavaLangString);
            paramBaseVideoCaptureResult.putExtra("short_video_entrance_type", k);
            paramBaseVideoCaptureResult.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
            if (paramboqz.jdField_a_of_type_Int != 10012) {
              break label1065;
            }
            paramBaseVideoCaptureResult.putExtra("op_department", "grp_tribe");
          }
          for (;;)
          {
            paramBaseVideoCaptureResult.putExtra("op_type", "video_edit");
            paramBaseVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
            paramBaseVideoCaptureResult.putExtra("state", paramBundle1);
            paramBaseVideoCaptureResult.putExtra("edit_video_way", paramInt);
            paramBaseVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", bnlb.b(paramActivity.getIntent()));
            paramBaseVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", bnlb.a(paramActivity.getIntent()));
            if (!(paramActivity instanceof QzoneEditVideoActivity)) {
              break label1103;
            }
            ((QzoneEditVideoActivity)paramActivity).a(paramBaseVideoCaptureResult);
            return;
            i = 1099;
            break;
            label887:
            j = i | 0x20;
            break label99;
            if (paramboqz.jdField_a_of_type_Int == 10013)
            {
              if (paramLocalMediaInfo.mDuration <= 20000L)
              {
                j = i;
                if (paramLocalMediaInfo.mTotalDuration <= 20000L) {
                  break label339;
                }
              }
              ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
              ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
              j = i;
              break label339;
            }
            if (paramboqz.jdField_a_of_type_Int != 10000)
            {
              j = i;
              if (paramboqz.jdField_a_of_type_Int != 10007) {
                break label339;
              }
            }
            j = i & 0xFFFFFFDF;
            break label339;
            if ((paramBundle2 != null) && (paramBundle2.getBoolean("from_qzone_slideshow")))
            {
              paramBaseVideoCaptureResult = new Intent(paramActivity, QzoneEditVideoActivity.class);
              paramBaseVideoCaptureResult.putExtra("qqstory_slide_show_scene", yzz.a().b());
              paramBaseVideoCaptureResult.putExtra("qqstory_slide_show_entrance", yzz.a().a());
              break label692;
            }
            paramBaseVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
            break label692;
            if (paramboqz.jdField_a_of_type_Int == 10013) {
              paramBaseVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
            } else {
              paramBaseVideoCaptureResult.putExtra("op_department", "grp_qq");
            }
          }
          paramActivity.startActivityForResult(paramBaseVideoCaptureResult, paramboqz.jdField_a_of_type_Int);
          paramActivity.overridePendingTransition(0, 0);
          return;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioChats&widgetinfo=" + paramString + "&cmode=all"));
    JumpActivity.g(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, borg paramborg)
  {
    paramborg = new Intent(paramActivity, SplashActivity.class);
    paramborg.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      paramborg.putExtra("main_tab_id", 6);
      paramborg.putExtra("open_now_tab_fragment", true);
      paramborg.putExtra("extra_from_share", true);
      paramborg.setFlags(335544320);
      paramActivity.startActivity(paramborg);
      paramActivity.overridePendingTransition(2130771981, 2130771983);
      return;
    }
    paramborg.putExtra("main_tab_id", 1);
    paramborg.setFlags(335544320);
    paramActivity.startActivity(paramborg);
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioGifCameraTail&widgetinfo=" + paramString + "&cmode=singlegif"));
    JumpActivity.g(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    JumpActivity.g(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnk
 * JD-Core Version:    0.7.0.1
 */