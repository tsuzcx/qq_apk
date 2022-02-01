package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;

public abstract class BaseChatItemLayoutViewWrapper<T extends IBaseChatItemLayoutProcessor>
{
  protected T a;
  protected BaseChatItemLayout b;
  protected Context c;
  
  public BaseChatItemLayoutViewWrapper(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.b = paramBaseChatItemLayout;
    this.c = paramContext;
  }
  
  @Nullable
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    if (this.a == null) {
      this.a = b();
    }
    return this.a.a(paramInt);
  }
  
  @Nullable
  public T a()
  {
    if (this.a == null) {
      this.a = b();
    }
    return this.a;
  }
  
  @NonNull
  protected abstract T b();
  
  @Nullable
  public BaseChatItemLayoutViewBasicAbility c()
  {
    if (this.a == null) {
      this.a = b();
    }
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapper
 * JD-Core Version:    0.7.0.1
 */