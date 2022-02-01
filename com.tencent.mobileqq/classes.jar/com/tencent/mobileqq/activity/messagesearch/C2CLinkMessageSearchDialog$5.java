package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class C2CLinkMessageSearchDialog$5
  implements AbsListView.OnScrollListener
{
  int a = 0;
  int b = 0;
  int c = 0;
  
  C2CLinkMessageSearchDialog$5(C2CLinkMessageSearchDialog paramC2CLinkMessageSearchDialog) {}
  
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
      paramAbsListView.append(this.d.w);
      paramAbsListView.append(", requesting:");
      paramAbsListView.append(this.d.v);
      paramAbsListView.append(", mSearchMode: ");
      paramAbsListView.append(this.d.m);
      paramAbsListView.append(", mCurrentKeyword: ");
      paramAbsListView.append(this.d.x);
      QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
    }
    int i = this.b;
    if (i == 0) {
      return;
    }
    if ((this.a == i) && (paramInt == 0))
    {
      if ((this.c != 0) && (!this.d.v))
      {
        paramAbsListView = this.d;
        paramAbsListView.v = true;
        if (paramAbsListView.m == 0)
        {
          if (QLog.isColorLevel())
          {
            paramAbsListView = new StringBuilder();
            paramAbsListView.append("onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: ");
            paramAbsListView.append(this.d.w);
            QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
          }
          this.d.n.a(this.d.z, this.d.x, 2);
          this.d.u.setText(this.d.c.getString(2131916115));
          this.d.s.setVisibility(0);
          this.d.t.findViewById(2131440727).setVisibility(0);
          this.d.t.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: ");
          paramAbsListView.append(this.d.w);
          QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
        }
        if (this.d.w)
        {
          this.d.u.setText(HardCodeUtil.a(2131899516));
          this.d.t.findViewById(2131440727).setVisibility(8);
          this.d.t.setVisibility(0);
          this.d.s.setVisibility(0);
          return;
        }
        this.d.u.setText(this.d.c.getString(2131916114));
        this.d.s.setVisibility(0);
        this.d.t.findViewById(2131440727).setVisibility(0);
        this.d.t.setVisibility(0);
        this.d.z = System.currentTimeMillis();
        return;
      }
      if ((this.c == 0) && (!this.d.v) && (this.d.w) && (this.d.m == 1))
      {
        this.d.u.setText(HardCodeUtil.a(2131899517));
        this.d.t.findViewById(2131440727).setVisibility(8);
        this.d.t.setVisibility(0);
        this.d.s.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */