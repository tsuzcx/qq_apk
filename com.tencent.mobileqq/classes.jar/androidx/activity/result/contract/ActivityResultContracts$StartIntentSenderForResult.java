package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ActivityResultContracts$StartIntentSenderForResult
  extends ActivityResultContract<IntentSenderRequest, ActivityResult>
{
  public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
  public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
  public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";
  
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull IntentSenderRequest paramIntentSenderRequest)
  {
    return new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", paramIntentSenderRequest);
  }
  
  @NonNull
  public ActivityResult parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    return new ActivityResult(paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult
 * JD-Core Version:    0.7.0.1
 */