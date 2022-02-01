package com.tencent.biz.qqcircle.fragments.content;

import aaak;
import aaam;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import bdep;
import bhsr;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;
import uyx;
import uzg;
import var;
import vlq;
import vmk;
import vml;
import vmm;
import vmn;
import vmo;
import vmp;
import vmq;
import vmr;
import vms;
import vmt;
import vmu;
import vmv;
import vtr;
import vtt;

public class QCircleContentOperationView
  extends QCircleBaseWidgetView<FeedCloudMeta.StFeed>
  implements aaam
{
  public static int a;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  public View a;
  public FrameLayout a;
  public LinearLayout a;
  public SeekBar a;
  protected TextView a;
  protected QCircleCommentBottomBar a;
  protected QCircleAvatarView a;
  public QCircleDoublePraiseView a;
  protected QCircleExpandableTextView a;
  protected QCircleFollowView a;
  private QCircleMaxHeightScrollView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMaxHeightScrollView;
  public QCircleRocketView a;
  private vlq jdField_a_of_type_Vlq;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  public FrameLayout b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected TextView b;
  private FrameLayout c;
  protected TextView c;
  public TextView d;
  private int e;
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
    this.jdField_e_of_type_Int = 2;
  }
  
  private int a(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramView != null)
    {
      i = paramInt;
      if (paramView.getVisibility() == 0)
      {
        i = paramInt;
        if (paramInt <= paramView.getHeight() + bdep.a(39.0F)) {
          i = paramView.getHeight() + bdep.a(47.0F);
        }
      }
    }
    return i;
  }
  
  private void a(int paramInt)
  {
    if ((a() != null) && (((FeedCloudMeta.StFeed)a()).poster.get() != null))
    {
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUin(((FeedCloudMeta.StFeed)a()).poster.id.get());
      localQCircleInitBean.setFromReportBean(a().clone().setElementIdStr("portrait"));
      uyx.b(getContext(), localQCircleInitBean);
      vtr.a(paramInt, 2, a(), e());
    }
  }
  
  private void a(int paramInt, List<FeedCloudMeta.StImage> paramList)
  {
    Object localObject;
    if (paramList.size() > this.jdField_b_of_type_Int)
    {
      paramList = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      localObject = (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
      paramInt = bdep.a(42.0F);
      if (localObject == null) {
        break label139;
      }
      if (!((QCircleInitBean)localObject).getTagInfo().has()) {
        break label108;
      }
      paramInt = a(((Activity)getContext()).findViewById(2131376860), paramInt);
    }
    label139:
    for (;;)
    {
      paramList.setMargins(bdep.a(20.0F), paramInt, paramList.rightMargin, paramList.bottomMargin);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramList);
      return;
      label108:
      if (((QCircleInitBean)localObject).getPoiInfo().has())
      {
        paramInt = a(((Activity)getContext()).findViewById(2131376808), paramInt);
        continue;
        if (((QCircleInitBean)localObject).getPoiInfo().has())
        {
          localObject = ((Activity)getContext()).findViewById(2131376808);
          if ((localObject != null) && (((View)localObject).getVisibility() == 0) && (paramInt <= ((View)localObject).getHeight() + bdep.a(39.0F))) {
            paramInt = ((View)localObject).getHeight() + bdep.a(42.0F) + bdep.a(5.0F);
          }
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Vlq = new vlq();
    this.jdField_a_of_type_Vlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMaxHeightScrollView);
    this.jdField_a_of_type_Vlq.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Vlq.a(this.jdField_b_of_type_AndroidWidgetLinearLayout);
  }
  
  private boolean c()
  {
    if (a() != null) {
      return 2 == ((FeedCloudMeta.StFeed)a()).type.get();
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(new vmp(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vmq(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new vmr(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new vms(this));
    vmt localvmt = new vmt(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setListener(new vmu(this, localvmt));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a().setOnClickListener(localvmt);
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new vmv(this));
    }
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
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
  
  private void e()
  {
    if ((!b()) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(((FeedCloudMeta.StFeed)a()).content.get(), false, new vml(this));
    }
  }
  
  public int a()
  {
    return 2131560703;
  }
  
  public ReportExtraTypeInfo a()
  {
    ReportExtraTypeInfo localReportExtraTypeInfo = new ReportExtraTypeInfo();
    localReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)a());
    localReportExtraTypeInfo.mDataPosition = f();
    localReportExtraTypeInfo.mPlayScene = this.jdField_e_of_type_Int;
    return localReportExtraTypeInfo;
  }
  
  public String a()
  {
    return "QCircleContentOperationView";
  }
  
  public void a()
  {
    if ((a() instanceof var)) {
      ((var)a()).a("comment_panel_dismiss", null);
    }
    this.jdField_b_of_type_Int = 0;
    e();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView = ((QCircleRocketView)paramView.findViewById(2131374056));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369432));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380179));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363654);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380181));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380035));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131366928));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView = ((QCircleExpandableTextView)paramView.findViewById(2131374087));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setClickAreaTextColor(-1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMaxHeightScrollView = ((QCircleMaxHeightScrollView)paramView.findViewById(2131374189));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMaxHeightScrollView.setMaxHeight((int)(ImmersiveUtils.b() * 0.6F));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar = ((QCircleCommentBottomBar)paramView.findViewById(2131364297));
    this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131374024));
    this.d = ((TextView)paramView.findViewById(2131374025));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366756));
    this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams().width = (ImmersiveUtils.a() * 3 / 5);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams().height = (ImmersiveUtils.a() * 2 / 5);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379768));
    this.f = ((TextView)paramView.findViewById(2131380157));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370264));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131377250));
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366767));
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new vmk(this));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373913);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView.setPageType(2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView = ((QCircleDoublePraiseView)paramView.findViewById(2131373916));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373993));
    this.g = ((TextView)paramView.findViewById(2131373994));
    d();
    c();
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    label138:
    label169:
    label432:
    label451:
    for (;;)
    {
      return;
      aaak.a().a(this);
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, paramStFeed.poster);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFeed.poster.nick.get());
      }
      Object localObject = paramStFeed.opMask2.get();
      int i;
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        if ((localObject != null) && (((List)localObject).contains(Integer.valueOf(9)))) {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          if (!TextUtils.isEmpty(paramStFeed.recomInfo.recomReason.get())) {
            break label404;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView;
          if (!bhsr.a(paramStFeed.content.get().trim())) {
            break label432;
          }
          i = 8;
          ((QCircleExpandableTextView)localObject).setVisibility(i);
          this.jdField_a_of_type_Vlq.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView);
          ((AsyncRichTextView)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a()).c();
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(paramStFeed.content.get(), new vmo(this));
        }
        if (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setExtraTypeInfo(a());
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setInteractor(a());
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setData(paramStFeed);
        }
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView != null) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStFeed.poster, paramStFeed.id.get());
        }
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView.setFeedId(paramStFeed.id.get());
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView.setPageType(2);
        }
        switch (paramStFeed.type.get())
        {
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView == null) {
          break label451;
        }
        d(paramStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setFeed(paramStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setPageType(d());
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(uzg.a(paramStFeed.createTime.get() * 1000L));
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramStFeed.recomInfo.recomReason.get());
        break label138;
        i = 0;
        break label169;
        b(paramStFeed);
        continue;
        c(paramStFeed);
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.a());
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetFrameLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      return this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.b();
    }
    if (this.jdField_a_of_type_Vlq != null)
    {
      this.jdField_a_of_type_Vlq.a();
      this.jdField_a_of_type_Vlq = null;
    }
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed)
  {
    int i = 8;
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (paramStFeed.images.size() > 1) {
        i = 0;
      }
      ((FrameLayout)localObject).setVisibility(i);
      setCurPicPos(0, paramStFeed.images.get());
    }
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.g != null) && (this.jdField_b_of_type_Int < paramStFeed.images.size())) {}
    for (;;)
    {
      try
      {
        localObject = new QQCircleFeedBase.StImageBusiData();
        ((QQCircleFeedBase.StImageBusiData)localObject).mergeFrom(((FeedCloudMeta.StImage)paramStFeed.images.get(this.jdField_b_of_type_Int)).busiData.get().toByteArray());
        if ((((QQCircleFeedBase.StImageBusiData)localObject).simulate_date != null) && (((QQCircleFeedBase.StImageBusiData)localObject).simulate_date.is_show_button.get() == 1) && (Build.VERSION.SDK_INT >= 21))
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.g.setText(((QQCircleFeedBase.StImageBusiData)localObject).simulate_date.simulate_name.get() + "    ");
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new vmm(this, (QQCircleFeedBase.StImageBusiData)localObject));
          localObject = a();
          if (c())
          {
            paramStFeed = "1";
            vtr.a(83, 1, (ExtraTypeInfo)localObject, new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ext1", paramStFeed) })), e());
            this.jdField_a_of_type_Vlq.a(this.jdField_b_of_type_AndroidWidgetLinearLayout);
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          continue;
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        QLog.e("QCircleContentOperationView", 1, "exception:", paramStFeed);
      }
      paramStFeed = "2";
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a();
    }
    return false;
  }
  
  public void c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    if ((this.jdField_c_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_c_of_type_AndroidWidgetFrameLayout.getVisibility() == 8)) {
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.g != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = new QQCircleFeedBase.StVideoBusiData();
        ((QQCircleFeedBase.StVideoBusiData)localObject).mergeFrom(paramStFeed.video.busiData.get().toByteArray());
        if ((((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date != null) && (((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.is_show_button.get() == 1) && (Build.VERSION.SDK_INT >= 21))
        {
          this.g.setText(((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.simulate_name.get() + "    ");
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new vmn(this, (QQCircleFeedBase.StVideoBusiData)localObject));
          localObject = a();
          if (c())
          {
            paramStFeed = "1";
            vtr.a(83, 1, (ExtraTypeInfo)localObject, new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ext1", paramStFeed) })), e());
            this.jdField_a_of_type_Vlq.a(this.jdField_b_of_type_AndroidWidgetLinearLayout);
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          continue;
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        QLog.e("QCircleContentOperationView", 1, "exception:", paramStFeed);
      }
      paramStFeed = "2";
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleContentImmersiveEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    aaak.a().a(this);
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Vlq != null)
    {
      if (QCircleContentImmersiveEvent.isImmersive()) {
        this.jdField_a_of_type_Vlq.a(3);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      if (!c()) {
        break label90;
      }
    }
    label90:
    for (String str = "1";; str = "2")
    {
      localArrayList.add(vtt.a("ext1", str));
      vtr.a(81, 1, a(), localArrayList, e());
      return;
      this.jdField_a_of_type_Vlq.a(2);
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleContentImmersiveEvent)) && (this.jdField_a_of_type_Vlq != null)) {
      this.jdField_a_of_type_Vlq.a((QCircleContentImmersiveEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setCurPicPos(int paramInt, List<FeedCloudMeta.StImage> paramList)
  {
    if (this.d != null)
    {
      if (jdField_a_of_type_Int <= 0) {
        break label72;
      }
      this.jdField_b_of_type_Int = jdField_a_of_type_Int;
      jdField_a_of_type_Int = -1;
    }
    for (;;)
    {
      this.d.setText(this.jdField_b_of_type_Int + 1 + "/" + paramList.size());
      a(paramInt, paramList);
      return;
      label72:
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void setCurrentHorizontalVH(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
  }
  
  public void setPlayScene(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    if (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleCommentBottomBar.setReportBean(a());
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setReportBean(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView
 * JD-Core Version:    0.7.0.1
 */