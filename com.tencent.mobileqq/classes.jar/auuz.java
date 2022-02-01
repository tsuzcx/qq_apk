import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.util.List;

public class auuz
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WeakReference<ImageSwitcher> jdField_a_of_type_JavaLangRefWeakReference;
  private List<String> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 1;
  private WeakReference<ImageSwitcher> jdField_b_of_type_JavaLangRefWeakReference;
  
  public auuz(ImageSwitcher paramImageSwitcher1, ImageSwitcher paramImageSwitcher2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageSwitcher1);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramImageSwitcher2);
    paramImageSwitcher1.setAnimateFirstView(false);
    paramImageSwitcher1.setAnimateFirstView(false);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1400L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(1400L);
    paramImageSwitcher1.setInAnimation(localAlphaAnimation1);
    paramImageSwitcher2.setInAnimation(localAlphaAnimation2);
    localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(1400L);
    paramImageSwitcher1.setOutAnimation(localAlphaAnimation1);
    paramImageSwitcher2.setOutAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
    if (QLog.isColorLevel()) {
      QLog.d("QQGameImagePlayHelper", 0, "[startPlay] set next image :" + this);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameImagePlayHelper", 0, "[handleMessage] set next image");
      }
      int i;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        paramMessage = (ImageSwitcher)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        if (i == this.jdField_a_of_type_JavaUtilList.size()) {
          this.jdField_a_of_type_Int = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)));
      }
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        paramMessage = (ImageSwitcher)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        i = this.jdField_b_of_type_Int + 1;
        this.jdField_b_of_type_Int = i;
        if (i == this.jdField_a_of_type_JavaUtilList.size()) {
          this.jdField_b_of_type_Int = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
      return false;
    }
    catch (Exception paramMessage)
    {
      QLog.e("QQGameImagePlayHelper", 1, "[handleMessage] ");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuz
 * JD-Core Version:    0.7.0.1
 */