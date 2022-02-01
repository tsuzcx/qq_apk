package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class LocalBroadcastManager$ReceiverRecord
{
  final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  final IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  LocalBroadcastManager$ReceiverRecord(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    this.jdField_a_of_type_AndroidContentIntentFilter = paramIntentFilter;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramBroadcastReceiver;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Receiver{");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntentFilter);
    if (this.b) {
      localStringBuilder.append(" DEAD");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord
 * JD-Core Version:    0.7.0.1
 */