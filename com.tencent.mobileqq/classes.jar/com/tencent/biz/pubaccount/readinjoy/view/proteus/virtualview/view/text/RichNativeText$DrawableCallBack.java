package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.lang.ref.WeakReference;

class RichNativeText$DrawableCallBack
  implements DrawableUtil.DrawableCallBack
{
  private WeakReference<RichNativeText> weakReference;
  
  public RichNativeText$DrawableCallBack(RichNativeText paramRichNativeText)
  {
    this.weakReference = new WeakReference(paramRichNativeText);
  }
  
  public void onCallBack(boolean paramBoolean, Drawable paramDrawable)
  {
    paramDrawable = (RichNativeText)this.weakReference.get();
    LogUtil.QLog.e("RichNativeText", 1, "onCallBack: isSuccess" + paramBoolean);
    if (paramDrawable != null)
    {
      paramDrawable.mNative.invalidate();
      LogUtil.QLog.e("RichNativeText", 1, "onCallBack: richNativeText != null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText.DrawableCallBack
 * JD-Core Version:    0.7.0.1
 */