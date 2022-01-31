package com.tencent.biz.qqcircle.widgets.childViewPresent;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.List;
import tqg;
import ucz;
import udn;

public class QCircleFeedItemPicPresent
  extends ucz
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleFeedItemPicPresent.MultiPicAdapter jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter;
  private int b = ImmersiveUtils.a();
  private int c;
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getLayoutParams() != null))
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getLayoutParams().height = this.c;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.requestLayout();
    }
  }
  
  private void a(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      this.c = ((int)(Math.max(Math.min(paramStImage.height.get() / paramStImage.width.get(), 1.333333F), 0.5625F) * this.b));
      a();
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0)) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a();
      if (i > 1) {
        a(paramInt % i + 1 + "/" + i);
      }
    }
    else
    {
      return;
    }
    a("");
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373178));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373179));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131373170));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter = new QCircleFeedItemPicPresent.MultiPicAdapter(this);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new udn(this));
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    FeedCloudMeta.StFeed localStFeed1;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      localStFeed1 = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      FeedCloudMeta.StFeed localStFeed2 = tqg.a(localStFeed1.id.get());
      paramObject = localStFeed1.images.get();
      if (localStFeed2 == null) {
        break label178;
      }
      paramObject = localStFeed2.images.get();
    }
    label178:
    for (;;)
    {
      if (paramObject.size() > 0)
      {
        a((FeedCloudMeta.StImage)paramObject.get(0));
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a(paramObject);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
        b(0);
      }
      if (localStFeed1.images.get().size() > 1)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresent
 * JD-Core Version:    0.7.0.1
 */