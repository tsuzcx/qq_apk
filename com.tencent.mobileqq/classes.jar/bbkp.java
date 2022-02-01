import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;

@TargetApi(14)
public class bbkp
{
  public int a;
  public SurfaceTexture a;
  public Surface a;
  
  public bbkp(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(paramInt);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkp
 * JD-Core Version:    0.7.0.1
 */