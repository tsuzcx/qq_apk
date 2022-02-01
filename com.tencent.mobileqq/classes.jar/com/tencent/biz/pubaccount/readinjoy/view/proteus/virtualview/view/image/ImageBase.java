package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public abstract class ImageBase
  extends ViewBase
{
  public static SparseArray<ImageView.ScaleType> IMAGE_SCALE_TYPE = new SparseArray();
  private static final String TAG = "ImageBase_TMTEST";
  double[] mDynamicRate = new double[1];
  public int mScaleType = 2;
  private int mSizeChangeAccord = 0;
  public String mSrc;
  
  static
  {
    IMAGE_SCALE_TYPE.put(1, ImageView.ScaleType.FIT_XY);
    IMAGE_SCALE_TYPE.put(2, ImageView.ScaleType.CENTER_CROP);
  }
  
  public ImageBase(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  public String getSrc()
  {
    return this.mSrc;
  }
  
  public void loadImage(String paramString) {}
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if ((this.mDynamicRate[0] > 0.0D) && (this.mParams != null))
    {
      Layout.Params localParams;
      double d1;
      double d2;
      if ((this.mSizeChangeAccord == 1) && (this.mParams.mLayoutWidth > 0))
      {
        localParams = this.mParams;
        d1 = this.mParams.mLayoutWidth;
        d2 = this.mDynamicRate[0];
        Double.isNaN(d1);
        localParams.mLayoutHeight = ((int)(d1 / d2));
        return;
      }
      if ((this.mSizeChangeAccord == 2) && (this.mParams.mLayoutHeight > 0))
      {
        localParams = this.mParams;
        d1 = this.mParams.mLayoutHeight;
        d2 = this.mDynamicRate[0];
        Double.isNaN(d1);
        localParams.mLayoutWidth = ((int)(d1 * d2));
      }
    }
  }
  
  public void reset()
  {
    super.reset();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = super.setAttribute(paramInt, paramObject);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = true;
      if (paramInt != 23)
      {
        if (paramInt != 55) {
          return false;
        }
        this.mSizeChangeAccord = JsonUtils.getDynamicRateSize(this.mDynamicRate, paramObject);
        return true;
      }
      this.mSrc = JsonUtils.getStringValue(paramObject, 0);
    }
    return bool1;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = super.setAttribute(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = true;
      if (paramInt != 23)
      {
        if (paramInt != 24)
        {
          if (paramInt != 51) {
            return false;
          }
          paramString = Utils.toInteger(paramString);
          if (paramString != null)
          {
            this.mScaleType = paramString.intValue();
            return true;
          }
        }
        else
        {
          this.mSrc = paramString;
          return true;
        }
      }
      else {
        this.mSrc = paramString;
      }
    }
    return bool1;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    setBitmap(paramBitmap, true);
  }
  
  public abstract void setBitmap(Bitmap paramBitmap, boolean paramBoolean);
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase
 * JD-Core Version:    0.7.0.1
 */