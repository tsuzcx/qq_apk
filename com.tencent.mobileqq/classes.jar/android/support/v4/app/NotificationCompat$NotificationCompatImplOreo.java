package android.support.v4.app;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

class NotificationCompat$NotificationCompatImplOreo
  implements NotificationCompat.NotificationCompatImpl
{
  public Notification build(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatOreo localNotificationCompatOreo = new NotificationCompatOreo(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mChannelId);
    Iterator localIterator = paramBuilder.mActions.iterator();
    while (localIterator.hasNext())
    {
      NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
      localNotificationCompatOreo.addAction(localAction.icon, localAction.title, localAction.actionIntent);
    }
    if (paramBuilder.mStyle != null)
    {
      if (!(paramBuilder.mStyle instanceof NotificationCompat.BigTextStyle)) {
        break label176;
      }
      paramBuilder = (NotificationCompat.BigTextStyle)paramBuilder.mStyle;
      localNotificationCompatOreo.addBigTextStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mBigText);
    }
    for (;;)
    {
      return localNotificationCompatOreo.build();
      label176:
      if ((paramBuilder.mStyle instanceof NotificationCompat.InboxStyle))
      {
        paramBuilder = (NotificationCompat.InboxStyle)paramBuilder.mStyle;
        localNotificationCompatOreo.addInboxStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mTexts);
      }
      else if ((paramBuilder.mStyle instanceof NotificationCompat.BigPictureStyle))
      {
        paramBuilder = (NotificationCompat.BigPictureStyle)paramBuilder.mStyle;
        localNotificationCompatOreo.addBigPictureStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mPicture, paramBuilder.mBigLargeIcon, paramBuilder.mBigLargeIconSet);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplOreo
 * JD-Core Version:    0.7.0.1
 */