package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R.style;
import com.google.android.material.dialog.InsetDialogOnTouchListener;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.TESTS})
public class MaterialStyledDatePickerDialog
  extends DatePickerDialog
{
  @StyleRes
  private static final int a = R.style.c;
  @NonNull
  private final Drawable b;
  @NonNull
  private final Rect c;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(this.b);
    getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialStyledDatePickerDialog
 * JD-Core Version:    0.7.0.1
 */