package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBarragePresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildDebugInfoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildDoublePraisePresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildHeaderPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildInteractPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildStickPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedPresenterManager;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.manager.IQFSLayerScrollerStatus;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QFSLayerFeedItemView
  extends QCircleBaseWidgetView<FeedBlockData>
  implements IQFSLayerScrollerStatus
{
  private static ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>>> d = new ArrayList(Arrays.asList(new Class[] { QFSFeedChildBottomInfoPresenter.class, QFSFeedChildBarragePresenter.class, QFSFeedChildHeaderPresenter.class, QFSFeedChildInteractPresenter.class, QFSFeedChildPicPresenter.class, QFSFeedChildVideoPresenter.class, QFSFeedChildDoublePraisePresenter.class, QFSFeedChildStickPresenter.class, QFSFeedChildDebugInfoPresenter.class }));
  private HashMap<Class, QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>> a;
  private IQFSFeedIoc b;
  private QFSFeedPresenterManager c = null;
  private boolean e;
  
  public QFSLayerFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("QFSLayerFeedItemView", 1, "[notifyInitView] root view should not be null.");
      return;
    }
    paramContext = getPresenterMaps().entrySet().iterator();
    while (paramContext.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)paramContext.next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.a(paramView);
      }
    }
  }
  
  private void a(QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed> paramQFSBaseFeedChildPresenter)
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo2 = getQCircleExtraTypeInfo();
    QCircleExtraTypeInfo localQCircleExtraTypeInfo1 = localQCircleExtraTypeInfo2;
    if (localQCircleExtraTypeInfo2 == null) {
      localQCircleExtraTypeInfo1 = d();
    }
    if (paramQFSBaseFeedChildPresenter != null) {
      paramQFSBaseFeedChildPresenter.a(localQCircleExtraTypeInfo1);
    }
  }
  
  private void b()
  {
    QFSFeedPresenterManager localQFSFeedPresenterManager = this.c;
    if (localQFSFeedPresenterManager == null) {
      return;
    }
    localQFSFeedPresenterManager.a();
  }
  
  private void b(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData != null)
    {
      if (paramFeedBlockData.b() == null) {
        return;
      }
      VideoReport.setElementId(this, "em_xsj_multimedia");
      Object localObject = new QCircleDTParamBuilder().buildElementParams();
      ((Map)localObject).putAll(QCirclePluginReportUtil.a(paramFeedBlockData));
      ((Map)localObject).put("xsj_feed_index", Integer.valueOf(paramInt + 1));
      VideoReport.setElementParams(this, (Map)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("em_xsj_multimedia");
      ((StringBuilder)localObject).append(paramFeedBlockData.b().id.get());
      VideoReport.setElementReuseIdentifier(this, ((StringBuilder)localObject).toString());
      VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
      VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
      paramFeedBlockData = new StringBuilder();
      paramFeedBlockData.append("dtReportBindItemView  pos = ");
      paramFeedBlockData.append(paramInt);
      QLog.i("QFSLayerFeedItemView", 1, paramFeedBlockData.toString());
    }
  }
  
  private void c()
  {
    if (this.e) {
      return;
    }
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.a(this.b);
      }
    }
    this.e = true;
  }
  
  private void c(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData == null) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramFeedBlockData.b();
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localQFSBaseFeedChildPresenter != null)
      {
        localQFSBaseFeedChildPresenter.a(paramFeedBlockData);
        a(localQFSBaseFeedChildPresenter);
        localQFSBaseFeedChildPresenter.a(localStFeed, paramInt);
      }
    }
  }
  
  private QCircleExtraTypeInfo d()
  {
    FeedBlockData localFeedBlockData = (FeedBlockData)getData();
    if (localFeedBlockData == null)
    {
      QLog.d("QFSLayerFeedItemView", 1, "[createExtraInfo] data should not be null.");
      return null;
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.pageType = 69;
    localQCircleExtraTypeInfo.mFeed = localFeedBlockData.b();
    localQCircleExtraTypeInfo.mPlayScene = 2;
    localQCircleExtraTypeInfo.sourceType = Integer.valueOf(getParentPageId()).intValue();
    localQCircleExtraTypeInfo.mDataPosition = getDataPosInList();
    return localQCircleExtraTypeInfo;
  }
  
  private void e()
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.c();
      }
    }
  }
  
  private void f()
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.d();
      }
    }
  }
  
  private void g()
  {
    HashMap localHashMap = getPresenterMaps();
    this.c = new QFSFeedPresenterManager();
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)localClass.newInstance();
        this.c.a(localQFSBaseFeedChildPresenter);
        localQFSBaseFeedChildPresenter.a(this.c);
        localHashMap.put(localClass, localQFSBaseFeedChildPresenter);
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    QLog.d("QFSLayerFeedItemView", 1, "fs_lifecycle onDestroy");
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.a();
      }
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.a(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  protected void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData != null)
    {
      if (paramFeedBlockData.b() == null) {
        return;
      }
      c();
      c(paramFeedBlockData, paramInt);
      b(paramFeedBlockData, paramInt);
    }
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onResumed  selectInfo = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("QFSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.a(paramQFSFeedSelectInfo);
      }
    }
  }
  
  public boolean a(QFSTouchBean paramQFSTouchBean)
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if ((localQFSBaseFeedChildPresenter != null) && (localQFSBaseFeedChildPresenter.a(paramQFSTouchBean))) {
        return true;
      }
    }
    return false;
  }
  
  public void b(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  selectInfo = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("QFSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.b(paramQFSFeedSelectInfo);
      }
    }
  }
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  selectInfo = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("QFSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.c(paramQFSFeedSelectInfo);
      }
    }
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onFeedSelected  selectInfo = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("QFSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localQFSBaseFeedChildPresenter != null)
      {
        localQFSBaseFeedChildPresenter.d(paramQFSFeedSelectInfo);
        if (localQFSBaseFeedChildPresenter.b()) {
          localQFSBaseFeedChildPresenter.j();
        }
      }
    }
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onFeedUnSelected  selectInfo = ");
    ((StringBuilder)localObject).append(paramQFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("QFSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QFSBaseFeedChildPresenter localQFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localQFSBaseFeedChildPresenter != null) {
        localQFSBaseFeedChildPresenter.e(paramQFSFeedSelectInfo);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131627134;
  }
  
  protected String getLogTag()
  {
    return null;
  }
  
  public HashMap<Class, QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>> getPresenterMaps()
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    QLog.d("QFSLayerFeedItemView", 1, "[onAttachedToWindow] current view item attached to window.");
    super.onAttachedToWindow();
    e();
  }
  
  protected void onDetachedFromWindow()
  {
    QLog.d("QFSLayerFeedItemView", 1, "[onDetachedFromWindow] current view item detached to window.");
    super.onDetachedFromWindow();
    f();
    b();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    g();
    a(paramContext, paramView);
  }
  
  public void setFeedIoc(IQFSFeedIoc paramIQFSFeedIoc)
  {
    this.b = paramIQFSFeedIoc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSLayerFeedItemView
 * JD-Core Version:    0.7.0.1
 */