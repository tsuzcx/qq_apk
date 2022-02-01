import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;

class arjs
  implements FaceDrawable.OnLoadingStateChangeListener
{
  arjs(arjr paramarjr) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      arjr.a(this.a).setImageDrawable((Drawable)null);
      arjr.a(this.a).setImageDrawable(arjr.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjs
 * JD-Core Version:    0.7.0.1
 */