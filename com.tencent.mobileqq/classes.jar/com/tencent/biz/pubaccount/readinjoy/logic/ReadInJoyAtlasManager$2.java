package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb74.cmd0xb74.RspBody;

class ReadInJoyAtlasManager$2
  extends ProtoUtils.AppProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.a, 2, "fetchAtlas0xb74 onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    while (this.a == null) {
      try
      {
        paramBundle = new cmd0xb74.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (this.a != null) {
          this.a.a(true, paramBundle.rpt_like_info.get(), 0);
        }
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.a != null) {
          this.a.a(false, null, paramInt);
        }
        QLog.e(ReadInJoyAtlasManager.a, 1, "fetchAtlas0xbe0 onResult(), exception=" + paramArrayOfByte.toString());
        return;
      }
    }
    this.a.a(false, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.2
 * JD-Core Version:    0.7.0.1
 */