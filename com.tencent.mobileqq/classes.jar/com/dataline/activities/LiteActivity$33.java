package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LiteActivity$33
  implements DialogInterface.OnClickListener
{
  LiteActivity$33(LiteActivity paramLiteActivity, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.b.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineHandler.e(113);
    localDataLineHandler.d(116);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
        DataLineReportUtil.f(this.b.app);
      }
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
    }
    localDataLineHandler.b(localArrayList);
    this.b.m.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.33
 * JD-Core Version:    0.7.0.1
 */