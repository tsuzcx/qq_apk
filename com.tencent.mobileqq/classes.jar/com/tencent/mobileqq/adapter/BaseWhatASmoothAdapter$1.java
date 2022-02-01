package com.tencent.mobileqq.adapter;

import android.view.View;

class BaseWhatASmoothAdapter$1
  implements Runnable
{
  BaseWhatASmoothAdapter$1(BaseWhatASmoothAdapter paramBaseWhatASmoothAdapter, View paramView, Object paramObject1, Object paramObject2, int paramInt, BaseWhatASmoothAdapter.RunningMark paramRunningMark) {}
  
  public void run()
  {
    Object localObject1 = this.a.getTag();
    if (this.b != null)
    {
      Object localObject2 = this.c;
      if ((localObject2 != null) && ((localObject2.equals(localObject1)) || (localObject1 == null)))
      {
        this.this$0.a(this.a, this.b);
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.this$0.a);
        ((StringBuilder)localObject2).append(this.d);
        ((View)localObject1).setTag(((StringBuilder)localObject2).toString());
      }
    }
    BaseWhatASmoothAdapter.RunningMark.a(this.e, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter.1
 * JD-Core Version:    0.7.0.1
 */