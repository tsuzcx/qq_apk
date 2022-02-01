package com.tencent.biz.pubaccount.imagecollection;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.ZBitmapDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class PublicAccountImageCollectionActivity
  extends BaseActivity
{
  int jdField_a_of_type_Int = 0;
  protected Handler a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  PublicAccountImageView jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView;
  
  public PublicAccountImageCollectionActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new PublicAccountImageCollectionActivity.1(this);
  }
  
  private Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    try
    {
      paramString = new URL(paramString);
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    Object localObject2 = new ImageRequest();
    ((ImageRequest)localObject2).jdField_a_of_type_JavaNetURL = paramString;
    ((ImageRequest)localObject2).jdField_a_of_type_Int = paramInt1;
    ((ImageRequest)localObject2).b = paramInt2;
    localObject2 = ((IImageManager)QRoute.api(IImageManager.class)).getBitmap((ImageRequest)localObject2);
    paramString = localObject1;
    if (localObject2 != null) {
      paramString = new ZBitmapDrawable(((ICloseableBitmap)localObject2).a());
    }
    return paramString;
  }
  
  private void a()
  {
    finish();
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionActivity", 2, "activity finish");
    }
    com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.doubleTapFlag = false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    super.setContentView(2131559605);
    int i = getWindowManager().getDefaultDisplay().getHeight();
    int j = getWindowManager().getDefaultDisplay().getWidth();
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getStringExtra("doubleBitMapPath");
    float[] arrayOfFloat = ((Intent)localObject).getFloatArrayExtra("imageMatrix");
    int k = ((Intent)localObject).getIntExtra("urlImageWidth", 0);
    int m = ((Intent)localObject).getIntExtra("urlImageHeight", 0);
    int n = ((Intent)localObject).getIntExtra("urlImageWidthReal", 0);
    int i1 = ((Intent)localObject).getIntExtra("urlImageHeightReal", 0);
    localObject = new Matrix();
    if (arrayOfFloat != null) {
      ((Matrix)localObject).setValues(arrayOfFloat);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView = new PublicAccountImageView(this, this.jdField_a_of_type_AndroidOsHandler, (Matrix)localObject, this.jdField_a_of_type_Int, n, i1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373230));
    paramBundle = a(paramBundle, k, m);
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setImageDrawable(paramBundle);
    ((Matrix)localObject).postScale(3.0F, 3.0F, n / 2, i1 / 2);
    ((Matrix)localObject).postTranslate((j - n) / 2, (i - i1) / 2);
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView.setImageMatrix((Matrix)localObject);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(10, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageView, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.doubleTapFlag = false;
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionActivity
 * JD-Core Version:    0.7.0.1
 */