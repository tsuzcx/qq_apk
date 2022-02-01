package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager;
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
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalCommonVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalFactory;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.LinkedList;
import java.util.List;

public class WSVerticalPageAdapter
  extends BaseAdapter<WSVerticalItemData, BaseViewHolder<WSVerticalItemData>>
{
  private int jdField_a_of_type_Int;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSPlayerParam jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  private LinkedList<WSVerticalVideoHolder> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private WSVerticalVideoHolder jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  private boolean jdField_b_of_type_Boolean;
  
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
  
  private WSPlayerParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
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
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSPlayerParam paramWSPlayerParam, String paramString)
  {
    if (c())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = a();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageAdapter.java][switchPlayerVideoViewLayout] holder: ");
    localStringBuilder.append(paramWSVerticalVideoHolder);
    WSLog.b("WSVerticalPageAdapterLog", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    WSReportDc00898.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, this.jdField_b_of_type_Int, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(false);
  }
  
  private void a(WSVerticalVideoHolder paramWSVerticalVideoHolder, WSVerticalItemData paramWSVerticalItemData, int paramInt, String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramWSVerticalItemData);
    Object localObject = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    paramWSVerticalItemData = (WSVerticalItemData)localObject;
    if (localObject == null) {
      paramWSVerticalItemData = new WSPlayerParam();
    }
    paramWSVerticalItemData.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo = WSPlayerUtils.a(localstSimpleMetaFeed);
    paramWSVerticalItemData.jdField_a_of_type_AndroidViewViewGroup = paramWSVerticalVideoHolder.a();
    IWSPlayerUIDelegate localIWSPlayerUIDelegate = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
    localObject = localIWSPlayerUIDelegate;
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
    a(paramInt, localstSimpleMetaFeed, paramWSVerticalItemData, paramString);
    paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSVerticalItemData;
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSPlayerParam paramWSPlayerParam)
  {
    if (paramstSimpleMetaFeed != null) {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;
    } else {
      paramstSimpleMetaFeed = "";
    }
    String str = a(paramWSPlayerParam);
    WSVerticalPageFragment localWSVerticalPageFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    return (localWSVerticalPageFragment != null) && (localWSVerticalPageFragment.a() == paramInt + 1) && (!TextUtils.isEmpty(str)) && (TextUtils.equals(paramstSimpleMetaFeed, str)) && (a(paramWSPlayerParam));
  }
  
  private boolean a(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = a(paramWSPlayerParam);
    boolean bool2 = false;
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
    paramWSVerticalVideoHolder = new StringBuilder();
    paramWSVerticalVideoHolder.append("[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:");
    paramWSVerticalVideoHolder.append(this.jdField_a_of_type_Int);
    paramWSVerticalVideoHolder.append(", currentPosition():");
    paramWSVerticalVideoHolder.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.getLayoutPosition());
    WSLog.a("WSVerticalPageAdapterLog", paramWSVerticalVideoHolder.toString());
  }
  
  private void b(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder)
  {
    if (!(paramBaseViewHolder instanceof WSVerticalCommonVideoHolder)) {
      return;
    }
    ((WSVerticalCommonVideoHolder)paramBaseViewHolder).a(this.jdField_a_of_type_Boolean);
  }
  
  private void c(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    if (paramWSVerticalVideoHolder != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
      if (paramWSVerticalVideoHolder == localObject) {
        return;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
      if ((localObject != null) && (((WSVerticalVideoHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null))
      {
        int i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[WSVerticalPageAdapter.java][tryPrePlayVideo] state:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", prePlayVideoHolder:");
        ((StringBuilder)localObject).append(paramWSVerticalVideoHolder);
        WSLog.b("WS_VIDEO_SCROLL", ((StringBuilder)localObject).toString());
        if ((i != 0) && (i != 1) && (i != 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[WSVerticalPageAdapter.java][tryPrePlayVideo] prePlayVideoHolder:");
          ((StringBuilder)localObject).append(paramWSVerticalVideoHolder);
          WSLog.b("WS_VIDEO_SCROLL", ((StringBuilder)localObject).toString());
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
        }
      }
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.d();
  }
  
  private void d(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    paramWSVerticalVideoHolder = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    if ((paramWSVerticalVideoHolder != null) && ((paramWSVerticalVideoHolder.jdField_a_of_type_Boolean) || ((paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null) && (paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e() != 0)))) {
      paramWSVerticalVideoHolder.jdField_a_of_type_Boolean = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public stSimpleMetaFeed a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)getItem(paramInt);
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
    List localList = getDataList();
    if ((localList != null) && (localList.size() > i)) {
      return (WSVerticalItemData)localList.get(i);
    }
    return null;
  }
  
  public WSVerticalVideoHolder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  }
  
  public LinkedList<WSVerticalVideoHolder> a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList;
  }
  
  public List<WSVerticalItemData> a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = getDataList();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSVerticalPageAdapter.java][onPageSelected] currentPosition:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", viewHolder:");
    ((StringBuilder)localObject).append(paramViewHolder);
    WSLog.a("WS_VIDEO_SCROLL", ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_Int = paramInt;
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      localObject = a((WSVerticalItemData)paramViewHolder.jdField_a_of_type_JavaLangObject);
      if ((c()) && (a(paramInt, (stSimpleMetaFeed)localObject, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam)))
      {
        a(paramViewHolder);
        WSFeedDataManager.a().a(null);
        WSDramaDataManager.a().a(null);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(paramInt, paramViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
        b(paramViewHolder);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
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
    paramBaseViewHolder.onViewDetachedFromWindow();
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    List localList = getDataList();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((WSVerticalVideoHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null)
      {
        bool1 = bool2;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSVideoItemView))
        {
          localObject = ((AbsWSVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView).b();
          bool1 = bool2;
          if ((localObject instanceof WSVerticalItemVideoProgressController))
          {
            bool1 = bool2;
            if (((WSVerticalItemVideoProgressController)localObject).a()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public WSVerticalVideoHolder b()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  }
  
  public void b(List<WSVerticalItemData> paramList)
  {
    List localList = getDataList();
    if (localList == null) {
      return;
    }
    if (localList.addAll(0, paramList)) {
      notifyItemRangeInserted(0, paramList.size());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 0;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    Object localObject = (WSVerticalItemData)getItem(paramInt);
    if ((localObject != null) && ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = ((WSVerticalItemData)localObject).a().floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 3;
  }
  
  public void onBindCustomViewHolder(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSVerticalPageAdapter.java][onBindCustomViewHolder] position: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", holder:");
    ((StringBuilder)localObject1).append(paramBaseViewHolder);
    WSLog.b("WS_VIDEO_SCROLL", ((StringBuilder)localObject1).toString());
    localObject1 = (WSVerticalItemData)getItem(paramInt);
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a((WSVerticalItemData)localObject1, paramInt);
      paramBaseViewHolder.bindData(localObject1);
      Object localObject2;
      if ((paramBaseViewHolder instanceof WSVerticalBaseHolder))
      {
        localObject2 = (WSVerticalBaseHolder)paramBaseViewHolder;
        if (((WSVerticalBaseHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null) {
          ((WSVerticalBaseHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a(paramInt);
        }
      }
      if ((paramBaseViewHolder instanceof WSVerticalVideoHolder))
      {
        localObject2 = (WSVerticalVideoHolder)paramBaseViewHolder;
        d((WSVerticalVideoHolder)localObject2);
        a((WSVerticalVideoHolder)localObject2, (WSVerticalItemData)localObject1, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        if (paramInt > 0) {
          c((WSVerticalVideoHolder)localObject2);
        }
      }
      localObject1 = (WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      if (localObject1 != null) {
        ((WSVerticalPageContract.Presenter)localObject1).a(paramBaseViewHolder, paramInt);
      }
      if ((paramBaseViewHolder instanceof WSVerticalCommonVideoHolder)) {
        ((WSVerticalCommonVideoHolder)paramBaseViewHolder).b(this.jdField_b_of_type_Boolean);
      }
    }
  }
  
  public BaseViewHolder<WSVerticalItemData> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = WSVerticalFactory.a(paramViewGroup, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_JavaUtilLinkedList.addLast((WSVerticalVideoHolder)paramViewGroup);
    b(paramViewGroup);
    return paramViewGroup;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter
 * JD-Core Version:    0.7.0.1
 */