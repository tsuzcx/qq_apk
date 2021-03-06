package androidx.core.app;

import android.app.Notification.BigTextStyle;
import android.os.Build.VERSION;
import androidx.annotation.RestrictTo;

public class NotificationCompat$BigTextStyle
  extends NotificationCompat.Style
{
  private CharSequence mBigText;
  
  public NotificationCompat$BigTextStyle() {}
  
  public NotificationCompat$BigTextStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramNotificationBuilderWithBuilderAccessor = new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
      if (this.mSummaryTextSet) {
        paramNotificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
      }
    }
  }
  
  public BigTextStyle bigText(CharSequence paramCharSequence)
  {
    this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigTextStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.BigTextStyle
 * JD-Core Version:    0.7.0.1
 */