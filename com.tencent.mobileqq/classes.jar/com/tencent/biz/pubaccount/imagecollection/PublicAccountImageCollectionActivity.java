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
  PublicAccountImageView a;
  RelativeLayout b;
  int c = 0;
  protected Handler d = new PublicAccountImageCollectionActivity.1(this);
  
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
    ((ImageRequest)localObject2).a = paramString;
    ((ImageRequest)localObject2).b = paramInt1;
    ((ImageRequest)localObject2).c = paramInt2;
    localObject2 = ((IImageManager)QRoute.api(IImageManager.class)).getBitmap((ImageRequest)localObject2);
    paramString = localObject1;
    if (localObject2 != null) {
      paramString = new ZBitmapDrawable(((ICloseableBitmap)localObject2).b());
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
    super.setContentView(2131625634);
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
    this.a = new PublicAccountImageView(this, this.d, (Matrix)localObject, this.c, n, i1);
    this.b = ((RelativeLayout)findViewById(2131440839));
    paramBundle = a(paramBundle, k, m);
    this.a.setImageDrawable(paramBundle);
    ((Matrix)localObject).postScale(3.0F, 3.0F, n / 2, i1 / 2);
    ((Matrix)localObject).postTranslate((j - n) / 2, (i - i1) / 2);
    this.a.setImageMatrix((Matrix)localObject);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(10, -1);
    this.b.addView(this.a, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.doubleTapFlag = false;
    Handler localHandler = this.d;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.d = null;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionActivity
 * JD-Core Version:    0.7.0.1
 */