package com.tencent.biz.qqcircle.widgets.feed;

import aadd;
import android.content.Context;
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
import anzj;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
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
import uyx;
import uzg;
import val;
import var;
import vtn;
import vtq;
import vvh;
import wec;
import weh;
import wei;
import wel;
import wem;
import zft;
import zzk;

public class QCircleTimeLineFeedItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener, zzk
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
  private wec jdField_a_of_type_Wec;
  private wem jdField_a_of_type_Wem;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
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
  
  private List<wel> a(List<FeedCloudMeta.StImage> paramList, int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    int j = -1;
    ArrayList localArrayList = new ArrayList();
    int k = paramList.size();
    int i = 0;
    while (i < k - 1)
    {
      localArrayList.add(new wel(this, (FeedCloudMeta.StImage)paramList.get(i), paramInt, paramStFeed.type.get(), -1));
      i += 1;
    }
    i = j;
    if (paramStFeed.images.size() > k) {
      i = paramStFeed.images.size();
    }
    localArrayList.add(new wel(this, (FeedCloudMeta.StImage)paramList.get(k - 1), paramInt, paramStFeed.type.get(), i));
    return localArrayList;
  }
  
  private void a(long paramLong)
  {
    if (c() == 1001)
    {
      if ((this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidViewViewStub != null))
      {
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380134));
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(paramLong);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localCalendar.get(1));
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidViewView == null)
    {
      Calendar localCalendar;
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    if ((a() != null) && ((a() instanceof var)) && ((a() instanceof FeedCloudMeta.StFeed)))
    {
      localStFeed = (FeedCloudMeta.StFeed)a();
      if (QCircleFakeAdapter.a(localStFeed)) {
        QQToast.a(getContext(), 0, 2131697318, 0).a();
      }
    }
    else
    {
      return;
    }
    Object localObject = (var)a();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.tabAttachInfo.set(((var)localObject).a());
    localObject = ((var)localObject).a();
    if (localObject != null)
    {
      localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
      localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
    }
    localObject = new QCircleLayerBean();
    ((QCircleLayerBean)localObject).setFeed(localStFeed);
    ((QCircleLayerBean)localObject).setSourceType(a().pageType);
    ((QCircleLayerBean)localObject).setFeedListBusiReqData(localStFeedListBusiReqData);
    ((QCircleLayerBean)localObject).setDataPosInList(paramInt);
    ((QCircleLayerBean)localObject).setFromReportBean(a().clone().setElementIdStr("content"));
    if (paramImageView != null)
    {
      vvh.a(paramImageView, paramImageView.getWidth(), paramImageView.getHeight(), (QCircleLayerBean)localObject);
      uyx.a(getContext(), (QCircleLayerBean)localObject);
    }
    for (;;)
    {
      paramImageView = new ReportExtraTypeInfo();
      paramImageView.mFeed = localStFeed;
      paramImageView.mPlayScene = 1;
      vtn.a(7, 2, paramImageView, d());
      return;
      uyx.a(getContext(), (QCircleLayerBean)localObject);
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
      localStringBuilder.append(anzj.a(2131718768));
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
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(zft.b(getContext(), 26.0F)), 0, j, 33);
      ((SpannableString)localObject).setSpan(new QCircleTimeLineFeedItemView.3(this, 1), 0, i, 33);
      ((SpannableString)localObject).setSpan(new StyleSpan(1), i, localStringBuilder.length(), 33);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
      label237:
      if (i - 1 == j)
      {
        localStringBuilder.append(anzj.a(2131719411));
        i = 0;
      }
      else if (i - 2 == j)
      {
        localStringBuilder.append(anzj.a(2131690486));
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
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(paramStFeed.content.get(), new wei(this));
  }
  
  private void d()
  {
    FeedCloudMeta.StFeed localStFeed;
    if ((a() != null) && ((a() instanceof var)) && ((a() instanceof FeedCloudMeta.StFeed)))
    {
      localStFeed = (FeedCloudMeta.StFeed)a();
      if (QCircleFakeAdapter.a(localStFeed)) {
        QQToast.a(getContext(), 0, 2131697318, 0).a();
      }
    }
    else
    {
      return;
    }
    Object localObject2 = (var)a();
    Object localObject1 = new QQCircleFeedBase.StFeedListBusiReqData();
    ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tabAttachInfo.set(((var)localObject2).a());
    localObject2 = ((var)localObject2).a();
    if (localObject2 != null)
    {
      ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagId.set(((QCircleInitBean)localObject2).getTagInfo().tagId.get());
      ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagName.set(((QCircleInitBean)localObject2).getTagInfo().tagName.get());
    }
    localObject2 = new QCircleInitBean();
    ((QCircleInitBean)localObject2).setFeed(localStFeed);
    ((QCircleInitBean)localObject2).setSourceType(a().pageType);
    ((QCircleInitBean)localObject2).setFeedListBusiReqData((QQCircleFeedBase.StFeedListBusiReqData)localObject1);
    ((QCircleInitBean)localObject2).setFromReportBean(a().clone().setElementIdStr("content"));
    uyx.a(getContext(), (QCircleInitBean)localObject2);
    localObject1 = new ReportExtraTypeInfo();
    ((ReportExtraTypeInfo)localObject1).mFeed = localStFeed;
    ((ReportExtraTypeInfo)localObject1).mPlayScene = 1;
    vtn.a(7, 2, (ExtraTypeInfo)localObject1, d());
  }
  
  public int a()
  {
    return 2131560724;
  }
  
  public String a()
  {
    return "QCircleTimeLineFeedItemView";
  }
  
  public wec a()
  {
    return this.jdField_a_of_type_Wec;
  }
  
  public void a() {}
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370186);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380133));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131380132));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377001));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new aadd(getContext(), zft.b(getContext(), 1.0F), 2131167247));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370189));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131381257));
    this.jdField_a_of_type_Wem = new wem(this);
    this.jdField_a_of_type_Wem.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Wem.setHasStableIds(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wem);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 2);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.setSpanSizeLookup(new weh(this));
    if (val.a)
    {
      this.jdField_a_of_type_Wec = new wec();
      this.jdField_a_of_type_Wec.a((ViewStub)paramView.findViewById(2131381099));
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
      if ((this.jdField_a_of_type_Wec != null) && (this.jdField_a_of_type_Wec.a() != null)) {
        this.jdField_a_of_type_Wec.a().setVisibility(8);
      }
      if ((localStFeed.type.get() != 3) || (!val.a)) {
        break label165;
      }
      if (this.jdField_a_of_type_Wec != null)
      {
        if ((a() instanceof var)) {
          this.jdField_a_of_type_Wec.a((var)a());
        }
        this.jdField_a_of_type_Wec.a().setVisibility(0);
        this.jdField_a_of_type_Wec.a(a());
        this.jdField_a_of_type_Wec.a(paramObject, paramInt);
        this.jdField_a_of_type_Wec.a(getTag(), paramObject);
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
      this.jdField_a_of_type_Wem.a(localStFeed, this.jdField_b_of_type_Int, a(paramObject, paramInt, localStFeed));
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
      if ((this.jdField_a_of_type_Wec != null) && (this.jdField_a_of_type_Wec.a() != null)) {
        this.jdField_a_of_type_Wec.a().setVisibility(4);
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
    String str2 = uzg.a(getContext());
    if (uzg.a(getContext())) {}
    for (String str1 = "1";; str1 = "2")
    {
      vtq.a(str2, 11, 19, 2, str1, "", "", "", "");
      d();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView
 * JD-Core Version:    0.7.0.1
 */