package androidx.activity;

import androidx.activity.result.contract.ActivityResultContract.SynchronousResult;

class ComponentActivity$2$1
  implements Runnable
{
  ComponentActivity$2$1(ComponentActivity.2 param2, int paramInt, ActivityResultContract.SynchronousResult paramSynchronousResult) {}
  
  public void run()
  {
    this.this$1.dispatchResult(this.val$requestCode, this.val$synchronousResult.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.ComponentActivity.2.1
 * JD-Core Version:    0.7.0.1
 */