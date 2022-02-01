package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

public class AlertDialog$Builder
{
  private final AlertController.AlertParams P;
  private final int mTheme;
  
  public AlertDialog$Builder(@NonNull Context paramContext)
  {
    this(paramContext, AlertDialog.resolveDialogTheme(paramContext, 0));
  }
  
  public AlertDialog$Builder(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    this.P = new AlertController.AlertParams(new ContextThemeWrapper(paramContext, AlertDialog.resolveDialogTheme(paramContext, paramInt)));
    this.mTheme = paramInt;
  }
  
  @NonNull
  public AlertDialog create()
  {
    AlertDialog localAlertDialog = new AlertDialog(this.P.mContext, this.mTheme);
    this.P.apply(localAlertDialog.mAlert);
    localAlertDialog.setCancelable(this.P.mCancelable);
    if (this.P.mCancelable) {
      localAlertDialog.setCanceledOnTouchOutside(true);
    }
    localAlertDialog.setOnCancelListener(this.P.mOnCancelListener);
    localAlertDialog.setOnDismissListener(this.P.mOnDismissListener);
    if (this.P.mOnKeyListener != null) {
      localAlertDialog.setOnKeyListener(this.P.mOnKeyListener);
    }
    return localAlertDialog;
  }
  
  @NonNull
  public Context getContext()
  {
    return this.P.mContext;
  }
  
