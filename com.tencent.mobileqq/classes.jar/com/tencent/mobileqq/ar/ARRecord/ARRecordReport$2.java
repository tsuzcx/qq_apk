package com.tencent.mobileqq.ar.ARRecord;

import akzf;
import axrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARRecordReport$2
  implements Runnable
{
  public ARRecordReport$2(akzf paramakzf, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    axrn.a(BaseApplication.getContext()).a("", "ar_record_active_record_start", this.a, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.2
 * JD-Core Version:    0.7.0.1
 */