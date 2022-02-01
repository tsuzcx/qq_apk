package com.tencent.biz.qcircleshadow.local.fragment.flashshow;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

class FSPluginLoadingDialog$1
  implements AnimationDrawableFactory.CreateResultListener
{
  FSPluginLoadingDialog$1(FSPluginLoadingDialog paramFSPluginLoadingDialog) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      FSPluginLoadingDialog.a(this.a, paramQQAnimationDrawable);
      FSPluginLoadingDialog.b(this.a).post(new FSPluginLoadingDialog.1.1(this));
      return;
    }
    FSPluginLoadingDialog.b(this.a).post(new FSPluginLoadingDialog.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.flashshow.FSPluginLoadingDialog.1
 * JD-Core Version:    0.7.0.1
 */