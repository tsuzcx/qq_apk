package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

class ActivityResultRegistry$CallbackAndContract<O>
{
  final ActivityResultCallback<O> mCallback;
  final ActivityResultContract<?, O> mContract;
  
  ActivityResultRegistry$CallbackAndContract(ActivityResultCallback<O> paramActivityResultCallback, ActivityResultContract<?, O> paramActivityResultContract)
  {
    this.mCallback = paramActivityResultCallback;
    this.mContract = paramActivityResultContract;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultRegistry.CallbackAndContract
 * JD-Core Version:    0.7.0.1
 */