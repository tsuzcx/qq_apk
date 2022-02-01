package com.dataline.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.Iterator;
import java.util.List;

class LiteActivity$SendVideoAsyncTask
  extends AsyncTask<Bundle, Integer, Void>
{
  LiteActivity$SendVideoAsyncTask(LiteActivity paramLiteActivity) {}
  
  protected Void a(Bundle... paramVarArgs)
  {
    Object localObject = paramVarArgs[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
    if (localObject == null) {}
    for (;;)
    {
      return null;
      paramVarArgs = (DataLineHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
        localDataLineMsgRecord.path = str;
        localDataLineMsgRecord.msgtype = -2009;
        paramVarArgs.a(localDataLineMsgRecord, false);
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.SendVideoAsyncTask
 * JD-Core Version:    0.7.0.1
 */