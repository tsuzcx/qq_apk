package com.tencent.mobileqq.activity.aio.qwallet;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.QWalletMsgHolderBase;
import com.tencent.mobileqq.widget.AnimationView;

public class QWalletMsgHolder
  extends BaseBubbleBuilder.ViewHolder
  implements IQWalletMsgHolder
{
  private IQWalletMsgHolder a;
  
  public QWalletMsgHolder()
  {
    a(new QWalletMsgHolderBase());
  }
  
  private void a(IQWalletMsgHolder paramIQWalletMsgHolder)
  {
    this.a = paramIQWalletMsgHolder;
    if (paramIQWalletMsgHolder.a() != null) {
      this.q = paramIQWalletMsgHolder.a();
    }
  }
  
  public MessageForQQWalletMsg a()
  {
    return (MessageForQQWalletMsg)this.q;
  }
  
  public void a(long paramLong)
  {
    this.a.a(paramLong);
  }
  
  public void a(ImageView paramImageView)
  {
    this.a.a(paramImageView);
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    this.a.a(paramLinearLayout);
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    this.a.a(paramRelativeLayout);
  }
  
  public void a(TextView paramTextView)
  {
    this.a.a(paramTextView);
  }
  
  public void a(AnimationView paramAnimationView)
  {
    this.a.a(paramAnimationView);
  }
  
  public RelativeLayout b()
  {
    return this.a.b();
  }
  
  public void b(RelativeLayout paramRelativeLayout)
  {
    this.a.b(paramRelativeLayout);
  }
  
  public void b(TextView paramTextView)
  {
    this.a.b(paramTextView);
  }
  
  public void b(AnimationView paramAnimationView)
  {
    this.a.b(paramAnimationView);
  }
  
  public TextView c()
  {
    return this.a.c();
  }
  
  public void c(RelativeLayout paramRelativeLayout)
  {
    this.a.c(paramRelativeLayout);
  }
  
  public void c(TextView paramTextView)
  {
    this.a.c(paramTextView);
  }
  
  public RelativeLayout d()
  {
    return this.a.d();
  }
  
  public void d(RelativeLayout paramRelativeLayout)
  {
    this.a.d(paramRelativeLayout);
  }
  
  public RelativeLayout e()
  {
    return this.a.e();
  }
  
  public void e(RelativeLayout paramRelativeLayout)
  {
    this.a.e(paramRelativeLayout);
  }
  
  public LinearLayout f()
  {
    return this.a.f();
  }
  
  public void f(RelativeLayout paramRelativeLayout)
  {
    this.a.f(paramRelativeLayout);
  }
  
  public TextView g()
  {
    return this.a.g();
  }
  
  public TextView h()
  {
    return this.a.h();
  }
  
  public ImageView i()
  {
    return this.a.i();
  }
  
  public RelativeLayout j()
  {
    return this.a.j();
  }
  
  public AnimationView k()
  {
    return this.a.k();
  }
  
  public AnimationView l()
  {
    return this.a.l();
  }
  
  public long m()
  {
    return this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.QWalletMsgHolder
 * JD-Core Version:    0.7.0.1
 */