package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.ArrayList;
import java.util.Iterator;

class LiteActivity$29$1
  implements DialogInterface.OnClickListener
{
  LiteActivity$29$1(LiteActivity.29 param29) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.g.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    boolean bool = this.a.b.isReportPause;
    paramInt = 1;
    if ((!bool) && (this.a.b.getGroupType() == -2335))
    {
      this.a.b.isReportPause = true;
      if (!this.a.b.isSingle()) {
        DataLineReportUtil.m(this.a.g.app);
      } else {
        DataLineReportUtil.k(this.a.g.app);
      }
    }
    if ((this.a.b.getGroupType() == -2000) && (!this.a.b.isSingle())) {
      DataLineReportUtil.o(this.a.g.app);
    }
    DataLineMsgSet localDataLineMsgSet = null;
    if ((!this.a.b.isSingle()) && (this.a.b.getGroupType() != -2335))
    {
      localDataLineHandler.a(this.a.b.getGroupId(), 0L, true);
    }
    else
    {
      Iterator localIterator = this.a.b.values().iterator();
      while (localIterator.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
        localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, true);
      }
      if ((this.a.b.values().size() == 1) && (this.a.b.getGroupType() == -2005))
      {
        int i = this.a.g.l.getSetIndex(((DataLineMsgRecord)this.a.b.values().get(0)).sessionid) + 1;
        if ((i < this.a.g.l.size()) && (((DataLineMsgRecord)this.a.g.l.get(i).values().get(0)).msgtype == -5041) && (Long.parseLong(((DataLineMsgRecord)this.a.g.l.get(i).values().get(0)).getExtInfoFromExtStr("tim_aio_file_msg_uiniseq")) == ((DataLineMsgRecord)this.a.b.values().get(0)).sessionid))
        {
          localDataLineMsgSet = this.a.g.l.get(i);
          break label455;
        }
      }
    }
    paramInt = 0;
    label455:
    localDataLineHandler.a(this.a.b);
    if (paramInt != 0) {
      localDataLineHandler.a(localDataLineMsgSet);
    }
    this.a.g.m.d();
    this.a.g.m.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.29.1
 * JD-Core Version:    0.7.0.1
 */