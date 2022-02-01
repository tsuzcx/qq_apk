import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;

class asny
  implements FaceDrawable.OnLoadingStateChangeListener
{
  asny(asnx paramasnx) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      asnx.a(this.a).setImageDrawable((Drawable)null);
      asnx.a(this.a).setImageDrawable(asnx.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asny
 * JD-Core Version:    0.7.0.1
 */