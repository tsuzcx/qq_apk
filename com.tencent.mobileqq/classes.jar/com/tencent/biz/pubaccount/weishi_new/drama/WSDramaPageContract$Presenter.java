package com.tencent.biz.pubaccount.weishi_new.drama;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;

public abstract interface WSDramaPageContract$Presenter
  extends IWSPresenter<WSDramaPageContract.View>
{
  public abstract void a();
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
  
  public abstract void a(WSPlayerParam paramWSPlayerParam);
  
  public abstract void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b();
  
  public abstract void b(WSPlayerParam paramWSPlayerParam);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.Presenter
 * JD-Core Version:    0.7.0.1
 */