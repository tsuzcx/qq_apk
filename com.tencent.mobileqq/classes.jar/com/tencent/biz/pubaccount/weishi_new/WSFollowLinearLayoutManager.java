package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.State;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;

public class WSFollowLinearLayoutManager
  extends LinearLayoutManager
{
  public WSFollowLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    return super.getExtraLayoutSpace(paramState) + WeishiUIUtil.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */