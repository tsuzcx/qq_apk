package com.tencent.biz.pubaccount.weishi_new.drama;

import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import java.util.List;

public abstract interface WSDramaPageContract$View
  extends IWSView<List<WSDramaItemData>>
{
  public abstract void a(WSPlayerParam paramWSPlayerParam);
  
  public abstract void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean);
  
  public abstract void a(List<WSDramaItemData> paramList);
  
  public abstract WSPlayerManager aK_();
  
  public abstract boolean aL_();
  
  public abstract String b();
  
  public abstract void b(WSPlayerParam paramWSPlayerParam);
  
  public abstract String c();
  
  public abstract WSDramaPageAdapter d();
  
  public abstract AbsWSDramaHolder e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View
 * JD-Core Version:    0.7.0.1
 */