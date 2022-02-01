import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.SingleLineTextView;

public final class bhja
  implements URLDrawable.URLDrawableListener
{
  public bhja(boolean paramBoolean, SingleLineTextView paramSingleLineTextView, Context paramContext) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (paramURLDrawable.getCurrDrawable() != null) {
        paramURLDrawable.getCurrDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, VipUtils.a(AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramURLDrawable));
      return;
      if (paramURLDrawable.getCurrDrawable() != null) {
        paramURLDrawable.getCurrDrawable().setColorFilter(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhja
 * JD-Core Version:    0.7.0.1
 */