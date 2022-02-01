package com.tencent.biz.qrcode.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.qphone.base.util.QLog;

class QRDisplayActivity$5
  extends DiscussionObserver
{
  QRDisplayActivity$5(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetFlyTicket: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (!paramBoolean)
    {
      this.a.a(paramInt);
      return;
    }
    Object localObject1 = this.a.C.a(this.a.n, true);
    if ((localObject1 != null) && ((localObject1 instanceof BitmapDrawable))) {
      this.a.j = ((BitmapDrawable)localObject1).getBitmap();
    }
    localObject1 = this.a.getSharedPreferences("qrcode", 0).edit();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("discussionvalidtime");
    ((StringBuilder)localObject2).append(this.a.n);
    ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), paramLong1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("discussion");
    ((StringBuilder)localObject2).append(this.a.n);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramString2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("discussionfullSig");
    ((StringBuilder)localObject2).append(this.a.n);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramString1);
    ((SharedPreferences.Editor)localObject1).commit();
    this.a.G = paramLong1;
    localObject1 = QRUtils.a(paramString2, -1);
    if (localObject1 != null)
    {
      ((TextView)this.a.findViewById(2131441424)).setText(paramString2);
      this.a.b.post(this.a.aH);
      localObject2 = this.a;
      ((QRDisplayActivity)localObject2).o = paramString2;
      ((QRDisplayActivity)localObject2).p = paramString1;
      ((QRDisplayActivity)localObject2).e = ((BitMatrix)localObject1);
      ((QRDisplayActivity)localObject2).h();
      return;
    }
    this.a.i();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      paramString = ((DiscussionHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramString, true);
      if ((paramString instanceof BitmapDrawable)) {
        this.a.j = ((BitmapDrawable)paramString).getBitmap();
      }
      if (this.a.u == null)
      {
        this.a.u = new Bundle();
        this.a.u.putInt("bkgRes", 0);
        this.a.u.putInt("nameClr", -16777216);
        this.a.u.putInt("tipsClr", -8947849);
        this.a.u.putInt("B", -16777216);
        this.a.u.putInt("W", 16777215);
        this.a.u.putParcelable("qrloc", new Rect(45, 76, 495, 526));
        this.a.u.putInt("head", 1);
      }
      if (this.a.e == null)
      {
        paramString = this.a;
        paramString.e = paramString.a(paramString.n, this.a.t, -1);
      }
      if (this.a.e != null) {
        this.a.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.5
 * JD-Core Version:    0.7.0.1
 */