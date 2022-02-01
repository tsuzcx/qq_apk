import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.view.ImgHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhsj
  implements View.OnClickListener
{
  public bhsj(ImgHeaderView paramImgHeaderView, Activity paramActivity, QQVipMsgInfo paramQQVipMsgInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewImgHeaderView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo.paMsgid, this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo.gameAppId, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsj
 * JD-Core Version:    0.7.0.1
 */