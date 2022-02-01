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
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -1000)
      {
        paramView = this.jdField_a_of_type_ComDatalineUtilItemHolder.a().jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(paramView, this.jdField_a_of_type_ComDatalineUtilItemHolder.a().jdField_a_of_type_Long, -1);
      }
      else
      {
        DataLineMsgRecord localDataLineMsgRecord;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 0);
            }
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2005) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2009))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.24
 * JD-Core Version:    0.7.0.1
 */