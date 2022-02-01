import android.graphics.ColorMatrixColorFilter;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.3.1;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener;

public class avqg
  implements YtSDKKitFramework.IYTReflectListener
{
  avqg(avqf paramavqf) {}
  
  public float onGetAppBrightness()
  {
    return 0.0F;
  }
  
  public void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter, float paramFloat)
  {
    avqf.a(this.a, new IdentificationPoseReflect.3.1(this, paramColorMatrixColorFilter));
  }
  
  public void onReflectStart(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqg
 * JD-Core Version:    0.7.0.1
 */