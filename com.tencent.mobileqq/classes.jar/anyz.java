import android.graphics.PointF;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector.SimpleOnMoveGestureListener;
import dov.com.qq.im.cropvideo.CropVideoActivity;
import dov.com.qq.im.cropvideo.RenderFilter;

public class anyz
  extends MoveGestureDetector.SimpleOnMoveGestureListener
{
  public anyz(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean b(MoveGestureDetector paramMoveGestureDetector)
  {
    float f1 = paramMoveGestureDetector.a().x;
    float f2 = paramMoveGestureDetector.a().y;
    CropVideoActivity.a(this.a).a(f1, f2, 0.0F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyz
 * JD-Core Version:    0.7.0.1
 */