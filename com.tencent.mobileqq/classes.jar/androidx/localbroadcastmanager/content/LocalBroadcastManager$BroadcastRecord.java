package androidx.localbroadcastmanager.content;

import android.content.Intent;
import java.util.ArrayList;

final class LocalBroadcastManager$BroadcastRecord
{
  final Intent intent;
  final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
  
  LocalBroadcastManager$BroadcastRecord(Intent paramIntent, ArrayList<LocalBroadcastManager.ReceiverRecord> paramArrayList)
  {
    this.intent = paramIntent;
    this.receivers = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord
 * JD-Core Version:    0.7.0.1
 */