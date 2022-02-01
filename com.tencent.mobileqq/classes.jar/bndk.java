import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bndk
  implements View.OnClickListener
{
  bndk(bndj parambndj, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bndj.a.jdField_a_of_type_Bnew != null) && (this.jdField_a_of_type_Bndj.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)) {
      this.jdField_a_of_type_Bndj.a.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndk
 * JD-Core Version:    0.7.0.1
 */