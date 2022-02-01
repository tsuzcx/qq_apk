import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class bcyy
  implements WXShareHelper.WXShareListener
{
  public bcyy(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      yyi.a(1, 2131718380);
    }
    for (;;)
    {
      WXShareHelper.getInstance().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTeamWorkTransparentShareActivity.a);
      return;
      yyi.a(2, 2131718398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyy
 * JD-Core Version:    0.7.0.1
 */