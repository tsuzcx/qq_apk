package com.tencent.biz.qqcircle.widgets;

import aaak;
import aaam;
import aaga;
import aazb;
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
import bhlq;
import bhpc;
import blir;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import uzg;
import vqn;
import wah;
import wai;
import waj;
import wak;
import wal;

public class QCircleFollowView
  extends TextView
  implements aaam, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aaga jdField_a_of_type_Aaga;
  public FeedCloudMeta.StUser a;
  private String jdField_a_of_type_JavaLangString;
  private wak jdField_a_of_type_Wak;
  private wal jdField_a_of_type_Wal;
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
    this.jdField_b_of_type_Int = paramContext.getResourceId(2, 2130843914);
    this.jdField_a_of_type_Int = paramContext.getResourceId(4, 2130843913);
    this.jdField_d_of_type_Int = paramContext.getResourceId(0, 2130843915);
    this.jdField_c_of_type_Int = paramContext.getResourceId(1, 2130843912);
    this.jdField_e_of_type_Int = paramContext.getColor(3, getResources().getColor(2131165356));
    this.f = paramContext.getColor(5, getResources().getColor(2131166243));
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
        QQToast.a(getContext(), 0, 2131697222, 0).a();
        return true;
      }
    } while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() != 2);
    bhlq.a(getContext(), 230).setMessage(2131697223).setPositiveButton(2131697240, new wah(this)).show();
    return true;
  }
  
  private void d()
  {
    blir localblir = blir.a(getContext());
    localblir.a(getContext().getResources().getString(2131697353));
    localblir.a(2131697354, 3);
    localblir.c(2131690580);
    localblir.a(new waj(this, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
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
    if ((TextUtils.isEmpty(paramStUser.id.get())) || (uzg.a(paramStUser))) {
      setVisibility(8);
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!vqn.a().a(paramStUser.id.get()));
      bool = vqn.a().b(paramStUser.id.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(uzg.a(bool));
      a(uzg.a(bool));
    } while (this.jdField_a_of_type_Wak == null);
    this.jdField_a_of_type_Wak.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
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
      setText(2131697233);
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
      setText(2131697221);
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
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFollowView", 2, "follow");
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)
    {
      QLog.e("QCircleFollowView", 2, "follow user failed! user is null");
      return;
    }
    if (!paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      if (paramBoolean) {
        j = 1;
      }
      FeedCloudCommon.StCommonExt localStCommonExt = null;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localStCommonExt = new FeedCloudCommon.StCommonExt();
        FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
        localEntry.key.set("feedid");
        localEntry.value.set(this.jdField_a_of_type_JavaLangString);
        localStCommonExt.mapInfo.get().add(localEntry);
      }
      a(j, true);
      QLog.d("QCircleFollowView", 1, "mStUser:" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get() + "setFakeFollowUI:" + j);
      VSNetworkHelper.a().a(new QCircleDoFollowRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, j, localStCommonExt), new wai(this, j, i));
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
      aaak.a().a(this);
    }
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Wal != null)) {
      this.jdField_a_of_type_Wal.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
    }
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  public void onClick(View paramView)
  {
    if ((aazb.a("QCircleFollowViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Wal != null) {
        this.jdField_a_of_type_Wal.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
      }
      if (this.jdField_a_of_type_Aaga != null) {
        this.jdField_a_of_type_Aaga.a();
      }
      if (!a()) {
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 0) {
          b(true);
        } else if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 1) && (!this.jdField_c_of_type_Boolean)) {
          d();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
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
        if (this.jdField_a_of_type_Wak != null) {
          if (paramSimpleBaseEvent.mFollowStatus != 1) {
            break label96;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Wak.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      return;
      label96:
      bool = false;
    }
  }
  
  public void setFollowStateChangeListener(wak paramwak)
  {
    this.jdField_a_of_type_Wak = paramwak;
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
  
  public void setItemPreClickListener(aaga paramaaga)
  {
    this.jdField_a_of_type_Aaga = paramaaga;
  }
  
  public void setItemReportListener(wal paramwal)
  {
    this.jdField_a_of_type_Wal = paramwal;
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
      if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!uzg.a(paramStUser))) {
        break label87;
      }
      setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
      label87:
      if (vqn.a().a(paramStUser.id.get()))
      {
        boolean bool = vqn.a().b(paramStUser.id.get());
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(uzg.a(bool));
        a(uzg.a(bool));
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
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */