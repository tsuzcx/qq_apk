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
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.a(this.a);
    ContentValues localContentValues = new ContentValues();
    if (!TextUtils.isEmpty(this.b)) {
      localContentValues.put("serverPath", this.b);
    }
    Object localObject = this.c;
    if ((localObject != null) && (localObject.length > 0)) {
      localContentValues.put("md5", (byte[])localObject);
    }
    if (localDataLineMsgRecord != null)
    {
      localObject = this.this$0;
      ((DataLineMsgProxy)localObject).a(((DataLineMsgProxy)localObject).a, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.9
 * JD-Core Version:    0.7.0.1
 */