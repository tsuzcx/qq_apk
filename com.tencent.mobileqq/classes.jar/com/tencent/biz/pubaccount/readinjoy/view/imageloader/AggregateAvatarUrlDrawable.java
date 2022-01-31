package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.PuzzleAvatarUtil;
import com.tencent.qphone.base.util.QLog;

public class AggregateAvatarUrlDrawable
  extends Drawable
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack, URLDrawable.URLDrawableListener
{
  private static String jdField_a_of_type_JavaLangString = "AggregateAvatarUrlDrawable";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private Bitmap b;
  
  public AggregateAvatarUrlDrawable(Bitmap paramBitmap, String paramString, int paramInt, Resources paramResources)
  {
    a(paramBitmap, paramString, paramInt, paramResources);
  }
  
  private void a(Bitmap paramBitmap, String paramString, int paramInt, Resources paramResources)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = Math.round(paramInt * 0.48F);
    localURLDrawableOptions.mRequestHeight = Math.round(paramInt * 0.48F);
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.a);
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.b = PuzzleAvatarUtil.a(paramBitmap, BitmapFactory.decodeResource(paramResources, 2130842402), 0.0F, 1.0F);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.b.getWidth(), this.b.getHeight());
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, paramInt * 0.75F, paramInt * 0.75F);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setBounds(new Rect(Math.round(paramInt * 0.52F), Math.round(paramInt * 0.52F), paramInt, paramInt));
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((!TextUtils.equals(paramString, String.valueOf(this.jdField_a_of_type_Long))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    a(this.jdField_a_of_type_AndroidGraphicsBitmap, ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo), this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadUserInfoFailed");
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && (localDrawable != null))
    {
      paramCanvas.drawBitmap(this.b, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_ComTencentImageURLDrawable.draw(paramCanvas);
      return;
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return this.jdField_a_of_type_ComTencentImageURLDrawable.getOpacity();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadSuccessed");
    invalidateSelf();
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.AggregateAvatarUrlDrawable
 * JD-Core Version:    0.7.0.1
 */