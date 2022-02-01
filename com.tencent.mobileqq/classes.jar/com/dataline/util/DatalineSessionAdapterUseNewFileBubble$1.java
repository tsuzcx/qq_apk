package com.dataline.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DatalineSessionAdapterUseNewFileBubble$1
  implements View.OnClickListener
{
  DatalineSessionAdapterUseNewFileBubble$1(DatalineSessionAdapterUseNewFileBubble paramDatalineSessionAdapterUseNewFileBubble) {}
  
  public void onClick(View paramView)
  {
    ItemHolder localItemHolder = (ItemHolder)paramView.getTag();
    if (localItemHolder != null)
    {
      DataLineMsgSet localDataLineMsgSet = localItemHolder.a();
      if (localDataLineMsgSet != null)
      {
        long l = 0L;
        if (localDataLineMsgSet.getFirstItem() != null) {
          l = localDataLineMsgSet.getFirstItem().sessionid;
        } else {
          QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "stop send but no sessionid");
        }
        localDataLineMsgSet.setPaused(true);
        ((DataLineHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(localDataLineMsgSet.getGroupId(), l, false);
        DatalineSessionAdapterUseNewFileBubble.a(this.a, localItemHolder, localDataLineMsgSet);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapterUseNewFileBubble.1
 * JD-Core Version:    0.7.0.1
 */