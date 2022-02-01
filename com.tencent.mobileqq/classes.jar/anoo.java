import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anoo
  implements bjig
{
  public anoo(ApolloGameInvitation.1 param1) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((anon.a(this.a.this$0) == null) || (!anon.a(this.a.this$0).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameInvitation", 1, "[onWXShareResp], resp.errCode:" + paramBaseResp.errCode);
      if (paramBaseResp.errCode != 0) {
        break;
      }
    } while ((anon.a(this.a.this$0) == null) || (anon.a(this.a.this$0) == null) || ((AppInterface)anon.a(this.a.this$0).get() == null));
    VipUtils.a(null, "cmshow", "Apollo", "wechat_invite_sent", 0, 0, new String[] { Integer.toString(anon.a(this.a.this$0).a) });
    if (paramBaseResp.errCode == 0) {
      anon.a(this.a.this$0, 0, 2);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (paramBaseResp.errCode == -2) {
        anon.a(this.a.this$0, 2, 2);
      } else {
        anon.a(this.a.this$0, 1, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoo
 * JD-Core Version:    0.7.0.1
 */