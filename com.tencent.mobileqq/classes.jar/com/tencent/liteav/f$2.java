package com.tencent.liteav;

import com.tencent.liteav.a.a.b;
import com.tencent.liteav.renderer.a;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

class f$2
  implements a.b
{
  f$2(f paramf) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (f.a(this.a) != null)
    {
      TXRecordCommon.TXRecordResult localTXRecordResult = new TXRecordCommon.TXRecordResult();
      if (paramInt == 0) {
        localTXRecordResult.retCode = 0;
      } else {
        localTXRecordResult.retCode = -1;
      }
      localTXRecordResult.descMsg = paramString1;
      localTXRecordResult.videoPath = paramString2;
      localTXRecordResult.coverPath = paramString3;
      f.a(this.a).onRecordComplete(localTXRecordResult);
    }
    f.b(this.a).a(null);
    f.b(this.a).a(null);
  }
  
  public void a(long paramLong)
  {
    if (f.a(this.a) != null) {
      f.a(this.a).onRecordProgress(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.f.2
 * JD-Core Version:    0.7.0.1
 */