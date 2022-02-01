package com.tencent.mobileqq.activity.framebusiness;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;

final class QCircleInjectImpl$6
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ThreadManagerV2.excute(new QCircleInjectImpl.6.1(this, paramIntent), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.6
 * JD-Core Version:    0.7.0.1
 */