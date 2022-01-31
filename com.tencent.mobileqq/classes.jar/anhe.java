import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;

public class anhe
  implements TextureView.SurfaceTextureListener, anhb
{
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private anhc jdField_a_of_type_Anhc;
  
  public anhe(TextureView paramTextureView)
  {
    this.jdField_a_of_type_AndroidViewTextureView = paramTextureView;
    this.jdField_a_of_type_AndroidViewTextureView.setOpaque(false);
    this.jdField_a_of_type_AndroidViewTextureView.setSurfaceTextureListener(this);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidViewTextureView.getY();
  }
  
  public Canvas a()
  {
    return this.jdField_a_of_type_AndroidViewTextureView.lockCanvas();
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidViewTextureView.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewTextureView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(anhc paramanhc)
  {
    this.jdField_a_of_type_Anhc = paramanhc;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Anhc = null;
    if (this.jdField_a_of_type_AndroidViewTextureView != null)
    {
      this.jdField_a_of_type_AndroidViewTextureView.setOnTouchListener(null);
      this.jdField_a_of_type_AndroidViewTextureView = null;
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewTextureView.setOpaque(false);
    if (this.jdField_a_of_type_Anhc != null)
    {
      this.jdField_a_of_type_Anhc.i();
      this.jdField_a_of_type_Anhc.j();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Anhc != null) {
      this.jdField_a_of_type_Anhc.k();
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Anhc != null) {
      this.jdField_a_of_type_Anhc.j();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhe
 * JD-Core Version:    0.7.0.1
 */