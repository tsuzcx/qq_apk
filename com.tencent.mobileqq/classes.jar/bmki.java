import com.tencent.mobileqq.pb.PBInt32Field;
import cooperation.vip.VasAdvService;
import cooperation.vip.VasAdvService.ServiceCode;
import cooperation.vip.VasAdvService.requestAd.1;
import cooperation.vip.pb.vac_adv_get.VacAdvRsp;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/VasAdvService$requestAd$1$callback$1", "Lcooperation/vip/VasAdvCallback;", "onError", "", "errMsg", "", "e", "", "onRsp", "rspBytes", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmki
  implements bmkd
{
  public void a(@NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.a.this$0.a(VasAdvService.ServiceCode.REQUEST_CMD_ERROR, "request ad onError: " + paramString);
    VasAdvService.a(this.a.this$0).set(false);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "rspBytes");
    for (;;)
    {
      try
      {
        localVacAdvRsp = new vac_adv_get.VacAdvRsp();
        localVacAdvRsp.mergeFrom(paramArrayOfByte);
        bool = VasAdvService.a(this.a.this$0, localVacAdvRsp);
        if (bool != true) {
          continue;
        }
        this.a.this$0.a(localVacAdvRsp);
      }
      catch (Exception paramArrayOfByte)
      {
        vac_adv_get.VacAdvRsp localVacAdvRsp;
        boolean bool;
        this.a.this$0.a(VasAdvService.ServiceCode.REQUEST_RSP_PARSE_ERR, "parse rsp exception: " + paramArrayOfByte.getMessage());
        continue;
      }
      VasAdvService.a(this.a.this$0).set(false);
      return;
      if (!bool) {
        this.a.this$0.a(VasAdvService.ServiceCode.REQUEST_RSP_FAIL, "rsp err code:" + localVacAdvRsp.err_code.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmki
 * JD-Core Version:    0.7.0.1
 */