import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/NotificationBuilder;", "", "()V", "build", "Landroid/app/Notification;", "contentIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayuq
{
  public static final ayuq a = new ayuq();
  
  @RequiresApi(16)
  @NotNull
  public final Notification a(@Nullable PendingIntent paramPendingIntent, @NotNull ayut paramayut)
  {
    Intrinsics.checkParameterIsNotNull(paramayut, "pushComponent");
    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
    localBigTextStyle.bigText((CharSequence)paramayut.c);
    paramPendingIntent = new NotificationCompat.Builder((Context)BaseApplication.context).setSmallIcon(2130841403).setAutoCancel(true).setContentText((CharSequence)paramayut.c).setWhen(System.currentTimeMillis()).setTicker((CharSequence)paramayut.c).setContentIntent(paramPendingIntent).setPriority(2).setStyle((NotificationCompat.Style)localBigTextStyle);
    if (!TextUtils.isEmpty((CharSequence)paramayut.a)) {
      paramPendingIntent.setContentTitle((CharSequence)paramayut.a);
    }
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      paramPendingIntent.setChannelId("CHANNEL_ID_OTHER");
    }
    paramayut = ayuu.a.a(paramayut.b);
    if (paramayut != null) {
      paramPendingIntent.setLargeIcon(paramayut);
    }
    paramPendingIntent = paramPendingIntent.build();
    Intrinsics.checkExpressionValueIsNotNull(paramPendingIntent, "notifyBuilder.build()");
    return paramPendingIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuq
 * JD-Core Version:    0.7.0.1
 */