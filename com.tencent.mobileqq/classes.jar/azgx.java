import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azgx
  implements View.OnClickListener
{
  azgx(azgv paramazgv, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Azgv.a != null) {
      this.jdField_a_of_type_Azgv.a.b(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgx
 * JD-Core Version:    0.7.0.1
 */