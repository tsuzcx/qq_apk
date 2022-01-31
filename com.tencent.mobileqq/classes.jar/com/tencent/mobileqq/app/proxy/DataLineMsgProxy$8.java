package com.tencent.mobileqq.app.proxy;

import aksz;
import android.content.ContentValues;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class DataLineMsgProxy$8
  implements Runnable
{
  public DataLineMsgProxy$8(aksz paramaksz, long paramLong, String paramString) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("thumbPath", this.jdField_a_of_type_JavaLangString);
    if (localDataLineMsgRecord != null) {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.8
 * JD-Core Version:    0.7.0.1
 */