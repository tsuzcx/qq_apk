package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewVideoPresenter;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.api.VideoViewFactory;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.net.URL;

public class PreviewVideoView
  extends BrowserBaseView
  implements View.OnClickListener, VideoPlayerCallback
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PreviewVideoPresenter jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter;
  private BaseVideoView jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  private ImageView b;
  
  public PreviewVideoView(Context paramContext, PreviewVideoPresenter paramPreviewVideoPresenter)
  {
    super(paramContext, paramPreviewVideoPresenter);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter = paramPreviewVideoPresenter;
  }
  
  private void a(int paramInt)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mVideoPath = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter.a(paramInt);
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mCallback = this;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(localVideoPlayParam);
  }
  
  private void a(Context paramContext)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    PreviewVideoPresenter localPreviewVideoPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter;
    localVideoPlayParam.mVideoPath = localPreviewVideoPresenter.a(localPreviewVideoPresenter.getCurrentPosition());
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mCallback = this;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = a(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter.getCurrentPosition(), localVideoPlayParam, null);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setId(2131380649);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(localVideoPlayParam);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
  }
  
  private void a(boolean paramBoolean)
  {
    ImageView localImageView = this.b;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  private void b(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public Drawable a(String paramString, int paramInt1, int paramInt2, LocalMediaInfo paramLocalMediaInfo)
  {
    PreviewVideoView.1 local1 = new PreviewVideoView.1(this, Color.rgb(214, 214, 214), paramInt2, paramInt1);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, local1, local1);
        ((URLDrawable)localObject).setTag(paramLocalMediaInfo);
        if (((URLDrawable)localObject).getStatus() != 1) {
          ((URLDrawable)localObject).downloadImediatly();
        }
        return localObject;
      }
      catch (Exception paramLocalMediaInfo)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getCoverDrawable():  getDrawable Exception, coverUrl=");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("QQAlbum", 2, ((StringBuilder)localObject).toString(), paramLocalMediaInfo);
        }
      }
    }
    return local1;
  }
  
  protected BaseVideoView a(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return (BaseVideoView)VideoViewFactory.createBaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
  
  public void a()
  {
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((localBaseVideoView != null) && (localBaseVideoView.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      a(true);
    }
  }
  
  public void bindView(int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter.a(paramInt);
    int i = this.mScreenWidthPx;
    int j = this.mScreenHeightPx;
    if (localLocalMediaInfo.mediaWidth > localLocalMediaInfo.mediaHeight)
    {
      i = this.mScreenHeightPx;
      j = this.mScreenWidthPx;
    }
    a(paramInt);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter.a(localLocalMediaInfo.path);
    Object localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "FLOW_THUMB");
      if (localObject != null)
      {
        localObject = a(((URL)localObject).toString(), i, j, localLocalMediaInfo);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter.a(localLocalMediaInfo.path, (Drawable)localObject);
      }
      else
      {
        QLog.d("QQAlbum", 2, "url  is null ");
        localObject = localDrawable;
      }
    }
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    b(true);
    a(true);
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131563026, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mBrowserItemView.findViewById(2131373043));
    this.b = ((ImageView)this.mBrowserItemView.findViewById(2131373041));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.mBrowserItemView.findViewById(2131373045));
    a(this.mContext);
    return this.mBrowserItemView;
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131373041) || (i == 2131380649))
    {
      BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (localBaseVideoView != null) {
        if (localBaseVideoView.isPlaying())
        {
          this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
          a(true);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
          a(false);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (localBaseVideoView != null) {
      localBaseVideoView.releasePlayer(false);
    }
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (paramView != null) {
      paramView.releasePlayer(false);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter;
    if (paramView != null)
    {
      paramView = paramView.a(paramInt);
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.path))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewVideoPresenter.a(paramView.path);
      }
    }
  }
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.post(new PreviewVideoView.4(this));
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    bindView(paramInt);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQAlbum", 2, "onScrollHalfScreenWidth");
    }
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((localBaseVideoView != null) && (localBaseVideoView.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      a(true);
      b(true);
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStateChange , state = ");
      localStringBuilder.append(paramInt);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    if (paramInt == 8)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new PreviewVideoView.2(this));
      return;
    }
    if (paramInt == 4) {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new PreviewVideoView.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView
 * JD-Core Version:    0.7.0.1
 */