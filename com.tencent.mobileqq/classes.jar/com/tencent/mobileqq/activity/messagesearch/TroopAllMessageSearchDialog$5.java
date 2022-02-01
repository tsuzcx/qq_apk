package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopAllMessageSearchDialog$5
  implements AbsListView.OnScrollListener
{
  int a = 0;
  int b = 0;
  int c = 0;
  
  TroopAllMessageSearchDialog$5(TroopAllMessageSearchDialog paramTroopAllMessageSearchDialog) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.a = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("onScrollStateChanged, reach bottom, scrollState ");
      paramAbsListView.append(paramInt);
      paramAbsListView.append(" firstVisibleItem: ");
      paramAbsListView.append(this.c);
      paramAbsListView.append(", lastItem:");
      paramAbsListView.append(this.a);
      paramAbsListView.append(", totalItemCount = ");
      paramAbsListView.append(this.b);
      paramAbsListView.append(", mIsComplete: ");
      paramAbsListView.append(this.d.y);
      paramAbsListView.append(", requesting:");
      paramAbsListView.append(this.d.x);
      paramAbsListView.append(", mSearchMode: ");
      paramAbsListView.append(this.d.n);
      paramAbsListView.append(", mCurrentKeyword: ");
      paramAbsListView.append(this.d.z);
      QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
    }
    int i = this.b;
    if (i == 0) {
      return;
    }
    if ((this.a == i) && (paramInt == 0))
    {
      if ((this.c != 0) && (!this.d.x))
      {
        paramAbsListView = this.d;
        paramAbsListView.x = true;
        if (paramAbsListView.n == 0)
        {
          if (QLog.isColorLevel())
          {
            paramAbsListView = new StringBuilder();
            paramAbsListView.append("onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: ");
            paramAbsListView.append(this.d.y);
            QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
          }
          this.d.o.a(this.d.B, this.d.z, 2);
          this.d.w.setText(this.d.c.getString(2131916115));
          this.d.u.setVisibility(0);
          this.d.v.findViewById(2131440727).setVisibility(0);
          this.d.v.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: ");
          paramAbsListView.append(this.d.y);
          QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
        }
        if (this.d.y)
        {
          this.d.w.setText(HardCodeUtil.a(2131912457));
          this.d.v.findViewById(2131440727).setVisibility(8);
          this.d.v.setVisibility(0);
          this.d.u.setVisibility(0);
          return;
        }
        this.d.w.setText(this.d.c.getString(2131916114));
        this.d.u.setVisibility(0);
        this.d.v.findViewById(2131440727).setVisibility(0);
        this.d.v.setVisibility(0);
        this.d.B = System.currentTimeMillis();
        return;
      }
      if ((this.c == 0) && (!this.d.x) && (this.d.y) && (this.d.n == 1))
      {
        this.d.w.setText(HardCodeUtil.a(2131912461));
        this.d.v.findViewById(2131440727).setVisibility(8);
        this.d.v.setVisibility(0);
        this.d.u.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */