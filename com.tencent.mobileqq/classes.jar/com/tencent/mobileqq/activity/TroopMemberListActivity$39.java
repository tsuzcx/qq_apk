package com.tencent.mobileqq.activity;

import android.app.Dialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.discussion.BizDiscussionObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopMemberListActivity$39
  extends BizDiscussionObserver
{
  TroopMemberListActivity$39(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (this.a.mProgressDialog != null) {
      this.a.mProgressDialog.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      paramLong1 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("");
      paramLong1.removeItem(localStringBuilder.toString());
      if (this.a.mAdapter != null) {
        this.a.mAdapter.c();
      }
      if (this.a.isSearchMode)
      {
        paramLong1 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("");
        paramLong1.removeSearchItem(localStringBuilder.toString());
        if (this.a.mSearchResultAdapter != null) {
          this.a.mSearchResultAdapter.notifyDataSetChanged();
        }
      }
    }
    else
    {
      paramLong1 = this.a;
      QQToast.makeText(paramLong1, 1, paramLong1.getString(2131891098), 0).show(this.a.getTitleBarHeight());
    }
    if (this.a.mProgressDialog != null) {
      this.a.mProgressDialog.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.a.runOnUiThread(new TroopMemberListActivity.39.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (this.a.mProgressDialog != null) {
      this.a.mProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.39
 * JD-Core Version:    0.7.0.1
 */