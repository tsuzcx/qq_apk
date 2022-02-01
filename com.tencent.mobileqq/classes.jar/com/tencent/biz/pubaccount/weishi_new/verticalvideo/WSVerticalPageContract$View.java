package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stGlobalConfig;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.List;

public abstract interface WSVerticalPageContract$View
  extends IWSView<List<WSVerticalItemData>>
{
  public abstract VideoFeedsRecyclerView a();
  
  public abstract WSPlayerManager a();
  
  public abstract WSVerticalPageAdapter a();
  
  public abstract String a();
  
  public abstract List<WSVerticalItemData> a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, Intent paramIntent);
  
  public abstract void a(stGlobalConfig paramstGlobalConfig);
  
  public abstract void a(List<WSVerticalItemData> paramList);
  
  public abstract String b();
  
  public abstract void b(Object paramObject);
  
  public abstract boolean b();
  
  public abstract String c();
  
  public abstract boolean c();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View
 * JD-Core Version:    0.7.0.1
 */