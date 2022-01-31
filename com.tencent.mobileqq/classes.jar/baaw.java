import android.graphics.Bitmap;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;

public class baaw
  extends baav
  implements azzc<SpriteNativeView>
{
  private Bitmap a;
  protected ImageView a;
  
  public baaw(SpriteNativeView paramSpriteNativeView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView = paramSpriteNativeView;
    this.jdField_a_of_type_AndroidWidgetImageView = a();
  }
  
  protected ImageView a()
  {
    return new ImageView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.getContext());
  }
  
  public void a(SpriteNativeView paramSpriteNativeView, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    paramSpriteNativeView = new FrameLayout.LayoutParams(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramSpriteNativeView);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_AndroidWidgetImageView.setPivotX(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2);
    this.jdField_a_of_type_AndroidWidgetImageView.setPivotY(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    boolean bool = super.c();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      a(this.jdField_a_of_type_Azze);
      float f1 = this.jdField_a_of_type_Azze.a;
      float f2 = b();
      float f3 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2;
      float f4 = this.f;
      float f5 = this.jdField_a_of_type_Azze.b;
      float f6 = b();
      float f7 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
      this.jdField_a_of_type_AndroidWidgetImageView.setX(f1 * f2 - f3);
      this.jdField_a_of_type_AndroidWidgetImageView.setY(f4 - f5 * f6 - f7);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(this.e * b());
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(this.e * b());
    this.jdField_a_of_type_AndroidWidgetImageView.setRotation(this.g);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(this.jdField_a_of_type_Int * (b() / 255.0F) / 255.0F);
    return bool;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baaw
 * JD-Core Version:    0.7.0.1
 */