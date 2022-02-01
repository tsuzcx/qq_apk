package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.widget.AnimationView;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import vrx;
import vsj;

public class QCirclePolyLikeFreeView
  extends QCirclePolyBaseLikeView
{
  public QCirclePolyLikeFreeView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void c()
  {
    if (b() == 256) {
      if (this.b != null) {
        this.b.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      return;
      if (this.b != null) {
        this.b.setVisibility(0);
      }
    }
  }
  
  public int a()
  {
    if (b() == 256) {
      return 2131560778;
    }
    return 2131560777;
  }
  
  public String a()
  {
    return "QCircleCommonPolyLikeView";
  }
  
  protected void a()
  {
    int[] arrayOfInt;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView != null)
    {
      arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.getLocationOnScreen(arrayOfInt);
      localObject = getContext();
      getContext();
      ((Vibrator)((Context)localObject).getSystemService("vibrator")).vibrate(50L);
      if (this.jdField_a_of_type_Vrx != null) {
        this.jdField_a_of_type_Vrx.b();
      }
    }
    try
    {
      localObject = new QQCircleFeedBase.StLikeBusiData();
      ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo;
      this.jdField_a_of_type_Vsj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike);
      this.jdField_a_of_type_Vsj.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike, this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, 1, arrayOfInt, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, (QQCircleFeedBase.StPolyLike)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(Context paramContext, View paramView)
  {
    super.a(paramContext, paramView);
    c();
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    super.a(paramObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFreeView
 * JD-Core Version:    0.7.0.1
 */