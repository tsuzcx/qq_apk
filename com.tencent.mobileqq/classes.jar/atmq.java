import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.forward.ForwardMarketFaceOption;

public class atmq
  implements URLDrawable.URLDrawableListener
{
  public atmq(ForwardMarketFaceOption paramForwardMarketFaceOption) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setBounds(bfvo.a(paramURLDrawable, 36, 100, this.a.a));
    ForwardMarketFaceOption.a(this.a).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmq
 * JD-Core Version:    0.7.0.1
 */