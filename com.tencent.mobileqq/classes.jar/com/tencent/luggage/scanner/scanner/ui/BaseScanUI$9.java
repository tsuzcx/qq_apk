package com.tencent.luggage.scanner.scanner.ui;

import com.tencent.luggage.scanner.qbar.LuggageFileDecodeQueue.FileDecodeCallBack;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.List;

class BaseScanUI$9
  implements LuggageFileDecodeQueue.FileDecodeCallBack
{
  BaseScanUI$9(BaseScanUI paramBaseScanUI, long paramLong) {}
  
  public void afterDecode(long paramLong, List<QBar.QBarResult> paramList, List<QbarNative.QBarReportMsg> paramList1)
  {
    if ((paramLong == this.a) && (BaseScanUI.q(this.b))) {
      t.a(new BaseScanUI.9.1(this, paramList, paramList1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.9
 * JD-Core Version:    0.7.0.1
 */