import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avmt
  implements View.OnClickListener
{
  public avmt(ImgHeaderView paramImgHeaderView, Activity paramActivity, QQGameMsgInfo paramQQGameMsgInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewImgHeaderView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmt
 * JD-Core Version:    0.7.0.1
 */