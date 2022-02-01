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
import android.graphics.Rect;
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
  private int a = -1308622848;
  private float b;
  private Paint c;
  private Bitmap d;
  private RectF e;
  private Canvas f;
  private List<HoleBean> g;
  private PorterDuffXfermode h;
  private Button i;
  
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
    paramRectF.left -= this.b / 2.0F;
    paramRectF.top -= this.b / 2.0F;
    paramRectF.right += this.b / 2.0F;
    paramRectF.bottom += this.b / 2.0F;
    return localRectF;
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  private void b()
  {
    this.h = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setColor(this.a);
    this.c.setMaskFilter(new BlurMaskFilter(10.0F, BlurMaskFilter.Blur.INNER));
    this.e = new RectF();
    setClickable(true);
    setWillNotDraw(false);
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public Rect getFirstHoleRect()
  {
    RectF localRectF;
    if (this.g.size() > 0) {
      localRectF = ((HoleBean)this.g.get(0)).b();
    } else {
      localRectF = new RectF();
    }
    Rect localRect = new Rect();
    localRectF.round(localRect);
    return localRect;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.g;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.c.setXfermode(this.h);
      this.c.setStyle(Paint.Style.FILL);
      localObject = this.g.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HoleBean localHoleBean = (HoleBean)((Iterator)localObject).next();
        RectF localRectF = localHoleBean.b();
        localRectF.offset(-this.e.left, -this.e.top);
        int j = localHoleBean.c();
        if (j != 0)
        {
          if (j != 1)
          {
            if (j == 2) {
              this.f.drawOval(localRectF, this.c);
            }
          }
          else {
            this.f.drawRect(localRectF, this.c);
          }
        }
        else {
          this.f.drawCircle(localRectF.centerX(), localRectF.centerY(), localHoleBean.a(), this.c);
        }
      }
      paramCanvas.drawBitmap(this.d, this.e.left, this.e.top, null);
      this.c.setXfermode(null);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setStrokeWidth(this.b + 0.1F);
      paramCanvas.drawRect(a(this.e), this.c);
    }
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setHoleList(List<HoleBean> paramList)
  {
    this.g = paramList;
    paramList = this.g;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = this.g.iterator();
      while (paramList.hasNext())
      {
        HoleBean localHoleBean = (HoleBean)paramList.next();
        this.e.union(localHoleBean.b());
      }
    }
    this.b = Math.max(Math.max(this.e.left, this.e.top), Math.max(a(getContext()) - this.e.right, b(getContext()) - this.e.bottom));
    if ((this.e.width() > 0.0F) && (this.e.height() > 0.0F)) {
      this.d = Bitmap.createBitmap((int)this.e.width(), (int)this.e.height(), Bitmap.Config.ARGB_8888);
    } else {
      this.d = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }
    this.f = new Canvas(this.d);
    this.f.drawColor(this.a);
    this.i = new Button(getContext());
    this.i.setX(this.e.left);
    this.i.setY(this.e.top);
    this.i.setContentDescription(getContext().getString(2131887293));
    this.i.setLayoutParams(new FrameLayout.LayoutParams((int)this.e.width(), (int)this.e.height()));
    this.i.setBackgroundColor(0);
    addView(this.i);
  }
  
  public void setHoleOnClick(View.OnClickListener paramOnClickListener)
  {
    Button localButton = this.i;
    if (localButton != null) {
      localButton.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.GuideView
 * JD-Core Version:    0.7.0.1
 */