package com.tencent.mobileqq.activity.qcircle.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.ArrayList;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, SimpleEventReceiver
{
  private int jdField_a_of_type_Int;
  private QCircleFollowView.FollowChangeListener jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowChangeListener;
  private QCircleFollowView.FollowReportListener jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowReportListener;
  private QCircleFollowView.ItemPreClickListener jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$ItemPreClickListener;
  protected FeedCloudMeta.StUser a;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  
  public QCircleFollowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
    this.jdField_a_of_type_Boolean = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleFollowView);
    this.jdField_b_of_type_Int = paramContext.getResourceId(2, 2130844088);
    this.jdField_a_of_type_Int = paramContext.getResourceId(4, 2130844087);
    this.jdField_d_of_type_Int = paramContext.getResourceId(0, 2130844089);
    this.jdField_c_of_type_Int = paramContext.getResourceId(1, 2130844086);
    this.e = paramContext.getColor(3, getResources().getColor(2131165338));
    this.f = paramContext.getColor(5, getResources().getColor(2131166289));
    paramContext.recycle();
    a();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("followstate", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void a(FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
    boolean bool = true;
    if (localObject == null)
    {
      QLog.w("QCircleFollowView", 1, "[onReceive] user info not is null.");
      return;
    }
    if (paramInt != 1) {
      bool = false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowChangeListener;
    if (localObject != null) {
      ((QCircleFollowView.FollowChangeListener)localObject).a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(paramInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()));
    a(getContext(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), paramInt);
    ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).setUinFollowed(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), paramInt);
    if (paramStDoFollowRsp != null) {
      ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).updateFollowUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.nick.get(), bool);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 2)) {
      return false;
    }
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() != 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() != 3))
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 2)
      {
        DialogUtil.a(getContext(), 230).setMessage(2131697905).setPositiveButton(2131697922, new QCircleFollowView.1(this)).show();
        return true;
      }
      return false;
    }
    QQToast.a(getContext(), 0, 2131697904, 0).a();
    return true;
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.create(getContext());
    localActionSheet.setMainTitle(getContext().getResources().getString(2131698040));
    localActionSheet.addButton(2131698041, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new QCircleFollowView.5(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  protected URLDrawable a(int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt);
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected void a()
  {
    setOnClickListener(this);
    b();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
    if (localObject != null)
    {
      ((FeedCloudMeta.StUser)localObject).followState.set(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QCircleFollowView", 1, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      a(paramBoolean);
      return;
    }
    b();
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!QCircleHostUtil.isOwner(paramStUser)))
    {
      if (((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).hasUin(paramStUser.id.get()))
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
        a(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
        QCircleFollowView.FollowChangeListener localFollowChangeListener = this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowChangeListener;
        if (localFollowChangeListener != null)
        {
          int i = ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get());
          boolean bool = true;
          if (i != 1) {
            bool = false;
          }
          localFollowChangeListener.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
        }
      }
    }
    else {
      setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(0);
    FeedCloudMeta.StUser localStUser = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
    if ((localStUser != null) && ((localStUser.blackState.get() == 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 3))) {
      setBackgroundResource(this.jdField_d_of_type_Int);
    } else if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      setBackgroundDrawable(a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString));
    } else {
      setBackgroundResource(this.jdField_b_of_type_Int);
    }
    setTextColor(this.e);
    setText(2131697915);
    if (this.jdField_c_of_type_Boolean)
    {
      if (paramBoolean)
      {
        c();
        return;
      }
      setVisibility(8);
    }
  }
  
  protected void b()
  {
    setVisibility(0);
    FeedCloudMeta.StUser localStUser = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
    if ((localStUser != null) && (localStUser.blackState.get() != 0)) {
      setBackgroundResource(this.jdField_c_of_type_Int);
    } else if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      setBackgroundDrawable(a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString));
    } else {
      setBackgroundResource(this.jdField_a_of_type_Int);
    }
    setTextColor(this.f);
    setText(2131697903);
  }
  
  protected void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void c()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillEnabled(false);
    startAnimation(localAlphaAnimation);
    postDelayed(new QCircleFollowView.2(this), 500L);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      SimpleEventBus.getInstance().registerReceiver(this);
    }
    FeedCloudMeta.StUser localStUser = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
    if (localStUser != null)
    {
      QCircleFollowView.FollowReportListener localFollowReportListener = this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowReportListener;
      if (localFollowReportListener != null) {
        localFollowReportListener.a(localStUser.followState.get());
      }
    }
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  public void onClick(View paramView)
  {
    if (!FastClickUtils.a("QCircleFollowViewClick"))
    {
      Object localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
      if (localObject != null)
      {
        QCircleFollowView.FollowReportListener localFollowReportListener = this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowReportListener;
        if (localFollowReportListener != null) {
          localFollowReportListener.b(((FeedCloudMeta.StUser)localObject).followState.get());
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$ItemPreClickListener;
        if (localObject != null) {
          ((QCircleFollowView.ItemPreClickListener)localObject).a();
        }
        if (!a()) {
          if (!QCircleHostUtil.isFollow(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
            b(true);
          } else {
            d();
          }
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
    FeedCloudMeta.StUser localStUser = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
    if ((localStUser != null) && ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if ((localStUser.id.get().equals(paramSimpleBaseEvent.mUserId)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() != paramSimpleBaseEvent.mFollowStatus))
      {
        a(paramSimpleBaseEvent.mFollowStatus);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowChangeListener != null)
        {
          int i = paramSimpleBaseEvent.mFollowStatus;
          boolean bool = true;
          if (i != 1) {
            bool = false;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowChangeListener.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
        }
      }
    }
  }
  
  public void setFollowStateChangeListener(QCircleFollowView.FollowChangeListener paramFollowChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowChangeListener = paramFollowChangeListener;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setFollowedDrawable(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setFollowedRemoteUrl(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setFollowedShowToast(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setFollowedTextColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setItemPreClickListener(QCircleFollowView.ItemPreClickListener paramItemPreClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$ItemPreClickListener = paramItemPreClickListener;
  }
  
  public void setItemReportListener(QCircleFollowView.FollowReportListener paramFollowReportListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView$FollowReportListener = paramFollowReportListener;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setUnFollowRemoteUrl(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setUnFollowTextColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    setUserData(paramStUser, "");
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser, String paramString)
  {
    if (paramStUser != null)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.set(paramStUser.id.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.nick.set(paramStUser.nick.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.set(paramStUser.blackState.get());
      if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!QCircleHostUtil.isOwner(paramStUser)))
      {
        if (((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).hasUin(paramStUser.id.get()))
        {
          this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
          a(((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getUinFollowed(paramStUser.id.get()));
        }
        else
        {
          this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(paramStUser.followState.get());
          a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
        }
      }
      else {
        setVisibility(8);
      }
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */