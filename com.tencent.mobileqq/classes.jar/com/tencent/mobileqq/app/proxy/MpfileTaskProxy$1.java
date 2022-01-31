package com.tencent.mobileqq.app.proxy;

import akeq;
import akes;
import atmo;
import com.dataline.mpfile.MpfileTaskRecord;
import eu;

public class MpfileTaskProxy$1
  implements Runnable
{
  public MpfileTaskProxy$1(akeq paramakeq, atmo paramatmo, akes paramakes, eu parameu) {}
  
  public void run()
  {
    MpfileTaskRecord localMpfileTaskRecord = ((MpfileTaskRecord)this.jdField_a_of_type_Atmo).clone();
    this.this$0.a.a(String.valueOf(0), 0, MpfileTaskRecord.tableName(), localMpfileTaskRecord, 0, this.jdField_a_of_type_Akes);
    this.jdField_a_of_type_Eu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1
 * JD-Core Version:    0.7.0.1
 */