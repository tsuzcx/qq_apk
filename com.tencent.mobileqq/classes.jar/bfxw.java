import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

class bfxw
  implements View.OnClickListener
{
  bfxw(bfxu parambfxu, bfxy parambfxy) {}
  
  public void onClick(View paramView)
  {
    if ((bfxu.a(this.jdField_a_of_type_Bfxu) != null) && (bfxu.a(this.jdField_a_of_type_Bfxu).isShowing())) {
      bfxu.a(this.jdField_a_of_type_Bfxu).dismiss();
    }
    if ((this.jdField_a_of_type_Bfxy != null) && (bfxu.a(this.jdField_a_of_type_Bfxu) != null)) {
      this.jdField_a_of_type_Bfxy.a(bfxu.a(this.jdField_a_of_type_Bfxu).getTimeInMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxw
 * JD-Core Version:    0.7.0.1
 */