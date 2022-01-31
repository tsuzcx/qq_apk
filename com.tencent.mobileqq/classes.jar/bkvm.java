import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class bkvm
  implements View.OnClickListener
{
  public bkvm(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onClick(View paramView)
  {
    bizt.a().u();
    Object localObject = bjaa.a().a("camera_ad_type", "", 4);
    paramView = bjaa.a().a("camera_ad_schema", "", 4);
    if ("h5".equals(localObject))
    {
      if (!bbfj.g(null))
      {
        bcql.a(this.a.getContext(), 1, this.a.getContext().getString(2131697859), 1).a();
        return;
      }
      localObject = new Intent(this.a.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("loc_play_show_material_id", paramView);
      if (AEPituCameraCaptureButtonLayout.a(this.a).hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.a).getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", birt.a.a()));
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("VIDEO_STORY_FROM_TYPE", birt.x.a());
        if (!(this.a.getContext() instanceof Activity)) {
          break;
        }
        ((Activity)this.a.getContext()).startActivityForResult((Intent)localObject, 1025);
        return;
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.a).getIntExtra("VIDEO_STORY_FROM_TYPE", birt.a.a()));
      }
      this.a.getContext().startActivity((Intent)localObject);
      return;
    }
    this.a.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkvm
 * JD-Core Version:    0.7.0.1
 */