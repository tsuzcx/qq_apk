package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.TroopNickNameManager.TroopNickNameUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class FeedsPlayModeBase$TroopNickNameUpdateEventReceiver
  extends QQUIEventReceiver
{
  public FeedsPlayModeBase$TroopNickNameUpdateEventReceiver(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase)
  {
    super(paramFeedsPlayModeBase);
  }
  
  public void a(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase, @NonNull TroopNickNameManager.TroopNickNameUpdateEvent paramTroopNickNameUpdateEvent)
  {
    if (paramTroopNickNameUpdateEvent.a.isSuccess())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 2, "TroopNickNameUpdateEvent");
      }
      paramFeedsPlayModeBase.d();
    }
  }
  
  public Class acceptEventClass()
  {
    return TroopNickNameManager.TroopNickNameUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase.TroopNickNameUpdateEventReceiver
 * JD-Core Version:    0.7.0.1
 */