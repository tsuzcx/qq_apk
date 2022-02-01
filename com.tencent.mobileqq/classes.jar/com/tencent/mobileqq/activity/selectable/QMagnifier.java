package com.tencent.mobileqq.activity.selectable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

public class QMagnifier
  implements SelectableMagnifier
{
  private static final int jdField_a_of_type_Int = ScreenUtil.dip2px(172.0F);
  private static final int b = ScreenUtil.dip2px(31.5F);
  private static final int c = jdField_a_of_type_Int + ScreenUtil.dip2px(16.0F);
  private static final int d = b + ScreenUtil.dip2px(14.0F);
  private static final int e = c / 2;
  private static final int f = ScreenUtil.dip2px(65.0F);
  private static final int g = ScreenUtil.dip2px(10.0F);
  private static final int h = ViewUtils.b(30.0F);
  private static final int i = ViewUtils.b(8.0F);
  private static final int j = ViewUtils.b(12.0F);
  private static final int k = ScreenUtil.dip2px(4.0F);
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private boolean jdField_a_of_type_Boolean;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  
  private int a(int paramInt)
  {
    int i3 = this.l;
    int i2 = 0;
    int i1 = i2;
    if (i3 != -1)
    {
      int i4 = this.m;
      i1 = i2;
      if (i4 != -1)
      {
        i1 = j;
        if ((paramInt > i4 + i1) && (i3 > i4 + i1)) {
          return 2;
        }
        i3 = j;
        i4 = this.m;
        i1 = i2;
        if (paramInt + i3 < i4)
        {
          i1 = i2;
          if (this.l + i3 < i4) {
            i1 = 1;
          }
        }
      }
    }
    return i1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    this.m = this.l;
    this.l = paramInt1;
    if (paramInt2 == 0)
    {
      int i1 = this.n;
      if (i1 != -1)
      {
        if (i1 > paramInt1)
        {
          if (i1 - paramInt1 < i)
          {
            paramInt1 = i1;
            break label94;
          }
          this.n = paramInt1;
          break label94;
        }
        if (i1 >= paramInt1) {
          break label94;
        }
        if (paramInt1 - i1 < i)
        {
          paramInt1 = i1;
          break label94;
        }
        this.n = paramInt1;
        break label94;
      }
    }
    this.n = paramInt1;
    label94:
    if (paramInt2 == 0) {
      return paramInt1 - h;
    }
    float f2;
    float f3;
    float f1;
    if (paramInt2 == 1)
    {
      f2 = paramInt1;
      f3 = h;
      f1 = 1.5F;
    }
    else
    {
      f2 = paramInt1;
      f3 = h;
      f1 = 0.5F;
    }
    return (int)(f2 - f3 * f1);
  }
  
  public static RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    RectF localRectF = a(paramView);
    a("start update ");
    a(paramInt1 - localRectF.left, paramInt2 - localRectF.top, 1.5F);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(-1);
    this.jdField_a_of_type_AndroidGraphicsCanvas.scale(1.5F, 1.5F);
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-this.jdField_a_of_type_AndroidGraphicsRect.left, -this.jdField_a_of_type_AndroidGraphicsRect.top);
    paramView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
    a("get Drawing cache ");
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d("QMagnifier", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    this.jdField_a_of_type_Boolean = false;
    this.l = -1;
    this.m = -1;
    this.n = -1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat2 -= g;
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    int i1 = jdField_a_of_type_Int;
    int i2 = (int)(paramFloat1 - i1 / 2 / paramFloat3);
    int i3 = b;
    localRect.set(i2, (int)(paramFloat2 - i3 / 2 / paramFloat3), (int)(paramFloat1 + i1 / 2 / paramFloat3), (int)(paramFloat2 + i3 / 2 / paramFloat3));
  }
  
  public void a(@NonNull View paramView1, int paramInt1, int paramInt2, @NonNull View paramView2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
      a("create popWindow ");
      paramView2 = ((LayoutInflater)paramView1.getContext().getSystemService("layout_inflater")).inflate(2131559284, null, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView2.findViewById(2131362424));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(k, false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramView2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(c);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(d);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(jdField_a_of_type_Int, b, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
      a("create magnifier bitmap and canvas");
    }
    if ((paramBoolean) || (!this.jdField_a_of_type_Boolean)) {
      a(paramView1, paramInt1, paramInt2);
    }
    paramInt2 = a(paramInt2, a(paramInt2));
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update(paramInt1 - e, paramInt2 - f, c, d);
    } else {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView1, 0, paramInt1 - e, paramInt2 - f);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.QMagnifier
 * JD-Core Version:    0.7.0.1
 */