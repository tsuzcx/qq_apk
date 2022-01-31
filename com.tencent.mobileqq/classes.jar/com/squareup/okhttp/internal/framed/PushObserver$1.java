package com.squareup.okhttp.internal.framed;

import java.util.List;
import okio.BufferedSource;

final class PushObserver$1
  implements PushObserver
{
  public boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
  {
    paramBufferedSource.skip(paramInt2);
    return true;
  }
  
  public boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    return true;
  }
  
  public boolean onRequest(int paramInt, List<Header> paramList)
  {
    return true;
  }
  
  public void onReset(int paramInt, ErrorCode paramErrorCode) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.PushObserver.1
 * JD-Core Version:    0.7.0.1
 */