package androidx.core.app;

import android.app.PendingIntent;

public class NotificationCompat$CarExtender$UnreadConversation
{
  private final long mLatestTimestamp;
  private final String[] mMessages;
  private final String[] mParticipants;
  private final PendingIntent mReadPendingIntent;
  private final RemoteInput mRemoteInput;
  private final PendingIntent mReplyPendingIntent;
  
  NotificationCompat$CarExtender$UnreadConversation(String[] paramArrayOfString1, RemoteInput paramRemoteInput, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
  {
    this.mMessages = paramArrayOfString1;
    this.mRemoteInput = paramRemoteInput;
    this.mReadPendingIntent = paramPendingIntent2;
    this.mReplyPendingIntent = paramPendingIntent1;
    this.mParticipants = paramArrayOfString2;
    this.mLatestTimestamp = paramLong;
  }
  
  public long getLatestTimestamp()
  {
    return this.mLatestTimestamp;
  }
  
  public String[] getMessages()
  {
    return this.mMessages;
  }
  
  public String getParticipant()
  {
    if (this.mParticipants.length > 0) {
      return this.mParticipants[0];
    }
    return null;
  }
  
  public String[] getParticipants()
  {
    return this.mParticipants;
  }
  
  public PendingIntent getReadPendingIntent()
  {
    return this.mReadPendingIntent;
  }
  
  public RemoteInput getRemoteInput()
  {
    return this.mRemoteInput;
  }
  
  public PendingIntent getReplyPendingIntent()
  {
    return this.mReplyPendingIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.CarExtender.UnreadConversation
 * JD-Core Version:    0.7.0.1
 */