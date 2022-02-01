package com.tencent.biz.qqcircle.fragments.content.stick;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleFeedViewExportEvent;
import com.tencent.biz.qqcircle.events.QCircleStickShareEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCircleStickHideManager;
import com.tencent.biz.qqcircle.manager.QCircleStickHideManager.OnStickHideListener;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCircleStickUtils;
import com.tencent.biz.qqcircle.utils.QCircleStickUtils.QCircleStickDisplayParam;
import com.tencent.biz.qqcircle.utils.QCircleStickUtils.StickArea;
import com.tencent.biz.qqcircle.utils.QCircleStickUtils.StickAreaConfig;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;

public class QCircleExpandStickView
  extends QCircleBaseWidgetView<FeedBlockData>
  implements View.OnTouchListener, QCircleStickHideManager.OnStickHideListener, SimpleEventReceiver, IQQFrontBackListener
{
  private FeedBlockData a;
  private QCircleGuideBubbleView b;
  private QCircleGuideBubbleView c;
  private View d;
  private View e;
  private QQCircleFeedBase.StKuoliePasterData f;
  private QCircleStickUtils.StickAreaConfig g;
  private boolean h = true;
  private QCircleExpandStickView.QCircleLoadStickParam i;
  private boolean j = false;
  private boolean k = false;
  private QCircleExpandStickView.GuideBubbleViewRunnable l;
  
  public QCircleExpandStickView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleExpandStickView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(Rect paramRect)
  {
    int m = 0;
    if (paramRect == null) {
      return 0;
    }
    if (paramRect.height() > 0) {
      m = paramRect.height() / 2;
    }
    return m;
  }
  
  private Rect a(QCircleStickUtils.StickArea paramStickArea)
  {
    Point localPoint1 = paramStickArea.c;
    Point localPoint2 = paramStickArea.f;
    paramStickArea = paramStickArea.d;
    return new Rect(0, 0, Math.abs(localPoint2.x - localPoint1.x), Math.abs(paramStickArea.y - localPoint1.y));
  }
  
  private SpannableString a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    SpannableString localSpannableString = new SpannableString(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        int m = getContext().getResources().getColor(2131167033);
        int n = paramString1.indexOf(paramString2);
        localSpannableString.setSpan(new ForegroundColorSpan(m), n, paramString2.length() + n, 33);
        return localSpannableString;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        QLog.e("Stick-QCircleExpandStickView", 1, paramString1, new Object[0]);
      }
    }
    return localSpannableString;
  }
  
  private QQCircleFeedBase.StKuoliePasterData a(FeedBlockData paramFeedBlockData, int paramInt, boolean paramBoolean)
  {
    if (paramFeedBlockData == null) {
      paramFeedBlockData = null;
    } else {
      paramFeedBlockData = paramFeedBlockData.b();
    }
    return QCircleStickTypeUtils.b(paramFeedBlockData, paramInt, paramBoolean);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((FeedBlockData)localObject1).b();
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.f;
    if (localObject2 == null) {
      return;
    }
    localObject2 = ((QQCircleFeedBase.StKuoliePasterData)localObject2).kuolie_id.get();
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject1)).setActionType(paramInt1).setSubActionType(paramInt2).setExt2((String)localObject2).setToUin(((FeedCloudMeta.StFeed)localObject1).poster.id.get()).setPageId(getPageId()));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.f = a(this.a, paramInt, paramBoolean);
  }
  
  private void a(Context paramContext, QCircleGuideBubbleView paramQCircleGuideBubbleView, FeedCloudMeta.StFeed paramStFeed)
  {
    int m = 1;
    if (paramContext == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[handleStickClick] context not is null.");
      return;
    }
    if (paramStFeed == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[handleStickClick] current feed is null.");
      return;
    }
    if (paramQCircleGuideBubbleView == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[handleStickClick] click bubble is null.");
      return;
    }
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[handleStickClick] feed id: ", paramStFeed.id.get(), " | mIsTouchStickVisible: ", Boolean.valueOf(this.j), " | visible: ", Integer.valueOf(paramQCircleGuideBubbleView.getVisibility()) });
    if (QCirclePluginUtil.d(paramStFeed))
    {
      if (paramQCircleGuideBubbleView.getVisibility() != 0) {
        m = 0;
      }
      if ((!this.j) && (m == 0))
      {
        a(paramQCircleGuideBubbleView, paramStFeed);
      }
      else
      {
        a(paramStFeed, paramQCircleGuideBubbleView);
        this.j = false;
      }
    }
    else
    {
      a(paramContext, paramStFeed);
    }
    if (k())
    {
      b(118, 2);
      return;
    }
    a(118, 2);
  }
  
  private void a(Context paramContext, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.poster != null))
    {
      b();
      Object localObject = this.f;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((QQCircleFeedBase.StKuoliePasterData)localObject).trans_info.get().toByteArray();
      }
      try
      {
        QLog.d("Stick-QCircleExpandStickView", 1, "[callToAddFriend] start call to friend.");
        if (localObject == null)
        {
          QCircleHostLauncher.startAddFriend(paramContext, paramStFeed.poster.id.get(), paramStFeed.poster.nick.get(), QCirclePluginUtil.c((FeedCloudMeta.StUser)paramStFeed.poster.get()), true);
          return;
        }
        QCircleHostLauncher.startAddFriend(paramContext, paramStFeed.poster.id.get(), paramStFeed.poster.nick.get(), QCirclePluginUtil.c((FeedCloudMeta.StUser)paramStFeed.poster.get()), true, (byte[])localObject);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("Stick-QCircleExpandStickView", 1, "[callToAddFriend] error: ", paramContext);
        return;
      }
    }
    QLog.w("Stick-QCircleExpandStickView", 1, "[callToAddFriend] feed or feed poster is null.");
  }
  
  private void a(Point paramPoint, FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.c == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[showGuideBubble] current guide not view.");
      return;
    }
    if (QCirclePluginUtil.d(paramStFeed)) {
      return;
    }
    boolean bool2 = false;
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[showGuideBubble] feedId: ", d(), " | isExportFeed: ", Boolean.valueOf(this.k), " | hash code: ", Integer.valueOf(hashCode()) });
    if (!this.k) {
      return;
    }
    if (this.c.getVisibility() == 0)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[showGuideBubble] current guide bubble is visible, not show.");
      return;
    }
    boolean bool1;
    if (k()) {
      bool1 = QCircleConfig.getInstance().checkNeedShowDetailKuolieStickGuideBubble();
    } else {
      bool1 = QCircleConfig.getInstance().checkNeedShowKuolieStickGuideBubble();
    }
    if (bool1)
    {
      Object localObject1 = QCircleApplication.APP.getResources().getString(2131895772);
      Object localObject2 = this.f.content.get();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localObject2;
      }
      this.c.setAutoClose(true);
      this.c.setText((String)localObject1);
      this.c.setShowDuration(6000);
      this.c.setOnClickListener(new QCircleExpandStickView.2(this, paramStFeed));
      localObject1 = this.g;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((QCircleStickUtils.StickAreaConfig)localObject1).a();
      }
      Rect localRect = getStickRect();
      int m = a(localRect);
      localObject2 = this.i;
      bool1 = bool2;
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (QCircleExpandStickView.QCircleLoadStickParam.d((QCircleExpandStickView.QCircleLoadStickParam)localObject2)) {
          bool1 = true;
        }
      }
      String str2 = "null";
      if (paramStFeed == null) {
        localObject2 = "null";
      } else {
        localObject2 = paramStFeed.id.get();
      }
      String str1 = str2;
      if (paramStFeed != null)
      {
        str1 = str2;
        if (paramStFeed.cover != null)
        {
          str1 = str2;
          if (paramStFeed.cover.picUrl != null) {
            str1 = paramStFeed.cover.picUrl.get();
          }
        }
      }
      paramStFeed = new StringBuilder();
      paramStFeed.append("[showGuideBubble] bubbleOffsetY: ");
      paramStFeed.append(m);
      paramStFeed.append(" | isLimitDisplay: ");
      paramStFeed.append(bool1);
      paramStFeed.append(" | feedId: ");
      paramStFeed.append((String)localObject2);
      paramStFeed.append(" | cover: ");
      paramStFeed.append(str1);
      paramStFeed.append("| hashCode: ");
      paramStFeed.append(hashCode());
      QLog.d("Stick-QCircleExpandStickView", 1, paramStFeed.toString());
      QCircleStickUtils.a(this.c, QCircleStickUtils.QCircleStickDisplayParam.a().a(paramPoint).a((Rect)localObject1).b(localRect).a(m).a(bool1));
      this.l = new QCircleExpandStickView.GuideBubbleViewRunnable(this);
      if (k())
      {
        QCircleConfig.getInstance().setDetailKuolieStickGuideBubbleNotShowAgain();
        return;
      }
      QCircleConfig.getInstance().setKuolieStickGuideBubbleNotShowAgain();
    }
  }
  
  @RequiresApi(api=21)
  private void a(View paramView, Size paramSize, int paramInt1, int paramInt2, float paramFloat)
  {
    if (paramView == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[showTestView] view not is null.");
      return;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[showTestView] params not is null.");
      return;
    }
    if (!(localObject instanceof FrameLayout.LayoutParams))
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[showTestView] current params not is frame layout.");
      return;
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).width = paramSize.getWidth();
    ((FrameLayout.LayoutParams)localObject).height = paramSize.getHeight();
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[showTestView] view: ", Integer.valueOf(paramView.hashCode()), " | width: ", Integer.valueOf(((FrameLayout.LayoutParams)localObject).width), " | height: ", Integer.valueOf(((FrameLayout.LayoutParams)localObject).height), " | top: ", Integer.valueOf(paramInt2), " | left: ", Integer.valueOf(paramInt1) });
    ((FrameLayout.LayoutParams)localObject).setMargins(paramInt1, paramInt2, ((FrameLayout.LayoutParams)localObject).rightMargin, ((FrameLayout.LayoutParams)localObject).bottomMargin);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setRotation(paramFloat);
    paramView.setVisibility(0);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[initializeTestDrawRect] rootView == null.");
      return;
    }
    if (this.d == null)
    {
      this.d = new View(getContext());
      this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      this.d.setBackgroundColor(Color.argb(33, 255, 0, 0));
      paramViewGroup.addView(this.d);
    }
    if (this.e == null)
    {
      this.e = new View(getContext());
      this.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      this.e.setBackgroundColor(Color.argb(33, 0, 255, 0));
      paramViewGroup.addView(this.e);
    }
  }
  
  private void a(ImageView.ScaleType paramScaleType)
  {
    Rect localRect1 = getSafeRect();
    Rect localRect2 = getDisplayRect();
    Rect localRect3 = getOriginRect();
    this.g = QCircleStickUtils.a(this.f, localRect3, localRect2, localRect1, paramScaleType);
  }
  
  private void a(QCircleFeedViewExportEvent paramQCircleFeedViewExportEvent)
  {
    String str = d();
    QCircleReportBean localQCircleReportBean = paramQCircleFeedViewExportEvent.getReportBean();
    int m;
    if (localQCircleReportBean == null) {
      m = -1;
    } else {
      m = localQCircleReportBean.getPageId();
    }
    int n = e();
    if ((TextUtils.equals(paramQCircleFeedViewExportEvent.getFeedId(), str)) && (m != -1) && (m == n))
    {
      this.k = true;
      g();
    }
  }
  
  private void a(QCircleGuideBubbleView paramQCircleGuideBubbleView)
  {
    if (paramQCircleGuideBubbleView == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[goneBubble] bubble not is null.");
      return;
    }
    if (paramQCircleGuideBubbleView.getVisibility() != 8)
    {
      QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[goneBubbleView] gone bubble, feed id: ", d() });
      paramQCircleGuideBubbleView.b();
    }
  }
  
  private void a(QCircleGuideBubbleView paramQCircleGuideBubbleView, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramQCircleGuideBubbleView == null)
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[showOwnerBubble] bubble not is null.");
      return;
    }
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[showOwnerBubble] click expand stick data not is null.");
      return;
    }
    localObject = a(((QQCircleFeedBase.StKuoliePasterData)localObject).content.get(), this.f.highlight_words.get());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[showOwnerBubble] content not is null.");
      return;
    }
    a(paramQCircleGuideBubbleView, paramStFeed, (SpannableString)localObject);
  }
  
  private void a(QCircleGuideBubbleView paramQCircleGuideBubbleView, FeedCloudMeta.StFeed paramStFeed, SpannableString paramSpannableString)
  {
    if (paramQCircleGuideBubbleView.getVisibility() == 0) {
      return;
    }
    Object localObject1 = this.g;
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((QCircleStickUtils.StickAreaConfig)localObject1).d();
    }
    localObject1 = this.g;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((QCircleStickUtils.StickAreaConfig)localObject1).a();
    }
    if (localObject2 == null) {
      localObject2 = localObject3;
    } else {
      localObject2 = ((QCircleStickUtils.StickArea)localObject2).b;
    }
    if (localObject2 == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[showClickBubble] current stick center point not is null.");
      return;
    }
    paramQCircleGuideBubbleView.setAutoClose(false);
    paramQCircleGuideBubbleView.setSpanText(paramSpannableString);
    paramQCircleGuideBubbleView.setOnClickListener(new QCircleExpandStickView.1(this, paramStFeed, paramQCircleGuideBubbleView));
    paramStFeed = getStickRect();
    int m = a(paramStFeed);
    j();
    paramSpannableString = this.i;
    boolean bool;
    if ((paramSpannableString != null) && (!QCircleExpandStickView.QCircleLoadStickParam.d(paramSpannableString))) {
      bool = true;
    } else {
      bool = false;
    }
    QCircleStickUtils.a(paramQCircleGuideBubbleView, QCircleStickUtils.QCircleStickDisplayParam.a().a((Point)localObject2).a((Rect)localObject1).b(paramStFeed).a(m).a(bool));
    QCircleStickHideManager.a().a(true);
    paramQCircleGuideBubbleView = this.f;
    if (paramQCircleGuideBubbleView != null) {
      QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[handlerOwnerClick] clickType: ", Integer.valueOf(paramQCircleGuideBubbleView.click_type.get()), " | content: ", this.f.content.get() });
    }
    if (k())
    {
      b(121, 1);
      return;
    }
    a(121, 1);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, QCircleGuideBubbleView paramQCircleGuideBubbleView)
  {
    if (QCirclePluginUtil.d(paramStFeed)) {
      b(getContext(), paramQCircleGuideBubbleView, paramStFeed);
    } else {
      a(getContext(), paramStFeed);
    }
    if (k())
    {
      b(121, 2);
      return;
    }
    a(121, 2);
  }
  
  private void a(String paramString)
  {
    if (getQCircleBaseFragment() == null) {
      return;
    }
    QCircleFeedDataCenter.a().a(paramString, new QCircleExpandStickView.FeedStateObserver(this));
  }
  
  private boolean a(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if ((paramStFeed1 != null) && (paramStFeed2 != null)) {
      return TextUtils.equals(paramStFeed1.id.get(), paramStFeed2.id.get());
    }
    return false;
  }
  
  private void b()
  {
    a(this.c);
    if (this.l != null)
    {
      RFThreadManager.getUIHandler().removeCallbacks(this.l);
      this.l = null;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((FeedBlockData)localObject1).b();
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.f;
    if (localObject2 == null) {
      return;
    }
    localObject2 = ((QQCircleFeedBase.StKuoliePasterData)localObject2).kuolie_id.get();
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject1)).setActionType(paramInt1).setSubActionType(paramInt2).setExt3((String)localObject2).setToUin(((FeedCloudMeta.StFeed)localObject1).poster.id.get()).setPageId(getPageId()).setfpageid(getParentPageId()));
  }
  
  private void b(@NonNull Context paramContext, QCircleGuideBubbleView paramQCircleGuideBubbleView, FeedCloudMeta.StFeed paramStFeed)
  {
    QQCircleFeedBase.StKuoliePasterData localStKuoliePasterData = this.f;
    if (localStKuoliePasterData == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[handlerOwnerClick] expand stick data not is null.");
      return;
    }
    if (paramStFeed == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[handlerOwnerClick] feed data not is null.");
      return;
    }
    int n = localStKuoliePasterData.click_type.get();
    int m = 0;
    if (n == 1)
    {
      try
      {
        QCircleHostLauncher.startNewFriendList(paramContext);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        QLog.e("Stick-QCircleExpandStickView", 1, paramContext, new Object[0]);
      }
    }
    else if (n == 2)
    {
      paramContext = this.i;
      if (paramContext != null) {
        m = paramContext.g();
      }
      SimpleEventBus.getInstance().dispatchEvent(new QCircleStickShareEvent(paramStFeed.id.get(), m, k(), getReportBean()));
    }
    a(paramQCircleGuideBubbleView);
  }
  
  private void b(boolean paramBoolean)
  {
    this.k = k();
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[updateStickVisible] isExistsStick: ", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      j();
      setVisibility(0);
      g();
      if (k()) {
        b(118, 1);
      } else {
        a(118, 1);
      }
      if (h()) {
        i();
      }
    }
    else
    {
      j();
      setVisibility(8);
    }
  }
  
  private boolean b(QCircleExpandStickView.QCircleLoadStickParam paramQCircleLoadStickParam)
  {
    Object localObject = this.i;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (paramQCircleLoadStickParam == null) {
        return false;
      }
      bool1 = bool2;
      if (QCircleExpandStickView.QCircleLoadStickParam.a((QCircleExpandStickView.QCircleLoadStickParam)localObject) != null)
      {
        if (QCircleExpandStickView.QCircleLoadStickParam.a(paramQCircleLoadStickParam) == null) {
          return false;
        }
        localObject = a(paramQCircleLoadStickParam.c(), paramQCircleLoadStickParam.g(), paramQCircleLoadStickParam.b());
        QQCircleFeedBase.StKuoliePasterData localStKuoliePasterData = a(this.i.c(), this.i.g(), this.i.b());
        bool1 = bool2;
        if (QCircleExpandStickView.QCircleLoadStickParam.b(this.i) == QCircleExpandStickView.QCircleLoadStickParam.b(paramQCircleLoadStickParam))
        {
          bool1 = bool2;
          if (QCircleExpandStickView.QCircleLoadStickParam.c(this.i) == QCircleExpandStickView.QCircleLoadStickParam.c(paramQCircleLoadStickParam))
          {
            bool1 = bool2;
            if (a(QCircleExpandStickView.QCircleLoadStickParam.a(this.i).b(), QCircleExpandStickView.QCircleLoadStickParam.a(paramQCircleLoadStickParam).b()))
            {
              bool1 = bool2;
              if (localObject != null)
              {
                bool1 = bool2;
                if (localStKuoliePasterData != null)
                {
                  bool1 = bool2;
                  if (TextUtils.equals(((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.get(), localStKuoliePasterData.kuolie_id.get())) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    if (this.b == null) {
      this.b = ((QCircleGuideBubbleView)findViewById(2131441708));
    }
    if (this.c == null) {
      this.c = ((QCircleGuideBubbleView)findViewById(2131441707));
    }
    if (h()) {
      a((ViewGroup)findViewById(2131441620));
    }
  }
  
  private void c(QCircleExpandStickView.QCircleLoadStickParam paramQCircleLoadStickParam)
  {
    Object localObject;
    if (paramQCircleLoadStickParam.c() == null) {
      localObject = null;
    } else {
      localObject = paramQCircleLoadStickParam.c().b();
    }
    String str2 = "";
    String str1;
    if (localObject == null) {
      str1 = "";
    } else {
      str1 = ((FeedCloudMeta.StFeed)localObject).id.get();
    }
    if ((localObject != null) && (((FeedCloudMeta.StFeed)localObject).poster != null)) {
      localObject = ((FeedCloudMeta.StFeed)localObject).poster.nick.get();
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty(str1))
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[initStickParam] current feed id not is empty.");
      return;
    }
    a(str1);
    if (b(paramQCircleLoadStickParam)) {
      return;
    }
    setData(paramQCircleLoadStickParam.c());
    this.i = paramQCircleLoadStickParam;
    this.h = true;
    b();
    a(paramQCircleLoadStickParam.g(), paramQCircleLoadStickParam.b());
    boolean bool = f();
    int m = paramQCircleLoadStickParam.g();
    QQCircleFeedBase.StKuoliePasterData localStKuoliePasterData = this.f;
    if (localStKuoliePasterData != null) {
      str2 = localStKuoliePasterData.kuolie_id.get();
    }
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[initStickParam] feedId: ", str1, " | nickName: ", localObject, " | horizontalPos:", Integer.valueOf(m), " | kuolie id:", str2, " | isExistsStick: ", Boolean.valueOf(bool), " | hashCode: ", Integer.valueOf(hashCode()) });
    if (bool) {
      a(paramQCircleLoadStickParam.i());
    }
    b(bool);
  }
  
  private String d()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FeedBlockData)localObject).b();
    }
    if (localObject == null) {
      return "";
    }
    return ((FeedCloudMeta.StFeed)localObject).id.get();
  }
  
  private int e()
  {
    QCircleReportBean localQCircleReportBean = getReportBean();
    if (localQCircleReportBean == null) {
      return -1;
    }
    return localQCircleReportBean.getPageId();
  }
  
  private boolean f()
  {
    QQCircleFeedBase.StKuoliePasterData localStKuoliePasterData = this.f;
    return (localStKuoliePasterData != null) && (localStKuoliePasterData.kuolie_id != null) && (!TextUtils.isEmpty(this.f.kuolie_id.get()));
  }
  
  private void g()
  {
    if (!f()) {
      return;
    }
    Object localObject = this.g;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((QCircleStickUtils.StickAreaConfig)localObject).d();
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setStickGuideBubbleDisplay] area not is null, hashCode: ");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("Stick-QCircleExpandStickView", 1, ((StringBuilder)localObject).toString());
      return;
    }
    FeedCloudMeta.StFeed localStFeed = this.a.b();
    if (localStFeed == null)
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[setStickGuideBubbleDisplay] feed not is null.");
      return;
    }
    a(((QCircleStickUtils.StickArea)localObject).b, localStFeed);
  }
  
  private Rect getDisplayRect()
  {
    QCircleExpandStickView.QCircleLoadStickParam localQCircleLoadStickParam = this.i;
    if (localQCircleLoadStickParam == null) {
      return null;
    }
    return localQCircleLoadStickParam.e();
  }
  
  private Rect getOriginRect()
  {
    QCircleExpandStickView.QCircleLoadStickParam localQCircleLoadStickParam = this.i;
    if (localQCircleLoadStickParam == null) {
      return null;
    }
    return localQCircleLoadStickParam.d();
  }
  
  private Rect getSafeRect()
  {
    QCircleExpandStickView.QCircleLoadStickParam localQCircleLoadStickParam = this.i;
    if (localQCircleLoadStickParam == null) {
      return null;
    }
    return localQCircleLoadStickParam.f();
  }
  
  private Rect getStickRect()
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[getStickRect] stick area config not is null");
      return null;
    }
    localObject = ((QCircleStickUtils.StickAreaConfig)localObject).d();
    if (localObject == null)
    {
      QLog.d("Stick-QCircleExpandStickView", 1, "[getStickRect] stick area not is null.");
      return null;
    }
    return a((QCircleStickUtils.StickArea)localObject);
  }
  
  private boolean h()
  {
    Object localObject = QCircleApplication.APP;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = RFApplication.getApplication().getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
    if (localObject != null) {
      bool = ((SharedPreferences)localObject).getBoolean("qcircle_show_stick_draw_rect", false);
    }
    return bool;
  }
  
  private void i()
  {
    if ((this.d != null) && (this.e != null))
    {
      Object localObject1 = this.g;
      if (localObject1 != null)
      {
        localObject1 = ((QCircleStickUtils.StickAreaConfig)localObject1).d();
        if (localObject1 == null) {
          return;
        }
        Object localObject2 = a((QCircleStickUtils.StickArea)localObject1);
        if (Build.VERSION.SDK_INT >= 21)
        {
          Size localSize = new Size(((Rect)localObject2).width(), ((Rect)localObject2).height());
          int m = (int)(((QCircleStickUtils.StickArea)localObject1).b.x - ((Rect)localObject2).width() / 2.0F);
          int n = (int)(((QCircleStickUtils.StickArea)localObject1).b.y - ((Rect)localObject2).height() / 2.0F);
          a(this.d, localSize, m, n, ((QCircleStickUtils.StickArea)localObject1).a);
        }
        localObject1 = getSafeRect();
        if (localObject1 == null) {
          return;
        }
        localObject2 = new QCircleStickUtils.StickArea();
        ((QCircleStickUtils.StickArea)localObject2).c = new Point(0, 0);
        ((QCircleStickUtils.StickArea)localObject2).f = new Point(((Rect)localObject1).width(), 0);
        ((QCircleStickUtils.StickArea)localObject2).d = new Point(0, ((Rect)localObject1).height());
        ((QCircleStickUtils.StickArea)localObject2).e = new Point(((Rect)localObject1).width(), ((Rect)localObject1).height());
        localObject1 = a((QCircleStickUtils.StickArea)localObject2);
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject1 = new Size(((Rect)localObject1).width(), ((Rect)localObject1).height());
          a(this.e, (Size)localObject1, 0, 0, 0.0F);
        }
      }
    }
  }
  
  private void j()
  {
    a(this.b);
  }
  
  private boolean k()
  {
    QCircleExpandStickView.QCircleLoadStickParam localQCircleLoadStickParam = this.i;
    return (localQCircleLoadStickParam != null) && (localQCircleLoadStickParam.h());
  }
  
  public void a()
  {
    j();
  }
  
  public void a(int paramInt)
  {
    QCircleExpandStickView.QCircleLoadStickParam localQCircleLoadStickParam = this.i;
    if (localQCircleLoadStickParam == null) {
      return;
    }
    if (paramInt == localQCircleLoadStickParam.g()) {
      return;
    }
    this.i.a(paramInt);
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[updatePosition] ", "| horizontalPos: ", Integer.valueOf(paramInt), " | hashCode:", Integer.valueOf(hashCode()) });
    a(paramInt, true);
    b(f());
  }
  
  protected void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    this.a = paramFeedBlockData;
  }
  
  public void a(FeedBlockData paramFeedBlockData, Rect paramRect1, Rect paramRect2, int paramInt, ImageView.ScaleType paramScaleType)
  {
    c(QCircleExpandStickView.QCircleLoadStickParam.a().a(paramFeedBlockData).a(paramRect1).b(paramRect2).c(null).a(paramInt).a(true).a(paramScaleType).b(false));
  }
  
  public void a(FeedBlockData paramFeedBlockData, Rect paramRect1, Rect paramRect2, boolean paramBoolean, ImageView.ScaleType paramScaleType)
  {
    c(QCircleExpandStickView.QCircleLoadStickParam.a().a(paramFeedBlockData).a(paramRect1).b(paramRect2).c(null).a(0).a(paramBoolean).a(paramScaleType).b(false));
  }
  
  public void a(QCircleExpandStickView.QCircleLoadStickParam paramQCircleLoadStickParam)
  {
    c(paramQCircleLoadStickParam);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.h) {
      return;
    }
    j();
    this.h = paramBoolean;
  }
  
  public boolean a(Point paramPoint)
  {
    if (this.a == null)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[interceptStickClick] current data not is null.");
      return false;
    }
    if (!f())
    {
      paramPoint = new StringBuilder();
      paramPoint.append("[interceptStickClick] current not exists expand stick, hashCode: ");
      paramPoint.append(hashCode());
      QLog.w("Stick-QCircleExpandStickView", 1, paramPoint.toString());
      return false;
    }
    if (!this.h)
    {
      QLog.w("Stick-QCircleExpandStickView", 1, "[interceptStickClick] current scale state, not click stick.");
      return false;
    }
    Object localObject = this.g;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((QCircleStickUtils.StickAreaConfig)localObject).d();
    }
    if (!QCircleStickUtils.a(paramPoint, (QCircleStickUtils.StickArea)localObject))
    {
      QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[interceptStickClick] current click stick not in the area, hash code: ", Integer.valueOf(hashCode()) });
      j();
      b();
      return false;
    }
    int m = paramPoint.x;
    int n = paramPoint.y;
    paramPoint = this.b;
    if (paramPoint == null) {
      paramPoint = "null";
    } else {
      paramPoint = Integer.valueOf(paramPoint.hashCode());
    }
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[interceptStickClick] click-x: ", Integer.valueOf(m), " | click-y: ", Integer.valueOf(n), " | click bubble: ", paramPoint });
    paramPoint = this.a.b();
    a(getContext(), this.b, paramPoint);
    return true;
  }
  
  public void b(Point paramPoint)
  {
    Object localObject = this.g;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((QCircleStickUtils.StickAreaConfig)localObject).d();
    }
    if (QCircleStickUtils.a(paramPoint, (QCircleStickUtils.StickArea)localObject)) {
      return;
    }
    j();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedViewExportEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131626795;
  }
  
  protected String getLogTag()
  {
    return "Stick-QCircleExpandStickView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    QCircleStickHideManager.a().a(this);
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(this);
    if ((!k()) && (this.l != null)) {
      RFThreadManager.getUIHandler().removeCallbacks(this.l);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    QCircleStickHideManager.a().b(this);
    QCircleListenerProxyManager.getInstance().removeQQFrontBackListener(this);
    setOnTouchListener(null);
    j();
    if ((!k()) && (this.l != null))
    {
      RFThreadManager.getUIHandler().postDelayed(this.l, 100L);
      return;
    }
    b();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    c();
  }
  
  public void onQQEnterBackground()
  {
    RFThreadManager.getUIHandler().post(new QCircleExpandStickView.3(this));
  }
  
  public void onQQEnterForeground() {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedViewExportEvent)) {
      a((QCircleFeedViewExportEvent)paramSimpleBaseEvent);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = this.b;
      boolean bool;
      if ((paramView != null) && (paramView.getVisibility() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      this.j = bool;
      j();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView
 * JD-Core Version:    0.7.0.1
 */