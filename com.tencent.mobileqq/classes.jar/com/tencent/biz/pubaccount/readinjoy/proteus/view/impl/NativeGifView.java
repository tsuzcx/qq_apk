package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;

public class NativeGifView
  extends GifView
  implements IView
{
  public NativeGifView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.mCoverUrl))
    {
      setCoverUrl(this.mCoverUrl);
      displayCover();
    }
    displayGif();
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGifView
 * JD-Core Version:    0.7.0.1
 */