import com.tencent.common.app.AppInterface;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/pluspanel/PlusPanelRedPointAppIdInterface;", "Lcom/tencent/mobileqq/app/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "()V", "getAioPanelRedDotIds", "", "", "getRedPointPaths", "appInterface", "Lcom/tencent/common/app/AppInterface;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class awhr
  implements alkq
{
  private final List<String> a()
  {
    Set localSet = (Set)new HashSet();
    Object localObject2;
    int i;
    try
    {
      Object localObject1 = awhs.a(false);
      if (localObject1 != null)
      {
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label140;
          }
          Object localObject3 = ((Iterator)localObject2).next();
          String str = ((TroopAIOAppInfo)localObject3).redDotID;
          Intrinsics.checkExpressionValueIsNotNull(str, "it.redDotID");
          if (Integer.parseInt(str) <= 0) {
            break;
          }
          i = 1;
          if (i != 0) {
            ((Collection)localObject1).add(localObject3);
          }
        }
      }
      return (List)new ArrayList((Collection)localSet);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PlusPanelRedPointAppIdInterface", 1, localThrowable, new Object[0]);
    }
    for (;;)
    {
      i = 0;
      break;
      label140:
      Iterator localIterator = ((Iterable)localThrowable).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = ((TroopAIOAppInfo)localIterator.next()).redDotID;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.redDotID");
        localSet.add(localObject2);
      }
    }
  }
  
  @NotNull
  public List<String> a(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "appInterface");
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanelRedPointAppIdInterface", 2, "getRedPointPaths");
    }
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awhr
 * JD-Core Version:    0.7.0.1
 */