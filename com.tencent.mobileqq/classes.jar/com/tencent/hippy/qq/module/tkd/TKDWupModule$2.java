package com.tencent.hippy.qq.module.tkd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class TKDWupModule$2
  extends BroadcastReceiver
{
  TKDWupModule$2(TKDWupModule paramTKDWupModule) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.this$0.app.removeObserver(this.this$0.mUniteSearchObserver);
    this.this$0.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.this$0.app.addObserver(this.this$0.mUniteSearchObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDWupModule.2
 * JD-Core Version:    0.7.0.1
 */