package com.tencent.mobileqq.activity;

import android.app.Activity;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.picbrowser.PicBrowserModel;
import com.tencent.mobileqq.profile.FriendProfileCardPicScene;

class FriendProfilePicBrowserActivity$FriendProfileGalleryManager
  extends GalleryManager
{
  FriendProfilePicBrowserActivity$FriendProfileGalleryManager(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity) {}
  
  public AbstractAnimationManager a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return super.a(paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.a.a = new FriendProfileCardPicScene((FriendProfilePicBrowserActivity)paramActivity, paramAbstractImageListModel);
    return this.a.a;
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity = new PicBrowserModel(paramActivity, FriendProfilePicBrowserActivity.a(paramActivity));
    paramActivity.a(FriendProfilePicBrowserActivity.a(this.a));
    return paramActivity;
  }
  
  public AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity.FriendProfileGalleryManager
 * JD-Core Version:    0.7.0.1
 */