import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgvx
  implements View.OnClickListener
{
  bgvx(bgvw parambgvw, bgvy parambgvy, MediaPreviewInfo paramMediaPreviewInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bgvy.a.setVisibility(8);
    this.jdField_a_of_type_Bgvw.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewInfo, this.jdField_a_of_type_Bgvy);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvx
 * JD-Core Version:    0.7.0.1
 */