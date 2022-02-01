package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import java.lang.ref.WeakReference;

public class FaceDrawableImpl
  extends FaceDrawable
{
  private static final String TAG = "Q.qqhead.FaceDrawableImpl";
  FaceDrawableImpl.InternalDiscussionObserver mDisObserver;
  FaceDrawableImpl.InternalFriendListObserver mFriendListObserver;
  FaceDrawableImpl.InternalGroupObserver mGroupObserver;
  WeakReference<AppInterface> weakApp;
  
  public FaceDrawableImpl(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean2);
    this.weakApp = new WeakReference(paramAppInterface);
  }
  
  private Bitmap getBitmapFromCacheInner(boolean paramBoolean)
  {
    if (this.mFaceInfo == null) {
      return null;
    }
    Object localObject = this.mFaceInfo.jdField_a_of_type_JavaLangString;
    if (this.mFaceInfo.jdField_a_of_type_Int == 1001) {
      localObject = AvatarUtil.c(this.mFaceInfo.jdField_a_of_type_JavaLangString);
    }
    AppInterface localAppInterface = (AppInterface)this.weakApp.get();
    if (localAppInterface == null) {
      return null;
    }
    IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)localAppInterface.getRuntimeService(IQQAvatarDataService.class, "");
    localObject = localIQQAvatarDataService.getBitmapFromCache(localIQQAvatarDataService.getFaceBitmapCacheKey(this.mFaceInfo.jdField_a_of_type_Int, (String)localObject, (byte)this.mFaceInfo.c, this.mFaceInfo.jdField_b_of_type_Int, this.mFaceInfo.d, paramBoolean));
    if ((localObject != null) && (this.mFaceInfo.jdField_a_of_type_Int == 1001)) {
      ((IDiscussionHandlerService)localAppInterface.getRuntimeService(IDiscussionHandlerService.class, "")).checkPstnIconInfoAndUpdate(this.mFaceInfo.jdField_a_of_type_JavaLangString);
    }
    return localObject;
  }
  
  public void cancel()
  {
    Object localObject = (AppInterface)this.weakApp.get();
    if ((!this.mCancelled) && (localObject != null))
    {
      IQQAvatarManagerService localIQQAvatarManagerService;
      if (this.mFriendListObserver != null)
      {
        localIQQAvatarManagerService = (IQQAvatarManagerService)((AppInterface)localObject).getRuntimeService(IQQAvatarManagerService.class, "");
        if (localIQQAvatarManagerService != null) {
          localIQQAvatarManagerService.removeObserver(this.mFriendListObserver);
        }
      }
      if (this.mDisObserver != null)
      {
        localIQQAvatarManagerService = (IQQAvatarManagerService)((AppInterface)localObject).getRuntimeService(IQQAvatarManagerService.class, "");
        if (localIQQAvatarManagerService != null) {
          localIQQAvatarManagerService.removeObserver(this.mDisObserver);
        }
      }
      if (this.mGroupObserver != null)
      {
        localObject = (IQQAvatarManagerService)((AppInterface)localObject).getRuntimeService(IQQAvatarManagerService.class, "");
        if (localObject != null) {
          ((IQQAvatarManagerService)localObject).removeObserver(this.mGroupObserver);
        }
      }
      this.weakApp = null;
    }
    super.cancel();
  }
  
  protected Bitmap getBitmapFromCache()
  {
    return getBitmapFromCacheInner(false);
  }
  
  protected Bitmap getBitmapFromCache(boolean paramBoolean)
  {
    return getBitmapFromCacheInner(paramBoolean);
  }
  
  protected void onNeedDownload()
  {
    if (this.mFriendListObserver == null) {
      this.mFriendListObserver = new FaceDrawableImpl.InternalFriendListObserver(this, this);
    }
    AppInterface localAppInterface = (AppInterface)this.weakApp.get();
    if (localAppInterface == null) {}
    do
    {
      do
      {
        return;
        localObject = (IQQAvatarManagerService)localAppInterface.getRuntimeService(IQQAvatarManagerService.class, "");
        if (localObject != null) {
          ((IQQAvatarManagerService)localObject).addObserver(this.mFriendListObserver);
        }
      } while ((this.mFaceInfo.jdField_a_of_type_Int != 1) && (this.mFaceInfo.jdField_a_of_type_Int != 11) && (this.mFaceInfo.jdField_a_of_type_Int != 4) && (this.mFaceInfo.jdField_a_of_type_Int != 32) && (this.mFaceInfo.jdField_a_of_type_Int != 16) && (this.mFaceInfo.jdField_a_of_type_Int != 116) && (this.mFaceInfo.jdField_a_of_type_Int != 1001));
      Object localObject = (IQQAvatarHandlerService)localAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
      if (this.mFaceInfo.jdField_a_of_type_Int == 1)
      {
        ((IQQAvatarHandlerService)localObject).getCustomHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.mFaceInfo.jdField_a_of_type_Int == 11)
      {
        ((IQQAvatarHandlerService)localObject).getMobileQQHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.mFaceInfo.jdField_a_of_type_Int == 4)
      {
        ((IQQAvatarHandlerService)localObject).getTroopHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.mFaceInfo.jdField_a_of_type_Int == 32)
      {
        ((IQQAvatarHandlerService)localObject).getStrangerHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Int, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.mFaceInfo.jdField_a_of_type_Int == 16)
      {
        ((IQQAvatarHandlerService)localObject).getQCallHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Int, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.mFaceInfo.jdField_a_of_type_Int == 116)
      {
        ((IQQAvatarHandlerService)localObject).getApolloHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte, this.mFaceInfo.d);
        return;
      }
      if (this.mFaceInfo.jdField_a_of_type_Int == 101)
      {
        ((IDiscussionHandlerService)localAppInterface.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon(this.mFaceInfo.jdField_a_of_type_JavaLangString, true);
        return;
      }
    } while (this.mFaceInfo.jdField_a_of_type_Int != 1001);
    ((IDiscussionHandlerService)localAppInterface.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon(AvatarUtil.c(this.mFaceInfo.jdField_a_of_type_JavaLangString), true);
  }
  
  public void onUpdateHead(boolean paramBoolean, int paramInt, String paramString, Object paramObject)
  {
    if ((this.mCancelled) || (this.mFaceInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != this.mFaceInfo.jdField_a_of_type_Int) || (!this.mFaceInfo.jdField_a_of_type_JavaLangString.equals(paramString)));
      if (paramObject == null) {
        break;
      }
      paramString = (AppInterface)this.weakApp.get();
    } while (paramString == null);
    paramString = (IQQAvatarManagerService)paramString.getRuntimeService(IQQAvatarManagerService.class, "");
    if (paramString != null) {
      paramString.removeObserver(paramObject);
    }
    if (paramBoolean)
    {
      paramString = getBitmapFromCache();
      if (paramString != null) {
        onDecodeTaskCompleted(this.mFaceInfo, paramString);
      }
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      requestDecode();
      continue;
      onDecodeTaskCompleted(this.mFaceInfo, null);
    }
  }
  
  protected boolean requestDecode()
  {
    if (this.mFaceInfo == null) {
      return false;
    }
    AppInterface localAppInterface = (AppInterface)this.weakApp.get();
    if (localAppInterface == null) {
      return false;
    }
    IQQAvatarManagerService localIQQAvatarManagerService;
    if ((this.mFaceInfo.jdField_a_of_type_Int == 101) || (this.mFaceInfo.jdField_a_of_type_Int == 1001))
    {
      this.mDisObserver = new FaceDrawableImpl.InternalDiscussionObserver(this, this);
      localIQQAvatarManagerService = (IQQAvatarManagerService)localAppInterface.getRuntimeService(IQQAvatarManagerService.class, "");
      if (localIQQAvatarManagerService != null) {
        localIQQAvatarManagerService.addObserver(this.mDisObserver);
      }
    }
    if (((this.mFaceInfo.jdField_a_of_type_Int == 4) || (this.mFaceInfo.jdField_a_of_type_Int == 113)) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(this.mFaceInfo.jdField_a_of_type_JavaLangString)))
    {
      this.mGroupObserver = new FaceDrawableImpl.InternalGroupObserver(this, this);
      localIQQAvatarManagerService = (IQQAvatarManagerService)localAppInterface.getRuntimeService(IQQAvatarManagerService.class, "");
      if (localIQQAvatarManagerService != null) {
        localIQQAvatarManagerService.addObserver(this.mGroupObserver);
      }
    }
    ((IQQAvatarDecoderApi)QRoute.api(IQQAvatarDecoderApi.class)).executeTask(localAppInterface, this.mFaceInfo, this);
    return true;
  }
  
  protected void setApp(AppInterface paramAppInterface)
  {
    this.weakApp = new WeakReference(paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl
 * JD-Core Version:    0.7.0.1
 */