package com.tencent.biz.pubaccount.weishi_new.profile;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseAdapter;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseViewHolder;
import java.util.List;

public class WSProfileWorkAdapter
  extends BaseAdapter<WSVerticalItemData, WSProfileWorkHolder>
{
  private String f;
  private WSProfileWorkAdapter.ItemViewExposeListener g;
  
  public WSProfileWorkAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public WSProfileWorkHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSProfileWorkHolder(paramViewGroup, this);
  }
  
  public String a()
  {
    return this.f;
  }
  
  public void a(WSProfileWorkAdapter.ItemViewExposeListener paramItemViewExposeListener)
  {
    this.g = paramItemViewExposeListener;
  }
  
  public void a(WSProfileWorkHolder paramWSProfileWorkHolder, int paramInt)
  {
    paramWSProfileWorkHolder.a((WSVerticalItemData)c().get(paramInt));
  }
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder)
  {
    super.onViewAttachedToWindow(paramBaseViewHolder);
    WSProfileWorkAdapter.ItemViewExposeListener localItemViewExposeListener = this.g;
    if (localItemViewExposeListener != null) {
      localItemViewExposeListener.a(paramBaseViewHolder);
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorkAdapter
 * JD-Core Version:    0.7.0.1
 */