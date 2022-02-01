import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bokf
  implements View.OnClickListener
{
  bokf(bojy parambojy) {}
  
  public void onClick(View paramView)
  {
    bozr.a().N();
    if ("h5".equals(bojy.a(this.a))) {
      if (!bhnv.g(null)) {
        QQToast.a(bojy.a(this.a), 1, bojy.b(this.a).getString(2131696933), 1).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(bojy.c(this.a), QQBrowserActivity.class);
      localIntent.putExtra("url", bojy.b(this.a));
      localIntent.putExtra("loc_play_show_material_id", bojy.b(this.a));
      if (bojy.d(this.a).getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bojy.e(this.a).getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", born.a.a()));
      }
      for (;;)
      {
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", born.C.a());
        bojy.g(this.a).startActivityForResult(localIntent, 1025);
        break;
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bojy.f(this.a).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a()));
      }
      bojy.a(this.a).a(bojy.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokf
 * JD-Core Version:    0.7.0.1
 */