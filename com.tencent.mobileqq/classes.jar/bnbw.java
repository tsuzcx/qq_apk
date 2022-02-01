import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnbw
  implements View.OnClickListener
{
  bnbw(bnbp parambnbp) {}
  
  public void onClick(View paramView)
  {
    bnqm.a().R();
    if ("h5".equals(bnbp.a(this.a))) {
      if (!NetworkUtil.isNetworkAvailable(null)) {
        QQToast.a(bnbp.a(this.a), 1, bnbp.b(this.a).getString(2131697352), 1).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(bnbp.c(this.a), QQBrowserActivity.class);
      localIntent.putExtra("url", bnbp.b(this.a));
      localIntent.putExtra("loc_play_show_material_id", bnbp.b(this.a));
      if (bnbp.d(this.a).getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bnbp.e(this.a).getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bnlb.a.a()));
      }
      for (;;)
      {
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bnlb.I.a());
        bnbp.g(this.a).startActivityForResult(localIntent, 1025);
        break;
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bnbp.f(this.a).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnlb.a.a()));
      }
      bnbp.a(this.a).b(bnbp.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbw
 * JD-Core Version:    0.7.0.1
 */