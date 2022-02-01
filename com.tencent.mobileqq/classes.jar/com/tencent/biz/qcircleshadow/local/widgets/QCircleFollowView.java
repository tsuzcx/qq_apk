package com.tencent.biz.qcircleshadow.local.widgets;

import aala;
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
import bhdj;
import bkzi;
import com.tencent.biz.qcircleshadow.local.requests.QCircleDoFollowRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.events.QCircleFollowUpdateEvent;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import vvx;
import vvy;
import vvz;
import vwa;
import vwb;
import vwc;
import vwd;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, SimpleEventReceiver
{
  private int jdField_a_of_type_Int;
  public FeedCloudMeta.StUser a;
  private String jdField_a_of_type_JavaLangString;
  private vwb jdField_a_of_type_Vwb;
  private vwc jdField_a_of_type_Vwc;
  private vwd jdField_a_of_type_Vwd;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleFollowView);
    this.jdField_b_of_type_Int = paramContext.getResourceId(2, 2130844013);
    this.jdField_a_of_type_Int = paramContext.getResourceId(4, 2130844012);
    this.jdField_d_of_type_Int = paramContext.getResourceId(0, 2130844014);
    this.jdField_c_of_type_Int = paramContext.getResourceId(1, 2130844011);
    this.jdField_e_of_type_Int = paramContext.getColor(3, getResources().getColor(2131165370));
    this.f = paramContext.getColor(5, getResources().getColor(2131166271));
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
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 2)) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 3))
      {
        QQToast.a(getContext(), 0, 2131697643, 0).a();
        return true;
      }
    } while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() != 2);
    bhdj.a(getContext(), 230).setMessage(2131697644).setPositiveButton(2131697661, new vvy(this)).show();
    return true;
  }
  
  private void d()
  {
    bkzi localbkzi = bkzi.a(getContext());
    localbkzi.a(getContext().getResources().getString(2131697777));
    localbkzi.a(2131697778, 3);
    localbkzi.c(2131690697);
    localbkzi.a(new vwa(this, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
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
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(paramInt);
      QLog.d("QCircleFollowView", 1, "uin:" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get() + " state:" + paramInt);
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
    boolean bool = true;
    if ((TextUtils.isEmpty(paramStUser.id.get())) || (vvx.a(paramStUser))) {
      setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (!QCircleFollowManager.getInstance().hasUin(paramStUser.id.get()));
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(QCircleFollowManager.getInstance().getUinFollowed(paramStUser.id.get()).intValue());
      a(QCircleFollowManager.getInstance().getUinFollowed(paramStUser.id.get()).intValue());
    } while (this.jdField_a_of_type_Vwb == null);
    vwb localvwb = this.jdField_a_of_type_Vwb;
    if (QCircleFollowManager.getInstance().getUinFollowed(paramStUser.id.get()).intValue() == 1) {}
    for (;;)
    {
      localvwb.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      return;
      bool = false;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(0);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 1) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 3))) {
      setBackgroundResource(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      setTextColor(this.jdField_e_of_type_Int);
      setText(2131697654);
      if (this.jdField_d_of_type_Boolean)
      {
        if (!paramBoolean) {
          break;
        }
        c();
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        setBackgroundDrawable(a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString));
      } else {
        setBackgroundResource(this.jdField_b_of_type_Int);
      }
    }
    setVisibility(8);
  }
  
  protected void b()
  {
    setVisibility(0);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() != 0)) {
      setBackgroundResource(this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      setTextColor(this.f);
      setText(2131697642);
      return;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        setBackgroundDrawable(a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString));
      } else {
        setBackgroundResource(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFollowView", 2, "follow");
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)
    {
      QLog.e("QCircleFollowView", 2, "follow user failed! user is null");
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      FeedCloudCommon.StCommonExt localStCommonExt = null;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localStCommonExt = new FeedCloudCommon.StCommonExt();
        FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
        localEntry.key.set("feedid");
        localEntry.value.set(this.jdField_a_of_type_JavaLangString);
        localStCommonExt.mapInfo.get().add(localEntry);
      }
      VSNetworkHelper.getInstance().sendRequest(new QCircleDoFollowRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, i, localStCommonExt), new vvz(this, i, paramBoolean));
      return;
    }
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
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Vwc != null)) {
      this.jdField_a_of_type_Vwc.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
    }
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  public void onClick(View paramView)
  {
    if ((aala.a("QCircleFollowViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Vwc != null) {
        this.jdField_a_of_type_Vwc.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
      }
      if (this.jdField_a_of_type_Vwd != null) {
        this.jdField_a_of_type_Vwd.a();
      }
      if (!a())
      {
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 0) {
          b(true);
        }
        if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 1) && (!this.jdField_c_of_type_Boolean)) {
          d();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get().equals(paramSimpleBaseEvent.mUserId)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() != paramSimpleBaseEvent.mFollowStatus))
      {
        a(paramSimpleBaseEvent.mFollowStatus);
        if (this.jdField_a_of_type_Vwb != null) {
          if (paramSimpleBaseEvent.mFollowStatus != 1) {
            break label96;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Vwb.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      return;
      label96:
      bool = false;
    }
  }
  
  public void setFollowStateChangeListener(vwb paramvwb)
  {
    this.jdField_a_of_type_Vwb = paramvwb;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
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
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setFollowedTextColor(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setItemPreClickListener(vwd paramvwd)
  {
    this.jdField_a_of_type_Vwd = paramvwd;
  }
  
  public void setItemReportListener(vwc paramvwc)
  {
    this.jdField_a_of_type_Vwc = paramvwc;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
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
      if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!vvx.a(paramStUser))) {
        break label87;
      }
      setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
      label87:
      if (QCircleFollowManager.getInstance().hasUin(paramStUser.id.get()))
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(QCircleFollowManager.getInstance().getUinFollowed(paramStUser.id.get()).intValue());
        a(QCircleFollowManager.getInstance().getUinFollowed(paramStUser.id.get()).intValue());
      }
      else
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(paramStUser.followState.get());
        a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.widgets.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */