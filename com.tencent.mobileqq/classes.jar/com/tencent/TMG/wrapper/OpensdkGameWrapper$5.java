package com.tencent.TMG.wrapper;

import android.util.Log;
import com.tencent.TMG.ptt.PttListener.Voice2TextListener;

class OpensdkGameWrapper$5
  implements PttListener.Voice2TextListener
{
  OpensdkGameWrapper$5(OpensdkGameWrapper paramOpensdkGameWrapper) {}
  
  public void onCompleted(int paramInt, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    Log.i("opensdkGameWrapper", String.format("voice2Text|onCompleted| code=%d, fileid=%s,text=%s", new Object[] { Integer.valueOf(paramInt), paramString2, str }));
    this.this$0.nativeVoice2TextCallback(paramInt, paramString2, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.wrapper.OpensdkGameWrapper.5
 * JD-Core Version:    0.7.0.1
 */