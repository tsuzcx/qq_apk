package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class NativeImage
  extends ImageBase
{
  private Drawable a;
  protected NativeImageImp a;
  private Drawable b = new ColorDrawable(0);
  
  public NativeImage(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp = new NativeImageImp(paramVafContext.a());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.setPadding(this.o, this.q, this.p, this.r);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.setScaleType((ImageView.ScaleType)ImageBase.a.get(this.z));
    a(this.e);
    f();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.b(paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    QLog.d("NativeImage_TMTEST", 2, "loadImage: path is " + paramString);
    if (paramString != null)
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label68;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.setImageSrc(paramString);
    }
    label68:
    Object localObject;
    do
    {
      return;
      localObject = ImageCommon.a(paramString);
      paramString = OfflineUtils.a(paramString);
      if (paramString != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.b;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.b;
        paramString = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.setImageDrawable(paramString);
        return;
      }
    } while (localObject == null);
    QLog.d("NativeImage_TMTEST", 2, "loadImage: cant find in offline dir, try to load from resources");
    try
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.getResources();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.setImageDrawable(paramString.getDrawable(((Integer)localObject).intValue()));
      return;
    }
    catch (Resources.NotFoundException paramString)
    {
      QLog.d("NativeImage_TMTEST", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewImageNativeImageImp.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.NativeImage
 * JD-Core Version:    0.7.0.1
 */