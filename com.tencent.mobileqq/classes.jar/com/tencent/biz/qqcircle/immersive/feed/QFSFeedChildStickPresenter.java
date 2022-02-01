package com.tencent.biz.qqcircle.immersive.feed;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleStickShareEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView.QCircleLoadStickParam;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleStickConfig;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleStickTypeUtils;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBaseFeedPresenterEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicScaleChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicStickChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTapClickEvent;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeMapUtils;
import com.tencent.biz.qqcircle.immersive.utils.QFSShareInfoUtils;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.pick.VerticalGallery.LayoutParams;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QFSFeedChildStickPresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements SimpleEventReceiver
{
  private QCircleExpandStickView i;
  private ViewStub j;
  private ViewGroup k;
  private View l;
  private final Map<Integer, QFSPicStickChangeEvent> m = new HashMap();
  private int n = -1;
  
  private FeedBlockData a(FeedCloudMeta.StFeed paramStFeed)
  {
    return new FeedBlockData(paramStFeed);
  }
  
  private QCircleStickConfig a(FeedBlockData paramFeedBlockData, int paramInt, Rect paramRect1, Rect paramRect2, ImageView.ScaleType paramScaleType)
  {
    if (this.c == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[createStickConfig] data should not be null.");
      return null;
    }
    if (paramRect2 == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[createStickConfig] display rect should not be null.");
      return null;
    }
    return QCircleStickConfig.a().a(paramRect1.width()).b(paramRect1.height()).c(paramRect2.width()).d(paramRect2.height()).a(paramFeedBlockData).e(paramInt).a(p()).a(paramScaleType);
  }
  
  private void a(float paramFloat)
  {
    QCircleExpandStickView localQCircleExpandStickView = this.i;
    boolean bool = true;
    if (localQCircleExpandStickView == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[updateScaleValue] expand stick view not is null.");
      return;
    }
    if ((paramFloat >= 1.1F) || (paramFloat <= 0.9F)) {
      bool = false;
    }
    localQCircleExpandStickView.a(bool);
  }
  
  private void a(int paramInt)
  {
    if (paramInt != this.n)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[attemptLoadPicStickConfig] picPosition(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") != currentPos(");
      ((StringBuilder)localObject1).append(this.n);
      ((StringBuilder)localObject1).append(")");
      QLog.d("Stick-QCircleExpandStickLayout", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (!QCircleStickTypeUtils.a((FeedCloudMeta.StFeed)this.c, paramInt, p()))
    {
      n();
      return;
    }
    Object localObject2 = (QFSPicStickChangeEvent)QFSSafeMapUtils.a(this.m, Integer.valueOf(paramInt));
    if (localObject2 == null)
    {
      n();
      return;
    }
    Object localObject1 = ((QFSPicStickChangeEvent)localObject2).c();
    localObject2 = ((QFSPicStickChangeEvent)localObject2).d();
    a(a(a((FeedCloudMeta.StFeed)this.c), this.n, (Rect)localObject1, (Rect)localObject2, ImageView.ScaleType.FIT_CENTER));
    QLog.d("Stick-QCircleExpandStickLayout", 1, new Object[] { "[attemptLoadPicStickConfig] config pic position: ", Integer.valueOf(paramInt) });
  }
  
  private void a(Point paramPoint)
  {
    QCircleExpandStickView localQCircleExpandStickView = this.i;
    if (localQCircleExpandStickView == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[handleClickPoint] expand stick view not is null.");
      return;
    }
    localQCircleExpandStickView.a(paramPoint);
  }
  
  private void a(@NonNull QCircleStickShareEvent paramQCircleStickShareEvent)
  {
    if (!TextUtils.equals(paramQCircleStickShareEvent.mFeedId, o())) {
      return;
    }
    if (this.a == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[openSharePanel] feed ioc should not be null.");
      return;
    }
    paramQCircleStickShareEvent = QFSShareInfoUtils.a((FeedCloudMeta.StFeed)this.c);
    paramQCircleStickShareEvent.a = this.h;
    paramQCircleStickShareEvent.c.mDataPosition = this.d;
    paramQCircleStickShareEvent.b = ((FeedCloudMeta.StFeed)this.c);
    paramQCircleStickShareEvent.r = i();
    if ((i() != null) && ("pg_ks_explore_page".equals(String.valueOf(i().getPageId())))) {
      paramQCircleStickShareEvent.l = true;
    }
    this.a.a("event_open_share", new Object[] { paramQCircleStickShareEvent });
  }
  
  private void a(@NonNull QFSPicPositionChangeEvent paramQFSPicPositionChangeEvent)
  {
    String str = o();
    if (!TextUtils.equals(paramQFSPicPositionChangeEvent.a(), str)) {
      return;
    }
    if (this.n == paramQFSPicPositionChangeEvent.b()) {
      return;
    }
    this.n = paramQFSPicPositionChangeEvent.b();
    QLog.d("Stick-QCircleExpandStickLayout", 1, new Object[] { "[handlePicPositionChangeEvent] change pic position: ", Integer.valueOf(this.n) });
    a(this.n);
  }
  
  private void a(QFSPicScaleChangeEvent paramQFSPicScaleChangeEvent)
  {
    if (!TextUtils.equals(paramQFSPicScaleChangeEvent.b(), o())) {
      return;
    }
    a(paramQFSPicScaleChangeEvent.a());
  }
  
  private void a(@NonNull QFSPicStickChangeEvent paramQFSPicStickChangeEvent)
  {
    Object localObject = o();
    String str = paramQFSPicStickChangeEvent.a();
    int i1 = paramQFSPicStickChangeEvent.b();
    if (!TextUtils.equals(str, (CharSequence)localObject)) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handlePicStickChangeEvent] handle pic stick, position: ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" | feed id: ");
    ((StringBuilder)localObject).append(str);
    QLog.d("Stick-QCircleExpandStickLayout", 1, ((StringBuilder)localObject).toString());
    this.m.put(Integer.valueOf(i1), paramQFSPicStickChangeEvent);
    a(i1);
  }
  
  private void a(QFSTapClickEvent paramQFSTapClickEvent)
  {
    if (paramQFSTapClickEvent == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[handleTapClickEvent] event should not be null.");
      return;
    }
    if (!a(paramQFSTapClickEvent.a()))
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[handleTapClickEvent] current feed data not same.");
      return;
    }
    paramQFSTapClickEvent = paramQFSTapClickEvent.b();
    a(new Point((int)paramQFSTapClickEvent.getX(), (int)paramQFSTapClickEvent.getY()));
  }
  
  private boolean a(String paramString)
  {
    if (this.c == null) {
      return false;
    }
    return TextUtils.equals(paramString, ((FeedCloudMeta.StFeed)this.c).id.get());
  }
  
  private void b(@NonNull QCircleStickConfig paramQCircleStickConfig)
  {
    if (this.l == null) {
      this.l = this.j.inflate();
    }
    if (this.i == null)
    {
      this.k = ((ViewGroup)this.l.findViewById(2131441959));
      this.i = new QCircleExpandStickView(this.f.getContext());
      this.k.addView(this.i, new VerticalGallery.LayoutParams(-1, -1));
    }
  }
  
  private void c(@NonNull QCircleStickConfig paramQCircleStickConfig)
  {
    if (this.i == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[updateStickConfig] expand stick view not is null.");
      return;
    }
    int i1 = paramQCircleStickConfig.b();
    int i2 = paramQCircleStickConfig.c();
    int i3 = paramQCircleStickConfig.d();
    int i4 = paramQCircleStickConfig.e();
    QLog.d("Stick-QCircleExpandStickLayout", 1, new Object[] { "[updateStickConfig] containerWidth: ", Integer.valueOf(i3), " | containerHeight: ", Integer.valueOf(i4), " | displayWidth: ", Integer.valueOf(i3), " | displayHeight: ", Integer.valueOf(i4), " | feed id: ", o() });
    Rect localRect1 = new Rect(0, 0, i1, i2);
    Rect localRect2 = new Rect(0, 0, i3, i4);
    Rect localRect3 = new Rect(0, 0, i1, i2);
    this.i.a(QCircleExpandStickView.QCircleLoadStickParam.a().a(paramQCircleStickConfig.g()).a(localRect1).b(localRect2).c(localRect3).a(paramQCircleStickConfig.h()).a(paramQCircleStickConfig.i()).a(paramQCircleStickConfig.f()).b(true));
  }
  
  private void k()
  {
    if (this.c == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[loadStickData] data should not be null.");
      return;
    }
    if (p())
    {
      n();
      return;
    }
    l();
  }
  
  private void l()
  {
    if (!QCircleStickTypeUtils.a((FeedCloudMeta.StFeed)this.c, this.n, p()))
    {
      n();
      return;
    }
    m();
    FeedBlockData localFeedBlockData = a((FeedCloudMeta.StFeed)this.c);
    int i1 = ((FeedCloudMeta.StFeed)this.c).cover.height.get();
    int i2 = ((FeedCloudMeta.StFeed)this.c).cover.width.get();
    int i3 = ImmersiveUtils.b();
    Rect localRect = new Rect(0, 0, i3, (int)(i3 / i2 * i1));
    a(a(localFeedBlockData, 0, new Rect(0, 0, ViewUtils.b(), ViewUtils.c() - ViewUtils.a()), localRect, ImageView.ScaleType.FIT_CENTER));
  }
  
  private void m()
  {
    this.m.clear();
    this.n = 0;
  }
  
  private void n()
  {
    this.i = null;
    ViewGroup localViewGroup = this.k;
    if (localViewGroup != null)
    {
      localViewGroup.removeAllViews();
      this.k = null;
    }
  }
  
  private String o()
  {
    if (this.c == null) {
      return "";
    }
    return ((FeedCloudMeta.StFeed)this.c).id.get();
  }
  
  private boolean p()
  {
    return q() == 2;
  }
  
  private int q()
  {
    if (this.c != null) {
      return ((FeedCloudMeta.StFeed)this.c).type.get();
    }
    return 0;
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.j = ((ViewStub)paramView.findViewById(2131441960));
  }
  
  public void a(QCircleStickConfig paramQCircleStickConfig)
  {
    if (paramQCircleStickConfig == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[loadStickConfig] config should not be null.");
      return;
    }
    n();
    b(paramQCircleStickConfig);
    c(paramQCircleStickConfig);
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.a(paramQFSFeedSelectInfo);
    QLog.d("Stick-QCircleExpandStickLayout", 1, new Object[] { "[onResumed] feed id: ", o(), " resume." });
    k();
  }
  
  protected void a(QFSBaseFeedPresenterEvent paramQFSBaseFeedPresenterEvent)
  {
    super.a(paramQFSBaseFeedPresenterEvent);
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSTapClickEvent))
    {
      a((QFSTapClickEvent)paramQFSBaseFeedPresenterEvent);
      return;
    }
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSPicStickChangeEvent))
    {
      a((QFSPicStickChangeEvent)paramQFSBaseFeedPresenterEvent);
      return;
    }
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSPicPositionChangeEvent))
    {
      a((QFSPicPositionChangeEvent)paramQFSBaseFeedPresenterEvent);
      return;
    }
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSPicScaleChangeEvent)) {
      a((QFSPicScaleChangeEvent)paramQFSBaseFeedPresenterEvent);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    m();
  }
  
  public void c()
  {
    super.c();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void d()
  {
    super.d();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.d(paramQFSFeedSelectInfo);
    QLog.d("Stick-QCircleExpandStickLayout", 1, new Object[] { "[onFeedSelected] feed id: ", o(), " selected, picPos: ", Integer.valueOf(this.n) });
    k();
  }
  
  public ArrayList getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleStickShareEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleStickShareEvent)) {
      a((QCircleStickShareEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildStickPresenter
 * JD-Core Version:    0.7.0.1
 */