package com.tencent.mobileqq.app.proxy;

import amjd;
import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class DataLineMsgProxy$9
  implements Runnable
{
  public DataLineMsgProxy$9(amjd paramamjd, long paramLong, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localContentValues.put("serverPath", this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
      localContentValues.put("md5", this.jdField_a_of_type_ArrayOfByte);
    }
    if (localDataLineMsgRecord != null) {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.9
 * JD-Core Version:    0.7.0.1
 */