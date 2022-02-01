package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyIconText
  extends NativeText
{
  protected String a;
  
  public ReadInJoyIconText(VafContext paramVafContext)
  {
    super(paramVafContext);
    QLog.d("ReadInJoyIconText", 2, "ReadInJoyIconText create");
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key ->");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" , value = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ReadInJoyIconText", 2, ((StringBuilder)localObject).toString());
    if (paramInt == 1086)
    {
      if (paramString != null)
      {
        this.a = paramString;
        setDrawableLeft(null);
      }
      return true;
    }
    if (paramInt == 1087)
    {
      if (paramString != null)
      {
        int i = Utils.dp2px(ParseUtil.a(paramString, 0));
        this.mNative.setCompoundDrawablePadding(i);
      }
    }
    else if (paramInt == 48)
    {
      localObject = Utils.toFloat(paramString);
      if (localObject != null)
      {
        this.mAlpha = ((Float)localObject).floatValue();
        getNativeView().setAlpha(this.mAlpha);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setAttribute: fail to parse - ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ReadInJoyIconText", 2, ((StringBuilder)localObject).toString());
      }
    }
    return super.setAttribute(paramInt, paramString);
  }
  
  protected void setDrawableLeft(String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("setDrawableLeft drawableLeftPath->");
    paramString.append(this.drawableLeftPath);
    paramString.append(" , drawableRightPath = ");
    paramString.append(this.a);
    QLog.d("ReadInJoyIconText", 2, paramString.toString());
    if (this.drawableLeftPath != null) {
      paramString = DrawableUtil.getDrawable(this.mNative.getContext(), this.drawableLeftPath, null, null);
    } else {
      paramString = null;
    }
    Drawable localDrawable;
    if (this.a != null) {
      localDrawable = DrawableUtil.getDrawable(this.mNative.getContext(), this.a, null, null);
    } else {
      localDrawable = null;
    }
    this.mNative.setCompoundDrawablesWithIntrinsicBounds(paramString, null, localDrawable, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyIconText
 * JD-Core Version:    0.7.0.1
 */