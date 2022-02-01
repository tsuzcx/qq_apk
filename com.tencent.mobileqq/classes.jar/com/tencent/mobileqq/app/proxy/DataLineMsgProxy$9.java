package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.data.DataLineMsgRecord;

class DataLineMsgProxy$9
  implements Runnable
{
  DataLineMsgProxy$9(DataLineMsgProxy paramDataLineMsgProxy, long paramLong, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localContentValues.put("serverPath", this.jdField_a_of_type_JavaLangString);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfByte;
    if ((localObject != null) && (localObject.length > 0)) {
      localContentValues.put("md5", (byte[])localObject);
    }
    if (localDataLineMsgRecord != null)
    {
      localObject = this.this$0;
      ((DataLineMsgProxy)localObject).a(((DataLineMsgProxy)localObject).jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.9
 * JD-Core Version:    0.7.0.1
 */