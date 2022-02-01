import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class bhtu
  implements URLDrawable.URLDrawableListener
{
  public bhtu(Resources paramResources, String paramString, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    int i;
    if (paramURLDrawable != null)
    {
      i = agej.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      j = paramURLDrawable.getIntrinsicHeight();
      if (j == 0)
      {
        boolean bool = new File(VasApngUtil.getCacheFilePath(this.jdField_a_of_type_JavaLangString)).delete();
        QLog.e("VipUtils", 1, "onLoadSuccessed drawableHeight=0, deleteSucc=" + bool + " url=" + this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    else
    {
      return;
    }
    int j = paramURLDrawable.getIntrinsicWidth() * i / j;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = i;
    localLayoutParams.width = j;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtu
 * JD-Core Version:    0.7.0.1
 */