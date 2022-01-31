package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

class NotificationCompatHoneycomb
{
  static Notification add(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    if ((paramNotification.flags & 0x2) != 0)
    {
      bool1 = true;
      paramContext = paramContext.setOngoing(bool1);
      if ((paramNotification.flags & 0x8) == 0) {
        break label213;
      }
      bool1 = true;
      label111:
      paramContext = paramContext.setOnlyAlertOnce(bool1);
      if ((paramNotification.flags & 0x10) == 0) {
        break label219;
      }
      bool1 = true;
      label131:
      paramContext = paramContext.setAutoCancel(bool1).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0) {
        break label225;
      }
    }
    label213:
    label219:
    label225:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return paramContext.setFullScreenIntent(paramPendingIntent2, bool1).setLargeIcon(paramBitmap).setNumber(paramInt).getNotification();
      bool1 = false;
      break;
      bool1 = false;
      break label111;
      bool1 = false;
      break label131;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatHoneycomb
 * JD-Core Version:    0.7.0.1
 */