package com.tencent.luggage.scanner.scanner.ui;

import android.os.Bundle;
import com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.List;

class a$2
  implements LuggageScanDecodeQueue.ScanDecodeCallBack
{
  a$2(a parama) {}
  
  public void notifyEvent(long paramLong, Bundle paramBundle)
  {
    this.a.post(new a.2.3(this, paramLong, paramBundle));
  }
  
  public void onDecodeSuccess(long paramLong, List<QBar.QBarResult> paramList, List<QbarNative.QBarPoint> paramList1, List<QbarNative.QBarReportMsg> paramList2, Bundle paramBundle)
  {
    o.e("Luggage.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramLong) }));
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.a.post(new a.2.2(this, paramLong, paramList, paramList2, paramList1, paramBundle));
      return;
    }
  }
  
  public void postTakeShot(long paramLong1, long paramLong2)
  {
    this.a.post(new a.2.1(this, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.a.2
 * JD-Core Version:    0.7.0.1
 */