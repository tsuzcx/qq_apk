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
import com.tencent.widget.ActionSheet;
import cooperation.qzone.util.QzonePublicAccountHelper;
import java.util.ArrayList;

public class FollowTextView
  extends TextView
  implements View.OnClickListener, SimpleEventReceiver
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private BaseWidgetView.ItemPreClickListener jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$ItemPreClickListener;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FollowTextView.FollowChangeListener jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView$FollowChangeListener;
  protected boolean a;
  private volatile boolean b = true;
  private boolean c;
  private boolean d;
  
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
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String str1;
    String str2;
    String str3;
    if (paramStFeed != null)
    {
      if (StringUtil.a(paramStFeed.id.get())) {
        break label100;
      }
      str1 = paramStFeed.id.get();
      str2 = paramStFeed.poster.id.get();
      str3 = "auth_" + SubscribeShareHelper.a(a());
      if (!paramBoolean) {
        break label114;
      }
    }
    label100:
    label114:
    for (paramStFeed = "follow";; paramStFeed = "un_follow")
    {
      VSReporter.a(str2, str3, paramStFeed, 0, 0, new String[] { "", "", str1 });
      return;
      str1 = paramStFeed.poster.nick.get();
      break;
    }
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.create(getContext());
    localActionSheet.setMainTitle(String.format(getContext().getResources().getString(2131695270), new Object[] { this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get() }));
    localActionSheet.addButton(2131696427, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnDismissListener(new FollowTextView.3(this));
    localActionSheet.setOnButtonClickListener(new FollowTextView.4(this, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.b = true;
      localActionSheet.show();
    }
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  protected void a()
  {
    setGravity(17);
    setTextColor(-1);
    setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(paramInt);
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
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      QLog.e("FollowTextView", 2, "follow user failed! user is null");
    }
    do
    {
      return;
      this.b = false;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = (QQAppInterface)localObject;
    if (paramBoolean)
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)localObject, getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), new FollowTextView.1(this), false, 0, true);
      return;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin((QQAppInterface)localObject, getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), false, new FollowTextView.2(this), true);
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get()));
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2130839109;
      setBackgroundResource(i);
      if (!this.jdField_a_of_type_Boolean) {
        break label46;
      }
    }
    label46:
    for (int i = -9211021;; i = Color.parseColor("#bdbfc9"))
    {
      setTextColor(i);
      setText(2131690843);
      return;
      i = 2130839107;
      break;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2130839196;
      setBackgroundResource(i);
      if (!this.jdField_a_of_type_Boolean) {
        break label47;
      }
    }
    label47:
    for (int i = -1493172225;; i = -1)
    {
      setTextColor(i);
      setText(2131690849);
      return;
      i = 2130839194;
      break;
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      SimpleEventBus.getInstance().registerReceiver(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.b)
      {
        QQToast.a(getContext(), "请勿重复操作", 0).a();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$ItemPreClickListener != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$ItemPreClickListener.a();
        }
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() == 0) {
          a(true);
        } else if (!this.d) {
          d();
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && ((paramSimpleBaseEvent instanceof FollowUpdateEvent)))
    {
      FollowUpdateEvent localFollowUpdateEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get().equals(localFollowUpdateEvent.useId))
      {
        a(localFollowUpdateEvent.followStatus);
        QzonePublicAccountHelper.broadcastFollowIfNeed(getContext(), (FollowUpdateEvent)paramSimpleBaseEvent);
        SubscribeHybirdFragment.a(getContext(), (FollowUpdateEvent)paramSimpleBaseEvent);
      }
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setFeedData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      a(paramStFeed.poster.followState.get());
    }
  }
  
  public void setFollowStateChangeListener(FollowTextView.FollowChangeListener paramFollowChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView$FollowChangeListener = paramFollowChangeListener;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setItemPreClickListener(BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$ItemPreClickListener = paramItemPreClickListener;
  }
  
  public void setNoneReportType(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.d = paramBoolean;
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
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = localStFeed;
    if (paramInt == -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      a(localStFeed.poster.followState.get());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView
 * JD-Core Version:    0.7.0.1
 */