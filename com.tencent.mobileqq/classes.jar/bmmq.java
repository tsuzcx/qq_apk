import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvServlet$Companion;", "", "()V", "CALLBACK_MAP", "", "", "Lcooperation/vip/VasAdvCallback;", "DEFAULT_VALUE_TIMEOUT", "", "RSP_HEADER_LENGTH", "", "SEND_EXTRA_KEY_CMD", "SEND_EXTRA_KEY_DATA", "SEND_EXTRA_KEY_REQ_UUID", "SEND_EXTRA_KEY_TIMEOUT", "TAG", "send", "", "cmd", "uuid", "data", "", "callback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmmq
{
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull bmkd parambmkd)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString2, "uuid");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Intrinsics.checkParameterIsNotNull(parambmkd, "callback");
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "appRuntime");
      NewIntent localNewIntent = new NewIntent((Context)((AppRuntime)localObject).getApplication(), bmmp.class);
      localNewIntent.putExtra("cmd", paramString1);
      localNewIntent.putExtra("req_uuid", paramString2);
      localNewIntent.putExtra("data", bhjl.a(paramArrayOfByte));
      ((AppRuntime)localObject).startServlet(localNewIntent);
      bmmp.a().put(paramString2, parambmkd);
      return;
    }
    catch (Exception paramString1)
    {
      bmmp.a().remove(paramString2);
      parambmkd.a("send cmd failed", (Throwable)paramString1);
      QLog.e("VasAdvServlet", 1, "requestAdv error: " + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmq
 * JD-Core Version:    0.7.0.1
 */