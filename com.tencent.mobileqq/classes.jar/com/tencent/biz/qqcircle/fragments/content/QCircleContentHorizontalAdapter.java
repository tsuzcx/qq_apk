package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleStickConfig;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleLiuHaiUtils;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.PagerChangeListener;
import com.tencent.biz.richframework.widget.BaseWidgetView.IInteractor;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.List;

public class QCircleContentHorizontalAdapter
  extends BaseListViewAdapter<FeedBlockData>
  implements ReportBean<QCircleReportBean>, QCirclePagerSnapHelper.PagerChangeListener
{
  private final QCircleContentModel a;
  private final QCircleContentVerticalAdapter b;
  private FeedBlockData c;
  private RecyclerView d;
  private int e;
  private QCircleContentOperationView f;
  private QCirclePagerSnapHelper.PagerChangeListener g;
  private boolean h = true;
  private boolean i;
  private QCircleReportBean j;
  private QCircleContentPart k;
  private RecyclerView.ViewHolder l;
  private BaseWidgetView.IInteractor m;
  private Context n;
  private QCircleContentOperationView o;
  private boolean p;
  
  public QCircleContentHorizontalAdapter(QCircleContentPart paramQCircleContentPart, QCircleContentVerticalAdapter paramQCircleContentVerticalAdapter)
  {
    setHasStableIds(true);
    this.a = ((QCircleContentModel)paramQCircleContentPart.a(QCircleContentModel.class));
    this.k = paramQCircleContentPart;
    this.b = paramQCircleContentVerticalAdapter;
  }
  
  private QCircleContentVideo a(Context paramContext)
  {
    paramContext = new QCircleContentVideo(paramContext);
    paramContext.setPlayScene(this.k.q().mPlayScene);
    paramContext.setSupportSeek(true);
    paramContext.setReportBean(d());
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  private String a(String paramString)
  {
    paramString = QCirclePluginGlobalInfo.b(paramString);
    if (paramString != null) {
      return paramString.video.playUrl.get();
    }
    return "";
  }
  
  private void a(View paramView)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (paramView == null) {
        return;
      }
      int i2 = ((FeedBlockData)localObject).b().cover.height.get();
      int i3 = this.c.b().cover.width.get();
      if (i2 > 0)
      {
        if (i3 <= 0) {
          return;
        }
        int i1 = ImmersiveUtils.b();
        i2 = (int)(i1 / i3 * i2);
        localObject = (FrameLayout.LayoutParams)paramView.getLayoutParams();
        if (localObject != null)
        {
          ((FrameLayout.LayoutParams)localObject).width = i1;
          ((FrameLayout.LayoutParams)localObject).height = i2;
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private void a(QCircleContentHorizontalAdapter.QCirclePicVH paramQCirclePicVH)
  {
    paramQCirclePicVH = this.c.b();
    if (paramQCirclePicVH != null)
    {
      QCircleContentOperationView localQCircleContentOperationView = this.o;
      if (localQCircleContentOperationView != null)
      {
        localQCircleContentOperationView.setAllPicCount(paramQCirclePicVH.images.get().size());
        this.o.setCurPicPos(QCircleFeedDataCenter.a().b(paramQCirclePicVH.id.get()));
        a(QCircleFeedDataCenter.a().b(paramQCirclePicVH.id.get()));
        this.b.b(QCircleFeedDataCenter.a().b(paramQCirclePicVH.id.get()));
        if (paramQCirclePicVH.images.size() == 1) {
          this.o.h.setVisibility(8);
        }
      }
    }
  }
  
  private boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    return (this.c != null) && (paramStFeed.id.get().equals(this.c.b().id.get())) && ((c(paramStFeed)) || (b(paramStFeed)));
  }
  
  private QCircleExpandStickLayout b(Context paramContext)
  {
    paramContext = new QCircleExpandStickLayout(paramContext);
    paramContext.setReportBean(d());
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  private void b(FeedBlockData paramFeedBlockData, int paramInt)
  {
    this.c = paramFeedBlockData;
    this.e = paramInt;
  }
  
  private boolean b(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 3) && (paramStFeed.video.fileId.get().equals(this.c.b().video.fileId.get()));
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    FeedCloudMeta.StFeed localStFeed = this.c.b();
    if (localStFeed == null)
    {
      QLog.e("QCircleReportHelper", 1, "reportContentExpose failed！feed ==null");
      return;
    }
    int i1 = localStFeed.type.get();
    String str1 = "";
    Object localObject;
    String str2;
    if ((i1 == 2) && (localStFeed.images.size() > paramViewHolder.getAdapterPosition()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((FeedCloudMeta.StImage)localStFeed.images.get(paramViewHolder.getAdapterPosition())).picId.get());
      ((StringBuilder)localObject).append("");
      str2 = ((StringBuilder)localObject).toString();
    }
    else
    {
      str2 = "";
    }
    i1 = localStFeed.type.get();
    String str3 = "2";
    if (i1 == 2)
    {
      localObject = this.f;
      if ((localObject != null) && (((QCircleContentOperationView)localObject).k == paramViewHolder.getAdapterPosition()))
      {
        paramViewHolder = "0";
      }
      else
      {
        localObject = this.f;
        if ((localObject != null) && (((QCircleContentOperationView)localObject).k > paramViewHolder.getAdapterPosition()))
        {
          paramViewHolder = "1";
        }
        else
        {
          localObject = this.f;
          if ((localObject != null) && (((QCircleContentOperationView)localObject).k < paramViewHolder.getAdapterPosition())) {
            paramViewHolder = "2";
          } else {
            paramViewHolder = "";
          }
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localStFeed.images.size());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      str1 = "1";
    }
    else if (localStFeed.type.get() == 3)
    {
      paramViewHolder = "";
      localObject = paramViewHolder;
      str1 = "2";
    }
    else
    {
      paramViewHolder = "";
      localObject = paramViewHolder;
    }
    if (!QCircleContentImmersiveEvent.isImmersive()) {
      str3 = "1";
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(localStFeed)).setActionType(1).setSubActionType(1).setPosition(this.e).setPlayScene(this.k.q().mPlayScene).setLloc(str2).setExt1(str1).setExt2(paramViewHolder).setExt3((String)localObject).setExt4(str3).setPageId(e()).setfpageid(f()));
  }
  
  private void c(QCircleContentHorizontalAdapter.QCircleVideoVH paramQCircleVideoVH)
  {
    if (this.b != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((FeedBlockData)localObject).b();
        a(paramQCircleVideoVH);
        paramQCircleVideoVH.a.setOperationView(this.o);
        int i1 = 0;
        if (this.b.d() != 0L)
        {
          i1 = (int)this.b.d();
          this.b.a(0L);
        }
        String str = a(((FeedCloudMeta.StFeed)localObject).id.get());
        StringBuilder localStringBuilder;
        if (TextUtils.isEmpty(str))
        {
          str = ((FeedCloudMeta.StFeed)localObject).video.playUrl.get();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("play net url:");
          localStringBuilder.append(str);
          QLog.d("QCircleContentHorizontalAdapter", 1, localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("play local url:");
          localStringBuilder.append(str);
          QLog.d("QCircleContentHorizontalAdapter", 1, localStringBuilder.toString());
        }
        paramQCircleVideoVH.a.setVideoPath(((FeedCloudMeta.StFeed)localObject).video, i1);
        this.b.h();
        b(paramQCircleVideoVH);
        this.b.a(paramQCircleVideoVH);
      }
    }
  }
  
  private boolean c(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed.type.get() == 2) && (paramStFeed.images.size() == this.c.b().images.size()) && (paramStFeed.images.size() > 1) && (((FeedCloudMeta.StImage)paramStFeed.images.get(0)).picUrl.get().equals(((FeedCloudMeta.StImage)this.c.b().images.get(0)).picUrl.get()));
  }
  
  private void g()
  {
    Object localObject = this.o;
    if (localObject != null) {
      ((QCircleContentOperationView)localObject).setCurrentHorizontalVH(this.l);
    }
    localObject = this.a;
    if (localObject != null) {
      ((QCircleContentModel)localObject).a(this.l);
    }
    localObject = this.l;
    if ((localObject instanceof QCircleContentHorizontalAdapter.QCirclePicVH))
    {
      a((QCircleContentHorizontalAdapter.QCirclePicVH)localObject);
      return;
    }
    if ((localObject instanceof QCircleContentHorizontalAdapter.QCircleVideoVH)) {
      c((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject);
    }
  }
  
  public FeedCloudMeta.StFeed a()
  {
    return this.c.b();
  }
  
  public void a(int paramInt)
  {
    RecyclerView localRecyclerView = this.d;
    if (localRecyclerView != null)
    {
      this.i = true;
      localRecyclerView.getViewTreeObserver().addOnPreDrawListener(new QCircleContentHorizontalAdapter.4(this, paramInt));
    }
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      Object localObject = this.c.b();
      Bitmap localBitmap = QCirclePluginGlobalInfo.f(((FeedCloudMeta.StFeed)localObject).id.get());
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        paramImageView.setVisibility(0);
        return;
      }
      localObject = new Option().setUrl(((FeedCloudMeta.StFeed)localObject).cover.picUrl.get()).setTargetView(paramImageView).setLoadingDrawable(this.n.getResources().getDrawable(2130853309)).setPredecode(true);
      QCircleFeedPicLoader.setViewWidthHeight((Option)localObject, paramImageView);
      QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((FeedBlockData)localObject).b().type.get() == 2) && ((paramViewHolder instanceof QCircleContentHorizontalAdapter.QCirclePicVH)))
    {
      int i1 = paramViewHolder.getAdapterPosition();
      QCircleFeedDataCenter.a().a(this.c.b().id.get(), i1);
      localObject = paramViewHolder.itemView;
      if (paramViewHolder.getAdapterPosition() >= this.c.b().images.size()) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      ((View)localObject).setVisibility(i1);
      if (this.c.b().images.size() > 1)
      {
        localObject = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(this.c.b())).setActionType(100).setSubActionType(2).setPosition(this.e).setPlayScene(this.k.q().mPlayScene);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramViewHolder.getAdapterPosition());
        localStringBuilder.append("");
        QCircleLpReportDc05507.report(((QCircleLpReportDc05507.DataBuilder)localObject).setExt2(localStringBuilder.toString()).setPageId(e()).setfpageid(f()));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QCircleContentHorizontalAdapter onPagerChanged:");
      ((StringBuilder)localObject).append(paramViewHolder.hashCode());
      QLog.d("QCircleContentHorizontalAdapter", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.a;
    if (localObject != null) {
      ((QCircleContentModel)localObject).a(paramViewHolder);
    }
  }
  
  public void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if ((paramInt == 0) && (a(paramFeedBlockData.b())))
    {
      b(paramFeedBlockData, paramInt);
      return;
    }
    b(paramFeedBlockData, paramInt);
    notifyDataSetChanged();
  }
  
  public void a(QCircleContentHorizontalAdapter.QCircleVideoVH paramQCircleVideoVH)
  {
    QCircleContentVideo localQCircleContentVideo = a(paramQCircleVideoVH.itemView.getContext());
    localQCircleContentVideo.setVideoCover(paramQCircleVideoVH.b);
    ((FrameLayout)paramQCircleVideoVH.itemView).addView(localQCircleContentVideo, 0);
    paramQCircleVideoVH.a = localQCircleContentVideo;
    paramQCircleVideoVH.a.setData(this.c, this.e);
    a(paramQCircleVideoVH.a);
    b(paramQCircleVideoVH);
  }
  
  public void a(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.f = paramQCircleContentOperationView;
  }
  
  public void a(QCircleContentVerticalAdapter.VerticalVH paramVerticalVH)
  {
    this.o = paramVerticalVH.a;
    RecyclerView localRecyclerView = this.d;
    if ((localRecyclerView != null) && (localRecyclerView.getChildAt(0) == null))
    {
      paramVerticalVH.a().notifyItemChanged(paramVerticalVH.getAdapterPosition());
      QLog.d("QCircleContentHorizontalAdapter", 1, String.format("QCircleContentVerticalAdapter notifyItemChanged pos:%d, hashCode:%d", new Object[] { Integer.valueOf(paramVerticalVH.getAdapterPosition()), Integer.valueOf(paramVerticalVH.hashCode()) }));
    }
    if (this.l == null)
    {
      this.p = true;
      return;
    }
    g();
  }
  
  public void a(QCirclePagerSnapHelper.PagerChangeListener paramPagerChangeListener)
  {
    this.g = paramPagerChangeListener;
  }
  
  public void a(BaseWidgetView.IInteractor paramIInteractor)
  {
    this.m = paramIInteractor;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.j = QCircleReportBean.setReportBean("QCircleContentHorizontalAdapter", paramQCircleReportBean);
  }
  
  public void b() {}
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(QCircleContentHorizontalAdapter.QCircleVideoVH paramQCircleVideoVH)
  {
    if (this.c == null)
    {
      QLog.w("QCircleContentHorizontalAdapter", 1, "[updateVideoStickConfig] reportData is null.");
      return;
    }
    if (paramQCircleVideoVH.c == null)
    {
      QLog.w("QCircleContentHorizontalAdapter", 1, "[updateVideoStickConfig] stick layout not is null.");
      return;
    }
    if (paramQCircleVideoVH.a == null)
    {
      QLog.w("QCircleContentHorizontalAdapter", 1, "[updateVideoStickConfig] video not is null.");
      return;
    }
    if (!(paramQCircleVideoVH.a.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      QLog.w("QCircleContentHorizontalAdapter", 1, "[updateVideoStickConfig] not is frame layout.");
      return;
    }
    Object localObject = this.n;
    int i1;
    if ((localObject instanceof Activity)) {
      i1 = QCircleLiuHaiUtils.c((Activity)localObject);
    } else {
      i1 = 0;
    }
    localObject = (FrameLayout.LayoutParams)paramQCircleVideoVH.a.getLayoutParams();
    localObject = QCircleStickConfig.a().a(ImmersiveUtils.b()).b(ImmersiveUtils.c() + i1).c(((FrameLayout.LayoutParams)localObject).width).d(((FrameLayout.LayoutParams)localObject).height).a(this.c).e(0).a(false).a(ImageView.ScaleType.CENTER_CROP);
    paramQCircleVideoVH.c.a((QCircleStickConfig)localObject);
  }
  
  public BaseWidgetView.IInteractor c()
  {
    return this.m;
  }
  
  public QCircleReportBean d()
  {
    return QCircleReportBean.getReportBean("QCircleContentHorizontalAdapter", this.j);
  }
  
  protected int e()
  {
    return QCircleReportBean.getPageId("QCircleContentHorizontalAdapter", this.j);
  }
  
  protected int f()
  {
    return QCircleReportBean.getParentPageId("QCircleContentHorizontalAdapter", this.j);
  }
  
  public int getItemCount()
  {
    FeedBlockData localFeedBlockData = this.c;
    int i2 = 1;
    int i1 = i2;
    if (localFeedBlockData != null)
    {
      i1 = i2;
      if (localFeedBlockData.b().type.get() == 2) {
        i1 = this.c.b().images.size();
      }
    }
    return i1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    FeedBlockData localFeedBlockData = this.c;
    if (localFeedBlockData != null) {
      return localFeedBlockData.b().type.get();
    }
    return 0;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.d = paramRecyclerView;
    this.n = this.d.getContext();
    if ((this.d.getLayoutManager() instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)this.d.getLayoutManager()).setRecycleChildrenOnDetach(true);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    if ((paramViewHolder instanceof QCircleContentHorizontalAdapter.QCirclePicVH))
    {
      if (!ArrayUtils.a(paramInt, ((FeedBlockData)localObject).b().images.get()))
      {
        localObject = (QCircleContentHorizontalAdapter.QCirclePicVH)paramViewHolder;
        ((QCircleContentHorizontalAdapter.QCirclePicVH)localObject).a.setDataPosInList(paramInt);
        ((QCircleContentHorizontalAdapter.QCirclePicVH)localObject).a.setData(this.c);
        ((QCircleContentHorizontalAdapter.QCirclePicVH)localObject).a.setVerticalPos(this.e);
        ((QCircleContentHorizontalAdapter.QCirclePicVH)localObject).a.setInteractor(c());
        if (paramViewHolder.itemView.getVisibility() == 8) {
          paramViewHolder.itemView.setVisibility(0);
        }
      }
      else if (paramViewHolder.itemView.getVisibility() == 0)
      {
        paramViewHolder.itemView.setVisibility(8);
      }
    }
    else if ((paramViewHolder instanceof QCircleContentHorizontalAdapter.QCircleVideoVH))
    {
      a(((QCircleContentHorizontalAdapter.QCircleVideoVH)paramViewHolder).b);
      if ((paramViewHolder.itemView instanceof QCircleDoubleClickLayout))
      {
        ((QCircleDoubleClickLayout)paramViewHolder.itemView).a();
        ((QCircleDoubleClickLayout)paramViewHolder.itemView).setOnDoubleClickListener(new QCircleContentHorizontalAdapter.3(this));
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QCircleContentHorizontalAdapter onBindViewHolder:");
    ((StringBuilder)localObject).append(paramViewHolder.hashCode());
    QLog.d("QCircleContentHorizontalAdapter", 1, ((StringBuilder)localObject).toString());
    this.l = paramViewHolder;
    if (this.p)
    {
      g();
      this.p = false;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2)
    {
      paramViewGroup = new QCircleContentImage(paramViewGroup.getContext());
      paramViewGroup.setPlayScene(this.k.q().mPlayScene);
      paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
      paramViewGroup.setReportBean(d());
      return new QCircleContentHorizontalAdapter.QCirclePicVH(this, paramViewGroup);
    }
    QCircleDoubleClickLayout localQCircleDoubleClickLayout = new QCircleDoubleClickLayout(paramViewGroup.getContext());
    localQCircleDoubleClickLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    localQCircleDoubleClickLayout.setOnTapClickListener(new QCircleContentHorizontalAdapter.1(this, localQCircleDoubleClickLayout));
    localQCircleDoubleClickLayout.setOnLongClickListener(new QCircleContentHorizontalAdapter.2(this, paramViewGroup));
    localQCircleDoubleClickLayout.addView(new URLImageView(this.n));
    localQCircleDoubleClickLayout.addView(b(paramViewGroup.getContext()));
    return new QCircleContentHorizontalAdapter.QCircleVideoVH(this, localQCircleDoubleClickLayout);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.f = null;
    paramRecyclerView.removeCallbacks(null);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = this.g;
    if ((localObject != null) && (this.h))
    {
      ((QCirclePagerSnapHelper.PagerChangeListener)localObject).a(null);
      this.h = false;
    }
    c(paramViewHolder);
    this.l = paramViewHolder;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QCircleContentHorizontalAdapter onViewAttachedToWindow:");
    ((StringBuilder)localObject).append(paramViewHolder.hashCode());
    QLog.d("QCircleContentHorizontalAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof QCircleContentHorizontalAdapter.QCircleVideoVH))
    {
      localObject = (QCircleContentHorizontalAdapter.QCircleVideoVH)paramViewHolder;
      if (((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).a != null)
      {
        ((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).a.t();
        if (((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).b != null) {
          ((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).b.setVisibility(0);
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QCircleContentHorizontalAdapter onViewDetachedFromWindow:");
    ((StringBuilder)localObject).append(paramViewHolder.hashCode());
    QLog.d("QCircleContentHorizontalAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleContentHorizontalAdapter onViewRecycled:");
    localStringBuilder.append(paramViewHolder.hashCode());
    QLog.d("QCircleContentHorizontalAdapter", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter
 * JD-Core Version:    0.7.0.1
 */