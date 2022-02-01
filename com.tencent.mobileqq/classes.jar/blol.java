import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blol
  implements View.OnClickListener
{
  blol(bloe parambloe) {}
  
  public void onClick(View paramView)
  {
    bmbc.a().R();
    if ("h5".equals(bloe.a(this.a))) {
      if (!NetworkUtil.isNetworkAvailable(null)) {
        QQToast.a(bloe.a(this.a), 1, bloe.b(this.a).getString(2131697075), 1).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(bloe.c(this.a), QQBrowserActivity.class);
      localIntent.putExtra("url", bloe.b(this.a));
      localIntent.putExtra("loc_play_show_material_id", bloe.b(this.a));
      if (bloe.d(this.a).getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bloe.e(this.a).getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", blvr.a.a()));
      }
      for (;;)
      {
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", blvr.I.a());
        bloe.g(this.a).startActivityForResult(localIntent, 1025);
        break;
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bloe.f(this.a).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blvr.a.a()));
      }
      bloe.a(this.a).b(bloe.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blol
 * JD-Core Version:    0.7.0.1
 */