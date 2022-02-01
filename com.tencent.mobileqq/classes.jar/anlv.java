import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/ApolloMessageUtils;", "", "()V", "send", "", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "actionId", "", "textType", "peerUin", "", "type", "frome", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anlv
{
  public static final anlv a = new anlv();
  
  public final void a(@Nullable BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2, @Nullable String paramString, int paramInt3, int paramInt4)
  {
    if (paramBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    annl localannl;
    Object localObject;
    do
    {
      do
      {
        return;
        localQQAppInterface = paramBaseChatPie.app;
      } while (localQQAppInterface == null);
      localannl = (annl)new annm(localQQAppInterface.getCurrentUin());
      localObject = localQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.utils.ApolloDaoManager");
      }
      localObject = ((ankc)localObject).a(paramInt1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adm.findActionById(actionId)");
    } while (localObject == null);
    ((ApolloActionData)localObject).peerUin = paramString;
    ((ApolloActionData)localObject).isForPlayerAction = 1;
    localannl.a = ((ApolloActionData)localObject);
    localannl.a.personNum = paramInt3;
    localannl.d = paramInt2;
    localannl.h = 3;
    paramString = localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.ApolloManager");
    }
    ((amme)paramString).a().b(paramBaseChatPie, localannl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlv
 * JD-Core Version:    0.7.0.1
 */