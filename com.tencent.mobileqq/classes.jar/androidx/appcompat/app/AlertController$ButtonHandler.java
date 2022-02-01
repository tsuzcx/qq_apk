package androidx.appcompat.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class AlertController$ButtonHandler
  extends Handler
{
  private static final int MSG_DISMISS_DIALOG = 1;
  private WeakReference<DialogInterface> mDialog;
  
  public AlertController$ButtonHandler(DialogInterface paramDialogInterface)
  {
    this.mDialog = new WeakReference(paramDialogInterface);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != -3) && (i != -2) && (i != -1))
    {
      if (i != 1) {
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
      return;
    }
    ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.mDialog.get(), paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.ButtonHandler
 * JD-Core Version:    0.7.0.1
 */