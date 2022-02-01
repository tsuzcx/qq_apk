package com.tencent.TMG.wrapper;

import android.util.Log;
import com.tencent.TMG.ptt.PttListener.RecordFileListener;

class OpensdkGameWrapper$1
  implements PttListener.RecordFileListener
{
  OpensdkGameWrapper$1(OpensdkGameWrapper paramOpensdkGameWrapper) {}
  
  public void onCompleted(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    Log.i("opensdkGameWrapper", String.format("startRecording|onCompleted| code=%d, filePath=%s", new Object[] { Integer.valueOf(paramInt), str }));
    this.this$0.nativestartRecordingCallback(paramInt, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.wrapper.OpensdkGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */