import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class azhz
  implements bcwh
{
  public azhz(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.a == null) || (!this.a.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      bcpw.a(BaseApplicationImpl.getContext(), 2, 2131719476, 1).a();
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      bcpw.a(BaseApplicationImpl.getContext(), 2, 2131719495, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhz
 * JD-Core Version:    0.7.0.1
 */