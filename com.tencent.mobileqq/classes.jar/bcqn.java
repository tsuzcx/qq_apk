import android.content.Context;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.MsgUtils.Proxy;

public final class bcqn
  implements RecentRoute.MsgUtils.Proxy
{
  public void buildMsgSummaryForMsg(Context paramContext, IMCoreAppRuntime paramIMCoreAppRuntime, IMCoreMessageStub paramIMCoreMessageStub, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    bgnr.a(paramContext, paramIMCoreAppRuntime, paramIMCoreMessageStub, paramInt, paramMsgSummary, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqn
 * JD-Core Version:    0.7.0.1
 */