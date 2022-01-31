package com.tencent.mobileqq.armap.wealthgod;

import android.content.Context;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ARMapSplashInfoView
  extends FrameLayout
{
  private TextView a;
  private TextView b;
  
  public ARMapSplashInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ARMapSplashInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARMapSplashInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130970251, this, true);
    a();
  }
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131369782));
    this.b = ((TextView)findViewById(2131369783));
    this.a.setTextColor(-1);
    TextPaint localTextPaint = this.a.getPaint();
    localTextPaint.setStrokeWidth(AIOUtils.a(2.0F, getResources()));
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence.toString());
    this.b.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapSplashInfoView
 * JD-Core Version:    0.7.0.1
 */