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

public class brdx
{
  private static Intent a(brdk parambrdk, boolean paramBoolean, Context paramContext)
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
        paramBundle.putString("KEY_CURRENT_TAB", born.a(paramString));
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
  
  public static void a(Activity paramActivity, bbhq parambbhq, bqaa parambqaa, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, parambbhq, parambqaa, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, bbhq parambbhq, bqaa parambqaa, Bundle paramBundle1, int paramInt, Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambqaa == null)) {}
    bqab localbqab;
    do
    {
      return;
      localbqab = parambqaa.a();
      if (localbqab != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
    return;
    boolean bool = localbqab.a();
    int i = parambqaa.jdField_c_of_type_Int;
    int j = localbqab.c();
    int k = parambqaa.b();
    int m = localbqab.a();
    String str = localbqab.b();
    Intent localIntent = EditPicActivity.a(paramActivity, parambbhq.jdField_a_of_type_JavaLangString, true, localbqab.jdField_c_of_type_Boolean, true, bool, true, localbqab.d(), localbqab.b(), localbqab.c(), i, k, j, false, null);
    localIntent.putExtra("edit_video_call_back", str);
    if (paramBundle2 != null) {
      localIntent.putExtras(paramBundle2);
    }
    localIntent.putExtra("qcamera_photo_filepath", parambbhq.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("qcamera_rotate", parambbhq.jdField_c_of_type_Int);
    localIntent.putExtra("shareto_web_mode", localbqab.jdField_a_of_type_Int);
    localIntent.putExtra("camera_type", 103);
    localIntent.putExtra("camera_front_back", m);
    localIntent.putExtra("camera_capture_method", parambbhq.jdField_a_of_type_Int);
    localIntent.putExtra("camera_mode", localbqab.jdField_b_of_type_Int);
    localIntent.putExtra("state", paramBundle1);
    bqyg.a(parambqaa.jdField_a_of_type_Int, "", "0X8007818", null);
    paramBundle1 = localbqab.a();
    parambqaa = localIntent;
    if (paramBundle1 != null)
    {
      localIntent.putExtra("uin", paramBundle1.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", paramBundle1.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", paramBundle1.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uinname", paramBundle1.jdField_b_of_type_JavaLangString);
      parambqaa = agej.a(localIntent, null);
    }
    parambqaa.putExtra("edit_video_way", paramInt);
    parambqaa.putExtra("sub_business_id", localbqab.d());
    paramBundle1 = SplashActivity.class.getName();
    paramBundle2 = localbqab.a();
    if ((paramBundle2 != null) && (paramBundle2.equals(ChatActivity.class.getName()))) {
      paramBundle1 = paramBundle2;
    }
    for (;;)
    {
      bqyo.a("finish");
      bqyo.a(parambqaa);
      parambqaa.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle1);
      if (parambbhq.jdField_a_of_type_Int == 1) {
        parambqaa.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(parambqaa, 1012);
        bqyg.a("", "0X80075C1", "", "", "", "");
        return;
        if (parambbhq.jdField_a_of_type_Int == 0) {
          parambqaa.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bqaa parambqaa, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramVideoCaptureResult, paramLocalMediaInfo, parambqaa, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bqaa parambqaa, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambqaa == null)) {}
    bqae localbqae;
    do
    {
      return;
      localbqae = parambqaa.a();
      if (localbqae != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l1 = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
    long l2;
    if ((paramActivity.getIntent() != null) && (l1 != -1L))
    {
      if ((!localbqae.jdField_c_of_type_Boolean) || (!bddz.o())) {
        break label1419;
      }
      l2 = l1 | 0x10;
      label95:
      l1 = l2;
      if (localbqae.c()) {
        l1 = l2 | 0x0;
      }
      l2 = l1;
      if (localbqae.a()) {
        l2 = l1 | 0x2000;
      }
      l1 = l2;
      if (localbqae.b()) {
        l1 = l2 | 0x4000;
      }
      l2 = l1;
      if (localbqae.e()) {
        l2 = l1 | 0x200000;
      }
      l1 = l2;
      if (parambqaa.jdField_a_of_type_Int != 10013)
      {
        l1 = l2;
        if (parambqaa.jdField_a_of_type_Int != 10012) {
          l1 = l2 | 0x0 | 0x0;
        }
      }
      l2 = l1;
      if (!localbqae.e) {
        l2 = l1 & 0xFFFFFFFE & 0xFFFFFFFF;
      }
      long l3 = l2;
      if (parambqaa.b() == 102) {
        l3 = l2 | 0x800000;
      }
      l1 = l3;
      if (bddz.l()) {
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
      if (parambqaa.jdField_a_of_type_Int == 10012)
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
        ((Bundle)localObject1).putInt("qq_sub_business_id", localbqae.b());
        ((Bundle)localObject1).putInt("entrance_type", parambqaa.jdField_b_of_type_Int);
        bool1 = localbqae.i();
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        int k = parambqaa.jdField_c_of_type_Int;
        int m = localbqae.c();
        yuq.b(m);
        localObject2 = ((bpoz)bplq.a().c(8)).a();
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
        if (parambqaa.jdField_a_of_type_Int == 10002)
        {
          l1 = l2;
          if (localbqae.g()) {
            l1 = l2 | 0x20000;
          }
          l2 = l1;
          if (localbqae.f()) {
            l2 = l1 | 0x4000000;
          }
          l1 = l2;
          if (localbqae.f) {
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
          if ((!brhq.a().b()) || (i != 0) || (!bddz.p())) {
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
          if (!localbqae.d()) {
            l2 = l1 & 0xFDFFFFFF;
          }
          l1 = l2;
          if (localbqae.h()) {
            l1 = l2 | 0x10000000;
          }
        }
        l2 = l1;
        if (localbqae.jdField_c_of_type_Int == 5) {
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
        ((EditVideoParams)localObject1).jdField_b_of_type_Int = localbqae.jdField_c_of_type_Int;
        ((EditVideoParams)localObject1).f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a());
        ((EditVideoParams)localObject1).a.putBoolean("enable_hw_encode", true);
        if (localbqae.jdField_c_of_type_Int == 2) {
          ((EditVideoParams)localObject1).e = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString());
        }
        ((EditVideoParams)localObject1).a.putInt("type", localbqae.jdField_a_of_type_Int);
        ((EditVideoParams)localObject1).a.putInt("WebSceneType", localbqae.jdField_b_of_type_Int);
        ((EditVideoParams)localObject1).a.putString("failedUrl", localbqae.jdField_c_of_type_JavaLangString);
        ((EditVideoParams)localObject1).a.putString("succUrl", localbqae.jdField_b_of_type_JavaLangString);
        if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          ((EditVideoParams)localObject1).a.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
        }
        ((EditVideoParams)localObject1).a.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
        if ((bool1) && (localbqae.a() != 0))
        {
          paramVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
          paramVideoCaptureResult.putExtra("videoId", localbqae.a());
          l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          if (l1 != 0L) {
            ((EditVideoParams)localObject1).a.putLong("troop_uin", l1);
          }
          zpo.a(paramVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
          paramVideoCaptureResult.putExtra("short_video_entrance_type", m);
          paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          if (parambqaa.jdField_a_of_type_Int != 10012) {
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
          paramVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", born.b(paramActivity.getIntent()));
          paramVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", born.a(paramActivity.getIntent()));
          if (!(paramActivity instanceof QzoneEditVideoActivity)) {
            break label1646;
          }
          ((QzoneEditVideoActivity)paramActivity).a(paramVideoCaptureResult);
          return;
          l1 = 671088971L;
          break;
          l2 = l1 | 0x20;
          break label95;
          if (parambqaa.jdField_a_of_type_Int == 10013)
          {
            if ((paramLocalMediaInfo.mDuration <= 20000L) && (paramLocalMediaInfo.mTotalDuration <= 20000L)) {
              break label1662;
            }
            ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
            ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
            break label418;
          }
          if ((parambqaa.jdField_a_of_type_Int != 10000) && (parambqaa.jdField_a_of_type_Int != 10007) && (parambqaa.jdField_a_of_type_Int != 10004)) {
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
            paramVideoCaptureResult.putExtra("qqstory_slide_show_scene", zkg.a().b());
            paramVideoCaptureResult.putExtra("qqstory_slide_show_entrance", zkg.a().a());
            break label1234;
          }
          paramVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
          break label1234;
          if (parambqaa.jdField_a_of_type_Int == 10013) {
            paramVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
          } else {
            paramVideoCaptureResult.putExtra("op_department", "grp_qq");
          }
        }
        paramActivity.startActivityForResult(paramVideoCaptureResult, parambqaa.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bqaa parambqaa, Bundle paramBundle, int paramInt, brdk parambrdk)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (parambqaa == null)) {}
    bqae localbqae;
    do
    {
      return;
      localbqae = parambqaa.a();
      if (localbqae != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l2 = 671088971L;
    if (localbqae.a()) {
      l2 = 0x2800014B | 0x2000;
    }
    long l1 = l2;
    if (localbqae.e()) {
      l1 = l2 | 0x200000;
    }
    l2 = l1;
    if (localbqae.f()) {
      l2 = l1 | 0x4000000;
    }
    l1 = l2;
    if (localbqae.f) {
      l1 = l2 | 0x0;
    }
    if (bddz.l()) {
      l1 = l1 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null) {
        localBundle.putParcelable("edit_send_session_info", localSessionInfo);
      }
      localBundle.putInt("qq_sub_business_id", localbqae.b());
      localBundle.putInt("entrance_type", parambqaa.jdField_b_of_type_Int);
      boolean bool = localbqae.i();
      paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      int i = parambqaa.jdField_c_of_type_Int;
      int j = localbqae.c();
      yuq.b(j);
      paramLocalMediaInfo = ((bpoz)bplq.a().c(8)).a();
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
      paramLocalMediaInfo = a(parambrdk, bool, paramActivity);
      if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebVideoActivity.class.getName())) {
        paramLocalMediaInfo.putExtra("videoId", localbqae.a());
      }
      paramVideoCaptureResult = new EditVideoParams(i, l2, paramVideoCaptureResult, localBundle);
      paramVideoCaptureResult.a.putBoolean("enable_hw_encode", true);
      if (QLog.isColorLevel()) {
        QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramVideoCaptureResult.toString());
      }
      paramLocalMediaInfo.putExtra("edit_video_call_back", localbqae.jdField_a_of_type_JavaLangString);
      paramVideoCaptureResult.a.putInt("type", localbqae.jdField_a_of_type_Int);
      paramVideoCaptureResult.a.putInt("WebSceneType", localbqae.jdField_b_of_type_Int);
      paramVideoCaptureResult.a.putString("failedUrl", localbqae.jdField_c_of_type_JavaLangString);
      paramVideoCaptureResult.a.putString("succUrl", localbqae.jdField_b_of_type_JavaLangString);
      l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
      if (l1 != 0L) {
        paramVideoCaptureResult.a.putLong("troop_uin", l1);
      }
      zpo.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras(), paramActivity);
      paramLocalMediaInfo.putExtra("short_video_entrance_type", j);
      paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
      paramLocalMediaInfo.putExtra("op_department", "grp_qq");
      paramLocalMediaInfo.putExtra("op_type", "video_edit");
      paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
      paramLocalMediaInfo.putExtra("state", paramBundle);
      paramLocalMediaInfo.putExtra("edit_video_way", paramInt);
      SegmentKeeper.adjustTime(0L);
      paramActivity.startActivityForResult(paramLocalMediaInfo, parambqaa.jdField_a_of_type_Int);
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
  
  public static void a(Activity paramActivity, boolean paramBoolean, bqah parambqah)
  {
    parambqah = new Intent(paramActivity, SplashActivity.class);
    parambqah.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      parambqah.putExtra("main_tab_id", 6);
      parambqah.putExtra("open_now_tab_fragment", true);
      parambqah.putExtra("extra_from_share", true);
      parambqah.setFlags(335544320);
      paramActivity.startActivity(parambqah);
      paramActivity.overridePendingTransition(2130771981, 2130771983);
      return;
    }
    parambqah.putExtra("main_tab_id", 1);
    parambqah.setFlags(335544320);
    paramActivity.startActivity(parambqah);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brdx
 * JD-Core Version:    0.7.0.1
 */