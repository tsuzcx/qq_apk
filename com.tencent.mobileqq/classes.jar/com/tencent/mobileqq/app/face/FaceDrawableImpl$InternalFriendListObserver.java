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
    this.this$0.onUpdateHead(paramBoolean, 116, paramString, this.this$0.mFriendListObserver);
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    this.this$0.onUpdateHead(paramBoolean, 1, paramString, this.this$0.mFriendListObserver);
  }
  
  public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    this.this$0.onUpdateHead(paramBoolean, 11, paramString, this.this$0.mFriendListObserver);
  }
  
  public void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if ((this.this$0.mFaceInfo == null) || (paramInt != this.this$0.mFaceInfo.b)) {
      return;
    }
    this.this$0.onUpdateHead(paramBoolean1, 16, paramString, this.this$0.mFriendListObserver);
  }
  
  public void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.this$0.onUpdateHead(paramBoolean1, 32, paramString, this.this$0.mFriendListObserver);
  }
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    this.this$0.onUpdateHead(paramBoolean, 4, paramString, this.this$0.mFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalFriendListObserver
 * JD-Core Version:    0.7.0.1
 */