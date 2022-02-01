package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalBaseHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalFactory;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSVerticalPageAdapter
  extends BaseAdapter<WSVerticalItemData, BaseViewHolder<WSVerticalItemData>>
{
  private int jdField_a_of_type_Int;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSPlayerParam jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  private int jdField_b_of_type_Int;
  private WSVerticalVideoHolder jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  
  public WSVerticalPageAdapter(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private stSimpleMetaFeed a(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramWSVerticalItemData != null) && ((paramWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      return paramWSVerticalItemData.a();
    }
    return null;
  }
  
  private WSPlayerWrapper a(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      return paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
    }
    return null;
  }
  
  private String a(WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null)) {
      return paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private void a()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new WSVerticalPageAdapter.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSPlayerParam paramWSPlayerParam)
  {
    if (d())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = WSFeedDataManager.a().a();
      if ((a(paramInt, paramstSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam)) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null))
      {
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport;
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.c(false);
      }
    }
  }
  
  private void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    WSLog.b("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][switchPlayerVideoViewLayout] holder: " + paramWSVerticalVideoHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    WSReportDc00898.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(false);
  }
  
  private void a(WSVerticalVideoHolder paramWSVerticalVideoHolder, WSVerticalItemData paramWSVerticalItemData, int paramInt, String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramWSVerticalItemData);
    paramWSVerticalItemData = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    if (paramWSVerticalItemData == null) {
      paramWSVerticalItemData = new WSPlayerParam();
    }
    for (;;)
    {
      paramWSVerticalItemData.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo = WSPlayerUtils.a(localstSimpleMetaFeed);
      paramWSVerticalItemData.jdField_a_of_type_AndroidViewViewGroup = paramWSVerticalVideoHolder.a();
      IWSPlayerUIDelegate localIWSPlayerUIDelegate = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
      Object localObject = localIWSPlayerUIDelegate;
      if (localIWSPlayerUIDelegate == null) {
        localObject = new WSVerticalPlayerUIDelegate();
      }
      ((WSVerticalPlayerUIDelegate)localObject).a(paramWSVerticalVideoHolder);
      paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = ((IWSPlayerUIDelegate)localObject);
      paramWSVerticalItemData.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
      paramWSVerticalItemData.jdField_a_of_type_Int = paramWSVerticalVideoHolder.b(localstSimpleMetaFeed);
      paramWSVerticalItemData.jdField_a_of_type_Long = 0L;
      paramWSVerticalItemData.jdField_b_of_type_Boolean = true;
      paramWSVerticalItemData.jdField_b_of_type_Int = paramInt;
      paramWSVerticalItemData.jdField_a_of_type_JavaLangString = WSVerticalUtils.a(paramString);
      a(paramInt, localstSimpleMetaFeed, paramWSVerticalItemData);
      paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSVerticalItemData;
      return;
    }
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSPlayerParam paramWSPlayerParam)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      String str = a(paramWSPlayerParam);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != paramInt + 1) || (TextUtils.isEmpty(str)) || (!TextUtils.equals(paramstSimpleMetaFeed, str)) || (!a(paramWSPlayerParam))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(WSPlayerParam paramWSPlayerParam)
  {
    boolean bool2 = false;
    paramWSPlayerParam = a(paramWSPlayerParam);
    boolean bool1 = bool2;
    if (paramWSPlayerParam != null) {
      if (!paramWSPlayerParam.b())
      {
        bool1 = bool2;
        if (!paramWSPlayerParam.c()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
    this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.getLayoutPosition());
    WSLog.a("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:" + this.jdField_a_of_type_Int + ", currentPosition():" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.getLayoutPosition());
  }
  
  private void c(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    if ((paramWSVerticalVideoHolder == null) || (paramWSVerticalVideoHolder == this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder)) {}
    int i;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper == null));
      i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e();
      WSLog.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] state:" + i + ", prePlayVideoHolder:" + paramWSVerticalVideoHolder);
    } while ((i == 0) || (i == 1) || (i == 2));
    WSLog.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + paramWSVerticalVideoHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
  }
  
  private void d(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    paramWSVerticalVideoHolder = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    if ((paramWSVerticalVideoHolder != null) && ((paramWSVerticalVideoHolder.jdField_a_of_type_Boolean) || ((paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null) && (paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e() != 0)))) {
      paramWSVerticalVideoHolder.jdField_a_of_type_Boolean = false;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "follow_tab"));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    Object localObject = (WSVerticalItemData)a(paramInt);
    if ((localObject != null) && ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = ((WSVerticalItemData)localObject).a().floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 3;
  }
  
  public stSimpleMetaFeed a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a(paramInt);
    if (localWSVerticalItemData != null) {
      return localWSVerticalItemData.a();
    }
    return null;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public WSVerticalItemData a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = b();
    if ((localList != null) && (localList.size() > i)) {
      return (WSVerticalItemData)localList.get(i);
    }
    return null;
  }
  
  public WSVerticalVideoHolder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  }
  
  public BaseViewHolder<WSVerticalItemData> a(ViewGroup paramViewGroup, int paramInt)
  {
    return WSVerticalFactory.a(paramViewGroup, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
  }
  
  public List<WSVerticalItemData> a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = b();
    if ((localList != null) && (localList.size() > i)) {
      return localList.subList(i, localList.size());
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    WSLog.a("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onPageSelected] currentPosition:" + paramInt + ", viewHolder:" + paramViewHolder);
    this.jdField_b_of_type_Int = paramInt;
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      stSimpleMetaFeed localstSimpleMetaFeed = a((WSVerticalItemData)paramViewHolder.jdField_a_of_type_JavaLangObject);
      if ((!d()) || (!a(paramInt, localstSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam))) {
        break label102;
      }
      a(paramViewHolder);
      WSFeedDataManager.a().a(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
      return;
      label102:
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(paramInt, paramViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      b(paramViewHolder);
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new WSPlayerStatusListenerImpl(paramWSPlayerManager);
    paramWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    a();
  }
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    paramBaseViewHolder.h();
  }
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    WSLog.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onBindCustomViewHolder] position: " + paramInt + ", holder:" + paramBaseViewHolder);
    Object localObject = (WSVerticalItemData)a(paramInt);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a((WSVerticalItemData)localObject, paramInt);
      paramBaseViewHolder.a(localObject);
      if (((paramBaseViewHolder instanceof WSVerticalBaseHolder)) && (((WSVerticalBaseHolder)paramBaseViewHolder).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null)) {
        ((WSVerticalBaseHolder)paramBaseViewHolder).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a(paramInt);
      }
      if ((paramBaseViewHolder instanceof WSVerticalVideoHolder))
      {
        WSVerticalVideoHolder localWSVerticalVideoHolder = (WSVerticalVideoHolder)paramBaseViewHolder;
        d(localWSVerticalVideoHolder);
        a(localWSVerticalVideoHolder, (WSVerticalItemData)localObject, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        if (paramInt > 0) {
          c(localWSVerticalVideoHolder);
        }
      }
      localObject = (WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      if (localObject != null) {
        ((WSVerticalPageContract.Presenter)localObject).a(paramBaseViewHolder, paramInt);
      }
    }
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    List localList = b();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSVideoItemView)))
    {
      AbsWsUIGroup localAbsWsUIGroup = ((AbsWSVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView).b();
      return ((localAbsWsUIGroup instanceof WSVerticalItemVideoProgressController)) && (((WSVerticalItemVideoProgressController)localAbsWsUIGroup).a());
    }
    return false;
  }
  
  public WSVerticalVideoHolder b()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 0;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      WSVerticalBaseHolder localWSVerticalBaseHolder = (WSVerticalBaseHolder)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (localWSVerticalBaseHolder != null) {
        localWSVerticalBaseHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter
 * JD-Core Version:    0.7.0.1
 */