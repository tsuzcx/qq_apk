package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anni;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import uxk;
import uxo;
import uxx;
import uyy;
import uzb;
import vrc;
import vrf;
import vsn;
import wam;
import war;
import was;
import wav;
import waw;
import zby;
import zvp;
import zzh;

public class QCircleTimeLineFeedItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener, zvp
{
  public static final int a;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private Object jdField_a_of_type_JavaLangObject;
  private wam jdField_a_of_type_Wam;
  private waw jdField_a_of_type_Waw;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_Int = (int)(ImmersiveUtils.a() * 0.3D);
  }
  
  public QCircleTimeLineFeedItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private List<FeedCloudMeta.StImage> a(FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramStFeed.type.get() == 3) {
      localArrayList.add(paramStFeed.cover.get());
    }
    int i;
    int j;
    do
    {
      return localArrayList;
      i = paramStFeed.images.size();
      j = Math.min(4, i);
    } while (i <= 0);
    localArrayList.addAll(paramStFeed.images.get().subList(0, j));
    return localArrayList;
  }
  
  private List<wav> a(List<FeedCloudMeta.StImage> paramList, int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    int j = -1;
    ArrayList localArrayList = new ArrayList();
    int k = paramList.size();
    int i = 0;
    while (i < k - 1)
    {
      localArrayList.add(new wav(this, (FeedCloudMeta.StImage)paramList.get(i), paramInt, paramStFeed.type.get(), -1));
      i += 1;
    }
    i = j;
    if (paramStFeed.images.size() > k) {
      i = paramStFeed.images.size();
    }
    localArrayList.add(new wav(this, (FeedCloudMeta.StImage)paramList.get(k - 1), paramInt, paramStFeed.type.get(), i));
    return localArrayList;
  }
  
  private void a(long paramLong)
  {
    if (c() == 1001)
    {
      if ((this.jdField_a_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidViewViewStub != null))
      {
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379950));
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(paramLong);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localCalendar.get(1));
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      Calendar localCalendar;
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    if ((a() != null) && ((a() instanceof uzb)) && ((a() instanceof FeedCloudMeta.StFeed)))
    {
      localStFeed = (FeedCloudMeta.StFeed)a();
      if (QCircleFakeAdapter.a(localStFeed)) {
        QQToast.a(getContext(), 0, 2131697243, 0).a();
      }
    }
    else
    {
      return;
    }
    Object localObject = (uzb)a();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.tabAttachInfo.set(((uzb)localObject).a());
    localObject = ((uzb)localObject).a();
    if (localObject != null)
    {
      localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
      localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
    }
    localObject = new uxk();
    ((uxk)localObject).a(localStFeed);
    ((uxk)localObject).a(a().pageType);
    ((uxk)localObject).a(localStFeedListBusiReqData);
    ((uxk)localObject).b(paramInt);
    ((uxk)localObject).a(a().clone().setElementIdStr("content"));
    if (paramImageView != null) {
      uxo.a(getContext(), ((uxk)localObject).a(), vsn.a(paramImageView, paramImageView.getWidth(), paramImageView.getHeight()));
    }
    for (;;)
    {
      paramImageView = new ReportExtraTypeInfo();
      paramImageView.mFeed = localStFeed;
      paramImageView.mPlayScene = 1;
      vrc.a(7, 2, paramImageView, d());
      return;
      uxo.a(getContext(), ((uxk)localObject).a(), new Intent());
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed.createTime.get() * 1000L);
    if ((c() == 1001) || (c() == 1002))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      b(paramStFeed.createTime.get() * 1000L);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void b(long paramLong)
  {
    StringBuilder localStringBuilder;
    Object localObject;
    int i;
    int j;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramLong);
      Calendar localCalendar = Calendar.getInstance();
      if (localCalendar.get(1) != ((Calendar)localObject).get(1)) {
        break label319;
      }
      i = localCalendar.get(6);
      j = ((Calendar)localObject).get(6);
      if (i != j) {
        break label237;
      }
      localStringBuilder.append(anni.a(2131718632));
      i = 0;
    }
    label319:
    for (;;)
    {
      j = localStringBuilder.length();
      if (i == 0) {
        break;
      }
      localStringBuilder.append("/" + (((Calendar)localObject).get(2) + 1));
      i = localStringBuilder.length();
      localStringBuilder.append(getResources().getString(2131689474));
      localObject = new SpannableString(localStringBuilder);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(zby.b(getContext(), 26.0F)), 0, j, 33);
      ((SpannableString)localObject).setSpan(new QCircleTimeLineFeedItemView.3(this, 1), 0, i, 33);
      ((SpannableString)localObject).setSpan(new StyleSpan(1), i, localStringBuilder.length(), 33);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
      label237:
      if (i - 1 == j)
      {
        localStringBuilder.append(anni.a(2131719211));
        i = 0;
      }
      else if (i - 2 == j)
      {
        localStringBuilder.append(anni.a(2131690491));
        i = 0;
      }
      else
      {
        localStringBuilder.append(new SimpleDateFormat("dd").format(new Date(paramLong)));
        i = 1;
        continue;
        localStringBuilder.append(new SimpleDateFormat("dd").format(new Date(paramLong)));
        i = 1;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(paramStFeed.content.get(), new was(this));
  }
  
  public int a()
  {
    return 2131560707;
  }
  
  public String a()
  {
    return "QCircleTimeLineFeedItemView";
  }
  
  public wam a()
  {
    return this.jdField_a_of_type_Wam;
  }
  
  public void a() {}
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379949));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131379948));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376862));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new zzh(getContext(), zby.b(getContext(), 1.0F), 2131167224));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370092));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131381075));
    this.jdField_a_of_type_Waw = new waw(this);
    this.jdField_a_of_type_Waw.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Waw.setHasStableIds(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Waw);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 2);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.setSpanSizeLookup(new war(this));
    if (uyy.a)
    {
      this.jdField_a_of_type_Wam = new wam();
      this.jdField_a_of_type_Wam.a((ViewStub)paramView.findViewById(2131380919));
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_b_of_type_Int = paramInt;
    FeedCloudMeta.StFeed localStFeed;
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      localStFeed = (FeedCloudMeta.StFeed)paramObject;
      a(localStFeed);
      b(localStFeed);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      if ((this.jdField_a_of_type_Wam != null) && (this.jdField_a_of_type_Wam.a() != null)) {
        this.jdField_a_of_type_Wam.a().setVisibility(8);
      }
      if ((localStFeed.type.get() != 3) || (!uyy.a)) {
        break label165;
      }
      if (this.jdField_a_of_type_Wam != null)
      {
        if ((a() instanceof uzb)) {
          this.jdField_a_of_type_Wam.a((uzb)a());
        }
        this.jdField_a_of_type_Wam.a().setVisibility(0);
        this.jdField_a_of_type_Wam.a(a());
        this.jdField_a_of_type_Wam.a(paramObject, paramInt);
        this.jdField_a_of_type_Wam.a(getTag(), paramObject);
      }
    }
    label165:
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {
      return;
    }
    paramObject = a(localStFeed);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams();
    paramInt = 1001;
    if (paramObject.size() == 1)
    {
      localLayoutParams.height = (jdField_a_of_type_Int * 2);
      paramInt = 1002;
    }
    for (;;)
    {
      localLayoutParams.width = (jdField_a_of_type_Int * 2);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_a_of_type_Waw.a(localStFeed, this.jdField_b_of_type_Int, a(paramObject, paramInt, localStFeed));
      return;
      if (paramObject.size() == 2) {
        localLayoutParams.height = jdField_a_of_type_Int;
      } else {
        localLayoutParams.height = (jdField_a_of_type_Int * 2);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
      }
      if ((this.jdField_a_of_type_Wam != null) && (this.jdField_a_of_type_Wam.a() != null)) {
        this.jdField_a_of_type_Wam.a().setVisibility(4);
      }
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str2 = uxx.a(getContext());
    if (uxx.a(getContext())) {}
    for (String str1 = "1";; str1 = "2")
    {
      vrf.a(str2, 11, 19, 2, str1, "", "", "", "");
      a(null, 0);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView
 * JD-Core Version:    0.7.0.1
 */