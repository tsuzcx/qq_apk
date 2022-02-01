package androidx.core.app;

import android.app.Notification.InboxStyle;
import android.os.Build.VERSION;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;

public class NotificationCompat$InboxStyle
  extends NotificationCompat.Style
{
  private ArrayList<CharSequence> mTexts = new ArrayList();
  
  public NotificationCompat$InboxStyle() {}
  
  public NotificationCompat$InboxStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  public InboxStyle addLine(CharSequence paramCharSequence)
  {
    this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramNotificationBuilderWithBuilderAccessor = new Notification.InboxStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
      if (this.mSummaryTextSet) {
        paramNotificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
      }
      Iterator localIterator = this.mTexts.iterator();
      while (localIterator.hasNext()) {
        paramNotificationBuilderWithBuilderAccessor.addLine((CharSequence)localIterator.next());
      }
    }
  }
  
  public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public InboxStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.InboxStyle
 * JD-Core Version:    0.7.0.1
 */