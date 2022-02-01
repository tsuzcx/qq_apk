package com.tencent.mobileqq.activity.selectmember;

import amrc;
import android.content.Intent;
import android.view.View;
import bcef;
import bhht;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class SelectMemberActivity$13
  extends amrc
{
  SelectMemberActivity$13(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onAddDiscussionMember(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (this.this$0.mQQProgressDialog != null)
    {
      this.this$0.mQQProgressDialog.dismiss();
      if (!paramBoolean) {
        break label231;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add discussion member success: roomId: " + paramLong);
      }
      paramArrayList = new ArrayList();
      Iterator localIterator = this.this$0.mResultList.iterator();
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
      this.this$0.mIntent.putExtra("roomId", paramLong);
      this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.mResultList);
      if (!paramBoolean) {
        break label213;
      }
      this.this$0.setResult(-1, this.this$0.mIntent);
    }
    for (;;)
    {
      this.this$0.finish();
      return;
      label213:
      this.this$0.setResult(1, this.this$0.mIntent);
    }
    label231:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member fail");
    }
    if (paramInt == 1000) {
      bcef.b(this.this$0.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
    }
    QQToast.a(this.this$0, this.this$0.getString(2131691634), 2000).b(this.this$0.mTitleBar.getHeight());
  }
  
  public void onCreateDiscussion(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (!paramBoolean) {
      SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = false;
    }
    if (this.this$0.mQQProgressDialog != null)
    {
      this.this$0.mQQProgressDialog.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion success: roomId: " + paramLong + ", mSubType: " + this.this$0.mSubType + ", mEntrance: " + this.this$0.mEntrance);
        }
        paramString = new ArrayList();
        Iterator localIterator = this.this$0.mResultList.iterator();
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
        this.this$0.mIntent.putExtra("roomId", paramLong);
        if (this.this$0.mEntrance == 12) {
          this.this$0.mIntent.putExtra("select_memeber_discussion_memeber_count", this.this$0.mResultList.size() + 1);
        }
        this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.mResultList);
        this.this$0.setResult(-1, this.this$0.mIntent);
        this.this$0.finish();
      }
    }
    else
    {
      return;
    }
    QLog.d("SelectMemberActivity", 1, "create discussion fail, errCode=" + paramInt);
    if (paramInt == 1000)
    {
      QQToast.a(this.this$0, this.this$0.getString(2131697088), 2000).b(this.this$0.mTitleBar.getHeight());
      bcef.b(this.this$0.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.this$0, this.this$0.getString(2131691636), 2000).b(this.this$0.mTitleBar.getHeight());
  }
  
  public void onHeaderFailed(Object[] paramArrayOfObject)
  {
    if (this.this$0.mQQProgressDialog != null) {
      this.this$0.mQQProgressDialog.dismiss();
    }
    if (paramArrayOfObject == null) {}
    String str;
    do
    {
      return;
      str = (String)paramArrayOfObject[0];
    } while (!this.this$0.mGroupCode.equals(str));
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    QLog.d("SelectMemberActivity", 2, "add discussion member failed, error code: " + i);
    QQToast.a(this.this$0, this.this$0.getString(2131691634), 0).b(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.13
 * JD-Core Version:    0.7.0.1
 */