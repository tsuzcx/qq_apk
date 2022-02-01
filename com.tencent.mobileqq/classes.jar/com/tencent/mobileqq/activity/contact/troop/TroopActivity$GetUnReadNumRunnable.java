package com.tencent.mobileqq.activity.contact.troop;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class TroopActivity$GetUnReadNumRunnable
  implements Runnable
{
  private QQAppInterface a;
  private WeakReference<TroopActivity> b;
  private TextView c;
  private ImageView d;
  
  public TroopActivity$GetUnReadNumRunnable(QQAppInterface paramQQAppInterface, WeakReference<TroopActivity> paramWeakReference, TextView paramTextView, ImageView paramImageView)
  {
    this.a = paramQQAppInterface;
    this.b = paramWeakReference;
    this.c = paramTextView;
    this.d = paramImageView;
  }
  
  private boolean a()
  {
    return (this.b.get() != null) && (!((TroopActivity)this.b.get()).isFinishing()) && (this.d != null) && (this.c != null);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      int i = localQQAppInterface.getMessageFacade().w();
      ThreadManager.getUIHandler().post(new TroopActivity.GetUnReadNumRunnable.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.GetUnReadNumRunnable
 * JD-Core Version:    0.7.0.1
 */