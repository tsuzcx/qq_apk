import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;

public class atba
{
  public int a;
  protected Drawable a;
  public Handler a;
  protected ImageView a;
  public ArrayList<String> a;
  protected int b;
  
  public void a(String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.b;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.b;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_reddot_face";
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    paramString.setTag(bavi.a(this.b, this.b));
    paramString.setDecodeHandler(bavi.a);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.1F });
      ((ObjectAnimator)localObject).addListener(new atbb(this, paramString));
      ((ObjectAnimator)localObject).setDuration(1500L).start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atba
 * JD-Core Version:    0.7.0.1
 */