package com.tencent.avgame.gamelogic.globalmanage;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.ui.AVGameOverlayFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GlobalExitRoomDialog
{
  public boolean a = false;
  private boolean b = true;
  private BroadcastReceiver c = new GlobalExitRoomDialog.1(this);
  
  public static GlobalExitRoomDialog a()
  {
    return GlobalExitRoomDialog.INNER.a;
  }
  
  private void d()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      MobileQQ.sMobileQQ.registerReceiver(this.c, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onRoomSelfExit: exitType:");
      paramEngineData.append(paramInt);
      paramEngineData.append("  exitRoomTip:");
      paramEngineData.append(paramString);
      QLog.d("GlobalExitRoomManagement", 2, paramEngineData.toString());
    }
    int i = 0;
    switch (paramInt)
    {
    case 0: 
    default: 
      break;
    case 5: 
    case 9: 
    case 10: 
    case 11: 
      bool = false;
      break;
    case 3: 
    case 4: 
    case 6: 
    case 7: 
      bool = true;
      paramInt = 1;
      break;
    }
    boolean bool = false;
    paramInt = i;
    if ((paramInt != 0) && (!this.a) && (this.b))
    {
      paramEngineData = new Intent();
      paramEngineData.putExtra("type", 1);
      paramEngineData.putExtra("tip", paramString);
      paramEngineData.putExtra("public_fragment_window_feature", 1);
      paramEngineData.setFlags(268435456);
      QPublicFragmentActivity.Launcher.a(MobileQQ.sMobileQQ, paramEngineData, QPublicTransFragmentActivity.class, AVGameOverlayFragment.class);
    }
    return bool;
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    MobileQQ.sMobileQQ.unregisterReceiver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.globalmanage.GlobalExitRoomDialog
 * JD-Core Version:    0.7.0.1
 */