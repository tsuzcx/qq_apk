package com.tencent.mobileqq.app.proxy;

import amjg;
import amji;
import awbv;
import com.dataline.mpfile.MpfileTaskRecord;
import ew;

public class MpfileTaskProxy$1
  implements Runnable
{
  public MpfileTaskProxy$1(amjg paramamjg, awbv paramawbv, amji paramamji, ew paramew) {}
  
  public void run()
  {
    MpfileTaskRecord localMpfileTaskRecord = ((MpfileTaskRecord)this.jdField_a_of_type_Awbv).clone();
    this.this$0.a.a(String.valueOf(0), 0, MpfileTaskRecord.tableName(), localMpfileTaskRecord, 0, this.jdField_a_of_type_Amji);
    this.jdField_a_of_type_Ew.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1
 * JD-Core Version:    0.7.0.1
 */