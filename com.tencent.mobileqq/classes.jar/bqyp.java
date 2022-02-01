import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.component.media.MediaFile;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.cropvideo.CropVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback.1;
import java.io.File;
import org.json.JSONObject;

public class bqyp
{
  public static float a;
  public static int a;
  public static Bitmap a;
  public static float b;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  
  static
  {
    jdField_a_of_type_Int = 419430400;
    jdField_b_of_type_Int = 240;
    c = 180000;
    d = 2000;
    e = 12002200;
    f = 20971520;
    g = 240;
    jdField_a_of_type_Float = e / 10000 / 1000.0F;
    jdField_b_of_type_Float = e % 10000 / 1000.0F;
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    if (paramActivity.getIntent().hasExtra("extra_upload_temp_directory")) {
      return paramActivity.getIntent().getStringExtra("extra_upload_temp_directory");
    }
    String str = bqut.a(paramInt);
    paramActivity.getIntent().putExtra("extra_upload_temp_directory", str);
    return str;
  }
  
  public static String a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.fileSize + "|" + paramLocalMediaInfo.mediaWidth + "|" + paramLocalMediaInfo.mediaHeight + "|" + paramLocalMediaInfo.mDuration + "," + paramLocalMediaInfo.mMimeType + "," + paramLocalMediaInfo.rotation;
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6)
  {
    a(paramActivity, paramString1, paramLocalMediaInfo, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramBoolean, paramInt6, 1);
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6, int paramInt7)
  {
    a(paramActivity, paramString1, paramLocalMediaInfo, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramBoolean, paramInt6, paramInt7, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6, int paramInt7, Bundle paramBundle)
  {
    int i;
    long l1;
    long l2;
    long l3;
    for (;;)
    {
      Object localObject;
      boolean bool2;
      boolean bool1;
      try
      {
        Bundle localBundle2 = new Bundle();
        i = paramInt7;
        if (paramInt4 == 10002) {
          break label1795;
        }
        i = paramInt7;
        if (paramInt4 == 10012) {
          break label1795;
        }
        i = paramInt7;
        if (paramInt4 == 10013) {
          break label1795;
        }
        i = paramInt7;
        if (paramInt4 == 10023) {
          break label1795;
        }
        paramInt7 = 2;
        if (paramInt4 == 10004)
        {
          localBundle2.putInt("qq_sub_business_id", 101);
          paramInt7 = 2;
          localBundle2.putString("extra_upload_temp_directory", a(paramActivity, paramInt7));
          localBundle2.putInt("entrance_type", paramInt3);
          localBundle2.putString("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
          long l4 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          l1 = 538968427L;
          if (!paramLocalMediaInfo.mMimeType.contains("video")) {
            break label1295;
          }
          if ((TextUtils.isEmpty(paramLocalMediaInfo.path)) || (paramLocalMediaInfo.path.equalsIgnoreCase("null")))
          {
            localObject = new EditLocalVideoSource(paramString1, paramLocalMediaInfo, paramInt1, paramInt2);
            i = paramInt2 - paramInt1;
            paramInt2 = 1;
            paramInt1 = paramInt2;
            if (paramInt7 != 11)
            {
              paramInt1 = paramInt2;
              if (paramInt7 != 12)
              {
                paramInt1 = paramInt2;
                if (i / 10000.0F > 1.0F)
                {
                  paramInt2 = i / 10000;
                  paramInt1 = paramInt2;
                  if (i % 10000 >= 1000) {
                    paramInt1 = paramInt2 + 1;
                  }
                }
              }
            }
            localBundle2.putInt("expect_fragment_count", paramInt1);
            l2 = l1;
            if (paramInt1 > 1) {
              break label1503;
            }
            l2 = 0x2020016B & 0xFFFBFFFF;
            break label1503;
            l2 = l1 & 0xFFDFFFFF | 0x8000000 | 0x0 | 0x2000000;
            l1 = l2;
            if (paramInt7 == 11)
            {
              bool2 = false;
              bool1 = false;
              localObject = bfek.a(paramActivity.getIntent().getExtras());
              if (localObject == null) {
                break label1531;
              }
              bool2 = ((JSONObject)localObject).optBoolean("needVideoDoodle", false);
              bool1 = ((JSONObject)localObject).optBoolean("needVideoWording", false);
              break label1531;
            }
            l3 = l1;
            if (paramInt7 != 12) {
              break label1601;
            }
            l2 = l1 & 0xFBFFFFFF & 0xFFFDFFFF & 0xFFEFFFFF;
            bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
            bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
            l1 = l2;
            if (bool1) {
              break label1576;
            }
            l1 = l2 & 0xDFFFFFFF;
            break label1576;
            l1 = l3 | 0x10000000 | 0x4000000;
            if (TextUtils.isEmpty(paramString2)) {
              break label1824;
            }
            l1 |= 0x800000;
            label459:
            if ((!brhq.a().b()) || (!bddz.p())) {
              break label1835;
            }
            paramInt1 = 1;
            break;
            label479:
            l1 = l2;
            if (bddz.l()) {
              l1 = l2 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
            }
            if (paramInt7 == 11) {
              localBundle2.putAll(paramActivity.getIntent().getExtras());
            }
            paramInt2 = 0;
            paramInt3 = 0;
            l2 = l1;
            if (paramInt7 != 1) {
              break label1493;
            }
            localObject = null;
            paramInt1 = paramInt3;
            if (paramActivity.getIntent() != null)
            {
              Bundle localBundle1 = paramActivity.getIntent().getExtras();
              paramInt1 = paramInt3;
              localObject = localBundle1;
              if (localBundle1 != null)
              {
                paramInt1 = localBundle1.getInt("extra_edit_video_from");
                localObject = localBundle1;
              }
            }
            l1 |= 0x0;
            paramInt2 = paramInt1;
            l2 = l1;
            if (!paramActivity.getIntent().getBooleanExtra("is_video_forward", false)) {
              break label1493;
            }
            if (localObject == null) {
              break label1734;
            }
            localBundle2.putAll((Bundle)localObject);
            break label1734;
            label639:
            if (born.a(paramActivity.getIntent(), paramInt7)) {
              break label1757;
            }
            if (!born.c(paramActivity.getIntent())) {
              break label1764;
            }
            break label1757;
            label664:
            paramString1 = new EditVideoParams(paramInt7, l2, paramString1, localBundle2);
            paramString1.e = paramInt1;
            paramString1.f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a());
            if (paramActivity.getIntent().getBooleanExtra("is_video_forward", false)) {
              paramString1.e = 4;
            }
            if (l4 != 0L) {
              paramString1.a.putLong("troop_uin", l4);
            }
            if (paramInt7 != 1) {
              break label1386;
            }
            if ((paramLocalMediaInfo.rotation != 90) && (paramLocalMediaInfo.rotation != 270)) {
              break label1369;
            }
            paramInt1 = paramLocalMediaInfo.mediaHeight;
            if ((paramLocalMediaInfo.rotation != 90) && (paramLocalMediaInfo.rotation != 270)) {
              break label1377;
            }
            paramInt2 = paramLocalMediaInfo.mediaWidth;
            if ((paramInt1 / paramInt2 >= bdep.jdField_a_of_type_Int / bdep.jdField_b_of_type_Int) && (!paramActivity.getIntent().getBooleanExtra("is_video_forward", false)))
            {
              paramString1.a.putBoolean("extra_is_fit_center", true);
              if (zqb.a(paramInt1, paramInt2, bdep.jdField_a_of_type_Int, bdep.jdField_b_of_type_Int)) {
                paramString1.a.putBoolean("extra_is_need_gaussion_blur", true);
              }
            }
            if (paramActivity.getIntent().getBooleanExtra("is_video_forward", false)) {
              paramString1.jdField_b_of_type_Int = 9;
            }
            paramString1.a.putBoolean("enable_hw_encode", false);
            paramString1.a.putBoolean("ignorePersonalPublish", paramBoolean);
            paramString1.a.putInt("shareGroupType", paramInt5);
            paramString1.a.putString("shareGroupId", paramString2);
            paramString1.a.putString("shareGroupName", paramString3);
            paramString1.a.putString("video_tag_info", paramActivity.getIntent().getExtras().getString("video_tag_info"));
            paramLocalMediaInfo = paramString1.a;
            if (paramInt6 != 7) {
              break label1446;
            }
            paramBoolean = true;
            paramLocalMediaInfo.putBoolean("extra_is_slide_show_video", paramBoolean);
            yuk.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString1.toString());
            paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
            zpo.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras(), paramActivity);
            paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString1);
            paramLocalMediaInfo.putExtra("op_department", "grp_qq");
            paramLocalMediaInfo.putExtra("op_type", "video_edit");
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            paramLocalMediaInfo.putExtra("short_video_entrance_type", 6);
            paramLocalMediaInfo.putExtra("edit_video_way", paramInt6);
            paramLocalMediaInfo.putExtra("VIDEO_STORY_FROM_TYPE", born.a(paramActivity.getIntent()));
            if (paramInt7 == 14)
            {
              paramLocalMediaInfo.putExtra("VIDEO_STORY_JUMP_TO_TYPE", born.b(paramActivity.getIntent()));
              paramLocalMediaInfo.putExtra("VIDEO_STORY_MEDIA_TYPE", born.c(paramActivity.getIntent()));
            }
            if (paramBundle != null) {
              paramLocalMediaInfo.putExtra("state", paramBundle);
            }
            SegmentKeeper.adjustTime(0L);
            paramInt1 = 10002;
            if (paramInt7 != 11) {
              break label1452;
            }
            paramInt1 = 10012;
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            paramLocalMediaInfo.putExtra("key_from_pic_choose", a(paramActivity));
            paramActivity.startActivityForResult(paramLocalMediaInfo, paramInt1);
          }
        }
        else
        {
          i = paramInt7;
          if (paramInt4 != 10009) {
            break label1795;
          }
          localBundle2.putInt("qq_sub_business_id", 102);
          i = paramInt7;
          break label1795;
        }
        bozv.a().b(4L);
        continue;
        if (TextUtils.isEmpty(paramLocalMediaInfo.path)) {
          break label1317;
        }
      }
      catch (Exception paramActivity)
      {
        yuk.e("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + paramActivity);
        return;
      }
      label1295:
      if (paramLocalMediaInfo.path.equalsIgnoreCase("null")) {}
      for (;;)
      {
        label1317:
        paramString1 = new EditLocalPhotoSource(paramString1, paramLocalMediaInfo);
        break;
        bozv.a().b(3L);
      }
      label1342:
      l1 = l2;
      if (!TextUtils.isEmpty(paramString2))
      {
        l1 = l2 & 0xFFFDFFFF & 0xFFEFFFFF;
        break label1637;
        label1369:
        paramInt1 = paramLocalMediaInfo.mediaWidth;
        continue;
        label1377:
        paramInt2 = paramLocalMediaInfo.mediaHeight;
        continue;
        label1386:
        if (paramInt7 != 14) {
          continue;
        }
        paramString1.a.putBoolean("extra_is_fit_center", true);
        paramLocalMediaInfo = paramString1.a;
        if ((paramBundle != null) && (paramBundle.getBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT"))) {}
        for (bool1 = true;; bool1 = false)
        {
          paramLocalMediaInfo.putBoolean("extra_photo_list_to_edit", bool1);
          break;
        }
        label1446:
        paramBoolean = false;
        continue;
        label1452:
        if (paramInt7 == 12)
        {
          paramInt1 = 10013;
          continue;
        }
        if (paramInt7 == 14)
        {
          paramInt1 = 10023;
          continue;
        }
        if (paramInt7 != 2) {
          continue;
        }
        paramInt1 = 10000;
        continue;
        label1493:
        paramInt1 = paramInt2;
        l1 = l2;
        continue;
        label1503:
        l1 = l2;
        paramString1 = (String)localObject;
        if (paramInt7 != 12) {
          continue;
        }
        l1 = l2 & 0xFFFBFFFF;
        paramString1 = (String)localObject;
        continue;
        label1531:
        l1 = l2;
        if (!bool2) {
          l1 = l2 & 0xDFFFFFFF;
        }
        l2 = l1;
        if (!bool1) {
          l2 = l1 & 0xFFFFFFFE;
        }
        l1 = l2 & 0xFDFFFFFF;
        continue;
        label1576:
        l2 = l1;
        if (!bool2) {
          l2 = l1 & 0xFFFFFFFE;
        }
        l3 = l2 & 0xFDFFFFFF;
        label1601:
        if (paramInt4 == 10002) {
          break label1802;
        }
        l1 = (l3 | 0x2000) & 0xFFFBFFFF & 0xFFFDFFFF & 0xFFEFFFFF & 0xFFFFF7FF & 0xFFFFFFFF;
      }
      label1637:
      if (paramInt5 != 1)
      {
        l2 = l1;
        if (paramInt7 != 11) {}
      }
      else
      {
        l2 = l1 & 0xFFEFFFFF;
      }
      l3 = l2;
      if (paramInt7 != 11)
      {
        l3 = l2;
        if (paramInt7 != 12) {
          l3 = l2 | 0x0;
        }
      }
      if (paramInt4 != 10004)
      {
        l1 = l3;
        if (paramInt4 != 10002) {}
      }
    }
    for (;;)
    {
      l2 = l1;
      if (paramInt1 == 0) {
        break label479;
      }
      l2 = l1 | 0x0;
      break label479;
      label1734:
      l1 = (l1 | 0x0) & 0xFDFFFFFF & 0xFFFFFFFF & 0xFFFFFFFF;
      break label639;
      label1757:
      l1 = 0L | 0x2000;
      label1764:
      if (paramInt4 != 10023)
      {
        l2 = l1;
        if (paramInt4 != 10024) {
          break label664;
        }
      }
      l2 = l1 | 0x0;
      break label664;
      label1795:
      paramInt7 = i;
      break;
      label1802:
      l2 = l3;
      if (paramInt3 != 16) {
        break label1342;
      }
      l2 = l3 & 0xFFFDFFFF;
      break label1342;
      label1824:
      l1 |= 0x20000;
      break label459;
      label1835:
      paramInt1 = 0;
    }
  }
  
  public static boolean a()
  {
    wta localwta = (wta)wth.a(10);
    if (localwta == null)
    {
      yuk.e("Q.qqstory.publish.QQStoryFlowCallback", "StoryConfigManager(CONFIG_MANAGER) is null!");
      return false;
    }
    int i = localwta.b();
    if (i == h) {
      return false;
    }
    jdField_a_of_type_Int = ((Integer)localwta.b("localUploadVideoSizeLimit", Integer.valueOf(jdField_a_of_type_Int))).intValue();
    jdField_b_of_type_Int = ((Integer)localwta.b("localUploadVideoMinResolutionLimit", Integer.valueOf(jdField_b_of_type_Int))).intValue();
    c = ((Integer)localwta.b("localUploadVideoDurationLimit", Integer.valueOf(c))).intValue();
    e = ((Integer)localwta.b("localUploadVideoRatioLimit", Integer.valueOf(e))).intValue();
    f = ((Integer)localwta.b("localUploadImageSizeLimit", Integer.valueOf(f))).intValue();
    g = ((Integer)localwta.b("localUploadImageMinResolutionLimit", Integer.valueOf(g))).intValue();
    jdField_a_of_type_Float = e / 10000 / 1000.0F;
    jdField_b_of_type_Float = e % 10000 / 1000.0F;
    yuk.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config %d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(c), Integer.valueOf(e), Integer.valueOf(f), Integer.valueOf(g) });
    yuk.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config from %d to %d", new Object[] { Integer.valueOf(h), Integer.valueOf(i) });
    h = localwta.b();
    return true;
  }
  
  private static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.getIntent() != null) {
        bool1 = paramActivity.getIntent().getBooleanExtra("key_from_pic_choose", false);
      }
    }
    return bool1;
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    long l = paramIntent.getLongExtra("file_send_duration", 0L);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.getParcelableExtra("media_info");
    int i = paramIntent.getIntExtra("entrance_type", 99);
    int j = paramIntent.getIntExtra("edit_video_type", 10002);
    if (localLocalMediaInfo == null) {
      throw new IllegalArgumentException(anzj.a(2131709760));
    }
    String str1 = localLocalMediaInfo.path;
    boolean bool;
    if (localLocalMediaInfo.mMimeType.contains("video"))
    {
      if (j == 10013) {
        return false;
      }
    }
    else
    {
      if (j == 10009) {}
      for (;;)
      {
        return true;
        if (j != 10002)
        {
          if (j == 10004) {}
          for (bool = true;; bool = false)
          {
            paramIntent = EditPicActivity.a(paramActivity, str1, true, true, true, true, true, bool, bool, bool, 2, i, 5, false, null);
            paramIntent.putExtra("media_info", localLocalMediaInfo);
            paramIntent.putExtra("edit_video_way", paramInt);
            if (j == 10004) {
              paramIntent.putExtra("sub_business_id", 101);
            }
            paramActivity.startActivityForResult(paramIntent, 10002);
            break;
          }
        }
        paramIntent = EditPicActivity.a(paramActivity, str1, true, true, true, true, true, true, true, TextUtils.isEmpty(paramIntent.getStringExtra("shareGroupId")), 1, i, 0, false, null);
        paramIntent.putExtra("media_info", localLocalMediaInfo);
        paramActivity.startActivityForResult(paramIntent, 10002);
      }
    }
    if (j == 10012)
    {
      if (l < body.d)
      {
        a(paramActivity, str1, localLocalMediaInfo, 0, (int)l, i, j, 0, null, null, false, paramInt, 11);
        return true;
      }
      return false;
    }
    if ((l < 2500L) && (j != 10009))
    {
      int k = paramIntent.getIntExtra("shareGroupType", 0);
      String str2 = paramIntent.getStringExtra("shareGroupId");
      String str3 = paramIntent.getStringExtra("shareGroupName");
      bool = paramIntent.getBooleanExtra("ignorePersonalPublish", false);
      a(paramActivity, str1, localLocalMediaInfo, 0, (int)l, i, j, k, str2, str3, bool, paramInt, 1);
      return true;
    }
    if ((l < 2500L) && (j == 10009))
    {
      CropVideoActivity.a(paramActivity, 0L, l, str1);
      paramActivity.finish();
      return true;
    }
    return false;
  }
  
  public static boolean a(@NonNull Activity paramActivity, @NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    int k = 4;
    boolean bool = true;
    if (paramLocalMediaInfo == null) {
      return false;
    }
    Object localObject = new MediaMetadataRetriever();
    int j;
    int i;
    try
    {
      ((MediaMetadataRetriever)localObject).setDataSource(paramLocalMediaInfo.path);
      paramLocalMediaInfo.mediaHeight = Integer.parseInt(((MediaMetadataRetriever)localObject).extractMetadata(19));
      paramLocalMediaInfo.mediaWidth = Integer.parseInt(((MediaMetadataRetriever)localObject).extractMetadata(18));
      paramLocalMediaInfo.rotation = Integer.parseInt(((MediaMetadataRetriever)localObject).extractMetadata(24));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        ((MediaMetadataRetriever)localObject).release();
      }
    }
    finally
    {
      ((MediaMetadataRetriever)localObject).release();
    }
    a();
    float f1 = paramLocalMediaInfo.mediaHeight * 1.0F / paramLocalMediaInfo.mediaWidth;
    if (paramLocalMediaInfo.mMimeType.contains("video")) {
      if (paramLocalMediaInfo.mDuration > c)
      {
        localObject = QQToast.a(paramActivity, 1, "暂不支持选择超过3分钟的视频", 0);
        yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        j = 4;
        k = 5;
        i = 1;
      }
    }
    for (;;)
    {
      yup.b("upload_local_video", "choose_media_info", 0, j, new String[] { a(paramLocalMediaInfo) });
      if (i != 0)
      {
        String str1 = String.valueOf(1);
        label200:
        yup.a("video_shoot", "chose_video", 0, 0, new String[] { str1, String.valueOf(k), String.valueOf(f1) });
        if ((i != 0) && (paramLocalMediaInfo.mDuration >= 20500L)) {
          yup.a("video_shoot", "local_over", 0, 0, new String[0]);
        }
        if (paramLocalMediaInfo.addedDate == 0L)
        {
          paramLocalMediaInfo.addedDate = (new File(paramLocalMediaInfo.path).lastModified() / 1000L);
          if (paramLocalMediaInfo.addedDate == 0L) {
            break label947;
          }
          i = 0;
          label307:
          yup.b("upload_local_video", "media_info_missing", 0, i, new String[] { a(paramLocalMediaInfo) });
        }
        if (localObject != null) {
          paramActivity.runOnUiThread(new QQStoryFlowCallback.1((QQToast)localObject));
        }
        if (j != 0) {
          break label952;
        }
      }
      for (;;)
      {
        return bool;
        if (paramLocalMediaInfo.mDuration < d)
        {
          localObject = QQToast.a(paramActivity, 1, "请选择时长大于2秒的视频", 0);
          yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          j = 5;
          k = 6;
          i = 1;
          break;
        }
        if (paramLocalMediaInfo.fileSize > jdField_a_of_type_Int)
        {
          localObject = QQToast.a(paramActivity, 1, anzj.a(2131709750), 0);
          yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 1;
          j = 1;
          i = 1;
          break;
        }
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < jdField_b_of_type_Int)
        {
          localObject = QQToast.a(paramActivity, 1, anzj.a(2131709738), 0);
          yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 1;
          break;
        }
        if ((f1 < 0.4F) || (f1 > 2.2F))
        {
          localObject = QQToast.a(paramActivity, 1, anzj.a(2131709743), 0);
          yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          j = 3;
          i = 1;
          break;
        }
        if ((MediaFile.getMimeTypeForFile(paramLocalMediaInfo.path) == null) || (MediaFile.getMimeTypeForFile(paramLocalMediaInfo.path).contains("mp4"))) {
          break label974;
        }
        localObject = QQToast.a(paramActivity, 1, anzj.a(2131709729), 0);
        yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        j = 6;
        k = 8;
        i = 1;
        break;
        if (paramLocalMediaInfo.fileSize > f)
        {
          localObject = QQToast.a(paramActivity, 1, anzj.a(2131709745), 0);
          yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 1;
          j = 1;
          i = 0;
          break;
        }
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < g)
        {
          localObject = QQToast.a(paramActivity, 1, anzj.a(2131709744), 0);
          yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 0;
          break;
        }
        if ((f1 >= 0.4F) && (f1 <= 2.2F)) {
          break label958;
        }
        localObject = QQToast.a(paramActivity, 1, anzj.a(2131709742), 0);
        yuk.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        j = 3;
        i = 0;
        break;
        String str2 = String.valueOf(0);
        break label200;
        label947:
        i = 1;
        break label307;
        label952:
        bool = false;
      }
      label958:
      k = 9999;
      j = 0;
      localObject = null;
      i = 0;
      continue;
      label974:
      k = 9999;
      j = 0;
      localObject = null;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyp
 * JD-Core Version:    0.7.0.1
 */