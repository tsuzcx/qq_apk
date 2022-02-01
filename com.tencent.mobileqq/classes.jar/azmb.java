import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/pluspanel/PlusPanelRedPointAppIdInterface;", "Lcom/tencent/mobileqq/app/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "()V", "getAioPanelRedDotIds", "", "", "appInterface", "Lcom/tencent/common/app/AppInterface;", "getRedPointPaths", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azmb
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  private final List<String> a(AppInterface paramAppInterface)
  {
    Set localSet = (Set)new HashSet();
    Object localObject2;
    int i;
    try
    {
      localObject1 = C2CPlusPanelAppConfigHelper.INSTANCE.getC2CAppInfo();
      if (localObject1 != null)
      {
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)localObject3;
            Intrinsics.checkExpressionValueIsNotNull(localPlusPanelAppInfo, "it");
            if (localPlusPanelAppInfo.getRedDotID() > 0)
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              ((Collection)localObject1).add(localObject3);
              continue;
              return (List)new ArrayList((Collection)localSet);
            }
          }
        }
      }
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("PlusPanelRedPointAppIdInterface", 1, paramAppInterface, new Object[0]);
    }
    do
    {
      i = 0;
      break;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PlusPanelAppInfo)((Iterator)localObject1).next();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        localSet.add(String.valueOf(((PlusPanelAppInfo)localObject2).getRedDotID()));
      }
    } while (!(paramAppInterface instanceof QQAppInterface));
    paramAppInterface = bfbz.a((QQAppInterface)paramAppInterface);
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "aioGroupAppsManager");
    paramAppInterface = paramAppInterface.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "appInfoList");
    Object localObject1 = (Iterable)paramAppInterface;
    paramAppInterface = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label264:
    label359:
    label362:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((TroopAIOAppInfo)localObject2).appid <= 0) {
          break label359;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label362;
        }
        paramAppInterface.add(localObject2);
        break label264;
        paramAppInterface = ((Iterable)paramAppInterface).iterator();
        while (paramAppInterface.hasNext()) {
          localSet.add(String.valueOf(((TroopAIOAppInfo)paramAppInterface.next()).appid));
        }
        break;
      }
    }
  }
  
  @NotNull
  public List<String> getRedPointPaths(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "appInterface");
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanelRedPointAppIdInterface", 2, "getRedPointPaths");
    }
    return a(paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmb
 * JD-Core Version:    0.7.0.1
 */