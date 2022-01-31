package com.tencent.mobileqq.apollo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.MessageProgressView;

public class ApolloMessageProgressView
  extends MessageProgressView
{
  public ApolloMessageProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void e(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(AIOUtils.a(15.0F, getResources()));
    localPaint.setColor(-1);
    localPaint.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText("游戏加载中", this.a, getHeight() - AIOUtils.a(25.0F, getResources()), localPaint);
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.d == 1)
    {
      d();
      this.b -= AIOUtils.a(7.0F, getResources());
      this.f = -822083584;
      b(paramCanvas);
      c(paramCanvas);
      a(paramCanvas);
      if (a() < 100) {
        e(paramCanvas);
      }
      d(paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloMessageProgressView
 * JD-Core Version:    0.7.0.1
 */