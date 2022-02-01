import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blkj
  implements View.OnClickListener
{
  blkj(blki paramblki, blkm paramblkm) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Blkm.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkj
 * JD-Core Version:    0.7.0.1
 */