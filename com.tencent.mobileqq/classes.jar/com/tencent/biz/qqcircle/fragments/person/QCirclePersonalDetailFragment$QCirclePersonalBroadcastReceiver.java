package com.tencent.biz.qqcircle.fragments.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class QCirclePersonalDetailFragment$QCirclePersonalBroadcastReceiver
  extends BroadcastReceiver
{
  private WeakReference<QCirclePersonalDetailFragment> a;
  
  public QCirclePersonalDetailFragment$QCirclePersonalBroadcastReceiver(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment)
  {
    this.a = new WeakReference(paramQCirclePersonalDetailFragment);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (QCirclePersonalDetailFragment)this.a.get();
    if ((paramContext != null) && (paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_reload_get_main_page")) && (paramIntent.hasExtra("uin")) && (paramIntent.getStringExtra("uin").equals(QCirclePersonalDetailFragment.h(paramContext))))
    {
      QCirclePersonalDetailFragment.a(paramContext, false);
      QCirclePersonalDetailFragment.b(paramContext, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment.QCirclePersonalBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */