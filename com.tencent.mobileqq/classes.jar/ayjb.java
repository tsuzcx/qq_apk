import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class ayjb
  implements bcwh
{
  public ayjb(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      wim.a(1, 2131719476);
    }
    for (;;)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTeamWorkTransparentShareActivity.a);
      return;
      wim.a(2, 2131719495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayjb
 * JD-Core Version:    0.7.0.1
 */