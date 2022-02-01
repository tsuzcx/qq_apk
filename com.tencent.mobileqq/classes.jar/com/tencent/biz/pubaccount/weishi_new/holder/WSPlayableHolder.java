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
  public IWSPlayerUIDelegate a;
  public WSPlayerParam a;
  public WSVideoInfo a;
  
  public WSPlayableHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public abstract ViewGroup a();
  
  public boolean b()
  {
    WSPlayerParam localWSPlayerParam = this.a;
    return (localWSPlayerParam != null) && (localWSPlayerParam.a != null) && (this.a.a.b());
  }
  
  public boolean c()
  {
    WSPlayerParam localWSPlayerParam = this.a;
    return (localWSPlayerParam != null) && (localWSPlayerParam.a != null) && (this.a.a.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder
 * JD-Core Version:    0.7.0.1
 */