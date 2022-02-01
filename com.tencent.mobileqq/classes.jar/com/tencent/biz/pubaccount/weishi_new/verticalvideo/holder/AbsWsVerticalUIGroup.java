package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public abstract class AbsWsVerticalUIGroup
  extends AbsWsUIGroup<WSVerticalItemData>
{
  public AbsWsVerticalUIGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  protected abstract void d(int paramInt);
  
  protected abstract void e(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWsVerticalUIGroup
 * JD-Core Version:    0.7.0.1
 */