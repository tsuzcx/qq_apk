package com.tencent.biz.qqcircle.fragments.person.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QCirclePersonHeaderRankListControl$QCirclePersonRankListBroadcastReceiver
  extends BroadcastReceiver
{
  private WeakReference<QCirclePersonHeaderRankListControl> a;
  
  public QCirclePersonHeaderRankListControl$QCirclePersonRankListBroadcastReceiver(QCirclePersonHeaderRankListControl paramQCirclePersonHeaderRankListControl)
  {
    this.a = new WeakReference(paramQCirclePersonHeaderRankListControl);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[onReceive] intent should not be null.");
      return;
    }
    paramContext = this.a;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = (QCirclePersonHeaderRankListControl)paramContext.get();
    }
    if (paramContext == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[onReceive] rank list control should not be null.");
      return;
    }
    if (TextUtils.equals(paramIntent.getAction(), "action_user_wearing_medal_update")) {
      QCirclePersonHeaderRankListControl.a(paramContext, paramIntent.getStringExtra("json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderRankListControl.QCirclePersonRankListBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */