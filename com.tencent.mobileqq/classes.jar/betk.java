import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class betk
  implements URLDrawableDownListener
{
  final String jdField_a_of_type_JavaLangString;
  final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  final String b;
  
  public betk(View paramView, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramView != null)
    {
      QLog.e("Q.profilecard.FrdProfileCard", 1, this.jdField_a_of_type_JavaLangString + this.b);
      paramView.setVisibility(8);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramView != null) {
      paramView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betk
 * JD-Core Version:    0.7.0.1
 */