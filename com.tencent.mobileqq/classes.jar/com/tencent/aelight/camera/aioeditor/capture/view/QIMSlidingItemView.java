package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class QIMSlidingItemView
  extends LinearLayout
{
  ImageView a;
  TextView b;
  QIMSlidingItemView.SlidingItemData c;
  
  public QIMSlidingItemView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIMSlidingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QIMSlidingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(16);
    this.a = new ImageView(getContext());
    this.b = new TextView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.b(13.0F, getResources()), AIOUtils.b(12.0F, getResources()));
    localLayoutParams.gravity = 17;
    addView(this.a, localLayoutParams);
    this.a.setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = AIOUtils.b(4.0F, getResources());
    addView(this.b, localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.setGravity(17);
    this.b.setSingleLine();
    this.b.setTextSize(0, paramInt1);
    setPadding(paramInt2, 0, paramInt2, 0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.b.setTextColor(paramInt);
    if (this.a.getVisibility() == 0)
    {
      ImageView localImageView = this.a;
      if (paramBoolean) {
        paramInt = this.c.c;
      } else {
        paramInt = this.c.b;
      }
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void setData(QIMSlidingItemView.SlidingItemData paramSlidingItemData)
  {
    this.c = paramSlidingItemData;
    this.b.setText(this.c.a);
    if (this.c.b != 0)
    {
      this.a.setImageResource(this.c.b);
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingItemView
 * JD-Core Version:    0.7.0.1
 */