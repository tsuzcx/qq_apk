package com.tencent.mobileqq.apollo.process.chanel;

import android.util.Log;
import com.tencent.TMG.sdk.AVRoomMulti.RequestViewListCompleteCallback;
import com.tencent.TMG.sdk.AVView;

class CmGameAvHandler$18
  implements AVRoomMulti.RequestViewListCompleteCallback
{
  CmGameAvHandler$18(CmGameAvHandler paramCmGameAvHandler) {}
  
  public void OnComplete(String[] paramArrayOfString, AVView[] paramArrayOfAVView, int paramInt1, int paramInt2, String paramString)
  {
    Log.d("CmGameAvHandler", "RequestViewListCompleteCallback.OnComplete result: " + paramInt2 + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.18
 * JD-Core Version:    0.7.0.1
 */