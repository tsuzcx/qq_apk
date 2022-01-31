import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.atomic.AtomicBoolean;

final class bbag
  implements bbah<T>
{
  bbag(AtomicBoolean paramAtomicBoolean, audu paramaudu, bbah parambbah, WebView paramWebView, AnimatorSet paramAnimatorSet) {}
  
  public T a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish isCanceled");
      this.jdField_a_of_type_Audu.dismiss();
      return null;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish bitmap is null");
      this.jdField_a_of_type_Audu.dismiss();
      return null;
    }
    return this.jdField_a_of_type_Bbah.a(paramBitmap);
  }
  
  public void a(Exception paramException)
  {
    this.jdField_a_of_type_Bbah.a(paramException);
    this.jdField_a_of_type_Audu.dismiss();
  }
  
  public void a(T paramT, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap isCanceled");
      this.jdField_a_of_type_Audu.dismiss();
      return;
    }
    if (paramT == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap t is null");
      this.jdField_a_of_type_Audu.dismiss();
      return;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap bitmap is null");
      this.jdField_a_of_type_Audu.dismiss();
      this.jdField_a_of_type_Bbah.a(new NullPointerException("postBitmap bitmap is null"));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView.getContext() != null) && (this.jdField_a_of_type_Audu.isShowing()))
    {
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      this.jdField_a_of_type_Audu.dismiss();
    }
    this.jdField_a_of_type_Bbah.a(paramT, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbag
 * JD-Core Version:    0.7.0.1
 */