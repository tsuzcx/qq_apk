package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfilePhotoView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import java.util.HashMap;

public class FriendProfileCardActivity$ProfileTopGestureLayout
  extends TopGestureLayout
{
  public FriendProfileCardActivity$ProfileTopGestureLayout(FriendProfileCardActivity paramFriendProfileCardActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a.a instanceof ProfilePhotoView))
    {
      View localView = (View)this.a.a.a.get("map_key_qzonecover");
      if (((localView instanceof QzonePhotoView)) && (((QzonePhotoView)localView).a)) {
        return false;
      }
    }
    else if (((this.a.a instanceof ProfileTagView)) && (((ProfileTagView)this.a.a).f))
    {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.ProfileTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */