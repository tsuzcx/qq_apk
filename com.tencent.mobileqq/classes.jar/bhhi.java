import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cooperation.qzone.panorama.widget.PanoramaGuideAnimate;

public class bhhi
  extends Handler
{
  public bhhi(PanoramaGuideAnimate paramPanoramaGuideAnimate) {}
  
  @TargetApi(11)
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      PanoramaGuideAnimate.a(this.a).setRotationY(PanoramaGuideAnimate.a(this.a));
      PanoramaGuideAnimate.a(this.a).setTranslationX(PanoramaGuideAnimate.b(this.a));
      return;
      if (PanoramaGuideAnimate.c(this.a) > 0.0F) {
        break;
      }
    } while (PanoramaGuideAnimate.a(this.a) == null);
    PanoramaGuideAnimate.a(this.a).a();
    return;
    PanoramaGuideAnimate.a(this.a, PanoramaGuideAnimate.c(this.a) - 0.05F);
    this.a.setAlpha(PanoramaGuideAnimate.c(this.a));
    PanoramaGuideAnimate.a(this.a).sendEmptyMessage(292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhhi
 * JD-Core Version:    0.7.0.1
 */