import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqed
  implements View.OnClickListener
{
  bqed(bqeb parambqeb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bqeb.a.jdField_a_of_type_Bqhs != null) && (this.jdField_a_of_type_Bqeb.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)) {
      this.jdField_a_of_type_Bqeb.a.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqed
 * JD-Core Version:    0.7.0.1
 */