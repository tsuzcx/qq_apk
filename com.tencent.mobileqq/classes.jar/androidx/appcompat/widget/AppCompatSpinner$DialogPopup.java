package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;

@VisibleForTesting
class AppCompatSpinner$DialogPopup
  implements DialogInterface.OnClickListener, AppCompatSpinner.SpinnerPopup
{
  private ListAdapter mListAdapter;
  @VisibleForTesting
  AlertDialog mPopup;
  private CharSequence mPrompt;
  
  AppCompatSpinner$DialogPopup(AppCompatSpinner paramAppCompatSpinner) {}
  
  public void dismiss()
  {
    AlertDialog localAlertDialog = this.mPopup;
    if (localAlertDialog != null)
    {
      localAlertDialog.dismiss();
      this.mPopup = null;
    }
  }
  
  public Drawable getBackground()
  {
    return null;
  }
  
  public CharSequence getHintText()
  {
    return this.mPrompt;
  }
  
  public int getHorizontalOffset()
  {
    return 0;
  }
  
  public int getHorizontalOriginalOffset()
  {
    return 0;
  }
  
  public int getVerticalOffset()
  {
    return 0;
  }
  
  public boolean isShowing()
  {
    AlertDialog localAlertDialog = this.mPopup;
    if (localAlertDialog != null) {
      return localAlertDialog.isShowing();
    }
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.setSelection(paramInt);
    if (this.this$0.getOnItemClickListener() != null) {
      this.this$0.performItemClick(null, paramInt, this.mListAdapter.getItemId(paramInt));
    }
    dismiss();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.mListAdapter = paramListAdapter;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
  }
  
  public void setHorizontalOriginalOffset(int paramInt)
  {
    Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
  }
  
  public void setPromptText(CharSequence paramCharSequence)
  {
    this.mPrompt = paramCharSequence;
  }
  
  public void setVerticalOffset(int paramInt)
  {
    Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    if (this.mListAdapter == null) {
      return;
    }
    Object localObject = new AlertDialog.Builder(this.this$0.getPopupContext());
    CharSequence localCharSequence = this.mPrompt;
    if (localCharSequence != null) {
      ((AlertDialog.Builder)localObject).setTitle(localCharSequence);
    }
    this.mPopup = ((AlertDialog.Builder)localObject).setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
    localObject = this.mPopup.getListView();
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((ListView)localObject).setTextDirection(paramInt1);
      ((ListView)localObject).setTextAlignment(paramInt2);
    }
    this.mPopup.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner.DialogPopup
 * JD-Core Version:    0.7.0.1
 */