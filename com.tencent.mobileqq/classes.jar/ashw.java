import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/emosm/web/RequestModuleManager$Companion;", "", "()V", "TAG", "", "sHandlers", "", "Lcom/tencent/mobileqq/emosm/web/RequestModuleManager$RequestModule;", "getRequestModule", "key", "registerHandler", "", "clazz", "Ljava/lang/Class;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ashw
{
  @JvmStatic
  @Nullable
  public final ashx a(@Nullable String paramString)
  {
    return (ashx)ashv.a().get(paramString);
  }
  
  @JvmStatic
  public final void a(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Object localObject2;
    int j;
    int i;
    try
    {
      Object localObject1 = paramClass.newInstance();
      if (localObject1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e(ashv.a(), 1, "registerHandler new instance error: " + localException);
          localObject2 = null;
        }
        paramClass = paramClass.getDeclaredMethods();
      } while (paramClass == null);
      j = paramClass.length;
      i = 0;
    }
    label67:
    Object localObject3;
    Object localObject4;
    if (i < j)
    {
      localObject3 = paramClass[i];
      localObject4 = (asic)localObject3.getAnnotation(asic.class);
      if ((localObject4 != null) && (ashv.a().get(((asic)localObject4).a()) == null)) {
        break label119;
      }
    }
    for (;;)
    {
      i += 1;
      break label67;
      break;
      label119:
      Map localMap = ashv.a();
      localObject4 = ((asic)localObject4).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "m");
      localMap.put(localObject4, new ashx(localObject3, localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashw
 * JD-Core Version:    0.7.0.1
 */