import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.vip.diy.common.DIYImageView;

public class biix
  extends bnvn
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private String jdField_a_of_type_JavaLangString;
  
  public biix(String paramString1, View paramView, @NonNull String paramString2)
  {
    super(paramString1, paramView);
    if ((paramView != null) && ((paramView instanceof DIYImageView))) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((DIYImageView)paramView).a();
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
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
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    ViewGroup.LayoutParams localLayoutParams1;
    ViewGroup.LayoutParams localLayoutParams2;
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidViewView.getParent() != null) && ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).setClipChildren(false);
      }
      localLayoutParams1 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams2 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    } while ((localLayoutParams1 == null) || (localLayoutParams2 == null));
    localLayoutParams2.width = localLayoutParams1.width;
    localLayoutParams2.height = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = this.jdField_a_of_type_JavaLangString + paramString;
    }
    if (!blhn.a(str)) {}
    do
    {
      return;
      paramString = URLDrawable.URLDrawableOptions.obtain();
      if ((this.jdField_a_of_type_Int > 0) && (this.b > 0))
      {
        paramString.mRequestWidth = this.jdField_a_of_type_Int;
        paramString.mRequestHeight = this.b;
      }
      paramString.mLoadingDrawable = beyq.a;
      paramString.mFailedDrawable = beyq.a;
      paramString.mPlayGifImage = false;
      paramString = URLDrawable.getDrawable(str, paramString);
    } while (paramString == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.jdField_a_of_type_AndroidViewView instanceof DIYImageView)) {
      znw.a("JsonInflateViewModel current view type illegal!", new Object[0]);
    }
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        a(paramString2);
        return;
      }
    } while (!"scale_type".equals(paramString1));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(a(paramString2));
  }
  
  protected void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biix
 * JD-Core Version:    0.7.0.1
 */