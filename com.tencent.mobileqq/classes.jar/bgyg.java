import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import dov.com.qq.im.AECamera.qudong.AETemplateInfoFragment;
import dov.com.qq.im.QIMCameraCaptureActivity;

public class bgyg
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgyg
 * JD-Core Version:    0.7.0.1
 */