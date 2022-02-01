package com.tencent.biz.qrcode.util;

import android.os.Bundle;
import com.tencent.mobileqq.qrscan.QRCodeBusinessObserver;
import com.tencent.mobileqq.qrscan.QRCodeEncodeCallback;
import org.json.JSONObject;

final class QRUtils$1
  extends QRCodeBusinessObserver
{
  QRUtils$1(QRCodeEncodeCallback paramQRCodeEncodeCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      paramBundle = paramBundle.getString("result");
    }
    try
    {
      paramBundle = new JSONObject(paramBundle);
      if (paramBundle.getInt("r") == 0) {
        paramBundle = paramBundle.getString("url");
      }
    }
    catch (Exception paramBundle)
    {
      label43:
      break label43;
    }
    paramBundle = null;
    if (paramBundle != null)
    {
      this.a.a(true, paramBundle);
      return;
    }
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils.1
 * JD-Core Version:    0.7.0.1
 */