package com.tencent.biz.qqcircle.scrollers;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCircleClientInfoUtils;
import com.tencent.biz.qqcircle.utils.QCircleThreadManager;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleLpReportDc05502.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QCircleFeedReportScroller
  extends QCircleFeedBaseScroller
{
  private final QCircleReportBean g;
  private final HashMap<Integer, QCircleFeedReportScroller.FeedReportBean> h = new HashMap();
  private final HashMap<Integer, QCircleFeedReportScroller.FeedReportBean> i = new HashMap();
  private final HashMap<Integer, QCircleFeedReportScroller.FeedReportBean> j = new HashMap();
  private final ArrayList<QCircleFeedReportScroller.OnFeedScrollerListener> k = new ArrayList();
  private final int l;
  private boolean m = false;
  
  public QCircleFeedReportScroller(int paramInt, QCircleReportBean paramQCircleReportBean)
  {
    this.l = paramInt;
    this.g = paramQCircleReportBean;
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof BaseWidgetView))
    {
      FeedCloudMeta.StFeed localStFeed = e(paramView);
      if (localStFeed != null)
      {
        Object localObject = QCirclePluginUtil.d(paramView.getContext());
        byte[] arrayOfByte = null;
        String str;
        if (localObject != null)
        {
          str = ((FeedCloudMeta.StFeed)localObject).id.get();
          paramView = str;
          if (((FeedCloudMeta.StFeed)localObject).busiReport.has())
          {
            arrayOfByte = ((FeedCloudMeta.StFeed)localObject).busiReport.get().toByteArray();
            paramView = str;
          }
        }
        else
        {
          paramView = "";
        }
        localObject = new QCircleLpReportDc05504.DataBuilder().setToUin(localStFeed.poster.id.get()).setActionType(11).setSubActionType(19).setThrActionType(paramInt);
        if (QCirclePluginUtil.d(localStFeed.poster.id.get())) {
          str = "1";
        } else {
          str = "2";
        }
        QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt1(str).setExt2(localStFeed.id.get()).setExt9(paramView).setFeedReportInfo(arrayOfByte).setPageId(this.l));
      }
    }
  }
  
  private void a(View paramView, String paramString, boolean paramBoolean)
  {
    if (!d(paramView)) {
      return;
    }
    if ((paramBoolean) && (!g(paramView))) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = e(paramView);
    int n = f(paramView);
    if (localStFeed == null)
    {
      paramView = new StringBuilder();
      paramView.append("asyncReportFeedExpose no feed data!from ");
      paramView.append(paramString);
      paramView.append(",index:");
      paramView.append(n);
      paramView.append(",pageId:");
      paramView.append(this.l);
      QLog.e("QCircleFeedReportHelper", 1, paramView.toString());
      return;
    }
    QCircleThreadManager.a().a(new QCircleFeedReportScroller.1(this, paramBoolean, paramView, localStFeed, n, paramString));
  }
  
  private void a(QCircleFeedReportScroller.FeedReportBean paramFeedReportBean)
  {
    if (paramFeedReportBean != null)
    {
      FeedCloudMeta.StFeed localStFeed = QCircleFeedReportScroller.FeedReportBean.a(paramFeedReportBean);
      paramFeedReportBean.a(System.currentTimeMillis());
      QCircleLpReportDc05502.report(new QCircleLpReportDc05502.DataBuilder(QCirclePluginReportUtil.c(localStFeed).setToUin(localStFeed.poster.id.get()).setBeginTime(paramFeedReportBean.c()).setEndTime(paramFeedReportBean.d()).setStayTime(paramFeedReportBean.e()).setIndex(paramFeedReportBean.f()).setExt1("1").setPageId(this.l)));
    }
  }
  
  private void a(QCircleBaseWidgetView paramQCircleBaseWidgetView)
  {
    if (paramQCircleBaseWidgetView == null) {
      return;
    }
    VideoReport.setElementId(paramQCircleBaseWidgetView, "em_xsj_feed");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("em_xsj_feed_");
    localStringBuilder.append(paramQCircleBaseWidgetView.getData().hashCode());
    VideoReport.setElementReuseIdentifier(paramQCircleBaseWidgetView, localStringBuilder.toString());
    VideoReport.setElementParams(paramQCircleBaseWidgetView, b(paramQCircleBaseWidgetView));
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, boolean paramBoolean)
  {
    if (paramStFeed != null)
    {
      b(paramStFeed, paramInt, paramBoolean);
      int n = this.l;
      String str2 = "";
      String str1;
      if ((n != 71) && (n != 72) && (n != 73)) {
        str1 = "";
      } else {
        str1 = String.valueOf(this.d.title);
      }
      n = this.l;
      if ((n == 691) || (n == 831) || (n == 851)) {
        str2 = QCircleClientInfoUtils.a(paramStFeed);
      }
      paramStFeed = QCirclePluginReportUtil.b(paramStFeed).setToUin(paramStFeed.poster.id.get());
      if (paramBoolean) {
        n = 2;
      } else {
        n = 1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramStFeed.setActionType(n).setSubActionType(1).setIndex(paramInt).setExt2(str1).setExt6(str2).setPageId(this.l)));
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scanValidExposeWhenRefreshOrResume,baseExposePool size:");
    ((StringBuilder)localObject).append(this.i.size());
    ((StringBuilder)localObject).append(",validExposePool size:");
    ((StringBuilder)localObject).append(this.j.size());
    QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject).toString());
    localObject = this.i.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QCircleFeedReportScroller.FeedReportBean localFeedReportBean = (QCircleFeedReportScroller.FeedReportBean)((Iterator)localObject).next();
      if (localFeedReportBean != null)
      {
        if (localFeedReportBean.a() != null)
        {
          localFeedReportBean.a().setTag(2131446778, Boolean.valueOf(false));
          a(localFeedReportBean.a(), paramString, false);
        }
        b(localFeedReportBean);
        if ((h(localFeedReportBean.a())) && (localFeedReportBean.g() != null))
        {
          localFeedReportBean.b();
          this.h.put(Integer.valueOf(localFeedReportBean.f()), localFeedReportBean);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("record feed stay event from ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",index:");
          localStringBuilder.append(localFeedReportBean.f());
          localStringBuilder.append(",feedId:");
          localStringBuilder.append(localFeedReportBean.g().id.get());
          localStringBuilder.append(",pageId:");
          localStringBuilder.append(this.l);
          QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
          a(localFeedReportBean.a(), paramString, true);
        }
      }
    }
  }
  
  private boolean a(Integer paramInteger, QCircleFeedReportScroller.FeedReportBean paramFeedReportBean)
  {
    if (!this.h.containsValue(paramFeedReportBean))
    {
      paramFeedReportBean.b();
      this.h.put(paramInteger, paramFeedReportBean);
      return true;
    }
    return false;
  }
  
  private Map<String, Object> b(QCircleBaseWidgetView paramQCircleBaseWidgetView)
  {
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    if ((paramQCircleBaseWidgetView != null) && ((paramQCircleBaseWidgetView.getData() instanceof FeedBlockData)))
    {
      if (((FeedBlockData)paramQCircleBaseWidgetView.getData()).b() == null) {
        return localMap;
      }
      localMap.putAll(QCirclePluginReportUtil.a((FeedBlockData)paramQCircleBaseWidgetView.getData()));
      localMap.put("xsj_feed_index", Integer.valueOf(paramQCircleBaseWidgetView.getDataPosInList() + 1));
    }
    return localMap;
  }
  
  private void b(QCircleFeedReportScroller.FeedReportBean paramFeedReportBean)
  {
    if ((paramFeedReportBean != null) && ((paramFeedReportBean.a() instanceof QCircleBaseWidgetView)))
    {
      QCircleBaseWidgetView localQCircleBaseWidgetView = (QCircleBaseWidgetView)paramFeedReportBean.a();
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)localQCircleBaseWidgetView.getData()).b();
      String str = localStFeed.id.get();
      paramFeedReportBean.a(localStFeed);
      paramFeedReportBean = new StringBuilder();
      paramFeedReportBean.append("refreshBeanData,index:");
      paramFeedReportBean.append(localQCircleBaseWidgetView.getDataPosInList());
      paramFeedReportBean.append(",feedId:");
      paramFeedReportBean.append(str);
      paramFeedReportBean.append(",pageId:");
      paramFeedReportBean.append(this.l);
      QLog.d("QCircleFeedReportHelper", 4, paramFeedReportBean.toString());
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    int n = paramStFeed.type.get();
    String str2 = "";
    Object localObject1;
    String str1;
    if ((n == 2) && (paramStFeed.images.size() > 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((FeedCloudMeta.StImage)paramStFeed.images.get(0)).picId.get());
      ((StringBuilder)localObject1).append("");
      str1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      str1 = "";
    }
    Object localObject2;
    if (paramStFeed.type.get() == 2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramStFeed.images.size());
      ((StringBuilder)localObject1).append("");
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = "1";
      str2 = "0";
    }
    else if (paramStFeed.type.get() == 3)
    {
      localObject1 = "2";
      localObject2 = "";
    }
    else
    {
      localObject1 = "";
      localObject2 = localObject1;
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramStFeed)).setActionType(1).setSubActionType(1).setToUin(paramStFeed.poster.id.get()).setPosition(paramInt).setPlayScene(1).setLloc(str1).setExt1((String)localObject1).setExt2(str2).setExt3((String)localObject2).setPageId(this.l));
  }
  
  private void b(String paramString)
  {
    Object localObject = this.j.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QCircleFeedReportScroller.FeedReportBean localFeedReportBean = (QCircleFeedReportScroller.FeedReportBean)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localFeedReportBean != null)
      {
        a(QCircleFeedReportScroller.FeedReportBean.b(localFeedReportBean), paramString, true);
        ((Iterator)localObject).remove();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("flushValidExposeReport by ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",retain size:");
    ((StringBuilder)localObject).append(this.j.size());
    QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject).toString());
  }
  
  private void c(View paramView)
  {
    FeedCloudMeta.StFeed localStFeed = e(paramView);
    if (localStFeed == null) {
      return;
    }
    int n = f(paramView);
    String str = localStFeed.id.get();
    if (!this.h.containsKey(Integer.valueOf(n)))
    {
      QCircleFeedReportScroller.FeedReportBean localFeedReportBean = new QCircleFeedReportScroller.FeedReportBean();
      localFeedReportBean.b();
      localFeedReportBean.a(paramView);
      localFeedReportBean.a(n);
      localFeedReportBean.a(localStFeed);
      this.h.put(Integer.valueOf(n), localFeedReportBean);
      paramView = new StringBuilder();
      paramView.append("record feed stay event from idle,index:");
      paramView.append(n);
      paramView.append(",feedId:");
      paramView.append(str);
      paramView.append(",pageId:");
      paramView.append(this.l);
      QLog.d("QCircleFeedReportHelper", 4, paramView.toString());
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.itemView.setTag(2131446778, Boolean.valueOf(false));
    paramViewHolder = (QCircleBaseWidgetView)paramViewHolder.itemView;
    FeedCloudMeta.StFeed localStFeed = e(paramViewHolder);
    int n = f(paramViewHolder);
    if (localStFeed != null)
    {
      Object localObject = new QCircleFeedReportScroller.FeedReportBean();
      ((QCircleFeedReportScroller.FeedReportBean)localObject).a(paramViewHolder);
      ((QCircleFeedReportScroller.FeedReportBean)localObject).a(n);
      ((QCircleFeedReportScroller.FeedReportBean)localObject).a(localStFeed);
      this.i.put(Integer.valueOf(n), localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add baseExposePool from attach,index:");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(",feedId:");
      ((StringBuilder)localObject).append(localStFeed.id.get());
      ((StringBuilder)localObject).append(",pageId:");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject).toString());
      a(paramViewHolder);
    }
  }
  
  private void c(String paramString)
  {
    Object localObject = this.h.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QCircleFeedReportScroller.FeedReportBean localFeedReportBean = (QCircleFeedReportScroller.FeedReportBean)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localFeedReportBean != null)
      {
        a(localFeedReportBean);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report feed stay event from flush by ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",index:");
        localStringBuilder.append(localFeedReportBean.f());
        localStringBuilder.append(",feedId:");
        localStringBuilder.append(localFeedReportBean.g().id.get());
        localStringBuilder.append(",pageId:");
        localStringBuilder.append(this.l);
        localStringBuilder.append(",stayTime:");
        localStringBuilder.append(localFeedReportBean.e());
        localStringBuilder.append("ms");
        QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
      }
      ((Iterator)localObject).remove();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("flushStayEventReport by ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",retain size:");
    ((StringBuilder)localObject).append(this.h.size());
    QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject).toString());
  }
  
  private FeedCloudMeta.StFeed d(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null) {
      return e(paramViewHolder.itemView);
    }
    return null;
  }
  
  private boolean d(View paramView)
  {
    return ((paramView instanceof QCircleInsFeedItemView)) || ((paramView instanceof QCircleWaterfallFeedItemView)) || ((paramView instanceof QCircleGridFeedItemView)) || ((paramView instanceof QCircleTimeLineFeedItemView));
  }
  
  private FeedCloudMeta.StFeed e(View paramView)
  {
    if (!(paramView instanceof BaseWidgetView)) {
      return null;
    }
    paramView = (BaseWidgetView)paramView;
    if ((paramView.getData() instanceof FeedBlockData)) {
      return ((FeedBlockData)paramView.getData()).b();
    }
    return null;
  }
  
  private int f(View paramView)
  {
    if (!(paramView instanceof BaseWidgetView)) {
      return 0;
    }
    return ((BaseWidgetView)paramView).getDataPosInList();
  }
  
  private void g()
  {
    Iterator localIterator = this.i.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int n = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = (QCircleFeedReportScroller.FeedReportBean)((Map.Entry)localObject).getValue();
      if ((!this.j.containsKey(Integer.valueOf(n))) && (h(((QCircleFeedReportScroller.FeedReportBean)localObject).a())) && (((QCircleFeedReportScroller.FeedReportBean)localObject).g() != null))
      {
        this.j.put(Integer.valueOf(n), localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add validExposePool from scroll,index:");
        localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject).f());
        localStringBuilder.append(",feedId:");
        localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject).g().id.get());
        localStringBuilder.append(",pageId:");
        localStringBuilder.append(this.l);
        QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
        if (a(Integer.valueOf(n), (QCircleFeedReportScroller.FeedReportBean)localObject))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("record feed stay event from scroll,index:");
          localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject).f());
          localStringBuilder.append(",feedId:");
          localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject).g().id.get());
          localStringBuilder.append(",pageId:");
          localStringBuilder.append(this.l);
          QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
        }
      }
    }
  }
  
  private boolean g(View paramView)
  {
    if (paramView != null)
    {
      boolean bool = ((Boolean)paramView.getTag(2131446778)).booleanValue() ^ true;
      if (bool) {
        paramView.setTag(2131446778, Boolean.valueOf(true));
      }
      return bool;
    }
    return false;
  }
  
  private boolean h(View paramView)
  {
    if (paramView != null)
    {
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      int i1 = paramView.getHeight();
      int n;
      if (localRect.bottom > 0) {
        n = localRect.bottom - localRect.top;
      } else {
        n = 0;
      }
      float f = n / i1;
      if (f >= 0.5D)
      {
        if (Float.isNaN(f)) {
          return false;
        }
        return (!(paramView instanceof QCircleWaterfallFeedItemView)) || (f >= 1.0F);
      }
    }
    return false;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageUnSelected,pageId:");
    localStringBuilder.append(this.l);
    QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
    c();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",pageId:");
    localStringBuilder.append(this.l);
    QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
    b();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!d(paramViewHolder.itemView)) {
      return;
    }
    c(paramViewHolder);
    if (this.m) {
      a(paramViewHolder.itemView, "onAttach", false);
    }
    if ((paramViewHolder.itemView instanceof QCircleGridFeedItemView))
    {
      a(paramViewHolder.itemView, 4);
      return;
    }
    if ((paramViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) {
      a(paramViewHolder.itemView, 1);
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!this.m) {
      return;
    }
    g();
    if (this.k.size() > 0)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext()) {
        ((QCircleFeedReportScroller.OnFeedScrollerListener)localIterator.next()).a(paramRecyclerView, paramInt1, paramInt2, paramBoolean);
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (!this.m) {
      return;
    }
    if (paramInt1 == 0) {
      if (paramInt2 > paramInt3) {}
    }
    for (;;)
    {
      if (paramInt2 <= paramInt3) {}
      try
      {
        paramRecyclerView = paramLayoutManager.findViewByPosition(paramInt2);
        if ((!d(paramRecyclerView)) || (!h(paramRecyclerView))) {
          break label84;
        }
        c(paramRecyclerView);
        a(paramRecyclerView, "onIdle", true);
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
      VideoReport.traverseExposure();
      QCircleFolderCacheHelper.a().c();
      return;
      label84:
      paramInt2 += 1;
    }
  }
  
  public void a(QCircleFeedReportScroller.OnFeedScrollerListener paramOnFeedScrollerListener)
  {
    this.k.add(paramOnFeedScrollerListener);
  }
  
  public void b()
  {
    this.m = f();
    Object localObject;
    if (this.m)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume");
      ((StringBuilder)localObject).append(",pageId:");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject).toString());
      a("onResume");
      b("onResume");
    }
    if (this.k.size() > 0)
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QCircleFeedReportScroller.OnFeedScrollerListener)((Iterator)localObject).next()).c();
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!d(paramViewHolder.itemView)) {
      return;
    }
    Object localObject1 = d(paramViewHolder);
    int n = f(paramViewHolder.itemView);
    if (localObject1 == null)
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("onViewDetachedFromWindow holder miss feed data!pageId:");
      paramViewHolder.append(this.l);
      QLog.e("QCircleFeedReportHelper", 1, paramViewHolder.toString());
      return;
    }
    localObject1 = ((FeedCloudMeta.StFeed)localObject1).id.get();
    Object localObject2;
    if (this.i.containsKey(Integer.valueOf(n)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("remove baseExposePool from detach,index:");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(",feedId:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",pageId:");
      ((StringBuilder)localObject2).append(this.l);
      QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject2).toString());
      this.i.remove(Integer.valueOf(n));
    }
    if (this.h.containsKey(Integer.valueOf(n)))
    {
      localObject2 = (QCircleFeedReportScroller.FeedReportBean)this.h.get(Integer.valueOf(n));
      if (localObject2 != null)
      {
        a((QCircleFeedReportScroller.FeedReportBean)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report feed stay event from detach,index:");
        localStringBuilder.append(n);
        localStringBuilder.append(",feedId:");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(",pageId:");
        localStringBuilder.append(this.l);
        localStringBuilder.append(",stayTime:");
        localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject2).e());
        localStringBuilder.append("ms");
        QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
      }
      this.h.remove(Integer.valueOf(n));
    }
    if (this.j.containsKey(Integer.valueOf(n)))
    {
      a(paramViewHolder.itemView, "onDetach", true);
      this.j.remove(Integer.valueOf(n));
    }
  }
  
  public void b(QCircleFeedReportScroller.OnFeedScrollerListener paramOnFeedScrollerListener)
  {
    this.k.remove(paramOnFeedScrollerListener);
  }
  
  public void c()
  {
    Object localObject;
    if (this.m)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause");
      ((StringBuilder)localObject).append(",pageId:");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("QCircleFeedReportHelper", 4, ((StringBuilder)localObject).toString());
      b("onPause");
      c("onPause");
    }
    this.m = f();
    if (this.k.size() > 0)
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QCircleFeedReportScroller.OnFeedScrollerListener)((Iterator)localObject).next()).b();
      }
    }
  }
  
  public void d()
  {
    this.m = f();
    if ((this.m) && (this.i.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRefresh,pageId:");
      localStringBuilder.append(this.l);
      QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
      c("onRefresh");
      b("onRefresh");
      RFThreadManager.getUIHandler().postDelayed(new QCircleFeedReportScroller.2(this), 100L);
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localObject != null)
      {
        localObject = (QCircleFeedReportScroller.FeedReportBean)this.h.get(localObject);
        if (localObject != null)
        {
          a((QCircleFeedReportScroller.FeedReportBean)localObject);
          if (((QCircleFeedReportScroller.FeedReportBean)localObject).g() != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("report feed stay event from destory,index:");
            localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject).f());
            localStringBuilder.append(",feedId:");
            localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject).g().id.get());
            localStringBuilder.append(",pageId:");
            localStringBuilder.append(this.l);
            localStringBuilder.append(",stayTime:");
            localStringBuilder.append(((QCircleFeedReportScroller.FeedReportBean)localObject).e());
            localStringBuilder.append("ms");
            QLog.d("QCircleFeedReportHelper", 4, localStringBuilder.toString());
          }
        }
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller
 * JD-Core Version:    0.7.0.1
 */