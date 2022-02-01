package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class RIJUserLevelTimeUtils$Observer
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.d("RIJUserLevelTimeUtils", 1, "observer ,errorCode=" + paramInt + " ，bundle=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJUserLevelTimeUtils.Observer
 * JD-Core Version:    0.7.0.1
 */