package android.support.v4.app;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

class NotificationCompat$NotificationCompatImplJellybean
  implements NotificationCompat.NotificationCompatImpl
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatJellybean localNotificationCompatJellybean = new NotificationCompatJellybean(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText);
    Iterator localIterator = paramBuilder.mActions.iterator();
    while (localIterator.hasNext())
    {
      NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
      localNotificationCompatJellybean.addAction(localAction.icon, localAction.title, localAction.actionIntent);
    }
    if (paramBuilder.mStyle != null)
    {
      if (!(paramBuilder.mStyle instanceof NotificationCompat.BigTextStyle)) {
        break label172;
      }
      paramBuilder = (NotificationCompat.BigTextStyle)paramBuilder.mStyle;
      localNotificationCompatJellybean.addBigTextStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mBigText);
    }
    for (;;)
    {
      return localNotificationCompatJellybean.build();
      label172:
      if ((paramBuilder.mStyle instanceof NotificationCompat.InboxStyle))
      {
        paramBuilder = (NotificationCompat.InboxStyle)paramBuilder.mStyle;
        localNotificationCompatJellybean.addInboxStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mTexts);
      }
      else if ((paramBuilder.mStyle instanceof NotificationCompat.BigPictureStyle))
      {
        paramBuilder = (NotificationCompat.BigPictureStyle)paramBuilder.mStyle;
        localNotificationCompatJellybean.addBigPictureStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mPicture, paramBuilder.mBigLargeIcon, paramBuilder.mBigLargeIconSet);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean
 * JD-Core Version:    0.7.0.1
 */