import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;

public class arsu
  implements TextureView.SurfaceTextureListener, arsr
{
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private arss jdField_a_of_type_Arss;
  
  public arsu(TextureView paramTextureView)
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
  
  public void a(arss paramarss)
  {
    this.jdField_a_of_type_Arss = paramarss;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Arss = null;
    if (this.jdField_a_of_type_AndroidViewTextureView != null)
    {
      this.jdField_a_of_type_AndroidViewTextureView.setOnTouchListener(null);
      this.jdField_a_of_type_AndroidViewTextureView = null;
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewTextureView.setOpaque(false);
    if (this.jdField_a_of_type_Arss != null)
    {
      this.jdField_a_of_type_Arss.i();
      this.jdField_a_of_type_Arss.j();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Arss != null) {
      this.jdField_a_of_type_Arss.k();
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Arss != null) {
      this.jdField_a_of_type_Arss.j();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsu
 * JD-Core Version:    0.7.0.1
 */