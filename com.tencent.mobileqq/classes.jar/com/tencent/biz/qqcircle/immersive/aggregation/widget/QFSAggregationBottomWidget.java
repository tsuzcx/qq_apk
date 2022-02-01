package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.QFSBlockContainer;
import com.tencent.biz.qqcircle.immersive.QFSMusicAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.aggregation.adapter.QFSAggregationBottomFeedBlock;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class QFSAggregationBottomWidget
  extends QCircleBaseWidgetView<List<FeedBlockData>>
  implements LifecycleOwner, SimpleEventReceiver
{
  private final LifecycleRegistry a;
  private final QFSMusicAggregationFragment b;
  private final QFSMusicAggregationInitBean c;
  private QFSBlockContainer d;
  private QFSMusicAggregationViewModel e;
  private QFSAggregationBottomFeedBlock f;
  private QFSAggregationBottomHintView g;
  private int h;
  private double i;
  private float j;
  private float k;
  private float l;
  
  public QFSAggregationBottomWidget(@NonNull Context paramContext, QFSMusicAggregationFragment paramQFSMusicAggregationFragment, QFSMusicAggregationInitBean paramQFSMusicAggregationInitBean)
  {
    super(paramContext);
    this.c = paramQFSMusicAggregationInitBean;
    this.a = new LifecycleRegistry(this);
    this.a.setCurrentState(Lifecycle.State.CREATED);
    this.b = paramQFSMusicAggregationFragment;
    this.h = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.j = ImmersiveUtils.getScreenWidth();
    this.i = Math.tan(0.5235987755982988D);
    b();
  }
  
  private void a()
  {
    this.f = new QFSAggregationBottomFeedBlock(new Bundle());
    this.f.setOnLoadDataDelegate(new QFSAggregationBottomWidget.1(this));
    this.f.a(new QFSAggregationBottomWidget.2(this));
  }
  
  private void a(int paramInt, FeedBlockData paramFeedBlockData)
  {
    if (paramFeedBlockData == null) {
      return;
    }
    paramFeedBlockData = b(paramInt, paramFeedBlockData);
    QCircleLauncher.a(getContext(), paramFeedBlockData);
  }
  
  private void a(View paramView)
  {
    this.g = ((QFSAggregationBottomHintView)paramView.findViewById(2131435053));
    paramView = this.g.getLayoutParams();
    paramView.width = ViewUtils.b();
    paramView.height = (ViewUtils.c() - ViewUtils.a() - ViewUtils.a(52.0F));
    this.g.setLayoutParams(paramView);
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent.mState == 3)
    {
      b(paramQCircleFeedEvent);
      c();
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    boolean bool = paramUIStateData.h();
    int n = paramUIStateData.c();
    int m = 0;
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4) {
              break label92;
            }
            b(paramUIStateData);
          }
          else
          {
            b(paramUIStateData, bool);
          }
        }
        else
        {
          b(paramUIStateData, bool);
          break label92;
        }
      }
      else {
        this.g.a();
      }
    }
    else {
      a(paramUIStateData, bool);
    }
    m = 1;
    label92:
    if (m != 0)
    {
      paramUIStateData = this.f;
      if (paramUIStateData != null)
      {
        paramUIStateData.getLoadInfo().a(bool);
        this.f.notifyLoadingComplete(true);
      }
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    QLog.e("QFSAggregationBottomWidget", 1, "handleFeedsRsp() return empty data");
    if (paramUIStateData.i())
    {
      QFSAggregationBottomFeedBlock localQFSAggregationBottomFeedBlock = this.f;
      if ((localQFSAggregationBottomFeedBlock != null) && (localQFSAggregationBottomFeedBlock.getItemCount() > 0))
      {
        this.f.getLoadInfo().a(paramBoolean);
        return;
      }
    }
    if (paramUIStateData.f() == null) {
      paramUIStateData = HardCodeUtil.a(2131896221);
    } else {
      paramUIStateData = paramUIStateData.f();
    }
    this.g.a("", paramUIStateData);
  }
  
  private QCircleLayerBean b(int paramInt, FeedBlockData paramFeedBlockData)
  {
    QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
    localQCircleLayerBean.setFeed(paramFeedBlockData.b());
    localQCircleLayerBean.setDataPosInList(paramInt);
    localQCircleLayerBean.setGlobalViewModelKey(this.e.f());
    return localQCircleLayerBean;
  }
  
  private void b()
  {
    this.e = ((QFSMusicAggregationViewModel)getViewModel(this.b, QFSMusicAggregationViewModel.class));
    this.e.b().observe(this, new QFSAggregationBottomWidget.4(this));
  }
  
  private void b(View paramView)
  {
    this.d = ((QFSBlockContainer)paramView.findViewById(2131429354));
    paramView = this.d.getLayoutParams();
    paramView.width = ViewUtils.b();
    paramView.height = (ViewUtils.c() - ViewUtils.a());
    setLayoutParams(paramView);
    this.d.setLayoutManagerType(2, 3);
    this.d.getRecyclerView().setNestedScrollingEnabled(true);
    this.d.a(this.f);
    this.d.setRefreshing(false);
    this.d.setEnableLoadMore(true);
    this.d.getBlockMerger().b(1);
    this.d.getRecyclerView().addOnScrollListener(new QFSAggregationBottomWidget.3(this));
    this.d.g();
  }
  
  private void b(QCircleFeedEvent paramQCircleFeedEvent)
  {
    boolean bool = this.f.a(paramQCircleFeedEvent.mTargetId);
    String str = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFSFeedEvent removeFeed  feedId = ");
    localStringBuilder.append(paramQCircleFeedEvent.mTargetId);
    localStringBuilder.append(" | result = ");
    localStringBuilder.append(bool);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  private void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    String str;
    if (paramUIStateData.f() == null) {
      str = HardCodeUtil.a(2131895632);
    } else {
      str = paramUIStateData.f();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleFeedsRsp() return error！errMsg:");
    ((StringBuilder)localObject).append(str);
    QLog.e("QFSAggregationBottomWidget", 1, ((StringBuilder)localObject).toString());
    localObject = this.f;
    if ((localObject != null) && (((QFSAggregationBottomFeedBlock)localObject).getItemCount() > 0)) {
      QCircleToastUtil.a(paramUIStateData.g(), QCircleToast.c, str, 1);
    }
    this.g.b("", str);
  }
  
  private void b(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    if (paramUIStateData.i()) {
      this.f.addAll((List)paramUIStateData.e());
    } else {
      this.f.setDatas((List)paramUIStateData.e());
    }
    this.f.getLoadInfo().a(paramBoolean);
    this.g.b();
  }
  
  private void c()
  {
    if (d())
    {
      String str = HardCodeUtil.a(2131896221);
      this.g.a("", str);
      QLog.i(getLogTag(), 1, "checkEmptyContentOperation  isEmptyContent");
    }
  }
  
  private boolean d()
  {
    QFSAggregationBottomFeedBlock localQFSAggregationBottomFeedBlock = this.f;
    return (localQFSAggregationBottomFeedBlock == null) || (localQFSAggregationBottomFeedBlock.a());
  }
  
  protected void a(List<FeedBlockData> paramList, int paramInt) {}
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131627110;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.a;
  }
  
  protected String getLogTag()
  {
    return "QFSAggregationBottomWidget";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.setCurrentState(Lifecycle.State.STARTED);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    a();
    b(paramView);
    a(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m == 2)
      {
        float f1 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        float f2 = Math.abs(this.k - f1);
        f3 = Math.abs(this.l - f3);
        if (f1 - this.k > this.h)
        {
          double d1 = f2;
          double d2 = this.i;
          Double.isNaN(d1);
          if (d1 * d2 > f3) {
            return true;
          }
        }
      }
    }
    else
    {
      this.k = paramMotionEvent.getX();
      this.l = paramMotionEvent.getY();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = this.k;
      if ((f1 - f2 > 0.0F) && (f1 - f2 >= this.j / 4.0F) && ((getContext() instanceof Activity))) {
        ((Activity)getContext()).onBackPressed();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomWidget
 * JD-Core Version:    0.7.0.1
 */