package com.tencent.biz.pubaccount.weishi_new.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public abstract class WSPlayableHolder<T>
  extends BaseViewHolder<T>
{
  public WSVideoInfo a;
  public WSPlayerParam b;
  public IWSPlayerUIDelegate c;
  
  public WSPlayableHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public abstract ViewGroup k();
  
  public boolean m()
  {
    WSPlayerParam localWSPlayerParam = this.b;
    return (localWSPlayerParam != null) && (localWSPlayerParam.d != null) && (this.b.d.e());
  }
  
  public boolean n()
  {
    WSPlayerParam localWSPlayerParam = this.b;
    return (localWSPlayerParam != null) && (localWSPlayerParam.d != null) && (this.b.d.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder
 * JD-Core Version:    0.7.0.1
 */