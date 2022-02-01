package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;

class a$a
  implements OAuthListener
{
  a$a(a parama) {}
  
  public void onAuthFinish(OAuthErrCode paramOAuthErrCode, String paramString)
  {
    Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[] { paramOAuthErrCode.toString(), paramString }));
    a.a(this.a, null);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(a.a(this.a));
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onAuthFinish(paramOAuthErrCode, paramString);
    }
  }
  
  public void onAuthGotQrcode(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAuthGotQrcode, qrcodeImgPath = ");
    ((StringBuilder)localObject).append(paramString);
    Log.d("MicroMsg.SDK.ListenerWrapper", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((ArrayList)localObject).addAll(a.a(this.a));
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onAuthGotQrcode(paramString, paramArrayOfByte);
    }
  }
  
  public void onQrcodeScanned()
  {
    Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
    if (a.b(this.a) != null) {
      a.b(this.a).post(new a.a.a(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.a.a
 * JD-Core Version:    0.7.0.1
 */