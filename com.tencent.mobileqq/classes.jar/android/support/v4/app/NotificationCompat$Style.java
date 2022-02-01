package android.support.v4.app;

import android.app.Notification;

public abstract class NotificationCompat$Style
{
  CharSequence mBigContentTitle;
  NotificationCompat.Builder mBuilder;
  CharSequence mSummaryText;
  boolean mSummaryTextSet = false;
  
  public Notification build()
  {
    NotificationCompat.Builder localBuilder = this.mBuilder;
    if (localBuilder != null) {
      return localBuilder.build();
    }
    return null;
  }
  
  public void setBuilder(NotificationCompat.Builder paramBuilder)
  {
    if (this.mBuilder != paramBuilder)
    {
      this.mBuilder = paramBuilder;
      paramBuilder = this.mBuilder;
      if (paramBuilder != null) {
        paramBuilder.setStyle(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Style
 * JD-Core Version:    0.7.0.1
 */