package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.DialogInterface.OnDismissListener;

class DialogFragment$1
  implements Runnable
{
  DialogFragment$1(DialogFragment paramDialogFragment) {}
  
  @SuppressLint({"SyntheticAccessor"})
  public void run()
  {
    DialogFragment.access$100(this.this$0).onDismiss(DialogFragment.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.DialogFragment.1
 * JD-Core Version:    0.7.0.1
 */