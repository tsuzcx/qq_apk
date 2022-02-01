package com.tencent.mm.opensdk.diffdev;

public abstract interface OAuthListener
{
  public abstract void onAuthFinish(OAuthErrCode paramOAuthErrCode, String paramString);
  
  public abstract void onAuthGotQrcode(String paramString, byte[] paramArrayOfByte);
  
  public abstract void onQrcodeScanned();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.OAuthListener
 * JD-Core Version:    0.7.0.1
 */