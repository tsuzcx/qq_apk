package com.tencent.luggage.scanner.qbar;

import android.os.Bundle;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.List;

public abstract interface LuggageScanDecodeQueue$ScanDecodeCallBack
{
  public static final String DECODE_DEBUG_STRING = "decode_debug_string";
  public static final String DECODE_SUCCESS_COST_TIME = "decode_success_cost_time";
  public static final String DECODE_SUCCESS_FRAME_DATA = "decode_success_frame_data";
  
  public abstract void notifyEvent(long paramLong, Bundle paramBundle);
  
  public abstract void onDecodeSuccess(long paramLong, List<QBar.QBarResult> paramList, List<QbarNative.QBarPoint> paramList1, List<QbarNative.QBarReportMsg> paramList2, Bundle paramBundle);
  
  public abstract void postTakeShot(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack
 * JD-Core Version:    0.7.0.1
 */