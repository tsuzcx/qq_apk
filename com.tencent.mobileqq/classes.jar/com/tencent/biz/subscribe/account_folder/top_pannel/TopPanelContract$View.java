package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import com.tencent.biz.subscribe.account_folder.BaseView;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import java.util.List;

public abstract interface TopPanelContract$View
  extends BaseView<TopPanelContract.Presenter>
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelContract.View
 * JD-Core Version:    0.7.0.1
 */