package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

class AIOGalleryActivity$AIOGalleryManager
  extends GalleryManager
{
  IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = new AIOGalleryActivity.AIOGalleryManager.1(this);
  
  AIOGalleryActivity$AIOGalleryManager(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new AIOGallerySceneWithBusiness(paramActivity, paramAbstractImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    return new AIOImageListModel(true);
  }
  
  public AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    AIOImageListModel localAIOImageListModel = (AIOImageListModel)paramAbstractImageListModel;
    localAIOImageListModel.e = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if (localAIOImageListModel.e) {
      ReportController.b(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, "", "", "");
    }
    localAIOImageListModel.d(4);
    localAIOImageListModel.a();
    return new AIOImageListScene(paramActivity, paramAbstractImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, AIOGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)
    {
      Object localObject = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(((BinderWarpper)localObject).a);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("IAIOImageProvider is ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
          QLog.d("AIOGalleryActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        throw new IllegalArgumentException("can't find Binder in Intent..");
      }
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
    super.a(paramActivity);
    if (bool)
    {
      this.jdField_a_of_type_Boolean = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
      super.a();
      if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene != null) && ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene instanceof AIOImageListScene))) {
        ((AIOImageListScene)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene).p();
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager
 * JD-Core Version:    0.7.0.1
 */