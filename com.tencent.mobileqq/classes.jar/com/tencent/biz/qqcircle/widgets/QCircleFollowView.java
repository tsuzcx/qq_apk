package com.tencent.biz.qqcircle.widgets;

import aabv;
import aauy;
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
import bkho;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import uxx;
import vof;
import vxb;
import vxc;
import vxd;
import vxe;
import zwp;
import zwr;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, zwr
{
  private int jdField_a_of_type_Int;
  private aabv jdField_a_of_type_Aabv;
  public FeedCloudMeta.StUser a;
  private String jdField_a_of_type_JavaLangString;
  private vxd jdField_a_of_type_Vxd;
  private vxe jdField_a_of_type_Vxe;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
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
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleFollowView);
    this.jdField_b_of_type_Int = paramContext.getResourceId(0, 2130843896);
    this.jdField_a_of_type_Int = paramContext.getResourceId(2, 2130843895);
    this.jdField_c_of_type_Int = paramContext.getColor(1, getResources().getColor(2131165356));
    this.jdField_d_of_type_Int = paramContext.getColor(3, getResources().getColor(2131166241));
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
    bkho localbkho = bkho.a(getContext());
    localbkho.a(getContext().getResources().getString(2131697275));
    localbkho.a(2131697276, 3);
    localbkho.c(2131690582);
    localbkho.a(new vxc(this, localbkho));
    if (!localbkho.isShowing()) {
      localbkho.show();
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
    if ((TextUtils.isEmpty(paramStUser.id.get())) || (uxx.a(paramStUser))) {
      setVisibility(8);
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!vof.a().a(paramStUser.id.get()));
      bool = vof.a().b(paramStUser.id.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(uxx.a(bool));
      a(uxx.a(bool));
    } while (this.jdField_a_of_type_Vxd == null);
    this.jdField_a_of_type_Vxd.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      setBackgroundDrawable(a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString));
    }
    for (;;)
    {
      setTextColor(this.jdField_c_of_type_Int);
      setText(2131697170);
      if (this.jdField_d_of_type_Boolean)
      {
        if (!paramBoolean) {
          break;
        }
        c();
      }
      return;
      setBackgroundResource(this.jdField_b_of_type_Int);
    }
    setVisibility(8);
  }
  
  protected void b()
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      setBackgroundDrawable(a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      setTextColor(this.jdField_d_of_type_Int);
      setText(2131697160);
      return;
      setBackgroundResource(this.jdField_a_of_type_Int);
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
      VSNetworkHelper.a().a(new QCircleDoFollowRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, j, localStCommonExt), new vxb(this, j, i));
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
      zwp.a().a(this);
    }
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_Vxe != null)) {
      this.jdField_a_of_type_Vxe.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
    }
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
  }
  
  public void onClick(View paramView)
  {
    if ((aauy.a("QCircleFollowViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Vxe != null) {
        this.jdField_a_of_type_Vxe.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get());
      }
      if (this.jdField_a_of_type_Aabv != null) {
        this.jdField_a_of_type_Aabv.a();
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 0) {
        b(true);
      } else if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 1) && (!this.jdField_c_of_type_Boolean)) {
        d();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
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
        if (this.jdField_a_of_type_Vxd != null) {
          if (paramSimpleBaseEvent.mFollowStatus != 1) {
            break label96;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Vxd.a(bool, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      return;
      label96:
      bool = false;
    }
  }
  
  public void setFollowStateChangeListener(vxd paramvxd)
  {
    this.jdField_a_of_type_Vxd = paramvxd;
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
  
  public void setItemPreClickListener(aabv paramaabv)
  {
    this.jdField_a_of_type_Aabv = paramaabv;
  }
  
  public void setItemReportListener(vxe paramvxe)
  {
    this.jdField_a_of_type_Vxe = paramvxe;
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
    this.jdField_d_of_type_Int = paramInt;
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
      if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!uxx.a(paramStUser))) {
        break label70;
      }
      setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
      label70:
      if (vof.a().a(paramStUser.id.get()))
      {
        boolean bool = vof.a().b(paramStUser.id.get());
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(uxx.a(bool));
        a(uxx.a(bool));
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