package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoySettingActivity$TroopProtocolObserver
  extends ProtoUtils.TroopProtocolObserver
{
  private boolean b;
  
  ReadInJoySettingActivity$TroopProtocolObserver(ReadInJoySettingActivity paramReadInJoySettingActivity, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      ReadInJoyHelper.a(ReadInJoyHelper.a(), this.b);
    }
    for (;;)
    {
      ReadInJoySettingActivity.a(this.a);
      return;
      QLog.d("ReadInJoySettingActivity", 1, "troopProtocolObserver fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.TroopProtocolObserver
 * JD-Core Version:    0.7.0.1
 */