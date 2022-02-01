package com.tencent.mobileqq.activity.selectmember;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class SelectMemberActivity$13
  extends DiscussionObserver
{
  SelectMemberActivity$13(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (!paramBoolean) {
      SelectMemberActivity.jdField_b_of_type_Boolean = false;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion success: roomId: " + paramLong + ", mSubType: " + this.a.jdField_b_of_type_Int + ", mEntrance: " + this.a.d);
        }
        paramString = new ArrayList();
        Iterator localIterator = this.a.e.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          if (localResultRecord.type == 5)
          {
            if (localResultRecord.uin.startsWith("pstn")) {
              localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
            }
            paramString.add(localResultRecord.uin);
          }
          else if ((localResultRecord.type == 4) && (localResultRecord.uin.startsWith("+")))
          {
            paramString.add(localResultRecord.uin);
          }
        }
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", paramLong);
        if (this.a.d == 12) {
          this.a.jdField_a_of_type_AndroidContentIntent.putExtra("select_memeber_discussion_memeber_count", this.a.e.size() + 1);
        }
        this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.e);
        this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
        this.a.finish();
      }
    }
    else
    {
      return;
    }
    QLog.d("SelectMemberActivity", 1, "create discussion fail, errCode=" + paramInt);
    if (paramInt == 1000)
    {
      QQToast.a(this.a, this.a.getString(2131697619), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      ReportController.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a, this.a.getString(2131691837), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (!paramBoolean) {
        break label231;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add discussion member success: roomId: " + paramLong);
      }
      paramArrayList = new ArrayList();
      Iterator localIterator = this.a.e.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (localResultRecord.type == 5)
        {
          if (localResultRecord.uin.startsWith("pstn")) {
            localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
          }
          paramArrayList.add(localResultRecord.uin);
        }
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", paramLong);
      this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.e);
      if (!paramBoolean) {
        break label213;
      }
      this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
    }
    for (;;)
    {
      this.a.finish();
      return;
      label213:
      this.a.setResult(1, this.a.jdField_a_of_type_AndroidContentIntent);
    }
    label231:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member fail");
    }
    if (paramInt == 1000) {
      ReportController.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
    }
    QQToast.a(this.a, this.a.getString(2131691835), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramArrayOfObject == null) {}
    String str;
    do
    {
      return;
      str = (String)paramArrayOfObject[0];
    } while (!this.a.jdField_c_of_type_JavaLangString.equals(str));
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    QLog.d("SelectMemberActivity", 2, "add discussion member failed, error code: " + i);
    QQToast.a(this.a, this.a.getString(2131691835), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.13
 * JD-Core Version:    0.7.0.1
 */