package com.dataline.activities;

import android.view.View;
import com.dataline.util.ItemHolder;
import com.dataline.util.ItemHolder.TextItemHolder;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;

class LiteActivity$24
  implements ActionSheet.OnButtonClickListener
{
  LiteActivity$24(LiteActivity paramLiteActivity, DataLineMsgSet paramDataLineMsgSet, ItemHolder paramItemHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (this.a.getGroupType() == -1000)
      {
        paramView = this.b.f().c;
        this.d.a(paramView, this.b.f().d, -1);
      }
      else
      {
        DataLineMsgRecord localDataLineMsgRecord;
        if (this.a.getGroupType() == -2000)
        {
          this.a.setPaused(false);
          paramView = this.a.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.d.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 0);
            }
          }
        }
        if ((this.a.getGroupType() == -2005) || (this.a.getGroupType() == -2009))
        {
          this.a.setPaused(false);
          paramView = this.a.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.d.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 2);
            }
          }
        }
      }
    }
    this.c.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.24
 * JD-Core Version:    0.7.0.1
 */