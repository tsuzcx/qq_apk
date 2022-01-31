package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import bdje;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import tqs;
import tra;
import tuk;
import twp;
import twy;
import twz;
import txa;
import txb;
import txc;
import txd;
import tyk;

public class QCircleContentOperationView
  extends BaseWidgetView<FeedCloudMeta.StFeed>
{
  private View jdField_a_of_type_AndroidViewView;
  protected ViewStub a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public LinearLayout a;
  public SeekBar a;
  protected TextView a;
  public QCircleCommentBottomBar a;
  protected QCircleAvatarView a;
  protected QCircleExpandableTextView a;
  protected QCircleFollowView a;
  public QCirclePolymorphicAniView a;
  public QCircleRockeyPopupView a;
  protected TagFlowLayout a;
  public SquareImageView a;
  private String jdField_a_of_type_JavaLangString;
  private twp jdField_a_of_type_Twp;
  protected TextView b;
  private String b;
  protected TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  private TextView g;
  
  public QCircleContentOperationView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    if ((a() != null) && (((FeedCloudMeta.StFeed)a()).poster.get() != null))
    {
      tqs.a(((FeedCloudMeta.StFeed)a()).poster.id.get());
      tyk.a(paramInt, 2, a());
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(new twy(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new twz(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new txa(this));
    txb localtxb = new txb(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setListener(new txc(this, localtxb));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.b().setOnClickListener(localtxb);
    this.g.setOnClickListener(new txd(this));
  }
  
  private void e()
  {
    if ((!b()) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(((FeedCloudMeta.StFeed)a()).content.get(), false);
    }
  }
  
  public int a()
  {
    return 2131560527;
  }
  
  public ReportExtraTypeInfo a()
  {
    ReportExtraTypeInfo localReportExtraTypeInfo = new ReportExtraTypeInfo();
    localReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)a());
    localReportExtraTypeInfo.mDataPosition = c();
    localReportExtraTypeInfo.mPlayScene = 2;
    return localReportExtraTypeInfo;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.a();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = ((QCirclePolymorphicAniView)paramView.findViewById(2131373173));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView = ((QCircleRockeyPopupView)paramView.findViewById(2131373189));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131368940));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379018));
    this.c = ((TextView)paramView.findViewById(2131379020));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131366606));
    this.jdField_a_of_type_JavaLangString = getResources().getString(2131698298);
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131698293);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView = ((QCircleExpandableTextView)paramView.findViewById(2131373200));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.b().setMovementMethod(ScrollingMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a().setTextColor(Color.parseColor("#435A7A"));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131369711));
    this.g = ((TextView)paramView.findViewById(2131378721));
    this.jdField_a_of_type_Twp = new twp(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Twp);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369710);
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar = ((QCircleCommentBottomBar)paramView.findViewById(2131364046));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380050));
    this.d = ((TextView)paramView.findViewById(2131378676));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131368843));
    this.e = ((TextView)paramView.findViewById(2131378675));
    this.f = ((TextView)paramView.findViewById(2131378999));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369717));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131376276));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366449));
    this.jdField_a_of_type_AndroidWidgetSeekBar.post(new QCircleContentOperationView.1(this));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setCommentPanelView((Activity)getContext(), this.jdField_a_of_type_AndroidViewViewStub);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843531);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(2);
    d();
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    int j = 8;
    if (paramStFeed == null) {
      return;
    }
    Object localObject;
    int i;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (bdje.a(paramStFeed.recomForward.poster.nick.get()))
      {
        i = 8;
        label43:
        ((TextView)localObject).setVisibility(i);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFeed.recomForward.poster.nick.get());
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, paramStFeed.poster);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramStFeed.poster.nick.get());
      }
      if (this.c != null) {
        this.c.setText(String.format("%s %s", new Object[] { tra.a(paramStFeed.createTime.get() * 1000L), paramStFeed.poiInfo.defaultName.get() }));
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView;
        if (!bdje.a(paramStFeed.content.get().trim())) {
          break label456;
        }
        i = 8;
        label207:
        ((QCircleExpandableTextView)localObject).setVisibility(i);
        ((AsyncRichTextView)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.b()).c();
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(paramStFeed.content.get());
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setExtraTypeInfo(a());
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setCurrentAniView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setCurrentFeed(paramStFeed);
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStFeed.poster);
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setFeedId(paramStFeed.id.get());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(2);
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = new ExtraTypeInfo();
        if ((paramStFeed.tagInfos.size() <= 0) || (((ExtraTypeInfo)localObject).sourceType == 7)) {
          break label461;
        }
        this.jdField_a_of_type_Twp.a(paramStFeed);
        this.jdField_a_of_type_Twp.notifyDataSetChanged();
        if (this.g != null)
        {
          localObject = this.g;
          i = j;
          if (this.jdField_a_of_type_Twp.a()) {
            i = 0;
          }
          ((TextView)localObject).setVisibility(i);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      switch (paramStFeed.type.get())
      {
      default: 
        return;
      case 2: 
        b(paramStFeed);
        return;
        i = 0;
        break label43;
        label456:
        i = 0;
        break label207;
        label461:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    b();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.a());
  }
  
  public void b()
  {
    if (this.d != null) {
      this.d.setVisibility(8);
    }
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed)
  {
    int i = 8;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.d != null)
    {
      TextView localTextView = this.d;
      if (paramStFeed.images.size() > 1) {
        i = 0;
      }
      localTextView.setVisibility(i);
      this.d.setText(String.format("1/%s", new Object[] { Integer.valueOf(paramStFeed.images.size()) }));
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a();
    }
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.a() != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.a().a(false);
    }
    e();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView
 * JD-Core Version:    0.7.0.1
 */