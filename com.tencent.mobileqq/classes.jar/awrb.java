import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awrb
  implements View.OnClickListener
{
  public awrb(PngFrameManager.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.this$0.e(this.a.a);
        if (this.a.a.jdField_a_of_type_Awre != null) {
          this.a.a.jdField_a_of_type_Awre.a(this.a.a.jdField_a_of_type_Ahbj);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrb
 * JD-Core Version:    0.7.0.1
 */