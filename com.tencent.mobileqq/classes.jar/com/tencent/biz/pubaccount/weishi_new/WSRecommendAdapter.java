package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.AbsWSGridBaseHolder;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridHolderFactory;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;

public class WSRecommendAdapter
  extends BaseAdapter<stSimpleMetaFeed, BaseViewHolder<stSimpleMetaFeed>>
{
  public static int f;
  public RecyclerViewWithHeaderFooter a;
  public WSDownloadListenerWrapper b;
  public RockDownloadListenerWrapper c;
  public long d = 0L;
  public int e = 0;
  public int g = 0;
  public final int h;
  public final int i;
  public final int j;
  public final int k;
  public final String l;
  public final String m;
  public boolean n;
  private WSRecommendAdapter.ItemViewExposeListener o;
  
  public WSRecommendAdapter(Context paramContext, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, String paramString1, String paramString2)
  {
    super(paramContext);
    this.a = paramRecyclerViewWithHeaderFooter;
    this.l = paramString1;
    this.m = paramString2;
    this.h = ScreenUtil.getRealWidth(paramContext);
    this.i = ScreenUtil.dip2px(5.0F);
    this.j = ScreenUtil.dip2px(18.0F);
    this.k = ScreenUtil.dip2px(14.0F);
  }
  
  public void a(WSRecommendAdapter.ItemViewExposeListener paramItemViewExposeListener)
  {
    this.o = paramItemViewExposeListener;
  }
  
  public void a(BaseViewHolder<stSimpleMetaFeed> paramBaseViewHolder)
  {
    WSRecommendAdapter.ItemViewExposeListener localItemViewExposeListener = this.o;
    if (localItemViewExposeListener != null) {
      localItemViewExposeListener.a(paramBaseViewHolder);
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    List localList = getDataList();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    Object localObject = getDataList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stSimpleMetaFeed)((List)localObject).get(paramInt);
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).waterFallCardStyle != null)) {
        return ((stSimpleMetaFeed)localObject).waterFallCardStyle.cardType;
      }
    }
    return 1;
  }
  
  public void onBindCustomViewHolder(BaseViewHolder<stSimpleMetaFeed> paramBaseViewHolder, int paramInt)
  {
    if ((paramBaseViewHolder instanceof AbsWSGridBaseHolder)) {
      ((AbsWSGridBaseHolder)paramBaseViewHolder).a.a(paramInt);
    }
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)getItem(paramInt);
    if (localstSimpleMetaFeed != null) {
      paramBaseViewHolder.bindData(localstSimpleMetaFeed);
    }
  }
  
  public BaseViewHolder<stSimpleMetaFeed> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return WSGridHolderFactory.a(paramInt, paramViewGroup, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */