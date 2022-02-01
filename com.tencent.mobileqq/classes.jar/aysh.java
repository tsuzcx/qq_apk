import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "defaultDateFormat", "Ljava/text/SimpleDateFormat;", "getDefaultDateFormat", "()Ljava/text/SimpleDateFormat;", "defaultRequestDateFormat", "getDefaultRequestDateFormat", "bgImageUrlFromEntity", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "constellationLinkFromEntity", "constellationRequestTsFromSp", "", "constellationTextColorFromSp", "currentDate", "currentRequestDate", "extInfoRequestIntervalSecondFromSp", "getCurrentProfileConstellation", "uin", "getMsfDate", "Ljava/util/Date;", "iconUrlFromEntity", "isConstellationRequestExpired", "", "isConstellationStatus", "saveConstellationRequestTsSp", "", "ts", "saveConstellationTextColorSp", "color", "saveExtInfoRequestIntervalSecondSp", "second", "", "saveTodayTrendJsonSp", "todayConstellationTrend", "simpleTrend", "suitableTrend", "friends", "Lcom/tencent/mobileqq/data/Friends;", "todayTrendJsonFromSp", "tomorrowRequestDate", "yesterdayRequestDate", "constellationInfo", "todayTrendFromEntity", "Lcom/tencent/mobileqq/app/FriendsManager;", "tomorrowTrendFromEntity", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class aysh
{
  @NotNull
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
  @NotNull
  private static final SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd");
  
  public static final long a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramQQAppInterface = bgsg.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_ext_info_request_interval_second", Long.valueOf(0L));
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)paramQQAppInterface).longValue();
  }
  
  @NotNull
  public static final String a()
  {
    Object localObject = a();
    localObject = a.format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultDateFormat.format(date)");
    return localObject;
  }
  
  @NotNull
  public static final String a(@NotNull anmw paramanmw, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramanmw, "$this$todayTrendFromEntity");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    paramanmw = paramanmw.d(paramString).constellationTodayTrend;
    if (paramanmw != null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationUtil", 2, new Object[] { "todayTrendFromEntity: called. ", "trend: " + paramanmw });
      }
      return paramanmw;
      paramanmw = "";
    }
  }
  
  @NotNull
  public static final String a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramQQAppInterface = bgsg.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_today_constellation_trends_json", "");
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    return (String)paramQQAppInterface;
  }
  
  @NotNull
  public static final String a(@NotNull QQAppInterface paramQQAppInterface, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    paramQQAppInterface = paramQQAppInterface.getManager(51);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    paramQQAppInterface = ((anmw)paramQQAppInterface).d(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "friends");
    return b(paramQQAppInterface);
  }
  
  @NotNull
  public static final String a(@NotNull Friends paramFriends)
  {
    Intrinsics.checkParameterIsNotNull(paramFriends, "$this$constellationInfo");
    return " uin: " + paramFriends.uin + " constellationTodayTrend: " + paramFriends.constellationTodayTrend + ' ' + "constellationTomorrowTrend: " + paramFriends.constellationTomorrowTrend + ' ' + "constellationDateStr: " + paramFriends.constellationDateStr;
  }
  
  @NotNull
  public static final SimpleDateFormat a()
  {
    return a;
  }
  
  private static final Date a()
  {
    return new Date(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    bgsg.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), true, "key_ext_info_request_interval_second", Integer.valueOf(paramInt));
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    bgsg.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), true, "key_constellation_last_request_second", Long.valueOf(paramLong));
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Context localContext = (Context)BaseApplicationImpl.context;
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    if (paramString != null) {}
    for (;;)
    {
      bgsg.a(localContext, paramQQAppInterface, true, "key_today_constellation_trends_json", paramString);
      return;
      paramString = "";
    }
  }
  
  public static final boolean a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = a(paramQQAppInterface);
    if (l1 - b(paramQQAppInterface) >= l2) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationUtil", 2, new Object[] { "isConstellationRequestExpired: called. ", "expired: " + bool });
      }
      return bool;
    }
  }
  
  public static final long b(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramQQAppInterface = bgsg.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_constellation_last_request_second", Long.valueOf(0L));
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)paramQQAppInterface).longValue();
  }
  
  @NotNull
  public static final String b()
  {
    Object localObject = a();
    localObject = b.format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultRequestDateFormat.format(date)");
    return localObject;
  }
  
  @NotNull
  public static final String b(@NotNull anmw paramanmw, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramanmw, "$this$tomorrowTrendFromEntity");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    paramanmw = paramanmw.d(paramString).constellationTomorrowTrend;
    if (paramanmw != null) {
      return paramanmw;
    }
    return "";
  }
  
  @Nullable
  public static final String b(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Manager localManager = paramQQAppInterface.getManager(51);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    paramQQAppInterface = ((anmw)localManager).d(paramQQAppInterface.c()).constellationIconUrl;
    if (paramQQAppInterface != null) {
      return paramQQAppInterface;
    }
    return "";
  }
  
  @NotNull
  public static final String b(@NotNull QQAppInterface paramQQAppInterface, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    paramQQAppInterface = bght.c(bghy.a(paramQQAppInterface, paramString).constellation);
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "constellationStr");
    return paramQQAppInterface;
  }
  
  @NotNull
  public static final String b(@NotNull Friends paramFriends)
  {
    Intrinsics.checkParameterIsNotNull(paramFriends, "friends");
    Object localObject;
    if (Intrinsics.areEqual(b(), paramFriends.constellationDateStr))
    {
      localObject = paramFriends.constellationTodayTrend;
      if (localObject == null) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationUtil", 2, new Object[] { "suitableTrend: called. ", a(paramFriends) });
      }
      return localObject;
      localObject = "";
      continue;
      if (Intrinsics.areEqual(d(), paramFriends.constellationDateStr))
      {
        String str = paramFriends.constellationTomorrowTrend;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
      else
      {
        localObject = "";
      }
    }
  }
  
  public static final void b(@NotNull QQAppInterface paramQQAppInterface, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "color");
    bgsg.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), true, "key_constellation_text_color", paramString);
  }
  
  public static final boolean b(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    return (paramQQAppInterface.getOnlineStatus() == AppRuntime.Status.online) && (paramQQAppInterface.getExtOnlineStatus() == 1040);
  }
  
  @NotNull
  public static final String c()
  {
    Object localObject = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cal");
    ((Calendar)localObject).setTime(a());
    ((Calendar)localObject).add(5, 1);
    localObject = b.format(((Calendar)localObject).getTime());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultRequestDateFormat.format(cal.time)");
    return localObject;
  }
  
  @Nullable
  public static final String c(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Manager localManager = paramQQAppInterface.getManager(51);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    paramQQAppInterface = ((anmw)localManager).d(paramQQAppInterface.c()).constellationBgImageUrl;
    if (paramQQAppInterface != null) {
      return paramQQAppInterface;
    }
    return "";
  }
  
  @NotNull
  public static final String d()
  {
    Object localObject = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cal");
    ((Calendar)localObject).setTime(a());
    ((Calendar)localObject).add(5, -1);
    localObject = b.format(((Calendar)localObject).getTime());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultRequestDateFormat.format(cal.time)");
    return localObject;
  }
  
  @NotNull
  public static final String d(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramQQAppInterface = bgsg.a((Context)BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_constellation_text_color", "");
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    return (String)paramQQAppInterface;
  }
  
  @NotNull
  public static final String e(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Manager localManager = paramQQAppInterface.getManager(51);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    paramQQAppInterface = ((anmw)localManager).d(paramQQAppInterface.c()).constellationJumpUrl;
    if (paramQQAppInterface != null) {
      return paramQQAppInterface;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysh
 * JD-Core Version:    0.7.0.1
 */