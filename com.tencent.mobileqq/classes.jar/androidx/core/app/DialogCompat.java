package androidx.core.app;

import android.app.Dialog;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;

public class DialogCompat
{
  @NonNull
  public static View requireViewById(@NonNull Dialog paramDialog, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramDialog.requireViewById(paramInt);
    }
    paramDialog = paramDialog.findViewById(paramInt);
    if (paramDialog != null) {
      return paramDialog;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.DialogCompat
 * JD-Core Version:    0.7.0.1
 */