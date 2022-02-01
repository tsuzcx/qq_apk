package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class BaseChatItemLayoutViewWrapperFactory
{
  private Map<Class<? extends BaseChatItemLayoutViewWrapper>, BaseChatItemLayoutViewWrapper> a;
  private BaseChatItemLayout b;
  private Context c;
  
  public BaseChatItemLayoutViewWrapperFactory(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.b = paramBaseChatItemLayout;
    this.c = paramContext;
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new HashMap();
      this.a.put(NickNameLayoutViewWrapper.class, new NickNameLayoutViewWrapper(this.b, this.c));
      this.a.put(BubbleViewWrapper.class, new BubbleViewWrapper(this.b, this.c));
      this.a.put(HeadIconWrapper.class, new HeadIconWrapper(this.b, this.c));
    }
  }
  
  @Nullable
  public <T extends BaseChatItemLayoutViewWrapper> T a(Class<? extends BaseChatItemLayoutViewWrapper> paramClass)
  {
    a();
    paramClass = (BaseChatItemLayoutViewWrapper)this.a.get(paramClass);
    if (paramClass == null) {
      QLog.e("BaseChatItemLayoutViewWrapperFactory", 1, "wrapper check failed");
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapperFactory
 * JD-Core Version:    0.7.0.1
 */