package com.tencent.mobileqq.apollo.view;

import aciy;
import ajjy;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import com.tencent.mobileqq.widget.MessageProgressView;

public class ApolloMessageProgressView
  extends MessageProgressView
{
  public ApolloMessageProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void h(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(aciy.a(15.0F, getResources()));
    localPaint.setColor(-1);
    localPaint.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(ajjy.a(2131634669), this.a, getHeight() - aciy.a(25.0F, getResources()), localPaint);
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.d == 1)
    {
      d();
      this.b -= aciy.a(7.0F, getResources());
      this.f = -822083584;
      b(paramCanvas);
      c(paramCanvas);
      a(paramCanvas);
      if (a() < 100) {
        h(paramCanvas);
      }
      d(paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloMessageProgressView
 * JD-Core Version:    0.7.0.1
 */