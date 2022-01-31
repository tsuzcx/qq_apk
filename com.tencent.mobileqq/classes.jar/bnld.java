import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
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
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;

public class bnld
{
  private static Intent a(bnkq parambnkq, boolean paramBoolean, Context paramContext)
  {
    if ((parambnkq != null) && (parambnkq.jdField_a_of_type_Boolean)) {
      return new Intent(paramContext, EditWebDanceMachineVideoActivity.class);
    }
    if (paramBoolean) {
      return new Intent(paramContext, EditWebVideoActivity.class);
    }
    return new Intent(paramContext, EditVideoActivity.class);
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
  
  public static void a(Activity paramActivity, axqw paramaxqw, bmgz parambmgz, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramaxqw, parambmgz, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, axqw paramaxqw, bmgz parambmgz, Bundle paramBundle1, int paramInt, Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambmgz == null)) {}
    bmha localbmha;
    do
    {
      return;
      localbmha = parambmgz.a();
      if (localbmha != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
    return;
    boolean bool = localbmha.a();
    int i = parambmgz.jdField_c_of_type_Int;
    int j = localbmha.c();
    int k = parambmgz.b();
    int m = localbmha.a();
    String str = localbmha.b();
    Intent localIntent = EditPicActivity.a(paramActivity, paramaxqw.jdField_a_of_type_JavaLangString, true, localbmha.jdField_c_of_type_Boolean, true, bool, true, localbmha.d(), localbmha.b(), localbmha.c(), i, k, j, false, null);
    localIntent.putExtra("edit_video_call_back", str);
    if (paramBundle2 != null) {
      localIntent.putExtras(paramBundle2);
    }
    localIntent.putExtra("qcamera_photo_filepath", paramaxqw.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("qcamera_rotate", paramaxqw.jdField_c_of_type_Int);
    localIntent.putExtra("shareto_web_mode", localbmha.jdField_a_of_type_Int);
    localIntent.putExtra("camera_type", 103);
    localIntent.putExtra("camera_front_back", m);
    localIntent.putExtra("camera_capture_method", paramaxqw.jdField_a_of_type_Int);
    localIntent.putExtra("camera_mode", localbmha.jdField_b_of_type_Int);
    localIntent.putExtra("state", paramBundle1);
    bnfi.a(parambmgz.jdField_a_of_type_Int, "", "0X8007818", null);
    paramBundle1 = localbmha.a();
    parambmgz = localIntent;
    if (paramBundle1 != null)
    {
      localIntent.putExtra("uin", paramBundle1.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", paramBundle1.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", paramBundle1.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uinname", paramBundle1.jdField_b_of_type_JavaLangString);
      parambmgz = aepi.a(localIntent, null);
    }
    parambmgz.putExtra("edit_video_way", paramInt);
    parambmgz.putExtra("sub_business_id", localbmha.d());
    paramBundle1 = SplashActivity.class.getName();
    paramBundle2 = localbmha.a();
    if ((paramBundle2 != null) && (paramBundle2.equals(ChatActivity.class.getName()))) {
      paramBundle1 = paramBundle2;
    }
    for (;;)
    {
      bnfq.a("finish");
      bnfq.a(parambmgz);
      parambmgz.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle1);
      if (paramaxqw.jdField_a_of_type_Int == 1) {
        parambmgz.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(parambmgz, 1012);
        bnfi.a("", "0X80075C1", "", "", "", "");
        return;
        if (paramaxqw.jdField_a_of_type_Int == 0) {
          parambmgz.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bmgz parambmgz, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramVideoCaptureResult, paramLocalMediaInfo, parambmgz, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bmgz parambmgz, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambmgz == null)) {}
    bmhd localbmhd;
    do
    {
      return;
      localbmhd = parambmgz.a();
      if (localbmhd != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l1 = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
    long l2;
    if ((paramActivity.getIntent() != null) && (l1 != -1L))
    {
      if ((!localbmhd.jdField_c_of_type_Boolean) || (!azki.o())) {
        break label1412;
      }
      l2 = l1 | 0x10;
      label95:
      l1 = l2;
      if (localbmhd.c()) {
        l1 = l2 | 0x0;
      }
      l2 = l1;
      if (localbmhd.a()) {
        l2 = l1 | 0x2000;
      }
      l1 = l2;
      if (localbmhd.b()) {
        l1 = l2 | 0x4000;
      }
      l2 = l1;
      if (localbmhd.e()) {
        l2 = l1 | 0x200000;
      }
      l1 = l2;
      if (parambmgz.jdField_a_of_type_Int != 10013)
      {
        l1 = l2;
        if (parambmgz.jdField_a_of_type_Int != 10012) {
          l1 = l2 | 0x0 | 0x0;
        }
      }
      l2 = l1;
      if (!localbmhd.e) {
        l2 = l1 & 0xFFFFFFFE & 0xFFFFFFFF;
      }
      long l3 = l2;
      if (parambmgz.b() == 102) {
        l3 = l2 | 0x800000;
      }
      l1 = l3;
      if (azki.l()) {
        l1 = l3 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
      }
      if (paramBundle2 != null) {
        break label1658;
      }
    }
    label418:
    label761:
    label1658:
    for (Object localObject1 = new Bundle();; localObject1 = paramBundle2)
    {
      boolean bool1;
      if (parambmgz.jdField_a_of_type_Int == 10012)
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
        ((Bundle)localObject1).putInt("qq_sub_business_id", localbmhd.b());
        ((Bundle)localObject1).putInt("entrance_type", parambmgz.jdField_b_of_type_Int);
        bool1 = localbmhd.i();
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        int k = parambmgz.jdField_c_of_type_Int;
        int m = localbmhd.c();
        wxk.b(m);
        localObject2 = ((blua)blqr.a().c(8)).a();
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
        if (parambmgz.jdField_a_of_type_Int == 10002)
        {
          l1 = l2;
          if (localbmhd.g()) {
            l1 = l2 | 0x20000;
          }
          l2 = l1;
          if (localbmhd.f()) {
            l2 = l1 | 0x4000000;
          }
          l1 = l2;
          if (localbmhd.f) {
            l1 = l2 | 0x0;
          }
          i = 0;
          if (paramBundle2 != null)
          {
            if (paramBundle2.getSerializable("extra_follow_capture_param") == null) {
              break label1517;
            }
            i = 1;
          }
          if ((!bnpo.a().b()) || (i != 0) || (!azki.p())) {
            break label1523;
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
          if (!localbmhd.d()) {
            l2 = l1 & 0xFDFFFFFF;
          }
          l1 = l2;
          if (localbmhd.h()) {
            l1 = l2 | 0x10000000;
          }
        }
        l2 = l1;
        if (localbmhd.jdField_c_of_type_Int == 5) {
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
        ((EditVideoParams)localObject1).jdField_b_of_type_Int = localbmhd.jdField_c_of_type_Int;
        ((EditVideoParams)localObject1).f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a());
        ((EditVideoParams)localObject1).a.putBoolean("enable_hw_encode", true);
        if (localbmhd.jdField_c_of_type_Int == 2) {
          ((EditVideoParams)localObject1).e = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString());
        }
        ((EditVideoParams)localObject1).a.putInt("type", localbmhd.jdField_a_of_type_Int);
        ((EditVideoParams)localObject1).a.putInt("WebSceneType", localbmhd.jdField_b_of_type_Int);
        ((EditVideoParams)localObject1).a.putString("failedUrl", localbmhd.jdField_c_of_type_JavaLangString);
        ((EditVideoParams)localObject1).a.putString("succUrl", localbmhd.jdField_b_of_type_JavaLangString);
        if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          ((EditVideoParams)localObject1).a.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
        }
        ((EditVideoParams)localObject1).a.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
        if ((bool1) && (localbmhd.a() != 0))
        {
          paramVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
          paramVideoCaptureResult.putExtra("videoId", localbmhd.a());
          l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          if (l1 != 0L) {
            ((EditVideoParams)localObject1).a.putLong("troop_uin", l1);
          }
          xsi.a(paramVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
          paramVideoCaptureResult.putExtra("short_video_entrance_type", m);
          paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          if (parambmgz.jdField_a_of_type_Int != 10012) {
            break label1601;
          }
          paramVideoCaptureResult.putExtra("op_department", "grp_tribe");
        }
        for (;;)
        {
          paramVideoCaptureResult.putExtra("op_type", "video_edit");
          paramVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
          paramVideoCaptureResult.putExtra("state", paramBundle1);
          paramVideoCaptureResult.putExtra("edit_video_way", paramInt);
          paramVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", blat.b(paramActivity.getIntent()));
          paramVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", blat.a(paramActivity.getIntent()));
          if (!(paramActivity instanceof QzoneEditVideoActivity)) {
            break label1639;
          }
          ((QzoneEditVideoActivity)paramActivity).a(paramVideoCaptureResult);
          return;
          l1 = 671088971L;
          break;
          l2 = l1 | 0x20;
          break label95;
          if (parambmgz.jdField_a_of_type_Int == 10013)
          {
            if ((paramLocalMediaInfo.mDuration <= 20000L) && (paramLocalMediaInfo.mTotalDuration <= 20000L)) {
              break label1655;
            }
            ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
            ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
            break label418;
          }
          if ((parambmgz.jdField_a_of_type_Int != 10000) && (parambmgz.jdField_a_of_type_Int != 10007) && (parambmgz.jdField_a_of_type_Int != 10004)) {
            break label1655;
          }
          l1 &= 0xFFFFFFDF;
          break label418;
          i = 0;
          break label761;
          j = 0;
          break label784;
          if ((paramBundle2 != null) && (paramBundle2.getBoolean("from_qzone_slideshow")))
          {
            paramVideoCaptureResult = new Intent(paramActivity, QzoneEditVideoActivity.class);
            paramVideoCaptureResult.putExtra("qqstory_slide_show_scene", xna.a().b());
            paramVideoCaptureResult.putExtra("qqstory_slide_show_entrance", xna.a().a());
            break label1230;
          }
          paramVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
          break label1230;
          if (parambmgz.jdField_a_of_type_Int == 10013) {
            paramVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
          } else {
            paramVideoCaptureResult.putExtra("op_department", "grp_qq");
          }
        }
        paramActivity.startActivityForResult(paramVideoCaptureResult, parambmgz.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bmgz parambmgz, Bundle paramBundle, int paramInt, bnkq parambnkq)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambmgz == null)) {}
    bmhd localbmhd;
    do
    {
      return;
      localbmhd = parambmgz.a();
      if (localbmhd != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l2 = 671088971L;
    if (localbmhd.a()) {
      l2 = 0x2800014B | 0x2000;
    }
    long l1 = l2;
    if (localbmhd.e()) {
      l1 = l2 | 0x200000;
    }
    l2 = l1;
    if (localbmhd.f()) {
      l2 = l1 | 0x4000000;
    }
    l1 = l2;
    if (localbmhd.f) {
      l1 = l2 | 0x0;
    }
    if (azki.l()) {}
    for (l2 = l1 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;; l2 = l1)
    {
      Bundle localBundle = new Bundle();
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null) {
        localBundle.putParcelable("edit_send_session_info", localSessionInfo);
      }
      localBundle.putInt("qq_sub_business_id", localbmhd.b());
      localBundle.putInt("entrance_type", parambmgz.jdField_b_of_type_Int);
      boolean bool = localbmhd.i();
      paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      int i = parambmgz.jdField_c_of_type_Int;
      int j = localbmhd.c();
      wxk.b(j);
      paramLocalMediaInfo = ((blua)blqr.a().c(8)).a();
      if (paramLocalMediaInfo != null)
      {
        l1 = l2;
        if (paramLocalMediaInfo.mType != 2) {}
      }
      else
      {
        l1 = l2 | 0x1000000;
      }
      localBundle.putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
      paramLocalMediaInfo = a(parambnkq, bool, paramActivity);
      if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebVideoActivity.class.getName()))
      {
        paramLocalMediaInfo.putExtra("videoId", localbmhd.a());
        l2 = l1;
      }
      for (;;)
      {
        paramVideoCaptureResult = new EditVideoParams(i, l2, paramVideoCaptureResult, localBundle);
        paramVideoCaptureResult.a.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramVideoCaptureResult.toString());
        }
        paramLocalMediaInfo.putExtra("edit_video_call_back", localbmhd.jdField_a_of_type_JavaLangString);
        paramVideoCaptureResult.a.putInt("type", localbmhd.jdField_a_of_type_Int);
        paramVideoCaptureResult.a.putInt("WebSceneType", localbmhd.jdField_b_of_type_Int);
        paramVideoCaptureResult.a.putString("failedUrl", localbmhd.jdField_c_of_type_JavaLangString);
        paramVideoCaptureResult.a.putString("succUrl", localbmhd.jdField_b_of_type_JavaLangString);
        l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
        if (l1 != 0L) {
          paramVideoCaptureResult.a.putLong("troop_uin", l1);
        }
        xsi.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras(), paramActivity);
        paramLocalMediaInfo.putExtra("short_video_entrance_type", j);
        paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
        paramLocalMediaInfo.putExtra("op_department", "grp_qq");
        paramLocalMediaInfo.putExtra("op_type", "video_edit");
        paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
        paramLocalMediaInfo.putExtra("state", paramBundle);
        paramLocalMediaInfo.putExtra("edit_video_way", paramInt);
        SegmentKeeper.adjustTime(0L);
        paramActivity.startActivityForResult(paramLocalMediaInfo, parambmgz.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
        l2 = l1;
        if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebDanceMachineVideoActivity.class.getName()))
        {
          localBundle.putString("dance_machine_score_rate", parambnkq.jdField_a_of_type_JavaLangString);
          localBundle.putInt("dance_machine_score", parambnkq.jdField_a_of_type_Int);
          localBundle.putString("dance_machine_ptv_category", parambnkq.jdField_b_of_type_JavaLangString);
          localBundle.putString("dance_machine_ptv_id", parambnkq.jdField_c_of_type_JavaLangString);
          localBundle.putString("web_share_url", parambnkq.g);
          localBundle.putString("over_percent", parambnkq.f);
          localBundle.putBoolean("shook_head_count", parambnkq.jdField_b_of_type_Boolean);
          localBundle.putInt("shook_head_count_value", parambnkq.jdField_b_of_type_Int);
          localBundle.putBoolean("random_fortune", parambnkq.jdField_c_of_type_Boolean);
          localBundle.putBoolean("fools_day", parambnkq.d);
          l1 &= 0xFBFFFFFF;
          if ((!parambnkq.jdField_b_of_type_Boolean) && (!parambnkq.jdField_c_of_type_Boolean))
          {
            l2 = l1;
            if (!parambnkq.d) {}
          }
          else
          {
            l2 = l1 & 0xFFFFDFFF & 0xFFDFFFFF;
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioChats&widgetinfo=" + paramString + "&cmode=all"));
    JumpActivity.a(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, bmhg parambmhg)
  {
    parambmhg = new Intent(paramActivity, SplashActivity.class);
    parambmhg.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      parambmhg.putExtra("main_tab_id", 6);
      parambmhg.putExtra("open_now_tab_fragment", true);
      parambmhg.putExtra("extra_from_share", true);
      parambmhg.setFlags(335544320);
      paramActivity.startActivity(parambmhg);
      paramActivity.overridePendingTransition(2130771981, 2130771983);
      return;
    }
    parambmhg.putExtra("main_tab_id", 1);
    parambmhg.setFlags(335544320);
    paramActivity.startActivity(parambmhg);
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioGifCameraTail&widgetinfo=" + paramString + "&cmode=singlegif"));
    JumpActivity.a(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    JumpActivity.a(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnld
 * JD-Core Version:    0.7.0.1
 */