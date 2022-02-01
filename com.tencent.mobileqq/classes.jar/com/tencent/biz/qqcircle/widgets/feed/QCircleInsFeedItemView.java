package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleProfileCardChangeListener;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFakeFeedPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedBottomInputPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBottomPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBubblePresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDesPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDoublePraisePresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemHeadPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemTagGuidePresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemVideoPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedLocationPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedRankPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleRockeyAnimationPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QCircleInsFeedItemView
  extends QCircleBaseWidgetView
  implements SimpleEventReceiver
{
  private static final String TAG = "QCircleInsFeedItemView";
  private static List<Class<? extends QCircleBaseFeedChildPresenter>> sPresenters = new ArrayList(Arrays.asList(new Class[] { QCircleFeedItemHeadPresenter.class, QCircleFeedItemDesPresenter.class, QCircleFeedItemPicPresenter.class, QCircleFeedItemVideoPresenter.class, QCircleFeedItemDoublePraisePresenter.class, QCircleFeedItemBottomPresenter.class, QCircleFeedBottomInputPresenter.class, QCircleFakeFeedPresenter.class, QCircleRockeyAnimationPresenter.class, QCircleFeedLocationPresenter.class, QCircleFeedItemTagGuidePresenter.class, QCircleFeedItemBubblePresenter.class }));
  private QCircleProfileCardChangeListener mCardObserver;
  int mCurrentType;
  private Object mData;
  private QCircleDoubleClickLayout mFeedContentArea;
  private int mPosition;
  private HashMap<Class, QCircleBaseFeedChildPresenter> mPresenterMaps;
  private RecyclerView mRecyclerView;
  
  static
  {
    if ((QCircleApplication.isRDMVersion()) && (QCirclePluginConfig.J())) {
      sPresenters.add(QCircleFeedRankPresenter.class);
    }
  }
  
  public QCircleInsFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleInsFeedItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private boolean isNeedSkipInit(Class paramClass)
  {
    if ((this.mCurrentType == 3) && (paramClass == QCircleFeedItemPicPresenter.class)) {
      return true;
    }
    return (this.mCurrentType == 2) && (paramClass == QCircleFeedItemVideoPresenter.class);
  }
  
  private void onBindPresenterData(Object paramObject, int paramInt)
  {
    System.currentTimeMillis();
    Iterator localIterator = getPresenterMaps().values().iterator();
    while (localIterator.hasNext())
    {
      QCircleBaseFeedChildPresenter localQCircleBaseFeedChildPresenter = (QCircleBaseFeedChildPresenter)localIterator.next();
      System.currentTimeMillis();
      if ((getInteractor() instanceof QCircleInteractor)) {
        localQCircleBaseFeedChildPresenter.setFetchInfoObj((QCircleInteractor)getInteractor());
      }
      if ((localQCircleBaseFeedChildPresenter instanceof QCircleFeedBottomInputPresenter)) {
        ((QCircleFeedBottomInputPresenter)localQCircleBaseFeedChildPresenter).setRecyclerView(this.mRecyclerView);
      }
      localQCircleBaseFeedChildPresenter.setExtraTypeInfo(getQCircleExtraTypeInfo());
      localQCircleBaseFeedChildPresenter.setData(paramObject);
      localQCircleBaseFeedChildPresenter.setPos(paramInt);
      if (localQCircleBaseFeedChildPresenter.getContainerView() != null) {
        localQCircleBaseFeedChildPresenter.bindData(paramObject, paramInt);
      }
    }
  }
  
  private void onInitPresenterView(Context paramContext)
  {
    System.currentTimeMillis();
    paramContext = sPresenters.iterator();
    while (paramContext.hasNext())
    {
      Class localClass = (Class)paramContext.next();
      try
      {
        if (!isNeedSkipInit(localClass))
        {
          System.currentTimeMillis();
          QCircleBaseFeedChildPresenter localQCircleBaseFeedChildPresenter = (QCircleBaseFeedChildPresenter)localClass.newInstance();
          localQCircleBaseFeedChildPresenter.setParentView(this);
          localQCircleBaseFeedChildPresenter.initView(this);
          getPresenterMaps().put(localClass, localQCircleBaseFeedChildPresenter);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void beforeInflateView(Context paramContext, int paramInt)
  {
    super.beforeInflateView(paramContext, paramInt);
    this.mCurrentType = paramInt;
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPosition = paramInt;
    onBindPresenterData(paramObject, paramInt);
    QCircleDoubleClickLayout localQCircleDoubleClickLayout = this.mFeedContentArea;
    if (localQCircleDoubleClickLayout != null)
    {
      localQCircleDoubleClickLayout.a();
      this.mFeedContentArea.setOnDoubleClickListener(new QCircleInsFeedItemView.2(this, paramObject));
      this.mFeedContentArea.setOnLongClickListener(new QCircleInsFeedItemView.3(this));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    Object localObject = this.mData;
    if ((localObject instanceof FeedBlockData)) {
      return ((FeedBlockData)localObject).b();
    }
    return null;
  }
  
  public int getLayoutId()
  {
    return 2131626808;
  }
  
  protected String getLogTag()
  {
    return "QCircleInsFeedItemView";
  }
  
  public QCircleFeedItemPicPresenter getPicPresenter()
  {
    return (QCircleFeedItemPicPresenter)getPresenterByClass(QCircleFeedItemPicPresenter.class);
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public <T extends QCircleBaseFeedChildPresenter> T getPresenterByClass(Class<T> paramClass)
  {
    return (QCircleBaseFeedChildPresenter)getPresenterMaps().get(paramClass);
  }
  
  public HashMap<Class, QCircleBaseFeedChildPresenter> getPresenterMaps()
  {
    if (this.mPresenterMaps == null) {
      this.mPresenterMaps = new HashMap();
    }
    return this.mPresenterMaps;
  }
  
  public QCircleFeedItemVideoPresenter getVideoPresenter()
  {
    return (QCircleFeedItemVideoPresenter)getPresenterByClass(QCircleFeedItemVideoPresenter.class);
  }
  
  public void launchFeedDetail()
  {
    if ((getQCircleExtraTypeInfo() != null) && (getQCircleExtraTypeInfo().pageType != 69))
    {
      QCircleLayerBean localQCircleLayerBean = null;
      if (getVideoPresenter() != null)
      {
        localQCircleLayerBean = getVideoPresenter().getContentDetailQCircleInitBean();
        SimpleEventBus.getInstance().registerReceiver(getVideoPresenter());
      }
      else if (getPicPresenter() != null)
      {
        localQCircleLayerBean = getPicPresenter().getDetailInitBean(getPicPresenter().getPicPosition());
      }
      if (localQCircleLayerBean != null)
      {
        boolean bool = true;
        if (QCircleConfigHelper.a("qqcircle", "qqcircle_feeddetail_recom", Integer.valueOf(1)).intValue() != 0) {
          bool = false;
        }
        localQCircleLayerBean.setSingleFeed(bool);
      }
      QCircleLauncher.a(getContext(), localQCircleLayerBean);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    HostDataTransUtils.registerProfileCardObserver(this.mCardObserver);
    Iterator localIterator = getPresenterMaps().values().iterator();
    while (localIterator.hasNext()) {
      ((QCircleBaseFeedChildPresenter)localIterator.next()).onAttachedToWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    HostDataTransUtils.unRegisterCardObserver(this.mCardObserver);
    Iterator localIterator = getPresenterMaps().values().iterator();
    while (localIterator.hasNext()) {
      ((QCircleBaseFeedChildPresenter)localIterator.next()).onDetachedFromWindow();
    }
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.mFeedContentArea = ((QCircleDoubleClickLayout)paramView.findViewById(2131440928));
    this.mCardObserver = new QCircleInsFeedItemView.1(this);
    onInitPresenterView(paramContext);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void setEnableBottomInput(boolean paramBoolean)
  {
    if (getPresenterByClass(QCircleFeedBottomInputPresenter.class) != null) {
      ((QCircleFeedBottomInputPresenter)getPresenterByClass(QCircleFeedBottomInputPresenter.class)).setEnableBottomInput(paramBoolean);
    }
  }
  
  public void setFeedBottomVisibleStateSource(QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource paramFeedBottomVisibleStateSource)
  {
    if (getPresenterByClass(QCircleFeedBottomInputPresenter.class) != null) {
      ((QCircleFeedBottomInputPresenter)getPresenterByClass(QCircleFeedBottomInputPresenter.class)).setFeedBottomVisibleStateSource(paramFeedBottomVisibleStateSource);
    }
  }
  
  public void setPicInitialItemPos(int paramInt)
  {
    if (getPicPresenter() != null) {
      getPicPresenter().setInitialItemPos(paramInt);
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    paramQCircleReportBean = getPresenterMaps().values().iterator();
    while (paramQCircleReportBean.hasNext()) {
      ((QCircleBaseFeedChildPresenter)paramQCircleReportBean.next()).setReportBean(getReportBean());
    }
  }
  
  public void setShareRecyclerViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    if (getPresenterByClass(QCircleFeedItemBottomPresenter.class) != null) {
      ((QCircleFeedItemBottomPresenter)getPresenterByClass(QCircleFeedItemBottomPresenter.class)).setShareRecyclerViewPool(paramRecycledViewPool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView
 * JD-Core Version:    0.7.0.1
 */