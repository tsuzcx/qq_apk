import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class bddo
  implements URLDrawable.URLDrawableListener
{
  bddo(View paramView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (this.a != null) {
      this.a.postInvalidate();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (this.a != null) {
      this.a.postInvalidate();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, xsm.a(BaseApplicationImpl.getContext(), 47.0F), xsm.a(BaseApplicationImpl.getContext(), 14.0F));
    }
    if (this.a != null) {
      this.a.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddo
 * JD-Core Version:    0.7.0.1
 */