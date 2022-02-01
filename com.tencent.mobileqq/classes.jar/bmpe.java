import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.qzone.widget.FastAnimationDrawable;
import java.lang.ref.WeakReference;

public class bmpe
  extends Handler
{
  private final WeakReference<Drawable> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bmpe(FastAnimationDrawable paramFastAnimationDrawable, Drawable paramDrawable)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpe
 * JD-Core Version:    0.7.0.1
 */