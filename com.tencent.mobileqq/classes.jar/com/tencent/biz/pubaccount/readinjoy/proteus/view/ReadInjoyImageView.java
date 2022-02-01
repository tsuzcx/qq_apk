package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSmartCropUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoyImageView
  extends ImageBase
{
  private Drawable a;
  protected NativeReadInjoyImageView a;
  
  public ReadInjoyImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = new NativeReadInjoyImageView(paramVafContext.getContext());
  }
  
  private boolean a()
  {
    if (this.mSrc == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getComMeasuredWidth();
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getComMeasuredHeight();
    } while ((i <= 0) || (j <= 0));
    this.mSrc = RIJSmartCropUtils.a(this.mSrc, i, j);
    return true;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  }
  
  public void loadImage(String paramString)
  {
    QLog.d("ReadInjoyImageView", 2, "loadImage: path is " + paramString);
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label84;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImagePlaceHolder(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (a()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(paramString);
      }
    }
    return;
    label84:
    paramString = ImageCommon.getDrawableResourceId(paramString);
    if (paramString != null)
    {
      QLog.d("ReadInjoyImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
      try
      {
        paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(paramString);
        return;
      }
      catch (Resources.NotFoundException paramString)
      {
        QLog.d("ReadInjoyImageView", 2, "loadImage: cant find in resources dir, do nothing");
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc("");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImagePlaceHolder(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void onComDraw(Canvas paramCanvas)
  {
    if ((this.mSrc != null) && (!this.mSrc.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.a())))
    {
      a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(this.mSrc);
    }
    super.onComDraw(paramCanvas);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    loadImage(this.mSrc);
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.mSrc = null;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyImageView
 * JD-Core Version:    0.7.0.1
 */