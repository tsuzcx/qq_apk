import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class befx
  implements biyn
{
  public befx(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, String paramString) {}
  
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
      znl.a(1, 2131718766);
    }
    for (;;)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTeamWorkTransparentShareActivity.a);
      return;
      znl.a(2, 2131718784);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befx
 * JD-Core Version:    0.7.0.1
 */