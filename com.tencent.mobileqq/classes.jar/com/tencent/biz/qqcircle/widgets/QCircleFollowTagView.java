package com.tencent.biz.qqcircle.widgets;

import aabv;
import aauy;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bglp;
import bgpa;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowTagRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;
import uxx;
import vot;
import vwv;
import vww;
import vwx;
import vwy;
import vwz;

public class QCircleFollowTagView
  extends TextView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = QCircleFollowTagView.class.getSimpleName();
  private int jdField_a_of_type_Int = 2130843895;
  private aabv jdField_a_of_type_Aabv;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = new FeedCloudMeta.StTagInfo();
  private vwy jdField_a_of_type_Vwy;
  private vwz jdField_a_of_type_Vwz;
  protected boolean a;
  private int jdField_b_of_type_Int = 2130843896;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public QCircleFollowTagView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFollowTagView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleFollowTagView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_tag_follow_state");
    localIntent.putExtra("tagId", paramString);
    localIntent.putExtra("followstate", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void d()
  {
    bglp.a(getContext(), 230, getContext().getResources().getString(2131697275), null, 2131690582, 2131690566, new vww(this), new vwx(this)).show();
  }
  
  protected void a()
  {
    setOnClickListener(this);
    c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.set(paramInt);
    }
    if (paramInt == 1)
    {
      c();
      return;
    }
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "follow tag failed! mTagInfo == null");
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      QCircleDoFollowTagRequest localQCircleDoFollowTagRequest = new QCircleDoFollowTagRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get(), i, null);
      VSNetworkHelper.a().a(localQCircleDoFollowTagRequest, new vwv(this, i, paramBoolean));
      return;
      i = 0;
    }
  }
  
  protected void b()
  {
    setVisibility(0);
    setBackgroundResource(this.jdField_a_of_type_Int);
    setTextColor(getResources().getColor(2131165343));
    setText(2131697160);
  }
  
  protected void c()
  {
    setVisibility(0);
    setBackgroundResource(this.jdField_b_of_type_Int);
    setTextColor(getResources().getColor(2131165356));
    setText(2131697170);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    if ((aauy.a("QCircleFollowTagViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Vwz != null) {
        this.jdField_a_of_type_Vwz.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get());
      }
      if (this.jdField_a_of_type_Aabv != null) {
        this.jdField_a_of_type_Aabv.a();
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get() == 0) {
        a(true);
      }
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get() == 1) && (!this.jdField_b_of_type_Boolean)) {
        d();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setFollowStateChangeListener(vwy paramvwy)
  {
    this.jdField_a_of_type_Vwy = paramvwy;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setFollowedDrawable(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setFollowedShowToast(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setItemPreClickListener(aabv paramaabv)
  {
    this.jdField_a_of_type_Aabv = paramaabv;
  }
  
  public void setItemReportListener(vwz paramvwz)
  {
    this.jdField_a_of_type_Vwz = paramvwz;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTagInfo(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    boolean bool = true;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.set(paramStTagInfo.tagId.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.set(paramStTagInfo.tagName.get());
    if (vot.a().a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get()))
    {
      bool = vot.a().b(paramStTagInfo.tagId.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.set(uxx.a(bool));
      a(uxx.a(bool));
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.set(paramStTagInfo.followState.get());
    vot localvot = vot.a();
    String str = paramStTagInfo.tagId.get();
    if (paramStTagInfo.followState.get() == 1) {}
    for (;;)
    {
      localvot.a(str, bool);
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get());
      return;
      bool = false;
    }
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowTagView
 * JD-Core Version:    0.7.0.1
 */