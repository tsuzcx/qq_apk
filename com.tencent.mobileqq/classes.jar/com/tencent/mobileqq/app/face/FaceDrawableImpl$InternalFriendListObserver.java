package com.tencent.mobileqq.app.face;

import java.lang.ref.WeakReference;

public class FaceDrawableImpl$InternalFriendListObserver
  implements FaceDrawableImpl.FaceObserver
{
  public WeakReference<FaceDrawable> faceDrawableWeakReference;
  public String uin;
  
  FaceDrawableImpl$InternalFriendListObserver(FaceDrawableImpl paramFaceDrawableImpl, FaceDrawable paramFaceDrawable)
  {
    this.faceDrawableWeakReference = new WeakReference(paramFaceDrawable);
    if ((paramFaceDrawable != null) && (paramFaceDrawable.mFaceInfo != null)) {
      this.uin = paramFaceDrawable.mFaceInfo.a;
    }
  }
  
  public void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt)
  {
    FaceDrawableImpl localFaceDrawableImpl = this.this$0;
    localFaceDrawableImpl.onUpdateHead(paramBoolean, 116, paramString, localFaceDrawableImpl.mFriendListObserver);
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    FaceDrawableImpl localFaceDrawableImpl = this.this$0;
    localFaceDrawableImpl.onUpdateHead(paramBoolean, 1, paramString, localFaceDrawableImpl.mFriendListObserver);
  }
  
  public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    FaceDrawableImpl localFaceDrawableImpl = this.this$0;
    localFaceDrawableImpl.onUpdateHead(paramBoolean, 11, paramString, localFaceDrawableImpl.mFriendListObserver);
  }
  
  public void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (this.this$0.mFaceInfo != null)
    {
      if (paramInt != this.this$0.mFaceInfo.b) {
        return;
      }
      FaceDrawableImpl localFaceDrawableImpl = this.this$0;
      localFaceDrawableImpl.onUpdateHead(paramBoolean1, 16, paramString, localFaceDrawableImpl.mFriendListObserver);
    }
  }
  
  public void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    FaceDrawableImpl localFaceDrawableImpl = this.this$0;
    localFaceDrawableImpl.onUpdateHead(paramBoolean1, 32, paramString, localFaceDrawableImpl.mFriendListObserver);
  }
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    FaceDrawableImpl localFaceDrawableImpl = this.this$0;
    localFaceDrawableImpl.onUpdateHead(paramBoolean, 4, paramString, localFaceDrawableImpl.mFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalFriendListObserver
 * JD-Core Version:    0.7.0.1
 */