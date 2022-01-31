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
import dov.com.qq.im.story.SessionWrap;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;

public class bjeg
{
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return bgww.a.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
  }
  
  private static Intent a(bjdr parambjdr, boolean paramBoolean, Context paramContext)
  {
    if ((parambjdr != null) && (parambjdr.jdField_a_of_type_Boolean)) {
      return new Intent(paramContext, EditWebDanceMachineVideoActivity.class);
    }
    if (paramBoolean) {
      return new Intent(paramContext, EditWebVideoActivity.class);
    }
    return new Intent(paramContext, EditVideoActivity.class);
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
  
  public static void a(Activity paramActivity, auuy paramauuy, bhyu parambhyu, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramauuy, parambhyu, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, auuy paramauuy, bhyu parambhyu, Bundle paramBundle1, int paramInt, Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambhyu == null)) {}
    bhyv localbhyv;
    do
    {
      return;
      localbhyv = parambhyu.a();
      if (localbhyv != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
    return;
    boolean bool = localbhyv.a();
    int i = parambhyu.jdField_c_of_type_Int;
    int j = localbhyv.c();
    int k = parambhyu.c();
    int m = localbhyv.a();
    String str = localbhyv.b();
    Intent localIntent = EditPicActivity.a(paramActivity, paramauuy.jdField_a_of_type_JavaLangString, true, localbhyv.jdField_c_of_type_Boolean, true, bool, true, localbhyv.d(), localbhyv.b(), localbhyv.c(), i, k, j, false, null);
    localIntent.putExtra("edit_video_call_back", str);
    if (paramBundle2 != null) {
      localIntent.putExtras(paramBundle2);
    }
    localIntent.putExtra("qcamera_photo_filepath", paramauuy.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("qcamera_rotate", paramauuy.jdField_c_of_type_Int);
    localIntent.putExtra("shareto_web_mode", localbhyv.jdField_a_of_type_Int);
    localIntent.putExtra("camera_type", 103);
    localIntent.putExtra("camera_front_back", m);
    localIntent.putExtra("camera_capture_method", paramauuy.jdField_a_of_type_Int);
    localIntent.putExtra("camera_mode", localbhyv.jdField_b_of_type_Int);
    localIntent.putExtra("state", paramBundle1);
    biyj.a(parambhyu.jdField_a_of_type_Int, "", "0X8007818", null);
    paramBundle1 = localbhyv.a();
    parambhyu = localIntent;
    if (paramBundle1 != null)
    {
      localIntent.putExtra("uin", paramBundle1.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", paramBundle1.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", paramBundle1.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uinname", paramBundle1.jdField_b_of_type_JavaLangString);
      parambhyu = aciy.a(localIntent, null);
    }
    parambhyu.putExtra("edit_video_way", paramInt);
    parambhyu.putExtra("sub_business_id", localbhyv.d());
    paramBundle1 = SplashActivity.class.getName();
    paramBundle2 = localbhyv.a();
    if ((paramBundle2 != null) && (paramBundle2.equals(ChatActivity.class.getName()))) {
      paramBundle1 = paramBundle2;
    }
    for (;;)
    {
      biyr.a("finish");
      biyr.a(parambhyu);
      parambhyu.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle1);
      if (paramauuy.jdField_a_of_type_Int == 1) {
        parambhyu.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(parambhyu, 1012);
        biyj.a("", "0X80075C1", "", "", "", "");
        return;
        if (paramauuy.jdField_a_of_type_Int == 0) {
          parambhyu.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bhyu parambhyu, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramVideoCaptureResult, paramLocalMediaInfo, parambhyu, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bhyu parambhyu, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambhyu == null)) {}
    bhyy localbhyy;
    do
    {
      return;
      localbhyy = parambhyu.a();
      if (localbhyy != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l1 = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
    long l2;
    if ((paramActivity.getIntent() != null) && (l1 != -1L))
    {
      if ((!localbhyy.jdField_c_of_type_Boolean) || (!awll.o())) {
        break label1410;
      }
      l2 = l1 | 0x10;
      label95:
      l1 = l2;
      if (localbhyy.c()) {
        l1 = l2 | 0x0;
      }
      l2 = l1;
      if (localbhyy.a()) {
        l2 = l1 | 0x2000;
      }
      l1 = l2;
      if (localbhyy.b()) {
        l1 = l2 | 0x4000;
      }
      l2 = l1;
      if (localbhyy.e()) {
        l2 = l1 | 0x200000;
      }
      l1 = l2;
      if (parambhyu.jdField_a_of_type_Int != 10013)
      {
        l1 = l2;
        if (parambhyu.jdField_a_of_type_Int != 10012) {
          l1 = l2 | 0x0 | 0x0;
        }
      }
      l2 = l1;
      if (!localbhyy.e) {
        l2 = l1 & 0xFFFFFFFE & 0xFFFFFFFF;
      }
      long l3 = l2;
      if (parambhyu.c() == 102) {
        l3 = l2 | 0x800000;
      }
      l1 = l3;
      if (awll.l()) {
        l1 = l3 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
      }
      if (paramBundle2 != null) {
        break label1656;
      }
    }
    label418:
    label1229:
    label1515:
    label1521:
    label1653:
    label1656:
    for (Object localObject1 = new Bundle();; localObject1 = paramBundle2)
    {
      boolean bool1;
      if (parambhyu.jdField_a_of_type_Int == 10012)
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
        ((Bundle)localObject1).putInt("qq_sub_business_id", localbhyy.b());
        ((Bundle)localObject1).putInt("entrance_type", parambhyu.jdField_b_of_type_Int);
        bool1 = localbhyy.i();
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        int k = parambhyu.jdField_c_of_type_Int;
        int m = localbhyy.c();
        urq.b(m);
        localObject2 = ((bhiu)bhfm.a().c(8)).a();
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
        label761:
        int j;
        if (parambhyu.jdField_a_of_type_Int == 10002)
        {
          l1 = l2;
          if (localbhyy.g()) {
            l1 = l2 | 0x20000;
          }
          l2 = l1;
          if (localbhyy.f()) {
            l2 = l1 | 0x4000000;
          }
          l1 = l2;
          if (localbhyy.f) {
            l1 = l2 | 0x0;
          }
          i = 0;
          if (paramBundle2 != null)
          {
            if (paramBundle2.getSerializable("extra_follow_capture_param") == null) {
              break label1515;
            }
            i = 1;
          }
          if ((!bjiq.a().b()) || (i != 0) || (!awll.p())) {
            break label1521;
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
          if (!localbhyy.d()) {
            l2 = l1 & 0xFDFFFFFF;
          }
          l1 = l2;
          if (localbhyy.h()) {
            l1 = l2 | 0x10000000;
          }
        }
        l2 = l1;
        if (localbhyy.jdField_c_of_type_Int == 5) {
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
        ((EditVideoParams)localObject1).jdField_b_of_type_Int = localbhyy.jdField_c_of_type_Int;
        ((EditVideoParams)localObject1).f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
        ((EditVideoParams)localObject1).a.putBoolean("enable_hw_encode", true);
        if (localbhyy.jdField_c_of_type_Int == 2) {
          ((EditVideoParams)localObject1).e = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString());
        }
        ((EditVideoParams)localObject1).a.putInt("type", localbhyy.jdField_a_of_type_Int);
        ((EditVideoParams)localObject1).a.putInt("WebSceneType", localbhyy.jdField_b_of_type_Int);
        ((EditVideoParams)localObject1).a.putString("failedUrl", localbhyy.jdField_c_of_type_JavaLangString);
        ((EditVideoParams)localObject1).a.putString("succUrl", localbhyy.jdField_b_of_type_JavaLangString);
        if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          ((EditVideoParams)localObject1).a.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
        }
        ((EditVideoParams)localObject1).a.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
        if ((bool1) && (localbhyy.a() != 0))
        {
          paramVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
          paramVideoCaptureResult.putExtra("videoId", localbhyy.a());
          l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          if (l1 != 0L) {
            ((EditVideoParams)localObject1).a.putLong("troop_uin", l1);
          }
          vmo.a(paramVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
          paramVideoCaptureResult.putExtra("short_video_entrance_type", m);
          paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          if (parambhyu.jdField_a_of_type_Int != 10012) {
            break label1599;
          }
          paramVideoCaptureResult.putExtra("op_department", "grp_tribe");
        }
        for (;;)
        {
          paramVideoCaptureResult.putExtra("op_type", "video_edit");
          paramVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
          paramVideoCaptureResult.putExtra("state", paramBundle1);
          paramVideoCaptureResult.putExtra("edit_video_way", paramInt);
          paramVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", b(paramActivity.getIntent()));
          paramVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", a(paramActivity.getIntent()));
          if (!(paramActivity instanceof QzoneEditVideoActivity)) {
            break label1637;
          }
          ((QzoneEditVideoActivity)paramActivity).a(paramVideoCaptureResult);
          return;
          l1 = 671088971L;
          break;
          l2 = l1 | 0x20;
          break label95;
          if (parambhyu.jdField_a_of_type_Int == 10013)
          {
            if ((paramLocalMediaInfo.mDuration <= 20000L) && (paramLocalMediaInfo.mTotalDuration <= 20000L)) {
              break label1653;
            }
            ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
            ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
            break label418;
          }
          if ((parambhyu.jdField_a_of_type_Int != 10000) && (parambhyu.jdField_a_of_type_Int != 10007) && (parambhyu.jdField_a_of_type_Int != 10004)) {
            break label1653;
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
            paramVideoCaptureResult.putExtra("qqstory_slide_show_scene", vhg.a().b());
            paramVideoCaptureResult.putExtra("qqstory_slide_show_entrance", vhg.a().a());
            break label1229;
          }
          paramVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
          break label1229;
          if (parambhyu.jdField_a_of_type_Int == 10013) {
            paramVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
          } else {
            paramVideoCaptureResult.putExtra("op_department", "grp_qq");
          }
        }
        paramActivity.startActivityForResult(paramVideoCaptureResult, parambhyu.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bhyu parambhyu, Bundle paramBundle, int paramInt, bjdr parambjdr)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambhyu == null)) {}
    bhyy localbhyy;
    do
    {
      return;
      localbhyy = parambhyu.a();
      if (localbhyy != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l2 = 671088971L;
    if (localbhyy.a()) {
      l2 = 0x2800014B | 0x2000;
    }
    long l1 = l2;
    if (localbhyy.e()) {
      l1 = l2 | 0x200000;
    }
    l2 = l1;
    if (localbhyy.f()) {
      l2 = l1 | 0x4000000;
    }
    l1 = l2;
    if (localbhyy.f) {
      l1 = l2 | 0x0;
    }
    if (awll.l()) {}
    for (l2 = l1 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;; l2 = l1)
    {
      Bundle localBundle = new Bundle();
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null) {
        localBundle.putParcelable("edit_send_session_info", localSessionInfo);
      }
      localBundle.putInt("qq_sub_business_id", localbhyy.b());
      localBundle.putInt("entrance_type", parambhyu.jdField_b_of_type_Int);
      boolean bool = localbhyy.i();
      paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      int i = parambhyu.jdField_c_of_type_Int;
      int j = localbhyy.c();
      urq.b(j);
      paramLocalMediaInfo = ((bhiu)bhfm.a().c(8)).a();
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
      paramLocalMediaInfo = a(parambjdr, bool, paramActivity);
      if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebVideoActivity.class.getName()))
      {
        paramLocalMediaInfo.putExtra("videoId", localbhyy.a());
        l2 = l1;
      }
      for (;;)
      {
        paramVideoCaptureResult = new EditVideoParams(i, l2, paramVideoCaptureResult, localBundle);
        paramVideoCaptureResult.a.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramVideoCaptureResult.toString());
        }
        paramLocalMediaInfo.putExtra("edit_video_call_back", localbhyy.jdField_a_of_type_JavaLangString);
        paramVideoCaptureResult.a.putInt("type", localbhyy.jdField_a_of_type_Int);
        paramVideoCaptureResult.a.putInt("WebSceneType", localbhyy.jdField_b_of_type_Int);
        paramVideoCaptureResult.a.putString("failedUrl", localbhyy.jdField_c_of_type_JavaLangString);
        paramVideoCaptureResult.a.putString("succUrl", localbhyy.jdField_b_of_type_JavaLangString);
        l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
        if (l1 != 0L) {
          paramVideoCaptureResult.a.putLong("troop_uin", l1);
        }
        vmo.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras(), paramActivity);
        paramLocalMediaInfo.putExtra("short_video_entrance_type", j);
        paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
        paramLocalMediaInfo.putExtra("op_department", "grp_qq");
        paramLocalMediaInfo.putExtra("op_type", "video_edit");
        paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
        paramLocalMediaInfo.putExtra("state", paramBundle);
        paramLocalMediaInfo.putExtra("edit_video_way", paramInt);
        SegmentKeeper.adjustTime(0L);
        paramActivity.startActivityForResult(paramLocalMediaInfo, parambhyu.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
        l2 = l1;
        if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebDanceMachineVideoActivity.class.getName()))
        {
          localBundle.putString("dance_machine_score_rate", parambjdr.jdField_a_of_type_JavaLangString);
          localBundle.putInt("dance_machine_score", parambjdr.jdField_a_of_type_Int);
          localBundle.putString("dance_machine_ptv_category", parambjdr.jdField_b_of_type_JavaLangString);
          localBundle.putString("dance_machine_ptv_id", parambjdr.jdField_c_of_type_JavaLangString);
          localBundle.putString("web_share_url", parambjdr.g);
          localBundle.putString("over_percent", parambjdr.f);
          localBundle.putBoolean("shook_head_count", parambjdr.jdField_b_of_type_Boolean);
          localBundle.putInt("shook_head_count_value", parambjdr.jdField_b_of_type_Int);
          localBundle.putBoolean("random_fortune", parambjdr.jdField_c_of_type_Boolean);
          localBundle.putBoolean("fools_day", parambjdr.d);
          l1 &= 0xFBFFFFFF;
          if ((!parambjdr.jdField_b_of_type_Boolean) && (!parambjdr.jdField_c_of_type_Boolean))
          {
            l2 = l1;
            if (!parambjdr.d) {}
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
  
  public static void a(Activity paramActivity, boolean paramBoolean, bhzb parambhzb)
  {
    parambhzb = new Intent(paramActivity, SplashActivity.class);
    parambhzb.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      parambhzb.putExtra("main_tab_id", 6);
      parambhzb.putExtra("open_now_tab_fragment", true);
      parambhzb.putExtra("extra_from_share", true);
      parambhzb.setFlags(335544320);
      paramActivity.startActivity(parambhzb);
      paramActivity.overridePendingTransition(2130771981, 2130771983);
      return;
    }
    parambhzb.putExtra("main_tab_id", 1);
    parambhzb.setFlags(335544320);
    paramActivity.startActivity(parambhzb);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == bgww.f.a()) || (paramInt == bgww.n.a()) || (paramInt == bgww.q.a()) || (paramInt == bgww.u.a());
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    return a(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a()));
  }
  
  public static boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a()) == bgww.m.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    return (paramInt == 14) && (!c(paramIntent)) && (!d(paramIntent));
  }
  
  public static int b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 0;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0);
  }
  
  public static boolean b(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a()) == bgww.t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 100;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100);
  }
  
  public static boolean c(Intent paramIntent)
  {
    boolean bool = false;
    if ((paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 100);
  }
  
  public static boolean e(Intent paramIntent)
  {
    return (f(paramIntent)) || (g(paramIntent)) || (h(paramIntent));
  }
  
  public static boolean f(Intent paramIntent)
  {
    return (a(paramIntent)) && (n(paramIntent));
  }
  
  public static boolean g(Intent paramIntent)
  {
    return (b(paramIntent)) && (n(paramIntent));
  }
  
  public static boolean h(Intent paramIntent)
  {
    return (j(paramIntent)) && (n(paramIntent));
  }
  
  public static boolean i(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == bgww.m.a());
  }
  
  public static boolean j(Intent paramIntent)
  {
    int i = a(paramIntent);
    return (i == bgww.j.a()) || (i == bgww.k.a());
  }
  
  public static boolean k(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == bgww.d.a());
  }
  
  public static boolean l(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == bgww.v.a());
  }
  
  public static boolean m(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == bgww.w.a());
  }
  
  private static boolean n(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjeg
 * JD-Core Version:    0.7.0.1
 */