package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewModel;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class AlbumPreviewBuilder
  implements IBrowserBuilder
{
  public PhotoPreviewCustomization<? extends OtherCommonData> a;
  private PreviewPresenter b;
  private PreviewScene c;
  private PreviewModel d;
  private BrowserParamsBuilder e;
  
  public AlbumPreviewBuilder(PhotoPreviewCustomization<? extends OtherCommonData> paramPhotoPreviewCustomization)
  {
    this.a = paramPhotoPreviewCustomization;
  }
  
  public PreviewPresenter a()
  {
    return this.b;
  }
  
  public void a(BrowserParamsBuilder paramBrowserParamsBuilder)
  {
    this.e = paramBrowserParamsBuilder;
  }
  
  public void buildComplete()
  {
    this.b.buildComplete();
    this.c.buildComplete();
    this.d.buildComplete();
  }
  
  public void buildModel()
  {
    this.d.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.b.buildParams(paramIntent);
    this.c.buildParams(paramIntent);
    this.d.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.b = new PreviewPresenter();
    PhotoPreviewCustomization localPhotoPreviewCustomization = this.a;
    PreviewPresenter localPreviewPresenter = this.b;
    localPhotoPreviewCustomization.i = localPreviewPresenter;
    localPreviewPresenter.a(localPhotoPreviewCustomization);
    this.b.setParamsBuilder(this.e);
    this.c = new PreviewScene(this.a.e, this.b);
    this.c.a(this.a);
    this.b.a(this.c);
    this.d = new PreviewModel(this.b);
    this.b.a(this.d);
  }
  
  public void buildView()
  {
    this.c.buildView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.AlbumPreviewBuilder
 * JD-Core Version:    0.7.0.1
 */