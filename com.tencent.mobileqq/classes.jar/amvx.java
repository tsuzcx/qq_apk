import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$Companion;", "", "()V", "TAG", "", "timeout", "", "getTimeout", "()J", "callBackError", "", "actionContext", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "errorState", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvx
{
  private final void a(amvr paramamvr, CMSActionStatus paramCMSActionStatus)
  {
    CMSAction localCMSAction = paramamvr.a();
    paramamvr.a().a(localCMSAction, paramCMSActionStatus);
    paramamvr.a().a(localCMSAction, false, CMSAction.a(localCMSAction, null, null, 3, null), null);
  }
  
  public final long a()
  {
    return amvq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvx
 * JD-Core Version:    0.7.0.1
 */