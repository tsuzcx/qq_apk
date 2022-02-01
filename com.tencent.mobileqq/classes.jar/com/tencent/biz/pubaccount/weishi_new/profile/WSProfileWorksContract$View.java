package com.tencent.biz.pubaccount.weishi_new.profile;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.List;

public abstract interface WSProfileWorksContract$View
  extends IWSView<List<stSimpleMetaFeed>>
{
  public abstract void a(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorksContract.View
 * JD-Core Version:    0.7.0.1
 */