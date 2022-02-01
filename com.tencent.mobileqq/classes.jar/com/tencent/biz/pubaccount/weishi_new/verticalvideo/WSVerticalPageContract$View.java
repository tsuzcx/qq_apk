package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.IWSEpisodeChoiceView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import java.util.List;

public abstract interface WSVerticalPageContract$View
  extends IWSView<List<WSVerticalItemData>>
{
  public abstract stSimpleMetaFeed C();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, Intent paramIntent);
  
  public abstract void a(stGlobalConfig paramstGlobalConfig);
  
  public abstract void a(WSVerticalItemData paramWSVerticalItemData);
  
  public abstract void a(String paramString);
  
  public abstract void a(List<WSVerticalItemData> paramList);
  
  public abstract void aX_();
  
  public abstract WSVerticalPageAdapter b();
  
  public abstract void b(List<WSVerticalItemData> paramList);
  
  public abstract VideoFeedsRecyclerView c();
  
  public abstract void c(@ColorInt int paramInt);
  
  public abstract TextView d();
  
  public abstract WSPlayerManager e();
  
  public abstract List<WSVerticalItemData> g();
  
  public abstract String k();
  
  public abstract String l();
  
  public abstract String m();
  
  public abstract String n();
  
  public abstract String p();
  
  public abstract boolean q();
  
  public abstract boolean t();
  
  public abstract IWSEpisodeChoiceView v();
  
  public abstract WSVideoPageChangeObserver w();
  
  public abstract void x();
  
  public abstract void y();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View
 * JD-Core Version:    0.7.0.1
 */