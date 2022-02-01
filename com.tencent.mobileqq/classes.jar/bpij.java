import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.component.media.MediaFile;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback.1;
import java.io.File;
import org.json.JSONObject;

public class bpij
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
    String str = bpfc.a(paramInt);
    paramActivity.getIntent().putExtra("extra_upload_temp_directory", str);
    return str;
  }
  
  public static String a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.fileSize + "|" + paramLocalMediaInfo.mediaWidth + "|" + paramLocalMediaInfo.mediaHeight + "|" + paramLocalMediaInfo.mDuration + "," + paramLocalMediaInfo.mMimeType + "," + paramLocalMediaInfo.rotation;
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6, int paramInt7)
  {
    a(paramActivity, paramString1, paramLocalMediaInfo, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramBoolean, paramInt6, paramInt7, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6, int paramInt7, Bundle paramBundle)
  {
    for (;;)
    {
      boolean bool2;
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("extra_upload_temp_directory", a(paramActivity, paramInt7));
        localBundle.putInt("entrance_type", paramInt3);
        localBundle.putString("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
        long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
        if (paramLocalMediaInfo.mMimeType.contains("video"))
        {
          if ((TextUtils.isEmpty(paramLocalMediaInfo.path)) || (paramLocalMediaInfo.path.equalsIgnoreCase("null")))
          {
            paramString1 = new EditLocalVideoSource(paramString1, paramLocalMediaInfo, paramInt1, paramInt2);
            paramInt2 = 1643;
            paramInt1 = paramInt2;
            if (paramInt7 == 11)
            {
              bool2 = false;
              bool1 = false;
              paramLocalMediaInfo = paramActivity.getIntent().getExtras();
              JSONObject localJSONObject = beub.a(paramLocalMediaInfo);
              if (localJSONObject == null) {
                break label810;
              }
              bool2 = localJSONObject.optBoolean("needVideoDoodle", false);
              bool1 = localJSONObject.optBoolean("needVideoWording", false);
              break label810;
              localBundle.putAll(paramLocalMediaInfo);
            }
            paramInt2 = paramInt1;
            if (paramInt7 != 12) {
              break label853;
            }
            bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
            bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
            paramInt3 = paramInt1;
            if (bool1) {
              break label837;
            }
            paramInt3 = paramInt1 & 0xFFFFFBFF;
            break label837;
            label227:
            if (bnlb.a(paramActivity.getIntent(), paramInt7)) {
              break label883;
            }
            if (!bnlb.c(paramActivity.getIntent())) {
              break label887;
            }
            break label883;
            label252:
            paramString1 = new EditVideoParams(paramInt7, paramInt2, paramString1, localBundle);
            paramString1.f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnlb.a.a());
            if (l != 0L) {
              paramString1.a.putLong("troop_uin", l);
            }
            if (paramInt7 == 14)
            {
              paramString1.a.putBoolean("extra_is_fit_center", true);
              paramLocalMediaInfo = paramString1.a;
              if ((paramBundle == null) || (!paramBundle.getBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT"))) {
                break label757;
              }
              bool1 = true;
              paramLocalMediaInfo.putBoolean("extra_photo_list_to_edit", bool1);
            }
            paramString1.a.putBoolean("enable_hw_encode", false);
            paramString1.a.putBoolean("ignorePersonalPublish", paramBoolean);
            paramString1.a.putInt("shareGroupType", paramInt5);
            paramString1.a.putString("shareGroupId", paramString2);
            paramString1.a.putString("shareGroupName", paramString3);
            paramString1.a.putString("video_tag_info", paramActivity.getIntent().getExtras().getString("video_tag_info"));
            paramLocalMediaInfo = paramString1.a;
            if (paramInt6 != 7) {
              break label763;
            }
            paramBoolean = true;
            paramLocalMediaInfo.putBoolean("extra_is_slide_show_video", paramBoolean);
            ykq.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString1.toString());
            paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
            zfd.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras(), paramActivity);
            paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString1);
            paramLocalMediaInfo.putExtra("op_department", "grp_qq");
            paramLocalMediaInfo.putExtra("op_type", "video_edit");
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            paramLocalMediaInfo.putExtra("short_video_entrance_type", 6);
            paramLocalMediaInfo.putExtra("edit_video_way", paramInt6);
            paramLocalMediaInfo.putExtra("VIDEO_STORY_FROM_TYPE", bnlb.a(paramActivity.getIntent()));
            if (paramInt7 == 14)
            {
              paramLocalMediaInfo.putExtra("VIDEO_STORY_JUMP_TO_TYPE", bnlb.b(paramActivity.getIntent()));
              paramLocalMediaInfo.putExtra("VIDEO_STORY_MEDIA_TYPE", bnlb.c(paramActivity.getIntent()));
            }
            if (paramBundle == null) {
              break label916;
            }
            paramLocalMediaInfo.putExtra("state", paramBundle);
            break label916;
            label640:
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            paramLocalMediaInfo.putExtra("key_from_pic_choose", a(paramActivity));
            paramActivity.startActivityForResult(paramLocalMediaInfo, paramInt1);
            return;
          }
          bnqq.a().b(4L);
          continue;
        }
        if (TextUtils.isEmpty(paramLocalMediaInfo.path)) {
          break label732;
        }
      }
      catch (Exception paramActivity)
      {
        ykq.e("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + paramActivity);
        return;
      }
      if (paramLocalMediaInfo.path.equalsIgnoreCase("null")) {}
      for (;;)
      {
        label732:
        paramString1 = new EditLocalPhotoSource(paramString1, paramLocalMediaInfo);
        break;
        bnqq.a().b(3L);
      }
      label757:
      boolean bool1 = false;
      continue;
      label763:
      paramBoolean = false;
      continue;
      label810:
      label837:
      label853:
      label883:
      label887:
      do
      {
        if (paramInt7 == 12)
        {
          paramInt1 = 10013;
          break label640;
        }
        if (paramInt7 == 14)
        {
          paramInt1 = 10023;
          break label640;
        }
        if (paramInt7 != 2) {
          break label640;
        }
        paramInt1 = 10000;
        break label640;
        if (!bool2) {
          paramInt2 = 619;
        }
        paramInt1 = paramInt2;
        if (bool1) {
          break;
        }
        paramInt1 = paramInt2 & 0xFFFFFFFE;
        break;
        paramInt2 = paramInt3;
        if (!bool2) {
          paramInt2 = paramInt3 & 0xFFFFFFFE;
        }
        paramInt1 = paramInt2;
        if (paramInt7 == 11) {
          break label227;
        }
        paramInt1 = paramInt2;
        if (paramInt7 == 12) {
          break label227;
        }
        paramInt1 = paramInt2 | 0x1000;
        break label227;
        paramInt1 = 512;
        if (paramInt4 != 10023)
        {
          paramInt2 = paramInt1;
          if (paramInt4 != 10024) {
            break label252;
          }
        }
        paramInt2 = paramInt1 | 0x2000;
        break label252;
        paramInt1 = 10002;
      } while (paramInt7 != 11);
      label916:
      paramInt1 = 10012;
    }
  }
  
  public static boolean a()
  {
    wjl localwjl = (wjl)wjs.a(10);
    if (localwjl == null)
    {
      ykq.e("Q.qqstory.publish.QQStoryFlowCallback", "StoryConfigManager(CONFIG_MANAGER) is null!");
      return false;
    }
    int i = localwjl.b();
    if (i == h) {
      return false;
    }
    jdField_a_of_type_Int = ((Integer)localwjl.b("localUploadVideoSizeLimit", Integer.valueOf(jdField_a_of_type_Int))).intValue();
    jdField_b_of_type_Int = ((Integer)localwjl.b("localUploadVideoMinResolutionLimit", Integer.valueOf(jdField_b_of_type_Int))).intValue();
    c = ((Integer)localwjl.b("localUploadVideoDurationLimit", Integer.valueOf(c))).intValue();
    e = ((Integer)localwjl.b("localUploadVideoRatioLimit", Integer.valueOf(e))).intValue();
    f = ((Integer)localwjl.b("localUploadImageSizeLimit", Integer.valueOf(f))).intValue();
    g = ((Integer)localwjl.b("localUploadImageMinResolutionLimit", Integer.valueOf(g))).intValue();
    jdField_a_of_type_Float = e / 10000 / 1000.0F;
    jdField_b_of_type_Float = e % 10000 / 1000.0F;
    ykq.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config %d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(c), Integer.valueOf(e), Integer.valueOf(f), Integer.valueOf(g) });
    ykq.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config from %d to %d", new Object[] { Integer.valueOf(h), Integer.valueOf(i) });
    h = localwjl.b();
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
      throw new IllegalArgumentException(anvx.a(2131710339));
    }
    String str1 = localLocalMediaInfo.path;
    if (!localLocalMediaInfo.mMimeType.contains("video"))
    {
      paramIntent = EditPicActivity.a(paramActivity, str1, true, true, true, true, true, false, false, false, 2, i, 5, false, null);
      paramIntent.putExtra("media_info", localLocalMediaInfo);
      paramIntent.putExtra("edit_video_way", paramInt);
      paramActivity.startActivityForResult(paramIntent, 10002);
      return true;
    }
    if (j == 10013) {
      return false;
    }
    if (j == 10012)
    {
      if (l < bmuy.jdField_a_of_type_Int)
      {
        a(paramActivity, str1, localLocalMediaInfo, 0, (int)l, i, j, 0, null, null, false, paramInt, 11);
        return true;
      }
      return false;
    }
    if (l < 2500L)
    {
      int k = paramIntent.getIntExtra("shareGroupType", 0);
      String str2 = paramIntent.getStringExtra("shareGroupId");
      String str3 = paramIntent.getStringExtra("shareGroupName");
      boolean bool = paramIntent.getBooleanExtra("ignorePersonalPublish", false);
      a(paramActivity, str1, localLocalMediaInfo, 0, (int)l, i, j, k, str2, str3, bool, paramInt, 2);
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
        ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        j = 4;
        k = 5;
        i = 1;
      }
    }
    for (;;)
    {
      ykv.b("upload_local_video", "choose_media_info", 0, j, new String[] { a(paramLocalMediaInfo) });
      if (i != 0)
      {
        String str1 = String.valueOf(1);
        label200:
        ykv.a("video_shoot", "chose_video", 0, 0, new String[] { str1, String.valueOf(k), String.valueOf(f1) });
        if ((i != 0) && (paramLocalMediaInfo.mDuration >= 20500L)) {
          ykv.a("video_shoot", "local_over", 0, 0, new String[0]);
        }
        if (paramLocalMediaInfo.addedDate == 0L)
        {
          paramLocalMediaInfo.addedDate = (new File(paramLocalMediaInfo.path).lastModified() / 1000L);
          if (paramLocalMediaInfo.addedDate == 0L) {
            break label947;
          }
          i = 0;
          label307:
          ykv.b("upload_local_video", "media_info_missing", 0, i, new String[] { a(paramLocalMediaInfo) });
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
          ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          j = 5;
          k = 6;
          i = 1;
          break;
        }
        if (paramLocalMediaInfo.fileSize > jdField_a_of_type_Int)
        {
          localObject = QQToast.a(paramActivity, 1, anvx.a(2131710329), 0);
          ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 1;
          j = 1;
          i = 1;
          break;
        }
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < jdField_b_of_type_Int)
        {
          localObject = QQToast.a(paramActivity, 1, anvx.a(2131710317), 0);
          ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 1;
          break;
        }
        if ((f1 < 0.4F) || (f1 > 2.2F))
        {
          localObject = QQToast.a(paramActivity, 1, anvx.a(2131710322), 0);
          ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          j = 3;
          i = 1;
          break;
        }
        if ((MediaFile.getMimeTypeForFile(paramLocalMediaInfo.path) == null) || (MediaFile.getMimeTypeForFile(paramLocalMediaInfo.path).contains("mp4"))) {
          break label974;
        }
        localObject = QQToast.a(paramActivity, 1, anvx.a(2131710308), 0);
        ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        j = 6;
        k = 8;
        i = 1;
        break;
        if (paramLocalMediaInfo.fileSize > f)
        {
          localObject = QQToast.a(paramActivity, 1, anvx.a(2131710324), 0);
          ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 1;
          j = 1;
          i = 0;
          break;
        }
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < g)
        {
          localObject = QQToast.a(paramActivity, 1, anvx.a(2131710323), 0);
          ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 0;
          break;
        }
        if ((f1 >= 0.4F) && (f1 <= 2.2F)) {
          break label958;
        }
        localObject = QQToast.a(paramActivity, 1, anvx.a(2131710321), 0);
        ykq.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
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
 * Qualified Name:     bpij
 * JD-Core Version:    0.7.0.1
 */