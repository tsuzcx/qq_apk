import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;

public class bqcc
{
  private static Intent a(bqbp parambqbp, boolean paramBoolean, Context paramContext)
  {
    if (paramBoolean) {
      return new Intent(paramContext, EditWebVideoActivity.class);
    }
    return new Intent(paramContext, EditVideoActivity.class);
  }
  
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
        paramBundle.putString("KEY_CURRENT_TAB", bnqb.a(paramString));
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
    paramBundle.putLong("qzone_slide_enable_mask", 3848427020667L);
    paramBundle.putBoolean("from_qzone_slideshow", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    QLog.e("QzoneSlideShowPreparingFragment", 2, "jumpToSlideShowEditVideoActivityForQzone start!");
    PublicFragmentActivityForPeak.b(paramActivity.getApplicationContext(), localIntent, QzoneSlideShowPreparingFragment.class);
    paramActivity.overridePendingTransition(2130771997, 2130772001);
  }
  
  public static void a(Activity paramActivity, baox parambaox, boyf paramboyf, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, parambaox, paramboyf, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, baox parambaox, boyf paramboyf, Bundle paramBundle1, int paramInt, Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramboyf == null)) {}
    boyg localboyg;
    do
    {
      return;
      localboyg = paramboyf.a();
      if (localboyg != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
    return;
    boolean bool = localboyg.a();
    int i = paramboyf.jdField_c_of_type_Int;
    int j = localboyg.c();
    int k = paramboyf.b();
    int m = localboyg.a();
    String str = localboyg.b();
    Intent localIntent = EditPicActivity.a(paramActivity, parambaox.jdField_a_of_type_JavaLangString, true, localboyg.jdField_c_of_type_Boolean, true, bool, true, localboyg.d(), localboyg.b(), localboyg.c(), i, k, j, false, null);
    localIntent.putExtra("edit_video_call_back", str);
    if (paramBundle2 != null) {
      localIntent.putExtras(paramBundle2);
    }
    localIntent.putExtra("qcamera_photo_filepath", parambaox.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("qcamera_rotate", parambaox.jdField_c_of_type_Int);
    localIntent.putExtra("shareto_web_mode", localboyg.jdField_a_of_type_Int);
    localIntent.putExtra("camera_type", 103);
    localIntent.putExtra("camera_front_back", m);
    localIntent.putExtra("camera_capture_method", parambaox.jdField_a_of_type_Int);
    localIntent.putExtra("camera_mode", localboyg.jdField_b_of_type_Int);
    localIntent.putExtra("state", paramBundle1);
    bpwl.a(paramboyf.jdField_a_of_type_Int, "", "0X8007818", null);
    paramBundle1 = localboyg.a();
    paramboyf = localIntent;
    if (paramBundle1 != null)
    {
      localIntent.putExtra("uin", paramBundle1.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", paramBundle1.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", paramBundle1.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uinname", paramBundle1.jdField_b_of_type_JavaLangString);
      paramboyf = afur.a(localIntent, null);
    }
    paramboyf.putExtra("edit_video_way", paramInt);
    paramboyf.putExtra("sub_business_id", localboyg.d());
    paramBundle1 = SplashActivity.class.getName();
    paramBundle2 = localboyg.a();
    if ((paramBundle2 != null) && (paramBundle2.equals(ChatActivity.class.getName()))) {
      paramBundle1 = paramBundle2;
    }
    for (;;)
    {
      bpwt.a("finish");
      bpwt.a(paramboyf);
      paramboyf.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle1);
      if (parambaox.jdField_a_of_type_Int == 1) {
        paramboyf.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(paramboyf, 1012);
        bpwl.a("", "0X80075C1", "", "", "", "");
        return;
        if (parambaox.jdField_a_of_type_Int == 0) {
          paramboyf.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, boyf paramboyf, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramVideoCaptureResult, paramLocalMediaInfo, paramboyf, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, boyf paramboyf, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramboyf == null)) {}
    boyj localboyj;
    do
    {
      return;
      localboyj = paramboyf.a();
      if (localboyj != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l1 = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
    long l2;
    if ((paramActivity.getIntent() != null) && (l1 != -1L))
    {
      if ((!localboyj.jdField_c_of_type_Boolean) || (!bclh.o())) {
        break label1419;
      }
      l2 = l1 | 0x10;
      label95:
      l1 = l2;
      if (localboyj.c()) {
        l1 = l2 | 0x0;
      }
      l2 = l1;
      if (localboyj.a()) {
        l2 = l1 | 0x2000;
      }
      l1 = l2;
      if (localboyj.b()) {
        l1 = l2 | 0x4000;
      }
      l2 = l1;
      if (localboyj.e()) {
        l2 = l1 | 0x200000;
      }
      l1 = l2;
      if (paramboyf.jdField_a_of_type_Int != 10013)
      {
        l1 = l2;
        if (paramboyf.jdField_a_of_type_Int != 10012) {
          l1 = l2 | 0x0 | 0x0;
        }
      }
      l2 = l1;
      if (!localboyj.e) {
        l2 = l1 & 0xFFFFFFFE & 0xFFFFFFFF;
      }
      long l3 = l2;
      if (paramboyf.b() == 102) {
        l3 = l2 | 0x800000;
      }
      l1 = l3;
      if (bclh.l()) {
        l1 = l3 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
      }
      if (paramBundle2 != null) {
        break label1665;
      }
    }
    label418:
    label1234:
    label1524:
    label1530:
    for (Object localObject1 = new Bundle();; localObject1 = paramBundle2)
    {
      boolean bool1;
      if (paramboyf.jdField_a_of_type_Int == 10012)
      {
        if ((paramLocalMediaInfo.mDuration > 20000L) || (paramLocalMediaInfo.mTotalDuration > 20000L))
        {
          ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
          ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
        }
        bool1 = ((Bundle)localObject1).getBoolean("needVideoDoodle", false);
        boolean bool2 = ((Bundle)localObject1).getBoolean("needVideoWording", false);
        l2 = l1;
        if (!bool1) {
          l2 = l1 & 0xDFFFFFFF;
        }
        l1 = l2;
        if (!bool2) {
          l1 = l2 & 0xFFFFFFFE & 0xFFFFFFFF;
        }
      }
      label765:
      label1662:
      for (;;)
      {
        if (paramLocalMediaInfo.mDuration > 80000L) {
          ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
        }
        Object localObject2 = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
        if (localObject2 != null)
        {
          ((Bundle)localObject1).putString("uin", ((SessionWrap)localObject2).jdField_a_of_type_JavaLangString);
          ((Bundle)localObject1).putInt("uintype", ((SessionWrap)localObject2).jdField_a_of_type_Int);
          ((Bundle)localObject1).putString("troop_uin", ((SessionWrap)localObject2).jdField_c_of_type_JavaLangString);
          ((Bundle)localObject1).putString("uinname", ((SessionWrap)localObject2).jdField_b_of_type_JavaLangString);
        }
        localObject2 = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (localObject2 != null) {
          ((Bundle)localObject1).putParcelable("edit_send_session_info", (Parcelable)localObject2);
        }
        ((Bundle)localObject1).putInt("qq_sub_business_id", localboyj.b());
        ((Bundle)localObject1).putInt("entrance_type", paramboyf.jdField_b_of_type_Int);
        bool1 = localboyj.i();
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        int k = paramboyf.jdField_c_of_type_Int;
        int m = localboyj.c();
        yqv.b(m);
        localObject2 = ((bone)bojv.a().c(8)).a();
        if (localObject2 != null)
        {
          l2 = l1;
          if (((MusicItemInfo)localObject2).mType != 2) {}
        }
        else
        {
          l2 = l1 | 0x1000000;
        }
        ((Bundle)localObject1).putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
        SegmentKeeper.adjustTime(0L);
        l1 = l2;
        int i;
        int j;
        if (paramboyf.jdField_a_of_type_Int == 10002)
        {
          l1 = l2;
          if (localboyj.g()) {
            l1 = l2 | 0x20000;
          }
          l2 = l1;
          if (localboyj.f()) {
            l2 = l1 | 0x4000000;
          }
          l1 = l2;
          if (localboyj.f) {
            l1 = l2 | 0x0;
          }
          i = 0;
          if (paramBundle2 != null)
          {
            if (paramBundle2.getSerializable("extra_follow_capture_param") == null) {
              break label1524;
            }
            i = 1;
          }
          if ((!bqgf.a().b()) || (i != 0) || (!bclh.p())) {
            break label1530;
          }
          j = 1;
          l2 = l1;
          if (j != 0) {
            l2 = l1 | 0x0;
          }
          l1 = l2;
          if (i != 0) {
            l1 = l2 & 0xFFFFFFEF;
          }
          l2 = l1 | 0x2000000;
          l1 = l2;
          if (paramBundle2 != null)
          {
            localObject2 = (FollowCaptureParam)paramBundle2.getSerializable("extra_follow_capture_param");
            l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (!((FollowCaptureParam)localObject2).showLink) {
                l1 = l2 & 0xFDFFFFFF;
              }
            }
          }
          l2 = l1;
          if (!localboyj.d()) {
            l2 = l1 & 0xFDFFFFFF;
          }
          l1 = l2;
          if (localboyj.h()) {
            l1 = l2 | 0x10000000;
          }
        }
        l2 = l1;
        if (localboyj.jdField_c_of_type_Int == 5) {
          l2 = l1 & 0xFFFFFFDF & 0xFFFFFFFF;
        }
        l1 = l2;
        if (paramBundle1 != null)
        {
          l1 = l2;
          if (paramBundle1.getBoolean("qa_mode", false)) {
            l1 = l2 & 0xFFFFFFEF & 0xFFFFFFFF;
          }
        }
        localObject1 = new EditVideoParams(k, l1, paramVideoCaptureResult, (Bundle)localObject1);
        ((EditVideoParams)localObject1).jdField_b_of_type_Int = localboyj.jdField_c_of_type_Int;
        ((EditVideoParams)localObject1).f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnqb.a.a());
        ((EditVideoParams)localObject1).a.putBoolean("enable_hw_encode", true);
        if (localboyj.jdField_c_of_type_Int == 2) {
          ((EditVideoParams)localObject1).e = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString());
        }
        ((EditVideoParams)localObject1).a.putInt("type", localboyj.jdField_a_of_type_Int);
        ((EditVideoParams)localObject1).a.putInt("WebSceneType", localboyj.jdField_b_of_type_Int);
        ((EditVideoParams)localObject1).a.putString("failedUrl", localboyj.jdField_c_of_type_JavaLangString);
        ((EditVideoParams)localObject1).a.putString("succUrl", localboyj.jdField_b_of_type_JavaLangString);
        if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          ((EditVideoParams)localObject1).a.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
        }
        ((EditVideoParams)localObject1).a.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
        if ((bool1) && (localboyj.a() != 0))
        {
          paramVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
          paramVideoCaptureResult.putExtra("videoId", localboyj.a());
          l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          if (l1 != 0L) {
            ((EditVideoParams)localObject1).a.putLong("troop_uin", l1);
          }
          zlt.a(paramVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
          paramVideoCaptureResult.putExtra("short_video_entrance_type", m);
          paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          if (paramboyf.jdField_a_of_type_Int != 10012) {
            break label1608;
          }
          paramVideoCaptureResult.putExtra("op_department", "grp_tribe");
        }
        for (;;)
        {
          paramVideoCaptureResult.putExtra("op_type", "video_edit");
          paramVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
          paramVideoCaptureResult.putExtra("state", paramBundle1);
          paramVideoCaptureResult.putExtra("edit_video_way", paramInt);
          paramVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", bnqb.b(paramActivity.getIntent()));
          paramVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", bnqb.a(paramActivity.getIntent()));
          if (!(paramActivity instanceof QzoneEditVideoActivity)) {
            break label1646;
          }
          ((QzoneEditVideoActivity)paramActivity).a(paramVideoCaptureResult);
          return;
          l1 = 671088971L;
          break;
          l2 = l1 | 0x20;
          break label95;
          if (paramboyf.jdField_a_of_type_Int == 10013)
          {
            if ((paramLocalMediaInfo.mDuration <= 20000L) && (paramLocalMediaInfo.mTotalDuration <= 20000L)) {
              break label1662;
            }
            ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
            ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
            break label418;
          }
          if ((paramboyf.jdField_a_of_type_Int != 10000) && (paramboyf.jdField_a_of_type_Int != 10007) && (paramboyf.jdField_a_of_type_Int != 10004)) {
            break label1662;
          }
          l1 &= 0xFFFFFFDF;
          break label418;
          i = 0;
          break label765;
          j = 0;
          break label788;
          if ((paramBundle2 != null) && (paramBundle2.getBoolean("from_qzone_slideshow")))
          {
            paramVideoCaptureResult = new Intent(paramActivity, QzoneEditVideoActivity.class);
            paramVideoCaptureResult.putExtra("qqstory_slide_show_scene", zgl.a().b());
            paramVideoCaptureResult.putExtra("qqstory_slide_show_entrance", zgl.a().a());
            break label1234;
          }
          paramVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
          break label1234;
          if (paramboyf.jdField_a_of_type_Int == 10013) {
            paramVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
          } else {
            paramVideoCaptureResult.putExtra("op_department", "grp_qq");
          }
        }
        paramActivity.startActivityForResult(paramVideoCaptureResult, paramboyf.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, boyf paramboyf, Bundle paramBundle, int paramInt, bqbp parambqbp)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramboyf == null)) {}
    boyj localboyj;
    do
    {
      return;
      localboyj = paramboyf.a();
      if (localboyj != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l2 = 671088971L;
    if (localboyj.a()) {
      l2 = 0x2800014B | 0x2000;
    }
    long l1 = l2;
    if (localboyj.e()) {
      l1 = l2 | 0x200000;
    }
    l2 = l1;
    if (localboyj.f()) {
      l2 = l1 | 0x4000000;
    }
    l1 = l2;
    if (localboyj.f) {
      l1 = l2 | 0x0;
    }
    if (bclh.l()) {
      l1 = l1 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null) {
        localBundle.putParcelable("edit_send_session_info", localSessionInfo);
      }
      localBundle.putInt("qq_sub_business_id", localboyj.b());
      localBundle.putInt("entrance_type", paramboyf.jdField_b_of_type_Int);
      boolean bool = localboyj.i();
      paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      int i = paramboyf.jdField_c_of_type_Int;
      int j = localboyj.c();
      yqv.b(j);
      paramLocalMediaInfo = ((bone)bojv.a().c(8)).a();
      if (paramLocalMediaInfo != null)
      {
        l2 = l1;
        if (paramLocalMediaInfo.mType != 2) {}
      }
      else
      {
        l2 = l1 | 0x1000000;
      }
      localBundle.putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
      paramLocalMediaInfo = a(parambqbp, bool, paramActivity);
      if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebVideoActivity.class.getName())) {
        paramLocalMediaInfo.putExtra("videoId", localboyj.a());
      }
      paramVideoCaptureResult = new EditVideoParams(i, l2, paramVideoCaptureResult, localBundle);
      paramVideoCaptureResult.a.putBoolean("enable_hw_encode", true);
      if (QLog.isColorLevel()) {
        QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramVideoCaptureResult.toString());
      }
      paramLocalMediaInfo.putExtra("edit_video_call_back", localboyj.jdField_a_of_type_JavaLangString);
      paramVideoCaptureResult.a.putInt("type", localboyj.jdField_a_of_type_Int);
      paramVideoCaptureResult.a.putInt("WebSceneType", localboyj.jdField_b_of_type_Int);
      paramVideoCaptureResult.a.putString("failedUrl", localboyj.jdField_c_of_type_JavaLangString);
      paramVideoCaptureResult.a.putString("succUrl", localboyj.jdField_b_of_type_JavaLangString);
      l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
      if (l1 != 0L) {
        paramVideoCaptureResult.a.putLong("troop_uin", l1);
      }
      zlt.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras(), paramActivity);
      paramLocalMediaInfo.putExtra("short_video_entrance_type", j);
      paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
      paramLocalMediaInfo.putExtra("op_department", "grp_qq");
      paramLocalMediaInfo.putExtra("op_type", "video_edit");
      paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
      paramLocalMediaInfo.putExtra("state", paramBundle);
      paramLocalMediaInfo.putExtra("edit_video_way", paramInt);
      SegmentKeeper.adjustTime(0L);
      paramActivity.startActivityForResult(paramLocalMediaInfo, paramboyf.jdField_a_of_type_Int);
      paramActivity.overridePendingTransition(0, 0);
      return;
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
  
  public static void a(Activity paramActivity, boolean paramBoolean, boym paramboym)
  {
    paramboym = new Intent(paramActivity, SplashActivity.class);
    paramboym.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      paramboym.putExtra("main_tab_id", 6);
      paramboym.putExtra("open_now_tab_fragment", true);
      paramboym.putExtra("extra_from_share", true);
      paramboym.setFlags(335544320);
      paramActivity.startActivity(paramboym);
      paramActivity.overridePendingTransition(2130771981, 2130771983);
      return;
    }
    paramboym.putExtra("main_tab_id", 1);
    paramboym.setFlags(335544320);
    paramActivity.startActivity(paramboym);
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
 * Qualified Name:     bqcc
 * JD-Core Version:    0.7.0.1
 */