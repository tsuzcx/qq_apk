package com.tencent.mobileqq.app.proxy;

import amjd;
import android.content.ContentValues;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class DataLineMsgProxy$7
  implements Runnable
{
  public DataLineMsgProxy$7(amjd paramamjd, long paramLong, String paramString) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("path", this.jdField_a_of_type_JavaLangString);
    if (localDataLineMsgRecord != null) {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.7
 * JD-Core Version:    0.7.0.1
 */