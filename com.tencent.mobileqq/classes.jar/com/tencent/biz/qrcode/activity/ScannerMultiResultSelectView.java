package com.tencent.biz.qrcode.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apnc;
import bdla;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qbar.QBarResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import zmh;
import zmi;

public class ScannerMultiResultSelectView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ScannerResult jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ScannerMultiResultSelectView.3(this);
  private zmh jdField_a_of_type_Zmh;
  private zmi jdField_a_of_type_Zmi;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public ScannerMultiResultSelectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScannerMultiResultSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScannerMultiResultSelectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      localObject = new int[paramInt1 * paramInt2];
      if (apnc.a((int[])localObject, paramArrayOfByte, paramInt1, paramInt2) == 0)
      {
        paramArrayOfByte = Bitmap.createBitmap((int[])localObject, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject = paramArrayOfByte;
        if (paramArrayOfByte == null) {}
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          Object localObject = new Matrix();
          ((Matrix)localObject).postRotate(90.0F);
          localObject = Bitmap.createBitmap(paramArrayOfByte, 0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), (Matrix)localObject, true);
          if (localObject != paramArrayOfByte) {
            paramArrayOfByte.recycle();
          }
          if (QLog.isColorLevel()) {
            QLog.i("ScannerMultiResultSelectView", 2, "getBitmapFromYuv bitmap:" + localObject);
          }
          return localObject;
        }
        catch (Throwable localThrowable2)
        {
          byte[] arrayOfByte;
          continue;
        }
        localThrowable1 = localThrowable1;
        paramArrayOfByte = null;
        localThrowable1.printStackTrace();
        QLog.i("ScannerMultiResultSelectView", 2, "getBitmapFromYuv error ", localThrowable1);
        arrayOfByte = paramArrayOfByte;
        continue;
        paramArrayOfByte = null;
      }
    }
  }
  
  private Rect a(RectF paramRectF)
  {
    int j = this.jdField_b_of_type_Int;
    int i = this.c;
    int k = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    if ((paramRectF.isEmpty()) || (m <= 0) || (k <= 0)) {
      return new Rect(0, 0, j, i);
    }
    int n;
    if (k * 1.0F / m > j * 1.0F / i)
    {
      n = m * j / k;
      m = (int)(paramRectF.left * j);
      float f = paramRectF.right;
      j = (int)(j * f);
      i = i / 2 - n / 2;
      k = (int)(paramRectF.top * n) + i;
      f = paramRectF.bottom;
      i = (int)(n * f) + i;
    }
    for (;;)
    {
      return new Rect(m, k, j, i);
      n = k * i / m;
      k = (int)(paramRectF.top * i);
      i = (int)(paramRectF.bottom * i);
      j = j / 2 - n / 2;
      m = (int)(paramRectF.left * n) + j;
      j += (int)(paramRectF.right * n);
    }
  }
  
  private View a()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(getContext());
    localDiniFlyAnimationView.setImageAssetsFolder("qr_scan_multi_point/images");
    localDiniFlyAnimationView.setAnimation("qr_scan_multi_point/data.json");
    localDiniFlyAnimationView.setRepeatCount(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dip2px(54.0F), ViewUtils.dip2px(54.0F));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localDiniFlyAnimationView, localLayoutParams);
    localDiniFlyAnimationView.setOnClickListener(this);
    localDiniFlyAnimationView.setVisibility(8);
    return localDiniFlyAnimationView;
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131560469, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368501));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131364250));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378950));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((View)localObject).findViewById(2131373020));
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    setBackgroundColor(-16777216);
    paramRelativeLayout.addView(this, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = true;
    if (LiuHaiUtils.b()) {
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = ViewUtils.dip2px(60.0F);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(i);
      if ((localObject instanceof DiniFlyAnimationView))
      {
        localObject = (DiniFlyAnimationView)localObject;
        if ((!paramBoolean) || (((DiniFlyAnimationView)localObject).isAnimating())) {
          break label64;
        }
        ((DiniFlyAnimationView)localObject).playAnimation();
      }
      for (;;)
      {
        i += 1;
        break;
        label64:
        if ((!paramBoolean) && (((DiniFlyAnimationView)localObject).isAnimating())) {
          ((DiniFlyAnimationView)localObject).cancelAnimation();
        }
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    Iterator localIterator;
    Object localObject;
    if (((this.jdField_a_of_type_Int & 0x1) != 0) && (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.d()))
    {
      localIterator = this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.a.iterator();
      while (localIterator.hasNext())
      {
        localObject = (QBarResult)localIterator.next();
        a().setTag(localObject);
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if ((this.jdField_a_of_type_Int & 0x2) != 0)
      {
        j = i;
        if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.c())
        {
          localIterator = this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.b.iterator();
          while (localIterator.hasNext())
          {
            localObject = (QMiniResult)localIterator.next();
            a().setTag(localObject);
          }
          j = i | 0x2;
        }
      }
      if (j == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716486);
      }
      while ((this.jdField_b_of_type_Int > 0) && (this.c > 0))
      {
        this.jdField_a_of_type_JavaLangRunnable.run();
        return;
        if (j == 2) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716485);
        } else {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716484);
        }
      }
      break;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Zmh == null) {
      return;
    }
    ThreadManagerV2.excute(new ScannerMultiResultSelectView.1(this, this.jdField_a_of_type_Zmh), 16, null, true);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScannerMultiResultSelectView", 2, "updateAfterDecodeBitmap mShowing：" + this.jdField_b_of_type_Boolean + " mBitmap:" + this.jdField_a_of_type_AndroidGraphicsBitmap + " mScannerResult:" + this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult);
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new ScannerMultiResultSelectView.2(this));
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      a(false);
      setVisibility(8);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    } while (this.jdField_a_of_type_Zmi == null);
    this.jdField_a_of_type_Zmi.a();
  }
  
  public void a(RelativeLayout paramRelativeLayout, ScannerResult paramScannerResult, int paramInt1, zmh paramzmh, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScannerMultiResultSelectView", 2, "show requestType：" + paramInt1 + " scannerResult:" + paramScannerResult + " data:" + paramzmh);
    }
    this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult = paramScannerResult;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Zmh = paramzmh;
    if (!this.jdField_a_of_type_Boolean) {
      a(paramRelativeLayout);
    }
    b();
    setVisibility(0);
    this.jdField_b_of_type_Boolean = true;
    this.d = paramInt2;
    bdla.b(null, "dc00898", "", "", "0X800B5E1", "0X800B5E1", this.d, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Zmi == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (paramView.getId() == 2131364250)
        {
          a();
          this.jdField_a_of_type_Zmi.a();
          bdla.b(null, "dc00898", "", "", "0X800B5E3", "0X800B5E3", this.d, 0, "", "", "", "");
        }
        else
        {
          Object localObject = paramView.getTag();
          if ((localObject != null) && ((localObject instanceof QBarResult)))
          {
            this.jdField_a_of_type_Zmi.a((QBarResult)localObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_Zmh);
            a(false);
            bdla.b(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.d, 0, "", "", "", "");
          }
          else if ((localObject != null) && ((localObject instanceof QMiniResult)))
          {
            this.jdField_a_of_type_Zmi.a((QMiniResult)localObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_Zmh);
            a(false);
            bdla.b(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.d, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 != this.jdField_b_of_type_Int) || (paramInt2 != this.c)))
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.c = paramInt2;
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void setMultiSelectListener(zmi paramzmi)
  {
    this.jdField_a_of_type_Zmi = paramzmi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView
 * JD-Core Version:    0.7.0.1
 */