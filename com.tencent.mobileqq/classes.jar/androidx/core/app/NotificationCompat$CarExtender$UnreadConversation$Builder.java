package androidx.core.app;

import android.app.PendingIntent;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat$CarExtender$UnreadConversation$Builder
{
  private long mLatestTimestamp;
  private final List<String> mMessages = new ArrayList();
  private final String mParticipant;
  private PendingIntent mReadPendingIntent;
  private RemoteInput mRemoteInput;
  private PendingIntent mReplyPendingIntent;
  
  public NotificationCompat$CarExtender$UnreadConversation$Builder(String paramString)
  {
    this.mParticipant = paramString;
  }
  
  public Builder addMessage(String paramString)
  {
    this.mMessages.add(paramString);
    return this;
  }
  
  public NotificationCompat.CarExtender.UnreadConversation build()
  {
    String[] arrayOfString = (String[])this.mMessages.toArray(new String[this.mMessages.size()]);
    String str = this.mParticipant;
    RemoteInput localRemoteInput = this.mRemoteInput;
    PendingIntent localPendingIntent1 = this.mReplyPendingIntent;
    PendingIntent localPendingIntent2 = this.mReadPendingIntent;
    long l = this.mLatestTimestamp;
    return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, localRemoteInput, localPendingIntent1, localPendingIntent2, new String[] { str }, l);
  }
  
  public Builder setLatestTimestamp(long paramLong)
  {
    this.mLatestTimestamp = paramLong;
    return this;
  }
  
  public Builder setReadPendingIntent(PendingIntent paramPendingIntent)
  {
    this.mReadPendingIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setReplyAction(PendingIntent paramPendingIntent, RemoteInput paramRemoteInput)
  {
    this.mRemoteInput = paramRemoteInput;
    this.mReplyPendingIntent = paramPendingIntent;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.CarExtender.UnreadConversation.Builder
 * JD-Core Version:    0.7.0.1
 */