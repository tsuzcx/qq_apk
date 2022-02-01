import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgnp
  implements View.OnClickListener
{
  bgnp(bgno parambgno, bgnq parambgnq, MediaPreviewInfo paramMediaPreviewInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bgnq.a.setVisibility(8);
    this.jdField_a_of_type_Bgno.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewInfo, this.jdField_a_of_type_Bgnq);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnp
 * JD-Core Version:    0.7.0.1
 */