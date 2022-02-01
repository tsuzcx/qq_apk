import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bffi
  implements View.OnClickListener
{
  bffi(bffh parambffh, bffj parambffj, MediaPreviewInfo paramMediaPreviewInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bffj.a.setVisibility(8);
    this.jdField_a_of_type_Bffh.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewInfo, this.jdField_a_of_type_Bffj);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffi
 * JD-Core Version:    0.7.0.1
 */