package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCirclePushBubbleEvent;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCircleTipsUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import qqcircle.QQCircleEnvHub.Tips;

public class QCirclePushBubbleView
  extends QCircleGuideBubbleView
  implements SimpleEventReceiver
{
  private static String[] c = new String[6];
  private static boolean[] d = new boolean[6];
  private FeedCloudMeta.StFeed a;
  private int b;
  private int e;
  
  public QCirclePushBubbleView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushBubbleView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QCirclePushBubbleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt != 0)
    {
      if (paramString == null) {
        return;
      }
      setCloseButton(false);
      setShowDuration(paramInt);
      setText(paramString);
      a();
    }
  }
  
  private void a(QQCircleEnvHub.Tips paramTips)
  {
    if (paramTips == null)
    {
      QLog.d("QCirclePushBubbleView", 1, "tips is null");
      return;
    }
    a(paramTips.durationMs.get(), paramTips.text.get());
    QCircleTipsUtil.a(HostDataTransUtils.getAccount(), paramTips);
  }
  
  private void h()
  {
    if (this.b == 2) {
      setStyle(2);
    } else {
      setStyle(1);
    }
    setCloseButton(false);
    setShowDuration(2000);
    setText(getContext().getString(2131895754));
    a();
  }
  
  private void i()
  {
    QCirclePluginConfig.a().e(true);
    setStyle(0);
    setCloseButton(false);
    setText(getContext().getString(2131895753));
    setShowDuration(3000);
    setNeedFadeAnim(true);
    a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (getExtraTypeInfo() != null)
    {
      FeedCloudMeta.StFeed localStFeed = this.a;
      if (localStFeed != null)
      {
        if (this.b == 2)
        {
          QCircleLpReportDc05507.report(QCirclePluginReportUtil.d(localStFeed).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(this.a.poster.id.get()).setPlayScene(getQCircleExtraTypeInfo().mPlayScene).setPosition(getQCircleExtraTypeInfo().mDataPosition).setPageId(getPageId()).setfpageid(getParentPageId()));
          return;
        }
        QCircleLpReportDc05501.report(QCirclePluginReportUtil.b(localStFeed).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(this.a.poster.id.get()).setPageId(getPageId()).setIndex(getQCircleExtraTypeInfo().mDataPosition));
        return;
      }
    }
    QLog.e("QCirclePushBubbleView", 1, "ExtraTypeInfo is null or mStFeed is null");
  }
  
  public void a(QCirclePushBubbleEvent paramQCirclePushBubbleEvent)
  {
    if ((this.a != null) && (paramQCirclePushBubbleEvent.mPageType == this.b))
    {
      if (getContext() == null) {
        return;
      }
      if (!paramQCirclePushBubbleEvent.mFeedId.equals(this.a.id.get()))
      {
        if (paramQCirclePushBubbleEvent.mBubbleType != 2) {
          b();
        }
        return;
      }
      QLog.d("QCirclePushBubbleView", 1, "showMessageBubble");
      int i = paramQCirclePushBubbleEvent.mBubbleType;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                return;
              }
              a(paramQCirclePushBubbleEvent.getPushTip());
              return;
            }
            i();
            return;
          }
          b();
          return;
        }
        h();
        return;
      }
      i = this.b;
      if ((i == 1) || (i == 2) || (i == 5))
      {
        paramQCirclePushBubbleEvent = d;
        i = this.b;
        paramQCirclePushBubbleEvent[i] = 1;
        c[i] = this.a.id.get();
      }
      a(112, 1);
      d();
    }
  }
  
  public void d()
  {
    if (getContext() != null)
    {
      if (getContext().getResources() == null) {
        return;
      }
      Drawable localDrawable = getContext().getResources().getDrawable(2130845094);
      if (localDrawable == null) {
        return;
      }
      int i = getContentLineHeight();
      localDrawable.setBounds(0, 0, i, i);
      SpannableString localSpannableString = new SpannableString(getContext().getString(2131895755));
      localSpannableString.setSpan(new QCirclePushBubbleView.1(this), 6, 13, 33);
      localSpannableString.setSpan(new ImageSpan(localDrawable), 5, 6, 33);
      setSpanText(localSpannableString);
      setCloseButton(true);
      setClickSpanAttribute();
      setStyle(0);
      i = this.b;
      if ((i == 1) || (i == 2)) {
        setOnHideListener(new QCirclePushBubbleView.2(this));
      }
      setOnCloseClickListener(new QCirclePushBubbleView.3(this));
      a();
    }
  }
  
  public void e()
  {
    if ((this.a != null) && ((getInteractor() instanceof QCircleInteractor)))
    {
      QCircleShareInfo localQCircleShareInfo = new QCircleShareInfo();
      QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
      localQCircleExtraTypeInfo.mFeed = this.a;
      localQCircleExtraTypeInfo.pageType = getPageId();
      localQCircleShareInfo.c = localQCircleExtraTypeInfo;
      localQCircleShareInfo.d = 0;
      localQCircleShareInfo.b = this.a;
      localQCircleShareInfo.l = false;
      localQCircleShareInfo.i = false;
      localQCircleShareInfo.p = false;
      localQCircleShareInfo.j = false;
      localQCircleShareInfo.k = false;
      localQCircleShareInfo.n = false;
      ((QCircleInteractor)getInteractor()).a(localQCircleShareInfo);
      return;
    }
    QLog.e("QCirclePushBubbleView", 1, "doShare: mStFeed is null or interactor is null");
  }
  
  public void f()
  {
    FeedCloudMeta.StFeed localStFeed = this.a;
    if (localStFeed != null)
    {
      int i = this.b;
      boolean[] arrayOfBoolean = d;
      if (i >= arrayOfBoolean.length) {
        return;
      }
      if ((arrayOfBoolean[i] != 0) && (localStFeed.id.get().equals(c[this.b]))) {
        d();
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushBubbleEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    f();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    c();
    setNeedFadeAnim(false);
    b();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePushBubbleEvent)) {
      a((QCirclePushBubbleEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void setPageType(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushBubbleView
 * JD-Core Version:    0.7.0.1
 */