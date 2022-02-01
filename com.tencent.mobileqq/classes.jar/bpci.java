import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpci
  implements View.OnClickListener
{
  bpci(bpcg parambpcg, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bpcg.a.jdField_a_of_type_Bpfx != null) && (this.jdField_a_of_type_Bpcg.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)) {
      this.jdField_a_of_type_Bpcg.a.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpci
 * JD-Core Version:    0.7.0.1
 */