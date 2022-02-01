package androidx.activity;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContract.SynchronousResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import java.util.ArrayList;
import java.util.List;

class ComponentActivity$2
  extends ActivityResultRegistry
{
  ComponentActivity$2(ComponentActivity paramComponentActivity) {}
  
  public <I, O> void onLaunch(int paramInt, @NonNull ActivityResultContract<I, O> paramActivityResultContract, I paramI, @Nullable ActivityOptionsCompat paramActivityOptionsCompat)
  {
    ComponentActivity localComponentActivity = this.this$0;
    ActivityResultContract.SynchronousResult localSynchronousResult = paramActivityResultContract.getSynchronousResult(localComponentActivity, paramI);
    if (localSynchronousResult != null)
    {
      new Handler(Looper.getMainLooper()).post(new ComponentActivity.2.1(this, paramInt, localSynchronousResult));
      return;
    }
    paramI = paramActivityResultContract.createIntent(localComponentActivity, paramI);
    paramActivityResultContract = null;
    if (paramI.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE"))
    {
      paramActivityResultContract = paramI.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
      paramI.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
    }
    else if (paramActivityOptionsCompat != null)
    {
      paramActivityResultContract = paramActivityOptionsCompat.toBundle();
    }
    if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(paramI.getAction()))
    {
      paramActivityResultContract = paramI.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
      if (paramActivityResultContract == null) {
        return;
      }
      paramI = new ArrayList();
      int j = paramActivityResultContract.length;
      int i = 0;
      while (i < j)
      {
        paramActivityOptionsCompat = paramActivityResultContract[i];
        if (this.this$0.checkPermission(paramActivityOptionsCompat, Process.myPid(), Process.myUid()) != 0) {
          paramI.add(paramActivityOptionsCompat);
        }
        i += 1;
      }
      if (!paramI.isEmpty()) {
        ActivityCompat.requestPermissions(localComponentActivity, (String[])paramI.toArray(new String[0]), paramInt);
      }
    }
    else
    {
      if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(paramI.getAction()))
      {
        paramI = (IntentSenderRequest)paramI.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try
        {
          ActivityCompat.startIntentSenderForResult(localComponentActivity, paramI.getIntentSender(), paramInt, paramI.getFillInIntent(), paramI.getFlagsMask(), paramI.getFlagsValues(), 0, paramActivityResultContract);
          return;
        }
        catch (IntentSender.SendIntentException paramActivityResultContract)
        {
          new Handler(Looper.getMainLooper()).post(new ComponentActivity.2.2(this, paramInt, paramActivityResultContract));
          return;
        }
      }
      ActivityCompat.startActivityForResult(localComponentActivity, paramI, paramInt, paramActivityResultContract);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.ComponentActivity.2
 * JD-Core Version:    0.7.0.1
 */