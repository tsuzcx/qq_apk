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
  private WSVerticalVideoHolder a;
  private WSVerticalVideoHolder b;
  private LinkedList<WSVerticalVideoHolder> c = new LinkedList();
  private WSPlayerManager d;
  private WSVerticalPageFragment e;
  private WSPlayerParam f;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  
  public WSVerticalPageAdapter(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.e = paramWSVerticalPageFragment;
  }
  
  private stSimpleMetaFeed a(WSVerticalItemData paramWSVerticalItemData)
  {
    if (paramWSVerticalItemData != null) {
      return paramWSVerticalItemData.b();
    }
    return null;
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSPlayerParam paramWSPlayerParam, String paramString)
  {
    if (l())
    {
      this.f = k();
      if ((a(paramInt, paramstSimpleMetaFeed, this.f)) && (this.f.b != null) && (this.f.d != null))
      {
        paramWSPlayerParam.d = this.f.d;
        paramWSPlayerParam.b = this.f.b;
        paramWSPlayerParam.l = this.f.l;
        paramWSPlayerParam.d.d(false);
      }
    }
  }
  
  private void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageAdapter.java][switchPlayerVideoViewLayout] holder: ");
    localStringBuilder.append(paramWSVerticalVideoHolder);
    WSLog.b("WSVerticalPageAdapterLog", localStringBuilder.toString());
    this.a = paramWSVerticalVideoHolder;
    WSReportDc00898.a(this.a.f, false);
    WSVerticalBeaconReport.a(this.e.k(), this.e.l(), this.a.f, this.h, ((WSVerticalPageContract.Presenter)this.e.aO_()).n());
    this.d.a(this.a.f, true);
    this.d.c(false);
  }
  
  private void a(WSVerticalVideoHolder paramWSVerticalVideoHolder, WSVerticalItemData paramWSVerticalItemData, int paramInt, String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramWSVerticalItemData);
    Object localObject = paramWSVerticalVideoHolder.f;
    paramWSVerticalItemData = (WSVerticalItemData)localObject;
    if (localObject == null) {
      paramWSVerticalItemData = new WSPlayerParam();
    }
    paramWSVerticalItemData.c = WSPlayerUtils.a(localstSimpleMetaFeed);
    paramWSVerticalItemData.a = paramWSVerticalVideoHolder.b();
    IWSPlayerUIDelegate localIWSPlayerUIDelegate = paramWSVerticalVideoHolder.g;
    localObject = localIWSPlayerUIDelegate;
    if (localIWSPlayerUIDelegate == null) {
      localObject = new WSVerticalPlayerUIDelegate();
    }
    ((WSVerticalPlayerUIDelegate)localObject).a(paramWSVerticalVideoHolder);
    paramWSVerticalVideoHolder.g = ((IWSPlayerUIDelegate)localObject);
    paramWSVerticalItemData.k = paramWSVerticalVideoHolder.g;
    paramWSVerticalItemData.e = paramWSVerticalVideoHolder.b(localstSimpleMetaFeed);
    paramWSVerticalItemData.g = 0L;
    paramWSVerticalItemData.i = true;
    paramWSVerticalItemData.f = paramInt;
    paramWSVerticalItemData.j = WSVerticalUtils.b(paramString);
    a(paramInt, localstSimpleMetaFeed, paramWSVerticalItemData, paramString);
    paramWSVerticalVideoHolder.f = paramWSVerticalItemData;
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, WSPlayerParam paramWSPlayerParam)
  {
    if (paramstSimpleMetaFeed != null) {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;
    } else {
      paramstSimpleMetaFeed = "";
    }
    String str = b(paramWSPlayerParam);
    WSVerticalPageFragment localWSVerticalPageFragment = this.e;
    return (localWSVerticalPageFragment != null) && (localWSVerticalPageFragment.I() == paramInt + 1) && (!TextUtils.isEmpty(str)) && (TextUtils.equals(paramstSimpleMetaFeed, str)) && (a(paramWSPlayerParam));
  }
  
  private boolean a(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = c(paramWSPlayerParam);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramWSPlayerParam != null) {
      if (!paramWSPlayerParam.e())
      {
        bool1 = bool2;
        if (!paramWSPlayerParam.h()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String b(WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.c != null)) {
      return paramWSPlayerParam.c.a;
    }
    return "";
  }
  
  private void b(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    this.d.n();
    this.a = paramWSVerticalVideoHolder;
    this.d.b(this.a.f, false);
    this.g = Math.max(this.g, this.a.getLayoutPosition());
    paramWSVerticalVideoHolder = new StringBuilder();
    paramWSVerticalVideoHolder.append("[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:");
    paramWSVerticalVideoHolder.append(this.g);
    paramWSVerticalVideoHolder.append(", currentPosition():");
    paramWSVerticalVideoHolder.append(this.a.getLayoutPosition());
    WSLog.a("WSVerticalPageAdapterLog", paramWSVerticalVideoHolder.toString());
  }
  
  private void b(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder)
  {
    if (!(paramBaseViewHolder instanceof WSVerticalCommonVideoHolder)) {
      return;
    }
    ((WSVerticalCommonVideoHolder)paramBaseViewHolder).a(this.i);
  }
  
  private WSPlayerWrapper c(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      return paramWSPlayerParam.d;
    }
    return null;
  }
  
  private void c(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    if (paramWSVerticalVideoHolder != null)
    {
      Object localObject = this.a;
      if (paramWSVerticalVideoHolder == localObject) {
        return;
      }
      this.b = paramWSVerticalVideoHolder;
      if ((localObject != null) && (((WSVerticalVideoHolder)localObject).f != null) && (this.a.f.d != null))
      {
        int k = this.a.f.d.E();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[WSVerticalPageAdapter.java][tryPrePlayVideo] state:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(", prePlayVideoHolder:");
        ((StringBuilder)localObject).append(paramWSVerticalVideoHolder);
        WSLog.b("WS_VIDEO_SCROLL", ((StringBuilder)localObject).toString());
        if ((k != 0) && (k != 1) && (k != 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[WSVerticalPageAdapter.java][tryPrePlayVideo] prePlayVideoHolder:");
          ((StringBuilder)localObject).append(paramWSVerticalVideoHolder);
          WSLog.b("WS_VIDEO_SCROLL", ((StringBuilder)localObject).toString());
          this.d.a(paramWSVerticalVideoHolder.f);
        }
      }
    }
  }
  
  private void d(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    paramWSVerticalVideoHolder = paramWSVerticalVideoHolder.f;
    if ((paramWSVerticalVideoHolder != null) && ((paramWSVerticalVideoHolder.h) || ((paramWSVerticalVideoHolder.d != null) && (paramWSVerticalVideoHolder.d.E() != 0)))) {
      paramWSVerticalVideoHolder.h = false;
    }
  }
  
  private void j()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new WSVerticalPageAdapter.1(this));
    this.d.a(localWSVideoPreDownloadManager);
  }
  
  private WSPlayerParam k()
  {
    return this.e.L();
  }
  
  private boolean l()
  {
    return this.e.K();
  }
  
  public LinkedList<WSVerticalVideoHolder> a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSVerticalPageAdapter.java][onPageSelected] currentPosition:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", viewHolder:");
    ((StringBuilder)localObject).append(paramViewHolder);
    WSLog.a("WS_VIDEO_SCROLL", ((StringBuilder)localObject).toString());
    this.h = paramInt;
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      localObject = a((WSVerticalItemData)paramViewHolder.e);
      if ((l()) && (a(paramInt, (stSimpleMetaFeed)localObject, this.f)))
      {
        a(paramViewHolder);
        WSFeedDataManager.a().a(null);
        WSDramaDataManager.a().a(null);
      }
      else
      {
        this.e.a(paramInt, paramViewHolder.f);
        b(paramViewHolder);
      }
      this.f = null;
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.d = paramWSPlayerManager;
    paramWSPlayerManager = new WSPlayerStatusListenerImpl(paramWSPlayerManager);
    paramWSPlayerManager.a(this.e);
    this.d.a(paramWSPlayerManager);
    j();
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
    this.j = paramBoolean;
  }
  
  public stSimpleMetaFeed b(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)getItem(paramInt);
    if (localWSVerticalItemData != null) {
      return localWSVerticalItemData.b();
    }
    return null;
  }
  
  public WSVerticalVideoHolder b()
  {
    return this.a;
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
    this.i = paramBoolean;
  }
  
  public WSVerticalVideoHolder c()
  {
    return this.b;
  }
  
  public WSPlayerManager d()
  {
    return this.d;
  }
  
  public WSVerticalItemData e()
  {
    int k = this.g;
    List localList = getDataList();
    if ((localList != null) && (localList.size() > k)) {
      return (WSVerticalItemData)localList.get(k);
    }
    return null;
  }
  
  public List<WSVerticalItemData> f()
  {
    int k = this.g;
    List localList = getDataList();
    if ((localList != null) && (localList.size() > k)) {
      return localList.subList(k, localList.size());
    }
    return null;
  }
  
  public boolean g()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((WSVerticalVideoHolder)localObject).c != null)
      {
        bool1 = bool2;
        if ((this.a.c instanceof AbsWSVideoItemView))
        {
          localObject = ((AbsWSVideoItemView)this.a.c).h();
          bool1 = bool2;
          if ((localObject instanceof WSVerticalItemVideoProgressController))
          {
            bool1 = bool2;
            if (((WSVerticalItemVideoProgressController)localObject).p()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    Object localObject = (WSVerticalItemData)getItem(paramInt);
    if ((localObject != null) && ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed)))
    {
      localObject = ((WSVerticalItemData)localObject).b().floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 3;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public boolean i()
  {
    return this.h == 0;
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
      this.e.a((WSVerticalItemData)localObject1, paramInt);
      paramBaseViewHolder.bindData(localObject1);
      Object localObject2;
      if ((paramBaseViewHolder instanceof WSVerticalBaseHolder))
      {
        localObject2 = (WSVerticalBaseHolder)paramBaseViewHolder;
        if (((WSVerticalBaseHolder)localObject2).c != null) {
          ((WSVerticalBaseHolder)localObject2).c.a(paramInt);
        }
      }
      if ((paramBaseViewHolder instanceof WSVerticalVideoHolder))
      {
        localObject2 = (WSVerticalVideoHolder)paramBaseViewHolder;
        d((WSVerticalVideoHolder)localObject2);
        a((WSVerticalVideoHolder)localObject2, (WSVerticalItemData)localObject1, paramInt, this.e.k());
        if (paramInt > 0) {
          c((WSVerticalVideoHolder)localObject2);
        }
      }
      localObject1 = (WSVerticalPageContract.Presenter)this.e.aO_();
      if (localObject1 != null) {
        ((WSVerticalPageContract.Presenter)localObject1).a(paramBaseViewHolder, paramInt);
      }
      if ((paramBaseViewHolder instanceof WSVerticalCommonVideoHolder)) {
        ((WSVerticalCommonVideoHolder)paramBaseViewHolder).b(this.j);
      }
    }
  }
  
  public BaseViewHolder<WSVerticalItemData> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = WSVerticalFactory.a(paramViewGroup, paramInt, this.e);
    this.c.addLast((WSVerticalVideoHolder)paramViewGroup);
    b(paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int m = paramRecyclerView.getChildCount();
    int k = 0;
    while (k < m)
    {
      WSVerticalBaseHolder localWSVerticalBaseHolder = (WSVerticalBaseHolder)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(k));
      if (localWSVerticalBaseHolder != null) {
        localWSVerticalBaseHolder.c.a();
      }
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter
 * JD-Core Version:    0.7.0.1
 */