package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_0xb7e.RspBody;

class DiandianTopConfigManager$1
  extends ProtoUtils.AppProtocolObserver
{
  DiandianTopConfigManager$1(DiandianTopConfigManager paramDiandianTopConfigManager, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      try
      {
        paramBundle = new oidb_0xb7e.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.rpt_top_item.has()) {
          break label129;
        }
        List localList = paramBundle.rpt_top_item.get();
        if ((localList == null) || (localList.size() <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(DiandianTopConfigManager.a, 2, "requestDiandianTopConfig rpt_top_item is empty");
          }
          ReadInJoyLogicEngineEventDispatcher.a().a(true, null);
          DiandianTopConfigManager.a(this.a, paramArrayOfByte, 0L);
          return;
        }
        DiandianTopConfigManager.a(this.a, paramArrayOfByte, System.currentTimeMillis());
        if (!this.b) {
          return;
        }
        DiandianTopConfigManager.a(this.a, paramBundle);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e(DiandianTopConfigManager.a, 2, "requestDiandianTopConfig parser failed");
      return;
      label129:
      if (QLog.isColorLevel()) {
        QLog.d(DiandianTopConfigManager.a, 2, "requestDiandianTopConfig rpt_top_item is empty");
      }
      DiandianTopConfigManager.a(this.a, paramArrayOfByte, 0L);
      ReadInJoyLogicEngineEventDispatcher.a().a(true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(DiandianTopConfigManager.a, 2, "requestDiandianTopConfig failed errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.1
 * JD-Core Version:    0.7.0.1
 */