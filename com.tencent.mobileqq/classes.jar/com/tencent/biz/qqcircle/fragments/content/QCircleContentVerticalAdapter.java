package com.tencent.biz.qqcircle.fragments.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.richframework.compat.CompatSlideFragment;
import com.tencent.biz.qqcircle.richframework.part.ExtraInfoInterface;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedGreyPicScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedScrollManager;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.QCircleLinearPagerSnapHelper;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.PagerChangeListener;
import com.tencent.biz.richframework.part.utils.LayoutManagerUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView.IInteractor;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QCircleContentVerticalAdapter
  extends BaseListViewAdapter
  implements ExtraInfoInterface, ReportBean<QCircleReportBean>, QCirclePagerSnapHelper.PagerChangeListener
{
  protected BaseWidgetView.IInteractor a;
  private final QCircleContentModel b;
  private int c;
  private QCircleContentPart d;
  private final RecyclerView.RecycledViewPool e;
  private QCircleLinearPagerSnapHelper f;
  private RecyclerView g;
  private QCircleContentOperationView h;
  private QCircleExtraTypeInfo i;
  private long j;
  private RecyclerView.ViewHolder k;
  private QCircleContentHorizontalAdapter l;
  private QCircleTransitionLayout m;
  private RecyclerView n;
  private int o;
  private AudioManager p;
  private QCircleReportBean q;
  private QCircleFeedScrollManager r;
  private QCircleContentFeedReportScroller s;
  private QCircleContentHorizontalAdapter.QCircleVideoVH t;
  private int u = -1;
  
  public QCircleContentVerticalAdapter(QCircleContentPart paramQCircleContentPart)
  {
    this.d = paramQCircleContentPart;
    this.b = ((QCircleContentModel)this.d.a(QCircleContentModel.class));
    this.f = new QCircleLinearPagerSnapHelper();
    this.f.a(this);
    this.e = new RecyclerView.RecycledViewPool();
    this.m = paramQCircleContentPart.l();
    setHasStableIds(true);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((QCircleTransitionLayout)localObject).a(true);
        return;
      }
      int i2 = LayoutManagerUtils.b(this.n);
      boolean bool = false;
      if ((paramInt >= 1) && (i2 == 0)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      localObject = this.l;
      int i1;
      if (localObject == null) {
        i1 = -1;
      } else {
        i1 = ((QCircleContentHorizontalAdapter)localObject).getItemCount() - 1;
      }
      if ((paramInt <= -1) && (i2 == i1)) {
        paramBoolean = bool;
      }
      this.m.a(paramBoolean);
    }
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.r = new QCircleFeedScrollManager(paramRecyclerView.getContext(), paramRecyclerView, this);
    this.r.a(new QCircleFeedPicPreloadScroller());
    this.r.a(new QCircleFeedGreyPicScroller());
    this.r.a(0);
    paramRecyclerView.addOnScrollListener(this.r);
    this.r.a(paramRecyclerView);
  }
  
  private void a(QCircleContentVerticalAdapter.VerticalVH paramVerticalVH)
  {
    this.h = paramVerticalVH.a;
    this.l = paramVerticalVH.b;
    this.n = paramVerticalVH.b();
    this.l.a(paramVerticalVH);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((e() instanceof QCircleInteractor))
    {
      QCircleCommentInfo localQCircleCommentInfo = new QCircleCommentInfo();
      localQCircleCommentInfo.b = paramStFeed;
      localQCircleCommentInfo.c = this.i;
      localQCircleCommentInfo.f = 1;
      ((QCircleInteractor)e()).a("danmaku_show", localQCircleCommentInfo);
      SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(11, localQCircleCommentInfo));
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    QCircleContentOperationView localQCircleContentOperationView = this.h;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localQCircleContentOperationView != null)
    {
      bool1 = bool3;
      if (this.g != null)
      {
        bool3 = localQCircleContentOperationView.a(paramMotionEvent);
        if (this.h.c())
        {
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
        this.g.requestDisallowInterceptTouchEvent(bool1);
      }
    }
    return bool1;
  }
  
  private boolean a(RecyclerView.ViewHolder paramViewHolder, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((this.k != null) && (paramStFeed.id.get().equals(this.k.itemView.getTag())))
    {
      int i2 = paramViewHolder.getAdapterPosition();
      paramViewHolder = this.k;
      int i1;
      if (paramViewHolder == null) {
        i1 = -1;
      } else {
        i1 = paramViewHolder.getAdapterPosition();
      }
      QLog.d("QCircleContentVerticalAdapter", 1, String.format("QCircleContentVerticalAdapter onPagerChanged: same viewholder return  %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
      return true;
    }
    return false;
  }
  
  private RecyclerView b(Context paramContext)
  {
    RecyclerView localRecyclerView = new RecyclerView(paramContext);
    Object localObject = new RecyclerView.LayoutParams(-1, -1);
    ((RecyclerView.LayoutParams)localObject).bottomMargin = QCircleConstants.s;
    localRecyclerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    localRecyclerView.setRecycledViewPool(this.e);
    paramContext = new QCirclePagerSnapHelper();
    localObject = new QCircleContentHorizontalAdapter(this.d, this);
    paramContext.a((QCirclePagerSnapHelper.PagerChangeListener)localObject);
    ((QCircleContentHorizontalAdapter)localObject).a(g());
    ((QCircleContentHorizontalAdapter)localObject).a(this);
    ((QCircleContentHorizontalAdapter)localObject).a(e());
    localRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    paramContext.a(localRecyclerView);
    return localRecyclerView;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = e(paramInt1, paramInt2);
    RecyclerView localRecyclerView = this.n;
    if (localRecyclerView != null) {
      localRecyclerView.requestDisallowInterceptTouchEvent(bool);
    }
    localRecyclerView = this.g;
    if (localRecyclerView != null) {
      localRecyclerView.requestDisallowInterceptTouchEvent(true);
    }
    a(paramInt1, bool);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    QCircleTransitionLayout localQCircleTransitionLayout = this.m;
    if (localQCircleTransitionLayout != null)
    {
      if (paramBoolean)
      {
        localQCircleTransitionLayout.a(true);
        return;
      }
      int i1 = LayoutManagerUtils.a(this.g);
      int i2 = this.c;
      paramBoolean = false;
      if ((paramInt > i2) && (i1 == 0)) {
        QLog.d("QCircleContentVerticalAdapter", 1, "pull down at first");
      } else if ((paramInt < -this.c) && (i1 == getItemCount() - 1)) {
        QLog.d("QCircleContentVerticalAdapter", 1, "pull up at bottom");
      } else {
        paramBoolean = true;
      }
      this.m.a(paramBoolean);
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleContentFeedReportScroller localQCircleContentFeedReportScroller = this.s;
    if (localQCircleContentFeedReportScroller != null) {
      localQCircleContentFeedReportScroller.a(paramStFeed, paramViewHolder.getAdapterPosition());
    }
    this.d.q().mFeed = paramStFeed;
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    RecyclerView localRecyclerView = this.g;
    if ((localRecyclerView != null) && ((localRecyclerView.getContext() instanceof CompatPublicActivity)) && ((((CompatPublicActivity)this.g.getContext()).g() instanceof CompatSlideFragment)) && ((((CompatSlideFragment)((CompatPublicActivity)this.g.getContext()).g()).u() instanceof QCirclePersonalDetailFragment))) {
      ((QCirclePersonalDetailFragment)((CompatSlideFragment)((CompatPublicActivity)this.g.getContext()).g()).u()).a((FeedCloudMeta.StUser)paramStFeed.poster.get());
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    boolean bool = d(paramInt1, paramInt2);
    RecyclerView localRecyclerView = this.g;
    if (localRecyclerView != null) {
      localRecyclerView.requestDisallowInterceptTouchEvent(bool);
    }
    b(paramInt2, bool);
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if ((k() instanceof QCircleContentImage))
    {
      QCircleContentImage localQCircleContentImage = (QCircleContentImage)this.b.d().itemView;
      float f1 = paramInt1;
      float f2 = paramInt2;
      boolean bool = localQCircleContentImage.a(f1, f2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" isVerticalDisAllowInterceptEvent isImageDisAllowIntercept");
      localStringBuilder.append(bool);
      QLog.d("QCircleContentVerticalAdapter", 4, localStringBuilder.toString());
      return localQCircleContentImage.a(f1, f2);
    }
    return false;
  }
  
  private boolean e(int paramInt1, int paramInt2)
  {
    boolean bool2 = k() instanceof QCircleContentImage;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (bool2)
    {
      int i1 = ((FeedBlockData)((QCircleContentImage)this.b.d().itemView).getData()).b().images.size();
      int i2 = LayoutManagerUtils.b(this.n);
      double d1 = paramInt1;
      if ((d1 >= 1.0D) && (i2 == 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (d1 <= -1.0D)
      {
        bool2 = bool1;
        if (i2 == i1 - 1) {
          bool2 = true;
        }
      }
      boolean bool4 = ((QCircleContentImage)this.b.d().itemView).a(paramInt1, paramInt2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" isHorizontalDisAllowInterceptEvent totalPic");
      localStringBuilder.append(i1);
      localStringBuilder.append(" curPos");
      localStringBuilder.append(i2);
      localStringBuilder.append(" isbounds");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" isImageDisAllowIntercept");
      localStringBuilder.append(bool4);
      QLog.d("QCircleContentVerticalAdapter", 4, localStringBuilder.toString());
      bool1 = bool3;
      if (bool2)
      {
        bool1 = bool3;
        if (bool4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void i()
  {
    this.s = new QCircleContentFeedReportScroller(g());
  }
  
  private void j()
  {
    this.c = ViewConfiguration.get(this.g.getContext()).getScaledTouchSlop();
    this.g.addOnItemTouchListener(new QCircleContentVerticalAdapter.1(this));
  }
  
  private View k()
  {
    QCircleContentModel localQCircleContentModel = this.b;
    if ((localQCircleContentModel != null) && (localQCircleContentModel.d() != null) && (this.b.d().itemView != null)) {
      return this.b.d().itemView;
    }
    return null;
  }
  
  private void l()
  {
    Object localObject = this.t;
    if (localObject != null) {
      ((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).a();
    }
    localObject = this.h;
    if (localObject != null) {
      ((QCircleContentOperationView)localObject).b();
    }
  }
  
  public FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.requestDisallowInterceptTouchEvent(true);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.addView(b(paramContext));
    paramContext = new QCircleContentOperationView(paramContext);
    paramContext.setPlayScene(this.d.q().mPlayScene);
    paramContext.setReportBean(g());
    paramContext.setInteractor(this.a);
    paramContext.setSourceType(this.u);
    localFrameLayout.addView(paramContext, new ViewGroup.LayoutParams(-1, -1));
    localFrameLayout.setTag(2131441606, Boolean.valueOf(true));
    return localFrameLayout;
  }
  
  public void a(int paramInt)
  {
    QCircleContentOperationView localQCircleContentOperationView = this.h;
    if (localQCircleContentOperationView == null)
    {
      this.u = paramInt;
      return;
    }
    localQCircleContentOperationView.setSourceType(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QCircleContentOperationView localQCircleContentOperationView = this.h;
    if (localQCircleContentOperationView != null) {
      localQCircleContentOperationView.animate().alpha(paramInt1).setDuration(paramInt2);
    }
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    RecyclerView.ViewHolder localViewHolder = paramViewHolder;
    if (paramViewHolder == null)
    {
      paramViewHolder = this.g;
      localViewHolder = paramViewHolder.getChildViewHolder(paramViewHolder.getChildAt(0));
      QLog.d("QCircleContentVerticalAdapter", 1, "onPagerChanged:call from horizontal view");
    }
    if (localViewHolder != null)
    {
      if (ArrayUtils.a(localViewHolder.getAdapterPosition(), getDataList())) {
        return;
      }
      paramViewHolder = ((FeedBlockData)getDataList().get(localViewHolder.getAdapterPosition())).b();
      localViewHolder.itemView.setTag(paramViewHolder.id.get());
      if (a(localViewHolder, paramViewHolder)) {
        return;
      }
      l();
      b(paramViewHolder);
      a(paramViewHolder);
      b(localViewHolder, paramViewHolder);
      a((QCircleContentVerticalAdapter.VerticalVH)localViewHolder);
      this.k = localViewHolder;
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("QCircleContentVerticalAdapter onPagerChanged:");
      paramViewHolder.append(localViewHolder.hashCode());
      QLog.d("QCircleContentVerticalAdapter", 1, paramViewHolder.toString());
    }
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.i = paramQCircleExtraTypeInfo;
  }
  
  public void a(QCircleContentHorizontalAdapter.QCircleVideoVH paramQCircleVideoVH)
  {
    this.t = paramQCircleVideoVH;
  }
  
  public void a(QCircleContentHorizontalAdapter.QCircleVideoVH paramQCircleVideoVH, int paramInt)
  {
    if (paramQCircleVideoVH != null)
    {
      Object localObject = this.t;
      if (localObject != null) {
        ((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).a();
      }
      if (paramQCircleVideoVH.getLayoutPosition() == -1)
      {
        QLog.w("QCircleContentVerticalAdapter", 1, "view holder has been removed");
        return;
      }
      this.l.a(paramQCircleVideoVH);
      paramQCircleVideoVH.a.setOperationView(this.h);
      localObject = ((FeedBlockData)paramQCircleVideoVH.a.getData()).b();
      paramQCircleVideoVH.a.setVideoPath(((FeedCloudMeta.StFeed)localObject).video, paramInt);
    }
  }
  
  public void a(BaseWidgetView.IInteractor paramIInteractor)
  {
    this.a = paramIInteractor;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.q = QCircleReportBean.setReportBean("QCircleContentVerticalAdapter", paramQCircleReportBean);
  }
  
  public boolean a()
  {
    QCircleContentOperationView localQCircleContentOperationView = this.h;
    if (localQCircleContentOperationView != null) {
      return localQCircleContentOperationView.a();
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    int i1 = 0;
    while (i1 < getDataList().size())
    {
      if (((FeedBlockData)getDataList().get(i1)).b().id.get().equals(paramString))
      {
        getDataList().remove(i1);
        notifyItemRemoved(i1);
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public QCircleExtraTypeInfo c()
  {
    return this.i;
  }
  
  public long d()
  {
    return this.j;
  }
  
  public BaseWidgetView.IInteractor e()
  {
    return this.a;
  }
  
  public int f()
  {
    QCircleContentOperationView localQCircleContentOperationView = this.h;
    if (localQCircleContentOperationView != null) {
      return localQCircleContentOperationView.getCurrentPicPos();
    }
    return 0;
  }
  
  public QCircleReportBean g()
  {
    return QCircleReportBean.getReportBean("QCircleContentVerticalAdapter", this.q);
  }
  
  public int getItemCount()
  {
    return getDataNumber();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public AudioManager h()
  {
    if (this.p == null)
    {
      RecyclerView localRecyclerView = this.g;
      if (localRecyclerView != null)
      {
        this.p = ((AudioManager)localRecyclerView.getContext().getSystemService("audio"));
        this.p.requestAudioFocus(null, 3, 1);
      }
    }
    return this.p;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.g = paramRecyclerView;
    this.f.attachToRecyclerView(this.g);
    if ((this.g.getLayoutManager() instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)this.g.getLayoutManager()).setRecycleChildrenOnDetach(true);
    }
    j();
    a(paramRecyclerView);
    i();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = (FeedBlockData)getDataList().get(paramInt);
    QCircleContentVerticalAdapter.VerticalVH localVerticalVH = (QCircleContentVerticalAdapter.VerticalVH)paramViewHolder;
    localVerticalVH.a().a((FeedBlockData)localObject, paramInt);
    localVerticalVH.a(paramInt);
    localVerticalVH.a.setExtraTypeInfo(c());
    localVerticalVH.a.setInteractor(e());
    localVerticalVH.a.setData(localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QCircleContentVerticalAdapter onBindViewHolder:");
    ((StringBuilder)localObject).append(paramViewHolder.hashCode());
    QLog.d("QCircleContentVerticalAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new QCircleContentVerticalAdapter.VerticalVH(a(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.e.clear();
    paramRecyclerView = this.f;
    if (paramRecyclerView != null) {
      paramRecyclerView.a();
    }
    paramRecyclerView = this.h;
    if (paramRecyclerView != null) {
      paramRecyclerView.release();
    }
    paramRecyclerView = this.s;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.a();
      this.s = null;
    }
    this.h = null;
    this.k = null;
    this.d = null;
    paramRecyclerView = this.p;
    if (paramRecyclerView != null) {
      paramRecyclerView.abandonAudioFocus(null);
    }
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((QCircleFeedScrollManager)localObject).a(paramViewHolder);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QCircleContentVerticalAdapter onViewAttachedToWindow:");
    ((StringBuilder)localObject).append(paramViewHolder.hashCode());
    QLog.d("QCircleContentVerticalAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleContentVerticalAdapter onViewDetachedFromWindow:");
    localStringBuilder.append(paramViewHolder.hashCode());
    QLog.d("QCircleContentVerticalAdapter", 1, localStringBuilder.toString());
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleContentVerticalAdapter onViewRecycled:");
    localStringBuilder.append(paramViewHolder.hashCode());
    QLog.d("QCircleContentVerticalAdapter", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVerticalAdapter
 * JD-Core Version:    0.7.0.1
 */