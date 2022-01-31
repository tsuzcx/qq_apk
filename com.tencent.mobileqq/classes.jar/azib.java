import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class azib
  implements bcww
{
  public azib(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.a == null) || (!this.a.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      bcql.a(BaseApplicationImpl.getContext(), 2, 2131719487, 1).a();
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      bcql.a(BaseApplicationImpl.getContext(), 2, 2131719506, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azib
 * JD-Core Version:    0.7.0.1
 */