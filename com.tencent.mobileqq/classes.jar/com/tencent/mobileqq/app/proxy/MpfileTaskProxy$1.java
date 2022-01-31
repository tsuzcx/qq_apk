package com.tencent.mobileqq.app.proxy;

import aktb;
import aktd;
import auko;
import com.dataline.mpfile.MpfileTaskRecord;
import gn;

public class MpfileTaskProxy$1
  implements Runnable
{
  public MpfileTaskProxy$1(aktb paramaktb, auko paramauko, aktd paramaktd, gn paramgn) {}
  
  public void run()
  {
    MpfileTaskRecord localMpfileTaskRecord = ((MpfileTaskRecord)this.jdField_a_of_type_Auko).clone();
    this.this$0.a.a(String.valueOf(0), 0, MpfileTaskRecord.tableName(), localMpfileTaskRecord, 0, this.jdField_a_of_type_Aktd);
    this.jdField_a_of_type_Gn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1
 * JD-Core Version:    0.7.0.1
 */