import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.qzone.widget.FastAnimationDrawable;
import java.lang.ref.WeakReference;

public class bkat
  extends Handler
{
  private final WeakReference<Drawable> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bkat(FastAnimationDrawable paramFastAnimationDrawable, Drawable paramDrawable)
  {
    super(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDrawable);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (Drawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramMessage != null) {
      paramMessage.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bkat
 * JD-Core Version:    0.7.0.1
 */