package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.data.DataLineMsgRecord;

class DataLineMsgProxy$12
  implements Runnable
{
  DataLineMsgProxy$12(DataLineMsgProxy paramDataLineMsgProxy, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.a(this.a);
    if (localDataLineMsgRecord != null)
    {
      localDataLineMsgRecord.issuc = false;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("issuc", Boolean.valueOf(false));
      DataLineMsgProxy localDataLineMsgProxy = this.this$0;
      localDataLineMsgProxy.a(localDataLineMsgProxy.a, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.12
 * JD-Core Version:    0.7.0.1
 */