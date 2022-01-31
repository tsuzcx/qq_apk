import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import dov.com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;

public class anws
  implements Runnable
{
  public anws(QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity) {}
  
  public void run()
  {
    QQStoryTakeVideoCloseAnimationActivity localQQStoryTakeVideoCloseAnimationActivity = this.a;
    Intent localIntent = new Intent(localQQStoryTakeVideoCloseAnimationActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("main_tab_id", 6);
    localIntent.putExtra("open_now_tab_fragment", true);
    localIntent.putExtra("extra_from_share", true);
    localIntent.putExtra("new_video_extra_info", "need_publish_animation");
    localIntent.setFlags(335544320);
    localQQStoryTakeVideoCloseAnimationActivity.startActivity(localIntent);
    localQQStoryTakeVideoCloseAnimationActivity.overridePendingTransition(2131034125, 2131034126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anws
 * JD-Core Version:    0.7.0.1
 */