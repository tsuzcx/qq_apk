package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment
  extends DialogFragment
{
  @NonNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    return new AppCompatDialog(getContext(), getTheme());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setupDialog(@NonNull Dialog paramDialog, int paramInt)
  {
    if ((paramDialog instanceof AppCompatDialog))
    {
      AppCompatDialog localAppCompatDialog = (AppCompatDialog)paramDialog;
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramInt != 3) {
          return;
        }
        paramDialog.getWindow().addFlags(24);
      }
      localAppCompatDialog.supportRequestWindowFeature(1);
      return;
    }
    super.setupDialog(paramDialog, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDialogFragment
 * JD-Core Version:    0.7.0.1
 */