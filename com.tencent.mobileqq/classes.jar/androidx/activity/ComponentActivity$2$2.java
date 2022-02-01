package androidx.activity;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;

class ComponentActivity$2$2
  implements Runnable
{
  ComponentActivity$2$2(ComponentActivity.2 param2, int paramInt, IntentSender.SendIntentException paramSendIntentException) {}
  
  public void run()
  {
    this.this$1.dispatchResult(this.val$requestCode, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.val$e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.ComponentActivity.2.2
 * JD-Core Version:    0.7.0.1
 */