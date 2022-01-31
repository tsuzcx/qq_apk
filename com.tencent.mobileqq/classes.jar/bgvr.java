import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Map;

final class bgvr
  implements View.OnClickListener
{
  bgvr(View.OnClickListener paramOnClickListener, long paramLong, View paramView, float[] paramArrayOfFloat, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    long l = 0L;
    paramView = (Long)bgvp.a().get(Long.valueOf(this.jdField_a_of_type_Long));
    if (paramView != null) {
      l = System.currentTimeMillis() - paramView.longValue();
    }
    int j = this.jdField_a_of_type_AndroidViewView.getWidth() / 5;
    int k = this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
    if (this.jdField_a_of_type_ArrayOfFloat[1] > k) {}
    for (int i = (int)this.jdField_a_of_type_ArrayOfFloat[0] / j + 6;; i = (int)this.jdField_a_of_type_ArrayOfFloat[0] / j + 1)
    {
      QMLog.d("BannerAdViolationManage", "box = " + j + "," + k + " size = " + this.jdField_a_of_type_AndroidViewView.getWidth() + "," + this.jdField_a_of_type_AndroidViewView.getHeight() + " x,y = " + this.jdField_a_of_type_ArrayOfFloat[0] + "," + this.jdField_a_of_type_ArrayOfFloat[1] + " area = " + i);
      bgvp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvr
 * JD-Core Version:    0.7.0.1
 */