package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import com.tencent.biz.pubaccount.weishi_new.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract interface WSVerticalPageContract$Presenter
  extends IWSPresenter<WSVerticalPageContract.View>
{
  public abstract int a(int paramInt);
  
  public abstract List<WSVerticalItemData> a(ArrayList paramArrayList);
  
  public abstract void a();
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
  
  public abstract void a(WSPlayerParam paramWSPlayerParam);
  
  public abstract void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean);
  
  public abstract void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public abstract int b();
  
  public abstract void b(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void b(String paramString);
  
  public abstract int c();
  
  public abstract void c(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract boolean i();
  
  public abstract void j();
  
  public abstract boolean k();
  
  public abstract WSPlayerParam l();
  
  public abstract Map<String, String> m();
  
  public abstract Map<String, String> n();
  
  public abstract boolean o();
  
  public abstract boolean p();
  
  public abstract void q();
  
  public abstract boolean r();
  
  public abstract int s();
  
  @Nullable
  public abstract WSAutoShowCommentParams t();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter
 * JD-Core Version:    0.7.0.1
 */