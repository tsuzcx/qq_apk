package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

class NotificationCompatOreo
{
  private Notification.Builder b;
  
  public NotificationCompatOreo(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4, String paramString)
  {
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    if ((paramNotification.flags & 0x2) != 0)
    {
      bool = true;
      paramContext = paramContext.setOngoing(bool);
      if ((paramNotification.flags & 0x8) == 0) {
        break label244;
      }
      bool = true;
      label112:
      paramContext = paramContext.setOnlyAlertOnce(bool);
      if ((paramNotification.flags & 0x10) == 0) {
        break label250;
      }
      bool = true;
      label132:
      paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0) {
        break label256;
      }
    }
    label256:
    for (boolean bool = true;; bool = false)
    {
      this.b = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1).setChannelId(paramString);
      return;
      bool = false;
      break;
      label244:
      bool = false;
      break label112;
      label250:
      bool = false;
      break label132;
    }
  }
  
  public void addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.b.addAction(paramInt, paramCharSequence, paramPendingIntent);
  }
  
  public void addBigPictureStyle(CharSequence paramCharSequence1, boolean paramBoolean1, CharSequence paramCharSequence2, Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean2)
  {
    paramCharSequence1 = new Notification.BigPictureStyle(this.b).setBigContentTitle(paramCharSequence1).bigPicture(paramBitmap1);
    if (paramBoolean2) {
      paramCharSequence1.bigLargeIcon(paramBitmap2);
    }
    if (paramBoolean1) {
      paramCharSequence1.setSummaryText(paramCharSequence2);
    }
  }
  
  public void addBigTextStyle(CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paramCharSequence1 = new Notification.BigTextStyle(this.b).setBigContentTitle(paramCharSequence1).bigText(paramCharSequence3);
    if (paramBoolean) {
      paramCharSequence1.setSummaryText(paramCharSequence2);
    }
  }
  
  public void addInboxStyle(CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, ArrayList<CharSequence> paramArrayList)
  {
    paramCharSequence1 = new Notification.InboxStyle(this.b).setBigContentTitle(paramCharSequence1);
    if (paramBoolean) {
      paramCharSequence1.setSummaryText(paramCharSequence2);
    }
    paramCharSequence2 = paramArrayList.iterator();
    while (paramCharSequence2.hasNext()) {
      paramCharSequence1.addLine((CharSequence)paramCharSequence2.next());
    }
  }
  
  public Notification build()
  {
    return this.b.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatOreo
 * JD-Core Version:    0.7.0.1
 */