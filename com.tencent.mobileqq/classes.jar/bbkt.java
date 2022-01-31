import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class bbkt
  implements bfah
{
  public bbkt(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.a == null) || (!this.a.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131720031, 1).a();
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131720050, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkt
 * JD-Core Version:    0.7.0.1
 */