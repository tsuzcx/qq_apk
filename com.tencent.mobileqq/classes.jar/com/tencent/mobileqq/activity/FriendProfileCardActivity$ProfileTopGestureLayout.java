package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;

public class FriendProfileCardActivity$ProfileTopGestureLayout
  extends TopGestureLayout
{
  public FriendProfileCardActivity$ProfileTopGestureLayout(FriendProfileCardActivity paramFriendProfileCardActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a.a instanceof VasProfilePhotoView))
    {
      View localView = this.a.a.a("map_key_qzonecover");
      if (((localView instanceof QzonePhotoView)) && (((QzonePhotoView)localView).a)) {
        return false;
      }
    }
    else if (((this.a.a instanceof VasProfileTagView)) && (((VasProfileTagView)this.a.a).a))
    {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.ProfileTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */