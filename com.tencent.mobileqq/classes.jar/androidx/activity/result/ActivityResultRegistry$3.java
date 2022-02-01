package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

class ActivityResultRegistry$3
  extends ActivityResultLauncher<I>
{
  ActivityResultRegistry$3(ActivityResultRegistry paramActivityResultRegistry, int paramInt, ActivityResultContract paramActivityResultContract, String paramString) {}
  
  @NonNull
  public ActivityResultContract<I, ?> getContract()
  {
    return this.val$contract;
  }
  
  public void launch(I paramI, @Nullable ActivityOptionsCompat paramActivityOptionsCompat)
  {
    this.this$0.onLaunch(this.val$requestCode, this.val$contract, paramI, paramActivityOptionsCompat);
  }
  
  public void unregister()
  {
    this.this$0.unregister(this.val$key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultRegistry.3
 * JD-Core Version:    0.7.0.1
 */