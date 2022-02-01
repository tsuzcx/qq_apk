package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class QRDisplayActivity$1
  extends QRDisplayActivity.GetNicknameObserver
{
  QRDisplayActivity$1(QRDisplayActivity paramQRDisplayActivity)
  {
    super(paramQRDisplayActivity);
  }
  
  protected void a(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetNicknameList: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QRDisplayActivity", 4, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramList1 != null) && (paramList2 != null))
    {
      int j = paramList2.size();
      if ((j > 0) && (paramList1.size() == j))
      {
        if (this.a.B == null) {
          this.a.B = new ArrayList();
        }
        this.a.B.addAll(paramList1);
        int i = 0;
        while (i < j)
        {
          if (this.a.a((String)paramList2.get(i)) == null) {
            this.a.a((String)paramList2.get(i), (String)paramList1.get(i));
          }
          i += 1;
        }
        Collections.sort(this.a.B, new QRDisplayActivity.DiscussionMemberComparator(this.a));
      }
    }
    paramList1 = this.a;
    paramList1.l = paramList1.a(paramList1.B);
    if (this.a.l != null)
    {
      paramList1 = this.a.d;
      paramList2 = new StringBuilder();
      paramList2.append(this.a.l);
      paramList2.append(",");
      paramList2.append(this.a.m);
      paramList1.setContentDescription(paramList2.toString());
      this.a.c.post(this.a.aG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.1
 * JD-Core Version:    0.7.0.1
 */