  public Builder setAdapter(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mAdapter = paramListAdapter;
    localAlertParams.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setCancelable(boolean paramBoolean)
  {
    this.P.mCancelable = paramBoolean;
    return this;
  }
  
  public Builder setCursor(Cursor paramCursor, DialogInterface.OnClickListener paramOnClickListener, String paramString)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mCursor = paramCursor;
    localAlertParams.mLabelColumn = paramString;
    localAlertParams.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setCustomTitle(@Nullable View paramView)
  {
    this.P.mCustomTitleView = paramView;
    return this;
  }
  
  public Builder setIcon(@DrawableRes int paramInt)
  {
    this.P.mIconId = paramInt;
    return this;
  }
  
  public Builder setIcon(@Nullable Drawable paramDrawable)
  {
    this.P.mIcon = paramDrawable;
    return this;
  }
  
  public Builder setIconAttribute(@AttrRes int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.P.mContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    this.P.mIconId = localTypedValue.resourceId;
    return this;
  }
  
  @Deprecated
  public Builder setInverseBackgroundForced(boolean paramBoolean)
  {
    this.P.mForceInverseBackground = paramBoolean;
    return this;
  }
  
  public Builder setItems(@ArrayRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mItems = localAlertParams.mContext.getResources().getTextArray(paramInt);
    this.P.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setItems(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mItems = paramArrayOfCharSequence;
    localAlertParams.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public Builder setMessage(@StringRes int paramInt)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mMessage = localAlertParams.mContext.getText(paramInt);
    return this;
  }
  
  public Builder setMessage(@Nullable CharSequence paramCharSequence)
  {
    this.P.mMessage = paramCharSequence;
    return this;
  }
  
  public Builder setMultiChoiceItems(@ArrayRes int paramInt, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mItems = localAlertParams.mContext.getResources().getTextArray(paramInt);
    localAlertParams = this.P;
    localAlertParams.mOnCheckboxClickListener = paramOnMultiChoiceClickListener;
    localAlertParams.mCheckedItems = paramArrayOfBoolean;
    localAlertParams.mIsMultiChoice = true;
    return this;
  }
  
  public Builder setMultiChoiceItems(Cursor paramCursor, String paramString1, String paramString2, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mCursor = paramCursor;
    localAlertParams.mOnCheckboxClickListener = paramOnMultiChoiceClickListener;
    localAlertParams.mIsCheckedColumn = paramString1;
    localAlertParams.mLabelColumn = paramString2;
    localAlertParams.mIsMultiChoice = true;
    return this;
  }
  
  public Builder setMultiChoiceItems(CharSequence[] paramArrayOfCharSequence, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mItems = paramArrayOfCharSequence;
    localAlertParams.mOnCheckboxClickListener = paramOnMultiChoiceClickListener;
    localAlertParams.mCheckedItems = paramArrayOfBoolean;
    localAlertParams.mIsMultiChoice = true;
    return this;
  }
  
  public Builder setNegativeButton(@StringRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mNegativeButtonText = localAlertParams.mContext.getText(paramInt);
    this.P.mNegativeButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNegativeButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mNegativeButtonText = paramCharSequence;
    localAlertParams.mNegativeButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNegativeButtonIcon(Drawable paramDrawable)
  {
    this.P.mNegativeButtonIcon = paramDrawable;
    return this;
  }
  
  public Builder setNeutralButton(@StringRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mNeutralButtonText = localAlertParams.mContext.getText(paramInt);
    this.P.mNeutralButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNeutralButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mNeutralButtonText = paramCharSequence;
    localAlertParams.mNeutralButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setNeutralButtonIcon(Drawable paramDrawable)
  {
    this.P.mNeutralButtonIcon = paramDrawable;
    return this;
  }
  
  public Builder setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.P.mOnCancelListener = paramOnCancelListener;
    return this;
  }
  
  public Builder setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.P.mOnDismissListener = paramOnDismissListener;
    return this;
  }
  
  public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.P.mOnItemSelectedListener = paramOnItemSelectedListener;
    return this;
  }
  
  public Builder setOnKeyListener(DialogInterface.OnKeyListener paramOnKeyListener)
  {
    this.P.mOnKeyListener = paramOnKeyListener;
    return this;
  }
  
  public Builder setPositiveButton(@StringRes int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mPositiveButtonText = localAlertParams.mContext.getText(paramInt);
    this.P.mPositiveButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setPositiveButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mPositiveButtonText = paramCharSequence;
    localAlertParams.mPositiveButtonListener = paramOnClickListener;
    return this;
  }
  
  public Builder setPositiveButtonIcon(Drawable paramDrawable)
  {
    this.P.mPositiveButtonIcon = paramDrawable;
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Builder setRecycleOnMeasureEnabled(boolean paramBoolean)
  {
    this.P.mRecycleOnMeasure = paramBoolean;
    return this;
  }
  
  public Builder setSingleChoiceItems(@ArrayRes int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mItems = localAlertParams.mContext.getResources().getTextArray(paramInt1);
    localAlertParams = this.P;
    localAlertParams.mOnClickListener = paramOnClickListener;
    localAlertParams.mCheckedItem = paramInt2;
    localAlertParams.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setSingleChoiceItems(Cursor paramCursor, int paramInt, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mCursor = paramCursor;
    localAlertParams.mOnClickListener = paramOnClickListener;
    localAlertParams.mCheckedItem = paramInt;
    localAlertParams.mLabelColumn = paramString;
    localAlertParams.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setSingleChoiceItems(ListAdapter paramListAdapter, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mAdapter = paramListAdapter;
    localAlertParams.mOnClickListener = paramOnClickListener;
    localAlertParams.mCheckedItem = paramInt;
    localAlertParams.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setSingleChoiceItems(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mItems = paramArrayOfCharSequence;
    localAlertParams.mOnClickListener = paramOnClickListener;
    localAlertParams.mCheckedItem = paramInt;
    localAlertParams.mIsSingleChoice = true;
    return this;
  }
  
  public Builder setTitle(@StringRes int paramInt)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mTitle = localAlertParams.mContext.getText(paramInt);
    return this;
  }
  
  public Builder setTitle(@Nullable CharSequence paramCharSequence)
  {
    this.P.mTitle = paramCharSequence;
    return this;
  }
  
  public Builder setView(int paramInt)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mView = null;
    localAlertParams.mViewLayoutResId = paramInt;
    localAlertParams.mViewSpacingSpecified = false;
    return this;
  }
  
  public Builder setView(View paramView)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mView = paramView;
    localAlertParams.mViewLayoutResId = 0;
    localAlertParams.mViewSpacingSpecified = false;
    return this;
  }
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Builder setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AlertController.AlertParams localAlertParams = this.P;
    localAlertParams.mView = paramView;
    localAlertParams.mViewLayoutResId = 0;
    localAlertParams.mViewSpacingSpecified = true;
    localAlertParams.mViewSpacingLeft = paramInt1;
    localAlertParams.mViewSpacingTop = paramInt2;
    localAlertParams.mViewSpacingRight = paramInt3;
    localAlertParams.mViewSpacingBottom = paramInt4;
    return this;
  }
  
  public AlertDialog show()
  {
    AlertDialog localAlertDialog = create();
    localAlertDialog.show();
    return localAlertDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertDialog.Builder
 * JD-Core Version:    0.7.0.1
 */