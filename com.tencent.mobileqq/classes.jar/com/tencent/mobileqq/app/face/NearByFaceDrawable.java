package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class NearByFaceDrawable
  extends FaceDrawable
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  FaceObserver jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver = null;
  
  public NearByFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, 100, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean2);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void cancel()
  {
    FaceObserver localFaceObserver = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver;
    if (localFaceObserver != null)
    {
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localAppInterface != null)
      {
        localAppInterface.removeObserver(localFaceObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver = null;
      }
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    super.cancel();
  }
  
  protected Bitmap getBitmapFromCache()
  {
    if (this.mFaceInfo == null) {
      return null;
    }
    String str = FaceInfo.a(this.mFaceInfo.jdField_a_of_type_Int, this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.b, this.mFaceInfo.c, this.mFaceInfo.d);
    return ((IQQAvatarManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarManagerService.class, "nearby")).getFaceFromCache(str);
  }
  
  protected Bitmap getBitmapFromCache(boolean paramBoolean)
  {
    return getBitmapFromCache();
  }
  
  protected void onNeedDownload()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNeedDownload.faceInfo=");
      ((StringBuilder)localObject).append(this.mFaceInfo);
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getBitmapFromCache();
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNeedDownload.faceInfo=");
        localStringBuilder.append(this.mFaceInfo);
        localStringBuilder.append(",bitmap is already in cache...");
        QLog.i("Q.qqhead.NearByFaceDrawable", 2, localStringBuilder.toString());
      }
      onDecodeTaskCompleted(this.mFaceInfo, (Bitmap)localObject);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver = new NearByFaceDrawable.1(this);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver);
    }
    ((IQQNearbyAvatarHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQNearbyAvatarHandlerService.class, "nearby")).getStrangerFaceInfo(this.mFaceInfo);
  }
  
  protected boolean requestDecode()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestDecode.faceInfo=");
      localStringBuilder.append(this.mFaceInfo);
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, localStringBuilder.toString());
    }
    if (this.mFaceInfo == null) {
      return false;
    }
    ((IQQAvatarDecoderApi)QRoute.api(IQQAvatarDecoderApi.class)).executeTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.mFaceInfo, this);
    return true;
  }
  
  protected void setApp(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearByFaceDrawable
 * JD-Core Version:    0.7.0.1
 */