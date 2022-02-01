package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.lang.ref.WeakReference;

class RichTextParser$DrawableCallBack
  implements DrawableUtil.DrawableCallBack
{
  private WeakReference<View> weakReference;
  
  RichTextParser$DrawableCallBack(View paramView)
  {
    this.weakReference = new WeakReference(paramView);
  }
  
  public void onCallBack(boolean paramBoolean, Drawable paramDrawable)
  {
    paramDrawable = (View)this.weakReference.get();
    LogUtil.QLog.e("RichTextParser", 1, "onCallBack: isSuccess" + paramBoolean);
    if (paramDrawable != null)
    {
      paramDrawable.invalidate();
      LogUtil.QLog.e("RichTextParser", 1, "onCallBack: richNativeText != null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser.DrawableCallBack
 * JD-Core Version:    0.7.0.1
 */