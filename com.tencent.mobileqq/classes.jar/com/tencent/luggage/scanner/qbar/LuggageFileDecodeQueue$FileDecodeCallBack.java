package com.tencent.luggage.scanner.qbar;

import androidx.annotation.Nullable;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.List;

public abstract interface LuggageFileDecodeQueue$FileDecodeCallBack
{
  public abstract void afterDecode(long paramLong, @Nullable List<QBar.QBarResult> paramList, @Nullable List<QbarNative.QBarReportMsg> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.LuggageFileDecodeQueue.FileDecodeCallBack
 * JD-Core Version:    0.7.0.1
 */