import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avmr
  implements View.OnClickListener
{
  public avmr(ImgHeaderView paramImgHeaderView, Activity paramActivity, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewImgHeaderView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmr
 * JD-Core Version:    0.7.0.1
 */