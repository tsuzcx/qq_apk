package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class BlankRecommendItemView$InnerRecommendItemView
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  
  public BlankRecommendItemView$InnerRecommendItemView(BlankRecommendItemView paramBlankRecommendItemView, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369356));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379668));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBackgroundColor(Color.parseColor("#252525"));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.invalidate();
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      int i = paramStFeed.cover.width.get();
      if (paramStFeed.cover.height.get() > i) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageURL(paramStFeed.cover.url.get());
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData() set image url error! url: ");
        localStringBuilder.append(paramStFeed.cover.url.get());
        QLog.e("BlankRecommendItemView", 2, localStringBuilder.toString(), localThrowable);
      }
      if (paramStFeed.video.duration.get() > 0L)
      {
        i = paramStFeed.video.duration.get() / 1000 / 60;
        int j = paramStFeed.video.duration.get() / 1000;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new BlankRecommendItemView.InnerRecommendItemView.1(this, paramStFeed));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.InnerRecommendItemView
 * JD-Core Version:    0.7.0.1
 */