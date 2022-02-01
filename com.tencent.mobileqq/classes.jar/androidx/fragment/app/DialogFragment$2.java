package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import androidx.annotation.Nullable;

class DialogFragment$2
  implements DialogInterface.OnCancelListener
{
  DialogFragment$2(DialogFragment paramDialogFragment) {}
  
  @SuppressLint({"SyntheticAccessor"})
  public void onCancel(@Nullable DialogInterface paramDialogInterface)
  {
    if (DialogFragment.access$000(this.this$0) != null) {
      this.this$0.onCancel(DialogFragment.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.DialogFragment.2
 * JD-Core Version:    0.7.0.1
 */