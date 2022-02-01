package com.dataline.activities;

import android.view.View;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LiteActivity$26
  implements ActionSheet.OnButtonClickListener
{
  LiteActivity$26(LiteActivity paramLiteActivity, long paramLong, DataLineMsgSet paramDataLineMsgSet, List paramList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(this.jdField_a_of_type_Long))
      {
        paramView = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
        if (paramView.a(this.jdField_a_of_type_JavaUtilList))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
            {
              localDataLineMsgRecord.bIsResendOrRecvFile = true;
              localDataLineMsgRecord.fileMsgStatus = 0L;
              localDataLineMsgRecord.progress = 0.0F;
            }
          }
          this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a.notifyDataSetChanged();
        }
        else
        {
          FMToastUtil.a(2131693807);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.26
 * JD-Core Version:    0.7.0.1
 */