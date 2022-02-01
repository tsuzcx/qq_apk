package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
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
  public static int b;
  public int a;
  public long a;
  private WSRecommendAdapter.ItemViewExposeListener a;
  public RockDownloadListenerWrapper a;
  public WSDownloadListenerWrapper a;
  public RecyclerViewWithHeaderFooter a;
  public final String a;
  public boolean a;
  public final String b;
  public int c = 0;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  
  public WSRecommendAdapter(Context paramContext, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, String paramString1, String paramString2)
  {
    super(paramContext);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramRecyclerViewWithHeaderFooter;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.d = ScreenUtil.getRealWidth(paramContext);
    this.e = ScreenUtil.dip2px(5.0F);
    this.f = ScreenUtil.dip2px(18.0F);
    this.g = ScreenUtil.dip2px(14.0F);
  }
  
  public RockDownloadListenerWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = new WSRecommendAdapter.1(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper;
  }
  
  public WSDownloadListenerWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper = WeishiDownloadUtil.a(100, 2);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper;
  }
  
  public void a(WSRecommendAdapter.ItemViewExposeListener paramItemViewExposeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter$ItemViewExposeListener = paramItemViewExposeListener;
  }
  
  public void a(BaseViewHolder<stSimpleMetaFeed> paramBaseViewHolder)
  {
    WSRecommendAdapter.ItemViewExposeListener localItemViewExposeListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter$ItemViewExposeListener;
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
    this.jdField_a_of_type_Boolean = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */