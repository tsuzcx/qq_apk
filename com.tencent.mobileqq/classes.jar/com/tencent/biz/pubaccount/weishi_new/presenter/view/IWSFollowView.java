package com.tencent.biz.pubaccount.weishi_new.presenter.view;

import UserGrowth.stFeed;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;

public abstract interface IWSFollowView
  extends IWSView<List<stFeed>>
{
  public abstract void a(List<stFeed> paramList, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, List<stFeed> paramList, boolean paramBoolean3);
  
  public abstract void b(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void c(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void e(boolean paramBoolean);
  
  public abstract WSFollowAdapter x();
  
  public abstract XRecyclerView y();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSFollowView
 * JD-Core Version:    0.7.0.1
 */