package com.tencent.biz.pubaccount.readinjoy.pts.nativemodule;

import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport.R5Builder;
import com.tencent.pts.nativemodule.IPTSHandleJSException;

public class PTSHandleJSException
  implements IPTSHandleJSException
{
  public void handleJSException(int paramInt1, int paramInt2, String paramString)
  {
    PTSReport.a("0X800A7C6", "", "", "", new PTSReport.R5Builder().a("type", "1").a("line", "" + paramInt1).a("column", "" + paramInt2).a("msg", paramString).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSHandleJSException
 * JD-Core Version:    0.7.0.1
 */