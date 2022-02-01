package com.tencent.biz.pubaccount.weishi_new.jump;

import android.app.Dialog;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.OnInterceptDialogClickListener;

class WSClientJumpStrategy$1
  implements OuterInterceptManager.OnInterceptDialogClickListener
{
  WSClientJumpStrategy$1(WSClientJumpStrategy paramWSClientJumpStrategy, IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor, OuterInterceptManager.OnInterceptDialogClickListener paramOnInterceptDialogClickListener) {}
  
  public void a()
  {
    WSClientJumpStrategy.a(this.c, this.a);
    OuterInterceptManager.OnInterceptDialogClickListener localOnInterceptDialogClickListener = this.b;
    if (localOnInterceptDialogClickListener != null) {
      localOnInterceptDialogClickListener.a();
    }
  }
  
  public void a(Dialog paramDialog)
  {
    OuterInterceptManager.OnInterceptDialogClickListener localOnInterceptDialogClickListener = this.b;
    if (localOnInterceptDialogClickListener != null) {
      localOnInterceptDialogClickListener.a(paramDialog);
    }
  }
  
  public void b()
  {
    WSClientJumpStrategy.a(this.c, this.a);
    OuterInterceptManager.OnInterceptDialogClickListener localOnInterceptDialogClickListener = this.b;
    if (localOnInterceptDialogClickListener != null) {
      localOnInterceptDialogClickListener.b();
    }
  }
  
  public void c()
  {
    OuterInterceptManager.OnInterceptDialogClickListener localOnInterceptDialogClickListener = this.b;
    if (localOnInterceptDialogClickListener != null) {
      localOnInterceptDialogClickListener.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSClientJumpStrategy.1
 * JD-Core Version:    0.7.0.1
 */