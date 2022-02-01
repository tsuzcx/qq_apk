package com.tencent.avgame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.List;

public class GuideView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1308622848;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private List<HoleBean> jdField_a_of_type_JavaUtilList;
  
  public GuideView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public GuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public GuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private RectF a(RectF paramRectF)
  {
    RectF localRectF = new RectF();
    paramRectF.left -= this.jdField_a_of_type_Float / 2.0F;
    paramRectF.top -= this.jdField_a_of_type_Float / 2.0F;
    paramRectF.right += this.jdField_a_of_type_Float / 2.0F;
    paramRectF.bottom += this.jdField_a_of_type_Float / 2.0F;
    return localRectF;
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(new BlurMaskFilter(10.0F, BlurMaskFilter.Blur.INNER));
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    setClickable(true);
    setWillNotDraw(false);
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HoleBean localHoleBean = (HoleBean)((Iterator)localObject).next();
        RectF localRectF = localHoleBean.a();
        localRectF.offset(-this.jdField_a_of_type_AndroidGraphicsRectF.left, -this.jdField_a_of_type_AndroidGraphicsRectF.top);
        int i = localHoleBean.b();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2) {
              this.jdField_a_of_type_AndroidGraphicsCanvas.drawOval(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
            }
          }
          else {
            this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
        else {
          this.jdField_a_of_type_AndroidGraphicsCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localHoleBean.a(), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top, null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float + 0.1F);
      paramCanvas.drawRect(a(this.jdField_a_of_type_AndroidGraphicsRectF), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setHoleList(List<HoleBean> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = this.jdField_a_of_type_JavaUtilList;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext())
      {
        HoleBean localHoleBean = (HoleBean)paramList.next();
        this.jdField_a_of_type_AndroidGraphicsRectF.union(localHoleBean.a());
      }
    }
    this.jdField_a_of_type_Float = Math.max(Math.max(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top), Math.max(a(getContext()) - this.jdField_a_of_type_AndroidGraphicsRectF.right, b(getContext()) - this.jdField_a_of_type_AndroidGraphicsRectF.bottom));
    if ((this.jdField_a_of_type_AndroidGraphicsRectF.width() > 0.0F) && (this.jdField_a_of_type_AndroidGraphicsRectF.height() > 0.0F)) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)this.jdField_a_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height(), Bitmap.Config.ARGB_8888);
    } else {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setX(this.jdField_a_of_type_AndroidGraphicsRectF.left);
    this.jdField_a_of_type_AndroidWidgetButton.setY(this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getContext().getString(2131690382));
    this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(new FrameLayout.LayoutParams((int)this.jdField_a_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_a_of_type_AndroidGraphicsRectF.height()));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(0);
    addView(this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  public void setHoleOnClick(View.OnClickListener paramOnClickListener)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.GuideView
 * JD-Core Version:    0.7.0.1
 */