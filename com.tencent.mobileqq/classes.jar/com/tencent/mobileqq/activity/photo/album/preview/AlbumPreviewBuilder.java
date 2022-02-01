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
  private PreviewModel jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewModelPreviewModel;
  private PreviewPresenter jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter;
  private PreviewScene jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene;
  private BrowserParamsBuilder jdField_a_of_type_ComTencentRichmediabrowserApiBrowserParamsBuilder;
  
  public AlbumPreviewBuilder(PhotoPreviewCustomization<? extends OtherCommonData> paramPhotoPreviewCustomization)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewCustomization = paramPhotoPreviewCustomization;
  }
  
  public PreviewPresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter;
  }
  
  public void a(BrowserParamsBuilder paramBrowserParamsBuilder)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserApiBrowserParamsBuilder = paramBrowserParamsBuilder;
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.buildComplete();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.buildComplete();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewModelPreviewModel.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewModelPreviewModel.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.buildParams(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.buildParams(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewModelPreviewModel.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter = new PreviewPresenter();
    PhotoPreviewCustomization localPhotoPreviewCustomization = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewCustomization;
    PreviewPresenter localPreviewPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter;
    localPhotoPreviewCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter = localPreviewPresenter;
    localPreviewPresenter.a(localPhotoPreviewCustomization);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.setParamsBuilder(this.jdField_a_of_type_ComTencentRichmediabrowserApiBrowserParamsBuilder);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene = new PreviewScene(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewCustomization.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewCustomization);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewModelPreviewModel = new PreviewModel(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewModelPreviewModel);
  }
  
  public void buildView()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.buildView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.AlbumPreviewBuilder
 * JD-Core Version:    0.7.0.1
 */