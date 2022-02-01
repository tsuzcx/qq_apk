package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.BitSet;
import java.util.Calendar;

public class TimeLineView
  extends FrameLayout
{
  public int a;
  private Context b;
  private int c;
  private Calendar d;
  private Calendar e;
  private BitSet f;
  private AutoFitScrollView g;
  private int h;
  
  public TimeLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TimeLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TimeLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  void a(Context paramContext)
  {
    this.b = paramContext;
    this.c = paramContext.getResources().getDisplayMetrics().widthPixels;
    paramContext = Calendar.getInstance();
    this.e = paramContext;
    this.d = paramContext;
    this.f = new BitSet();
    this.h = getResources().getColor(2131168003);
  }
  
  public void a(AutoFitScrollView paramAutoFitScrollView)
  {
    this.g = paramAutoFitScrollView;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int k = AIOUtils.a(8.0F, this.b.getResources());
    int m = AIOUtils.a(2.0F, this.b.getResources());
    int n = AIOUtils.a(15.0F, this.b.getResources());
    int i1 = AIOUtils.a(7.5F, this.b.getResources());
    int i = (this.c >> 1) - (m >> 1);
    Paint localPaint1 = new Paint();
    Paint localPaint2 = new Paint();
    localPaint2.setTextSize(this.b.getResources().getDisplayMetrics().density * 12.0F);
    localPaint2.setColor(-8355712);
    localPaint2.setDither(true);
    Calendar localCalendar = (Calendar)this.d.clone();
    Object localObject = this.f;
    int j = 0;
    if (!((BitSet)localObject).get(0)) {
      return;
    }
    for (;;)
    {
      if ((!localCalendar.before(this.e)) && (!localCalendar.equals(this.e))) {
        return;
      }
      int i2 = localCalendar.get(2) + 1;
      int i3 = localCalendar.get(5);
      Rect localRect = new Rect();
      if ((1 != i3) && (i3 != 15))
      {
        localRect.left = i;
        localRect.top = (getHeight() - i1);
        localRect.right = (localRect.left + m);
        localRect.bottom = getHeight();
      }
      else
      {
        localRect.left = i;
        localRect.top = (getHeight() - n);
        localRect.right = (localRect.left + m);
        localRect.bottom = getHeight();
        if (i3 == 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131912265));
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(i3);
        }
        localObject = ((StringBuilder)localObject).toString();
        float f1 = localPaint2.measureText((String)localObject);
        i2 = AIOUtils.a(3.0F, this.b.getResources());
        paramCanvas.drawText((String)localObject, m / 2 + i - f1 / 2.0F, (getHeight() >> 1) - i2, localPaint2);
      }
      i += k + m;
      if (this.f.get(j)) {
        localPaint1.setColor(this.h);
      } else {
        localPaint1.setColor(-3355444);
      }
      paramCanvas.drawRect(localRect, localPaint1);
      localCalendar.add(5, 1);
      j += 1;
    }
  }
  
  public Calendar getBegintDate()
  {
    return (Calendar)this.d.clone();
  }
  
  public int getItemWidth()
  {
    return AIOUtils.a(10.0F, this.b.getResources());
  }
  
  public BitSet getRoamDateBitMap()
  {
    return this.f;
  }
  
  public void setDate(QQAppInterface paramQQAppInterface, Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean)
  {
    if ((paramCalendar1 != null) && (paramCalendar2 != null))
    {
      this.d = ((Calendar)paramCalendar1.clone());
      this.e = ((Calendar)paramCalendar2.clone());
      StringBuilder localStringBuilder = new StringBuilder("setDate date: ");
      if (QLog.isColorLevel())
      {
        int i = this.d.get(1);
        int j = this.d.get(2);
        int k = this.d.get(5);
        localStringBuilder.append(i);
        localStringBuilder.append("-");
        localStringBuilder.append(j + 1);
        localStringBuilder.append("-");
        localStringBuilder.append(k);
        localStringBuilder.append(" ~ ");
        i = this.e.get(1);
        j = this.e.get(2);
        k = this.e.get(5);
        localStringBuilder.append(i);
        localStringBuilder.append("-");
        localStringBuilder.append(j + 1);
        localStringBuilder.append("-");
        localStringBuilder.append(k);
        localStringBuilder.append(", isLoc: ");
        localStringBuilder.append(paramBoolean);
      }
      paramQQAppInterface = (MessageRoamManager)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (!paramBoolean) {
        this.f = paramQQAppInterface.c(this.d, this.e);
      } else {
        this.f = paramQQAppInterface.a(paramCalendar1, paramCalendar2);
      }
      long l = paramCalendar1.getTimeInMillis();
      this.a = ((int)((paramCalendar2.getTimeInMillis() - l) / 86400000L));
      this.g.setFitWidth(this.a * getItemWidth() + this.c, getItemWidth());
      this.g.b();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(", mDataSize: ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", max scrollView Width: ");
        localStringBuilder.append(this.g.a);
        localStringBuilder.append(", item width: ");
        localStringBuilder.append(getItemWidth());
        localStringBuilder.append(",displayWidth: ");
        localStringBuilder.append(this.c);
        QLog.d("TimeLineView", 2, localStringBuilder.toString());
      }
      requestLayout();
      invalidate();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TimeLineView", 2, "setDate date is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TimeLineView
 * JD-Core Version:    0.7.0.1
 */