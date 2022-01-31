package com.tencent.TMG.wrapper;

import android.util.Log;
import com.tencent.TMG.ptt.PttListener.UploadFileListener;

class OpensdkGameWrapper$3
  implements PttListener.UploadFileListener
{
  OpensdkGameWrapper$3(OpensdkGameWrapper paramOpensdkGameWrapper) {}
  
  public void onCompleted(int paramInt, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Log.i("opensdkGameWrapper", String.format("uploadRecordedFile|onCompleted| code=%d, filePath=%s,fileid=%s", new Object[] { Integer.valueOf(paramInt), str, paramString1 }));
    this.this$0.nativeUploadRecordedFileCallback(paramInt, str, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.wrapper.OpensdkGameWrapper.3
 * JD-Core Version:    0.7.0.1
 */