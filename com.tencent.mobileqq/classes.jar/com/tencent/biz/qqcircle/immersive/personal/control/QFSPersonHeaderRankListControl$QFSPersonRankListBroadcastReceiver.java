package com.tencent.biz.qqcircle.immersive.personal.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QFSPersonHeaderRankListControl$QFSPersonRankListBroadcastReceiver
  extends BroadcastReceiver
{
  private WeakReference<QFSPersonHeaderRankListControl> a;
  
  public QFSPersonHeaderRankListControl$QFSPersonRankListBroadcastReceiver(QFSPersonHeaderRankListControl paramQFSPersonHeaderRankListControl)
  {
    this.a = new WeakReference(paramQFSPersonHeaderRankListControl);
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
      paramContext = (QFSPersonHeaderRankListControl)paramContext.get();
    }
    if (paramContext == null)
    {
      QLog.w("RANK-QCirclePersonHeaderRankListControl", 1, "[onReceive] rank list control should not be null.");
      return;
    }
    if (TextUtils.equals(paramIntent.getAction(), "action_user_wearing_medal_update")) {
      QFSPersonHeaderRankListControl.a(paramContext, paramIntent.getStringExtra("json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.control.QFSPersonHeaderRankListControl.QFSPersonRankListBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */