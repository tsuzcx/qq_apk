package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import java.net.URLEncoder;

public class HandleScanResult$Req
  extends BaseReq
{
  private static final int MAX_URL_LENGHT = 10240;
  public String scanResult;
  
  public boolean checkArgs()
  {
    if ((this.scanResult == null) || (this.scanResult.length() < 0)) {}
    while (this.scanResult.length() > 10240) {
      return false;
    }
    return true;
  }
  
  public int getType()
  {
    return 17;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.HandleScanResult.Req
 * JD-Core Version:    0.7.0.1
 */