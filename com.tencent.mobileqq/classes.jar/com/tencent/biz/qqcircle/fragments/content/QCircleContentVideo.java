package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.BaseVideoView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import tql;
import txo;
import tyk;
import tyy;
import vrr;

public class QCircleContentVideo
  extends BaseVideoView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private volatile QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private boolean d;
  
  public QCircleContentVideo(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void j()
  {
    setOnClickListener(new txo(this));
  }
  
  public int a()
  {
    return 0;
  }
  
  public SeekBar a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_AndroidWidgetSeekBar;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if (localStFeed != null)
    {
      String str = "";
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        str = paramInt2 + ":" + paramInt1;
      }
      tyk.a(2, 4, 2, this.jdField_a_of_type_Int + 1, paramLong1, paramLong2, true, str, localStFeed, tyk.a(localStFeed));
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if (localStFeed != null) {
      tyk.a(2, 5, 2, this.jdField_a_of_type_Int + 1, paramLong1, paramLong2, true, "", localStFeed, tyk.a(localStFeed));
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    j();
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramObject = (FeedCloudMeta.StFeed)paramObject;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = tql.b(a());
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130849999);
    tql.a(paramObject.cover.picUrl.get(), a(), localURLDrawableOptions, false);
  }
  
  public void a(vrr paramvrr)
  {
    super.a(paramvrr);
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.f != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.f.setText(tyy.a((int)paramvrr.b()));
    }
    c();
    a().postDelayed(new QCircleContentVideo.2(this), 100L);
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if (localStFeed != null) {
      tyk.a(2, 6, 2, this.jdField_a_of_type_Int + 1, paramLong1, paramLong2, true, "", localStFeed, tyk.a(localStFeed));
    }
  }
  
  public void b(vrr paramvrr)
  {
    this.d = true;
    e();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentImageURLImageView != null)) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    super.c();
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
    }
  }
  
  public void d() {}
  
  public void e()
  {
    super.e();
    this.d = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.c) {
        a().postDelayed(new QCircleContentVideo.3(this), 1500L);
      }
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    super.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    if ((this.c) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null))
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.e != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.e.setText(tyy.a(paramInt) + " | ");
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    super.onSeekComplete(paramTVK_IMediaPlayer);
  }
  
  public void setInitialPosition(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOperationView(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = paramQCircleContentOperationView;
  }
  
  public void setVideoPath(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    if (a() != null) {
      a().setOnSeekBarChangeListener(this);
    }
    this.d = false;
    super.setVideoPath(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo
 * JD-Core Version:    0.7.0.1
 */