package com.tencent.av.ui;

import android.content.res.Resources;
import android.widget.Button;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$MyVideoObserver
  extends VideoObserver
{
  MultiVideoEnterPageActivity$MyVideoObserver(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((this.b.u != null) && (this.b.t != null))
    {
      if (paramLong != this.b.k)
      {
        QLog.w(this.b.a, 1, "onKickOutResult, ignore");
        return;
      }
      if (paramBoolean)
      {
        this.b.u.n.a(this.b.t.getLongAccountUin(), paramLong, this.b.D);
        this.b.b(paramInt2);
        return;
      }
      if (paramInt3 == -5)
      {
        if (this.b.z)
        {
          if ((this.b.c != null) && (this.b.c.length > 1) && (this.b.c[1] != null)) {
            this.b.c[1].x.setVisibility(8);
          }
        }
        else {
          this.b.b.b.setVisibility(8);
        }
        QQToast.makeText(this.b, 2131890643, 1).show(MultiVideoEnterPageActivity.c(this.b).getDimensionPixelSize(2131299920));
        return;
      }
      QQToast.makeText(this.b, 2131890642, 1).show(MultiVideoEnterPageActivity.d(this.b).getDimensionPixelSize(2131299920));
      return;
    }
    QLog.w(this.b.a, 1, "onKickOutResult, empty");
  }
  
  protected void c(long paramLong)
  {
    super.c(paramLong);
    if (QLog.isColorLevel())
    {
      String str = this.b.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", mRelationId = ");
      localStringBuilder.append(this.b.k);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramLong != 0L) && (paramLong == this.b.k))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.b.a, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin matched");
      }
      this.b.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.MyVideoObserver
 * JD-Core Version:    0.7.0.1
 */