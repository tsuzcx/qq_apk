package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import bhpy;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import tra;
import txt;
import ube;
import ubf;
import ubg;
import ubh;
import xzd;
import yej;
import yel;
import ytg;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, yel
{
  private static final String jdField_a_of_type_JavaLangString = QCircleFollowView.class.getSimpleName();
  private int jdField_a_of_type_Int = 2130843532;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
  private ubg jdField_a_of_type_Ubg;
  private ubh jdField_a_of_type_Ubh;
  private xzd jdField_a_of_type_Xzd;
  protected boolean a;
  private int jdField_b_of_type_Int = 2130843533;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = getResources().getColor(2131165320);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = getResources().getColor(2131165307);
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
    bhpy localbhpy = bhpy.a(getContext());
    localbhpy.a(getContext().getResources().getString(2131698382));
    localbhpy.a(2131690626, 0);
    localbhpy.c(2131690648);
    localbhpy.a(new ubf(this, localbhpy));
    if (!localbhpy.isShowing()) {
      localbhpy.show();
    }
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
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
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get().equals(paramSimpleBaseEvent.mUserId)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() != paramSimpleBaseEvent.mFollowStatus))
      {
        a(paramSimpleBaseEvent.mFollowStatus);
        if (this.jdField_a_of_type_Ubg != null) {
          if (paramSimpleBaseEvent.mFollowStatus != 1) {
            break label96;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ubg.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      return;
      label96:
      bool = false;
    }
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
      } while (!txt.a().a(paramStUser.id.get()));
      bool = txt.a().b(paramStUser.id.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(tra.a(bool));
      a(tra.a(bool));
    } while (this.jdField_a_of_type_Ubg == null);
    this.jdField_a_of_type_Ubg.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(0);
    setBackgroundResource(this.jdField_b_of_type_Int);
    setTextColor(this.jdField_c_of_type_Int);
    setText(2131698318);
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
    setText(2131698315);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "follow");
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "follow user failed! user is null");
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      VSNetworkHelper.a().a(new QCircleDoFollowRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, i, null), new ube(this, i, paramBoolean));
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      yej.a().a(this);
    }
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Ubh != null)) {
      this.jdField_a_of_type_Ubh.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
    }
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  public void onClick(View paramView)
  {
    if ((ytg.a("QCircleFollowViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Ubh != null) {
        this.jdField_a_of_type_Ubh.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
      }
      if (this.jdField_a_of_type_Xzd != null) {
        this.jdField_a_of_type_Xzd.a();
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
    yej.a().b(this);
  }
  
  public void setFollowStateChangeListener(ubg paramubg)
  {
    this.jdField_a_of_type_Ubg = paramubg;
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
  
  public void setItemPreClickListener(xzd paramxzd)
  {
    this.jdField_a_of_type_Xzd = paramxzd;
  }
  
  public void setItemReportListener(ubh paramubh)
  {
    this.jdField_a_of_type_Ubh = paramubh;
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
    if (txt.a().a(paramStUser.id.get()))
    {
      boolean bool = txt.a().b(paramStUser.id.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(tra.a(bool));
      a(tra.a(bool));
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(paramStUser.followState.get());
    txt.a().a(paramStUser.id.get(), tra.b(paramStUser));
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */