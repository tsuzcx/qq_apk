package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

public final class SendTdiAuth$Resp
  extends SendAuth.Resp
{
  private static final String KEY_AUTH_BUFFER = "_wxapi_sendauth_resp_tdi_buffer";
  private static final String TAG = "MicroMsg.SDK.SendTdiAuth.Resp";
  public byte[] tdiAuthBuffer;
  
  public SendTdiAuth$Resp(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.tdiAuthBuffer = paramBundle.getByteArray("_wxapi_sendauth_resp_tdi_buffer");
  }
  
  public int getType()
  {
    return 31;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putByteArray("_wxapi_sendauth_resp_tdi_buffer", this.tdiAuthBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendTdiAuth.Resp
 * JD-Core Version:    0.7.0.1
 */