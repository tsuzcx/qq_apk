package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;

public class DetailEmptyInteractionSegment
  extends SegmentView
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public DetailEmptyInteractionSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public void R_()
  {
    SegmentView localSegmentView1 = a().a("DetailCommentSegment");
    SegmentView localSegmentView2 = a().a("DetailLikeListSegment");
    DetailDoubleTabSegment localDetailDoubleTabSegment = (DetailDoubleTabSegment)a().a("DetailDoubleTabSegment");
    if ((localDetailDoubleTabSegment != null) && (localDetailDoubleTabSegment.a() > 0) && (localSegmentView1 != null) && (localSegmentView1.a() == 0) && (localSegmentView2 != null) && (localSegmentView2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localDetailDoubleTabSegment.b();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
    int i = UIUtils.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (GeneralFeedProfileSegment)a().a("GeneralFeedProfileSegment");
    ShareGroupFeedProfileSegment localShareGroupFeedProfileSegment = (ShareGroupFeedProfileSegment)a().a("ShareGroupFeedProfileSegment");
    BannerProfileSegment localBannerProfileSegment = (BannerProfileSegment)a().a("BannerProfileSegment");
    DetailInteractSegment localDetailInteractSegment = (DetailInteractSegment)a().a("DetailInteractSegment");
    DetailDoubleTabSegment localDetailDoubleTabSegment = (DetailDoubleTabSegment)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localShareGroupFeedProfileSegment.b() + localBannerProfileSegment.b() + localDetailInteractSegment.b() + localDetailDoubleTabSegment.c()) - k;
    if (paramInt > UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F))
    {
      paramBaseViewHolder.a().getLayoutParams().height = paramInt;
      SLog.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramBaseViewHolder.a().getLayoutParams().height));
      paramViewGroup = (TextView)paramBaseViewHolder.a(2131378507);
      if (this.jdField_a_of_type_Int != 1) {
        break label247;
      }
      paramViewGroup.setText(HardCodeUtil.a(2131703167));
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      paramBaseViewHolder.a().getLayoutParams().height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      break;
      label247:
      paramViewGroup.setText(HardCodeUtil.a(2131703168));
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561779, paramViewGroup, false));
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailEmptyInteractionSegment
 * JD-Core Version:    0.7.0.1
 */