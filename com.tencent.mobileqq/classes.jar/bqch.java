import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class bqch
  implements View.OnClickListener
{
  public bqch(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onClick(View paramView)
  {
    bnyh.a().N();
    if ("h5".equals(AEPituCameraCaptureButtonLayout.a(this.a))) {
      if (!bgnt.g(null)) {
        QQToast.a(this.a.getContext(), 1, this.a.getContext().getString(2131696884), 1).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.a.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", AEPituCameraCaptureButtonLayout.b(this.a));
      localIntent.putExtra("loc_play_show_material_id", AEPituCameraCaptureButtonLayout.b(this.a));
      if (AEPituCameraCaptureButtonLayout.a(this.a).hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.a).getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bnqb.a.a()));
      }
      for (;;)
      {
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bnqb.C.a());
        if (!(this.a.getContext() instanceof Activity)) {
          break label223;
        }
        ((Activity)this.a.getContext()).startActivityForResult(localIntent, 1025);
        break;
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.a).getIntExtra("VIDEO_STORY_FROM_TYPE", bnqb.a.a()));
      }
      label223:
      this.a.getContext().startActivity(localIntent);
      continue;
      this.a.a.a(AEPituCameraCaptureButtonLayout.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqch
 * JD-Core Version:    0.7.0.1
 */