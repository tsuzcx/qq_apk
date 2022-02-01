package com.tencent.aelight.camera.aeeditor.view.timebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.Scaler;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class ScaleTimeBar
  extends ScaleView
{
  private int b = 0;
  private int c = 0;
  private float d = 0.0F;
  private int e = 3;
  private int f;
  private Paint g = new Paint();
  private Paint h = new Paint();
  private Paint i = new Paint();
  private long j = 2147483647L;
  private String k = "";
  
  public ScaleTimeBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.f = getResources().getDimensionPixelSize(2063859752);
    this.e = getResources().getDimensionPixelSize(2063859733);
    this.g.setAntiAlias(true);
    this.g.setTextSize(this.f);
    this.g.setColor(getResources().getColor(2063794206));
    this.g.setStrokeWidth(1.0F);
    this.g.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.h.setAntiAlias(true);
    this.h.setTextSize(this.f);
    this.h.setColor(getResources().getColor(2063794207));
    this.h.setStrokeWidth(1.0F);
    this.h.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.i.setAntiAlias(true);
    this.i.setTextSize(this.f);
    this.i.setStrokeWidth(1.0F);
    this.i.setColor(getResources().getColor(2063794206));
  }
  
  private int getTimeBarStatX()
  {
    return getMeasuredWidth() / 2;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a == null) {
      return;
    }
    if (this.b == 0) {
      this.b = getTimeBarStatX();
    }
    if (this.c == 0) {
      this.c = (getHeight() / 2);
    }
    if (this.a.a() == null) {
      return;
    }
    Object localObject2 = null;
    int n = this.a.a().size();
    Object localObject1 = this.g.getFontMetrics();
    float f1 = this.c + (((Paint.FontMetrics)localObject1).bottom - ((Paint.FontMetrics)localObject1).top) / 2.0F - ((Paint.FontMetrics)localObject1).bottom;
    int m = 0;
    float f2;
    float f3;
    while (m < n)
    {
      Scaler localScaler = (Scaler)this.a.a().get(m);
      f2 = this.b + this.a.f() * localScaler.a();
      if (this.a.b(localScaler) == this.j)
      {
        localObject1 = localObject2;
        if (m < n - 1) {
          localObject1 = (Scaler)this.a.a().get(m + 1);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (this.a.b(localScaler) > this.j) {
          break;
        }
      }
      if (this.d == 0.0F) {
        this.d = this.g.measureText("a");
      }
      f3 = this.d * 5.0F;
      if ((f2 >= getScrollX() - f3) && (f2 <= getScrollX() + getWidth() + f3))
      {
        f3 = this.c;
        if (localScaler.b() == 1)
        {
          paramCanvas.drawCircle(f2, f3, this.e, this.g);
        }
        else if (localScaler.b() == 0)
        {
          localObject2 = this.a.a(localScaler);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            int i1 = ((String)localObject2).length();
            if ((this.a.b(localScaler) == this.j) && (m < n - 1)) {
              paramCanvas.drawText((String)localObject2, 0, i1, f2 - this.d * i1 / 2.0F, f1, this.h);
            } else {
              paramCanvas.drawText((String)localObject2, 0, i1, f2 - this.d * i1 / 2.0F, f1, this.g);
            }
          }
        }
      }
      m += 1;
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      f2 = this.b;
      f3 = this.a.f();
      float f4 = ((Scaler)localObject2).a();
      if (!TextUtils.isEmpty(this.k))
      {
        m = this.k.length();
        paramCanvas.drawText(this.k, 0, m, f2 + f3 * f4, f1, this.i);
      }
    }
  }
  
  public void setMaxDurationLimit(long paramLong)
  {
    if (paramLong > 0L) {
      this.j = paramLong;
    }
  }
  
  public void setMaxDurationLimitTip(String paramString)
  {
    this.k = paramString;
  }
  
  public void setTextSize(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar
 * JD-Core Version:    0.7.0.1
 */