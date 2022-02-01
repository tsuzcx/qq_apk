import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvAppImpl;", "Lcooperation/vip/VasAdvAppInterface;", "()V", "account", "", "context", "Landroid/content/Context;", "execute", "", "runnable", "Ljava/lang/Runnable;", "sendCmd", "cmd", "", "cmdKey", "reqBytes", "", "callback", "Lcooperation/vip/VasAdvCallback;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmmk
  implements bmkc
{
  public long a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    return ((AppRuntime)localObject).getLongAccountUin();
  }
  
  @NotNull
  public Context a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplicationImpl.context");
    return (Context)localBaseApplication;
  }
  
  public void a(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    ThreadManager.executeOnSubThread(paramRunnable);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull bmkd parambmkd)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString2, "cmdKey");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reqBytes");
    Intrinsics.checkParameterIsNotNull(parambmkd, "callback");
    bmmp.a.a(paramString1, paramString2, paramArrayOfByte, parambmkd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmk
 * JD-Core Version:    0.7.0.1
 */