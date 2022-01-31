import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.widget.QQViewPager;

class apuq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  apuq(apuo paramapuo, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_Apuo.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apuo.a.a.getMeasuredHeight() != 0)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.height = ((int)(this.jdField_a_of_type_Apuo.a.a.getMeasuredHeight() * 0.6F));
        localLayoutParams.width = ((int)(localLayoutParams.height * 1.3F));
        localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Apuo.a.a.getMeasuredHeight() * 0.08F));
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
      return;
      this.jdField_a_of_type_Apuo.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apuq
 * JD-Core Version:    0.7.0.1
 */