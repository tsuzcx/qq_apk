package com.google.android.material.dialog;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialAlertDialogBuilder
  extends AlertDialog.Builder
{
  @AttrRes
  private static final int jdField_a_of_type_Int = R.attr.alertDialogStyle;
  @StyleRes
  private static final int b = R.style.b;
  @AttrRes
  private static final int c = R.attr.u;
  @Dimension
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  @NonNull
  public MaterialAlertDialogBuilder a(@StringRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setTitle(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@ArrayRes int paramInt1, int paramInt2, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramInt1, paramInt2, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@StringRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setPositiveButton(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@ArrayRes int paramInt, @Nullable boolean[] paramArrayOfBoolean, @Nullable DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramInt, paramArrayOfBoolean, paramOnMultiChoiceClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnCancelListener(paramOnCancelListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnDismissListener(paramOnDismissListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable DialogInterface.OnKeyListener paramOnKeyListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnKeyListener(paramOnKeyListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable Cursor paramCursor, int paramInt, @NonNull String paramString, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramCursor, paramInt, paramString, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable Cursor paramCursor, @Nullable DialogInterface.OnClickListener paramOnClickListener, @NonNull String paramString)
  {
    return (MaterialAlertDialogBuilder)super.setCursor(paramCursor, paramOnClickListener, paramString);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable Cursor paramCursor, @NonNull String paramString1, @NonNull String paramString2, @Nullable DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramCursor, paramString1, paramString2, paramOnMultiChoiceClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable View paramView)
  {
    return (MaterialAlertDialogBuilder)super.setCustomTitle(paramView);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable ListAdapter paramListAdapter, int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramListAdapter, paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable ListAdapter paramListAdapter, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setAdapter(paramListAdapter, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable CharSequence paramCharSequence)
  {
    return (MaterialAlertDialogBuilder)super.setTitle(paramCharSequence);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable CharSequence paramCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setPositiveButton(paramCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(boolean paramBoolean)
  {
    return (MaterialAlertDialogBuilder)super.setCancelable(paramBoolean);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable CharSequence[] paramArrayOfCharSequence, int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramArrayOfCharSequence, paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable CharSequence[] paramArrayOfCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setItems(paramArrayOfCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder a(@Nullable CharSequence[] paramArrayOfCharSequence, @Nullable boolean[] paramArrayOfBoolean, @Nullable DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramArrayOfCharSequence, paramArrayOfBoolean, paramOnMultiChoiceClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder b(@StringRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setMessage(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder b(@StringRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNegativeButton(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder b(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setPositiveButtonIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder b(@Nullable View paramView)
  {
    return (MaterialAlertDialogBuilder)super.setView(paramView);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder b(@Nullable CharSequence paramCharSequence)
  {
    return (MaterialAlertDialogBuilder)super.setMessage(paramCharSequence);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder b(@Nullable CharSequence paramCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNegativeButton(paramCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder c(@DrawableRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setIcon(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder c(@StringRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNeutralButton(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder c(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setNegativeButtonIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder c(@Nullable CharSequence paramCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNeutralButton(paramCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public AlertDialog create()
  {
    AlertDialog localAlertDialog = super.create();
    Window localWindow = localAlertDialog.getWindow();
    View localView = localWindow.getDecorView();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable instanceof MaterialShapeDrawable)) {
      ((MaterialShapeDrawable)localDrawable).r(ViewCompat.getElevation(localView));
    }
    localWindow.setBackgroundDrawable(MaterialDialogs.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsRect));
    localView.setOnTouchListener(new InsetDialogOnTouchListener(localAlertDialog, this.jdField_a_of_type_AndroidGraphicsRect));
    return localAlertDialog;
  }
  
  @NonNull
  public MaterialAlertDialogBuilder d(@AttrRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setIconAttribute(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder d(@ArrayRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setItems(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder d(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setNeutralButtonIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder e(int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setView(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.dialog.MaterialAlertDialogBuilder
 * JD-Core Version:    0.7.0.1
 */