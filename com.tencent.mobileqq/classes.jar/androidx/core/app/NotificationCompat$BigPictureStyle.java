package androidx.core.app;

import android.app.Notification.BigPictureStyle;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.annotation.RestrictTo;

public class NotificationCompat$BigPictureStyle
  extends NotificationCompat.Style
{
  private Bitmap mBigLargeIcon;
  private boolean mBigLargeIconSet;
  private Bitmap mPicture;
  
  public NotificationCompat$BigPictureStyle() {}
  
  public NotificationCompat$BigPictureStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramNotificationBuilderWithBuilderAccessor = new Notification.BigPictureStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
      if (this.mBigLargeIconSet) {
        paramNotificationBuilderWithBuilderAccessor.bigLargeIcon(this.mBigLargeIcon);
      }
      if (this.mSummaryTextSet) {
        paramNotificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
      }
    }
  }
  
  public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
  {
    this.mBigLargeIcon = paramBitmap;
    this.mBigLargeIconSet = true;
    return this;
  }
  
  public BigPictureStyle bigPicture(Bitmap paramBitmap)
  {
    this.mPicture = paramBitmap;
    return this;
  }
  
  public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.BigPictureStyle
 * JD-Core Version:    0.7.0.1
 */