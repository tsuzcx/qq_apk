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
  IAIOImageProviderCallBack a = new AIOGalleryActivity.AIOGalleryManager.1(this);
  
  AIOGalleryActivity$AIOGalleryManager(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new AIOGallerySceneWithBusiness(paramActivity, paramAbstractImageListModel, this.i.b, AIOGalleryActivity.a(this.i));
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    return new AIOImageListModel(true);
  }
  
  public AbstractImageListScene b(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    AIOImageListModel localAIOImageListModel = (AIOImageListModel)paramAbstractImageListModel;
    localAIOImageListModel.s = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if (localAIOImageListModel.s) {
      ReportController.b(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.i.i, "", "", "");
    }
    localAIOImageListModel.f(4);
    localAIOImageListModel.o();
    return new AIOImageListScene(paramActivity, paramAbstractImageListModel, this.i.b, AIOGalleryActivity.b(this.i));
  }
  
  public void b(Activity paramActivity)
  {
    if (this.i.b == null)
    {
      Object localObject = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject != null)
      {
        this.i.b = IAIOImageProvider.Stub.a(((BinderWarpper)localObject).a);
        this.i.b.a(this.a);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("IAIOImageProvider is ");
          ((StringBuilder)localObject).append(this.i.b);
          QLog.d("AIOGalleryActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        throw new IllegalArgumentException("can't find Binder in Intent..");
      }
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
    super.b(paramActivity);
    if (bool)
    {
      this.f = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
      super.f();
      if ((this.c != null) && ((this.c instanceof AIOImageListScene))) {
        ((AIOImageListScene)this.c).r();
      }
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager
 * JD-Core Version:    0.7.0.1
 */