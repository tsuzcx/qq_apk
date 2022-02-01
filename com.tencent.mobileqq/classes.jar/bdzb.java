import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;

public class bdzb
  extends bdze
  implements bdxi
{
  protected String b;
  
  public bdzb(SpriteNativeView paramSpriteNativeView, String paramString)
  {
    super(paramSpriteNativeView);
    this.b = paramString;
  }
  
  protected ImageView a()
  {
    return new PressEffectImageView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.getContext());
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzb
 * JD-Core Version:    0.7.0.1
 */