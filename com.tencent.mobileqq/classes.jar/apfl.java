import android.view.View;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.doutu.DoutuData;
import java.util.HashMap;

class apfl
  implements URLDrawableDownListener
{
  apfl(apfk paramapfk) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof apfm)))
    {
      paramView = (apfm)paramView;
      if (paramView.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      }
      if (this.a.a == null) {
        this.a.a = new HashMap();
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_md5 != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_down_url != null)) {
        this.a.a.put(paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_md5, paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_down_url);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfl
 * JD-Core Version:    0.7.0.1
 */