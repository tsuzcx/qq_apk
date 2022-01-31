import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.atomic.AtomicBoolean;

final class azzc
  implements azzd<T>
{
  azzc(AtomicBoolean paramAtomicBoolean, atgo paramatgo, azzd paramazzd, WebView paramWebView, AnimatorSet paramAnimatorSet) {}
  
  public T a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish isCanceled");
      this.jdField_a_of_type_Atgo.dismiss();
      return null;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish bitmap is null");
      this.jdField_a_of_type_Atgo.dismiss();
      return null;
    }
    return this.jdField_a_of_type_Azzd.a(paramBitmap);
  }
  
  public void a(Exception paramException)
  {
    this.jdField_a_of_type_Azzd.a(paramException);
    this.jdField_a_of_type_Atgo.dismiss();
  }
  
  public void a(T paramT, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap isCanceled");
      this.jdField_a_of_type_Atgo.dismiss();
      return;
    }
    if (paramT == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap t is null");
      this.jdField_a_of_type_Atgo.dismiss();
      return;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap bitmap is null");
      this.jdField_a_of_type_Atgo.dismiss();
      this.jdField_a_of_type_Azzd.a(new NullPointerException("postBitmap bitmap is null"));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView.getContext() != null) && (this.jdField_a_of_type_Atgo.isShowing()))
    {
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      this.jdField_a_of_type_Atgo.dismiss();
    }
    this.jdField_a_of_type_Azzd.a(paramT, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azzc
 * JD-Core Version:    0.7.0.1
 */