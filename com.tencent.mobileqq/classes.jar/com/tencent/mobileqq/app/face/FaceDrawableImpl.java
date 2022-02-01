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
    Object localObject = this.mFaceInfo.c;
    if (this.mFaceInfo.b == 1001) {
      localObject = AvatarUtil.d(this.mFaceInfo.c);
    }
    AppInterface localAppInterface = (AppInterface)this.weakApp.get();
    if (localAppInterface == null) {
      return null;
    }
    IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)localAppInterface.getRuntimeService(IQQAvatarDataService.class, "");
    localObject = localIQQAvatarDataService.getBitmapFromCache(localIQQAvatarDataService.getFaceBitmapCacheKey(this.mFaceInfo.b, (String)localObject, (byte)this.mFaceInfo.e, this.mFaceInfo.d, this.mFaceInfo.j, paramBoolean));
    if ((localObject != null) && (this.mFaceInfo.b == 1001)) {
      ((IDiscussionHandlerService)localAppInterface.getRuntimeService(IDiscussionHandlerService.class, "")).checkPstnIconInfoAndUpdate(this.mFaceInfo.c);
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
    if (localAppInterface == null) {
      return;
    }
    Object localObject = (IQQAvatarManagerService)localAppInterface.getRuntimeService(IQQAvatarManagerService.class, "");
    if (localObject != null) {
      ((IQQAvatarManagerService)localObject).addObserver(this.mFriendListObserver);
    }
    if ((this.mFaceInfo.b == 1) || (this.mFaceInfo.b == 11) || (this.mFaceInfo.b == 4) || (this.mFaceInfo.b == 32) || (this.mFaceInfo.b == 16) || (this.mFaceInfo.b == 116) || (this.mFaceInfo.b == 1001))
    {
      localObject = (IQQAvatarHandlerService)localAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
      if (this.mFaceInfo.b == 1)
      {
        ((IQQAvatarHandlerService)localObject).getCustomHead(this.mFaceInfo.c, this.mFaceInfo.f, this.mFaceInfo.g);
        return;
      }
      if (this.mFaceInfo.b == 11)
      {
        ((IQQAvatarHandlerService)localObject).getMobileQQHead(this.mFaceInfo.c, this.mFaceInfo.g);
        return;
      }
      if (this.mFaceInfo.b == 4)
      {
        ((IQQAvatarHandlerService)localObject).getTroopHead(this.mFaceInfo.c, this.mFaceInfo.g);
        return;
      }
      if (this.mFaceInfo.b == 32)
      {
        ((IQQAvatarHandlerService)localObject).getStrangerHead(this.mFaceInfo.c, this.mFaceInfo.d, this.mFaceInfo.f, this.mFaceInfo.g);
        return;
      }
      if (this.mFaceInfo.b == 16)
      {
        ((IQQAvatarHandlerService)localObject).getQCallHead(this.mFaceInfo.c, this.mFaceInfo.d, this.mFaceInfo.f, this.mFaceInfo.g);
        return;
      }
      if (this.mFaceInfo.b == 116)
      {
        ((IQQAvatarHandlerService)localObject).getApolloHead(this.mFaceInfo.c, this.mFaceInfo.f, this.mFaceInfo.g, this.mFaceInfo.j);
        return;
      }
      if (this.mFaceInfo.b == 101)
      {
        ((IDiscussionHandlerService)localAppInterface.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon(this.mFaceInfo.c, true);
        return;
      }
      if (this.mFaceInfo.b == 1001) {
        ((IDiscussionHandlerService)localAppInterface.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon(AvatarUtil.d(this.mFaceInfo.c), true);
      }
    }
  }
  
  public void onUpdateHead(boolean paramBoolean, int paramInt, String paramString, Object paramObject)
  {
    if (!this.mCancelled)
    {
      if (this.mFaceInfo == null) {
        return;
      }
      if (paramInt == this.mFaceInfo.b)
      {
        if (!this.mFaceInfo.c.equals(paramString)) {
          return;
        }
        if (paramObject != null)
        {
          paramString = (AppInterface)this.weakApp.get();
          if (paramString == null) {
            return;
          }
          paramString = (IQQAvatarManagerService)paramString.getRuntimeService(IQQAvatarManagerService.class, "");
          if (paramString != null) {
            paramString.removeObserver(paramObject);
          }
        }
        if (paramBoolean)
        {
          paramString = getBitmapFromCache();
          if (paramString != null) {
            onDecodeTaskCompleted(this.mFaceInfo, paramString);
          } else {
            requestDecode();
          }
        }
        else
        {
          onDecodeTaskCompleted(this.mFaceInfo, null);
        }
        System.currentTimeMillis();
      }
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
    if ((this.mFaceInfo.b == 101) || (this.mFaceInfo.b == 1001))
    {
      this.mDisObserver = new FaceDrawableImpl.InternalDiscussionObserver(this, this);
      localIQQAvatarManagerService = (IQQAvatarManagerService)localAppInterface.getRuntimeService(IQQAvatarManagerService.class, "");
      if (localIQQAvatarManagerService != null) {
        localIQQAvatarManagerService.addObserver(this.mDisObserver);
      }
    }
    if (((this.mFaceInfo.b == 4) || (this.mFaceInfo.b == 113)) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(this.mFaceInfo.c)))
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