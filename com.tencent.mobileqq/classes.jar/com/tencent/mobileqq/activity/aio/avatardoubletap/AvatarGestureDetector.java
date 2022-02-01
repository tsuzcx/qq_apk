package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class AvatarGestureDetector
  extends GestureDetector
{
  private VasAvatar a;
  
  public AvatarGestureDetector(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    super(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public VasAvatar a()
  {
    return this.a;
  }
  
  public void a(VasAvatar paramVasAvatar)
  {
    this.a = paramVasAvatar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.AvatarGestureDetector
 * JD-Core Version:    0.7.0.1
 */