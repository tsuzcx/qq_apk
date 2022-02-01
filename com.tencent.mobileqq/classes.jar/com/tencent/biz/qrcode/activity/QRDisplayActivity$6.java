package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qrscan.QRCodeEncodeCallback;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;

class QRDisplayActivity$6
  implements Runnable
{
  QRDisplayActivity$6(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int j = (int)(QRDisplayActivity.a(this.this$0) * 20.0F);
    int i = this.this$0.c.getWidth();
    j *= 2;
    int k = i - j;
    int m = this.this$0.c.getHeight() - j;
    i = this.this$0.t;
    if ((i != 1) && (i != 2))
    {
      i = 540;
      j = 740;
    }
    else
    {
      i = 550;
      j = 844;
    }
    if ((k >= i) && (m >= j))
    {
      localObject1 = this.this$0;
      ((QRDisplayActivity)localObject1).v = i;
      ((QRDisplayActivity)localObject1).w = j;
    }
    else
    {
      double d1;
      double d2;
      if (k * i < m * i)
      {
        localObject1 = this.this$0;
        ((QRDisplayActivity)localObject1).v = k;
        d1 = k;
        d2 = i;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = j;
        Double.isNaN(d2);
        ((QRDisplayActivity)localObject1).w = ((int)(d1 * d2));
      }
      else
      {
        localObject1 = this.this$0;
        d1 = m;
        d2 = j;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = i;
        Double.isNaN(d2);
        ((QRDisplayActivity)localObject1).v = ((int)(d1 * d2));
        ((QRDisplayActivity)localObject1).w = m;
      }
      localObject1 = this.this$0.d.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.this$0.v;
      ((ViewGroup.LayoutParams)localObject1).height = this.this$0.w;
      this.this$0.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.this$0.I.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.this$0.v;
      ((ViewGroup.LayoutParams)localObject1).height = this.this$0.w;
      this.this$0.I.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    Object localObject1 = this.this$0.j;
    i = 0;
    if (localObject1 == null) {
      ThreadManager.post(new QRDisplayActivity.6.1(this), 8, null, false);
    }
    if ((this.this$0.t == 2) && (this.this$0.j != null))
    {
      localObject1 = this.this$0;
      ((QRDisplayActivity)localObject1).j = ImageUtil.a(((QRDisplayActivity)localObject1).j, 50, 50);
    }
    if (this.this$0.u == null)
    {
      this.this$0.u = new Bundle();
      this.this$0.u.putInt("bkgRes", 0);
      this.this$0.u.putInt("nameClr", -16777216);
      this.this$0.u.putInt("tipsClr", -8947849);
      this.this$0.u.putInt("B", -16777216);
      this.this$0.u.putInt("W", 16777215);
      this.this$0.u.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      this.this$0.u.putInt("head", 1);
    }
    Object localObject2;
    Object localObject3;
    if (this.this$0.t != 5)
    {
      if (this.this$0.t == 11)
      {
        localObject1 = this.this$0.getIntent().getStringExtra("url");
        localObject2 = this.this$0;
        ((QRDisplayActivity)localObject2).a(((QRDisplayActivity)localObject2).n, this.this$0.t, (String)localObject1);
      }
      if (this.this$0.e == null)
      {
        localObject1 = this.this$0;
        ((QRDisplayActivity)localObject1).e = ((QRDisplayActivity)localObject1).a(((QRDisplayActivity)localObject1).n, this.this$0.t, -1);
      }
      if ((this.this$0.e != null) && (this.this$0.t != 2))
      {
        this.this$0.h();
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
        }
        localObject2 = this.this$0.getIntent();
        if (this.this$0.i)
        {
          localObject1 = ((Intent)localObject2).getStringExtra("groupOwner");
          ((QidianHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.this$0.n, (String)localObject1);
          return;
        }
        localObject3 = (TicketManager)this.this$0.app.getManager(2);
        localObject1 = this.this$0.app.getAccount();
        localObject3 = ((TicketManager)localObject3).getSkey((String)localObject1);
        String str = ((Intent)localObject2).getStringExtra("uin");
        i = ((Intent)localObject2).getIntExtra("type", 1);
        localObject2 = new QRDisplayActivity.QRCodeEncodeCallbackImp(null);
        ((QRDisplayActivity.QRCodeEncodeCallbackImp)localObject2).a = new WeakReference(this.this$0);
        ((QRDisplayActivity.QRCodeEncodeCallbackImp)localObject2).c = i;
        ((QRDisplayActivity.QRCodeEncodeCallbackImp)localObject2).b = str;
        QRUtils.a(this.this$0.app, this.this$0, str, i, (String)localObject1, (String)localObject3, 0, (QRCodeEncodeCallback)localObject2);
      }
    }
    else
    {
      localObject1 = this.this$0.getSharedPreferences("qrcode", 0);
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("discussionvalidtime");
      ((StringBuilder)localObject3).append(this.this$0.n);
      ((QRDisplayActivity)localObject2).G = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject3).toString(), 0L);
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("discussion");
      ((StringBuilder)localObject3).append(this.this$0.n);
      ((QRDisplayActivity)localObject2).o = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), null);
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("discussionfullSig");
      ((StringBuilder)localObject3).append(this.this$0.n);
      ((QRDisplayActivity)localObject2).p = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), null);
      if (this.this$0.G - System.currentTimeMillis() / 1000L > 0L) {
        i = 1;
      }
      this.this$0.findViewById(2131442861).setOnClickListener(this.this$0);
      if ((this.this$0.o == null) || (this.this$0.p == null) || (i == 0)) {
        break label1203;
      }
      ((TextView)this.this$0.findViewById(2131441424)).setText(this.this$0.o);
      localObject1 = this.this$0;
      ((QRDisplayActivity)localObject1).e = QRUtils.a(((QRDisplayActivity)localObject1).o, -1);
      this.this$0.h();
    }
    this.this$0.b.post(this.this$0.aH);
    return;
    label1203:
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
    }
    this.this$0.C.a(Long.parseLong(this.this$0.n), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.6
 * JD-Core Version:    0.7.0.1
 */