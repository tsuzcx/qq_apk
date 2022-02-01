package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyAtlasManager$5
  extends ProtoUtils.AppProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.a, 2, "reportGalleryExposed0xbe1 onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    try
    {
      if (this.a != null) {
        this.a.a(true, 0);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.a != null) {
        this.a.a(true, paramInt);
      }
      QLog.e(ReadInJoyAtlasManager.a, 1, "reportGalleryExposed0xbe1 onResult(), exception=" + paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.5
 * JD-Core Version:    0.7.0.1
 */