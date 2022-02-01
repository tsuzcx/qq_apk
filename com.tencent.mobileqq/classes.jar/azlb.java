import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.onlinestatus.OnlineStatusExtInfo.AutoStateBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo.ZodiacBizInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/constellation/ExtensionBizInfoHelper;", "", "()V", "autoStatusTime", "", "packAutoStatusBundle", "Landroid/os/Bundle;", "updateSecond", "extStatus", "", "requestSetAutoStatusExtInfo", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "requestSetConstellationExtInfo", "statusId", "jumpUrl", "", "todayTrend", "tomorrowTrend", "todayDate", "requestSyncAutoStatusExtInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azlb
{
  public static final azlb a = new azlb();
  
  private final Bundle a(long paramLong, int paramInt)
  {
    OnlineStatusExtInfo.AutoStateBizInfo localAutoStateBizInfo = new OnlineStatusExtInfo.AutoStateBizInfo();
    localAutoStateBizInfo.uint64_update_time.set(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("ExtInfo", localAutoStateBizInfo.toByteArray());
    localBundle.putInt("StatusId", paramInt);
    return localBundle;
  }
  
  private final void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSetConstellationExtInfo: called. ", "statusId: " + paramInt + "  todayTrend: " + paramString2 + "  jumpUrl: " + paramString1 });
    }
    paramQQAppInterface = paramQQAppInterface.a(174);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
    }
    paramQQAppInterface = (azll)paramQQAppInterface;
    OnlineStatusExtInfo.ZodiacBizInfo localZodiacBizInfo = new OnlineStatusExtInfo.ZodiacBizInfo();
    localZodiacBizInfo.string_miniapp.set(paramString1);
    localZodiacBizInfo.string_today_trend.set(paramString2);
    localZodiacBizInfo.string_tomorrow_trend.set(paramString3);
    localZodiacBizInfo.string_today_date.set(paramString4);
    paramString1 = new Bundle();
    paramString1.putByteArray("ExtInfo", localZodiacBizInfo.toByteArray());
    paramString1.putInt("StatusId", paramInt);
    paramQQAppInterface.a(3, paramString1, null);
  }
  
  public final long a()
  {
    return NetConnInfoCenter.getServerTimeMillis() / 1000L;
  }
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Object localObject = paramQQAppInterface.getManager(51);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    localObject = (anyw)localObject;
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = azla.e(paramQQAppInterface);
    Intrinsics.checkExpressionValueIsNotNull(str1, "uin");
    a(paramQQAppInterface, paramInt, str2, azla.a((anyw)localObject, str1), azla.b((anyw)localObject, str1), azla.b());
  }
  
  public final void a(@NotNull QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramQQAppInterface = paramQQAppInterface.a(174);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
    }
    ((azll)paramQQAppInterface).a(3, a(paramLong, paramInt), null);
    if (QLog.isColorLevel()) {
      QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSetAutoStatusExtInfo: called. ", "updateSecond: " + paramLong + "  extStatus: " + paramInt });
    }
  }
  
  public final void b(@NotNull QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Object localObject = paramQQAppInterface.getManager(369);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusManager");
    }
    localObject = (azic)localObject;
    boolean bool = ((azic)localObject).a().a(40000);
    if (bool)
    {
      paramQQAppInterface = paramQQAppInterface.a(174);
      if (paramQQAppInterface == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
      }
      ((azll)paramQQAppInterface).a(3, a(paramLong, paramInt));
      long l = NetConnInfoCenter.getServerTime();
      ((azic)localObject).a().a(40000, l);
      if (QLog.isColorLevel()) {
        QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSyncAutoStatusExtInfo: called. (每次执行sync后，需要刷新本地的更新时间，用于下次限频判断) ", "serverTime: " + l });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSyncAutoStatusExtInfo: called. ", "updateSecond: " + paramLong + "  extStatus: " + paramInt + "  expired: " + bool });
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSyncAutoStatusExtInfo: called. (触发限频逻辑，不用频繁上报) ", "expired: " + bool });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlb
 * JD-Core Version:    0.7.0.1
 */