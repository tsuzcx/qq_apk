package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaData;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import java.util.List;

public abstract interface WSGridPageContract$View
  extends IWSView<List<stSimpleMetaFeed>>
{
  public abstract int a();
  
  public abstract String a();
  
  public abstract List<stSimpleMetaFeed> a();
  
  public abstract void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed);
  
  public abstract void a(stGlobalConfig paramstGlobalConfig);
  
  public abstract void a(stNotificationRsp paramstNotificationRsp, RspHeaderBean paramRspHeaderBean);
  
  public abstract void a(@NonNull WSFollowDramaData paramWSFollowDramaData, boolean paramBoolean);
  
  public abstract void a(String paramString);
  
  public abstract void a(List<stSimpleMetaFeed> paramList);
  
  public abstract void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void e();
  
  public abstract void i();
  
  public abstract void j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.View
 * JD-Core Version:    0.7.0.1
 */