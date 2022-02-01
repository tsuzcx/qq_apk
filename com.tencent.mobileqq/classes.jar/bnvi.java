import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class bnvi
  extends bnvn
{
  public bnvi(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private ImageView.ScaleType a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("center_crop".equals(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("fit_center".equals(paramString)) {
      return ImageView.ScaleType.FIT_CENTER;
    }
    return ImageView.ScaleType.CENTER_CROP;
  }
  
  protected void a(String paramString)
  {
    if (!blhn.a(paramString)) {}
    do
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((this.jdField_a_of_type_Int > 0) && (this.b > 0))
      {
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
        localURLDrawableOptions.mRequestHeight = this.b;
      }
      localURLDrawableOptions.mPlayGifImage = false;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    } while (paramString == null);
    ((ImageView)this.jdField_a_of_type_AndroidViewView).setImageDrawable(paramString);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView)) {}
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        a(paramString2);
        return;
      }
    } while (!"scale_type".equals(paramString1));
    ((ImageView)this.jdField_a_of_type_AndroidViewView).setScaleType(a(paramString2));
  }
  
  protected void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvi
 * JD-Core Version:    0.7.0.1
 */