package com.tencent.biz.qqcircle.immersive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import java.lang.ref.WeakReference;

class QFSPersonalDetailsFragment$QFSPersonalBroadcastReceiver
  extends BroadcastReceiver
{
  private final WeakReference<QFSPersonalDetailsFragment> a;
  
  public QFSPersonalDetailsFragment$QFSPersonalBroadcastReceiver(QFSPersonalDetailsFragment paramQFSPersonalDetailsFragment)
  {
    this.a = new WeakReference(paramQFSPersonalDetailsFragment);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = (QFSPersonalDetailsFragment)this.a.get();
    if ((localObject != null) && (((QFSPersonalDetailsFragment)localObject).d != null))
    {
      if (paramIntent == null) {
        return;
      }
      paramContext = paramIntent.getAction();
      localObject = ((QFSPersonalDetailsFragment)localObject).d;
      if ((TextUtils.equals(paramContext, "action_reload_get_main_page")) && (paramIntent.hasExtra("uin")) && (paramIntent.getStringExtra("uin").equals(((QFSPersonalViewModel)localObject).n()))) {
        ((QFSPersonalViewModel)localObject).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment.QFSPersonalBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */