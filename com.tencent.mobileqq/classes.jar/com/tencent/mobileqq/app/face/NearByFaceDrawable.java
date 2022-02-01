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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver = null;
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.mFaceInfo);
    }
    Bitmap localBitmap = getBitmapFromCache();
    if (localBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.mFaceInfo + ",bitmap is already in cache...");
      }
      onDecodeTaskCompleted(this.mFaceInfo, localBitmap);
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "requestDecode.faceInfo=" + this.mFaceInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearByFaceDrawable
 * JD-Core Version:    0.7.0.1
 */