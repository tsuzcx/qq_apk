package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract interface WSVerticalPageContract$Presenter
  extends IWSPresenter<WSVerticalPageContract.View>
{
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract long a();
  
  public abstract List<WSVerticalItemData> a(ArrayList paramArrayList);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
  
  public abstract void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter
 * JD-Core Version:    0.7.0.1
 */