import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoViewFactory;

public class axaz
{
  static {}
  
  public static IBaseVideoView a(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return VideoViewFactory.createBaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
  
  public static IBaseVideoView a(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    return VideoViewFactory.createCropBubbleView(paramContext, paramLong, paramVideoPlayParam, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axaz
 * JD-Core Version:    0.7.0.1
 */