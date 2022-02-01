package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureModel;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoModel;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPicturePresenter;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewVideoPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewPictureView;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView;
import com.tencent.mobileqq.activity.photo.album.preview.view.WebPreviewPictureView;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.core.IMvpFactory;

public class AlbumPreviewFactory
  implements IMvpFactory
{
  public IBaseModelBuilder createModel(int paramInt, IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return new PreviewVideoModel();
    }
    return new PreviewPictureModel();
  }
  
  public IBasePresenterBuilder createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return new PreviewVideoPresenter();
    }
    return new PreviewPicturePresenter();
  }
  
  public IBaseViewBuilder createView(Context paramContext, int paramInt, IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 102: 
      if ((paramIBasePresenterBuilder instanceof PreviewPicturePresenter)) {
        return new WebPreviewPictureView(paramContext, (PreviewPicturePresenter)paramIBasePresenterBuilder);
      }
      break;
    case 101: 
      if ((paramIBasePresenterBuilder instanceof PreviewVideoPresenter)) {
        return new PreviewVideoView(paramContext, (PreviewVideoPresenter)paramIBasePresenterBuilder);
      }
      break;
    case 100: 
      if ((paramIBasePresenterBuilder instanceof PreviewPicturePresenter)) {
        return new PreviewPictureView(paramContext, (PreviewPicturePresenter)paramIBasePresenterBuilder);
      }
      break;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.AlbumPreviewFactory
 * JD-Core Version:    0.7.0.1
 */