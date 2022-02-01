package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

public class AlertDialog
  extends AppCompatDialog
  implements DialogInterface
{
  static final int LAYOUT_HINT_NONE = 0;
  static final int LAYOUT_HINT_SIDE = 1;
  final AlertController mAlert = new AlertController(getContext(), this, getWindow());
  
  protected AlertDialog(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  protected AlertDialog(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    super(paramContext, resolveDialogTheme(paramContext, paramInt));
  }
  
  protected AlertDialog(@NonNull Context paramContext, boolean paramBoolean, @Nullable DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this(paramContext, 0);
    setCancelable(paramBoolean);
    setOnCancelListener(paramOnCancelListener);
  }
  
  static int resolveDialogTheme(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) >= 1) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2131034181, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public Button getButton(int paramInt)
  {
    return this.mAlert.getButton(paramInt);
  }
  
  public ListView getListView()
  {
    return this.mAlert.getListView();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mAlert.installContent();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mAlert.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mAlert.onKeyUp(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.mAlert.setButton(paramInt, paramCharSequence, paramOnClickListener, null, null);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.mAlert.setButton(paramInt, paramCharSequence, paramOnClickListener, null, paramDrawable);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, Message paramMessage)
  {
    this.mAlert.setButton(paramInt, paramCharSequence, null, paramMessage, null);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setButtonPanelLayoutHint(int paramInt)
  {
    this.mAlert.setButtonPanelLayoutHint(paramInt);
  }
  
  public void setCustomTitle(View paramView)
  {
    this.mAlert.setCustomTitle(paramView);
  }
  
  public void setIcon(int paramInt)
  {
    this.mAlert.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mAlert.setIcon(paramDrawable);
  }
  
  public void setIconAttribute(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    getContext().getTheme().resolveAttribute(paramInt, localTypedValue, true);
    this.mAlert.setIcon(localTypedValue.resourceId);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.mAlert.setMessage(paramCharSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.mAlert.setTitle(paramCharSequence);
  }
  
  public void setView(View paramView)
  {
    this.mAlert.setView(paramView);
  }
  
  public void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mAlert.setView(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertDialog
 * JD-Core Version:    0.7.0.1
 */