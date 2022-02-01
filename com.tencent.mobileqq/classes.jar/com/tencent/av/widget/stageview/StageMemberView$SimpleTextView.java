package com.tencent.av.widget.stageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.view.View;

class StageMemberView$SimpleTextView
  extends View
{
  public StageMemberView$SimpleTextView(StageMemberView paramStageMemberView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f;
    if (StageMemberView.a(this.a) != null)
    {
      f = -StageMemberView.a(this.a).getFontMetrics().ascent;
      if (this.a.a == null) {
        break label76;
      }
      StageMemberView.a(this.a).setColor(this.a.a.a);
    }
    for (;;)
    {
      paramCanvas.drawText(StageMemberView.a(this.a), 0.0F, f, StageMemberView.a(this.a));
      return;
      label76:
      StageMemberView.a(this.a).setColor(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageMemberView.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */