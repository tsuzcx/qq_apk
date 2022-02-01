import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/ConstellationView$Companion;", "", "()V", "reqCardDisplaySettingIfNotPrepared", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aytm
{
  public final boolean a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Object localObject = paramQQAppInterface.getManager(51);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    localObject = ((anmw)localObject).c(paramQQAppInterface.c());
    azsn localazsn = azsm.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "selfProfileCard");
    if (localazsn.a(41609, (Card)localObject, paramQQAppInterface) == -1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationView", 2, new Object[] { "onSelectStatusCallback: called. ", "displaySettingNotPrepared: " + bool });
      }
      if (!bool) {
        return bool;
      }
      paramQQAppInterface = paramQQAppInterface.a(182);
      if (paramQQAppInterface != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.profilesetting.CardSettingHandler");
    }
    ((azrh)paramQQAppInterface).a(CollectionsKt.arrayListOf(new Integer[] { Integer.valueOf(41609) }));
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytm
 * JD-Core Version:    0.7.0.1
 */