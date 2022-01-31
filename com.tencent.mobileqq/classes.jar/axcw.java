import android.media.MediaMetadataRetriever;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;

public class axcw
  extends axcu
{
  protected VPNGImageView a;
  
  public axcw(SpriteNativeView paramSpriteNativeView, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView = paramSpriteNativeView;
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = new VPNGImageView(paramSpriteNativeView.getContext());
    paramSpriteNativeView = new MediaMetadataRetriever();
    try
    {
      paramSpriteNativeView.setDataSource(paramString);
      paramString = paramSpriteNativeView.extractMetadata(18);
      String str = paramSpriteNativeView.extractMetadata(19);
      this.jdField_a_of_type_Float = (Integer.parseInt(paramString) / 2);
      this.b = Integer.parseInt(str);
      paramString = new FrameLayout.LayoutParams((int)this.jdField_a_of_type_Float, (int)this.b);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setLayoutParams(paramString);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setPivotX(this.jdField_a_of_type_Float / 2.0F);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setPivotY(this.b / 2.0F);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("VideoSprite", 2, "MediaMetadataRetriever exception " + paramString);
      return;
    }
    finally
    {
      paramSpriteNativeView.release();
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVideo(paramString, paramBoolean);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onPause();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onResume();
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    a(this.jdField_a_of_type_Axbd);
    float f1 = this.jdField_a_of_type_Axbd.jdField_a_of_type_Float;
    float f2 = b();
    float f3 = this.jdField_a_of_type_Float / 2.0F;
    float f4 = this.f;
    float f5 = this.jdField_a_of_type_Axbd.b;
    float f6 = b();
    float f7 = this.b / 2.0F;
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setX(f1 * f2 - f3);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setY(f4 - f5 * f6 - f7);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setScaleX(this.e * b());
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setScaleY(this.e * b());
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setRotation(this.g);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setAlpha(this.jdField_a_of_type_Int * (b() / 255.0F) / 255.0F);
    return bool;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.addView(this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcw
 * JD-Core Version:    0.7.0.1
 */