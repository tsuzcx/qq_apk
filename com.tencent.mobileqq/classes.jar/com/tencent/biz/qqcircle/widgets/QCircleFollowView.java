package com.tencent.biz.qqcircle.widgets;

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
import bhuf;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import tra;
import tyy;
import udv;
import udw;
import udx;
import udy;
import ydm;
import yiw;
import yiy;
import yxv;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, yiy
{
  private int jdField_a_of_type_Int;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
  private udx jdField_a_of_type_Udx;
  private udy jdField_a_of_type_Udy;
  private ydm jdField_a_of_type_Ydm;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
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
    a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleFollowView);
    this.jdField_b_of_type_Int = paramContext.getResourceId(0, 2130843548);
    this.jdField_a_of_type_Int = paramContext.getResourceId(2, 2130843547);
    this.jdField_c_of_type_Int = paramContext.getColor(1, getResources().getColor(2131165320));
    this.jdField_d_of_type_Int = paramContext.getColor(3, getResources().getColor(2131165307));
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
  
  private void d()
  {
    bhuf localbhuf = bhuf.a(getContext());
    localbhuf.a(getContext().getResources().getString(2131698394));
    localbhuf.a(2131690626, 0);
    localbhuf.c(2131690648);
    localbhuf.a(new udw(this, localbhuf));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
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
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(paramInt);
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
    if ((TextUtils.isEmpty(paramStUser.id.get())) || (tra.a(paramStUser))) {
      setVisibility(8);
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!tyy.a().a(paramStUser.id.get()));
      bool = tyy.a().b(paramStUser.id.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(tra.a(bool));
      a(tra.a(bool));
    } while (this.jdField_a_of_type_Udx == null);
    this.jdField_a_of_type_Udx.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(0);
    setBackgroundResource(this.jdField_b_of_type_Int);
    setTextColor(this.jdField_c_of_type_Int);
    setText(2131698327);
    if (this.jdField_d_of_type_Boolean)
    {
      if (paramBoolean) {
        c();
      }
    }
    else {
      return;
    }
    setVisibility(8);
  }
  
  protected void b()
  {
    setVisibility(0);
    setBackgroundResource(this.jdField_a_of_type_Int);
    setTextColor(this.jdField_d_of_type_Int);
    setText(2131698318);
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
      VSNetworkHelper.a().a(new QCircleDoFollowRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, i, null), new udv(this, i, paramBoolean));
      return;
    }
  }
  
  protected void c()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillEnabled(false);
    startAnimation(localAlphaAnimation);
    postDelayed(new QCircleFollowView.1(this), 500L);
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
      yiw.a().a(this);
    }
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Udy != null)) {
      this.jdField_a_of_type_Udy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
    }
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  public void onClick(View paramView)
  {
    if ((yxv.a("QCircleFollowViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Udy != null) {
        this.jdField_a_of_type_Udy.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
      }
      if (this.jdField_a_of_type_Ydm != null) {
        this.jdField_a_of_type_Ydm.a();
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 0) {
        b(true);
      }
    } while ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() != 1) || (this.jdField_c_of_type_Boolean));
    d();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
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
        if (this.jdField_a_of_type_Udx != null) {
          if (paramSimpleBaseEvent.mFollowStatus != 1) {
            break label96;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Udx.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      return;
      label96:
      bool = false;
    }
  }
  
  public void setFollowStateChangeListener(udx paramudx)
  {
    this.jdField_a_of_type_Udx = paramudx;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setFollowedDrawable(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setFollowedShowToast(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setFollowedTextColor(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setItemPreClickListener(ydm paramydm)
  {
    this.jdField_a_of_type_Ydm = paramydm;
  }
  
  public void setItemReportListener(udy paramudy)
  {
    this.jdField_a_of_type_Udy = paramudy;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setUnFollowTextColor(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.set(paramStUser.id.get());
      if ((TextUtils.isEmpty(paramStUser.id.get())) || (tra.a(paramStUser))) {
        setVisibility(8);
      }
    }
    else
    {
      return;
    }
    if (tyy.a().a(paramStUser.id.get()))
    {
      boolean bool = tyy.a().b(paramStUser.id.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(tra.a(bool));
      a(tra.a(bool));
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(paramStUser.followState.get());
    tyy.a().a(paramStUser.id.get(), tra.b(paramStUser));
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */