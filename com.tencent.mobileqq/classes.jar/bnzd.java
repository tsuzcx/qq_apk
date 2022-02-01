import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;

public class bnzd
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      bnzb.d("PicChooseJumpUtil", "activity is null.");
      return;
    }
    String str1 = QIMCameraCaptureActivity.class.getName();
    String str2 = LocalVideoSelectActivity.class.getName();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 60000L);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", str2);
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("enter_from", 26);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("pic_back_type_result", true);
    localIntent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", bnqb.b(paramActivity.getIntent()));
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bnqb.a(paramActivity.getIntent()));
    localIntent.putExtra("edit_video_way", 11);
    localIntent.putExtra("edit_video_type", 10023);
    paramActivity.startActivityForResult(localIntent, 10006);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    String str = QIMCameraCaptureActivity.class.getName();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("enter_from", 23);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(paramActivity));
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    bnzb.b("PicChooseJumpUtil", "[jumpForAECircle] Start");
    bnzb.a("PicChooseJumpUtil", "[AE Profiler] jumpForAECircle Start");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("intent_key_uid_for_report", localIntent.getStringExtra("PhotoConst.UIN"));
    localIntent.setClass(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 29);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(paramActivity));
    paramActivity.startActivity(localIntent);
  }
  
  public static void b(Activity paramActivity, int paramInt)
  {
    String str = QIMCameraCaptureActivity.class.getName();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("enter_from", 23);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("pic_choose_in_node_id", paramInt);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(paramActivity));
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzd
 * JD-Core Version:    0.7.0.1
 */