package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment
  extends AppCompatDialogFragment
{
  private boolean a;
  
  private void a()
  {
    if (this.a)
    {
      super.dismissAllowingStateLoss();
      return;
    }
    super.dismiss();
  }
  
  private void a(@NonNull BottomSheetBehavior<?> paramBottomSheetBehavior, boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (paramBottomSheetBehavior.b() == 5)
    {
      a();
      return;
    }
    if ((getDialog() instanceof BottomSheetDialog)) {
      ((BottomSheetDialog)getDialog()).a();
    }
    paramBottomSheetBehavior.a(new BottomSheetDialogFragment.BottomSheetDismissCallback(this, null));
    paramBottomSheetBehavior.d(5);
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = getDialog();
    if ((localObject instanceof BottomSheetDialog))
    {
      localObject = (BottomSheetDialog)localObject;
      BottomSheetBehavior localBottomSheetBehavior = ((BottomSheetDialog)localObject).a();
      if ((localBottomSheetBehavior.a()) && (((BottomSheetDialog)localObject).a()))
      {
        a(localBottomSheetBehavior, paramBoolean);
        return true;
      }
    }
    return false;
  }
  
  public void dismiss()
  {
    if (!a(false)) {
      super.dismiss();
    }
  }
  
  public void dismissAllowingStateLoss()
  {
    if (!a(true)) {
      super.dismissAllowingStateLoss();
    }
  }
  
  @NonNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    return new BottomSheetDialog(getContext(), getTheme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialogFragment
 * JD-Core Version:    0.7.0.1
 */