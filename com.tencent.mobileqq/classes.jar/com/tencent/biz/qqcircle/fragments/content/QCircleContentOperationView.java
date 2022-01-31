package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import bdnn;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import tqs;
import tra;
import tuz;
import txg;
import txt;
import txu;
import txv;
import txw;
import txx;
import txy;
import tzw;
import tzy;

public class QCircleContentOperationView
  extends BaseWidgetView<FeedCloudMeta.StFeed>
{
  public static int a;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public LinearLayout a;
  public SeekBar a;
  protected TextView a;
  protected QCircleCommentBottomBar a;
  protected QCircleAvatarView a;
  public QCircleDoublePraiseView a;
  protected QCircleExpandableTextView a;
  protected QCircleFollowView a;
  public QCircleRockeyPopupView a;
  protected TagFlowLayout a;
  public SquareImageView a;
  private String jdField_a_of_type_JavaLangString;
  private txg jdField_a_of_type_Txg;
  public int b;
  protected TextView b;
  private String b;
  protected TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  private TextView g;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public QCircleContentOperationView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    if ((a() != null) && (((FeedCloudMeta.StFeed)a()).poster.get() != null))
    {
      tqs.a(((FeedCloudMeta.StFeed)a()).poster.id.get());
      tzw.a(paramInt, 2, a());
    }
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    int i = 0;
    if (paramStFeed == null) {
      return;
    }
    label36:
    int j;
    switch (paramStFeed.type.get())
    {
    default: 
      j = 0;
    }
    while ((i > 0) && (j > 0))
    {
      int k = ImmersiveUtils.a();
      float f1 = k / j;
      i = (int)(i * f1);
      paramStFeed = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.getLayoutParams();
      paramStFeed.width = k;
      paramStFeed.height = i;
      paramStFeed.gravity = 17;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setLayoutParams(paramStFeed);
      return;
      if ((this.jdField_b_of_type_Int < 0) || (this.jdField_b_of_type_Int >= paramStFeed.images.size())) {
        break label36;
      }
      paramStFeed = (FeedCloudMeta.StImage)((FeedCloudMeta.StImage)paramStFeed.images.get(this.jdField_b_of_type_Int)).get();
      j = paramStFeed.width.get();
      i = paramStFeed.height.get();
      continue;
      j = paramStFeed.cover.width.get();
      i = paramStFeed.cover.height.get();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(new txt(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new txu(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new txv(this));
    txw localtxw = new txw(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setListener(new txx(this, localtxw));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.b().setOnClickListener(localtxw);
    this.g.setOnClickListener(new txy(this));
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
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView = ((QCircleRockeyPopupView)paramView.findViewById(2131373240));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379059));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131368958));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379076));
    this.c = ((TextView)paramView.findViewById(2131379078));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131366612));
    this.jdField_a_of_type_JavaLangString = getResources().getString(2131698301);
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131698296);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView = ((QCircleExpandableTextView)paramView.findViewById(2131373252));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.b().setMovementMethod(ScrollingMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a().setTextColor(Color.parseColor("#435A7A"));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131369730));
    this.g = ((TextView)paramView.findViewById(2131378775));
    this.jdField_a_of_type_Txg = new txg(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_Txg);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369729);
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar = ((QCircleCommentBottomBar)paramView.findViewById(2131364048));
    this.d = ((TextView)paramView.findViewById(2131378730));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131368858));
    this.e = ((TextView)paramView.findViewById(2131378729));
    this.f = ((TextView)paramView.findViewById(2131379057));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369736));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131376330));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366454));
    this.jdField_a_of_type_AndroidWidgetSeekBar.post(new QCircleContentOperationView.1(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843544);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView = ((QCircleDoublePraiseView)paramView.findViewById(2131373158));
    d();
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    int j = 8;
    if (paramStFeed == null) {}
    label513:
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (bdnn.a(paramStFeed.recomForward.poster.nick.get()))
        {
          i = 8;
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
          if (!bdnn.a(paramStFeed.content.get().trim())) {
            break label483;
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
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setInteractor(a());
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setData(paramStFeed);
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
            break label488;
          }
          this.jdField_a_of_type_Txg.a(paramStFeed);
          this.jdField_a_of_type_Txg.notifyDataSetChanged();
          if (this.g != null)
          {
            localObject = this.g;
            i = j;
            if (this.jdField_a_of_type_Txg.a()) {
              i = 0;
            }
            ((TextView)localObject).setVisibility(i);
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        label416:
        switch (paramStFeed.type.get())
        {
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView == null) {
          break label513;
        }
        c(paramStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setFeed(paramStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setPageType(tzy.a().a());
        return;
        i = 0;
        break;
        label483:
        i = 0;
        break label207;
        label488:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label416;
        b(paramStFeed);
        continue;
        b();
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.a());
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      return this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
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
      setCurPicPos(0, paramStFeed.images.size());
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
    this.jdField_b_of_type_Int = 0;
    e();
    if ((this.jdField_a_of_type_Txg != null) && (!this.jdField_a_of_type_Txg.a())) {
      this.jdField_a_of_type_Txg.a();
    }
    if (this.g != null) {
      this.g.setText(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setCurPicPos(int paramInt1, int paramInt2)
  {
    if (this.d != null)
    {
      if (jdField_a_of_type_Int <= 0) {
        break label61;
      }
      this.jdField_b_of_type_Int = jdField_a_of_type_Int;
      jdField_a_of_type_Int = -1;
    }
    for (;;)
    {
      this.d.setText(String.format("%s/%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int + 1), Integer.valueOf(paramInt2) }));
      return;
      label61:
      this.jdField_b_of_type_Int = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView
 * JD-Core Version:    0.7.0.1
 */