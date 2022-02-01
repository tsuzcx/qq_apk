package com.tencent.biz.qqcircle.publish.view.edittext;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class TextColorAnimation
  extends Animation
{
  private ArrayList<Integer> a;
  private int b;
  private TextColorAnimation.OnUpdateColorListener c;
  
  public TextColorAnimation(ArrayList<Integer> paramArrayList)
  {
    a(paramArrayList);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.a;
    if (paramTransformation != null)
    {
      if (paramTransformation.size() < 2) {
        return;
      }
      float f = 1.0F / (this.a.size() - 1);
      int j = (int)(paramFloat / f);
      f = (paramFloat - j * f) / f;
      int i = j;
      if (j == this.a.size() - 1) {
        i = this.a.size() - 2;
      }
      int k = ((Integer)this.a.get(i)).intValue();
      j = ((Integer)this.a.get(i + 1)).intValue();
      i = j;
      if (paramFloat < 1.0F) {
        i = Color.argb((int)(Color.alpha(k) + (Color.alpha(j) - Color.alpha(k)) * f), (int)(Color.red(k) + (Color.red(j) - Color.red(k)) * f), (int)(Color.green(k) + (Color.green(j) - Color.green(k)) * f), (int)(Color.blue(k) + f * (Color.blue(j) - Color.blue(k))));
      }
      this.b = i;
      paramTransformation = this.c;
      if (paramTransformation != null) {
        paramTransformation.a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.edittext.TextColorAnimation
 * JD-Core Version:    0.7.0.1
 */