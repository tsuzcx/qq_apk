package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.ItemPreClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneMixApi;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class FollowTextView
  extends TextView
  implements View.OnClickListener, SimpleEventReceiver
{
  protected boolean a = false;
  private volatile boolean b = true;
  private CertifiedAccountMeta.StFeed c;
  private ExtraTypeInfo d;
  private BaseWidgetView.ItemPreClickListener e;
  private FollowTextView.FollowChangeListener f;
  private boolean g;
  private boolean h;
  
  public FollowTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (!StringUtil.isEmpty(paramStFeed.id.get())) {
        localObject = paramStFeed.id;
      } else {
        localObject = paramStFeed.poster.nick;
      }
      Object localObject = ((PBStringField)localObject).get();
      String str1 = paramStFeed.poster.id.get();
      paramStFeed = new StringBuilder();
      paramStFeed.append("auth_");
      paramStFeed.append(SubscribeShareHelper.a(getExtraTypeInfo()));
      String str2 = paramStFeed.toString();
      if (paramBoolean) {
        paramStFeed = "follow";
      } else {
        paramStFeed = "un_follow";
      }
      VSReporter.a(str1, str2, paramStFeed, 0, 0, new String[] { "", "", localObject });
    }
  }
  
  private void e()
  {
    ActionSheet localActionSheet = ActionSheet.create(getContext());
    localActionSheet.setMainTitle(String.format(getContext().getResources().getString(2131893008), new Object[] { this.c.poster.nick.get() }));
    localActionSheet.addButton(2131894218, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new FollowTextView.3(this));
    localActionSheet.setOnButtonClickListener(new FollowTextView.4(this, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.b = true;
      localActionSheet.show();
    }
  }
  
  protected void a()
  {
    setGravity(17);
    setTextColor(-1);
    setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    CertifiedAccountMeta.StFeed localStFeed = this.c;
    if (localStFeed != null) {
      localStFeed.poster.followState.set(paramInt);
    }
    if (paramInt == 1)
    {
      b();
      return;
    }
    c();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowTextView", 2, "follow");
    }
    if (this.c == null)
    {
      QLog.e("FollowTextView", 2, "follow user failed! user is null");
      return;
    }
    this.b = false;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (paramBoolean)
      {
        localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
        localIPublicAccountObserver.setOnCallback(new FollowTextView.1(this));
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)localObject, getContext(), this.c.poster.id.get(), localIPublicAccountObserver, false, 0, true);
        return;
      }
      IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
      localIPublicAccountObserver.setOnCallback(new FollowTextView.2(this));
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin((AppInterface)localObject, getContext(), this.c.poster.id.get(), false, localIPublicAccountObserver, true);
    }
  }
  
  protected void b()
  {
    int i;
    if (this.a) {
      i = 2130839116;
    } else {
      i = 2130839114;
    }
    setBackgroundResource(i);
    if (this.a) {
      i = -9211021;
    } else {
      i = Color.parseColor("#bdbfc9");
    }
    setTextColor(i);
    setText(2131887693);
  }
  
  protected void c()
  {
    int i;
    if (this.a) {
      i = 2130839203;
    } else {
      i = 2130839201;
    }
    setBackgroundResource(i);
    if (this.a) {
      i = -1493172225;
    } else {
      i = -1;
    }
    setTextColor(i);
    setText(2131887699);
  }
  
  protected boolean d()
  {
    CertifiedAccountMeta.StFeed localStFeed = this.c;
    return (localStFeed == null) || (StringUtil.isEmpty(localStFeed.poster.nick.get()));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.d;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      SimpleEventBus.getInstance().registerReceiver(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!d()) {
      if (!this.b)
      {
        QQToast.makeText(getContext(), "请勿重复操作", 0).show();
      }
      else
      {
        BaseWidgetView.ItemPreClickListener localItemPreClickListener = this.e;
        if (localItemPreClickListener != null) {
          localItemPreClickListener.a();
        }
        if (this.c.poster.followState.get() == 0) {
          a(true);
        } else if (!this.h) {
          e();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    CertifiedAccountMeta.StFeed localStFeed = this.c;
    if ((localStFeed != null) && ((paramSimpleBaseEvent instanceof FollowUpdateEvent)))
    {
      paramSimpleBaseEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (localStFeed.poster.id.get().equals(paramSimpleBaseEvent.useId))
      {
        a(paramSimpleBaseEvent.followStatus);
        ((IQzoneMixApi)QRoute.api(IQzoneMixApi.class)).broadcastFollowIfNeed(getContext(), paramSimpleBaseEvent.useId, paramSimpleBaseEvent.followStatus);
        SubscribeHybirdFragment.a(getContext(), paramSimpleBaseEvent);
      }
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.d = paramExtraTypeInfo;
  }
  
  public void setFeedData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.c = paramStFeed;
      a(paramStFeed.poster.followState.get());
    }
  }
  
  public void setFollowStateChangeListener(FollowTextView.FollowChangeListener paramFollowChangeListener)
  {
    this.f = paramFollowChangeListener;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setItemPreClickListener(BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    this.e = paramItemPreClickListener;
  }
  
  public void setNoneReportType(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setUserData(CertifiedAccountMeta.StUser paramStUser)
  {
    setUserData(paramStUser, -1);
  }
  
  public void setUserData(CertifiedAccountMeta.StUser paramStUser, int paramInt)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    localStFeed.poster.set(paramStUser);
    localStFeed.type.set(paramInt);
    this.c = localStFeed;
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    a(localStFeed.poster.followState.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView
 * JD-Core Version:    0.7.0.1
 */