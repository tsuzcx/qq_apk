package com.tencent.av.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.widget.api.IChildLockSignApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ChildLockSign
  extends View
  implements Handler.Callback, View.OnClickListener
{
  private Bitmap a;
  private Bitmap b;
  private Bitmap c;
  private final RectF d = new RectF();
  private int e;
  private final Paint f = new Paint();
  private Handler g;
  private boolean h = true;
  private ChildLockSign.ChangeSignThread i = null;
  
  public ChildLockSign(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
    setOnClickListener(this);
  }
  
  public ChildLockSign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public ChildLockSign(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
    new ChildLockSign(paramContext);
  }
  
  private void a()
  {
    this.i = new ChildLockSign.ChangeSignThread(this);
    this.i.start();
  }
  
  private void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.g.sendMessage(localMessage);
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131441039);
    paramAttributeSet = getResources();
    this.h = true;
    try
    {
      this.a = BitmapFactory.decodeResource(paramAttributeSet, 2130843079);
      this.b = BitmapFactory.decodeResource(paramAttributeSet, 2130843080);
      if (this.h) {
        this.c = this.a;
      } else {
        this.c = this.b;
      }
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      paramAttributeSet.printStackTrace();
    }
    this.f.setFlags(1);
    this.f.setColor(-1);
    this.g = new Handler(Looper.getMainLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      setVisibility(8);
      ((IChildLockSignApi)QRoute.api(IChildLockSignApi.class)).handleSuccessMsg(getContext());
      setEnabled(true);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.h)
    {
      setEnabled(false);
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.f.setStrokeWidth(8.0F);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setAlpha(255);
    Bitmap localBitmap = this.c;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.c, null, this.d, this.f);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = Math.min(paramInt1, paramInt2);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChildLock : w = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("  h = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" min = ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.e / 6);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.e / 6);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.e * 5 / 6);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.e * 5 / 6);
      QLog.d("ChildLockSign", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.d;
    paramInt1 = this.e;
    ((RectF)localObject).set(paramInt1 / 6, paramInt1 / 6, paramInt1 * 5 / 6, paramInt1 * 5 / 6);
  }
  
  public void setLocked(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.h)
    {
      this.c = this.a;
      return;
    }
    this.c = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockSign
 * JD-Core Version:    0.7.0.1
 */