import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class bngw
  implements View.OnClickListener
{
  public bngw(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onClick(View paramView)
  {
    blen.a().A();
    Object localObject = blev.a().a("camera_ad_type", "", 4);
    paramView = blev.a().a("camera_ad_schema", "", 4);
    if ("h5".equals(localObject))
    {
      if (!bdee.g(null))
      {
        QQToast.a(this.a.getContext(), 1, this.a.getContext().getString(2131698036), 1).a();
        return;
      }
      localObject = new Intent(this.a.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("loc_play_show_material_id", paramView);
      if (AEPituCameraCaptureButtonLayout.a(this.a).hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.a).getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", bkwm.a.a()));
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("VIDEO_STORY_FROM_TYPE", bkwm.A.a());
        if (!(this.a.getContext() instanceof Activity)) {
          break;
        }
        ((Activity)this.a.getContext()).startActivityForResult((Intent)localObject, 1025);
        return;
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.a).getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a()));
      }
      this.a.getContext().startActivity((Intent)localObject);
      return;
    }
    this.a.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngw
 * JD-Core Version:    0.7.0.1
 */